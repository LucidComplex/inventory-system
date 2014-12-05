/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base;

import static base.Database.em;


/**
 *
 * @author tan
 */
public abstract class Commitable {
    
    /**
     * This method commits the object to the database
     */
    public void commit(){
        em.getTransaction().begin();
        em.persist(this);
        em.getTransaction().commit();
        updateDB();
    }
    
    /**
     * This method deletes the object
     * from the database
     */
    public void delete(){
        em.getTransaction().begin();
        em.remove(this);
        em.getTransaction().commit();
        updateDB();
    }
    
    /**
     * This method updates the object
     * from the database
     */
    public void update(){
        em.getTransaction().begin();
        em.merge(this);
        em.getTransaction().commit();
        updateDB();
    }
    
    private void updateDB(){
        Database.refreshDatabase();
    }
}
