import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MusicBtn here.
 * Allows the user to switch music in the menu screen
 * Daniel Wei
 * Jan 18
 */
public class MusicBtn extends Actor
{
    /**
     * Act - do whatever the MusicBtn wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage img = new GreenfootImage("MusicBtn.png");
    public void act() 
    {
        // Add your action code here.
    }   
    
    public MusicBtn() {
        img.scale(img.getWidth()/20, img.getHeight()/20);
        setImage(img);
    }
}
