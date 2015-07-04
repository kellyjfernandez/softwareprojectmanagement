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
public class Risk 
{
    int riskID;
    String riskName;
    String riskStatus;
    
    public Risk()
    {
        riskID = 0;
        riskName = "empty";
        riskStatus = "empty";
       
    }
    
    public int getRiskID()
    {
        return riskID;
    }
    
    public void setRiskID(int id)
    {
        riskID = id;
    }
    
    public String getRiskName()
    {
        return riskName;
    }
    
    public void setRiskName(String name)
    {
        riskName = name;
    }
    
    public String getRiskStatus()
    {
        return riskStatus;
    }
    
    public void setRiskStatus(String status)
    {
        riskStatus = status;
    }
    
}
