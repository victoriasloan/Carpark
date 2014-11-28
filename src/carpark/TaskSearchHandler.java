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
import javax.swing.Timer;

//This class' purpose is to handle a user selecting the search for vehicle option.
public class TaskSearchHandler implements ActionListener
{

    private CarParkFrame frame_;
    private TaskAdmitHandler admit_;
    private CarParkPanel panel_;
    
    //constructor initialising the variables
    public TaskSearchHandler(CarParkFrame theFrame, CarParkPanel thePanel, TaskAdmitHandler theAdmit) 
    { 
        frame_ = theFrame ;
        admit_ = theAdmit;
        panel_ = thePanel;
    } 
    
    
    @Override
    public void actionPerformed(ActionEvent evt) 
    {   
        
        try
        {
        //executes the method that allows for searching
         this.searchVehicles(admit_.getVehicles(), panel_.parkingSpaces_);
         //this.flash(panel.parkingSpaces_, i);
        }
        catch (NullPointerException cancel)
        {
          //catches a null pointer exception in the event the user hits cancel and no vehicle object is created 
        }
    }
    
    
    
    
     //Iterates through array and checks if a vehicle matching the entered registration exists
     // i.e. an instance exists of it.
    protected void searchVehicles(Vehicle[] vehicles, ParkingSpace[] parkingSpaces)
    {   
        boolean found = false;
        int i = 0;
        String target = admit_.enterReg();
        
        //searches through the array of vehicles. If the vehicle isn't null, then check its reg to see if it matches
        while((i<=14) && (found==false)) 
        {
            if(vehicles[i]!=null) //if element is null, then nothing exists in it.
            {
                if( target.equals(vehicles[i].getRegistration())) //if the target is found, then display the following message.
                {
                    JOptionPane.showMessageDialog(frame_,
                    "The car you are looking for is in bay: " + vehicles[i].getSpace());
                    
                    this.flash(parkingSpaces, (vehicles[i].getSpace()-1)); //also flash the space the vehicle is in.
                                                                           //its -1, because the array starts at zero, and not 1.
                    found = true;
                }
            }
                        
            i++;
        }
        
        if(found == false) // if the target isn't found, display the following message
        {
            JOptionPane.showMessageDialog(frame_,
            "The registration you have entered doesn't match any vehicles in the car park!");
        }
        
        
    } 
    

    // a method that makes the parking space that user is searching for appear to flash.
    public void flash(final ParkingSpace[] parkingSpaces, final int i)
    {   
        // Inner class to deal with time-out events
         class MyTimerHandler implements ActionListener
           {
             int counter = 0;
             boolean isRed = true; //allows sytem to keep track of what colour the bay is
             
                @Override
                public void actionPerformed(ActionEvent evt)
                {
                    //if the space is red, then change it to green and repaint it.
                    if(isRed == true) 
                    {
                        parkingSpaces[i].setAsFree(); //this means the space will be drawn green
                        frame_.repaint();
                        isRed=false;
                    }
                    else if(isRed==false)  //if the space isn't red, then change it back to red and repaint
                    {
                        parkingSpaces[i].setAsTaken(); //this means the space will be drawn red
                        frame_.repaint();
                        isRed = true;
                    }
  
                   counter++; //this counter means the space will flash a different colour 6 times.
                   if(counter==6)
                   {
                       ((Timer)evt.getSource()).stop(); // stops the timer.
                   }
    
                }
            } 
        
        Timer myTimer = new Timer(150, new MyTimerHandler()); // a timer that will execute every 150 miliseconds

         myTimer.start() ; //start the timer.
   
    }

    
}
