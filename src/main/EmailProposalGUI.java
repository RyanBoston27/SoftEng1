package main;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;

public class EmailProposalGUI extends JFrame {

    private JTextField searchField;
    private JButton searchButton;
    private JTable resultsTable;
    private JFrame frame;

    public EmailProposalGUI() {
        frame = new JFrame("Search Clients");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        searchField = new JTextField(20);
        searchButton = new JButton("Search");
        resultsTable = new JTable();

        JPanel searchPanel = new JPanel();
        searchPanel.add(new JLabel("Enter address:"));
        searchPanel.add(searchField);
        searchPanel.add(searchButton);

        frame.add(searchPanel, BorderLayout.NORTH);
        frame.add(new JScrollPane(resultsTable), BorderLayout.CENTER);

        JButton homeButton = new JButton("Home");
        searchPanel.add(homeButton);

        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add your code for Create Client here
                new LandingPageGUI();
                frame.dispose();
            }
        });

        searchButton.addActionListener(e -> searchClients());

        display();
    }

    private void display() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(screenSize.width / 2, screenSize.height / 2); // Set the frame size to be half the screen size
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void searchClients() {
        String searchAddress = searchField.getText().toLowerCase().trim();
    
        try(Connection conn = sqlcon.getConnection()) {
            
            String query = "SELECT fullName AS FullName, phoneNumber AS PhoneNumber, emailAddress AS Email, jobSiteAddress AS JobSiteAddress, bidSheet AS BidSheet, proposalDoc AS ProposalDoc FROM customers WHERE LOWER(jobSiteAddress) LIKE ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, "%" + searchAddress + "%");
    
            ResultSet resultSet = statement.executeQuery();
            
            // Get metadata for column names
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            Vector<String> columnNames = new Vector<>();
            for (int column = 1; column <= columnCount; column++) {
                columnNames.add(metaData.getColumnName(column));
            }
    
            // Get data rows
            Vector<Vector<Object>> data = new Vector<>();
            while (resultSet.next()) {
                Vector<Object> vector = new Vector<>();
                for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                    vector.add(resultSet.getObject(columnIndex));
                }
                data.add(vector);
            }
    
            // Update the table model
            DefaultTableModel model = new DefaultTableModel(data, columnNames);
            resultsTable.setModel(model);
    
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}