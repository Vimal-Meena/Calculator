import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class Calculator extends JFrame implements ActionListener {
    private DecimalFormat df = new DecimalFormat("#,###.00");
    private String[] symbols = {
            "%", "CE", "C", "<x",
            "1/x", "x²", "√", "÷",
            "7", "8", "9", "x",
            "4", "5", "6", "-",
            "1", "2", "3", "+",
            "+/-", "0", ".", "="
    };
    private int operator = 0;

    

    // private JButton menu = new JButton("☰");
    // private JTextArea type = new JTextArea("Standard");
    // private JPanel

    private JPanel panel = new JPanel(new BorderLayout(5, 3));
    private JPanel btnPanel = new JPanel(new GridLayout(6, 4, 2, 2));

    private JButton[] btns = new JButton[24];
    
    private JTextArea calculatingTf = new JTextArea(3, 40);
    private JTextArea screen = new JTextArea(5, 40);
    private double firstNum = 0, secondNum = 0;
    Font myFont = new Font("Arial", Font.PLAIN, 30);

    public Calculator() {
        init();
    }

    private void init() {

        screen.setFont(myFont);
        setTitle("Calculator");

        screen.setBackground(Color.WHITE);
        panel.setBackground(Color.WHITE);
        btnPanel.setBackground(Color.WHITE);
        screen.setForeground(Color.BLACK);

        calculatingTf.setForeground(Color.BLACK);
        calculatingTf.setBackground(Color.WHITE);

        for (int i = 0; i < btns.length; i++) {
            btns[i] = new JButton(symbols[i]);
            btns[i].setOpaque(true);
            btns[i].setFont(myFont);
            btns[i].setBorderPainted(false);
            btns[i].setBackground(Color.WHITE);
            btns[i].setForeground(Color.BLACK);
            btns[i].addActionListener(this);
            btnPanel.add(btns[i]);
        }


        panel.add(btnPanel, BorderLayout.CENTER);
        screen.add(calculatingTf, BorderLayout.NORTH);
        panel.add(screen, BorderLayout.NORTH);
        // screen.add(menu,BorderLayout.PAGE_START);
        add(panel);
        setSize(335, 540);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String args[]) {
        new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String cmd = e.getActionCommand().toString();
        switch (cmd) {
            case ".":
                if (!screen.getText().contains(".")) {
                    screen.setText(screen.getText() + ".");
                }
                break;
            case "0":
                screen.setText(screen.getText() + "0");
                break;
            case "1":
                screen.setText(screen.getText() + "1");
                break;
            case "2":
                screen.setText(screen.getText() + "2");
                break;
            case "3":
                screen.setText(screen.getText() + "3");
                break;
            case "4":
                screen.setText(screen.getText() + "4");
                break;
            case "5":
                screen.setText(screen.getText() + "5");
                break;
            case "6":
                screen.setText(screen.getText() + "6");
                break;
            case "7":
                screen.setText(screen.getText() + "7");
                break;
            case "8":
                screen.setText(screen.getText() + "8");
                break;

            case "9":
                screen.setText(screen.getText() + "9");
                break;
            case "+":
                if (!screen.getText().isEmpty()) {
                    firstNum = Double.parseDouble(screen.getText().toString());
                    operator = 1;
                    screen.setText("");
                }
                break;
            case "-":
                if (!screen.getText().isEmpty()) {
                    firstNum = Double.parseDouble(screen.getText().toString());
                    operator = 2;
                    screen.setText("");
                }
                break;
            case "x":
                if (!screen.getText().isEmpty()) {
                    firstNum = Double.parseDouble(screen.getText().toString());
                    operator = 3;
                    screen.setText("");
                }
                break;
            case "÷":
                if (!screen.getText().isEmpty()) {
                    firstNum = Double.parseDouble(screen.getText().toString());
                    operator = 4;
                    screen.setText("");
                }
                break;
            case "x²":
                double sq = Double.parseDouble(screen.getText().toString());
                sq *= sq;
                screen.setText(String.valueOf(sq));
                break;
            case "√":
                double root = Double.parseDouble(screen.getText().toString());
                root = Math.sqrt(root);
                screen.setText(String.valueOf(root));
                break;
            case "%":
                double num = Double.parseDouble(screen.getText().toString());
                screen.setText(String.valueOf(num / 100));
                break;
            case "1/x":
                double inv = Double.parseDouble(screen.getText().toString());
                inv = 1 / inv;
                screen.setText(String.valueOf(inv));
                break;
            case "+/-":
                double neg = Double.parseDouble(screen.getText().toString());
                neg *= -1;
                screen.setText(String.valueOf(neg));
                break;
            case "C":
                screen.setText("");
                break;
            default:
        }

        if (cmd.equalsIgnoreCase("=")) {
            if (!screen.getText().isEmpty()) {
                secondNum = Double.parseDouble(screen.getText().toString());
                switch (operator) {
                    case 1: // addition
                        screen.setText(String.valueOf(firstNum + secondNum));
                        calculatingTf.setText(String
                                .valueOf(firstNum + " + " + secondNum + " = " + (df.format(firstNum + secondNum))));
                        break;
                    case 2: // subtraction
                        screen.setText(String.valueOf(firstNum - secondNum));
                        calculatingTf.setText(String
                                .valueOf(firstNum + " - " + secondNum + " = " + (df.format(firstNum - secondNum))));
                        break;
                    case 3: // multiplication
                        screen.setText(String.valueOf(firstNum * secondNum));
                        calculatingTf.setText(String
                                .valueOf(firstNum + " x " + secondNum + " = " + (df.format(firstNum * secondNum))));
                        break;
                    case 4: // division
                        screen.setText(String.valueOf(firstNum / secondNum));
                        calculatingTf.setText(String
                                .valueOf(firstNum + " ÷ " + secondNum + " = " + (df.format(firstNum / secondNum))));
                        break;
                    default:
                }
            }
        }
    }
}
