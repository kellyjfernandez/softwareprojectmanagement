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
public class Requirement 
{
 
    int requirementID;
    boolean isFunctionalRequirement;
    String requirementDescription;
    
    public Requirement()
    {
        requirementID = 0;
        isFunctionalRequirement = false;
        requirementDescription = "empty";
    }
    
    public int getRequirementID()
    {
        return requirementID;
    }
    
    public void setRequirementID(int id)
    {
        requirementID = id;
    }
    
    public boolean getIsFunctionalRequirement()
    {
        return isFunctionalRequirement;
    }
    
    public void setIsFunctionalRequirement(boolean functional)
    {
        isFunctionalRequirement = functional;
    }
    
    public String getRequirementDescription()
    {
        return requirementDescription;
    }
    
    public void setRequirementDescription(String desc)
    {
        requirementDescription = desc;
    }
}
