import greenfoot.*;

public class FuelCommand implements Command
{

    Receivers receiver;
    String fuel = null;
    
    public FuelCommand(Receivers receiver, String fuel)
    {
        this.receiver = receiver;
        this.fuel = fuel;
    }

    public void execute(World world){
        receiver.setFuelType(fuel);
    }
}
