/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import base.Commitable;
import static base.Database.EMF;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

/**
 *
 * @author tan
 */

@Entity
@Table(name="CATEGORY")
public class Category extends Commitable implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    
    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name="PARENT_CATEGORY")
    private Category parentCategory;
    
    
    
    @Column(name="NAME")
    private String name;
    
    @Column(name="DESCRIPTION")
    private String description;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the parentCategory
     */
    public Category getParentcategory() {
        return parentCategory;
    }

    /**
     * @param category the parentCategory to set
     */
    public void setParentcategory(Category category) {
        this.parentCategory = category;
    }
    
    @Override
    public String toString(){
        return name;
    }
    
}
