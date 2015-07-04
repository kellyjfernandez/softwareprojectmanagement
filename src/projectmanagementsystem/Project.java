/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projectmanagementsystem;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author KellyJohanna
 */
public class Project 
{
    int projectID;
    String projectName;
    String projectDescription;
    int projectManager;
    List<Requirement> requirements;
    List<Effort> efforts;
    List<Person> teamMembers;
    List<Goal> goals;
    List<Risk> risks;
    
    public Project()
    {
        projectID = 0;
        projectName = "empty";
        projectDescription = "empty";
        projectManager = 0;
        requirements = new ArrayList();
        efforts = new ArrayList();
        teamMembers = new ArrayList();
        goals = new ArrayList();
        risks = new ArrayList();
    }
    
    public int getProjectID()
    {
        return projectID;
    }
    
    public void setProjectID(int id)
    {
        projectID = id;
    }
    
    public String getProjectName()
    {
        return projectName;
    }
    
    public void setProjectName(String name)
    {
        projectName = name;
    }
    
    public String getProjectDescription()
    {
        return projectDescription;
    }
    
    public void setProjectDescription(String desc)
    {
        projectDescription = desc;
    }
    
    public int getProjectManager()
    {
        return projectManager;
    }
    
    public void setProjectManager(int manager)
    {
        projectManager = manager;
    }
    
    public List<Requirement> getRequirements()
    {
        return requirements;
    }
    
    public void setRequirements(List<Requirement> reqs)
    {
        requirements = reqs;
    }
    
    public List<Effort> getEfforts()
    {
        return efforts;
    }
    
    public void setEfforts(List<Effort> efforts)
    {
        this.efforts = efforts;
    }
    
    public List<Person> getTeamMembers()
    {
        return teamMembers;
    }
    
    public void setTeamMembers(List<Person> tm)
    {
        teamMembers = tm;
    }
    
    public List<Goal> getGoals()
    {
        return goals;
    }
    
    public void setGoals(List<Goal> goals)
    {
        this.goals = goals;
    }
    
    public List<Risk> getRisks()
    {
        return risks;
    }
    
    public void setRisks(List<Risk> risks)
    {
        this.risks = risks;
    }
}

