/*
 * Version 0.1
 * Last Modified: 14/11/2014
 *
 *
 * @author Victoria Sloan B00637620, Zeki Kucuk-Kose B00637176
 */
package carpark;
import java.awt.Rectangle;

//This class' purpose is to allow a parking space to be drawn and store whether or not it is free.
public class ParkingSpace extends Rectangle 
{
    private boolean isFree;
    
    //constructor inherited from the Rectangle class
    public ParkingSpace(int x, int y, int width, int height)
    {
        super(x, y, width, height);
        this.isFree=true;
    }
    
    //method that returns whether or not the parking space is free
    public boolean isFree()
    {
        return this.isFree;
    }
    
    //method that sets the parking space as free
    public void setAsFree()
    {
        this.isFree = true;
    }
    
    //method that sets the parking space as taken
    public void setAsTaken()
    {
     this.isFree = false;
    }
    
    
    
}
