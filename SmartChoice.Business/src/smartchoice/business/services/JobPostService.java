/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartchoice.business.services;

import javax.persistence.EntityManager;
import smartchoice.data.daos.JobPostDAO;
import smartchoice.data.models.JobPost;

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

    public JobPost createJobPost(JobPost entity) {
        return jobPostDAO.create(entity);
    }

}
