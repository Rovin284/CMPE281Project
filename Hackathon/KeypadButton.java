import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class KeypadButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class KeypadButton extends Button
{
    /**
     * Act - do whatever the KeypadButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */    
    public KeypadButton(GreenfootImage g, String buttonPressed){
        super(buttonPressed);
        g.scale(35,40);
        setImage(g);
        
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
}
