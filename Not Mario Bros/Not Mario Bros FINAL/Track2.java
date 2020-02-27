import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Track2 here.
 * Switches menu soudntrack to Soundtrack 2 upon collision with Mario
 * Daniel Wei
 * Jan 18
 */
public class Track2 extends Actor
{
    /**
     * Act - do whatever the Track2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage img = new GreenfootImage("track2.png");
    public void act() 
    {
        // Add your action code here.
    }    
    
    public Track2() {
        img.scale(img.getWidth() / 20, img.getHeight() / 20);
        setImage(img);
    }  
}
