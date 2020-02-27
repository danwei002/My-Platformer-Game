import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BackBtn here.
 * Back button to return to main screen from instructions screen
 * Daniel Wei
 * Jan 18
 */
public class BackBtn extends Actor
{
    /**
     * Act - do whatever the BackBtn wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage img = new GreenfootImage("BackBtn.png");
    public BackBtn() {
        img.scale(img.getWidth()/7, img.getHeight()/7);
        setImage(img);
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
}
