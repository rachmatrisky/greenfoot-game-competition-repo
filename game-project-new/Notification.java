import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Notification here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Notification extends Actor
{
    public Notification(String message)
    {
        setImage(new GreenfootImage(message, 24, Color.BLACK, Color.WHITE));
    }
    
    public void act()
    {
        // Add your action code here.
        // getWorld().removeObject(this);
    }
}
