/*
 * Version 0.1
 * Last Modified: 14/11/2014
 *
 *
 * @author Victoria Sloan B00637620, Zeki Kucuk-Kose B00637176
 */
package carpark;

//The purpose of this class is to hold the abstract methods that the other classes can override

import javax.swing.JOptionPane;

// and allow some instance variables to be inherited.
public abstract class Vehicle 
{
    private String make; 
    private String model;
    private String registration;
    private int space;
    
    //abstract method that will be implemented by classes that inherit from Vehicle
    public abstract boolean checkSpaces(ParkingSpace[] parkingSpaces, CarParkPanel panel);
    
    //method that displays the result of the search for a parking space
    public void displayResult(boolean found, int i, CarParkPanel panel)
    {
        if(found == true)
        {
            JOptionPane.showMessageDialog(panel, "Parking Space found." + " Please park in space number: " + i);
        }
        
        if(found == false)
        {
            JOptionPane.showMessageDialog(panel, "All parking spaces are taken. Sorry");
        }
    }
    
    //method that searches bays 11 - 15
    public boolean searchElevenToFifteen(boolean found, int i, ParkingSpace[] parkingSpaces, CarParkPanel panel)
    {
        //searches bays 11 to 15 for a free space
        while( ((i>=10)&& (i<=14))  && (found==false) )
        {     
            if( parkingSpaces[i].isFree() == true)
            {
                found = true;
                //sets the space as taken
                parkingSpaces[i].setAsTaken();
                    
                //sets the vehicles space attribute to the one thats found
                //its i + 1 because the array starts at 0, but the actual numbers of spaces start at 1
                this.setSpace(i+1);
                
            }
            
            //increments i to continue the search
            i++;
        }
        //display a positive result if a space was found
        if(found == true)
        {
            this.displayResult(found, i, panel);
        }
        return found;
    }
    
    //method that searches bays 1-5 for a space
    public boolean searchOneToFive(boolean found, int i, ParkingSpace[] parkingSpaces, CarParkPanel panel)
    {
        while( (i<=4) && (found==false) )
        {
            if( parkingSpaces[i].isFree() == true)
            {
                //sets the space as taken
                parkingSpaces[i].setAsTaken();
                    
                //sets the vehicles space attribute to the one thats found
                //its i + 1 because the array starts at 0, but the actual numbers of spaces start at 1
                this.setSpace(i+1);
                found = true;
            }
            
            //increment i to continue the search
            i++;
        }
        
        //display a positive result if a space was found
        if(found == true)
        {
            this.displayResult(found, i, panel);
        }
        return found;
    }
   
    //searches bays 6 to 10 for a free space
    public boolean searchSixToTen(boolean found, int i, ParkingSpace[] parkingSpaces, CarParkPanel panel)
    {
 
        while( (i>=5)&& (i<=9)  && (found==false) )
        {     
            if( parkingSpaces[i].isFree() == true)
            {
                //sets the space as taken
                parkingSpaces[i].setAsTaken();
                    
                //sets the vehicles space attribute to the one thats found
                //its i + 1 because the array starts at 0, but the actual numbers of spaces start at 1
                this.setSpace(i+1);
                found = true;
            }
            
            //increments i to continue the search
            i++;
        }
        
        //display a positive result if a space was found
        if(found == true)
        {
            this.displayResult(found, i, panel);
        }
        
        return found;
    }
    
    //getter and setter methods for private instance variables
    public String getRegistration() {
        return registration;
    }

    public int getSpace() {
        return space;
    }

    public void setRegistration(String theReg) {
        this.registration = theReg;
    }

    public void setSpace(int space) {
        this.space = space;
    }
    
    
    
    
}
