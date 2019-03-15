package gr.aueb.mscis.vacpro.resource;

import gr.aueb.mscis.vacpro.model.Parent;
import gr.aueb.mscis.vacpro.service.ParentService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("users")
public class UserResource {

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
        return  parents;
    }

    @GET
    @Path("/{type}/{username}/{password}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ParentInfo> signIn(@PathParam("type") String userType, @PathParam("username") String username, @PathParam("password") String password) {
        List<ParentInfo> users = new ArrayList<>();
        ParentInfo parentInfo = null;
        if (userType.equals("PARENT")) {
            ParentService parentService = new ParentService();
            Parent user = parentService.findParentByUsername(username);
            if (user != null) {
                if (user.getPassword().equals(password)) {
                    System.out.println("Parent successfully signed in.");
                    parentInfo = ResourceConverters.convertParentChildToDTO(user);
                    users.add(parentInfo);
                } else {
                    System.out.println("Invalid username or password.");
                }
            } else {
                System.out.println("Invalid username or password.");
            }
        }

        return users;
    }

//    @POST
//    @Path("/signUp")
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response signUpParent(final String parent) {
//        System.out.println("Sign-Up called");
//        ParentService parentService = new ParentService();
//        Parent newParent = new Parent();
//        System.out.println(parent);
//        //newParent.setFirstName();
//        //newParent = parentService.createParent(newParent);
//        System.out.println("Sign-Up Completed. New parent id: " + newParent.getId());
//        return Response.status(201).build();
//    }
}
