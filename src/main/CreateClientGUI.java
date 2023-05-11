package main;
import classes.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.MaskFormatter;
import javax.swing.JFormattedTextField;
import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.text.ParseException;

class CreateClientGUI {

    private JCheckBox sameAsJobAddressCheckbox = new JCheckBox("Same as job address");

    public CreateClientGUI() {
        JFrame frame = new JFrame("Create Client");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(21, 2));

        JLabel firstNameLabel = new JLabel("First Name");
        JTextField firstNameField = new JTextField(20);
        panel.add(firstNameLabel);
        panel.add(firstNameField);

        JLabel lastNameLabel = new JLabel("Last Name");
        JTextField lastNameField = new JTextField(20);
        panel.add(lastNameLabel);
        panel.add(lastNameField);

        JLabel dateLabel = new JLabel("Date");
        MaskFormatter dateFormatter = null;
        try {
            dateFormatter = new MaskFormatter("##-##-####");
            dateFormatter.setPlaceholderCharacter('_');
        } catch (ParseException e) {
            e.printStackTrace();
        }
        JFormattedTextField dateField = new JFormattedTextField(dateFormatter);
        panel.add(dateLabel);
        panel.add(dateField);

        JLabel emailLabel = new JLabel("Email");
        JTextField emailField = new JTextField(20);
        panel.add(emailLabel);
        panel.add(emailField);

        JLabel phoneLabel = new JLabel("Phone");
        JTextField phoneField = new JTextField(20);
        panel.add(phoneLabel);
        panel.add(phoneField);

        JLabel jobAddressLabel = new JLabel("<html><u>Job Address</u></html>");
        JTextField jobAddressField = new JTextField(20);
        JTextField jobCityField = new JTextField(20);
        JTextField jobStateField = new JTextField(20);
        JTextField jobZipcodeField = new JTextField(20);

        panel.add(jobAddressLabel);
        panel.add(new JLabel(""));
        panel.add(new JLabel("Address"));
        panel.add(jobAddressField);
        panel.add(new JLabel("City"));
        panel.add(jobCityField);
        panel.add(new JLabel("State"));
        panel.add(jobStateField);  
        panel.add(new JLabel("Zipcode"));
        panel.add(jobZipcodeField);

        panel.add(sameAsJobAddressCheckbox);
        panel.add(new JLabel(""));

        JLabel billingAddressLabel = new JLabel("<html><u>Billing Address</u></html>");
        JTextField billingAddressField = new JTextField(20);
        JTextField billingCityField = new JTextField(20);
        JTextField billingStateField = new JTextField(20);
        JTextField billingZipcodeField = new JTextField(20);

        panel.add(billingAddressLabel);
        panel.add(new JLabel(""));
        panel.add(new JLabel("Address"));
        panel.add(billingAddressField);
        panel.add(new JLabel("City"));
        panel.add(billingCityField);
        panel.add(new JLabel("State"));
        panel.add(billingStateField);
        panel.add(new JLabel("Zipcode"));
        panel.add(billingZipcodeField);

        JButton createButton = new JButton("Create Client");
        panel.add(createButton);

        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (firstNameField.getText().isEmpty() || lastNameField.getText().isEmpty() || dateField.getText().isEmpty()
                        || emailField.getText().isEmpty() || phoneField.getText().isEmpty() || jobAddressField.getText().isEmpty()
                        || jobCityField.getText().isEmpty() || jobStateField.getText().isEmpty() || jobZipcodeField.getText().isEmpty()
                        || billingAddressField.getText().isEmpty() || billingCityField.getText().isEmpty()
                        || billingStateField.getText().isEmpty() || billingZipcodeField.getText().isEmpty()) {
        
                    // Show an error message when a field is empty
                    JOptionPane.showMessageDialog(frame, "All fields must be filled out", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    String jobAddress = jobAddressField.getText() + jobCityField.getText() + ", " + jobStateField.getText() + " " + jobZipcodeField.getText();
                    String billingAddress = billingAddressField.getText() + ", " + billingCityField.getText() + ", " + billingStateField.getText() + " " + billingZipcodeField.getText();
                    
                    String inputDate = dateField.getText();
                    String outputDate = convertDate(inputDate);

                    CustomerInfo customer = new CustomerInfo();
                    customer.setFirstName(firstNameField.getText());
                    customer.setLastName(lastNameField.getText());
                    customer.setDate(outputDate);
                    customer.setEmail(emailField.getText());
                    customer.setPhone(phoneField.getText());
                    customer.setJobAddress(jobAddress);
                    customer.setBillingAddress(billingAddress);
        
                    // Here you might want to add code to store the CustomerInfo object in your database
                    saveCustomerInfo(customer);
        
                    System.out.println("Client created");
                    // After creating the client, you could navigate to another page, for example:
                    new BidSheetGUI();
                    frame.dispose();
                }
            }
        });

        sameAsJobAddressCheckbox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    // Checkbox has been selected
                    billingAddressField.setEnabled(false);
                    billingCityField.setEnabled(false);
                    billingStateField.setEnabled(false);
                    billingZipcodeField.setEnabled(false);
        
                    billingAddressField.setText(jobAddressField.getText());
                    billingCityField.setText(jobCityField.getText());
                    billingStateField.setText(jobStateField.getText());
                    billingZipcodeField.setText(jobZipcodeField.getText());
                } else {
                    // Checkbox has been deselected
                    billingAddressField.setEnabled(true);
                    billingCityField.setEnabled(true);
                    billingStateField.setEnabled(true);
                    billingZipcodeField.setEnabled(true);
                }
            }
        });

    
        // Call this method for each pair of job/billing address fields
        setupAddressFieldSync(jobAddressField, billingAddressField);
        setupAddressFieldSync(jobCityField, billingCityField);
        setupAddressFieldSync(jobStateField, billingStateField);
        setupAddressFieldSync(jobZipcodeField, billingZipcodeField);
        
        

        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    
    }

    private void setupAddressFieldSync(JTextField source, JTextField target) {
        source.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                syncFields();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                syncFields();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                syncFields();
            }

            private void syncFields() {
                if (sameAsJobAddressCheckbox.isSelected()) {
                    target.setText(source.getText());
                }
            }
        });

    }

    public static String convertDate(String inputDate) {
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        // Parse the input date
        LocalDate date = LocalDate.parse(inputDate, inputFormatter);
        
        // Format the date in the output format and return it
        return date.format(outputFormatter);
    }

    public static void saveCustomerInfo(CustomerInfo customer){

        // SQL query to insert a new record in your "logininfo" table
        String sql = "INSERT INTO customers (firstName, lastName, dateEntered, emailAddress, PhoneNumber, jobSiteAddress, billingAddress) VALUES (?, ?, ?, ?, ?, ?, ?)";
    
        // 1. Test connection
        try(Connection conn = sqlcon.getConnection()){
 
        // 2. Create a statement
        PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, customer.getFirstName());
            stmt.setString(2, customer.getLastName());
            stmt.setString(3, customer.getDate());
            stmt.setString(4, customer.getEmail());
            stmt.setString(5, customer.getPhone());
            stmt.setString(6, customer.getJobAddress());
            stmt.setString(7, customer.getBillingAddress());
    
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

