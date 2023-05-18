package main;
import classes.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
//import java.io.IOException;
import java.io.IOException;

public class BidSheetGUI extends JFrame {
    private CustomerInfo customerInfo;
    private LiningService liningService = new LiningService();
    private SewerService sewerService = new SewerService();
    private WaterService waterService = new WaterService();
    private BidSheet sheet = new BidSheet();

    // Checkboxes
    private JCheckBox waterServiceCheckBox, sewerServiceCheckBox, liningServiceCheckBox;
    private JCheckBox dropCheckBox, backFlowCheckBox, propertyLineCheckBoxWater, blvdCheckBox, cityMainCheckBoxWater;
    private JCheckBox propertyLineCheckBoxSewer, cityMainCheckBoxSewer, excavateCheckBox;
    private JCheckBox furnishPermitsCheckBox, breakUpFloorCheckBox, recementFloorCheckBox, trafficControlCheckBox;

    // Text fields and areas
    private JTextField sizeFieldWater, approxFeetFieldWater, additionalHorizFeetField;
    private JTextField sizeFieldSewer, approxFeetFieldSewer;
    private JTextField sizeFieldLining, approxFeetFieldLining, transitionLinerField;
    private JTextField trafficControlExplanationField;
    private JTextArea remarksArea;

    // Panels
    private JPanel waterServicePanel, sewerServicePanel, liningServicePanel, additionalInfoPanel;

    public BidSheetGUI(CustomerInfo inputCustomerInfo) {
        this.customerInfo = new CustomerInfo(inputCustomerInfo);


        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 800); 
        setTitle("Bid Sheet for " + customerInfo.getFirstName());

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS)); 

        JLabel customerNameLabel = new JLabel("Customer Name: " + customerInfo.getFirstName());
        add(customerNameLabel);
        
        //I cant get this button to display
        JButton createBidSheetButton = new JButton("Create BidSheet");
        add(createBidSheetButton);
        //idk why

        waterServiceCheckBox = new JCheckBox("Water Service");
        sewerServiceCheckBox = new JCheckBox("Sewer Service");
        liningServiceCheckBox = new JCheckBox("Lining Service");

        waterServicePanel = new JPanel();
        waterServicePanel.setLayout(new BoxLayout(waterServicePanel, BoxLayout.Y_AXIS));

        sewerServicePanel = new JPanel();
        sewerServicePanel.setLayout(new BoxLayout(sewerServicePanel, BoxLayout.Y_AXIS));

        liningServicePanel = new JPanel();
        liningServicePanel.setLayout(new BoxLayout(liningServicePanel, BoxLayout.Y_AXIS));

        additionalInfoPanel = new JPanel();
        additionalInfoPanel.setLayout(new GridLayout(7, 2));

        JPanel waterServiceHolder = new JPanel();
        waterServiceHolder.setLayout(new BoxLayout(waterServiceHolder, BoxLayout.Y_AXIS));
        waterServiceHolder.add(waterServiceCheckBox);
        waterServiceHolder.add(waterServicePanel);
        add(waterServiceHolder);

        JPanel sewerServiceHolder = new JPanel();
        sewerServiceHolder.setLayout(new BoxLayout(sewerServiceHolder, BoxLayout.Y_AXIS));
        sewerServiceHolder.add(sewerServiceCheckBox);
        sewerServiceHolder.add(sewerServicePanel);
        add(sewerServiceHolder);

        JPanel liningServiceHolder = new JPanel();
        liningServiceHolder.setLayout(new BoxLayout(liningServiceHolder, BoxLayout.Y_AXIS));
        liningServiceHolder.add(liningServiceCheckBox);
        liningServiceHolder.add(liningServicePanel);
        add(liningServiceHolder);

        add(additionalInfoPanel);

        // Now instantiate all the fields and checkboxes,
        // initially setting the text fields to non-editable and the checkboxes to disabled

        // Water Service fields and checkboxes
        sizeFieldWater = new JTextField();
        sizeFieldWater.setEditable(false);
        approxFeetFieldWater = new JTextField();
        approxFeetFieldWater.setEditable(false);
        additionalHorizFeetField = new JTextField();
        additionalHorizFeetField.setEditable(false);
        dropCheckBox = new JCheckBox("Drop");
        dropCheckBox.setEnabled(false);
        backFlowCheckBox = new JCheckBox("Back Flow");
        backFlowCheckBox.setEnabled(false);
        propertyLineCheckBoxWater = new JCheckBox("Property Line");
        propertyLineCheckBoxWater.setEnabled(false);
        blvdCheckBox = new JCheckBox("Blvd");
        blvdCheckBox.setEnabled(false);
        cityMainCheckBoxWater = new JCheckBox("City Main");
        cityMainCheckBoxWater.setEnabled(false);

        waterServicePanel.add(new JLabel("Size"));
        waterServicePanel.add(sizeFieldWater);
        waterServicePanel.add(new JLabel("Approx Feet"));
        waterServicePanel.add(approxFeetFieldWater);
        waterServicePanel.add(dropCheckBox);
        waterServicePanel.add(backFlowCheckBox);
        waterServicePanel.add(new JLabel("Additional Horiz Feet"));
        waterServicePanel.add(additionalHorizFeetField);
        waterServicePanel.add(propertyLineCheckBoxWater);
        waterServicePanel.add(blvdCheckBox);
        waterServicePanel.add(cityMainCheckBoxWater);

        waterServiceCheckBox.addItemListener(e -> {
            boolean isSelected = e.getStateChange() == ItemEvent.SELECTED;
            sizeFieldWater.setEditable(isSelected);
            approxFeetFieldWater.setEditable(isSelected);
            additionalHorizFeetField.setEditable(isSelected);
            dropCheckBox.setEnabled(isSelected);
            backFlowCheckBox.setEnabled(isSelected);
            propertyLineCheckBoxWater.setEnabled(isSelected);
            blvdCheckBox.setEnabled(isSelected);
            cityMainCheckBoxWater.setEnabled(isSelected);
        });

        // Sewer Service fields and checkboxes
        sizeFieldSewer = new JTextField();
        sizeFieldSewer.setEditable(false);
        approxFeetFieldSewer = new JTextField();
        approxFeetFieldSewer.setEditable(false);
        propertyLineCheckBoxSewer = new JCheckBox("Property Line");
        propertyLineCheckBoxSewer.setEnabled(false);
        cityMainCheckBoxSewer = new JCheckBox("City Main");
        cityMainCheckBoxSewer.setEnabled(false);

        sewerServicePanel.add(new JLabel("Size"));
        sewerServicePanel.add(sizeFieldSewer);
        sewerServicePanel.add(new JLabel("Approx Feet"));
        sewerServicePanel.add(approxFeetFieldSewer);
        sewerServicePanel.add(propertyLineCheckBoxSewer);
        sewerServicePanel.add(cityMainCheckBoxSewer);

        sewerServiceCheckBox.addItemListener(e -> {
            boolean isSelected = e.getStateChange() == ItemEvent.SELECTED;
            sizeFieldSewer.setEditable(isSelected);
            approxFeetFieldSewer.setEditable(isSelected);
            propertyLineCheckBoxSewer.setEnabled(isSelected);
            cityMainCheckBoxSewer.setEnabled(isSelected);
        });

        // Lining Service fields and checkboxes
        sizeFieldLining = new JTextField();
        sizeFieldLining.setEditable(false);
        approxFeetFieldLining = new JTextField();
        approxFeetFieldLining.setEditable(false);
        excavateCheckBox = new JCheckBox("Excavate");
        excavateCheckBox.setEnabled(false);
        transitionLinerField = new JTextField();
        transitionLinerField.setEditable(false);

        liningServicePanel.add(new JLabel("Size"));
        liningServicePanel.add(sizeFieldLining);
        liningServicePanel.add(new JLabel("Approx Feet"));
        liningServicePanel.add(approxFeetFieldLining);
        liningServicePanel.add(excavateCheckBox);
        liningServicePanel.add(new JLabel("Transition Liner"));
        liningServicePanel.add(transitionLinerField);

        liningServiceCheckBox.addItemListener(e -> {
            boolean isSelected = e.getStateChange() == ItemEvent.SELECTED;
            sizeFieldLining.setEditable(isSelected);
            approxFeetFieldLining.setEditable(isSelected);
            excavateCheckBox.setEnabled(isSelected);
            transitionLinerField.setEditable(isSelected);
        });

        // Additional Info fields and checkboxes
        furnishPermitsCheckBox = new JCheckBox("Furnish Permits");
        breakUpFloorCheckBox = new JCheckBox("Break-Up Floor");
        recementFloorCheckBox = new JCheckBox("Recement Floor");
        trafficControlCheckBox = new JCheckBox("Traffic Control");
        trafficControlExplanationField = new JTextField();
        trafficControlExplanationField.setEditable(false);
        remarksArea = new JTextArea(3, 20);
        remarksArea.setEditable(true);  // This field should always be editable

        additionalInfoPanel.add(furnishPermitsCheckBox);
        additionalInfoPanel.add(breakUpFloorCheckBox);
        additionalInfoPanel.add(recementFloorCheckBox);
        additionalInfoPanel.add(trafficControlCheckBox);
        additionalInfoPanel.add(new JLabel("Explain"));
        additionalInfoPanel.add(trafficControlExplanationField);
        additionalInfoPanel.add(new JLabel("Remarks"));
        additionalInfoPanel.add(new JScrollPane(remarksArea));

        trafficControlCheckBox.addItemListener(e -> {
            boolean isSelected = e.getStateChange() == ItemEvent.SELECTED;
            trafficControlExplanationField.setEditable(isSelected);
        });

        pack();
        setLocationRelativeTo(null); 
        createBidSheetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
               //setting water service classes
               if(sizeFieldWater != null){
               waterService.setSize(sizeFieldWater.getText());
               }
               waterService.setApproxFeet(approxFeetFieldWater.getText());
               waterService.setDrop(dropCheckBox.isSelected());
               waterService.setBackFlow(backFlowCheckBox.isSelected());
               waterService.setAddHorizFeet(additionalHorizFeetField.getText());
               waterService.setPropertyLine(propertyLineCheckBoxWater.isSelected());
               waterService.setBlvd(blvdCheckBox.isSelected());
               waterService.setCityMain(cityMainCheckBoxWater.isSelected());
               
               //setting sewer service classes
               sewerService.setSize(sizeFieldSewer.getText());
               sewerService.setBlvd(propertyLineCheckBoxSewer.isSelected());
               sewerService.setPropertyLine(propertyLineCheckBoxSewer.isSelected());
               sewerService.setCityMain(cityMainCheckBoxSewer.isSelected());

               //setting lining service classes
               liningService.setSize(sizeFieldLining.getText());
               liningService.setApproxFeet(approxFeetFieldLining.getText());
               liningService.setExcavate(excavateCheckBox.isSelected());
               liningService.setTransitionLiner(transitionLinerField.getText());
               
                //set bidsheet class  
                sheet.setCustomerInfo(inputCustomerInfo);
                sheet.setWaterService(waterService);
                sheet.setSewerService(sewerService);
                sheet.setLiningService(liningService);

                //set other fields
                sheet.setFurnishPermits(furnishPermitsCheckBox.isSelected());
                sheet.setBreakUpFloor(breakUpFloorCheckBox.isSelected());
                sheet.setRecementFloor(recementFloorCheckBox.isSelected());
                sheet.setTrafficControl(trafficControlCheckBox.isSelected());
                sheet.setExplain(trafficControlExplanationField.getText());
                sheet.setRemarks(remarksArea.getText());

                sheet.getLiningService().getSize();
                
                String texFilePath = "./src/main/latex/bid.tex";
                
                 
                try {
                    new bidSheetGenerate(texFilePath, sheet);

                } catch (IOException e1) {
                    e1.printStackTrace();
                } 

                dispose();
                try {
                    SwingUtilities.invokeLater(new Runnable() {
                        public void run() {
                            new LandingPageGUI();
                        }
                    });
                } catch (Exception r) {
                    r.printStackTrace();
                }
                
            }
        });
    }
}