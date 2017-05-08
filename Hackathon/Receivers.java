import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Receivers here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Receivers extends Actor
{
    /**
     * Act - do whatever the Receivers wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public abstract void setServiceType(String s);
    public abstract void setFuelType(String s);
    public abstract void helpInfo(World w);
    public abstract void nextScreen(World w, String s);
    public abstract void printReceipt(String buttonPressed,World world);
    public void resetScreen(World world){
       List<Message> worldMessages = new ArrayList<Message>();
       worldMessages = world.getObjects(Message.class);
       for(Message m : worldMessages){
        world.removeObject(m);
       }

    }
    
    public void resetWorld(World world){
    resetScreen(world);
    world.addObject(new Message("Thankyou \n Visit Again!!",40),493,178);
    Greenfoot.delay(150);
    Greenfoot.setWorld(new MyWorld());
    }
    
}
