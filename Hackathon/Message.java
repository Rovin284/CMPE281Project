import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Message here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Message extends Actor
{
    /**
     * Act - do whatever the Message wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public String message = null;
    GreenfootImage g = null;
    
    public Message(){
    }
    
    public Message(String message,int size){
     GreenfootImage img = new GreenfootImage(message,size,Color.WHITE,Color.BLACK);
     setImage(img);
     this.message = message;
    }
    
    public Message(String message, int size, String textColor, String imageColor){
        GreenfootImage img = new GreenfootImage(message,size,Color.BLACK,Color.WHITE);       
        setImage(img);
        this.g= img;
        this.message = message;
    }
    
    public String getMessage(){
    return message;
    }
    
     public Message(GreenfootImage g){
     GreenfootImage img = g;
     img.scale(260,220);     
     setImage(img);   
     this.g = img;
    }
    
    public GreenfootImage getMessageImage(){
        System.out.println("Returning image");
        return g;
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
}
