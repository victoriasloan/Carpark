/*
 * Version 0.1
 * Last Modified: 14/11/2014
 *
 *
 * @author Victoria Sloan B00637620, Zeki Kucuk-Kose B00637176
 */
package carpark;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JMenu;





//The purpose of this class is to hold all the menu options and the panel.
public class CarParkFrame extends JFrame
{
    
    private CarParkPanel panel;
    
    //constructor that adds all of the relevant components
     public CarParkFrame()
    {
        //JFrame elements
        // this.setVisible(true);
        this.setTitle("Car Park");
        this.setSize(1100, 1000);
        this.setDefaultCloseOperation(CarParkFrame.EXIT_ON_CLOSE);
    
    
        //JMenuBar elements
        JMenuBar MenuBar = new JMenuBar();
        JMenu menuTasks = new JMenu("Tasks");
        JMenu menuFile = new JMenu("File");
     
        //JMenuItem elements
        JMenuItem menuTasksAdmitVehicle = new JMenuItem("Admit Vehicle");
        JMenuItem menuTasksReleaseVehicle = new JMenuItem("Release Vehicle");
        JMenuItem menuTasksCountVehicles = new JMenuItem("Count Number Of Vehicles In Car Park");
        JMenuItem menuTasksSearch = new JMenuItem ("Search for Car");
        
        JMenuItem menuFileExit = new JMenuItem ("Exit Application");

    
        //adding items to menu
        menuTasks.add(menuTasksAdmitVehicle);
        menuTasks.add(menuTasksReleaseVehicle);
        menuTasks.add(menuTasksCountVehicles);
        menuTasks.add(menuTasksSearch);
        

        menuFile.add(menuFileExit);

        //adding menu to menu bar
        MenuBar.add(menuFile);
        MenuBar.add(menuTasks);
        
        //setting menu bar 
        this.setJMenuBar(MenuBar);
     
     
        //instance of carparkpanel & and adding it to frame
        panel = new CarParkPanel();
        this.add(panel);
        
         //Action Listener to provide functionality to the Admit Vehicle menu item.
         TaskAdmitHandler admitClick = new TaskAdmitHandler(this, panel); 
         menuTasksAdmitVehicle.addActionListener(admitClick);
        
        
        //Action Listener to provide functionality to the Exit menu item.
        FileExitHandler exitClick = new FileExitHandler(this);
        menuFileExit.addActionListener(exitClick);
        
        //Action Listener to provide functionality to the Count vehicles menu item.
        TaskCountHandler countClick = new TaskCountHandler(this, admitClick); //passes in admit click to have access to array of vehicles.
        menuTasksCountVehicles.addActionListener(countClick);
        
        //Action Listener to provide functionality to the Count vehicles menu item.
        TaskSearchHandler searchClick = new TaskSearchHandler(this, admitClick); //passes in admit click to have access to array of vehicles.
        menuTasksSearch.addActionListener(searchClick);
        
        //Action Listener to provide functionality to the Release vehicle menu item.
        TaskReleaseHandler releaseClick = new TaskReleaseHandler(this, admitClick, panel); //passes in admit click to have access to array of vehicles.
        menuTasksReleaseVehicle.addActionListener(releaseClick);        
        

        
    }
     
     
     
     
    
    
    
}
    
    

