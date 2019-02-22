package gr.aueb.mscis.sample.service;

import gr.aueb.mscis.sample.dao.ChildDao;
import gr.aueb.mscis.sample.model.Child;

import java.util.List;

public class ChildService {

    public List<Child> findAll(){
        ChildDao childDao = new ChildDao();
        List<Child> results = childDao.finadAll();
        return results;
    }
}
