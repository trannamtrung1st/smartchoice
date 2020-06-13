/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartchoice.business.services;

import javax.persistence.EntityManager;
import smartchoice.data.daos.CareerFieldDAO;
import smartchoice.data.models.CareerField;

/**
 *
 * @author TNT
 */
public class CareerFieldService {
    protected CareerFieldDAO careerFieldDAO;
    protected EntityManager entityManager;

    public CareerFieldService(EntityManager entityManager, CareerFieldDAO careerFieldDAO) {
        this.entityManager = entityManager;
        this.careerFieldDAO = careerFieldDAO;
    }

    public CareerField createCareerField(CareerField entity) {
        return careerFieldDAO.create(entity);
    }
}
