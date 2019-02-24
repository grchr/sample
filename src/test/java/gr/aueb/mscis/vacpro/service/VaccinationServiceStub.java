package gr.aueb.mscis.vacpro.service;

import gr.aueb.mscis.vacpro.enums.VaccinationStatus;
import gr.aueb.mscis.vacpro.model.Child;
import gr.aueb.mscis.vacpro.model.Parent;
import gr.aueb.mscis.vacpro.model.Vaccination;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author taggelis
 */
public class VaccinationServiceStub extends VaccinationService {

	@Override
	public List<Vaccination> findVaccinationsThatNeedNotification(Date date) {
		Parent parent = new Parent();
		parent.setFistName("theParent");
		parent.setLastName("Papadopoylos");
		parent.setEmail("theparent@gmail.com");

		Vaccination vac = new Vaccination();
		vac.setStatus(VaccinationStatus.REGISTERED);
		vac.setChild(new Child("kostas", "fortounis", date, parent));

		Vaccination vac2 = new Vaccination();
		vac2.setStatus(VaccinationStatus.REGISTERED);
		vac2.setChild(new Child("andreas", "mpouxalakis", date, parent));

		List<Vaccination> vaccinations = new ArrayList<>();
		vaccinations.add(vac);
		vaccinations.add(vac2);

		return vaccinations;
	}

	@Override
	public Vaccination updateVaccination(Vaccination vac){
		return vac;
	}
}

