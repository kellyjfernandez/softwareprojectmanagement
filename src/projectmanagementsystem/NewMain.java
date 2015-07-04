/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projectmanagementsystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;

/**
 *
 * @author KellyJohanna
 */
public class NewMain 
{
    
    public static void main(String[] args) 
    {
        JFrame main = new JFrame();
        main.setVisible(true);
        main.setSize(100,300);
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
       JButton create = new JButton("Create");
       JButton view = new JButton("View/Edit");
       JPanel panel = new JPanel();
       panel.add(create);
       panel.add(view);
       main.add(panel);
       create.addActionListener(new Action());
       view.addActionListener(new Action());
//        
//        String name = "Kelly";
//        String desc = "my project for software management";
//        try{
//    Class.forName("com.mysql.jdbc.Driver");
//            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/projectmanagementsystem?zeroDateTimeBehavior=convertToNull", "root", "password");
//    PreparedStatement pst = con.prepareStatement("SELECT * FROM project");
//    ResultSet rs = pst.executeQuery();
//    while (rs.next()) {
//            String names = rs.getString("projectname");
//            String descs = rs.getString("projectdesc");
//            System.out.println(names + "\t" + descs); 
//            }
//        }
//    catch(Exception e)
//    {
//      System.out.println(e.toString());
//    }
////       
//       Project project = new Project();
//       project.setProjectName("project");
//       project.setProjectDescription("testing 123");
//       Person p = new Person();
//       p.setFirstName("Johanna");
//       p.setLastName("Gomez");
//       p.setPosition("CEO");
//       project.getTeamMembers().add(p);
////        
//        try{
//    Class.forName("com.mysql.jdbc.Driver");
//            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/projectmanagementsystem?zeroDateTimeBehavior=convertToNull", "root", "password");
////    
//            String query = "insert into project(projectname, projectdesc) values (?, ?)";
//            PreparedStatement pst = con.prepareStatement(query);
//            pst.setString(1, project.getProjectName() );
//            pst.setString(2, project.getProjectDescription());
//            pst.executeUpdate();
//            
//            String query2 = "select idproject from project where projectdesc = ?";
//            PreparedStatement pst2 = con.prepareStatement(query2);
//            String desc = project.getProjectDescription();
//            pst2.setString(1, desc);
//            ResultSet rs = pst2.executeQuery();
//            int id = 0;
//            if (rs.next()) 
//            {    
//                id= rs.getInt("idproject");
//            }
//
//            System.out.println(id);
//      
//       
//       for(int i = 0; i < project.getTeamMembers().size();i++)
//            {
//                String query3 = "insert into teammember(firstname,lastname,position,teammember_FK) values (?,?,?,?)";
//                PreparedStatement pst3 = con.prepareStatement(query3);
//                pst.setString(1, project.getTeamMembers().get(i).getFirstName());
//                pst.setString(2, project.getTeamMembers().get(i).getLastName());
//                pst.setString(3, project.getTeamMembers().get(i).getPosition());
//                pst.setInt(4, id);
//                pst3.executeUpdate();
//            }
//       
//        }
//       catch(Exception e)
//       {
//           System.out.println(e.toString());
//       }
        
//        Project currentProject = new Project();
//        Effort effor = new Effort();
//        effor.setEffortDate("03/03/2015");
//        effor.setEffortDevPhase("Coding");
//        effor.setEffortHours(30);
//        effor.s
//        
//        for(int i = 0; i < currentProject.getEfforts().size();i++)
//            {
//                String query4 = "select idrequirement from requirement where requirementdesc = ?";
//            PreparedStatement pst4 = con.prepareStatement(query4);
//            String desc2 = currentProject.getRequirements().get(currentProject.getEfforts().get(i).getRequirementID()).requirementDescription;
//            pst4.setString(1, desc2);
//            ResultSet rs2 = pst4.executeQuery();
//            int reqid = 0;
//            if (rs.next()) 
//            {    
//                reqid= rs2.getInt("idrequirement");
//            }
//            System.out.println(reqid);
//                
//                String query3 = "insert into effort(effortdate,efforthours,effortdevphase,effort_FK) values (?,?,?,?)";
//                PreparedStatement pst3 = con.prepareStatement(query3);
//                pst3.setString(1, currentProject.getEfforts().get(i).getEffortDate());
//                pst3.setInt(2, currentProject.getEfforts().get(i).getEffortHours());
//                pst3.setString(3, currentProject.getEfforts().get(i).getEffortDevPhase());
//                pst3.setInt(4, reqid);
//                pst3.executeUpdate();
//            }
       
 
    }
       
       static class Action implements ActionListener{
           public void actionPerformed (ActionEvent e){
               
               JButton button = (JButton)e.getSource();

            String label2 = button.getText();
               
            if(label2.equals("Create"))
            {
            JFrame frame2 = new JFrame("Create Project");
               frame2.setVisible(true);
               frame2.setSize(1200, 550);
               frame2.add(new CreateProject());
               
           }
            else
            {
                JFrame frame3 = new JFrame("Make your seletion");
                frame3.setVisible(true);
                frame3.setSize(300,300);
                frame3.add(new ChooseProject());
            }
           }
       }
}
       
    
    

