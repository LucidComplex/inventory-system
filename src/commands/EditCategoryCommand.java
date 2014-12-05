/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import base.Command;
import base.UI;
import exceptions.ExecutorException;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import models.Category;

/**
 *
 * @author MiriamMarie
 */
public class EditCategoryCommand extends Command{

    public EditCategoryCommand (UI ui){
        elements = ui;
        fields = elements.getFields();
        
    }
    @Override
    public void execute() throws ExecutorException {
        JComboBox editCategory = (JComboBox) fields.get("category_combo");
        Category category = (Category) editCategory.getSelectedItem();
        
        JRadioButton name = (JRadioButton) fields.get("editName_radiobutton");
        JRadioButton description = (JRadioButton) fields.get("editDescription_radiobutton");
        JRadioButton parent = (JRadioButton) fields.get("editParent_radioButton");
        
        JTextField newName = (JTextField) fields.get("editName_field");
        JTextField newDescription = (JTextField) fields.get("editDescription_field");
        JComboBox newParent=(JComboBox)fields.get("editParent_combo");
        
        if(name.isSelected())
            category.setName(newName.getText());
        if(description.isSelected())
            category.setDescription(newDescription.getText());
        if(parent.isSelected())
            category.setParentcategory((Category) newParent.getSelectedItem());
        
        category.update();
    }
    
}
