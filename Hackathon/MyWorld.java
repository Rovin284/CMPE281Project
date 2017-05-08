
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    HashMap<Object,String> keyPadMap = new HashMap<Object,String>();
    Message message;
    Nozzle n;
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1); 
        prepare();
    }
    
    public void prepare()   //method to place actors and objects in the world
    {
        CreditCard creditcard = new CreditCard();        

        GasPumpDisplay gasPumpDisplay= new GasPumpDisplay(creditcard);
        addObject(gasPumpDisplay, getWidth()/2, getHeight()/2);

        addObject(creditcard,99,137);

        KeypadButton k1 = new KeypadButton(new GreenfootImage("1.PNG"),"1");
        addObject(k1, 272,413);
        keyPadMap.put(k1,"1");
        KeypadButton k2 = new KeypadButton(new GreenfootImage("2.PNG"),"2");
        addObject(k2, 312,413);
        keyPadMap.put(k2,"2");
        KeypadButton k3 = new KeypadButton(new GreenfootImage("3.PNG"),"3");
        addObject(k3, 351,413);
        keyPadMap.put(k3,"3");
        KeypadButton k4 = new KeypadButton(new GreenfootImage("4.PNG"),"4");
        addObject(k4, 272,454);
        keyPadMap.put(k4,"4");
        KeypadButton k5 = new KeypadButton(new GreenfootImage("5.PNG"),"5");
        addObject(k5, 312,455);
        keyPadMap.put(k5,"5");
        KeypadButton k6 = new KeypadButton(new GreenfootImage("6.PNG"),"6");
        addObject(k6, 351,455);
        keyPadMap.put(k6,"6");
        KeypadButton k7 = new KeypadButton(new GreenfootImage("7.PNG"),"7");
        addObject(k7,272,497);
        keyPadMap.put(k7,"7");
        KeypadButton k8 = new KeypadButton(new GreenfootImage("8.PNG"),"8");
        addObject(k8, 312,497);
        keyPadMap.put(k8,"8");
        KeypadButton k9 = new KeypadButton(new GreenfootImage("9.PNG"),"9");
        addObject(k9,350,497);
        keyPadMap.put(k9,"9");
        KeypadButton k0 = new KeypadButton(new GreenfootImage("0.PNG"),"0");
        addObject(k0,312,540);
        keyPadMap.put(k0,"0");
        KeypadButton blank1 = new KeypadButton(new GreenfootImage("blank.PNG"),"blank");
        addObject(blank1,272,540);
        keyPadMap.put(blank1,"blank1");
        KeypadButton blank2 = new KeypadButton(new GreenfootImage("blank.PNG"),"blank");
        addObject(blank2,350,540);
        keyPadMap.put(blank2,"blank2");
        KeypadMenuButton clear = new KeypadMenuButton(new GreenfootImage("clear.PNG"),"clear");
        addObject(clear, 435,456);
        keyPadMap.put(clear,"clear");
        KeypadMenuButton enter = new KeypadMenuButton(new GreenfootImage("Enter.PNG"),"enter");
        addObject(enter, 435,496);
        keyPadMap.put(enter,"enter");
        KeypadMenuButton cancel = new KeypadMenuButton(new GreenfootImage("cancel.PNG"),"cancel");
        addObject(cancel, 435,414);
        keyPadMap.put(cancel,"cancel");
        MenuButton menubutton = new MenuButton("1");
        addObject(menubutton,310,80);
        MenuButton menubutton2 = new MenuButton("2");
        addObject(menubutton2,311,140);
        MenuButton menubutton3 = new MenuButton("3");
        addObject(menubutton3,312,200);
        MenuButton menubutton4 = new MenuButton("4");
        addObject(menubutton4,313,260);
        MenuButton menubutton5 = new MenuButton("5");
        addObject(menubutton5,680,80);
        MenuButton menubutton6 = new MenuButton("6");
        addObject(menubutton6,681,140);
        MenuButton menubutton7 = new MenuButton("7");
        addObject(menubutton7,682,200);
        MenuButton menubutton8 = new MenuButton("8");
        addObject(menubutton8,683,260);
        GreenfootImage display = new GreenfootImage("Screen.png");
        DisplayScreen screen = new DisplayScreen(display);
        addObject(screen, 496,170);
        message = new Message("Welcome\nInsert Card",40);
        addObject(message,493,178); 
        n = new Nozzle();
        addObject(n,851,389);       
    }
        
    public HashMap<Object,String> getHashMap(){
        return keyPadMap;
    }
    
    public Message getMessage(){
        return message;
    }
    
    public Nozzle getNozzle(){
        return n;
    }

}
