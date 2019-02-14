package gr.aueb.mscis.sample.dao;

import gr.aueb.mscis.sample.model.MunicipalityWorker;
import gr.aueb.mscis.sample.persistence.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class MunicipalityWorkerDao {

    EntityManager em;

    public List<MunicipalityWorker> getMunWorkerByLastName(String name) {
        List<MunicipalityWorker> results = new ArrayList<>();
        // The getResultList() method return a List<Object[]>. We need to convert the returned objects to objects of our type and return them TODO: try to find other workaround
        List<Object[]> rawResults = new ArrayList<>();

        em = JPAUtil.getCurrentEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Query query = null;
        query = em.createNativeQuery("select id,first_name,last_name,reg_office from User as u where u.last_name =:name and u.type like :type").setParameter("name", name)
                .setParameter("type", "MUN_W");

        //results = query.getResultList();
        rawResults = query.getResultList();
        if (rawResults != null) {
            for (Object[] o : rawResults) {
                MunicipalityWorker worker = converObjectToMunicipalityWorker(o);
                results.add(worker);
            }
        }
        tx.commit();
        return results;
    }


    public MunicipalityWorker converObjectToMunicipalityWorker(Object[] o) {

        MunicipalityWorker worker = new MunicipalityWorker();
        worker.setId((int)o[0]);
        worker.setFistName((String)o[1]);
        worker.setLastName((String)o[2]);
        worker.setRegistryOffice((String)o[3]);

        return worker;
    }
}
