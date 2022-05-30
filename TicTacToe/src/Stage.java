import javax.swing.*;
import java.awt.*;

public class Stage extends JFrame
{
    final int WIDTH = 600;
    final int HEIGHT = 600;

    Stage()
    {

    }

    void init()
    {
        setBounds(10, 10, WIDTH, HEIGHT);
        setTitle("Tic Tac Toe");
        setBackground(Color.DARK_GRAY);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
