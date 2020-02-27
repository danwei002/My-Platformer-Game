import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Flag here.
 * Flag that marks the end of a level, taking the player back to the level select screen from a level
 * Daniel Wei
 * Jan 18
 */
public class Flag extends Actor
{
    /**
     * Act - do whatever the Flag wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage flagImg = getImage();
    public void act() 
    {
        // Add your action code here.
    }    
    
    public Flag() {
        flagImg.scale(flagImg.getWidth() / 5, flagImg.getHeight()/ 5);
        setImage(flagImg);
    }
    
    // Used to check if Mario has reached the flag
    public Object getObject() {
        return getOneObjectAtOffset(0, 0, null); 
    }
}
