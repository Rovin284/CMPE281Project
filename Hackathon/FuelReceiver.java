
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FuelReceiver here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FuelReceiver extends Receivers {

    /**
     * Act - do whatever the FuelReceiver wants to do. This method is called
     * whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    static String fuelType = null;
    static double fuelRate;

    public void FuelReceiver() {
    }

    public void act() {
        // Add your action code here.
    }

    public void setFuelType(String s) {
        if (s.equals("2")) {
            fuelType = "Premium";
            fuelRate = 2.90;
            System.out.println(fuelType);
        } else if (s.equals("3")) {
            fuelType = "Mid-Graded";
            fuelRate = 2.80;
            System.out.println(fuelType);
        } else if (s.equals("4")) {
            fuelType = "Unleaded";
            fuelRate = 2.51;
            System.out.println(fuelType);
        }
    }

    public static String getFuelType() {
        return fuelType;
    }

    public static double getFuelRate() {
        return fuelRate;
    }

    public void setServiceType(String s) {
    }

    public void helpInfo(World w) {
    }

    public void nextScreen(World w, String s) {
    }

    public void printReceipt(String buttonPressed, World world){
     }
}
