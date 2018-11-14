import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class GUI extends JFrame implements FocusListener {
    private static JTextField input;
    private static JTextField output;
    private static JButton translate;

    private int NUM_ROWS = 3;

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

        add(input);
        add(output);
        add(translate);

        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

/*    public static String getInput(){
        return input.getText();
    }

    public static  String getOutput(){
        return output.getText();
    }*/

    private static void drawSplashScreen(Graphics2D graphics, int frame){
        graphics.setComposite(AlphaComposite.Clear);
        graphics.fillRect(120,140,200,40);
        graphics.setPaintMode();
        graphics.setColor(Color.BLACK);
        graphics.drawString("Loading ML translator", 120, 150);
    }

    public static  void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

/*        SplashScreen splash = SplashScreen.getSplashScreen();
        if (splash == null) {
            System.err.println("no splash screen available");
            return;
        }
        Graphics2D graphics = splash.createGraphics();
        int numFrames = 100;
        for(int i = 0; i < numFrames; i++){
            drawSplashScreen(graphics, i);
            splash.update();
            try {
                Thread.sleep(90);
            } catch(InterruptedException e) {
            }
            splash.close();
        }*/

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
}
