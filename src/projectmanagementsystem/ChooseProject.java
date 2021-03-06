/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projectmanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;

/**
 *
 * @author KellyJohanna
 */
public class ChooseProject extends javax.swing.JPanel {

    /**
     * Creates new form ChooseProject
     */
   DefaultComboBoxModel projectmodel;
    public ChooseProject()
    {
        initComponents();
        
            try
            {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/projectmanagementsystem?zeroDateTimeBehavior=convertToNull", "root", "password");

            String query2 = "select projectname from project";
            PreparedStatement pst2 = con.prepareStatement(query2);
            ResultSet rs = pst2.executeQuery();
            ArrayList<String> projects = new ArrayList();
            while(rs.next()) 
            {    
               projects.add(rs.getString("projectname"));
            }
            projectmodel = new DefaultComboBoxModel(projects.toArray());
            projectlist.setModel(projectmodel);
            }
            catch(Exception e)
            {
               System.out.println(e.toString());
            }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        projectlist = new javax.swing.JComboBox();
        gobutton = new javax.swing.JButton();

        jLabel1.setText("Choose an existing Project:");

        projectlist.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        projectlist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                projectlistActionPerformed(evt);
            }
        });

        gobutton.setText("Go!");
        gobutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gobuttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(gobutton)
                            .addComponent(projectlist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addComponent(projectlist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92)
                .addComponent(gobutton)
                .addContainerGap(53, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void projectlistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_projectlistActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_projectlistActionPerformed

    private void gobuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gobuttonActionPerformed
        // TODO add your handling code here:
        JFrame viewframe = new JFrame("View Project");
        viewframe.setVisible(true);
        viewframe.setSize(1400,500);
        viewframe.add(new ViewProject(projectlist.getSelectedIndex()));
    }//GEN-LAST:event_gobuttonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton gobutton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JComboBox projectlist;
    // End of variables declaration//GEN-END:variables
}
