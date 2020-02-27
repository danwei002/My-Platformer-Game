import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level4 here.
 * Level 4 of 6
 * Daniel Wei
 * Jan 18
 */
public class Level4 extends World
{

    /**
     * Constructor for objects of class Level4.
     * 
     */
    private GreenfootImage bkgrnd = new GreenfootImage("Level4.png");
    private GreenfootImage brickfloor = new GreenfootImage("brickfloor2.png");
    private GreenfootSound theme = new GreenfootSound("Level4.mp3");
    
    // Blocks and objects used in the level, spooky blocks trigger the normal block spawns
    Mario mario;
    Block spooky1;
    Block spooky2;
    Block spooky3;
    Block spooky4;
    Block spooky5;
    Block checkpoint;
    
    Block block = new Block();
    Block block2 = new Block();
    Block block3 = new Block();
    Block block4 = new Block();
    Block block5 = new Block();
    Block block6 = new Block();
    Block block7 = new Block();
    Block block8 = new Block();
    Block block9 = new Block();
    Block block10 = new Block();
    
    Flag flag = new Flag();
    
    // Checks whether a set of blocks have spawned yet
    boolean spawned1 = false;
    boolean spawned2 = false;
    boolean spawned4 = false;
    boolean spawned5 = false;
    
    // Sets all the blocks, ground, and Mario's position and adds them
    public Level4()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 800, 1); 
        bkgrnd.scale(1200, 900);
        setBackground(bkgrnd);
        
        theme.setVolume(70);
        theme.playLoop();
        
        Ground ground = new Ground();
        brickfloor.scale(getWidth(), brickfloor.getHeight() + 5);
        ground.setImage(brickfloor);
        addObject(ground, getWidth()/2, getHeight() - ground.getImage().getHeight()/2);
        
        mario = new Mario();
        addObject(mario, 25, getHeight() - ground.getImage().getHeight() - 15);
                
        spooky1 = new Block();
        addObject(spooky1, getWidth()/2, getHeight() - 125);
                        
        spooky2 = new Block();
        addObject(spooky2, getWidth()/2 - 150, getHeight() - 205);
        
        spooky3 = new Block();
        addObject(spooky3, getWidth()/2 - 210, getHeight() - 420);
        
        spooky4 = new Block();
        addObject(spooky4, getWidth() - 180, getHeight() - 520);
        
        spooky5 = new Block();
        addObject(spooky5, getWidth() - 90, getHeight() - 720);
        
        for (int i = 0; i < 12; i++) {
            Block block = new Block();
            addObject(block, getWidth()/2 + 60 - block.getImage().getWidth() * i, getHeight() - 460);
        }
        
        for (int i = 0; i < 3; i++) {
            Block block = new Block();
            addObject(block, getWidth() - 460 - block.getImage().getWidth() * i, getHeight() - 740);
        }
        
        addObject(flag, getWidth() - 490, getHeight() - 770);
    }
    
    private int track1 = 0;
    private int track2 = 0;
    private int track4 = 0;
    private int track5 = 0;
    // Checks collision with "spooky" blocks and the flag
    public void act() {
        
        if (flag.getObject() instanceof Mario) {
            theme.stop();
            Greenfoot.setWorld(new LevelClear());
        }
        
        if (spooky1.upCollision() instanceof Mario && !spawned1) {           
            block = new Block();
            addObject(block, getWidth()/2 - 70, getHeight() - 175);
            spawned1 = true;
            
        }
        
        if (spawned1) {
            track1++;           
            if (track1 > 100) {
                spawned1 = false;
                removeObject(block);
                track1 = 0;
            }
        }
        
        if (spooky2.upCollision() instanceof Mario && !spawned2) {
            block2 = new Block();
            addObject(block2, getWidth()/2 - 200, getHeight() - 285);
            spawned2 = true;
            
            block3 = new Block();
            addObject(block3, getWidth()/2 - 260, getHeight() - 360);
        }
        
        if (spawned2) {
            track2++;
            if (track2 > 200) {
                spawned2 = false;
                removeObject(block2);
                removeObject(block3);
                track2 = 0;
            }    
        }
        
        if (spooky4.upCollision() instanceof Mario && !spawned4) {
            block4 = new Block();
            block5 = new Block();
            block6 = new Block();
            
            addObject(block4, getWidth() - 140, getHeight() - 560);
            addObject(block5, getWidth() - 70, getHeight() - 630);
            addObject(block6, getWidth() - 20, getHeight() - 700);
            
            spawned4 = true;
        }
        
        if (spawned4) {
            track4++;
            if (track4 > 250) {
                spawned4 = false;
                removeObject(block4);
                removeObject(block5);
                removeObject(block6);
                track4 = 0;
            }
        }
        
        if (spooky5.upCollision() instanceof Mario && !spawned5) {
            block7 = new Block();
            block8 = new Block();
            block9 = new Block();
            block10 = new Block();
            
            addObject(block7, getWidth() - 160, getHeight() - 720);
            addObject(block8, getWidth() - 230, getHeight() - 720);
            addObject(block9, getWidth() - 300, getHeight() - 720);
            addObject(block10, getWidth() - 380, getHeight() - 720);
            
            spawned5 = true;
        }
        
        if (spawned5) {
            track5++;
            if (track5 > 350) {
                track5 = 0;
                removeObject(block7);
                removeObject(block8);
                removeObject(block9);
                removeObject(block10);
                spawned5 = false;
            }
        }
        
        if (Greenfoot.isKeyDown("escape")) {
            theme.stop();
            Greenfoot.setWorld(new LevelSelect());
        }
    }
}
