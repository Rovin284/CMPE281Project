
import greenfoot.*;
import java.util.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.text.DecimalFormat;

public class GasPumpDisplay extends Actor {

    GifImage g;
    static int flag = 0;
    MouseInfo mInfo;
    CreditCard card;
    Message msg;
    MyWorld myworld;
    String fuel = null;
    static String service = null;
    static String printReceipt = null;
    int x = 490;
    int y = 250;
    int counter = 0;
    static double totalPrice;
    StringBuffer sb = new StringBuffer();
    boolean pinVerified = false;
    boolean serviceSelected = false;
    boolean fuelSelected = false;
    boolean wantReceipt = false;
    static boolean fillFuel = false;
    static String serviceType = null;
    static String fuelType = null;
    static double fuelRate;
    static boolean inactiveClear = false;
    HashMap<String, Integer> gastype = new HashMap<String, Integer>();
    ServiceReceiver serviceReceiver;
    boolean runGif = false;
    boolean stopGif = false;
    Message pickNozzle;
    Message removeNozzle;
    long stopTime; 
    long startTime;
    long totalTime;
    Message receipt;
    Receipt r;
    DecimalFormat f = new DecimalFormat("##.00");
    GreenfootSound sound = new GreenfootSound("gasfillingaudio.mp3");
    Message carWashCode;
    //gastype.put("i","1");

    public GasPumpDisplay(CreditCard card) {
        this.card = card;
        GreenfootImage image = getImage();
        image.scale(600, 600);

    }

    public GasPumpDisplay() {
    }

    public void act() {
        cardInserted();
        buttonPressed();
        selectService();        
        fillGas();
        showGif();
        removeGif();
    }

    public void buttonPressed() {
        List objects = new ArrayList();
        List menuButtons = new ArrayList();
        objects = getWorld().getObjects(KeypadButton.class);
        menuButtons = getWorld().getObjects(KeypadMenuButton.class);
        HashMap<Object, String> keyPadMap = new HashMap<Object, String>();
        MyWorld gw = (MyWorld) getWorld();
        keyPadMap = gw.getHashMap();
        for (int i = 0; i < menuButtons.size(); i++) {
            if (Greenfoot.mouseClicked(menuButtons.get(i)) && flag == 0) {
                Greenfoot.playSound("beep.wav");
            }
            if (Greenfoot.mouseClicked(menuButtons.get(i)) && keyPadMap.get(menuButtons.get(i)).equals("clear") && flag == 1 && inactiveClear == false) {
                sb.setLength(0);
                counter = 0;
                resetScreen();
                msg = new Message("Enter Pin", 40);
                getWorld().addObject(msg, 493, 178);
            }
            if (Greenfoot.mouseClicked(menuButtons.get(i)) && keyPadMap.get(menuButtons.get(i)).equals("cancel") && flag == 1) {
                resetWorld(" Thankyou! \n Visit Again");
            }
            if (Greenfoot.mouseClicked(menuButtons.get(i)) && keyPadMap.get(menuButtons.get(i)).equals("enter") && flag == 1) {
                if (counter == 4 && sb.toString().equals("1234") && inactiveClear == false) {
                    pinVerified = true;
                    inactiveClear = true;
                    resetScreen();
                } else if (counter < 4 || sb.toString().equals("1234") == false) {
                    resetWorld(" Invalid pin! \n Please try again");
                }

            }
        }
        for (int i = 0; i < objects.size(); i++) {
            if (Greenfoot.mouseClicked(objects.get(i)) && flag == 0) {
                Greenfoot.playSound("beep.wav");
            } else if (Greenfoot.mouseClicked(objects.get(i)) && flag == 1 && keyPadMap.get(objects.get(i)).equals("blank1") == false && keyPadMap.get(objects.get(i)).equals("blank2") == false) {
                if (keyPadMap.containsKey(objects.get(i))) {
                    if (counter < 4) {
                        sb.append(keyPadMap.get(objects.get(i)));
                    }
                    counter++;
                    if (counter == 1) {
                        Message msg = new Message("*", 60);
                        getWorld().addObject(msg, x, y);
                    } else if (counter == 2) {
                        Message msg = new Message("* *", 60);
                        getWorld().addObject(msg, x, y);
                    } else if (counter == 3) {
                        Message msg = new Message("* * *", 60);
                        getWorld().addObject(msg, x, y);
                    } else if (counter == 4) {
                        Message msg = new Message("* * * *", 60);
                        getWorld().addObject(msg, x, y);
                    } else {
                        Greenfoot.playSound("beep.wav");
                    }

                }

            }
        }
    }
    //intersecting logic plus change of flag

    public void cardInserted() {
        if (Greenfoot.mousePressed(card)) // take action when mouse key is pressed ie on click
        {
            card.setLocation(650, 800);
            card.move();
            myworld = (MyWorld) getWorld();
            getWorld().removeObject(myworld.getMessage());
            msg = new Message("Enter Pin", 40);
            getWorld().addObject(msg, 493, 178);
            flag = 1;
        }

    }

    public void selectService() {
        if (pinVerified == true) {
            Message msg = new Message("Select Service", 18);
            Message service1 = new Message("Fill gas &  \nprint receipt", 18);
            Message service2 = new Message("Fill gas &  \nCar Wash", 18);
            Message service3 = new Message("Fill gas    ", 18);
            Message help = new Message("Help", 18);
            Message cancel = new Message("Cancel", 18);
            Message continueButton = new Message("Continue", 18);
            getWorld().addObject(msg, 500, 80);
            getWorld().addObject(service1, 405, 140);
            getWorld().addObject(service2, 405, 200);
            getWorld().addObject(service3, 405, 260);
            getWorld().addObject(help, 600, 140);
            getWorld().addObject(cancel, 600, 200);
            getWorld().addObject(continueButton, 600, 260);
            pinVerified = false;
        }
    }

    public void fillGas() {
        if (serviceType != null && fuelType != null && fillFuel == true) {
            pickNozzle = new Message("Pick Up \nNozzle", 40);
            getWorld().addObject(pickNozzle, 500, 100);
            runGif = true;           
            System.out.println("Filling gas");                                                                            
             fillFuel = false;
            
        }
    }

    public void showGif() {
        if (runGif) {
            g = new GifImage("gasfilling.gif");
            myworld = (MyWorld) getWorld();
            Nozzle n = myworld.getNozzle();
            if (Greenfoot.mouseClicked(n)) {
                startTime = System.currentTimeMillis();
                sound.play();
                for (int i = 0; i < 15; i++) {
                    pickNozzle.setImage(g.getCurrentImage());
                    pickNozzle.getImage().scale(1000, 600);
                    pickNozzle.setLocation(getWorld().getWidth() / 2, getWorld().getHeight() / 2);
                    Greenfoot.delay(25);                    
                    stopGif = true;
                    runGif = false;
                }                
            }
        }
    }

    public void removeGif() {
        if (stopGif) {
            myworld = (MyWorld) getWorld();
            if (Greenfoot.mouseClicked(pickNozzle)) {
                stopTime = System.currentTimeMillis();
                sound.stop();
                pickNozzle.setImage(g.getCurrentImage());
                pickNozzle.getImage().scale(1000, 600);                
                Greenfoot.delay(40);                  
                stopGif = false;                
                myworld.removeObject(pickNozzle);  
                totalTime = (stopTime - startTime);  
                totalPrice = fuelRate*totalTime/1000;
                System.out.println("Total Price :" +totalPrice);
                selectType();
            }
        }
    }
    
    public void generateReceipt(){
        receipt = new Message("_|_|_|-|-|____|||_-__\n_|_|_|-|-|____|||_-__\n_|_|_|-|-|____|||_-__\n_|_|_|-|-|____|||_-__",20,"BLACK","WHITE");
        GreenfootImage img = receipt.getMessageImage();
        img.scale(120,20);        
        Greenfoot.delay(50);
        myworld.addObject(receipt,635,496);
        Greenfoot.playSound("receiptPrinting.mp3");
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
             
        myworld.removeObject(receipt);
        r = new Receipt();
        myworld.addObject(r,120,300);
        Message m1 = new Message("Total Bill: "+f.format(totalPrice),30,"BLACK","WHITE");
        myworld.addObject(m1,120,320);
        
    }
    
    public void selectType(){
     if(serviceType.equals("FillGas and Print Receipt")){
         //Logic for direct print receipt
         Message m = new Message("Gas filled!!! \n\n Total Price = "+totalPrice,20);
         getWorld().addObject(m,500, 100);
         this.generateReceipt();
        }else if(serviceType.equals("Fill Gas and CarWash")){
            //Logic for GIF
            totalPrice = totalPrice +20;
            Message m = new Message("Car Wash Done!!!\n\n Total Price = "+totalPrice,20);
            //Logic for direct print receipt
            getWorld().addObject(m,500, 100);
            this.generateReceipt();
            carWashCode = new Message("Car Wash Code :\n     1234\nTax :      "+f.format(totalPrice*3/100)+"\nWash Price :   "+20,30,"BLACK","WHITE");
            myworld.addObject(carWashCode,120,400);
            Greenfoot.delay(200);
            carWash();
        }else if(serviceType.equals("Fill Gas")){
                Message msg = new Message("Do you want a receipt?", 20);
                Message yes = new Message("Yes", 20);
                Message no = new Message("No", 20);

                getWorld().addObject(msg, 500, 80);
                getWorld().addObject(yes, 400, 140);
                getWorld().addObject(no, 400, 200);
                
                
        }
    }
    
    public void carWash(){
        carWashCode.setLocation(500,300);
        GreenfootImage city = new GreenfootImage("smallcity.png");
        city.scale(1000,600);
        carWashCode.setImage(city);
        Car car = new Car();
        myworld.addObject(car,125,540);
        myworld.addObject(new CarWashCode(),750,400);    
        car.move();
    }
    

    public void resetWorld(String message) {
        resetScreen();
        getWorld().addObject(new Message(message, 40), 493, 178);
        Greenfoot.delay(150);
        sb.setLength(0);
        counter = 0;
        flag = 0;
        Greenfoot.setWorld(new MyWorld());
    }

    public void resetScreen() {
        List<Message> worldMessages = new ArrayList<Message>();
        worldMessages = (getWorld().getObjects(Message.class));
        for (Message m : worldMessages) {
            getWorld().removeObject(m);
        }

    }

    public static void setTypes(String sType, String fType, double fRate) {
        serviceType = sType;
        fuelType = fType;
        fuelRate = fRate;
        fillFuel = true;
        System.out.println("SERVICETYPE : " + serviceType);
        System.out.println("FUELTYPE : " + fuelType);
        System.out.println("FUELRATE : " + fuelRate);
    }
    
    public static double getTotalPrice(){
        return totalPrice;
    }
    
}
