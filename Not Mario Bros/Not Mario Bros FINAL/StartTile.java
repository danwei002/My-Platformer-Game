import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartTile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartTile extends Actor
{
    /**
     * Act - do whatever the StartTile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage img = new GreenfootImage("StartTile.png");
    public void act() 
    {
        // Add your action code here.
    }    
    
    public StartTile() {
        
        img.scale(img.getWidth()/5 * 3, img.getHeight()/5 * 3);
        setImage(img);
    }
}
