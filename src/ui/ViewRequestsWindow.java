/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import base.Database;
import base.UI;
import commands.factory.CommandFactory;
import exceptions.ExecutorException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.PurchaseRequest;
import statics.Executor;

/**
 *
 * @author MiriamMarie
 */
public class ViewRequestsWindow extends UI {

    /**
     * Creates new form ViewRequestsWindow
     */
    public ViewRequestsWindow() {
        initComponents();
        Executor.put("accept", CommandFactory.createAcceptRequestCommand(this));
        Executor.put("reject", CommandFactory.createRejectRequestCommand(this));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        requests_panel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        requests_table = new javax.swing.JTable();
        accept_button = new javax.swing.JButton();
        reject_button = new javax.swing.JButton();
        close_button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Requests");

        refreshTable();
        requests_table.setName("requests_table"); // NOI18N
        jScrollPane1.setViewportView(requests_table);

        accept_button.setText("Accept");
        accept_button.setName("accept_button"); // NOI18N

        reject_button.setText("Reject");
        reject_button.setName("reject_button"); // NOI18N
        reject_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reject_buttonActionPerformed(evt);
            }
        });

        close_button.setText("Close");
        close_button.setName("close_button"); // NOI18N
        close_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                close_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout requests_panelLayout = new javax.swing.GroupLayout(requests_panel);
        requests_panel.setLayout(requests_panelLayout);
        requests_panelLayout.setHorizontalGroup(
            requests_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(requests_panelLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(accept_button, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(reject_button, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(close_button, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );
        requests_panelLayout.setVerticalGroup(
            requests_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(requests_panelLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(requests_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(accept_button)
                    .addComponent(reject_button)
                    .addComponent(close_button))
                .addGap(0, 54, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(requests_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(requests_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void close_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_close_buttonActionPerformed
        this.dispose();
    }//GEN-LAST:event_close_buttonActionPerformed

    private void reject_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reject_buttonActionPerformed
        try {
            Executor.execute("reject");
        } catch (ExecutorException ex) {
            Logger.getLogger(ViewRequestsWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        refreshTable();
    }//GEN-LAST:event_reject_buttonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewRequestsWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewRequestsWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewRequestsWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewRequestsWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewRequestsWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton accept_button;
    private javax.swing.JButton close_button;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton reject_button;
    private javax.swing.JPanel requests_panel;
    private javax.swing.JTable requests_table;
    // End of variables declaration//GEN-END:variables
    
    private Object[][] populateTable(List list){
        Object[][] content = new Object[list.size()][2];
        for(int i=0; i<list.size(); i++){
            PurchaseRequest temp = (PurchaseRequest) list.get(i);
            content[i][0] = temp;
            content[i][1] = temp.getRequestedQuantity();
        }
        return content;
    }
    
    @Override
    public Map getFields() {
        Map fields = new HashMap();
        fields.put(requests_table.getName(), requests_table);
        return fields;
    }
    
    private void refreshTable(){
        List<PurchaseRequest> requestList = Database.getRequestList();
        Object[][] tableContents = populateTable(requestList);
        requests_table.setModel(
            new javax.swing.table.DefaultTableModel(
                tableContents,
                new String [] {
                    "Requested Item",
                    "Requested Quantity"
                }
            )
            {
                @Override
                public boolean isCellEditable(int row, int column){
                    return false;
                }
            }
        );
    }
}
