import greenfoot.*; 

public class Car extends Actor
{
    
    MouseInfo mInfo;
        int i = 0;
        Car car;
        GreenfootSound g = new GreenfootSound("vroom.mp3");
        
    public Car(){
        GreenfootImage g = getImage();
        g.scale(250,120);       
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
            if(this.getX()>600 && this.getX()<1000 &&  this.getY()>400 && this.getY()<600)   
            {  
                Actor insertingCard= getOneIntersectingObject(CarWashCode.class);
                if(insertingCard!=null)  // if penny object is found intersecting
                {                                                            
                    i = 1;                    
                }
            }
            else{
                g.play();
                setLocation(getX()+10,getY());
                Greenfoot.delay(10);
                
            }
        }
        g.stop();
        Greenfoot.setWorld(new MyWorld());
    }
}
