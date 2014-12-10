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
import models.Contact;
import models.Monkey;
import models.factory.ModelFactory;

/**
 *
 * @author MiriamMarie
 */
public class AddUserCommand extends Command
{
    public AddUserCommand(UI ui){
        elements = ui;
        fields = elements.getFields();
    }

    @Override
    public void execute() throws ExecutorException {
        Monkey user = ModelFactory.createMonkey();
        Contact contact = ModelFactory.createContact();
        JTextField username = (JTextField) fields.get("username_field");
        JTextField password = (JTextField) fields.get("password_field");
        JTextField email = (JTextField) fields.get("email_field");
        JTextField number = (JTextField) fields.get("number_field");
        JRadioButton head = (JRadioButton) fields.get("head_radioButton");
        
        contact.setEmail(email.getText());
        contact.setNumber(number.getText());
        
        user.setContact(contact);
        user.setPassword(password.getText());
        user.setUsername(username.getText());
        user.setHead(head.isSelected());
        
        user.commit();
    }
    
}
