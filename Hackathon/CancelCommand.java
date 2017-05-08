import greenfoot.*; /**
 * Write a description of class CancelCommand here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CancelCommand  implements Command
{
    Receivers r;
    public CancelCommand(Receivers r)
    {
        this.r = r;
    }
    
    public void execute(World world){
        System.out.println("In cancel command");
        r.resetWorld(world);
    }
}
