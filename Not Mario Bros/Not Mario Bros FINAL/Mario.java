import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Mario here.
 * Mario is the character that the player controls
 * Mario's goal is to run and jump across platforms to reach the end goal (flag)
 * Daniel Wei
 * Jan 18
 */
public class Mario extends Actor
{
    /**
     * Act - do whatever the Mario wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private GreenfootImage leftMario = new GreenfootImage("mariostandleft.png");
    private GreenfootImage rightMario = new GreenfootImage("mariostand.png");
    private GreenfootImage jumpMario = new GreenfootImage("mariojump.png");
    private GreenfootImage jumpMarioLeft = new GreenfootImage("mariojumpleft.png");
    private int frameTracker = 1;
    
    /* The following variables below control the following:
     * Mario's physics (jumping, acceleration, gravity)
     * Mario's collision (running into blocks, jumping into blocks, riding moving platforms)
     */
    private boolean jumped = false;
    private int fallSpeed = 1;
    private final int maxJumpHeight = 80;
    private int jumpVelocity = 13;
    private int maxMoveSpeed = 3;
    private final int sprintMaxMoveSpeed = 6;
    private final int defaultMaxMoveSpeed = 3;
    private int moveSpeed = 1;
    private final int defaultJumpVelocity = jumpVelocity;
    private final int defaultHighJumpVelocity = 25;
    private int startY;
    private final int maxFallVelocity = 8;
    private boolean onGround = true;
    private boolean touchingPlatform = false;
    private int moveR = 0;
    private int moveL = 0;
    private boolean upBlocked = false;
    private boolean leftBlocked = false;
    private boolean rightBlocked = false;
    private boolean falling = false;
    private int platMoveTracker = 0;
    private boolean platLeft = false;
    private boolean platRight = true;
    private boolean facingLeft = false;
    private boolean facingRight = true;
    
    // The following variables control the running animation for Mario
    private GreenfootImage[] runAnimation = {new GreenfootImage("runmario1.png"), new GreenfootImage("runmario2.png"), new GreenfootImage("runmario3.png")};
    private GreenfootImage[] leftRunAnimation = {new GreenfootImage("leftrunmario1.png"), new GreenfootImage("leftrunmario2.png"), new GreenfootImage("leftrunmario3.png")};
    private int animationTracker = 0;
    private int animationTracker2 = 0;
    private String lastKeyPress;
    public void act() 
    {
        
        // This if-else tracks the current movement state of horizontal moving platforms (left or right)
        if (platMoveTracker > 100) {
            platLeft = true;
            platRight = false;
        } else if (platMoveTracker < 0) {
            platLeft = false;
            platRight = true;
        }
        
        if (platLeft) {
            platMoveTracker--;
        } else if (platRight) {
            platMoveTracker++;
        }
        
        // The following if statements check Mario's collision with blocks/platforms/ground, but not the flag
        if (upCollision() != null && !(upCollision() instanceof Flag)) {
            upBlocked = true;
        } 
        
        if (rightCollision() != null && !(rightCollision() instanceof Flag)) {
            rightBlocked = true;
        }
        
        if (leftCollision() != null && !(leftCollision() instanceof Flag)) {
            leftBlocked = true;
        }
        
        // This if statement checks if Mario is in midair or standing on something solid
        if (downCollision() != null && !(downCollision() instanceof Flag)) {
            falling = false;
            
        } else {
            falling = true;
        }
        
        // If mario is not falling, check if he is riding a horizontal or vertical moving platform
        if (!falling) {
            
            if (downCollision() instanceof MovingPlatform) {
                if (platRight) {
                    setLocation(getX() + 1, getY());
                } else if (platLeft) {
                    setLocation(getX() - 1, getY());
                }
            } else if (downCollision() instanceof MovingVerticalPlatform) {
                setLocation(getX(), getY() - 2);
            } else {
                setLocation(getX(), getY() - 1);
            }
        }
        
        /* This executes when the user inputs the jump key
         * The jump works as follows:
         * Mario's jump velocity starts at a set value, then decreases over time
         * This makes his jumping realistic to the real world, start off faster and slow down as you reach the apex
         * of your jump
         */
        if (jumped) {
            
            jump(jumpVelocity);
            jumpVelocity--;
            if (jumpVelocity <= 0) {
                jumped = false;
            }
            
            // This will stop Mario's upward jump momentum if it detects that his above is blocked
            if (upBlocked) {
                setLocation(getX(), getY() + 1);
                jumped = false;
                upBlocked = false;
                jumpVelocity = defaultJumpVelocity;
            }
        }
        
        // This statement accelerates Mario's fall to a max velocity (maxFallVelocity) if he is not 
        // in a jumping state
        if (falling && !jumped) {
            
            setLocation(getX(), getY() + fallSpeed);
            if (fallSpeed < maxFallVelocity) {
                fallSpeed += 1;
            }
        } else {
            fallSpeed = 0;
        }
        
        /* This checks if Mario is able to jump.
         * If Mario is not falling, is on a solid object, and is not currently in a jumping state,
         * he can jump.
         */
        if (!falling && !jumped) {
            if (Greenfoot.isKeyDown("space")) {
                jumped = true;
                onGround = false;
                jumpVelocity = defaultJumpVelocity;
                
            }
        }
        
        // Checks if Mario's right is blocked, if it is, it pushes him backward out of the object
        if (rightBlocked) {
            moveSpeed = 0;
            setLocation(getX() - 1, getY());
            rightBlocked = false;
        }
        
        // Checks if Mario's left is blocked, if it is, it pushes him backward out of the object
        if (leftBlocked) {
            moveSpeed = 0;
            setLocation(getX() + 1, getY());
            leftBlocked = false;
        }
        
        
        // This code is Mario's left-right movement acceleration code, as well as his animation code
        // Mario is able to run up to his max move speed, or his sprint max move speed if shift is held
        if (Greenfoot.isKeyDown("left") && !leftBlocked) {
            setLocation(getX() - moveSpeed, getY());
            facingLeft = true;
            facingRight = false;
            //setImage(leftMario); 
            setImage(leftRunAnimation[animationTracker2/3]);
            if (Greenfoot.isKeyDown("shift")) {
                maxMoveSpeed = sprintMaxMoveSpeed;
            } else {
                maxMoveSpeed = defaultMaxMoveSpeed;
                moveSpeed = defaultMaxMoveSpeed;
            }
            
            if(moveSpeed < maxMoveSpeed && moveL % 6 == 0) {
                moveSpeed++;
                moveL = 0;
            }
            animationTracker2++;
            moveL++;
            
            if (animationTracker2 > 6) {
                animationTracker2 = 0;
            }
        } else if (Greenfoot.isKeyDown("right") && !rightBlocked) {
            setLocation(getX() + moveSpeed, getY());
            facingLeft = false;
            facingRight = true;
            // setImage(rightMario);
            setImage(runAnimation[animationTracker/3]);
            if (Greenfoot.isKeyDown("shift")) {
                maxMoveSpeed = sprintMaxMoveSpeed;
            } else {
                maxMoveSpeed = defaultMaxMoveSpeed;
                moveSpeed = defaultMaxMoveSpeed;
            }
            
            if (moveSpeed < maxMoveSpeed && moveR % 6 == 0) {
                moveSpeed++;
                moveR = 0;
            }
            animationTracker++;
            moveR++;
            
            if (animationTracker > 6) {
                animationTracker = 0;
            }
        } else {
            if (getImage() == leftMario) {
                setLocation(getX() - moveSpeed,getY());
            }
            
            if (getImage() == rightMario) {
                setLocation(getX() + moveSpeed, getY());
            }
            
            if (moveSpeed > 0) {
                moveSpeed--;
            }
            
            
        }
        
        // This code switches between Mario's jumping sprite and his default movement sprite
        if (jumped) {
            if (facingRight) {
                setImage(jumpMario);
            } else if (facingLeft) {
                setImage(jumpMarioLeft);
            }
        } else if (!Greenfoot.isKeyDown("left") && !Greenfoot.isKeyDown("right")) {
            if (facingRight) {
                GreenfootImage defaultImg = new GreenfootImage("mariostand.png");
                defaultImg.scale(defaultImg.getWidth() * 3 / 2, defaultImg.getHeight() * 3 / 2);
                setImage(defaultImg);
            } else {
                GreenfootImage defaultImg = new GreenfootImage("mariostandleft.png");
                defaultImg.scale(defaultImg.getWidth() * 3 / 2, defaultImg.getHeight() * 3 / 2);
                setImage(defaultImg);
                
            }
        }
    }    
    
    public Mario() {
       
       // Scaling mario's movement and jump frames
       rightMario.scale(rightMario.getWidth() / 7, rightMario.getHeight() / 7);
       leftMario.scale(leftMario.getWidth() / 10, leftMario.getHeight() / 10);
       runAnimation[0].scale(runAnimation[0].getWidth() * 3 / 2, runAnimation[0].getHeight() * 3 / 2);
       runAnimation[1].scale(runAnimation[1].getWidth() * 3 / 2, runAnimation[1].getHeight() * 3 / 2);
       runAnimation[2].scale(runAnimation[2].getWidth() * 3 / 2, runAnimation[2].getHeight() * 3 / 2);
       leftRunAnimation[0].scale(leftRunAnimation[0].getWidth() * 3 / 2, leftRunAnimation[0].getHeight() * 3 / 2);
       leftRunAnimation[1].scale(leftRunAnimation[1].getWidth() * 3 / 2, leftRunAnimation[1].getHeight() * 3 / 2);
       leftRunAnimation[2].scale(leftRunAnimation[2].getWidth() * 3 / 2, leftRunAnimation[2].getHeight() * 3 / 2);
       jumpMario.scale(jumpMario.getWidth() * 3 / 2, jumpMario.getHeight() * 3 / 2);
       jumpMarioLeft.scale(jumpMarioLeft.getWidth() * 3 / 2, jumpMarioLeft.getHeight() * 3 / 2);
       
       
       GreenfootImage defaultImg = new GreenfootImage("mariostand.png");
       defaultImg.scale(defaultImg.getWidth() * 3 / 2, defaultImg.getHeight() * 3 / 2);
       setImage(defaultImg);
    }
    
    
    
    // Making mario jump upward at upSpeed
    public void jump(int upSpeed) {
        setLocation(getX(), getY() - upSpeed);
    }
    
    // Collision at Mario's feet
    public Object downCollision() {
        return getOneObjectAtOffset(0, getImage().getHeight()/2, null);
    }
    
    // Collision at Mario's head
    public Object upCollision() {
        return getOneObjectAtOffset(0, -getImage().getHeight(), null);
    }
    
    // Collision at Mario's rightside
    public Object rightCollision() {
        return getOneObjectAtOffset(getImage().getWidth()/2, 0, null);
    }
    
    // Collision at Mario's leftside
    public Object leftCollision() {
        return getOneObjectAtOffset(-getImage().getWidth()/2, 0, null);
    }
    
    // Resets platform move state (only used in Level 6)
    public void platMoveState() {
        platMoveTracker = 0;
    }
}
