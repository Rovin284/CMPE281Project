
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class MenuButton here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MenuButton extends Button implements Invoker {

    /**
     * Act - do whatever the MenuButton wants to do. This method is called
     * whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    Command command;
    static boolean serviceSelected = false;
    static boolean fuelSelected = false;

    public MenuButton(String buttonPressed) {
        super(buttonPressed);
        GreenfootImage image = getImage();
        image.scale(50, 30);
    }

    public void act() {
        // Add your action code here.
        if (Greenfoot.mousePressed(this)) {
            System.out.println("BUTTON PRESSED");
            List<Message> messages = new ArrayList<Message>();
            messages = (getWorld().getObjects(Message.class));
            String receiverType = null;
            for (Message o : messages) {
                System.out.println("MessageFOUND");
                if (o.getMessage().contains("Select Service")) {
                    receiverType = "ServiceReceiver";
                } else if (o.getMessage().contains("Select Fuel Type")) {
                    receiverType = "FuelReceiver";
                }else if (o.getMessage().contains("Do you want a receipt?")) {
                    receiverType = "ReceiptReceiver";
                }
                else if (o.getMessage().contains("Happy to help!")) {
                    System.out.println("Happy to help");
                    receiverType = "HelpReceiver";
                    break;
                    
                }
            }
            //ServiceReceiver serviceReceiver = getWorld().getObjects(GasPumpDisplay.class).getServiceReceiver();
            String buttonPressed = this.getButtonPressed();
            if (receiverType == null || buttonPressed.equals("5") || buttonPressed.equals("1")) {
                Greenfoot.playSound("beep.wav");
            } else if (buttonPressed.equals("2")) {
                if (receiverType.equals("ServiceReceiver")) {
                    Command c = new ServiceCommand(new ServiceReceiver(), "2");
                    this.command = c;
                    serviceSelected = true;
                } else if (receiverType.equals("FuelReceiver")) {
                    Command c = new FuelCommand(new FuelReceiver(), "2");
                    this.command = c;
                    fuelSelected = true;
                }
                else if (receiverType.equals("ReceiptReceiver")) {
                    Command c = new ReceiptCommand(new ReceiptReceiver(), "2");
                    this.command = c;
                 
                }
           
                this.press();
            } else if (buttonPressed.equals("3")) {
                if (receiverType.equals("ServiceReceiver")) {
                    Command c = new ServiceCommand(new ServiceReceiver(), "3");
                    this.command = c;
                    serviceSelected = true;
                } else if (receiverType.equals("FuelReceiver")) {
                    Command c = new FuelCommand(new FuelReceiver(), "3");
                    this.command = c;
                    fuelSelected = true;
                }
                else if (receiverType.equals("ReceiptReceiver")) {
                    Command c = new ReceiptCommand(new ReceiptReceiver(), "3");
                    this.command = c;
                 
                }
                this.press();   
            } else if (buttonPressed.equals("4")) {
                if (receiverType.equals("ServiceReceiver")) {
                    Command c = new ServiceCommand(new ServiceReceiver(), "4");
                    this.command = c;
                    serviceSelected = true;
                } else if (receiverType.equals("FuelReceiver")) {
                    Command c = new FuelCommand(new FuelReceiver(), "4");
                    this.command = c;
                    fuelSelected = true;
                }
                this.press();

            } else if (buttonPressed.equals("6") && receiverType != null) {
                System.out.println("in MenuButton()");
                receiverType = "HelpReceiver";
                System.out.println(receiverType);
                Command c = new HelpCommand(new HelpReceiver());
                this.command = c;
                this.press();

            }
            if (buttonPressed.equals("7") && receiverType != null) {
                System.out.println("Button 7 pressed");
                Command c = new CancelCommand(new CancelReceiver());
                this.command = c;
                this.press();

            }
            if (buttonPressed.equals("8")) {
                if (receiverType != null) {
                    if ((serviceSelected == true && receiverType == "ServiceReceiver") || (fuelSelected == true && receiverType == "FuelReceiver")) {
                        System.out.println("Service has been selected by the user");
                        Command c = new ContinueCommand(new ContinueReceiver(), receiverType);
                        this.command = c;
                        this.press();
                    }
                }
                if (receiverType == "HelpReceiver") {
                    if (serviceSelected == false) {
                        receiverType = "goBackToService";
                    } else if (serviceSelected == true) {
                        receiverType = "goBackToFuel";
                    }
                    Command c = new ContinueCommand(new ContinueReceiver(), receiverType);
                    this.command = c;
                    this.press();
                }

            }
        }
    }

    public void press() {
        System.out.println("in menubutton press()");
        command.execute(getWorld());
    }
}
