import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level6 here.
 * The most annoying level in this game (Level 6 of 6)
 * Daniel Wei
 * Jan 18
 */
public class Level6 extends World
{

    /**
     * Constructor for objects of class Level6.
     * 
     */
    private GreenfootSound theme = new GreenfootSound("Level6.mp3");
    private GreenfootImage snowfloor = new GreenfootImage("snowfloor.png");
    
    // Below: Mario and all the blocks that are in this level
    // Jebait blocks are blocks that move upon contact with Mario
    Mario mario;
    Flag flag;
    MovingPlatform move1;
    Block jebait1 = new Block();
    Block jebait2 = new Block();
    Block jebait3 = new Block();
    Block jebait4 = new Block();
    Block jebait5 = new Block();
    Block jebait6 = new Block();
    Block jebait7 = new Block();
    Block jebait8 = new Block();
    Block jebait9 = new Block();
    Block jebait10 = new Block();
    Block jebait11 = new Block();
    Block jebait12 = new Block();
    
    Block spawner = new Block();
    
    int jebait1Y = getHeight() - 250;
    int jebait2Y = getHeight() - 300;
    int jebait3Y = getHeight() - 380;
    int jebait4Y = getHeight() - 460;
    int jebait5X = getWidth()/3 * 2 + 35;
    int jebait6X = getWidth() /3 * 2 + 85;
    int jebait7X = getWidth()/3 * 2 + 85 - jebait7.getImage().getWidth();
    int jebait8X = jebait7X - jebait8.getImage().getWidth();
    int jebait9Y = getHeight() - 660;
    
    // Set the positions of the ground and all the blocks in the level, as well as start the music
    public Level6()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 800, 1); 
        theme.setVolume(70);
        theme.playLoop();
        
        Ground ground = new Ground();
        snowfloor.scale(getWidth(), (snowfloor.getHeight() + 5) * 3);
        ground.setImage(snowfloor);
        addObject(ground, getWidth()/2, getHeight() - ground.getImage().getHeight()/2);
        
        mario = new Mario();
        addObject(mario, 25, getHeight() - ground.getImage().getHeight() - 15);
        
        for (int i = 0; i < 2; i++) {
            Block block = new Block();
            addObject(block, getWidth()/4 + block.getImage().getWidth() * i, getHeight() - 175);
        }
        
        addObject(jebait1, getWidth()/3, jebait1Y);
        addObject(jebait2, getWidth()/3 + 80, jebait2Y);
        
        for (int i = 0; i < 4; i++) {
            if (i != 2) {
                Block block = new Block();
                addObject(block, getWidth()/3 + 120 + block.getImage().getWidth() * i, getHeight() - 380);
            } else {
                addObject(jebait3, getWidth()/3 + 120 + jebait3.getImage().getWidth() * 2, getHeight() - 380);
            }
        }
        
        addObject(jebait4, getWidth()/3 * 2, jebait4Y);
        addObject(jebait5, jebait5X, jebait4Y);
        
        for (int i = 0; i < 1; i++) {
            Block block = new Block();
            addObject(block, jebait5X + 30, getHeight() - 485);
        }
        
        MovingVerticalPlatform vert1 = new MovingVerticalPlatform(getHeight() - 525);
        addObject(vert1, jebait5X + 100, getHeight() - 525);
        
        addObject(jebait6, jebait6X, getHeight() - 640);
        addObject(jebait7, jebait7X, getHeight() - 640);
        addObject(jebait8, jebait8X, getHeight() - 640);
        
        Block safe = new Block();
        addObject(safe, jebait8X - safe.getImage().getWidth(), getHeight() - 640);
        
        for (int i = 0; i < 3; i++) {
            Block block = new Block();
            addObject(block, safe.getX() - 60 - block.getImage().getWidth() * i, getHeight() - 700);
        }
        
        addObject(jebait9, getWidth()/2 - 30 - jebait9.getImage().getWidth() * 2, getHeight() - 660);
        addObject(jebait10, getWidth()/2 - 30 - jebait9.getImage().getWidth() * 3, getHeight() - 660);
        addObject(jebait11, getWidth()/2 - 30 - jebait9.getImage().getWidth() * 5, getHeight() - 660);
        addObject(jebait12, getWidth()/2 - 30 - jebait9.getImage().getWidth() * 6, getHeight() - 660);
        
        for (int i = 0; i < 12; i++) {
            if (i != 2 && i != 3 && i!=5 && i!=6) {
                Block block = new Block();
                addObject(block, getWidth()/2 - 30 - block.getImage().getWidth() * i, getHeight() - 660);
            }
        }
        
        
        
        for (int i = 0; i < 1; i++) {
            Block block = new Block();
            addObject(block, block.getImage().getWidth() + 10 + block.getImage().getWidth() * 1, getHeight() - 460);
        }
        
        addObject(spawner, spawner.getImage().getWidth() + 10, getHeight() - 460);
        
        
    }
    
    int turnTrack = 0;
    boolean spawned = false;
    // Act checks for collision with "jebait" blocks so that they move
    public void act() {
        if (jebait1.upCollision() instanceof Mario) {
            jebait1.setLocation(jebait1.getX(), jebait1.getY() + 1);
        } else {
            if (jebait1.getY() > jebait1Y) {
                jebait1.setLocation(jebait1.getX(), jebait1.getY() - 1);
            }
        }
        
        if (jebait2.upCollision() instanceof Mario) {
            jebait2.setLocation(jebait2.getX(), jebait2.getY() + 2);
        } else {
            if (jebait2.getY() > jebait2Y) {
                jebait2.setLocation(jebait2.getX(), jebait2.getY() - 1);
            }
        }
        
        if (jebait3.upCollision() instanceof Mario) {
            jebait3.setLocation(jebait3.getX(), jebait3.getY() + 7);
        } else {
            if (jebait3.getY() > jebait3Y) {
                jebait3.setLocation(jebait3.getX(), jebait3.getY() - 2);
            }
        }
        
        if (jebait4.upCollision() instanceof Mario) {
            jebait4.setLocation(jebait4.getX(), jebait4.getY() + 1);
        } else {
            if (jebait4.getY() > jebait4Y) {
                jebait4.setLocation(jebait4.getX(), jebait4.getY() - 1);
            }
        }
        
        if (jebait5.upCollision() instanceof Mario) {
            jebait5.setLocation(jebait5.getX() - 3, jebait5.getY());
        } else {
            if (jebait5.getX() < jebait5X) {
                jebait5.setLocation(jebait5.getX() + 1, jebait5.getY());
            }
        }
        
        if (jebait6.upCollision() instanceof Mario) {
            jebait6.setLocation(jebait6.getX() - 6, jebait6.getY());
        } else {
            if (jebait6.getX() < jebait6X) {
                jebait6.setLocation(jebait6.getX() + 1, jebait6.getY());
            }
        }
        
        if (jebait7.upCollision() instanceof Mario) {
            jebait7.setLocation(jebait7.getX() - 6, jebait7.getY());
        } else {
            if (jebait7.getX() < jebait7X) {
                jebait7.setLocation(jebait7.getX() + 1, jebait7.getY());
            }
        }
        
        if (jebait8.upCollision() instanceof Mario) {
            jebait8.setLocation(jebait8.getX() - 6, jebait8.getY());
        } else {
            if (jebait8.getX() < jebait8X) {
                jebait8.setLocation(jebait8.getX() + 1, jebait8.getY());
            }
        }
        
        if (jebait9.upCollision() instanceof Mario) {
            jebait9.setLocation(jebait9.getX(), jebait9.getY() + 5);
        } else {
            if (jebait9.getY() > jebait9Y) {
                jebait9.setLocation(jebait9.getX(), jebait9.getY() - 1);
            }
        }
        
        if (jebait10.upCollision() instanceof Mario) {
            jebait10.setLocation(jebait10.getX(), jebait10.getY() + 5);
        } else {
            if (jebait10.getY() > jebait9Y) {
                jebait10.setLocation(jebait10.getX(), jebait10.getY() - 1);
            }
        }
        
        if (jebait11.upCollision() instanceof Mario) {
            jebait11.setLocation(jebait11.getX(), jebait11.getY() + 5);
        } else {
            if (jebait11.getY() > jebait9Y) {
                jebait11.setLocation(jebait11.getX(), jebait11.getY() - 1);
            }
        }
        
        if (jebait12.upCollision() instanceof Mario) {
            jebait12.setLocation(jebait12.getX(), jebait12.getY() + 5);
        } else {
            if (jebait12.getY() > jebait9Y) {
                jebait12.setLocation(jebait12.getX(), jebait12.getY() - 1);
            }
        }
        
        if (spawned) {
            if (move1.upCollision() instanceof Mario) {
                move1.turn(10);
                turnTrack+=10;
            } else {
                if (turnTrack > 0) {
                    move1.turn(-10);
                    turnTrack -= 10;
                }
            }
            
            if (flag.getObject() instanceof Mario) {
                theme.stop();
                Greenfoot.setWorld(new LevelClear());
            }
        }
        
        if (spawner.upCollision() instanceof Mario && !spawned) {
            move1 = new MovingPlatform(jebait1.getImage().getWidth() + 10 + jebait1.getImage().getWidth() + 25);
            addObject(move1, jebait1.getImage().getWidth() + 10 + jebait1.getImage().getWidth() + 25, getHeight() - 460);
        
            MovingPlatform move2 = new MovingPlatform(jebait1.getImage().getWidth() + 10 + jebait1.getImage().getWidth() + 25);
            addObject(move2, jebait1.getImage().getWidth() + 10 + jebait1.getImage().getWidth() + 25, getHeight() - 540);
            
            mario.platMoveState();
            for (int i = 0; i < 3; i++) {
                Block block = new Block();
                addObject(block, move2.getX() + 130 + block.getImage().getWidth() * i, getHeight() - 500);
            }
            
            spawned = true;
            
            flag = new Flag();
            addObject(flag, move2.getX() + 130 + jebait1.getImage().getWidth() * 1, getHeight() - 530);
        }
        
        if (Greenfoot.isKeyDown("escape")) {
            theme.stop();
            Greenfoot.setWorld(new LevelSelect());
        }
    }
}
