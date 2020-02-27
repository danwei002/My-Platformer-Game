import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LevelClear here.
 * Screen that displays upon level clear
 * Daniel Wei
 * Jan 18
 */
public class LevelClear extends World
{

    /**
     * Constructor for objects of class LevelClear.
     * 
     */
    private GreenfootImage img = new GreenfootImage("LevelClear.png");
    private GreenfootSound theme = new GreenfootSound("LevelClear.mp3");
    private int delay = 0;
    
    // Creates the screen and sets the volume and plays the clear theme
    public LevelClear()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        img.scale(600, 400);
        setBackground(img);
        theme.setVolume(70);
        theme.play();
       

    }
    
    // Tracks at what point the level clear screen should stop displaying
    public void act() {
        delay++;
        
        if (delay > 220) {
            Greenfoot.setWorld(new LevelSelect());
        }
    }
}
