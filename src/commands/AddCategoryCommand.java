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
import models.Category;
import models.factory.ModelFactory;

/**
 *
 * @author tan
 */
public class AddCategoryCommand extends Command {
    
    public AddCategoryCommand(UI ui){
        elements = ui;
        fields = elements.getFields();
    }

    @Override
    public void execute() throws ExecutorException {
        Category newCategory = ModelFactory.createCategory();
        
        JTextField name = (JTextField) fields.get("categoryName_field");
        JTextField description = (JTextField) fields.get("categoryDescription_field");
        JComboBox parent = (JComboBox) fields.get("parentCategory_combo");
        
        newCategory.setName(name.getText());
        newCategory.setDescription(description.getText());
        newCategory.setParentcategory((Category) parent.getSelectedItem());
        
        newCategory.commit();
    }
    
}
