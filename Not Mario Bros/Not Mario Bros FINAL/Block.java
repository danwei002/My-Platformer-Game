import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Block here.
 * These are the main yellow platforms that Mario is able to interact/collide with
 * Daniel Wei
 * Jan 18
 */


public class Block extends Actor
{
    /**
     * Act - do whatever the Block wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public GreenfootImage blockImg = getImage();
    public GreenfootImage hitImg = new GreenfootImage("hit block.png");
    
    public void act() 
    {
       
        
        
        
    } 
    
    public Block() {
        blockImg.scale(blockImg.getWidth() / 25, blockImg.getHeight() / 25);
        setImage(blockImg);
    }
    
    // Detects and returns what object is standing on the block
    public Object upCollision() {
        return getOneObjectAtOffset(0, -getImage().getHeight(), null);
    }
    
}
