package gr.aueb.mscis.vacpro.resource;

import gr.aueb.mscis.vacpro.model.Parent;
import gr.aueb.mscis.vacpro.persistence.JPAUtil;
import gr.aueb.mscis.vacpro.service.ParentService;

import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("users")
public class UserResource {

    @GET
    @Path("parents")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Parent> listAllParents() {
        EntityManager em = JPAUtil.getCurrentEntityManager();
        ParentService parentService = new ParentService();
        List<Parent> parents = parentService.findAll();
        em.close();
        return  parents;
    }
}
