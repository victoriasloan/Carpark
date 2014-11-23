/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carpark;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Zeki
 */
//This class' purpose is to handle a user selecting the Exit option.
public class FileExitHandler implements ActionListener
{
 

    private CarParkFrame frame ; 
    
    //constructor that initialises the frame variable
    public FileExitHandler(CarParkFrame theFrame) 
    { 
        frame = theFrame ; 
    } 
    
    
    @Override
    public void actionPerformed(ActionEvent evt) 
    {   
        //calls the method that closes the program
        this.windowClosed();
    }
    
    
    
    
     //Closes the window after user confirms they want to
    protected void windowClosed()
    { 
        //Checks if it is safe to close the application 
        Object[] options = {"Exit","Cancel!"};
        int choice = JOptionPane.showOptionDialog(frame,"Are you sure you wish to exit?","Exit",
                                                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                                                    null,     //do not use a custom Icon
                                                    options,  //the titles of buttons
                                                    options[0]); //default button title
        
        //If the user confirms then Exit application. 
        if(choice==0)
        {
            System.exit(0);
        } 
    } 

}
