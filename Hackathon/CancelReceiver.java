import greenfoot.*; 
import java.util.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CancelReceiver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CancelReceiver extends Receivers
{
    /**
     * Act - do whatever the CancelReceiver wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    /*public void resetWorld(World world){
    resetScreen(world);
    world.addObject(new Message("Thankyou \n Visit Again!!",40),493,178);
    Greenfoot.delay(150);
    Greenfoot.setWorld(new MyWorld());
    }*/
   /* public void resetScreen(World world){
       List<Message> worldMessages = new ArrayList<Message>();
       worldMessages = world.getObjects(Message.class);
       for(Message m : worldMessages){
        world.removeObject(m);
       }

    } */
    public void setServiceType(String s){}
    public void setFuelType(String s){}
    public void helpInfo(World w){}
    public void nextScreen(World w, String s){}
    public void printReceipt(String buttonPressed, World world){
     }
}
