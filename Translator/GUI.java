import javax.swing.*;
import java.awt.*;

public class GUI extends  JFrame{
    private static JTextField input;
    private static JTextField output;
    private static JButton translate;

    private int NUM_ROWS = 3;

    public GUI() {
        setLayout(new GridLayout(NUM_ROWS, 1));

        input =  new JTextField("Input URL");
        output = new JTextField("Output file path");

        translate = new JButton("Translate");
        translate.addActionListener(e -> {
            try{
                new HTMLParserTool(GUI.getInput(), "temp", GUI.getOutput()).run();
            } catch (Exception ex){
                System.err.println(ex.getMessage());
            }

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

    public static  void main(String[] args){
        new GUI().setVisible(true);
    }
}
