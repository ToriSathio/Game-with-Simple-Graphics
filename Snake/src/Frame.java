import javax.swing.*;
import java.awt.*;

class Frame extends JFrame
{
    /**
     *
     */


    public static final int WIDTH = 800;
    public static final int HEIGHT = 800;

    public Frame()
    {

    }

    public void init()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setTitle("Snake");
        setBounds(10, 10, WIDTH, HEIGHT);
        setBackground(Color.DARK_GRAY);
        setLocationRelativeTo(null);
    }
}