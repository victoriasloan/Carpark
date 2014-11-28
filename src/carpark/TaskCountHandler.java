/*
 * Version 0.9
 * Last Modified: 27/11/2014
 *
 *
 * @author Victoria Sloan B00637620, Zeki Kucuk-Kose B00637176
 */
package carpark;


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
 

    private CarParkFrame frame_ ;
    private TaskAdmitHandler admit_;
    
    //Constructor that initialises the variables
    public TaskCountHandler(CarParkFrame theFrame, TaskAdmitHandler theAdmit) 
    { 
        frame_ = theFrame ;
        admit_ = theAdmit;
    } 
    
    
    @Override
    public void actionPerformed(ActionEvent evt) 
    {   
       
           //calls the method that counts the vehicles in the vehicles array.
           this.countVehicles(admit_.getVehicles());
    }

    
     //Iterates through array and counts the number of vehicles that aren't null
     // i.e. an instance exists, and it is therefore in the carpark
    public void countVehicles(Vehicle[] vehicles)
    { 
        int total = 0;
        for(int i=0; i<=14; i++)
        {
            if(vehicles[i] != null) //if the vehicle isn't null, then increment the total
            {
                total++;
            }
        }
        
        JOptionPane.showMessageDialog(frame_,        //prints the following message with the number of cars
            "The number of cars in the car park is: " + total );
         
    } 

}
