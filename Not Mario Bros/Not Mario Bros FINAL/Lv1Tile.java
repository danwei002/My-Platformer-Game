import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Lv1Tile here.
 * This is a clickable object on the level select screen that takes the player to Level 1
 * Daniel Wei
 * Jan 18
 */
public class Lv1Tile extends Actor
{
    /**
     * Act - do whatever the Lv1Tile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage img = new GreenfootImage("Lv1Tile.png");
    public void act() 
    {
        if (Greenfoot.mouseClicked(this)) {
            LevelSelect.getSound().stop();
            Greenfoot.setWorld(new Level1());
        }
    }    
    
    public Lv1Tile() {
        img.scale(img.getWidth()/5 * 3, img.getHeight()/5 * 3);
        setImage(img);
    }
}
