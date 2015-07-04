/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projectmanagementsystem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
 *
 * @author KellyJohanna
 */
public class NewClass extends JPanel implements ActionListener
{
    JButton create;
    public NewClass()
    {
        create = new JButton("Create");
        add(create);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {

        JButton buttonPressed = (JButton) e.getSource();

        if (buttonPressed.equals(create)) {
            add(new CreateProject());
        }

        else {
            
        }

    }
}
