package main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class LoginGUI {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LoginGUI::new);
    }

    private LoginGUI() {
        JFrame frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(1, 2));

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));

        JLabel welcomeLabel = new JLabel("Welcome back!");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        JLabel instructionLabel = new JLabel("Please log in using company Email and Password.");
        rightPanel.add(welcomeLabel);
        rightPanel.add(instructionLabel);

        JLabel usernameLabel = new JLabel("Email");
        JTextField usernameField = new JTextField(20);
        rightPanel.add(usernameLabel);
        rightPanel.add(usernameField);

        JLabel passwordLabel = new JLabel("Password");
        JPasswordField passwordField = new JPasswordField(20);
        rightPanel.add(passwordLabel);
        rightPanel.add(passwordField);

        JButton loginButton = new JButton("Log In");
        rightPanel.add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                char[] password = passwordField.getPassword();
        
                // Call some method to verify the credentials
                boolean isValid = validateCredentials(username, new String(password));
        
                if (isValid) {
                    System.out.println("Login successful");
                    // Dispose of the login frame
                    frame.dispose();
                    // Open the landing page
                    new LandingPageGUI();
                } else {
                    // Show an error message when the login is unsuccessful
                    JOptionPane.showMessageDialog(frame, "Invalid Login Credentials", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        

        JPanel leftPanel = new JPanel();
        // Add your logo to the leftPanel here. Example:
        leftPanel.add(new JLabel(new ImageIcon("images/MBlogo2.png")));

        panel.add(leftPanel);
        panel.add(rightPanel);

        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private boolean validateCredentials(String username, String password) {
        
        // 1. Test connection
        try(Connection conn = sqlcon.getConnection()){
 
            // 2. Create a statement
            PreparedStatement myStmt = conn.prepareStatement("SELECT * FROM logininfo WHERE username = ? AND password = ?");
            myStmt.setString(1, username);
            myStmt.setString(2, password);
            
            // 3. Execute SQL query
            ResultSet myRs = myStmt.executeQuery();
            
            // 4. Process the result set - if there's a result, then the credentials are valid
            if (myRs.next()) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

