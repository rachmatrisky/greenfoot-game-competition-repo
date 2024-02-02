import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameWorld extends World
{
    private int currentLevel = 1;
    private int notificationTimer = 0;
    private ArrayList<String> questions;
    private ArrayList<String> answersA;
    private ArrayList<String> answersB;
    private ArrayList<String> correctAnswers;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public GameWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        prepareQuestions();
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Question question = new Question(questions.get(currentLevel - 1));
        addObject(question, getWidth() / 2, getHeight() - 100);
        
        Button buttonA = new Button("option A: " + answersA.get(currentLevel - 1));
        addObject(buttonA, getWidth() / 2 - 100, getHeight() - 50);
        
        Button buttonB = new Button("option B: " + answersB.get(currentLevel - 1));
        addObject(buttonB, getWidth() / 2 + 100, getHeight() - 50);
    }
    
    public void act()
    {
        if (Greenfoot.mouseClicked(null))
        {
            checkAnswer();
        }
        
        if (notificationTimer > 0)
        {
            notificationTimer--;
            if (notificationTimer == 0)
            {
                removeObjects(getObjects(Notification.class));
            }
        }
    }
    
    private void prepareQuestions()
    {
        questions = new ArrayList<>();
        answersA = new ArrayList<>();
        answersB = new ArrayList<>();
        correctAnswers = new ArrayList<>();
        
        questions.add("question1 where question 1 is one of the most strongerst word in the world so because of that\n");
        answersA.add("answer1 correct");
        answersB.add("answer1 incorrect");
        correctAnswers.add("answer1 correct");
        
        questions.add("question2");
        answersA.add("answer2 incorrect");
        answersB.add("answer2 correct");
        correctAnswers.add("answer2 correct");
    }
    
    private void nextLevel()
    {
        removeObjects(getObjects(Question.class));
        removeObjects(getObjects(Button.class));
        
        currentLevel++;
        
        if (currentLevel <= questions.size())
        {
        Question question = new Question(questions.get(currentLevel - 1));
        addObject(question, getWidth() / 2, getHeight() - 100);
        
        Button buttonA = new Button("option A: " + answersA.get(currentLevel - 1));
        addObject(buttonA, getWidth() / 2 - 100, getHeight() - 50);
        
        Button buttonB = new Button("option B: " + answersB.get(currentLevel - 1));
        addObject(buttonB, getWidth() / 2 + 100, getHeight() - 50);
        }
        else
        {
            Greenfoot.stop();
        }
    }
    
    private void checkAnswer()
    {
        List<Actor> clickedObjects = getObjectsAt(Greenfoot.getMouseInfo().getX(), Greenfoot.getMouseInfo().getY(), Actor.class);
        
        // if (!clickedObjects.isEmpty())
        // {
            // Button clickedButton = (Button) clickedObjects.get(0);
            // String buttonText = clickedButton.getText();
            // String correctAnswer;
            
            // if (buttonText.contains("option A"))
            // {
                // correctAnswer = answersA.get(currentLevel - 1);
            // } else {
                // correctAnswer = answersB.get(currentLevel - 1);
            // }
            
            // if (buttonText.contains(correctAnswer))
            // {
                // showNotification("correct");
                // nextLevel();
            // }
            // else
            // {
                // showNotification("wrong");
                // Greenfoot.stop();
            // }
        // }
        
        for (Actor actor : clickedObjects)
        {
                Button clickedButton = (Button) actor;
                String buttonText = clickedButton.getText();

                // String correctAnswer = answersA.get(currentLevel - 1);
                // String incorrectAnswer = answersB.get(currentLevel - 1);
                
                // String correctAnswer;
                
                // if (currentLevel % 2 == 0)
                // {
                    // correctAnswer = answersA.get(currentLevel - 1);
                // }
                // else
                // {
                    // correctAnswer = answersB.get(currentLevel - 1);
                // }
                
                System.out.println(buttonText);
                // System.out.println(correctAnswer);
                System.out.println(currentLevel);
                
                
                if (clickedButton == getObjects(Button.class).get(0))
                {
                    if (buttonText.contains(correctAnswers.get(currentLevel - 1)))
                    {
                        showNotification("Jawaban benar");
                        nextLevel();
                    } else {
                        showNotification("jawaban salah");
                    }
                } else if (clickedButton == getObjects(Button.class).get(1))
                {
                    if (buttonText.contains(correctAnswers.get(currentLevel - 1)))
                    {
                        showNotification("jawaban benar");
                        nextLevel();
                    }
                    else
                    {
                        showNotification("jawaban salah");
                    }
                }
                break;
        }
    }
    
    private void showNotification(String message)
    {
        addObject(new Notification(message), getWidth() / 2, getHeight() / 2);
        notificationTimer = 180;
    }
}
