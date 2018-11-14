import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class GUI extends JFrame implements FocusListener, ActionListener {
    private static JTextField input;
    private static JTextField output;
    private static JButton translate;
    private static JComboBox dropdown;

    private int NUM_ROWS = 4;

    private int WIDTH = 250;
    private int HEIGHT = 45;

    public GUI(){
        setLayout(new GridLayout(NUM_ROWS, 1));

        input =  new JTextField("Input URL");
        input.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        input.addFocusListener(this);

        output = new JTextField("Output file path");
        output.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        output.addFocusListener(this);

        translate = new JButton("Translate");
        translate.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        translate.addActionListener(e -> {
            ThreadHandler.add(input.getText(), output.getText());
        });

        String[] langs = {"Amharic", "French", "German", "Spanish"};
        dropdown = new JComboBox(langs);
        dropdown.setSelectedIndex(0);
        dropdown.addActionListener(this);

        add(input);
        add(output);
        add(dropdown);
        add(translate);

        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static  void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        try{
            new GUI().setVisible(true);
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        JTextField field = (JTextField)e.getSource();
        field.setText("");
    }

    @Override
    public void focusLost(FocusEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
