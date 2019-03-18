package gr.aueb.mscis.vacpro.resource;

import gr.aueb.mscis.vacpro.model.MunicipalityWorker;
import gr.aueb.mscis.vacpro.model.Parent;
import gr.aueb.mscis.vacpro.persistence.JPAUtil;
import gr.aueb.mscis.vacpro.service.MunicipalityWorkerService;
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
	 * Parent Sign in list.
	 *
	 * @param username the username
	 * @param password the password
	 * @return the list
	 */
	@GET
	@Path("/parent/{username}/{password}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ParentInfo> parentSignIn(@PathParam("username") String username, @PathParam("password") String password) {
		List<ParentInfo> users = new ArrayList<>();
		ParentInfo parentInfo = null;
		ParentService parentService = new ParentService();
		Parent user = parentService.findParentByUsername(username);
		if (user != null) {
			if (user.getPassword().equals(password)) {
				parentInfo = ResourceConverters.convertParentChildToDTO(user);
				users.add(parentInfo);
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

	/**
	 * Update parent response.
	 *
	 * @param parentId      the parent id
	 * @param requestParent the request parent
	 * @return the response
	 */
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

	/**
	 * List all workers list.
	 *
	 * @return the list
	 */
	@GET
	@Path("municipality")
	@Produces(MediaType.APPLICATION_JSON)
	public List<MunicipalityWorkerInfo> listAllWorkers() {
		MunicipalityWorkerService service = new MunicipalityWorkerService();
		List<MunicipalityWorker> results = service.findAll();
		List<MunicipalityWorkerInfo> municipalityWorkerInfos = new ArrayList<>();
		for (MunicipalityWorker mw : results) {
			municipalityWorkerInfos.add(ResourceConverters.convertToMunWorkerDTO(mw));
		}
		return municipalityWorkerInfos;
	}


	/**
	 * Workers Sign in list.
	 *
	 * @param username the username
	 * @param password the password
	 * @return the list
	 */
	@GET
	@Path("/municipality/{username}/{password}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<MunicipalityWorkerInfo> workerSignIn(@PathParam("username") String username, @PathParam("password") String password) {
		List<MunicipalityWorkerInfo> users = new ArrayList<>();
		MunicipalityWorkerInfo worker = null;
		MunicipalityWorkerService service = new MunicipalityWorkerService();
		List<MunicipalityWorker> userWorkers = service.findByUserName(username);
		if (userWorkers != null && !userWorkers.isEmpty()) {
			if (userWorkers.get(0).getPassword().equals(password)) {
				worker = ResourceConverters.convertToMunWorkerDTO(userWorkers.get(0));
				users.add(worker);
			}
		}
		return users;
	}

	/**
	 * Create parent response.
	 *
	 * @param worker the worker
	 * @return the response
	 */
	@POST
	@Path("municipality/create")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createWorker(final MunicipalityWorkerInfo worker) {

		MunicipalityWorkerService service = new MunicipalityWorkerService();
		List<MunicipalityWorker> workers = service.findByUserName(worker.getUserName());
		if (workers != null && !workers.isEmpty()) {
			return Response.status(Response.Status.CONFLICT).build();
		}
		MunicipalityWorker newWorker = ResourceConverters.convertFromMunWorkerToDTO(worker);
		System.out.println(newWorker);
		newWorker = service.createMunicipalityWorker(newWorker.getFirstName(), newWorker.getLastName(), newWorker.getUserName()
				, newWorker.getPassword(), newWorker.getPhoneNumber(), newWorker.getEmail(), newWorker.getVatNumber()
				, newWorker.getRegistryOffice(), newWorker.getAddress());

		UriBuilder ub = uriInfo.getAbsolutePathBuilder();
		URI newWorkerUri = ub.path(Integer.toString(newWorker.getId())).build();
		return Response.created(newWorkerUri).build();
	}

	/**
	 * Update worker response.
	 *
	 * @param municipalityId the municipality id
	 * @param request        the request
	 * @return the response
	 */
	@PUT
	@Path("/municipality/update/{municipalityId:[0-9]*}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateWorker(@PathParam("municipalityId") final int municipalityId, final MunicipalityWorkerInfo request) {
		EntityManager em = JPAUtil.getCurrentEntityManager();
		MunicipalityWorker existingWorker = em.find(MunicipalityWorker.class, municipalityId);
		if (existingWorker == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}

		MunicipalityWorker worker = ResourceConverters.convertFromMunWorkerToDTO(request);
		MunicipalityWorkerService workerService = new MunicipalityWorkerService();
		workerService.updateMunicipalityWorker(worker.getFirstName(), worker.getLastName(), worker.getUserName(),
				worker.getPassword(), worker.getPhoneNumber(), worker.getEmail(), worker.getVatNumber(),
				worker.getRegistryOffice(), existingWorker);
		return Response.ok().build();
	}


}
