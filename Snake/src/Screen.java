import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

public class Screen extends JPanel implements Runnable, KeyListener    // Runnable for thread.start().
{
    public static final int WIDTH = 800;
    public static final int HEIGHT = 800;

    private static final long serialVersionUID = 1L;
    private Thread thread;
    boolean gameOver = false;
    Random random;

    private BodyPart body;
    private ArrayList<BodyPart> snake;
    private Food fruit;
    private ArrayList<Food> food;

    private int snakeXPos = 10;
    private int snakeYPos = 10;
    private int size = 5;
    private int update = 0;

    private boolean left = false;
    private boolean right = true;
    private boolean up = false;
    private boolean down = false;

    public Screen()
    {
        addKeyListener(this);
        setFocusable(true);

        snake = new ArrayList<BodyPart>();
        food = new ArrayList<Food>();

        start();
    }

    public void start()    // Why do use thread?
    {
        gameOver = false;
        random = new Random();
        thread = new Thread(this, "Game Loop");
        thread.start();
    }

    public void moveLeft()
    {
        --snakeXPos;
    }

    public void moveRight()
    {
        ++snakeXPos;
    }

    public void moveUp()
    {
        --snakeYPos;
    }

    public void moveDown()
    {
        ++snakeYPos;
    }

    public void update()
    {
        if (snake.size() == 0)
        {
            body = new BodyPart(snakeXPos, snakeYPos, 10);    // Print body.
            snake.add(body);
        }

        if (food.size() == 0)  // Print food.
        {
            int xPos = random.nextInt(78);  // 0 - 77.
            int yPos = random.nextInt(78);

            fruit = new Food(xPos, yPos, 10);   // If tileSize aren't the same, food can't be eaten.
            food.add(fruit);
        }

        for (int i = 0; i < food.size(); i++)   // Remove food if eaten.
        {
            if (snakeXPos == food.get(i).getFoodXPos() && snakeYPos == food.get(i).getFoodYPos())

            {
                ++size;
                food.remove(i);
            }
        }

        ++update;    // Update will be incremented, akin to loop.

        if (update > 550000)
        {
            if (left)
            {
                moveLeft();
            }

            if (right)
            {
                moveRight();
            }

            if (up)
            {
                moveUp();
            }

            if (down)
            {
                moveDown();
            }

            update = 0;    // Reset.

            body = new BodyPart(snakeXPos, snakeYPos, 10);    // Print new body.
            snake.add(body);

            if (snake.size() > size)
            {
                snake.remove(0);
            }

            if (snakeXPos > 78 || snakeXPos < 0 || snakeYPos > 75 || snakeYPos < 0) // Snake dies when touches the border
            {
                stop();
            }

            for (int i = 0; i < snake.size(); i++)  // Snake dies when touches its body
            {
                if (snakeXPos == snake.get(i).getBodyXPos() && snakeYPos == snake.get(i).getBodyYPos())
                {
                    if (i != snake.size() - 1) // What's this? I don't get it.
                    {
                        stop();
                    }
                }
            }
        }
    }

    public void paint(Graphics g)
    {
        requestFocus(true); // JPanel keeps losing focus if not added.

        g.setColor(Color.DARK_GRAY);    // Set the background color.
        g.fillRect(0, 0, WIDTH, HEIGHT);    // Repaint the background.

        for (int i = 0; i < WIDTH / 10; i++)    // Vertical lines.
        {
            g.drawLine(i * 10, 0, i * 10, HEIGHT);
            g.setColor(Color.BLACK);
        }

        for (int i = 0; i < HEIGHT / 10; i++)    // Horizontal lines.
        {
            g.drawLine(0, i * 10, WIDTH, i * 10);
            g.setColor(Color.BLACK);
        }

        for (int i = 0; i < snake.size(); i++)    // Draw snake.
        {
            snake.get(i).draw(g);
        }

        for (int i = 0; i < food.size(); i++)   // Draw food.
        {
            food.get(i).draw(g);
        }
    }

    public void stop()
    {
        gameOver = true;

        try
        {
            thread.join();
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void run()
    {
        while (!gameOver)
        {
            update();
            repaint();
        }
    }

    @Override
    public void keyTyped(KeyEvent e)
    {

    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT && !right)    // Snake not allowed move sideways.
        {
            left = true;
            right = false;
            up = false;
            down = false;
        }

        if (key == KeyEvent.VK_RIGHT && !left)
        {
            left = false;
            right = true;
            up = false;
            down = false;
        }

        if (key == KeyEvent.VK_UP && !down)
        {
            left = false;
            right = false;
            up = true;
            down = false;
        }

        if (key == KeyEvent.VK_DOWN && !up)
        {
            left = false;
            right = false;
            up = false;
            down = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e)
    {

    }
}

