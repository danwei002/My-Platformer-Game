import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MovingVerticalPlatform here.
 * Moving Platform that moves up and down
 * Daniel Wei
 * Jan 18
 */
public class MovingVerticalPlatform extends Actor
{
    /**
     * Act - do whatever the MovingVerticalPlatform wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage platImg = getImage();
    private int startY;
    private int moveSpeed = 1;
    // These booleans determine the platform's starting movement state
    private boolean goingUp = true;
    private boolean goingDown = false;
    public void act() 
    {
        setLocation(getX(), getY() + moveSpeed);
        // Makes sure the platform doesn't move too far in one direction
        if (goingUp) {
            if (getY() < startY - 150) {
                moveSpeed = -moveSpeed;
            } else if (getY() > startY) {
                moveSpeed = -moveSpeed;
            }
        } else if (goingDown) {
           
            if (getY() > startY + 150) {
                moveSpeed = -moveSpeed;
            } else if (getY() < startY) {
                moveSpeed = -moveSpeed;
            }
        }
    }  
    
    public MovingVerticalPlatform(int startY) {
        platImg.scale(platImg.getWidth() / 10, platImg.getHeight() / 6);
        setImage(platImg);
        
        this.startY = startY;
        
        
    }
    
    // Returns what direction the platform is currently moving in
    public String moveDir() {
        if (moveSpeed > 0) {
            return "up";
        } else {
            return "down";
        }
    }
    
    // Can be referecned to switch a platform into starting by moving down
    public void goDown() {
        goingDown = true;
        goingUp = false;
    }
}
