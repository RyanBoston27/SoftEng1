package main;
import classes.BidSheet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class ProposalDocGUI extends JFrame {

    private BidSheet sheet = new BidSheet();

    private JTextField waterDescriptionField;
    private JTextField waterCostField;
    private JTextField sewerDescriptionField;
    private JTextField sewerCostField;
    private JTextField liningDescriptionField;
    private JTextField liningCostField;

    private String wDesc;
    private String wCost;
    private String sDesc;
    private String sCost;
    private String lDesc;
    private String lCost;
    private String totalCost;

    public ProposalDocGUI(BidSheet sheet) {
        this.sheet = sheet;
        setupUI();
    }

    private void setupUI() {
        // Set the layout manager to a grid
        setLayout(new GridLayout(5, 3)); // Adjust grid size as needed

        // Add the header row
        add(new JLabel("Service"));
        add(new JLabel("Description"));
        add(new JLabel("Cost"));

        // Add the rows for services

        // Water service row
        add(new JLabel("Water Service"));
        waterDescriptionField = new JTextField();
        waterCostField = new JTextField();
        waterDescriptionField.setEnabled(sheet.getWaterService().hasData());
        waterCostField.setEnabled(sheet.getWaterService().hasData());
        add(waterDescriptionField); // Description
        add(waterCostField); // Cost

        // Sewer service row
        add(new JLabel("Sewer Service"));
        sewerDescriptionField = new JTextField();
        sewerCostField = new JTextField();
        sewerDescriptionField.setEnabled(sheet.getSewerService().hasData());
        sewerCostField.setEnabled(sheet.getSewerService().hasData());
        add(sewerDescriptionField); // Description
        add(sewerCostField); // Cost

        // Lining service row
        add(new JLabel("Lining Service"));
        liningDescriptionField = new JTextField();
        liningCostField = new JTextField();
        liningDescriptionField.setEnabled(sheet.getLiningService().hasData());
        liningCostField.setEnabled(sheet.getLiningService().hasData());
        add(liningDescriptionField); // Description
        add(liningCostField); // Cost

        // Add "Create Proposal" button
        JButton createProposalButton = new JButton("Create Proposal");
        createProposalButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                wDesc = waterDescriptionField.getText();
                wCost = waterCostField.getText();
                sDesc = sewerDescriptionField.getText();
                sCost = sewerCostField.getText();
                lDesc = liningDescriptionField.getText();
                lCost = liningCostField.getText();
                System.out.println(wDesc);
                if(wCost.isEmpty()){
                    wCost = "0";
                }
                if(sCost.isEmpty()){
                    sCost = "0";
                }
                if(lCost.isEmpty()){
                    lCost = "0";
                }
                int wCostVal = Integer.parseInt(wCost);
                int sCostVal = Integer.parseInt(sCost);
                int lCostVal = Integer.parseInt(lCost);
                int total = wCostVal + sCostVal + lCostVal;

                totalCost = String.valueOf(total);

                String texFilePath = "./src/main/latex/proposal.tex";
        
                try {
                    new ProposalDocGenerate(texFilePath, sheet, wDesc, wCost, sDesc, sCost, lDesc, lCost, totalCost);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                dispose();
                // Close current frame
                // Open LandingPageGUI
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
        add(createProposalButton);

        // Set JFrame parameters
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}
