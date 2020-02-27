import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Track3 here.
 * Switches the soundtrack in the menu screen to Soundtrack 3 on collision with Mario
 * Jan 18
 * Daniel Wei
 */
public class Track3 extends Actor
{
    /**
     * Act - do whatever the Track3 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage img = new GreenfootImage("track3.png");
    public void act() 
    {
        // Add your action code here.
    }    
    
    public Track3() {
        img.scale(img.getWidth() / 20, img.getHeight() / 20);
        setImage(img);
    }  
}
