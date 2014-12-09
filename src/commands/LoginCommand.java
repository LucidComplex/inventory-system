/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import base.Command;
import static base.Database.EMF;
import base.UI;
import exceptions.ExecutorException;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import models.Monkey;
import ui.MainWindow;

/**
 *
 * @author tan
 */
public class LoginCommand extends Command {
    
    public LoginCommand(UI ui){
        elements = ui;
        fields = elements.getFields();
    }

    @Override
    public void execute() throws ExecutorException {
        
        JTextField usernameField = (JTextField) fields.get("username_field");
        JPasswordField passwordField = (JPasswordField) fields.get("password_field");
        
        String username = usernameField.getText();
        String password = String.valueOf(passwordField.getPassword());
        new MainWindow(login(username, password)).setVisible(true);
    }
    
    private Monkey login(String username, String password) throws ExecutorException {
        EntityManager em = EMF.createEntityManager();
        Monkey monkey;
        em.getTransaction().begin();
        StringBuilder builder = new StringBuilder("SELECT * FROM MONKEY WHERE ");
        builder.append("USERNAME=").append("\'").append(username).append("\'")
                .append(" AND PASSWORD=").append("\'").append(password).append("\'");
        
        try{
            monkey = (Monkey) em.createNativeQuery(builder.toString(), Monkey.class).getSingleResult();
        } catch(NoResultException inc){
            JLabel info = (JLabel) fields.get("information_label");
            info.setText("Login details incorrect.");
            em.close();
            throw new ExecutorException("Incorrect login details.");
        }
        
        em.close();
        return monkey;
    }
    
}
