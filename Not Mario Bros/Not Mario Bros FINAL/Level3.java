import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level3 here.
 * Level 3 of 6
 * Daniel Wei
 * Jan 18
 */
public class Level3 extends World
{

    /**
     * Constructor for objects of class Level3.
     * 
     */
    private GreenfootImage bkgrnd = new GreenfootImage("menuscreen.png");
    private GreenfootImage brickfloor = new GreenfootImage("brickfloor.png");
    private GreenfootSound theme = new GreenfootSound("Level3.mp3");
    
    // Movingplatforms, the flag, and mairo
    Mario mario;
    
    MovingVerticalPlatform vert1;
    MovingPlatform move1;
    MovingPlatform move2;
    Flag flag;
    
    // Generate Level 3 (position and add the blocks, mario, and the flag, and the ground)
    public Level3()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 800, 1); 
        bkgrnd.scale(600, 10000);
        setBackground(bkgrnd);
        
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
            addObject(block, getWidth() - 50 - block.getImage().getWidth() * i, getHeight() - 125);
        }
        
        for (int i = 0; i < 1; i++) {
            Block block = new Block();
            addObject(block, getWidth()/2 + 25, getHeight() - 175);
        }
        
        for (int i = 0; i < 3; i++) {
            Block block = new Block();
            addObject(block, getWidth()/3 - block.getImage().getWidth() * i, getHeight() - 235);
        }
        
        vert1 = new MovingVerticalPlatform(getHeight() - 265);
        addObject(vert1, getWidth()/7, getHeight() - 265);
        
        for (int i = 0; i < 1; i++) {
            Block block = new Block();
            addObject(block, getWidth()/7 - 25, getHeight() - 445);
        }
        
        for (int i = 0; i < 3; i++) {
            Block block = new Block();
            addObject(block, getWidth()/7 - 75 + block.getImage().getWidth() * i, getHeight() - 525);
        }
        
        move1 = new MovingPlatform(getWidth()/7 + 25);
        addObject(move1, getWidth()/7 + 25, getHeight() - 515);
        
        for (int i = 0; i < 5; i++) {
            Block block = new Block();
            addObject(block, getWidth()/7 + 75, getHeight() - 530 - (block.getImage().getHeight() * i));
        }
        
        for (int i = 0; i < 1; i++) {
            Block block = new Block();
            addObject(block, getWidth()/2 - 45, getHeight() - 470);
        }
        
        move2 = new MovingPlatform(getWidth()/2);
        addObject(move2, getWidth()/2, getHeight() - 515);
        
        for (int i = 0; i < 5; i++) {
            Block block = new Block();
            addObject(block, getWidth()/2 + 50, getHeight() - 530 - (block.getImage().getHeight() * i));
        }
        
        for (int i = 0; i < 3; i++) {
            Block block = new Block();
            addObject(block, getWidth() - 130 + block.getImage().getWidth() * i, getHeight() - 530);
        }
        
        for (int i = 0; i < 2; i++) {
            Block block = new Block();
            addObject(block, getWidth() - 90 + block.getImage().getWidth() * i, getHeight() - 590);
        }
        
        for (int i = 0; i < 2; i++) {
            Block block = new Block();
            addObject(block, getWidth() - 110 + block.getImage().getWidth() * i, getHeight() - 670);
        }
        
        for (int i = 0; i < 6; i++) {
            Block block = new Block();
            addObject(block, getWidth() - 200 + block.getImage().getWidth() * i, getHeight() - 720);
        }
        
        for (int i = 0; i < 2; i++) {
            Block block = new Block();
            addObject(block, getWidth() - 330 + block.getImage().getWidth() * i, getHeight() - 720);
        }
        
        for (int i = 0; i < 2; i++) {
            Block block = new Block();
            addObject(block, getWidth() - 430 + block.getImage().getWidth() * i, getHeight() - 720);
        }
        
        for (int i = 0; i < 2; i++) {
            Block block = new Block();
            addObject(block, getWidth() - 530 + block.getImage().getWidth() * i, getHeight() - 720);
        }
        
        flag = new Flag();
        addObject(flag, getWidth() - 535, getHeight() - 750);
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
