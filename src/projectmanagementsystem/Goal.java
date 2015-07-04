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
public class Goal 
{
    int goalID;
    String goalDesc;
    String goalType;
    
    public Goal()
    {
        goalID = 0;
        goalDesc = "empty";
        goalType = "empty";
    }
    
    public int getGoalID()
    {
        return goalID;
    }
    
    public void setGoalID(int id)
    {
        goalID = id;
    }
    
    public String getGoalDesc()
    {
        return goalDesc;
    }
    
    public void setGoalDesc(String desc)
    {
        goalDesc = desc;
    }
    
    public String getGoalType()
    {
        return goalType;
    }
    
    public void setGoalType(String type)
    {
        goalType = type;
    }
}
