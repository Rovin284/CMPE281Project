import greenfoot.*;/**
 * Write a description of class ContinueCommand here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ContinueCommand  implements Command
{
    Receivers r;
    String screen =null;
    public ContinueCommand(Receivers r,String screen)
    {
        this.r = r;
        this.screen = screen;
    }
    
    public void execute(World world){
        System.out.println("in execute() of continue command");
        r.nextScreen(world, screen);
    }
}
