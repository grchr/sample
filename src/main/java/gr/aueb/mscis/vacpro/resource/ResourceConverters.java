package gr.aueb.mscis.vacpro.resource;

import gr.aueb.mscis.vacpro.model.Child;
import gr.aueb.mscis.vacpro.model.MunicipalityWorker;
import gr.aueb.mscis.vacpro.model.Parent;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Resource converters.
 */
public class ResourceConverters {

	/**
	 * Convert parent child to dto parent info.
	 *
	 * @param parent the parent
	 * @return the parent info
	 */
	public static ParentInfo convertParentChildToDTO(Parent parent) {
		ParentInfo parentInfo = new ParentInfo();

		parentInfo.setId(parent.getId());
		parentInfo.setFirstName(parent.getFirstName());
		parentInfo.setLastName(parent.getLastName());
		parentInfo.setUserName(parent.getUserName());
		parentInfo.setPassword(parentInfo.getPassword());
		parentInfo.setAddress(parent.getAddress());
		parentInfo.setEmail(parent.getEmail());
		parentInfo.setPhoneNumber(parent.getPhoneNumber());
		List<ChildrenInfo> children = new ArrayList<>();
		for (Child child : parent.getChildren()) {
			ChildrenInfo childrenInfo = new ChildrenInfo();

			childrenInfo.setId(child.getId());
			childrenInfo.setName(child.getName());
			childrenInfo.setSurname(child.getSurname());
			childrenInfo.setBirthday(child.getBirthday());
			childrenInfo.setParent(parentInfo);
			children.add(childrenInfo);
		}
		parentInfo.setChildren(children);
		parentInfo.setInsuranceNumber(parent.getInsuranceNumber());
		parentInfo.setVatNumber(parent.getVatNumber());

		return parentInfo;
	}

	/**
	 * Convert parent child from dto parent.
	 *
	 * @param parentInfo the parent info
	 * @return the parent
	 */
	public static Parent convertParentChildFromDTO(final ParentInfo parentInfo) {

		Parent parent = new Parent();

		parent.setId(parentInfo.getId());
		parent.setFirstName(parentInfo.getFirstName());
		parent.setLastName(parentInfo.getLastName());
		parent.setUserName(parentInfo.getUserName());
		parent.setPassword(parentInfo.getPassword());
		parent.setAddress(parentInfo.getAddress());
		parent.setEmail(parentInfo.getEmail());
		parent.setPhoneNumber(parentInfo.getPhoneNumber());
		List<Child> children = new ArrayList<>();
		if (parentInfo.getChildren() != null) {
			for (ChildrenInfo child : parentInfo.getChildren()) {
				Child childrenInfo = new Child();

				childrenInfo.setId(child.getId());
				childrenInfo.setName(child.getName());
				childrenInfo.setSurname(child.getSurname());
				childrenInfo.setBirthday(child.getBirthday());
				childrenInfo.setParent(parent);
				children.add(childrenInfo);
			}
		}
		parent.setChildren(children);
		parent.setInsuranceNumber(parentInfo.getInsuranceNumber());
		parent.setVatNumber(parentInfo.getVatNumber());

		return parent;
	}

	/**
	 * Convert to mun worker dto municipality worker info.
	 *
	 * @param municipalityWorker the municipality worker
	 * @return the municipality worker info
	 */
	public static MunicipalityWorkerInfo convertToMunWorkerDTO(MunicipalityWorker municipalityWorker) {
		MunicipalityWorkerInfo municipalityWorkerInfo = new MunicipalityWorkerInfo();

		municipalityWorkerInfo.setId(municipalityWorker.getId());
		municipalityWorkerInfo.setFirstName(municipalityWorker.getFirstName());
		municipalityWorkerInfo.setLastName(municipalityWorker.getLastName());
		municipalityWorkerInfo.setUserName(municipalityWorker.getUserName());
		municipalityWorkerInfo.setPassword(municipalityWorker.getPassword());
		municipalityWorkerInfo.setAddress(municipalityWorker.getAddress());
		municipalityWorkerInfo.setEmail(municipalityWorker.getEmail());
		municipalityWorkerInfo.setPhoneNumber(municipalityWorker.getPhoneNumber());
		municipalityWorkerInfo.setRegistryOffice(municipalityWorker.getRegistryOffice());

		return municipalityWorkerInfo;
	}


	/**
	 * Convert from mun worker to dto municipality worker.
	 *
	 * @param municipalityWorkerInfo the municipality worker info
	 * @return the municipality worker
	 */
	public static MunicipalityWorker convertFromMunWorkerToDTO(MunicipalityWorkerInfo municipalityWorkerInfo) {
		MunicipalityWorker municipalityWorker = new MunicipalityWorker();

		municipalityWorker.setId(municipalityWorkerInfo.getId());
		municipalityWorker.setFirstName(municipalityWorkerInfo.getFirstName());
		municipalityWorker.setLastName(municipalityWorkerInfo.getLastName());
		municipalityWorker.setUserName(municipalityWorkerInfo.getUserName());
		municipalityWorker.setPassword(municipalityWorkerInfo.getPassword());
		municipalityWorker.setAddress(municipalityWorkerInfo.getAddress());
		municipalityWorker.setEmail(municipalityWorkerInfo.getEmail());
		municipalityWorker.setPhoneNumber(municipalityWorkerInfo.getPhoneNumber());
		municipalityWorker.setRegistryOffice(municipalityWorkerInfo.getRegistryOffice());

		return municipalityWorker;
	}
}
