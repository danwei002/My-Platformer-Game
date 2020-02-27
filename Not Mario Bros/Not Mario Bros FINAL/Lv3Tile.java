import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Lv3Tile here.
 * This is a clickable object on the level select screen that takes the player to Level 3
 * Daniel Wei
 * Jan 18
 */
public class Lv3Tile extends Actor
{
    /**
     * Act - do whatever the Lv3Tile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage img = new GreenfootImage("Lv3Tile.png");
    public void act() 
    {
        if (Greenfoot.mouseClicked(this)) {
            LevelSelect.getSound().stop();
            Greenfoot.setWorld(new Level3());
        }
    }    
    
    public Lv3Tile() {
        img.scale(img.getWidth()/5 * 3, img.getHeight()/5 * 3);
        setImage(img);
    }
}
