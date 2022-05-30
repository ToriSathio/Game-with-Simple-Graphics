import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Scene extends JPanel implements ActionListener
{
    private JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9;
    private JButton bPercentage, bDivide, bMultiply, bMinus, bPlus, bEquals;
    private JButton bClear, bDot, bDelete, bOn, bOff;
    private Object calculateResult = null;

    private JTextField calculatorTextField;

    Scene()
    {
        initTextField();
        initButtons();
    }

    void initTextField()
    {
        calculatorTextField = new JTextField();

        calculatorTextField.setEditable(false);
        calculatorTextField.setBackground(Color.WHITE);
        calculatorTextField.setFont(new Font("Arial", Font.BOLD, 20));

        setLayout(new BorderLayout());
        add(calculatorTextField, BorderLayout.NORTH);   // Positioned at top.
    }

    void initButtons()
    {
       JPanel buttonPanel = new JPanel();
       JPanel editPanel = new JPanel();

        b0 = new JButton("0");      b0.addActionListener(this);
        b1 = new JButton("1");      b1.addActionListener(this);
        b2 = new JButton("2");      b2.addActionListener(this);
        b3 = new JButton("3");      b3.addActionListener(this);
        b4 = new JButton("4");      b4.addActionListener(this);
        b5 = new JButton("5");      b5.addActionListener(this);
        b6 = new JButton("6");      b6.addActionListener(this);
        b7 = new JButton("7");      b7.addActionListener(this);
        b8 = new JButton("8");      b8.addActionListener(this);
        b9 = new JButton("9");      b9.addActionListener(this);

        bPercentage = new JButton("%");         bPercentage.addActionListener(this);
        bDivide = new JButton("/");             bDivide.addActionListener(this);
        bMultiply = new JButton("*");           bMultiply.addActionListener(this);
        bMinus = new JButton("-");              bMinus.addActionListener(this);
        bPlus = new JButton("+");               bPlus.addActionListener(this);
        bEquals = new JButton("=");             bEquals.addActionListener(this);

        bClear = new JButton("C");              bClear.addActionListener(this);
        bDot = new JButton(".");                bDot.addActionListener(this);
        bDelete = new JButton("BACKSPACE");     bDelete.addActionListener(this);
        bOn = new JButton ("ON");               bOn.addActionListener(this);
        bOff = new JButton ("OFF");             bOff.addActionListener(this);

        b0.setFont(new Font("Arial", Font.BOLD, 20));
        b1.setFont(new Font("Arial", Font.BOLD, 20));
        b2.setFont(new Font("Arial", Font.BOLD, 20));
        b3.setFont(new Font("Arial", Font.BOLD, 20));
        b4.setFont(new Font("Arial", Font.BOLD, 20));
        b5.setFont(new Font("Arial", Font.BOLD, 20));
        b6.setFont(new Font("Arial", Font.BOLD, 20));
        b7.setFont(new Font("Arial", Font.BOLD, 20));
        b8.setFont(new Font("Arial", Font.BOLD, 20));
        b9.setFont(new Font("Arial", Font.BOLD, 20));

        bPercentage.setFont(new Font("Arial", Font.BOLD, 20));
        bDivide.setFont(new Font("Arial", Font.BOLD, 20));
        bMultiply.setFont(new Font("Arial", Font.BOLD, 20));
        bMinus.setFont(new Font("Arial", Font.BOLD, 20));
        bPlus.setFont(new Font("Arial", Font.BOLD, 20));
        bEquals.setFont(new Font("Arial", Font.BOLD, 20));

        bClear.setFont(new Font("Arial", Font.BOLD, 20));
        bDot.setFont(new Font("Arial", Font.BOLD, 20));
        bDelete.setFont(new Font("Arial", Font.BOLD, 20));
        bOn.setFont(new Font("Arial", Font.BOLD, 20));
        bOff.setFont(new Font("Arial", Font.BOLD, 20));


        editPanel.add(bClear);                              editPanel.add(bDelete);
        buttonPanel.add(b7);    buttonPanel.add(b8);        buttonPanel.add(b9);        buttonPanel.add(bDivide);
        buttonPanel.add(b4);    buttonPanel.add(b5);        buttonPanel.add(b6);        buttonPanel.add(bMultiply);
        buttonPanel.add(b1);    buttonPanel.add(b2);        buttonPanel.add(b3);        buttonPanel.add(bMinus);
        buttonPanel.add(b0);    buttonPanel.add(bDot);      buttonPanel.add(bEquals);   buttonPanel.add(bPlus);

        editPanel.setLayout(new FlowLayout());
        buttonPanel.setLayout(new GridLayout(4, 4, 4, 4));

        add(editPanel, BorderLayout.SOUTH);
        add(buttonPanel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object buttonClicked = e.getSource();

        if(buttonClicked == b0 )
        {
            calculatorTextField.setText(calculatorTextField.getText() + b0.getText());
        }
        if(buttonClicked == b1)
        {
            calculatorTextField.setText(calculatorTextField.getText() + b1.getText());
        }
        if(buttonClicked == b2)
        {
            calculatorTextField.setText(calculatorTextField.getText() + b2.getText());
        }
        if(buttonClicked == b3)
        {
            calculatorTextField.setText(calculatorTextField.getText() + b3.getText());
        }
        if(buttonClicked == b4)
        {
            calculatorTextField.setText(calculatorTextField.getText() + b4.getText());
        }
        if(buttonClicked == b5)
        {
            calculatorTextField.setText(calculatorTextField.getText() + b5.getText());
        }
        if(buttonClicked == b6)
        {
            calculatorTextField.setText(calculatorTextField.getText() + b6.getText());
        }
        if(buttonClicked == b7)
        {
            calculatorTextField.setText(calculatorTextField.getText() + b7.getText());
        }
        if(buttonClicked == b8)
        {
            calculatorTextField.setText(calculatorTextField.getText() + b8.getText());
        }
        if(buttonClicked == b9)
        {
            calculatorTextField.setText(calculatorTextField.getText() + b9.getText());
        }

        
        // If expressions already calculated, any button that is pressed except operators will erase everything.
        if(buttonClicked == b0 && calculateResult != null)
        {
            calculatorTextField.setText(b0.getText());
            calculateResult = null;     // Reset.
        }
        else if(buttonClicked == b1 && calculateResult != null)
        {
            calculatorTextField.setText(b1.getText());
            calculateResult = null;
        }
        else if(buttonClicked == b2 && calculateResult != null)
        {
            calculatorTextField.setText(b2.getText());
            calculateResult = null;
        }
        else if(buttonClicked == b3 && calculateResult != null)
        {
            calculatorTextField.setText(b3.getText());
            calculateResult = null;
        }
        else if(buttonClicked == b4 && calculateResult != null)
        {
            calculatorTextField.setText(b4.getText());
            calculateResult = null;
        }
        else if(buttonClicked == b5 && calculateResult != null)
        {
            calculatorTextField.setText(b5.getText());
            calculateResult = null;
        }
        else if(buttonClicked == b6 && calculateResult != null)
        {
            calculatorTextField.setText(b6.getText());
            calculateResult = null;
        }
        else if(buttonClicked == b7 && calculateResult != null)
        {
            calculatorTextField.setText(b7.getText());
            calculateResult = null;
        }
        else if(buttonClicked == b8 && calculateResult != null)
        {
            calculatorTextField.setText(b8.getText());
            calculateResult = null;
        }
        else if(buttonClicked == b9 && calculateResult != null)
        {
            calculatorTextField.setText(b9.getText());
            calculateResult = null;
        }
        // If equal pressed then delete button pressed, erase everything.
        else if(buttonClicked == bDelete && calculateResult != null)
        {
            calculatorTextField.setText("");
            calculateResult = null; // Reset.
        }
        
        if(buttonClicked == bPercentage && calculatorTextField.getText().isEmpty() || buttonClicked == bDivide && calculatorTextField.getText().isEmpty() || buttonClicked == bMultiply && calculatorTextField.getText().isEmpty() || buttonClicked == bMinus && calculatorTextField.getText().isEmpty() || buttonClicked == bPlus && calculatorTextField.getText().isEmpty() || buttonClicked == bEquals && calculatorTextField.getText().isEmpty() || buttonClicked == bDot && calculatorTextField.getText().isEmpty() || buttonClicked == bDelete && calculatorTextField.getText().isEmpty())
        {
            // Do nothing.
        }
        else if(buttonClicked == bPercentage)
        {
            calculatorTextField.setText(calculatorTextField.getText() + bPercentage.getText());
            calculateResult = null;
        }
        else if(buttonClicked == bDivide)
        {
            calculatorTextField.setText(calculatorTextField.getText() + bDivide.getText());
            calculateResult = null;
        }
        else if(buttonClicked == bMultiply)
        {
            calculatorTextField.setText(calculatorTextField.getText() + bMultiply.getText());
            calculateResult = null;
        }
        else if(buttonClicked == bMinus)
        {
            calculatorTextField.setText(calculatorTextField.getText() + bMinus.getText());
            calculateResult = null;
        }
        else if(buttonClicked == bPlus)
        {
            calculatorTextField.setText(calculatorTextField.getText() + bPlus.getText());
            calculateResult = null;
        }
       else if(buttonClicked == bEquals)
        {
            // create a script engine manager
            ScriptEngineManager factory = new ScriptEngineManager();
            // create a JavaScript engine
            ScriptEngine engine = factory.getEngineByName("JavaScript");

            // evaluate JavaScript code from String
            try
            {
                calculateResult = engine.eval(calculatorTextField.getText());
            } catch (ScriptException ex)
            {
                ex.printStackTrace();
            }

            calculatorTextField.setText(String.valueOf(calculateResult));
        }
        else if(buttonClicked == bDot)
        {
            calculatorTextField.setText(calculatorTextField.getText() + bDot.getText());
            calculateResult = null;
        }
        else if(buttonClicked == bDelete)
        {
            calculatorTextField.setText(calculatorTextField.getText().substring(0, calculatorTextField.getDocument().getLength() - 1));
            calculateResult = null; // Reset.
        }

        if(buttonClicked == bClear)
        {
            calculatorTextField.setText("");
            calculateResult = null;
        }


        if(buttonClicked == bOn)
        {
            calculatorTextField.setText(calculatorTextField.getText() + bOn.getText());
        }
        if(buttonClicked == bOff)
        {
            calculatorTextField.setText(calculatorTextField.getText() + bOff.getText());
        }
    }
}