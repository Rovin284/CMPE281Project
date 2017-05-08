import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.text.DecimalFormat;
public class ReceiptReceiver extends Receivers
{
    double totalPrice = GasPumpDisplay.getTotalPrice();
    World world;    
    Message receipt;
    Receipt r;
    DecimalFormat f = new DecimalFormat("##.00");   
    
    public void printReceipt(String buttonPressed, World world){
        if(buttonPressed.equals("2")){           
            resetScreen(world);
            Message m = new Message("Total price = " + f.format(totalPrice),20);
            this.world = world;
            world.addObject(m,493,178);
            generateReceipt();
        }else if(buttonPressed.equals("3")){
            resetWorld(world);
        }
    }
    
    public void generateReceipt(){
        receipt = new Message("_|_|_|-|-|____|||_-__\n_|_|_|-|-|____|||_-__\n_|_|_|-|-|____|||_-__\n_|_|_|-|-|____|||_-__",20,"BLACK","WHITE");
        GreenfootImage img = receipt.getMessageImage();
        img.scale(120,20);
        Greenfoot.playSound("receiptPrinting.mp3");
        world.addObject(receipt,635,496);
        int x = 10;
        int y = 496;
        for(int i = 1; i<12 ; i++){
            x=x+10;
            y = y+5;
            img.scale(120,x);
            receipt.setImage(img);
            receipt.setLocation(635,y);
            Greenfoot.delay(20);            
        }
        Greenfoot.delay(50);
        this.showReceipt();
    }
    
    public void showReceipt(){
             
        world.removeObject(receipt);
        r = new Receipt();
        world.addObject(r,120,300);
        Message m1 = new Message(""+f.format(totalPrice),30,"BLACK","WHITE");
        world.addObject(m1,180,320);
        
    }
    
    public  void setServiceType(String s){}
    public  void setFuelType(String s){}
    public  void helpInfo(World w){}
    public void nextScreen(World w, String s){}

}
