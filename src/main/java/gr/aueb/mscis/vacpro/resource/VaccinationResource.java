package gr.aueb.mscis.vacpro.resource;

import gr.aueb.mscis.vacpro.model.Child;
import gr.aueb.mscis.vacpro.model.Vaccination;
import gr.aueb.mscis.vacpro.model.Vaccine;
import gr.aueb.mscis.vacpro.persistence.JPAUtil;
import gr.aueb.mscis.vacpro.service.GmailProvider;
import gr.aueb.mscis.vacpro.service.NotificationService;
import gr.aueb.mscis.vacpro.service.VaccinationService;
import gr.aueb.mscis.vacpro.service.VaccineService;
import org.apache.commons.lang3.time.DateUtils;

import javax.persistence.EntityManager;
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
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * The type Vaccination resource.
 *
 * @author taggelis
 */
@Path("vaccination")
public class VaccinationResource {

	/**
	 * The Uri info.
	 */
	@Context
	private UriInfo uriInfo;

	/**
	 * Create vaccination response.
	 *
	 * @param childId   the child id
	 * @param vaccineId the vaccine id
	 * @param request   the request
	 * @return the list
	 */
	@POST
	@Path("vaccination/{childId}/{vaccineId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response createVaccination(@PathParam("childId") final int childId,
									  @PathParam("vaccineId") final int vaccineId,
									  final VaccinationInfo request) {
		VaccinationService vaccinationService = new VaccinationService();
		VaccineService vaccineService = new VaccineService();

		List<Vaccine> vaccines = vaccineService.findAll();
		boolean vaccineExist = false;
		Vaccine theVaccine = new Vaccine();
		for (Vaccine vaccine : vaccines) {
			if (vaccine.getId() == vaccineId) {
				vaccineExist = true;
				theVaccine = vaccine;
				break;
			}
		}

		if (!vaccineExist) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		EntityManager em = JPAUtil.getCurrentEntityManager();
		Child child = em.find(Child.class, childId);
		Vaccination vaccination = vaccinationService.createVaccination(new Vaccination(child, theVaccine,
				request.getVaccinationDate(), request.getStatus()));

		UriBuilder ub = uriInfo.getAbsolutePathBuilder();
		URI newWorkerUri = ub.path(Integer.toString(vaccination.getId())).build();
		return Response.created(newWorkerUri).build();
	}


	/**
	 * Update vaccination response.
	 *
	 * @param vaccinationId the vaccination id
	 * @param request       the request
	 * @return the response
	 */
	@PUT
	@Path("vaccination/{vaccinationId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateVaccination(@PathParam("vaccinationId") final int vaccinationId,
									  final VaccinationInfo request) {
		VaccinationService vaccinationService = new VaccinationService();

		List<Vaccination> vaccinations = vaccinationService.findAll();
		boolean vaccinationExist = false;
		Vaccination theVaccination = new Vaccination();
		for (Vaccination vaccination : vaccinations) {
			if (vaccination.getId() == vaccinationId) {
				vaccinationExist = true;
				theVaccination = vaccination;
				break;
			}
		}

		if (!vaccinationExist) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}

		theVaccination.setNotifyDate(request.getVaccinationDate());
		theVaccination.setStatus(request.getStatus());

		vaccinationService.updateVaccination(theVaccination);
		return Response.ok().build();
	}

	/**
	 * Send notifications response.
	 *
	 * @return the response
	 */
	@GET
	@Path("vaccination/notification")
	@Produces(MediaType.APPLICATION_JSON)
	public Response sendNotifications() {
		VaccinationService vaccinationService = new VaccinationService();
		NotificationService notificationService = new NotificationService(new GmailProvider(), vaccinationService);
		int notified = notificationService.sendDailyVaccinationNotification();
		return Response.ok().build();
	}

	/**
	 * Create report response.
	 *
	 * @return the response
	 */
	@GET
	@Path("vaccination/report")
	@Produces(MediaType.APPLICATION_JSON)
	public Response createReport() {
		VaccinationService vaccinationService = new VaccinationService();

		Map<Vaccine, Integer> map = vaccinationService.createMonthlyVaccinationReport(new Date(), DateUtils.addMonths(new Date(), 1));

		return Response.ok().build();
	}
}
