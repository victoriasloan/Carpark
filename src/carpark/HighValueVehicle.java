/*
 * Version 0.1
 * Last Modified: 14/11/2014
 *
 *
 * @author Victoria Sloan B00637620, Zeki Kucuk-Kose B00637176
 */
package carpark;

//This class contains code relevant to a High Value vehicle, as its checkSpaces method will be implemented differently from other types of vehicle.
public class HighValueVehicle extends Vehicle 
{
    private int value;
    
     //method that checks for a free parking space suitable for a HighValueVehicle
    @Override
    public boolean checkSpaces(ParkingSpace[] parkingSpaces, CarParkPanel panel)
    {
       //sets i = 10 to enable first set of bays to be searched
        int i = 0;
        boolean found = false;
        
        //try and find a free space from bays 1-5
        if(this.searchOneToFive(found, i, parkingSpaces, panel) == true)
        {
            found = true;
        }

        
        //if not found then searches bays 11-15
        if(found ==false)
        {
            //sets i = 1 to enable the next set of bays to be searched
            i = 10;
            if(this.searchElevenToFifteen(found, i, parkingSpaces, panel) == true)
            {
                found = true;
            }
        }
        
        //if still not found, then search bays 6-10
        if(found==false)
        {   
            //sets i = 6 to enable next set of bays to be searched
            i=5;
            if(this.searchSixToTen(found, i, parkingSpaces, panel) == true)
            {
                found = true;
            }
        }
        
        //display the result of the failed search.
        if(found == false)
        {
            this.displayResult(found, i , panel);
        }
        
        return found;
    }
}
