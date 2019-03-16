package gr.aueb.mscis.vacpro.resource;

import gr.aueb.mscis.vacpro.model.Parent;
import gr.aueb.mscis.vacpro.persistence.JPAUtil;
import gr.aueb.mscis.vacpro.service.ParentService;

import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * The type User resource.
 */
@Path("users")
public class UserResource {

	/**
	 * The Uri info.
	 */
	@Context
	UriInfo uriInfo;

	/**
	 * List all parents list.
	 *
	 * @return the list
	 */
	@GET
	@Path("parents")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ParentInfo> listAllParents() {
		ParentService parentService = new ParentService();
		List<Parent> results = parentService.findAll();
		List<ParentInfo> parents = new ArrayList<>();
		for (Parent parent : results) {
			parents.add(ResourceConverters.convertParentChildToDTO(parent));
		}
		return parents;
	}

	/**
	 * Sign in list.
	 *
	 * @param userType the user type
	 * @param username the username
	 * @param password the password
	 * @return the list
	 */
	@GET
	@Path("/{type}/{username}/{password}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ParentInfo> signIn(@PathParam("type") String userType, @PathParam("username") String username, @PathParam("password") String password) {
		List<ParentInfo> users = new ArrayList<>();
		ParentInfo parentInfo = null;
		if (userType.equalsIgnoreCase("PARENT")) {
			ParentService parentService = new ParentService();
			Parent user = parentService.findParentByUsername(username);
			if (user != null) {
				if (user.getPassword().equals(password)) {
					System.out.println("Parent successfully signed in.");
					parentInfo = ResourceConverters.convertParentChildToDTO(user);
					users.add(parentInfo);
				}
			}
		}

		return users;
	}

	/**
	 * Create parent response.
	 *
	 * @param parent the parent
	 * @return the response
	 */
	@POST
	@Path("parent/create")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createParent(final ParentInfo parent) {
		System.out.println("Sign-Up called");
		ParentService parentService = new ParentService();
		List<Parent> existingParent = parentService.findParentByVatNumber(parent.getVatNumber());
		if (existingParent != null && !existingParent.isEmpty()) {
			return Response.status(Response.Status.CONFLICT).build();
		}
		Parent newParent = ResourceConverters.convertParentChildFromDTO(parent);
		System.out.println(parent);
		newParent = parentService.createParent(newParent);
		System.out.println("Sign-Up Completed. New parent id: " + newParent.getId());
		UriBuilder ub = uriInfo.getAbsolutePathBuilder();
		URI newParentUri = ub.path(Integer.toString(newParent.getId())).build();
		return Response.created(newParentUri).build();
	}

	@PUT
	@Path("/parent/update/{parentId:[0-9]*}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateParent(@PathParam("parentId") final int parentId, final ParentInfo requestParent) {
		EntityManager em = JPAUtil.getCurrentEntityManager();
		Parent existingParent = em.find(Parent.class, parentId);
		if (existingParent == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}

		Parent parentInfo = ResourceConverters.convertParentChildFromDTO(requestParent);
		ParentService parentService = new ParentService();
		parentService.updateParent(parentInfo.getFirstName(), parentInfo.getLastName(), parentInfo.getUserName(),
				parentInfo.getPassword(), parentInfo.getPhoneNumber(), parentInfo.getEmail(), parentInfo.getVatNumber(),
				parentInfo.getInsuranceNumber(), parentInfo.getChildren(), existingParent);
		return Response.ok().build();
	}
}
