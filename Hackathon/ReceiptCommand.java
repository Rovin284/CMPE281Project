import greenfoot.*;

public class ReceiptCommand  implements Command
{    
    Receivers receiver;
    String service = null;
    
    public ReceiptCommand(Receivers receiver, String service)
    {
        this.receiver = receiver;
        this.service = service;
    }

    public void execute(World world){
        receiver.printReceipt(service, world);
    }
    
}
