/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartchoice.business.services;

import javax.persistence.EntityManager;
import smartchoice.data.daos.LocationDAO;
import smartchoice.data.models.Location;

/**
 *
 * @author TNT
 */
public class LocationService {

    protected LocationDAO locationDAO;
    protected EntityManager entityManager;

    public LocationService(EntityManager entityManager, LocationDAO locationDAO) {
        this.entityManager = entityManager;
        this.locationDAO = locationDAO;
    }

    public Location createLocation(Location entity) {
        return locationDAO.create(entity);
    }

}
