/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import base.Commitable;
import java.io.Serializable;
import java.time.Instant;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author tan
 */
@Entity
@Table(name="ITEM")
public class Item extends Commitable implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    
    @Column(name="DESCRIPTION")
    private String description;
    
    @Column(name="NAME")
    private String name;
    
    @Column(name="QUANTITY")
    private int quantity;
    
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="SUPPLIER")
    private Supplier supplier;
    
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="CATEGORY")
    private Category category;
    
    @Temporal(TemporalType.DATE)
    @Column(name="DATE_LAST_ADDED")
    private Date dateLastAdded;
    
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
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the supplier
     */
    public Supplier getSupplier() {
        return supplier;
    }

    /**
     * @param supplier the supplier to set
     */
    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    /**
     * @return the dateLastAdded
     */
    public Date getDateLastAdded() {
        return dateLastAdded;
    }

    /**
     * @param dateLastAdded the dateLastAdded to set
     */
    public void setDateLastAdded(Date dateLastAdded) {
        this.dateLastAdded = dateLastAdded;
    }

    /**
     * @return the category
     */
    public Category getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(Category category) {
        this.category = category;
    }
    
    public void incQuantity(int quantity){
        setQuantity(this.quantity+quantity);
    }
    
    public void decQuantity(int quantity){
        this.quantity -= quantity;
    }
    
    @Override
    public String toString(){
        return name;
    }
    
}
