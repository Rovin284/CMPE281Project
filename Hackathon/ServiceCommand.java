import greenfoot.*; /**
 * Write a description of class serviceCommand here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ServiceCommand implements Command 
{
    // instance variables - replace the example below with your own
    Receivers receiver;

    /**
     * Constructor for objects of class serviceCommand
     */
    String service = null;
    public ServiceCommand(Receivers receiver, String service)
    {
        this.receiver = receiver;
        this.service = service;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void execute(World world){
        receiver.setServiceType(service);
    }
}
