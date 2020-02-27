import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MainWorld here.
 * This was a test world used to experiment with Mario's physics
 * Daniel Wei
 * Jan 18
 */
public class MainWorld extends World
{

    /**
     * Constructor for objects of class MainWorld.
     * 
     */
    Mario mario;
    Block block;
    Block block2;
    MovingPlatform move1;
    MovingVerticalPlatform vert1;
    Ground ground;
    
    
    GreenfootImage groundImg = new GreenfootImage("mario ground.png");
    
    public MainWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        mario = new Mario();
        addObject(mario, 10, getHeight() - 50);
        
        block = new Block();
        addObject(block, 150, getHeight() - 75);
        
        block2 = new Block();
        addObject(block2, block.getX() + block.getImage().getWidth(), block.getY());
        
        move1 = new MovingPlatform(block2.getX() + 100);
        addObject(move1, block2.getX() + 100, block2.getY() - 50);
        
        vert1 = new MovingVerticalPlatform(move1.getX() + 50);
        addObject(vert1, move1.getX() + 250, move1.getY());
        
        ground = new Ground();
        groundImg.scale(getWidth(), groundImg.getHeight());
        ground.setImage(groundImg);
        addObject(ground, getWidth()/2, getHeight() - groundImg.getHeight()/2);
        
    }
    
    public void act() { 
        
    }
}
