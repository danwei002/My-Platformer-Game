import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MovingPlatform here.
 * This is the horizontal moving platform seen in some levels
 * Daniel Wei
 * Jan 18
 */


public class MovingPlatform extends Actor
{
    /**
     * Act - do whatever the MovingPlatform wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private int startX;
    private int blockMoveSpeed = 1;
    private GreenfootImage platImg = getImage();
    
    public void act() 
    {
        setLocation(getX() + blockMoveSpeed, getY()); 
        // Controls platform movement (makes sure it doesn't move too far in one direction)
        if (getX() > startX + 100) {
            blockMoveSpeed = -blockMoveSpeed;
        } else if (getX() < startX) {
            blockMoveSpeed = -blockMoveSpeed;
        }
    
        
    }    
    
    public MovingPlatform(int startX) {
        platImg.scale(platImg.getWidth() / 10, platImg.getHeight() / 6);
        setImage(platImg);
        
        this.startX = startX;
        
    }
    
    
    // Determines the direction the platform is moving in
    public String moveDir() {
        if (blockMoveSpeed > 0) {
            return "right";
        } else {
            return "left";
        }
    }
    
    // Checks what is standing on the platform
    public Object upCollision() {
        return getOneObjectAtOffset(0, -getImage().getHeight(), null);
    }
}
