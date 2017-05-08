import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class KeypadMenuButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class KeypadMenuButton extends Button
{
    /**
     * Act - do whatever the KeypadMenuButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public KeypadMenuButton(GreenfootImage g, String buttonPressed){
        super(buttonPressed);
        g.scale(50, 30) ;
        setImage(g);
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
}
