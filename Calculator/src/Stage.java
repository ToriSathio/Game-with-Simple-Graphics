import javax.swing.*;

public class Stage extends JFrame
{
    private final int WIDTH = 400;
    private final int HEIGHT = 500;

    Stage()
    {

    }

    void init()
    {
        setSize(WIDTH, HEIGHT);
        setTitle("Calculator");
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);    // Center the window.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
