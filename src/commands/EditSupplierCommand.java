/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import base.Command;
import base.UI;
import exceptions.ExecutorException;
import javax.swing.*;
import models.Address;
import models.Contact;
import models.Supplier;

/**
 *
 * @author tan
 */
public class EditSupplierCommand extends Command {

    public EditSupplierCommand(UI ui){
        elements = ui;
        fields = elements.getFields();
    }
    
    @Override
    public void execute() throws ExecutorException {
        JComboBox editSupplier = (JComboBox) fields.get("supplier_combo");
        Supplier supplier = (Supplier) editSupplier.getSelectedItem();
        Address address = supplier.getAddress();
        Contact contact = supplier.getContact();
        
        JRadioButton name = (JRadioButton) fields.get("name_radiobutton");
        JRadioButton street = (JRadioButton) fields.get("street_radiobutton");
        JRadioButton city = (JRadioButton) fields.get("city_radiobutton");
        JRadioButton country = (JRadioButton) fields.get("country_radiobutton");
        JRadioButton province = (JRadioButton) fields.get("province_radiobutton");
        JRadioButton zipcode = (JRadioButton) fields.get("zipcode_radiobutton");
        JRadioButton number = (JRadioButton) fields.get("contact_radiobutton");
        JRadioButton email = (JRadioButton) fields.get("email_radiobutton");
        
        JTextField newName = (JTextField) fields.get("name_field");
        JTextField newStreet = (JTextField) fields.get("street_field");
        JTextField newCity = (JTextField) fields.get("city_field");
        JTextField newCountry = (JTextField) fields.get("country_field");
        JTextField newProvince = (JTextField) fields.get("province_field");
        JTextField newZipcode = (JTextField) fields.get("zipcode_field");
        JTextField newNumber = (JTextField) fields.get("number_field");
        JTextField newEmail = (JTextField) fields.get("email_field");
        
        if(name.isSelected())
            supplier.setName(newName.getText());
        if(street.isSelected())
            address.setStreet(newStreet.getText());
        if(city.isSelected())
            address.setCity(newCity.getText());
        if(country.isSelected())
            address.setCountry(newCountry.getText());
        if(province.isSelected())
            address.setProvince(newProvince.getText());
        if(zipcode.isSelected())
            address.setZipcode(newZipcode.getText());
        if(number.isSelected())
            contact.setNumber(newNumber.getText());
        if(email.isSelected())
            contact.setEmail(newEmail.getText());
            
            
//        supplier.setAddress(address);
        supplier.update();
    }
    
}
