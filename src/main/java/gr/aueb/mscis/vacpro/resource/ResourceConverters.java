package gr.aueb.mscis.vacpro.resource;

import gr.aueb.mscis.vacpro.model.Child;
import gr.aueb.mscis.vacpro.model.MunicipalityWorker;
import gr.aueb.mscis.vacpro.model.Parent;

import java.util.ArrayList;
import java.util.List;

public class ResourceConverters {

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
}
