import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Actor
{
    private String buttonText;
    /**
     * Act - do whatever the Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Button(String buttonText)
    {
        this.buttonText = buttonText;
        setImage(new GreenfootImage(buttonText, 20, Color.BLACK, Color.WHITE));
    }
    
    public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
            System.out.println("clicked");
        }
        System.out.println(isAtEdge());
    }
    
    public String getText()
    {
        return buttonText;
    }
}
