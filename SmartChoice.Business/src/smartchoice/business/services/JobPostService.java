/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartchoice.business.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import smartchoice.data.daos.JobPostDAO;
import smartchoice.data.models.CareerField;
import smartchoice.data.models.JobPost;
import smartchoice.data.models.Location;
import smartchoice.helper.DateHelper;

/**
 *
 * @author TNT
 */
public class JobPostService {

    protected JobPostDAO jobPostDAO;
    protected EntityManager entityManager;

    public JobPostService(EntityManager entityManager, JobPostDAO jobPostDAO) {
        this.entityManager = entityManager;
        this.jobPostDAO = jobPostDAO;
    }

    public boolean jobPostCodeExists(String code) {
        String sql = "SELECT id FROM JobPost WHERE code=?code";
        Query query = jobPostDAO.nativeQuery(sql).setParameter("code", code);
        List<Integer> list = query.getResultList();
        return list.size() > 0;
    }

    public boolean needUpdatedJobPost(String code, Date updatedDate) {
        String sql = "SELECT updatedDate FROM JobPost WHERE code=?code";
        Query query = jobPostDAO.nativeQuery(sql).setParameter("code", code);
        Date date = (Date) query.getSingleResult();
        Calendar currCal = DateHelper.getCalendar(date);
        Calendar updatedCal = DateHelper.getCalendar(updatedDate);
        int compare = DateHelper.compareIgnoreTime(currCal, updatedCal);
        return compare != 0;
    }

    public JobPost createJobPost(JobPost entity) {
        return jobPostDAO.create(entity);
    }

    public void addJobPostLocation(JobPost entity, Location location) {
        Collection<JobPost> collection = location.getJobPostCollection();
        if (collection == null) {
            collection = new ArrayList<>();
            location.setJobPostCollection(collection);
        }
        collection.add(entity);
    }

    public void addJobPostCareerField(JobPost entity, CareerField field) {
        Collection<JobPost> collection = field.getJobPostCollection();
        if (collection == null) {
            collection = new ArrayList<>();
            field.setJobPostCollection(collection);
        }
        collection.add(entity);
    }

}
