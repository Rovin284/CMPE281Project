import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CreditClass here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CreditCard extends Actor
{
    /**
     * Act - do whatever the CreditClass wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    MouseInfo mInfo;
    int i = 0;
    
    public CreditCard(){
        GreenfootImage g = getImage();
        g.scale(200,250);
    }
    
    public void act() 
    {
        int mouseX, mouseY ;

        if(Greenfoot.mouseDragged(this)) {          
            MouseInfo mouse = Greenfoot.getMouseInfo();  
            mouseX=mouse.getX();  
            mouseY=mouse.getY();  
            setLocation(mouseX, mouseY);
        }
        

    }    
    
    
    public void move(){
         mInfo=Greenfoot.getMouseInfo();
         
         while(i == 0){
            if(this.getX()>500 && this.getX()<800 &&  this.getY()>340 && this.getY()<500)   
            {  
                Actor insertingCard= getOneIntersectingObject(GasPumpDisplay.class);
                if(insertingCard!=null)  // if penny object is found intersecting
                {                                        
                    getWorld().removeObject(this);
                    i = 1;
                    //getWorld().removeObject(message);
                    //Message msg = new Message("Enter Pin",40);
                    //getWorld().addObject(msg, 30,30);
                }
            }
            else{
                setLocation(getX(),getY()-10);
                Greenfoot.delay(10);
                
            }
        }
    }
}
