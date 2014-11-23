/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carpark;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;



/**
 *
 * @author Zeki
 */

//This class' purpose is to handle a user selecting the admit vehicle option.
public class TaskAdmitHandler implements ActionListener
{
    private CarParkFrame frame ; 
    private CarParkPanel panel;
    private Vehicle[] vehicles;
    
    //vehicle references neccessary for the polymorphic array
    Vehicle vehicleOne;
    Vehicle vehicleTwo;
    Vehicle vehicleThree;
    Vehicle vehicleFour;
    Vehicle vehicleFive;
    Vehicle vehicleSix;
    Vehicle vehicleSeven;
    Vehicle vehicleEight;
    Vehicle vehicleNine;
    Vehicle vehicleTen;
    Vehicle vehicleEleven;
    Vehicle vehicleTwelve;
    Vehicle vehicleThirteen;
    Vehicle vehicleFourteen;
    Vehicle vehicleFifteen;
    
    public Vehicle[] getVehicles()
    {
       return this.vehicles;
    }
    
    //constructor with variables and the polymorphic vehicle array being initialised 
    public TaskAdmitHandler(CarParkFrame theFrame, CarParkPanel thePanel) 
    {   
        frame = theFrame ; 
        panel = thePanel;
        vehicles = new Vehicle[]{vehicleOne, vehicleTwo, vehicleThree, vehicleFour, vehicleFive, vehicleSix, vehicleSeven, 
                                 vehicleEight, vehicleNine, vehicleTen, vehicleEleven, vehicleTwelve, vehicleThirteen, 
                                 vehicleFourteen, vehicleFifteen};
    } 
    
    
    @Override
    public void actionPerformed(ActionEvent evt) 
    {   
        //executes the method that allows the user to admit a vehicle
        this.admitVehicle(panel.parkingSpaces);
        
        //repaints the parking space that was taken, red
        frame.repaint();
    }
    

         //Allows the user to admit a vehicle.
    protected void admitVehicle(ParkingSpace[] parkingSpaces)
    {   
        //brings up a dialogue box that allows the user to enter the registration
        String theReg = this.enterReg();
        
        //Brings up a dialogue box that allows for user selection of the type of vehicle
        String selection = this.selectVehicle();
       
        
        int i=0;
        boolean found = false;
        
        //switch statement that creates the relevant vehicle based on the user's selection
        switch(selection)
        {   
            
            case "Ordinary Vehicle":
                
                 //Search array for free space while a space isnt found, and while within the length of the array.
                //if space exists then make new instance of OrdinaryVehicle
                while((i<=14) && (found==false))
                    {
                        if(vehicles[i]==null)  //if element is null, then nothing exists in it.
                        {
                            vehicles[i]= new OrdinaryVehicle();
                            found = true;
                        }
                        
                        i++;
                    }        
               break;
                
            case "Large Vehicle": 
                
                //Search array for free space while a space isnt found, and while within the length of the array.
                //if space exists then make new instance of LargeVehicle
                while((i<=14) && (found==false))  
                    {
                        if(vehicles[i]==null) //if element is null, then nothing exists in it.
                        {
                            vehicles[i]= new LargeVehicle();
                            found = true;
                        }
                        
                        i++;
                    }        
               break;
            
            case "High Value Vehicle": 
 
                //Search array for free space while a space isnt found, and while within the length of the array.
                //if space exists then make new instance of HighValueVehicle
                while((i<=14) && (found==false)) 
                    {
                        if(vehicles[i]==null) //if element is null, then nothing exists in it.
                        {
                            vehicles[i]= new HighValueVehicle();
                            found = true;
                        }
                        
                        i++;
                    }        
               break;
                
        }  
        
        //this is where the polymorphism will be implemented. as it will be an array of vehicles
        //depending on what the user has selected, it will be that type of object that will check for spaces. ie. high value/large/ordinary. 
        
        //checks for spaces
        // and set reg to the vehicle to indidcate that space is taken. Only if space was found tho.
        if(found==true)
        {
            if(vehicles[i-1].checkSpaces(parkingSpaces, panel) == true) // the element is (i-1), because of the incrementation of i
            {                                                            //that occurs during the checking for room for new vehicle
                vehicles[i-1].setRegistration(theReg);                   //even if a vehicle has been found.   
            }                                
        }
        else //prints a message if the carpark is full
        {
            JOptionPane.showMessageDialog(frame,
                "I'm sorry, the carPark is full.");
        }
    }
    
    
    //a method that allows the user to enter a registration number
    public String enterReg()
    {   
       
        String theReg = (String)JOptionPane.showInputDialog(
                    frame,
                    "Enter the registration of the vehicle:",
                    "Enter Registration",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    null,
                    "");
        
        while(theReg.length()>8)
        {
          theReg = this.reEnterReg();
        }
        return theReg;
    }
    
    //if the user enters in a registration that is too long, this informs them
    //and allows them to enter it again
    public String reEnterReg()
    {
        JOptionPane.showMessageDialog(frame,
            "The maximum length is 8.");
            
        String theReg = (String)JOptionPane.showInputDialog(
                    frame,
                    "enter a registration with a maximum of 8 characters:",
                    "Enter Registration",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    null,
                    "");
        return theReg;
    }
    
    //method that brings up a dialogue box that allows the user to choose the type of vehicle.
    public String selectVehicle()
    {
                //Brings up a dialogue box that allows for user selection of the type of vehicle
        Object[] possibilities = {"Ordinary Vehicle", "Large Vehicle", "High Value Vehicle"};
        String selection = (String)JOptionPane.showInputDialog(
                    frame,
                    "What type of vehicle is it?",
                    "Customized Dialog",
                    JOptionPane.PLAIN_MESSAGE,
                    null, //do not use a custom icon
                    possibilities,
                    "Ordinary Vehicle");
        
        return selection;
    }
    
} 


