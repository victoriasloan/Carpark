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
import javax.swing.*;


//This class' purpose is to handle a user selecting the admit vehicle option.
public class TaskAdmitHandler implements ActionListener
{
    private  CarParkFrame frame_ ; 
    private  CarParkPanel panel_;
    private Vehicle[] vehicles_;

    public Vehicle[] getVehicles() 
    {
        return vehicles_;
    }
    
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
    
    //constructor with variables and the polymorphic vehicle array being initialised 
    public TaskAdmitHandler(CarParkFrame theFrame, CarParkPanel thePanel) 
    {   
        frame_ = theFrame ; 
        panel_ = thePanel;
        vehicles_ = new Vehicle[]{vehicleOne, vehicleTwo, vehicleThree, vehicleFour, vehicleFive, vehicleSix, vehicleSeven, 
                                 vehicleEight, vehicleNine, vehicleTen, vehicleEleven, vehicleTwelve, vehicleThirteen, 
                                 vehicleFourteen, vehicleFifteen};
    } 
    
    
    @Override
    public void actionPerformed(ActionEvent evt) 
    {   
        try
       {
        //executes the method that allows the user to admit a vehicle
        this.admitVehicle(panel_.parkingSpaces_); 
        
        //repaints the parking space that was taken, red
        frame_.repaint();
       }
        catch (NullPointerException cancel)
        {
          //catches a null pointer exception in the event the user hits cancel and no vehicle object exists to run the method
        }

    }
    

         //Allows the user to admit a vehicle.
    protected void admitVehicle(ParkingSpace[] parkingSpaces)
    {
        this.entryAnimation();
        //Brings up a dialogue box that allows for user selection of the type of vehicle
        String selection = this.selectVehicle();
        
        //brings up a dialogue box that allows the user to enter the registration
        String theReg = this.enterReg();
        
        //checks to make sure the entered reg is unique. If it isn't, the user is allowed to reenter the reg
        theReg = this.checkRegIsUnique(theReg);
                
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
                        if(vehicles_[i]==null)  //if element is null, then nothing exists in it.
                        {
                            vehicles_[i]= new OrdinaryVehicle();
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
                        if(vehicles_[i]==null) //if element is null, then nothing exists in it.
                        {
                            vehicles_[i]= new LargeVehicle();
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
                        if(vehicles_[i]==null) //if element is null, then nothing exists in it.
                        {
                            vehicles_[i]= new HighValueVehicle();
                            found = true;
                        }
                        
                        i++;
                    }        
               break;
                
        }  
        
        //this is where the polymorphism will be implemented. as it will be an array of vehicles_
        //depending on what the user has selected, it will be that type of object that will check for spaces. ie. high value/large/ordinary. 
        
        //checks for spaces
        // and set reg to the vehicle to indidcate that space is taken. Only if space was found tho.
        i--;
        if((found==true) && (vehicles_[i].checkSpaces(parkingSpaces, panel_) == true))
        {
             // the element is (i-1), because of the incrementation of i
             //that occurs during the checking for room for new vehicle
            //even if a vehicle has been found.
                vehicles_[i].setRegistration(theReg);

        }
        else //prints a message if the carpark is full
        {   
            if(i!=14)
            {
                vehicles_[i] = null; // this is to stop a new large vehicle being stored even if no spaces are free
                                         //only occurs where i!=14 to prevent the final element being accidentally set to null
                                         //as a result of a failed search.
            }
            JOptionPane.showMessageDialog(frame_,
                "I'm sorry, the carPark is full.");
        }
    }
    
    
    
    
    //method that brings up a dialogue box that allows the user to choose the type of vehicle.
    public String selectVehicle()
    {
                //Brings up a dialogue box that allows for user selection of the type of vehicle
        Object[] possibilities = {"Ordinary Vehicle", "Large Vehicle", "High Value Vehicle"};
        String selection = (String)JOptionPane.showInputDialog(frame_,
                    "What type of vehicle is it?",
                    "Vehicle Selection",
                    JOptionPane.PLAIN_MESSAGE,
                    null, //do not use a custom icon
                    possibilities,
                    "Ordinary Vehicle");
        return selection;
    }
    
    
    //a method that allows the user to enter a registration number
    public String enterReg()
    {   
       
        String theReg = (String)JOptionPane.showInputDialog(frame_,
                    "Enter the registration of the vehicle:",
                    "Enter Registration",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    null,
                    "");
        
        while(theReg.length()<3 || theReg.length()>8)  //validates the user input so that they may only enter a registration of max 8 characters
        {
          JOptionPane.showMessageDialog(frame_,
            "The registration length should be between 3 and 8 characters.");
          theReg = this.reEnterReg();
        }
        panel_.entryY = -100;
        panel_.repaint();
        return theReg; //returns the entered reg
    }
    
    //if the user enters in a registration that is too long, this informs them
    //and allows them to enter it again
    public String reEnterReg()
    {
            
        String theReg = (String)JOptionPane.showInputDialog(frame_,
                    "Enter a registration between 3 and 8 characters:",
                    "Enter Registration",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    null,
                    "");
        theReg = this.checkRegIsUnique(theReg); //validates the re-entered reg.
        panel_.entryY = -100;
        panel_.repaint();
        return theReg; //returns the re-entered reg.
    }
    
    
    
    //A method that checks whether or not the registration is unique. If it isn't, the user is prompted to re-enter
    public String checkRegIsUnique(String theReg)
    {
        int j=0;
        while((j<=14) && (vehicles_[j]!=null))
        {
            if(theReg.equals(vehicles_[j].getRegistration())) //checks if the reg is unique. if it isn't then a message is printed and the user re-enters
            {
                 JOptionPane.showMessageDialog(frame_,
            "A vehicle already exists with this registration.");
            
                 
                 theReg = this.reEnterReg(); //prompts the user to re-enter
                 
                
            }
            j++; //increments the counter variable
        }
        return theReg; //returns the validated registration
    }

    //Animation for the entry of the car. Simulates a car driving up the attendant.
    public void entryAnimation() {
        // Inner class to deal with time-out events
        class MyEntryHandler implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent evt) {
                //Moving the car up to the attendants station
                    panel_.entryY++;
                    panel_.repaint();
                 if(panel_.entryY == 300) {
                    ((Timer) evt.getSource()).stop(); // stops the timer.
                     //panel_.entryY = -100;
                }


            }
        }

        Timer timer = new Timer(7, new MyEntryHandler());
        timer.start();
    }

    //Animation for the car driving away from the station when released.
    public void exitAnimation() {
        // Inner class to deal with time-out events
        class MyExitHandler implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent evt) {
                    panel_.y--;
                    panel_.repaint();
                if(panel_.y == - 580 ) {
                    ((Timer) evt.getSource()).stop(); // stops the timer.
                    panel_.y = 700;
                }

            }
        }
        Timer timer = new Timer(7, new MyExitHandler());
        timer.start();
    }
    
    
} 


