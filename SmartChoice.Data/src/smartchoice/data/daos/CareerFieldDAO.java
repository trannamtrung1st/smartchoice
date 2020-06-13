/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartchoice.data.daos;

import javax.persistence.EntityManager;
import smartchoice.data.models.CareerField;

/**
 *
 * @author TNT
 */
public class CareerFieldDAO extends BaseDAO<CareerField> {
    
    public CareerFieldDAO(EntityManager eManager) {
        super(eManager);
    }
    
}
