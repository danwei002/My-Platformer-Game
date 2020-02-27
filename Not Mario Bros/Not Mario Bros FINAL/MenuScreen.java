import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MenuScreen here.
 * Main menu screen of the game
 * Daniel Wei
 * Jan 18
 */
public class MenuScreen extends World
{

    /**
     * Constructor for objects of class MenuScreen.
     * 
     */
    
    // All the objects that are generated/will be generated in the world
    Mario mario;
    Ground ground;
    private GreenfootImage groundImg = new GreenfootImage("brickfloor.png");
    private GreenfootImage background = new GreenfootImage("menuscreen.png");
    private GreenfootSound music1 = new GreenfootSound("MenuTheme1.mp3");
    private GreenfootSound music2 = new GreenfootSound("MenuTheme2.mp3");
    private GreenfootSound music3 = new GreenfootSound("MenuTheme3.mp3");
    StartBtn startBtn;
    MusicBtn musicBtn;
    InstructBtn instructBtn;
    Instructions instruct;
    Logo logo;
    BackBtn backBtn;
    Track1 track1;
    Track2 track2;
    Track3 track3;
    
    // Adding the objects into the menu screen (eg: Start Button)
    public MenuScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        mario = new Mario();
        addObject(mario, getWidth()/2, getHeight() - 50);
        
        ground = new Ground();
        groundImg.scale(getWidth(), groundImg.getHeight() + 5);
        ground.setImage(groundImg);
        addObject(ground, getWidth()/2, getHeight() - groundImg.getHeight()/2);
        
        startBtn = new StartBtn();
        addObject(startBtn, getWidth()/4, getHeight()/7 * 4);
        
        musicBtn = new MusicBtn();
        addObject(musicBtn, getWidth()/2, getHeight()/7 * 4);
        
        instructBtn = new InstructBtn();
        addObject(instructBtn, getWidth()/4 * 3, getHeight()/7 * 4);
        
        logo = new Logo();
        addObject(logo, getWidth()/2, getHeight()/7 * 2);
        
        instruct = new Instructions();
        backBtn = new BackBtn();
        
        track1 = new Track1();
        track2 = new Track2();
        track3 = new Track3();
        
        background.scale(background.getWidth(), getHeight());
        setBackground(background);
        
        
    }
    
    // Act constantly checks which button the player has chosen to interact with
    public void act() {
        if (mario.upCollision() instanceof StartBtn) {
            Greenfoot.setWorld(new LevelSelect());
            music1.stop();
            music2.stop();
            music3.stop();
        }
        
        if (mario.upCollision() instanceof InstructBtn) {
            removeObject(startBtn);
            removeObject(musicBtn);
            removeObject(instructBtn);
            removeObject(logo);
            
            addObject(instruct, getWidth()/2 + 75, getHeight()/2);
            addObject(backBtn, getWidth()/6, getHeight()/7 * 4);
            mario.setLocation(getWidth()/2, getHeight() / 7 * 6);
        }
        
        if (mario.upCollision() instanceof BackBtn) {
            removeObject(instruct);
            removeObject(backBtn);
            
            addObject(startBtn, getWidth()/4, getHeight()/7 * 4);
            addObject(musicBtn, getWidth()/2, getHeight()/7 * 4);
            addObject(instructBtn, getWidth()/4 * 3, getHeight()/7 * 4);
            addObject(logo, getWidth()/2, getHeight()/7 * 2);
            mario.setLocation(mario.getX(), getHeight() / 7 * 6);
        }
        
        if (mario.upCollision() instanceof MusicBtn) {
            removeObject(startBtn);
            removeObject(musicBtn);
            removeObject(instructBtn);
            removeObject(logo);
            
            mario.setLocation(getWidth()/2, getHeight() / 7 * 6);
            addObject(track1, getWidth()/4, getHeight() / 7 * 4);
            addObject(track2, getWidth()/2, getHeight() / 7 * 4);
            addObject(track3, getWidth()/4 * 3, getHeight() / 7 * 4);
        }
        
        
        
        if (mario.upCollision() instanceof Track1) {
            music1.setVolume(50);
            music1.playLoop();
            
            music2.stop();
            music3.stop();
            
            removeObject(track1);
            removeObject(track2);
            removeObject(track3);
            addObject(startBtn, getWidth()/4, getHeight()/7 * 4);
            addObject(musicBtn, getWidth()/2, getHeight()/7 * 4);
            addObject(logo, getWidth()/2, getHeight()/7 * 2);
            addObject(instructBtn, getWidth()/4 * 3, getHeight()/7 * 4);
            mario.setLocation(mario.getX(), getHeight() / 7 * 6);
        } else if (mario.upCollision() instanceof Track2) {
            music2.setVolume(50);
            music2.playLoop();
            
            music1.stop();
            music3.stop();
            
            removeObject(track1);
            removeObject(track2);
            removeObject(track3);
            addObject(startBtn, getWidth()/4, getHeight()/7 * 4);
            addObject(musicBtn, getWidth()/2, getHeight()/7 * 4);
            addObject(logo, getWidth()/2, getHeight()/7 * 2);
            addObject(instructBtn, getWidth()/4 * 3, getHeight()/7 * 4);
            mario.setLocation(mario.getX(), getHeight() / 7 * 6);
        } else if (mario.upCollision() instanceof Track3) {
            music3.setVolume(50);
            music3.playLoop();
            
            music1.stop();
            music2.stop();
            
            removeObject(track1);
            removeObject(track2);
            removeObject(track3);
            addObject(startBtn, getWidth()/4, getHeight()/7 * 4);
            addObject(musicBtn, getWidth()/2, getHeight()/7 * 4);
            addObject(instructBtn, getWidth()/4 * 3, getHeight()/7 * 4);
            addObject(logo, getWidth()/2, getHeight()/7 * 2);
            mario.setLocation(mario.getX(), getHeight() / 7 * 6);
        }
    }
    
    // Start the music on game start
    public void started() {
        music1.setVolume(50);
        music1.playLoop();
    }
}
