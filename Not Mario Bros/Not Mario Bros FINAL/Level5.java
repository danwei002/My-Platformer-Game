import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Level5 here.
 * Level 5 of 6
 * Daniel Wei
 * Jan 18
 */
public class Level5 extends World
{

    /**
     * Constructor for objects of class Level5.
     * 
     */
    private GreenfootSound theme = new GreenfootSound("Level5.mp3");
    private GreenfootImage floor = new GreenfootImage("floor3.png");
    
    // Mario and the flag
    // Block2 is the trigger that spawns another part of the level upon collision with Mario
    Mario mario;
    Block block2;
    Flag flag;
    
    // Set the positions and add the blocks, flag, Mario, and the ground
    public Level5()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 800, 1); 
        theme.setVolume(70);
        theme.playLoop();
        
        
        
        Ground ground = new Ground();
        floor.scale(getWidth(), (floor.getHeight() + 5) / 3);
        ground.setImage(floor);
        addObject(ground, getWidth()/2, getHeight() - ground.getImage().getHeight()/2);
        
        mario = new Mario();
        addObject(mario, 25, getHeight() - ground.getImage().getHeight() - 15);
        
        for (int i = 0; i < 8; i++) {
            Block block = new Block();
            addObject(block, getWidth()/7 + block.getImage().getWidth() * i, getHeight() - 125);
        }
        
        for (int i = 0; i < 2; i++) {
            Block block = new Block();
            addObject(block, getWidth()/2 + 10 + block.getImage().getWidth() * i, getHeight() - 205);
        }
        
        for (int i = 0; i < 2; i++) {
            Block block = new Block();
            addObject(block, getWidth()/7 * 5 + 10 + block.getImage().getWidth() * i, getHeight() - 285);
        }
        
        for (int i = 0; i < 2; i++) {
            Block block = new Block();
            addObject(block, getWidth() - 40 - block.getImage().getWidth() * i, getHeight() - 365);
        }
        
        for (int i = 0; i < 2; i++) {
            Block block = new Block();
            addObject(block, getWidth()/7 * 6 + 10 - block.getImage().getWidth() * i, getHeight() - 445);
        }
        
        
        
        MovingVerticalPlatform move1 = new MovingVerticalPlatform(getHeight() - 465);
        addObject(move1, getWidth()/7 * 5 - 10, getHeight() - 465);
        
        for (int i = 0; i < 12; i++) {
            if (i != 11 && i != 10) {
                Block block = new Block();
                addObject(block, getWidth()/7 * 5 - 48, getHeight() - 445 - block.getImage().getHeight() * i);
            }
        }
        
        MovingVerticalPlatform move2 = new MovingVerticalPlatform(getHeight() - 615);
        move2.goDown();
        addObject(move2, getWidth()/7 * 4 - 10, getHeight() - 615);
        
        for (int i = 0; i < 12; i++) {
            if (i != 6 && i != 7) {
                Block block = new Block();
                addObject(block, getWidth()/7 * 4 - 48, getHeight() - 445 - block.getImage().getHeight() * i);
            }
        }
        
        MovingVerticalPlatform move3 = new MovingVerticalPlatform(getHeight() - 465);        
        addObject(move3, getWidth()/7 * 3 - 10, getHeight() - 465);
        
        for (int i = 0; i < 12; i++) {
            if (i != 2 && i!= 3 && i != 4) {
                Block block = new Block();
                addObject(block, getWidth()/7 * 3 - 48, getHeight() - 445 - block.getImage().getHeight() * i);
            }
        }
        
        MovingVerticalPlatform move4 = new MovingVerticalPlatform(getHeight() - 615);
        move4.goDown();
        addObject(move4, getWidth()/7 * 2 - 10, getHeight() - 615);
        
        for (int i = 0; i < 12; i++) {
            if (i != 1 && i != 2 && i != 3) {
                Block block = new Block();
                addObject(block, getWidth()/7 * 2 - 48, getHeight() - 445 - block.getImage().getHeight() * i);
            }
        }
        
        MovingVerticalPlatform move5 = new MovingVerticalPlatform(getHeight() - 465);        
        addObject(move5, getWidth()/7 - 10, getHeight() - 465);
        
        for (int i = 0; i < 24; i++) {
            Block block = new Block();
            addObject(block, getWidth()/7 * 2 - 48 + block.getImage().getWidth() * (i - 4), getHeight() - 445 - block.getImage().getHeight() * 12);
        }
        
        
        block2 = new Block();
        addObject(block2, block2.getImage().getWidth() + 5, getHeight() - 305 - block2.getImage().getHeight() * 12);
        
        flag = new Flag();
        addObject(flag, getWidth()/4, getHeight() - 445 - block2.getImage().getHeight() * 12 - 30);
        
    }
    
    // Boolean spawned checks whether the second part of the level has spawned yet
    boolean spawned = false;
    public void act() {
        if (flag.getObject() instanceof Mario) {
            theme.stop();
            Greenfoot.setWorld(new LevelClear());
        }
        
        if (Greenfoot.isKeyDown("escape")) {
            theme.stop();
            Greenfoot.setWorld(new LevelSelect());
        }
        
        // Spawns the second part of the level
        if (block2.upCollision() instanceof Mario && !spawned) {
            for (int i = 0; i < 2; i++) {
                Block block = new Block();
                addObject(block, getWidth()/7 * 6 + 60 - block.getImage().getWidth() * i, getHeight() - 515);
            }
            
            for (int i = 0; i < 2; i++) {
                Block block = new Block();
                addObject(block, getWidth()/7 * 6 - 20 - block.getImage().getWidth() * i, getHeight() - 575);
            }
            
            for (int i = 0; i < 2; i++) {
                Block block = new Block();
                addObject(block, getWidth()/7 * 6 + 60 - block.getImage().getWidth() * i, getHeight() - 645);
            }
            
            for (int i = 0; i < 2; i++) {
                Block block = new Block();
                addObject(block, getWidth()/7 * 6 - block.getImage().getWidth() * i, getHeight() - 725);
            }
            
            for (int i = 0; i < 2; i++) {
                Block block = new Block();
                addObject(block, getWidth()/7  + block.getImage().getWidth() * i, getHeight() - 365);
            }
            
            for (int i = 0; i < 2; i++) {
                Block block = new Block();
                addObject(block, getWidth()/7 * 2  + block.getImage().getWidth() * i, getHeight() - 305);
            }
            
            for (int i = 0; i < 2; i++) {
                Block block = new Block();
                addObject(block, getWidth()/7 * 3  + block.getImage().getWidth() * i, getHeight() - 365);
            }
            
            for (int i = 0; i < 2; i++) {
                Block block = new Block();
                addObject(block, getWidth()/7 * 4  + block.getImage().getWidth() * i, getHeight() - 305);
            }
            
            for (int i = 0; i < 2; i++) {
                Block block = new Block();
                addObject(block, getWidth()/7 * 5  + block.getImage().getWidth() * i, getHeight() - 365);
            }
            spawned = true;
            
            
        }
    }
}

