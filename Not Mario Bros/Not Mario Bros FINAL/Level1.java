import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level1 here.
 * Level 1 of 6
 * Daniel Wei
 * Jan 18
 */
public class Level1 extends World
{

    /**
     * Constructor for objects of class Level1.
     * 
     */
    private GreenfootImage bkgrnd = new GreenfootImage("menuscreen.png");
    private GreenfootImage brickfloor = new GreenfootImage("brickfloor.png");
    private GreenfootSound theme = new GreenfootSound("Level1.mp3");
    Mario mario;
    Flag flag;
    // Generate the level and position/add the blocks, mario, flag, and ground
    public Level1()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        bkgrnd.scale(600, 400);
        setBackground(bkgrnd);
        
        Ground ground = new Ground();
        brickfloor.scale(getWidth(), brickfloor.getHeight() + 5);
        ground.setImage(brickfloor);
        addObject(ground, getWidth()/2, getHeight() - ground.getImage().getHeight()/2);
        
        mario = new Mario();
        addObject(mario, 25, getHeight() - ground.getImage().getHeight() - 15);
        

        for (int i = 0; i < 3; i++) {
            Block block = new Block();
            addObject(block, getWidth()/5 + block.getImage().getWidth() * i, getHeight() - 125);
        }
        
        for (int i = 0; i < 3; i++) {
            Block block = new Block();
            addObject(block, getWidth()/9 + block.getImage().getWidth() * i, getHeight() - 200);
        }
        
        for (int i = 0; i < 1; i++) {
            Block block = new Block();
            addObject(block, block.getImage().getWidth(), getHeight() - 280);
        }
        
        for (int i = 0; i < 3; i++) {
            Block block = new Block();
            addObject(block, getWidth()/5 + block.getImage().getWidth() * i - 25, getHeight() - 330);
        }
        
        MovingPlatform movingPlat = new MovingPlatform(getWidth()/5 + 75);
        addObject(movingPlat, getWidth()/5 + 75, getHeight() - 330);
        
        for (int i = 0; i < 4; i++) {
            Block block = new Block();
            addObject(block, getWidth()/5 + 215 + block.getImage().getWidth() * i, getHeight() - 330);
        }
        
        Block block2 = new Block();
        addObject(block2, getWidth()/5 + 325, getHeight() - 310);
        
        for (int i = 0; i < 3; i++) {
            Block block = new Block();
            addObject(block, getWidth()/5 + 385 + block.getImage().getWidth() * i, getHeight() - 330);
        }
        
        for (int i = 0; i < 3; i++) {
            Block block = new Block();
            addObject(block, getWidth()/5 + 385 + block.getImage().getWidth() * i, getHeight() - 230);
        }
        
        flag = new Flag();
        addObject(flag, getWidth()/5 + 385 + block2.getImage().getWidth(), getHeight() - 260);
        
        theme.setVolume(50);
        theme.playLoop();
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
