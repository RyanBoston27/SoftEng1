package main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LandingPageGUI {

    public LandingPageGUI() {
        JFrame frame = new JFrame("Landing Page");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add components for the landing page here

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}