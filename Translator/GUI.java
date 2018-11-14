import javax.swing.*;
import java.awt.*;

public class GUI extends  JFrame{
    private static JTextField input;
    private static JTextField output;
    private static JButton translate;

    private int NUM_ROWS = 3;

    public GUI(){


        setLayout(new GridLayout(NUM_ROWS, 1));

        input =  new JTextField("Input URL");
        output = new JTextField("Output file path");

        translate = new JButton("Translate");
        translate.addActionListener(e -> {
            ThreadHandler.add(input.getText(), output.getText());
        });

        add(input);
        add(output);
        add(translate);

        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static String getInput(){
        return input.getText();
    }

    public static  String getOutput(){
        return output.getText();
    }

    public static  void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        try{
            new GUI().setVisible(true);
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
