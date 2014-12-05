/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import base.Command;
import base.UI;
import javax.swing.JTextField;
import models.Address;
import models.Supplier;
import models.factory.ModelFactory;

/**
 *
 * @author tan
 */
public class AddSupplierCommand extends Command {
    
    public AddSupplierCommand(UI ui){
        elements = ui;
        fields = elements.getFields();
    }

    @Override
    public void execute() {
        Supplier newSupplier = ModelFactory.createSupplier();
        Address address = ModelFactory.createAddress();
        
        JTextField city = (JTextField) fields.get("city_field");
        JTextField zipcode = (JTextField) fields.get("zipcode_field");
        JTextField street = (JTextField) fields.get("street_field");
        JTextField province = (JTextField) fields.get("province_field");
        JTextField country = (JTextField) fields.get("country_field");
        JTextField name = (JTextField) fields.get("supplierName_field");
        
        address.setCity(city.getText());
        address.setCountry(country.getText());
        address.setProvince(province.getText());
        address.setStreet(street.getText());
        address.setZipcode(zipcode.getText());
        
        newSupplier.setAddress(address);
        newSupplier.setName(name.getText());
        
        newSupplier.commit();
    }
    
}
