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

//This class' purpose is to handle a user selecting the Release Vehicle option.         //IS THERE A WAY TO USE THE MTHOD FROM THE SEARCH CLASS FOR THIS??
public class TaskReleaseHandler implements ActionListener
{
    private CarParkFrame frame ;
    private CarParkPanel panel;
    private TaskAdmitHandler admit;
    
    //constructor that initialises the variables.
    public TaskReleaseHandler(CarParkFrame theFrame, TaskAdmitHandler theAdmit, CarParkPanel thePanel) 
    { 
        frame = theFrame;
        admit = theAdmit;
        panel = thePanel;
    } 



@Override
    public void actionPerformed(ActionEvent evt) 
    {   
        //calls the method that the allows the user to admit a vehicle
        this.releaseVehicle(admit.getVehicles());
    }
    
    //Prompts the user to enter the registration of the car they wish to release
    //It then searches through the vehicles array to look for a match
    //if theres a match, then it displays the bay its in and asks the user to confirm they wish to release it.
    public void releaseVehicle(Vehicle[] vehicles)
    {
       boolean found = false;
        int i = 0;
        String target = admit.enterReg();
        
        //searches through the array of vehicles. If the vehicle isn't null, then check its reg to see if it matches
        while((i<=14) && (found==false)) 
        {
            if(vehicles[i]!=null) //if element is null, then nothing exists in it.
            {
                if( target.equals(vehicles[i].getRegistration())) //if the target is found, then display the following message.
                {
                    JOptionPane.showMessageDialog(frame,
                    "The car you are looking for is in bay: " + vehicles[i].getSpace());
                                        
                    found = true;
                }
            }
                        
            i++;
        }
        
        if(found == false) // if the target isn't found, display the following message
        {
            JOptionPane.showMessageDialog(frame,
            "The registration you have entered doesn't match any vehicles in the car park!");
        }
        else //if found then checks if the user definitely wants to release the vehicle
        {
            Object[] options = {"Release","Cancel!"};
            int choice = JOptionPane.showOptionDialog(frame,"Are you sure you wish to release this vehicle?","Release Vehicle",
                                                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                                                    null,     //do not use a custom Icon
                                                    options,  //the titles of buttons
                                                    options[0]); //default button title
        
            //If the user confirms then release the vehicle 
            if(choice==0)
            {   int space = vehicles[i-1].getSpace(); 
                vehicles[i-1]=null;                   // the element is (i-1), because of the incrementation of i
                                                        //that occurs during the checking for a matching vehicle
                                                        //even if a vehicle has been found. 
  
            panel.parkingSpaces[space-1].setAsFree();   //frees [space-1] because the array starts at zero, whereas the parking spaces representation
                                                        //starts at 1.
            
            frame.repaint();                            //repaints the frame so that the newly freed up parking space is green again
            } 
        } 
    }
}
