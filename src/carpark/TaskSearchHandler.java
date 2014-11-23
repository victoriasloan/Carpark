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

//This class' purpose is to handle a user selecting the search for vehicle option.
public class TaskSearchHandler implements ActionListener
{

    private CarParkFrame frame;
    private TaskAdmitHandler admit;
    
    //constructor initialising the variables
    public TaskSearchHandler(CarParkFrame theFrame, TaskAdmitHandler theAdmit) 
    { 
        frame = theFrame ;
        admit = theAdmit;
    } 
    
    
    @Override
    public void actionPerformed(ActionEvent evt) 
    {   
        //executes the method that allows for searching
        this.searchVehicles(admit.getVehicles());
    }
    
    
    
    
     //Iterates through array and checks if a vehicle matching the entered registration exists
     // i.e. an instance exists of it.
    protected boolean searchVehicles(Vehicle[] vehicles)
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
        
        return found;
    } 

    
}
