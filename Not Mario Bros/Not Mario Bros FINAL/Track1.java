import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Track1 here.
 * Switches menu soudntrack to Soundtrack 1 upon collision with Mario
 * Daniel Wei
 * Jan 18
 */
public class Track1 extends Actor
{
    /**
     * Act - do whatever the Track1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage img = new GreenfootImage("track1.png");
    public void act() 
    {
        // Add your action code here.
    }    
    
    public Track1() {
        img.scale(img.getWidth() / 20, img.getHeight() / 20);
        setImage(img);
    }
}
