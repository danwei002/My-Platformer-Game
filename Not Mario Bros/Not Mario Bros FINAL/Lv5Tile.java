import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Lv5Tile here.
 * This is a clickable object on the level select screen that takes the player to Level 5
 * Daniel Wei
 * Jan 18
 */
public class Lv5Tile extends Actor
{
    /**
     * Act - do whatever the Lv5Tile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage img = new GreenfootImage("Lv5Tile.png");
    public void act() 
    {
        if (Greenfoot.mouseClicked(this)) {
            LevelSelect.getSound().stop();
            Greenfoot.setWorld(new Level5());
        }
    }    
    
    public Lv5Tile() {
        img.scale(img.getWidth() / 5 * 3, img.getHeight() / 5 * 3);
        setImage(img);
    }
}
