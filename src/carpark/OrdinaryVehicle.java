/*
 * Version 0.9
 * Last Modified: 27/11/2014
 *
 *
 * @author Victoria Sloan B00637620, Zeki Kucuk-Kose B00637176
 */
package carpark;

//This class contains code relevant to an ordinary vehicle, as its checkSpaces method will be implemented differently from other types of vehicle.



public class OrdinaryVehicle extends Vehicle
{   

    //goes through parkingSpaces looking for an available free space. First from spaces 11-15, then from 1-5, then finally from 6-10.
    //returns whether or not the check is successful
    @Override
    public boolean checkSpaces(ParkingSpace[] parkingSpaces, CarParkPanel panel)
    {  
 
        //sets i = 10 to enable first set of bays to be searched
        int i = 10;
        boolean found = false;
        
        //try and find a free space from bays 11-15
        if(this.searchElevenToFifteen(found, i, parkingSpaces, panel) == true)
        {
            found = true;
        }

        
        //if not found then searches bays 1-5
        if(found ==false)
        {
            //sets i = 1 to enable the next set of bays to be searched
            i = 0;
            if(this.searchOneToFive(found, i, parkingSpaces, panel) == true)
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
        
        if(found == false) //displays the result if the search failed.
        {
            this.displayResult(found, i , panel);
        }
        
    return found;
               
    }
    
    
    
}
            
   
       

    

