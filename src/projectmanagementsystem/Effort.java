/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projectmanagementsystem;

/**
 *
 * @author KellyJohanna
 */
public class Effort 
{
    int effortID;
    String effortDate;
    int effortHours;
    String effortDevPhase;
    int requirementID;
    String requirementDesc;
    
    public Effort()
    {
        effortID = 0;
        effortDate = "empty";
        effortHours = 0;
        effortDevPhase = "empty";
        requirementID = 0;
        requirementDesc = "empty";
    }
    
    public int getEffortID()
    {
        return effortID;
    }
    
    public void setEffortID(int id)
    {
        effortID = id;
    }
    
    public String getEffortDate()
    {
        return effortDate;
    }
    
    public void setEffortDate(String date)
    {
        effortDate = date;
    }
    
    public int getEffortHours()
    {
        return effortHours;
    }
    
    public void setEffortHours(int hours)
    {
        effortHours = hours;
    }
    
    public String getEffortDevPhase()
    {
        return effortDevPhase;
    }
    
    public void setEffortDevPhase(String phase)
    {
        effortDevPhase = phase;
    }
    
    public int getRequirementID()
    {
        return requirementID;
    }
    
    public void setRequirementID(int id)
    {
        requirementID = id;
    }
    
    public String getRequirementDesc()
    {
        return requirementDesc;
    }
    
    public void setRequirementDesc(String desc)
    {
        requirementDesc = desc;
    }
}
