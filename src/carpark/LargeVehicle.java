/*
 * Version 0.9
 * Last Modified: 27/11/2014
 *
 *
 * @author Victoria Sloan B00637620, Zeki Kucuk-Kose B00637176
 */
package carpark;

//This class contains code relevant to a Large vehicle, as its checkSpaces method will be implemented differently from other types of vehicle.
public class LargeVehicle extends Vehicle 
{

    @Override
    //method that checks for a free parking space suitable (spaces 6-10) for a LargeVehicle
    public boolean checkSpaces(ParkingSpace[] parkingSpaces, CarParkPanel panel)
    {
        //sets i = 6 to enable next set of bays to be searched
        int i=5;
        boolean found = false;
            
        if(this.searchSixToTen(found, i, parkingSpaces, panel) == true)
        {
            found = true;
        }

        
     //  if(found==false) //displays the result if the search failed.
       //{
       //    this.displayResult(found, i , panel);
       //}
       
       return found;
    }
    
}
