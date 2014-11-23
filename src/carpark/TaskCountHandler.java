/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carpark;

/**
 *
 * @author Zeki
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Zeki
 */
//This class' purpose is to handle a user selecting the Count Vehicles option.
public class TaskCountHandler implements ActionListener
{
 

    private CarParkFrame frame ;
    private TaskAdmitHandler admit;
    
    //Constructor that initialises the variables
    public TaskCountHandler(CarParkFrame theFrame, TaskAdmitHandler theAdmit) 
    { 
        frame = theFrame ;
        admit = theAdmit;
    } 
    
    
    @Override
    public void actionPerformed(ActionEvent evt) 
    {   
        //calls the method that counts the vehicles in the vehicles array.
        this.countVehicles(admit.vehicles);
    }
    
    
    
    
     //Iterates through array and counts the number of vehicles that aren't null
     // i.e. an instance exists, and it is therefore in the carpark
    protected void countVehicles(Vehicle[] vehicles)
    { 
        int total = 0;
        
        for(int i=0; i<=14; i++)
        {
            if(vehicles[i] != null)
            {
                total++;
            }
        }
        
        JOptionPane.showMessageDialog(frame,        //prints the following message with the number of cars
            "The number of cars in the car park is: " + total);
         
    } 

}
