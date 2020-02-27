import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LevelSelect here.
 * A menu to select levels to play
 * Daniel Wei
 * Jan 18
 */
public class LevelSelect extends World
{

    /**
     * Constructor for objects of class LevelSelect.
     * 
     */
    private static GreenfootSound theme1 = new GreenfootSound("LevelSelectTheme.mp3");
    
    // Level Select screen and the tiles to select the levels (1-6)
    public LevelSelect()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        GreenfootImage image = new GreenfootImage("level-select.png");
        image.scale(getWidth(), getHeight());
        setBackground(image);

        StartTile startTile = new StartTile();
        addObject(startTile, 75, 110);
        
        Lv1Tile lv1Tile = new Lv1Tile();
        addObject(lv1Tile, 157, 34);
        
        Lv2Tile lv2Tile = new Lv2Tile();
        addObject(lv2Tile, 320, 32);
        
        Lv3Tile lv3Tile = new Lv3Tile();
        addObject(lv3Tile, 402, 33);
        
        Lv4Tile lv4Tile = new Lv4Tile();
        addObject(lv4Tile, 403, 113);
        
        Lv5Tile lv5Tile = new Lv5Tile();
        addObject(lv5Tile, 157, 348);
        
        Lv6Tile lv6Tile = new Lv6Tile();
        addObject(lv6Tile, 321, 348);
        
        theme1.playLoop();
        
    }
    
    // Access the LevelSelect theme so that other classes can start/stop the theme
    public static GreenfootSound getSound() {
        return theme1;
    }
}
