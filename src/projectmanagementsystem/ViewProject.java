/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projectmanagementsystem;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.sql.*;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author KellyJohanna
 */
public class ViewProject extends javax.swing.JPanel {

    /**
     * Creates new form CreateProject
     */
    
    DefaultListModel teammodel = new DefaultListModel();
    DefaultListModel goalmodel = new DefaultListModel();
    DefaultListModel requirementmodel = new DefaultListModel();
    DefaultListModel riskmodel = new DefaultListModel();
    DefaultListModel effortmodel = new DefaultListModel();
    List<Person> teammembers = new ArrayList();
    List<Goal> goals = new ArrayList();
    List<Requirement> requirements = new ArrayList();
    List<Risk> risks = new ArrayList();
    List<Effort> efforts = new ArrayList();
    Project currentProject;
    


public ViewProject() {
        initComponents();
        currentProject = new Project();
        
    }

public ViewProject(int id)
{
    initComponents();
    currentProject = new Project();
    currentProject.setProjectID(id);
    
    try
            {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/projectmanagementsystem?zeroDateTimeBehavior=convertToNull", "root", "password");

            String query2 = "select * from project where idproject = ?";
            PreparedStatement pst2 = con.prepareStatement(query2);
            int projectid = id +1;
            pst2.setInt(1, projectid);
            ResultSet rs = pst2.executeQuery();
            
            if(rs.next()) 
            {    
               projectname.setText(rs.getString("projectname"));
               projectdescription.setText(rs.getString("projectdesc"));
            }
 
            String query3 = "select * from teammember where teammember_FK = ?";
            PreparedStatement pst3 = con.prepareStatement(query3);
            pst3.setInt(1, projectid);
            ResultSet rs2 = pst3.executeQuery();
            
            while(rs2.next())
            {
                Person p = new Person();
                p.setFirstName(rs2.getString("firstname"));
                p.setLastName(rs2.getString("lastname"));
                p.setPosition(rs2.getString("position"));
                p.setPersonID(rs2.getInt("idteammember"));
                teammembers.add(p);
                teammodel.addElement(p.getFirstName() + " " + p.getLastName() + " " + p.getPosition());
            }
            
        teamlist.setModel(teammodel);
        
            String query4 = "select * from goal where goal_FK = ?";
            PreparedStatement pst4 = con.prepareStatement(query4);
            pst4.setInt(1, projectid);
            ResultSet rs3 = pst4.executeQuery();
            
            while(rs3.next())
            {
                Goal g = new Goal();
                g.setGoalID(rs3.getInt("idgoal"));
                g.setGoalDesc(rs3.getString("goaldesc"));
                g.setGoalType(rs3.getString("goaltype"));
                goals.add(g);
                goalmodel.addElement(g.getGoalType() + " " + g.getGoalDesc());
            }
            
            goallist.setModel(goalmodel);
            
            String query5 = "select * from requirement where requirement_FK = ?";
            PreparedStatement pst5 = con.prepareStatement(query5);
            pst5.setInt(1, projectid);
            ResultSet rs4 = pst5.executeQuery();
            
            while(rs4.next())
            {
                Requirement r = new Requirement();
                String type;
                r.setRequirementID(rs4.getInt("idrequirement"));
                r.setRequirementDescription(rs4.getString("requirementdesc"));
                if(rs4.getInt("isFunctionalRequirement") == 0)
                {
                    r.setIsFunctionalRequirement(false);
                    type = "Non-functional";
                }
                else
                    type = "Functional";
                requirements.add(r);
                requirementmodel.addElement(type + " " + r.getRequirementDescription());
            }
            requirementlist.setModel(requirementmodel);
            
            String query6 = "select * from risk where risk_FK = ?";
            PreparedStatement pst6 = con.prepareStatement(query6);
            pst6.setInt(1, projectid);
            ResultSet rs5 = pst6.executeQuery();
            
            while(rs5.next())
            {
                Risk r = new Risk();
                r.setRiskID(rs5.getInt("idrisk"));
                r.setRiskName(rs5.getString("riskname"));
                r.setRiskStatus(rs5.getString("riskstatus"));
                risks.add(r);
                riskmodel.addElement(r.getRiskStatus() + " " + r.getRiskName());
            }
            
            risklist.setModel(riskmodel);
            
            String query7 = "select * from effort join requirement on effort.effort_FK = requirement.idrequirement"
             + " where requirement.requirement_FK = ?";
            PreparedStatement pst7 = con.prepareStatement(query7);
            pst7.setInt(1, projectid);
            ResultSet rs6 = pst7.executeQuery();
            
            while(rs6.next())
            {
                Effort e = new Effort();
                e.setEffortID(rs6.getInt("ideffort"));
                e.setEffortDate(rs6.getString("effortdate"));
                e.setEffortDevPhase(rs6.getString("effortdevphase"));
                e.setEffortHours(rs6.getInt("efforthours"));
                e.setRequirementID(rs6.getInt("effort_FK"));
                e.setRequirementDesc(rs6.getString("requirementdesc"));
                efforts.add(e);
                effortmodel.addElement("For req: " + e.getRequirementDesc() + " " + e.getEffortDevPhase() + " " + e.getEffortDate() + " " + 
                        e.getEffortHours());
            }
            
             effortlist.setModel(effortmodel);
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

        jPanel7 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        projectname = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        projectdescription = new javax.swing.JTextArea();
        jPanel8 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        addteammember = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        teamlist = new javax.swing.JList();
        jPanel9 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        goallist = new javax.swing.JList();
        addgoalinfo = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        requirementlist = new javax.swing.JList();
        addrequirement = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        addeffort = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        effortlist = new javax.swing.JList();
        jPanel12 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        risklist = new javax.swing.JList();
        addrisk = new javax.swing.JButton();
        save = new javax.swing.JButton();

        jLabel6.setText("Enter Project Information:");

        jLabel12.setText("Project Name:");

        jLabel13.setText("Project Description:");

        projectdescription.setColumns(20);
        projectdescription.setRows(5);
        jScrollPane2.setViewportView(projectdescription);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13))
                        .addGap(58, 58, 58)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2)
                            .addComponent(projectname))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(projectname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel13))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel7.setText("Enter Project Team Information:");

        addteammember.setText("Add");
        addteammember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addteammemberActionPerformed(evt);
            }
        });

        jScrollPane3.setViewportView(teamlist);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addteammember)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addteammember)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel8.setText("Enter Project Goal Information:");

        jScrollPane5.setViewportView(goallist);

        addgoalinfo.setText("Add");
        addgoalinfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addgoalinfoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addgoalinfo)))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addgoalinfo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel11.setText("Enter Project Requirement Information:");

        jScrollPane1.setViewportView(requirementlist);

        addrequirement.setText("Add");
        addrequirement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addrequirementActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addrequirement))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel11))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(addrequirement)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel9.setText("Enter Project Effort Information:");

        addeffort.setText("Add");
        addeffort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addeffortActionPerformed(evt);
            }
        });

        jScrollPane4.setViewportView(effortlist);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                        .addComponent(addeffort)))
                .addGap(15, 15, 15))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(addeffort)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel10.setText("Enter Project Risk Information:");

        jScrollPane6.setViewportView(risklist);

        addrisk.setText("Add");
        addrisk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addriskActionPerformed(evt);
            }
        });

        save.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        save.setText("SAVE & EXIT");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                                .addComponent(addrisk))
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(save)))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                        .addContainerGap(18, Short.MAX_VALUE)
                        .addComponent(addrisk)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(save)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addteammemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addteammemberActionPerformed
     JTextField fname = new JTextField();
     JTextField lname = new JTextField();
     JTextField position = new JTextField();
     Object[]message = {
         "First Name:", fname,
         "Last Name:", lname,
         "Position:", position,
     };
     int option= JOptionPane.showConfirmDialog(this, message, "Enter Team Member Information", JOptionPane.OK_CANCEL_OPTION);
     
     if(option == JOptionPane.OK_OPTION)
     {
        Person tm = new Person();
        tm.setFirstName(fname.getText());
        tm.setLastName(lname.getText());
        tm.setPosition(position.getText());
        currentProject.getTeamMembers().add(tm);
        teammodel.addElement(tm.getFirstName() + " " + tm.getLastName() + " " + tm.getPosition());
        teamlist.setModel(teammodel);
     }
       
    }//GEN-LAST:event_addteammemberActionPerformed

    private void addgoalinfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addgoalinfoActionPerformed
        // TODO add your handling code here:
        String [] types = {"Product", "Project"};
        JComboBox typeList = new JComboBox(types);
        typeList.setSelectedIndex(0);
     JTextArea description = new JTextArea();
     description.setRows(5);
        description.setColumns(10);
        description.setLineWrap(true);
        JScrollPane pane = new JScrollPane(description);
     Object[]message = {
         "Goal type:", typeList,
         "Goal Description:", pane,
     };
     int option= JOptionPane.showConfirmDialog(this, message, "Enter Goal Information", JOptionPane.OK_CANCEL_OPTION);
     
     if(option == JOptionPane.OK_OPTION)
     {
        Goal goal = new Goal();
        goal.setGoalDesc(description.getText());
        goal.setGoalType(typeList.getSelectedItem().toString());
        currentProject.getGoals().add(goal);
        goalmodel.addElement(typeList.getSelectedItem().toString() + " " + description.getText());
        goallist.setModel(goalmodel);
     }
    }//GEN-LAST:event_addgoalinfoActionPerformed

    private void addriskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addriskActionPerformed
        // TODO add your handling code here:
        String [] types = {"Minor", "Moderate", "Major", "Catastrophic"};
        JComboBox typeList = new JComboBox(types);
        typeList.setSelectedIndex(0);
        JTextArea description = new JTextArea();
        description.setRows(5);
        description.setColumns(10);
        description.setLineWrap(true);
        JScrollPane pane = new JScrollPane(description);
        Object[]message = {
            "Risk Type:", typeList,
            "Description:", pane,
        };
        int option= JOptionPane.showConfirmDialog(this, message, "Enter Risk Information", JOptionPane.OK_CANCEL_OPTION);
        
        if(option == JOptionPane.OK_OPTION)
        {
            Risk risk = new Risk();
            risk.setRiskName(description.getText());
            risk.setRiskStatus(typeList.getSelectedItem().toString());
            currentProject.getRisks().add(risk);
            riskmodel.addElement(typeList.getSelectedItem().toString() + " " + description.getText());
            risklist.setModel(riskmodel);
        }
    }//GEN-LAST:event_addriskActionPerformed

    private void addrequirementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addrequirementActionPerformed
          // TODO add your handling code here:
        String [] types = {"Functional", "Non-functional"};
        JComboBox typeList = new JComboBox(types);
        typeList.setSelectedIndex(0);
        JTextArea description = new JTextArea();
        description.setRows(5);
        description.setColumns(10);
        description.setLineWrap(true);
        JScrollPane pane = new JScrollPane(description);
        Object[]message = {
            "Requirement Type:", typeList,
            "Description:", pane,
        };
        int option= JOptionPane.showConfirmDialog(this, message, "Enter Requirement Information", JOptionPane.OK_CANCEL_OPTION);
        
        if(option == JOptionPane.OK_OPTION)
        {
             Requirement req = new Requirement();
             req.setRequirementDescription(description.getText());
             if(typeList.getSelectedItem().toString().equals("Functional"))
                 {
                    req.setIsFunctionalRequirement(true);
                 }
             else
                    req.setIsFunctionalRequirement(false);
            currentProject.getRequirements().add(req);
            requirementmodel.addElement(typeList.getSelectedItem() + " " + description.getText());
            requirementlist.setModel(requirementmodel);
        }
    }//GEN-LAST:event_addrequirementActionPerformed

    private void addeffortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addeffortActionPerformed
        // TODO add your handling code here:
        if(requirementmodel.isEmpty())
        {
            JOptionPane.showMessageDialog(this, "You must create a requirement before entering efforts", "First create requirement", INFORMATION_MESSAGE);
            return;
        }
        String [] phases = {"Project Management", "Requirements Analysis", "Design", "Coding", "Testing"};
        JComboBox typeList = new JComboBox(phases);
        typeList.setSelectedIndex(0);
        List <String> reqs = new ArrayList();
        
        for( int i = 0; i < currentProject.getRequirements().size();i++)
        {
            reqs.add(currentProject.getRequirements().get(i).getRequirementDescription());
        }
        JComboBox reqList = new JComboBox(reqs.toArray());
        JTextField date = new JTextField();
        JTextField hours = new JTextField();
        Object[]message = {
            "For requirement:", reqList,
            "During SDLC Phase:", typeList,
            "On Date:", date,
            "Hours:", hours,
        };
        int option= JOptionPane.showConfirmDialog(this, message, "Enter Effort Information", JOptionPane.OK_CANCEL_OPTION);
     
        if(option == JOptionPane.OK_OPTION)
        {
            Effort effort = new Effort();
            effort.setEffortDate(date.getText());
            effort.setEffortDevPhase(typeList.getSelectedItem().toString());
            effort.setEffortHours(Integer.parseInt(hours.getText()));
            //effort.setRequirementID(reqList.getSelectedIndex());
            
            for(int i = 0; i < currentProject.getRequirements().size(); i++)
        {
            if(currentProject.getRequirements().get(i).getRequirementDescription().equals(reqList.getSelectedItem().toString()))
            {
                effort.setRequirementID(i);
                effort.setRequirementDesc(currentProject.getRequirements().get(i).getRequirementDescription());
            }
        }
            currentProject.getEfforts().add(effort);
            effortmodel.addElement("For req:" + " " + reqList.getSelectedItem() + " " + typeList.getSelectedItem() + " " + date.getText() + hours.getText());
             effortlist.setModel(effortmodel);
        }
    }//GEN-LAST:event_addeffortActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        // TODO add your handling code here:
        currentProject.setProjectName(projectname.getText());
        currentProject.setProjectDescription(projectdescription.getText());
        try{

    		File file =new File("projects.txt");
 
    		//if file doesnt exists, then create it
    		if(!file.exists()){
    			file.createNewFile();
    		}
 
    		//true = append file
    		FileWriter fileWritter = new FileWriter(file.getName(),true);
    	        BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
                
                bufferWritter.write(currentProject.getProjectID() + " " + currentProject.getProjectName() + " " + currentProject.getProjectDescription());
                
                for(int i = 0; i < currentProject.getRequirements().size(); i++)
                {
                    bufferWritter.write(currentProject.getRequirements().get(i).getRequirementID() + " " + currentProject.getRequirements().get(i).getRequirementDescription());
                    if(currentProject.getRequirements().get(i).getIsFunctionalRequirement() == false)
                    {
                        bufferWritter.write(" non-functional");
                    }
                    else
                        bufferWritter.write(" functional");
                    
                }
                
                for(int i = 0; i < currentProject.getTeamMembers().size(); i++)
                {
                    bufferWritter.write(currentProject.getTeamMembers().get(i).getPersonID() + " " + currentProject.getTeamMembers().get(i).getFirstName() + " " +
                    currentProject.getTeamMembers().get(i).getLastName() + "  " + currentProject.getTeamMembers().get(i).getPosition());
                }
    	       
                for(int i = 0; i < currentProject.getEfforts().size(); i++)
                {
                    bufferWritter.write(currentProject.getEfforts().get(i).getEffortID() + " " + currentProject.getEfforts().get(i).getRequirementID() + " " + 
                            currentProject.getEfforts().get(i).getEffortDevPhase() + " " + currentProject.getEfforts().get(i).getEffortDate() + " " + currentProject.getEfforts().get(i).getEffortHours());
                }
                
                for(int i = 0; i < currentProject.getGoals().size(); i++)
                {
                    bufferWritter.write(currentProject.getGoals().get(i).getGoalID() + " " + currentProject.getGoals().get(i).getGoalType() + " " + 
                            currentProject.getGoals().get(i).getGoalDesc());
                }
                
                for(int i = 0; i < currentProject.getRisks().size(); i++)
                {
                    bufferWritter.write(currentProject.getRisks().get(i).getRiskID() + " " + currentProject.getRisks().get(i).getRiskName() + " " + currentProject.getRisks().get(i).getRiskStatus());
                            
                }
    	        bufferWritter.close();
 

 
    	}catch(IOException e){
    		JOptionPane.showMessageDialog(this, "Couldn't save", "Didn't work", INFORMATION_MESSAGE);
    	}
        JOptionPane.showMessageDialog(this, "Project Successfully saved", "Success", INFORMATION_MESSAGE);
        
        try{
    Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/projectmanagementsystem?zeroDateTimeBehavior=convertToNull", "root", "password");
    
            String query = "insert into project(projectname, projectdesc) values (?, ?)";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, currentProject.getProjectName());
            pst.setString(2, currentProject.getProjectDescription());
            pst.executeUpdate();
            
            String query2 = "select idproject from project where projectdesc = ?";
            PreparedStatement pst2 = con.prepareStatement(query2);
            String desc = currentProject.getProjectDescription();
            pst2.setString(1, desc);
            ResultSet rs = pst2.executeQuery();
            int id = 0;
            if (rs.next()) 
            {    
                id= rs.getInt("idproject");
            }
            System.out.println(id);
            
            for(int i = 0; i < currentProject.getTeamMembers().size();i++)
            {
                String query3 = "insert into teammember(firstname,lastname,position,teammember_FK) values (?,?,?,?)";
                PreparedStatement pst3 = con.prepareStatement(query3);
                pst3.setString(1, currentProject.getTeamMembers().get(i).getFirstName());
                pst3.setString(2, currentProject.getTeamMembers().get(i).getLastName());
                pst3.setString(3, currentProject.getTeamMembers().get(i).getPosition());
                pst3.setInt(4, id);
                pst3.executeUpdate();
            }
            
            for(int i = 0; i < currentProject.getGoals().size();i++)
            {
                String query3 = "insert into goal(goaldesc,goaltype,goal_FK) values (?,?,?)";
                PreparedStatement pst3 = con.prepareStatement(query3);
                pst3.setString(1, currentProject.getGoals().get(i).getGoalDesc());
                pst3.setString(2, currentProject.getGoals().get(i).getGoalType());
                pst3.setInt(3, id);
                pst3.executeUpdate();
            }
            
            for(int i = 0; i < currentProject.getRequirements().size();i++)
            {
                int functional = 0;
                if(currentProject.getRequirements().get(i).getIsFunctionalRequirement() == true)
                {
                    functional = 1;
                }
                
                String query3 = "insert into requirement(isFunctionalRequirement,requirementdesc,requirement_FK) values (?,?,?)";
                PreparedStatement pst3 = con.prepareStatement(query3);
                pst3.setInt(1, functional);
                pst3.setString(2, currentProject.getRequirements().get(i).getRequirementDescription());
                pst3.setInt(3, id);
                pst3.executeUpdate();
            }
            
            for(int i = 0; i < currentProject.getRisks().size();i++)
            {
                String query3 = "insert into risk(riskname,riskstatus,risk_FK) values (?,?,?)";
                PreparedStatement pst3 = con.prepareStatement(query3);
                pst3.setString(1, currentProject.getRisks().get(i).getRiskName());
                pst3.setString(2, currentProject.getRisks().get(i).getRiskStatus());
                pst3.setInt(3, id);
                pst3.executeUpdate();
            }
            
            for(int i = 0; i < currentProject.getEfforts().size();i++)
            {
                String query4 = "select idrequirement from requirement where requirementdesc = ?";
            PreparedStatement pst4 = con.prepareStatement(query4);
            String desc2 = currentProject.getEfforts().get(i).getRequirementDesc();
            pst4.setString(1, desc2);
            ResultSet rs2 = pst4.executeQuery();
            int reqid = 0;
            if (rs.next()) 
            {    
                reqid= rs2.getInt("idrequirement");
            }
            System.out.println(reqid);
                
                String query3 = "insert into effort(effortdate,efforthours,effortdevphase,effort_FK) values (?,?,?,?)";
                PreparedStatement pst3 = con.prepareStatement(query3);
                pst3.setString(1, currentProject.getEfforts().get(i).getEffortDate());
                pst3.setInt(2, currentProject.getEfforts().get(i).getEffortHours());
                pst3.setString(3, currentProject.getEfforts().get(i).getEffortDevPhase());
                pst3.setInt(4, reqid);
                pst3.executeUpdate();
            }
        }
    catch(Exception e)
    {
      System.out.println(e.toString());
    }
    }//GEN-LAST:event_saveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addeffort;
    private javax.swing.JButton addgoalinfo;
    private javax.swing.JButton addrequirement;
    private javax.swing.JButton addrisk;
    private javax.swing.JButton addteammember;
    private javax.swing.JList effortlist;
    private javax.swing.JList goallist;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextArea projectdescription;
    private javax.swing.JTextField projectname;
    private javax.swing.JList requirementlist;
    private javax.swing.JList risklist;
    private javax.swing.JButton save;
    private javax.swing.JList teamlist;
    // End of variables declaration//GEN-END:variables
}
