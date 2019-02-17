package gr.aueb.mscis.sample.dao;

import com.sun.org.apache.regexp.internal.RE;
import gr.aueb.mscis.sample.model.MunicipalityWorker;
import gr.aueb.mscis.sample.model.User;
import gr.aueb.mscis.sample.persistence.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class MunicipalityWorkerDao extends UserDao{

    EntityManager em;

    public List<MunicipalityWorker> findByLastName(String lastName) {
        List<MunicipalityWorker> results = new ArrayList<>();

        em = JPAUtil.getCurrentEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        String queryString = "from " + User.class.getName() + " where last_name = :name and type like :type";
        Query query = em.createQuery(queryString);
        query.setParameter("name", lastName);
        query.setParameter("type", "MUN_W");
        results = (List<MunicipalityWorker>) query.getResultList();
        tx.commit();
        return results;
    }

    public List<MunicipalityWorker> findByUserName(String userName) {
        List<MunicipalityWorker> results = new ArrayList<>();

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
