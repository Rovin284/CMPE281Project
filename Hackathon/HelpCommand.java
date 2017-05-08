import greenfoot.*;

public class HelpCommand implements Command
{
    Receivers r;
    
    public HelpCommand(Receivers r)
    {
        this.r = r;
    }
    
    public void execute(World world){
        System.out.println("in execute() of help command");
        r.helpInfo(world);
    }
    
}
