import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class InstructBtn here.
 * This is a button on the home screen
 * When hit, it displays the instructions for the game
 * Daniel Wei
 * Jan 18
 */
public class InstructBtn extends Actor
{
    /**
     * Act - do whatever the InstructBtn wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage img = new GreenfootImage("InstructBtn.png");
    public InstructBtn() {
        img.scale(img.getWidth() / 5, img.getHeight() / 5);
        setImage(img);
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
}
