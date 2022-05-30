import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class Scene extends JPanel implements ActionListener
{
    private JButton button[][] = new JButton[3][3];
    private static int boardCount = 0;
    private boolean isPlayerOne = true;
    private boolean isPlayerTwo = false;
    private boolean playerOneWin = false;
    private boolean playerTwoWin = false;
    private static int turn = 1;

    Scene()
    {
        initBoard();
    }

    private void initBoard()
    {
        setLayout(new GridLayout(3, 3, 0, 0));

        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                button[i][j] = new JButton();
                button[i][j].setText("");
                button[i][j].addActionListener(this);

                add(button[i][j]);
            }
        }
    }

    private void checkBoard()
    {
        checkRows();
        checkColumns();
        checkDiagonals();
        ifNoWinner();
    }

    private void ifNoWinner()
    {
        if (boardCount == 9) // If all buttons are filled.
        {
            screenMessage();
        }
    }

    private void checkRows()
    {
        // Check rows.

        for (int i = 0; i < 3; i++)
        {
            if (button[i][0].getText().equals("X") && button[i][1].getText().equals("X") && button[i][2].getText().equals("X"))
            {
                playerOneWin = true;
                screenMessage();
            }

            if (button[i][0].getText().equals("O") && button[i][1].getText().equals("O") && button[i][2].getText().equals("O"))
            {
                playerTwoWin = true;
                screenMessage();
            }
        }
    }

    private void checkColumns()
    {
        // Check columns.

        for (int i = 0; i < 3; i++)
        {
            if (button[0][i].getText().equals("X") && button[1][i].getText().equals("X") && button[2][i].getText().equals("X"))
            {
                playerOneWin = true;
                screenMessage();
            }

            if (button[0][i].getText().equals("O") && button[1][i].getText().equals("O") && button[2][i].getText().equals("O"))
            {
                playerTwoWin = true;
                screenMessage();
            }
        }
    }

    private void checkDiagonals()
    {
        checkLeftDiagonal();
        checkRightDiagonal();
    }

    private void checkLeftDiagonal()
    {
        if (button[0][0].getText().equals("X") && button[1][1].getText().equals("X") && button[2][2].getText().equals("X"))
        {
            playerOneWin = true;
            screenMessage();
        }
        if (button[0][0].getText().equals("O") && button[1][1].getText().equals("O") && button[2][2].getText().equals("O"))
        {
            playerTwoWin = true;
            screenMessage();
        }
    }

    private void checkRightDiagonal()
    {
        if (button[0][2].getText().equals("X") && button[1][1].getText().equals("X") && button[2][0].getText().equals("X"))
        {
            playerOneWin = true;
            screenMessage();
        }
        if (button[0][2].getText().equals("O") && button[1][1].getText().equals("O") && button[2][0].getText().equals("O"))
        {
            playerTwoWin = true;
            screenMessage();
        }
    }

    // 00 01 02
    // 10 11 12
    // 20 21 22

    @Override
    public void actionPerformed(ActionEvent e)
    {
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                if (e.getSource() == button[i][j])    // Get the particular button that was clicked.
                {
                    if (isPlayerOne())
                    {
                        button[i][j].setText("X");
                        button[i][j].setFont(new Font("Dialog", Font.BOLD, 40));
                        button[i][j].setEnabled(false);
                        setPlayerOneTurn(false);
                        setPlayerTwoTurn(true);
                        ++boardCount;
                    }
                    else
                    {
                        button[i][j].setText("O");
                        button[i][j].setFont(new Font("Dialog", Font.BOLD, 40));
                        button[i][j].setEnabled(false);
                        setPlayerOneTurn(true);
                        setPlayerTwoTurn(false);
                        ++boardCount;
                    }
                    checkBoard();
                    ++turn;
                }
            }
        }
    }

    private boolean isPlayerOne()
    {
        if (turn % 2 != 0)
        {
            return isPlayerOne = true;
        }
        else
        {
            return isPlayerOne = false;
        }
    }

    private void screenMessage()
    {
        JFrame frame = new JFrame("Message");
        JButton button = new JButton("Ok");
        JLabel message;

        button.addMouseListener(new MouseListener()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {

            }

            @Override
            public void mousePressed(MouseEvent e)
            {

            }

            @Override
            public void mouseReleased(MouseEvent e) // Exit if button is clicked.
            {
                System.exit(0);
            }

            @Override
            public void mouseEntered(MouseEvent e)
            {

            }

            @Override
            public void mouseExited(MouseEvent e)
            {

            }
        });

        if (playerOneWin)
        {
            message = new JLabel("Player One Wins!");

            frame.setBounds(100, 150, 400, 200);
            frame.setVisible(true);
            frame.setLayout(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            button.setBounds(150, 120, 100, 25);
            message.setBounds(115, 40, 500, 50);
            message.setFont(new Font("Serif", Font.PLAIN, 24));

            frame.add(button);
            frame.add(message);
        }
        else if (playerTwoWin)
        {
            message = new JLabel("Player Two Wins!");

            frame.setBounds(100, 150, 400, 200);
            frame.setVisible(true);
            frame.setLayout(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            button.setBounds(150, 120, 100, 25);
            message.setBounds(115, 40, 500, 50);
            message.setFont(new Font("Serif", Font.PLAIN, 24));

            frame.add(button);
            frame.add(message);
        }
        else
        {
            message = new JLabel("TIED!");

            frame.setBounds(100, 150, 400, 200);
            frame.setVisible(true);
            frame.setLayout(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            button.setBounds(150, 120, 100, 25);
            message.setBounds(170, 40, 500, 50);
            message.setFont(new Font("Serif", Font.PLAIN, 24));

            frame.add(button);
            frame.add(message);
        }
    }

    private void setPlayerOneTurn(boolean set)
    {
        isPlayerOne = set;
    }

    private void setPlayerTwoTurn(boolean set)
    {
        isPlayerTwo = set;
    }
}
