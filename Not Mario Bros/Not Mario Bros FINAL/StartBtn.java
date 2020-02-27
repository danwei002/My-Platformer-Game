import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartBtn here.
 * Starts the game, sending the player to the level select screen
 * Daniel Wei
 * Jan 18
 */
public class StartBtn extends Actor
{
    /**
     * Act - do whatever the StartBtn wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage btnImg = new GreenfootImage("startbtn.jpg");
    public void act() 
    {
        // Add your action code here.
    }    
    
    public StartBtn() {
        btnImg.scale(btnImg.getWidth() / 3, btnImg.getHeight() / 3);
        setImage(btnImg);
    }
}
