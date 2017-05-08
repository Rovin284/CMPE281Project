
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class ContinueReceiver here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ContinueReceiver extends Receivers {

    /**
     * Act - do whatever the ContinueReceiver wants to do. This method is called
     * whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        // Add your action code here.
    }

    public void nextScreen(World world, String screen) {
        System.out.println("In next Screen");
        resetScreen(world);
        if (screen.equals("ServiceReceiver") || screen.equals("goBackToFuel")) {

            Message msg = new Message("Select Fuel Type\n & click continue :", 20);
            Message fuel1 = new Message("Premium", 20);
            Message fuel2 = new Message("Mid-Grade", 20);
            Message fuel3 = new Message("Unleaded", 20);
            Message help = new Message("Help", 20);
            Message cancel = new Message("Cancel", 20);
            Message continueButton = new Message("Continue", 20);
            world.addObject(msg, 500, 80);
            world.addObject(fuel1, 400, 140);
            world.addObject(fuel2, 400, 200);
            world.addObject(fuel3, 400, 260);
            world.addObject(help, 600, 140);
            world.addObject(cancel, 600, 200);
            world.addObject(continueButton, 600, 260);
        } else if (screen.equals("FuelReceiver")) {
            System.out.println("Screen must have been cleared");
            System.out.println(ServiceReceiver.getServiceType());
            System.out.println(FuelReceiver.getFuelType());
            System.out.println(FuelReceiver.getFuelRate());
            GasPumpDisplay.setTypes(ServiceReceiver.getServiceType(), FuelReceiver.getFuelType(), FuelReceiver.getFuelRate());
        } else if (screen.equals("goBackToService")) {
            Message msg = new Message("Select Service", 18);
            Message service1 = new Message("Fill gas &  \nprint receipt", 18);
            Message service2 = new Message("Fill gas &  \nCar Wash", 18);
            Message service3 = new Message("Fill gas    ", 18);
            Message help = new Message("Help", 18);
            Message cancel = new Message("Cancel", 18);
            Message continueButton = new Message("Continue", 18);
            world.addObject(msg, 500, 80);
            world.addObject(service1, 405, 140);
            world.addObject(service2, 405, 200);
            world.addObject(service3, 405, 260);
            world.addObject(help, 600, 140);
            world.addObject(cancel, 600, 200);
            world.addObject(continueButton, 600, 260);
        } 
    }

    /* public void resetScreen(World world){
       List<Message> worldMessages = new ArrayList<Message>();
       worldMessages = world.getObjects(Message.class);
       for(Message m : worldMessages){
        world.removeObject(m);
       }

    } */
    public void setServiceType(String s) {
    }

    public void setFuelType(String s) {
    }

    public void helpInfo(World w) {
    }

   
    
     public void printReceipt(String buttonPressed, World world){
     }
}
