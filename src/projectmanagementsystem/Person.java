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
public class Person 
{
    int personID;
    String firstName;
    String lastName;
    String position;
    
    public Person()
    {
        personID = 0;
        firstName = "empty";
        lastName = "empty";
        position = "empty";
    }
    
    public int getPersonID()
    {
        return personID;
    }
    
    public void setPersonID(int id)
    {
        personID = id;
    }
    
    public String getFirstName()
    {
        return firstName;
    }
    
    public void setFirstName(String fname)
    {
        firstName = fname;
    }
    
    public String getLastName()
    {
        return lastName;
    }
    
    public void setLastName(String lname)
    {
        lastName = lname;
    }
    
    public String getPosition()
    {
        return position;
    }
    
    public void setPosition(String p)
    {
        position = p;
    }
}
