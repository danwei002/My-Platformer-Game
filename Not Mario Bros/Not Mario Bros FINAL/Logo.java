import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Logo here.
 * This is the logo seen ("Not Mario Bros") on the main screen
 * Daniel Wei
 * Jan 18
 */
public class Logo extends Actor
{
    /**
     * Act - do whatever the Logo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage img = new GreenfootImage("Logo.png");
    public Logo() {
        img.scale(img.getWidth()/5 * 4, img.getHeight()/5 * 4);
        setImage(img);
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
}
