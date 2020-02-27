import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Instructions here.
 * This is the box appears to display the instructions when the button is hit
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Instructions extends Actor
{
    /**
     * Act - do whatever the Instructions wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage img = new GreenfootImage("Instructions.png");
    public Instructions() {
        img.scale(img.getWidth()/2, img.getHeight()/2);
        setImage(img);
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
}
