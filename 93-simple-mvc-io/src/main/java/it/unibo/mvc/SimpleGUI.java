package it.unibo.mvc;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Dimension;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private final JFrame frame = new JFrame();
    private static final int PROPORTION = 5;

    public SimpleGUI(){
        JTextArea textArea = new JTextArea("Write Here");
        JButton save = new JButton("Save");
        save.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Controller controller = new Controller();
                controller.saveOnCurrentFile(textArea.getText());
            }
        });
        frame.setLayout(new BorderLayout());
        frame.add(textArea, BorderLayout.CENTER);
        frame.add(save, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public void Start(){

    }

    public void display(){
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }
    public static void main(final String... args) {
        new SimpleGUI().display();
     }
}
