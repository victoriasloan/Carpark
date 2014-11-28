/*
 * Version 0.9
 * Last Modified: 27/11/2014
 *
 *
 * @author Victoria Sloan B00637620, Zeki Kucuk-Kose B00637176
 */
package carpark;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Line2D;

//The purpose of this class is to hold all the drawn on components of the GUI.
public class CarParkPanel extends JPanel
{   
   protected ParkingSpace[] parkingSpaces_;
    
    //public ParkingSpace[] parkingSpaceArray; //this array holds the parkingSpaces_
    public CarParkPanel()
    {
    this.setBorder(BorderFactory.createLineBorder(Color.blue)); 
    ParkingSpace spaceEight = new ParkingSpace(200, 100, 100, 150);
    ParkingSpace spaceSeven = new ParkingSpace(400, 100, 100, 150);
    ParkingSpace spaceSix = new ParkingSpace(600, 100, 100, 150);
    ParkingSpace spaceTwo = new ParkingSpace(800, 140, 60, 110);
    ParkingSpace spaceOne = new ParkingSpace(900, 140, 60, 110);

    ParkingSpace spaceThirteen = new ParkingSpace(450, 400, 60, 110);
    ParkingSpace spaceTwelve = new ParkingSpace(550, 400, 60, 110);
    ParkingSpace spaceEleven = new ParkingSpace(650, 400, 60, 110);
    ParkingSpace spaceThree = new ParkingSpace(750, 400, 60, 110);

    ParkingSpace spaceFifteen = new ParkingSpace(200, 700, 60, 110);
    ParkingSpace spaceFourteen = new ParkingSpace(300, 700, 60, 110);
    ParkingSpace spaceTen = new ParkingSpace(450, 700, 100, 150);
    ParkingSpace spaceNine = new ParkingSpace(600, 700,100,150);
    ParkingSpace spaceFive = new ParkingSpace(800, 700, 60, 110);
    ParkingSpace spaceFour = new ParkingSpace(900, 700, 60, 110);
    
    parkingSpaces_ = new ParkingSpace[]{spaceOne, spaceTwo, spaceThree, spaceFour,
    spaceFive, spaceSix, spaceSeven, spaceEight, spaceNine, spaceTen,
    spaceEleven, spaceTwelve, spaceThirteen, spaceFourteen, spaceFifteen};
    }
    
    //paint method used to draw all of the graphics using a graphics2D object
      @Override
  public void paint(Graphics g)
  {
     
     Graphics2D ga = (Graphics2D)g;
     ga.setPaint(Color.green);     
    
    //Creating the rectangle that acts as the background colour of the car park
    ParkingSpace pavement = new ParkingSpace(100, 50, 925, 850 );
    
    //draws the pavement in gray
    ga.setPaint(Color.LIGHT_GRAY);
    ga.fill(pavement);
    
    //colour set back to green to draw the parking spaces in green
               ga.setPaint(Color.GREEN); 

            
    //An enhanced for-loop that itterates through the array and fills all the parking spaces as green
    for (ParkingSpace theSpace : parkingSpaces_) 
    {
        if(theSpace.isFree()==true)
        {
           ga.setPaint(Color.GREEN); 
           ga.fill(theSpace); 
        }
        else if (theSpace.isFree()==false)
        {
            ga.setColor(Color.RED);
            ga.fill(theSpace);
        }
        
    }
        
    //sets the paint back to black
    ga.setPaint(Color.BLACK);
    
    //An enhanced for-loop that itterates through the array and draws a black outline around the parking spaces
    for (ParkingSpace theSpace : parkingSpaces_)
    {
        ga.draw(theSpace);
    }
    
    //creates the attendant's station shape
    Rectangle attendantStation = new Rectangle(900, 400, 125, 150);
    
    //draws the attendant's station in dark gray
    ga.draw(attendantStation);
    ga.setPaint(Color.DARK_GRAY);
    ga.fill(attendantStation);
    

    
        //changes back to black for drawing the remaining components
    ga.setPaint(Color.BLACK);
    
    
    //draws the car park's boundaries
    ga.draw(new Line2D.Double(100, 50, 1025, 50));
    ga.draw(new Line2D.Double(100, 900, 1025, 900));
    ga.draw(new Line2D.Double(100, 50, 100, 900));
    ga.draw(new Line2D.Double(1025, 50, 1025, 250));
    ga.draw(new Line2D.Double(1025, 900, 1025, 700));
    
    ga.setFont(new Font("TimesRoman", Font.BOLD, 12));
    //draws all the labels on the car park
    ga.drawString("8", 250, 175);
    ga.drawString("7", 450, 175);
    ga.drawString("6", 650, 175);
    ga.drawString("2", 830, 200);
    ga.drawString("1", 930, 200);
    
    ga.drawString("13", 480, 455);
    ga.drawString("12", 580, 455);
    ga.drawString("11", 680, 455);
    ga.drawString("3", 780, 455);
    
    ga.drawString("15", 230, 755);
    ga.drawString("14", 330, 755);
    ga.drawString("10", 500, 775);
    ga.drawString("9", 650, 775);
    ga.drawString("5", 830, 755);
    g.drawString("4", 930, 755);
    
    ga.drawString("Entry", 1025, 300);
    ga.drawString("Exit", 1025, 650);
    ga.setPaint(Color.WHITE);
    ga.drawString("Attendant's Station", 915, 475);

   }

}
    

