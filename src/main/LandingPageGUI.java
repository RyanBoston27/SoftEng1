package main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class LandingPageGUI {
    public LandingPageGUI() {
        JFrame frame = new JFrame("Home Page");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());

        // Creating a navigation bar
        JPanel navBar = new JPanel(new FlowLayout(FlowLayout.LEFT));
        navBar.add(new JLabel(new ImageIcon("images/MBlogo.png")));
        panel.add(navBar, BorderLayout.NORTH);

        // Creating the main container
        JPanel container = new JPanel(new GridLayout(1, 2));
        JButton createClientButton = new JButton("Create Client");
        JButton searchClientsButton = new JButton("Search Clients");
        container.add(createClientButton);
        container.add(searchClientsButton);
        panel.add(container, BorderLayout.CENTER);

        // Event listener for Create Client button
        createClientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add your code for Create Client here
                new BidSheetGUI();
                frame.dispose();
            }
        });

        // Event listener for Search Clients button
        searchClientsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add your code for Search Clients here
                new SearchClientGUI();    
                frame.dispose();
            }
        });

        frame.getContentPane().add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
