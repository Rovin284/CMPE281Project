import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class HelpReceiver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HelpReceiver extends Receivers
{
    
    public void act() 
    {
        // Add your action code here.
    }    
    
    public void HelpReceiver(){}
    
    
    public void helpInfo(World world){
        resetScreen(world);
        GreenfootImage i = new GreenfootImage("help.jpg");
        Message helpImage = new Message(i);
        MyWorld gw = (MyWorld) getWorld();
        world.addObject(new Message("Happy to help!",20), 496,170);
        world.addObject(helpImage, 496,170);   
        
    }
    public void resetScreen(World world){
       List<Message> worldMessages = new ArrayList<Message>();
       worldMessages = world.getObjects(Message.class);
       for(Message m : worldMessages){
        world.removeObject(m);
       }

    }
    public void setFuelType(String s){}
    
    public void setServiceType(String s){}
    public void nextScreen(World w, String s){}
         public void printReceipt(String buttonPressed, World world){
     }
}
