import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level2 here.
 * Level 2 of 6
 * Jan 18
 * Daniel Wei
 */
public class Level2 extends World
{

    /**
     * Constructor for objects of class Level2.
     * 
     */
    private GreenfootImage background = new GreenfootImage("Level2.png");
    private GreenfootImage brickfloor = new GreenfootImage("brickfloor2.png");
    private GreenfootSound theme = new GreenfootSound("Level2.mp3");
    
    // Mario. the flag, and moving platforms
    // Dummyblock is a placeholder block that is used to get dimensions from
    Mario mario;
    Flag flag;
    MovingVerticalPlatform vert1;
    MovingVerticalPlatform vert2;
    MovingPlatform plat1;
    Block dummyBlock = new Block();
    
    // Generate the level (blocks, and mario, and the flag are positioned and added)
    public Level2()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 800, 1); 
        background.scale(getWidth(), 7000);
        setBackground(background);
        
        Ground ground = new Ground();
        brickfloor.scale(getWidth(), brickfloor.getHeight() + 5);
        ground.setImage(brickfloor);
        addObject(ground, getWidth()/2, getHeight() - ground.getImage().getHeight()/2);
        
        mario = new Mario();
        addObject(mario, 25, getHeight() - ground.getImage().getHeight() - 15);
        
        theme.setVolume(70);
        theme.playLoop();
        
        for (int i = 0; i < 6; i++) {
            Block block = new Block();
            addObject(block, getWidth()/9 + block.getImage().getWidth() * i, getHeight() - 125);
        }
        
        for (int i = 0; i < 3; i++) {
            Block block = new Block();
            addObject(block, getWidth()/2 + block.getImage().getWidth() * i, getHeight() - 175);
        }
        
        vert1 = new MovingVerticalPlatform(getHeight() - 175);
        addObject(vert1, getWidth()/2 + dummyBlock.getImage().getWidth() * 3 + 75, getHeight() - 175);
        
        vert2 = new MovingVerticalPlatform(getHeight() - 475);
        addObject(vert2, getWidth()/2 + dummyBlock.getImage().getWidth() * 3 + 175, getHeight() - 475);
        vert2.goDown();
        
        for (int i = 0; i < 3; i++) {
            Block block = new Block();
            addObject(block, vert2.getX() - 75 - block.getImage().getWidth() * i, getHeight() - 490);
        }
        
        for (int i = 0; i < 3; i++) {
            Block block = new Block();
            addObject(block, getWidth()/2 + 15 - block.getImage().getWidth() * i, getHeight() - 490);
        }
        
        plat1 = new MovingPlatform(getWidth()/2 + 15 - dummyBlock.getImage().getWidth() * 3 - 125);
        addObject(plat1, getWidth()/2 + 15 - dummyBlock.getImage().getWidth() * 3 - 125, getHeight() - 520);
        
        for (int i = 0; i < 3; i++) {
            Block block = new Block();
            addObject(block, 35 + block.getImage().getWidth() * i, getHeight() - 560);
        }
        
        for (int i = 0; i < 3; i++) {
            Block block = new Block();
            addObject(block, 135 + block.getImage().getWidth() * i, getHeight() - 610);
        }
        
        for (int i = 0; i < 5; i++) {
            Block block = new Block();
            addObject(block, 225 + (40 * i), getHeight() - 610 - (30 * i));
        }
        
        for (int i = 0; i < 6; i++) {
            Block block = new Block();
            addObject(block, 445 + block.getImage().getWidth() * i, getHeight() - 700);
        }
        
        flag = new Flag();
        addObject(flag, 425 + dummyBlock.getImage().getWidth() * 5, getHeight() - 730);
    }
    
    
    public void act() {
        if (flag.getObject() instanceof Mario) {
            theme.stop();
            Greenfoot.setWorld(new LevelClear());
        }
        
        if (Greenfoot.isKeyDown("escape")) {
            theme.stop();
            Greenfoot.setWorld(new LevelSelect());
        }
    }
}
