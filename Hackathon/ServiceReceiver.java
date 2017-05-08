import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ServiceReceiver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ServiceReceiver extends Receivers
{
    /**
     * Act - do whatever the ServiceReceiver wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    static String serviceType = null;
    String service = null;
    public void ServiceReceiver(){
    }
    public void act() 
    {
        // Add your action code here.
    }    
    public void setServiceType(String s){
      if(s.equals("2")){
      serviceType = "FillGas and Print Receipt";
      System.out.println(serviceType);
     }else if(s.equals("3")){
        serviceType = "Fill Gas and CarWash";
        System.out.println(serviceType);
        }
     else if(s.equals("4")){
        serviceType = "Fill Gas";
        System.out.println(serviceType);
        }
    }
    public static String getServiceType(){
     return serviceType;
    }
     public void setFuelType(String s){}
     
      public void helpInfo(World w){}
      public void nextScreen(World w, String s){}
           public void printReceipt(String buttonPressed, World world){
     }
    }
    
    
   

