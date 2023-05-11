package main;
import java.awt.EventQueue;

import javax.swing.JFrame;

import javax.swing.JTextPane;
import java.awt.TextField;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.JButton;

public class proposal {

	private JFrame frame;
	private final JTextField txtCustName = new JTextField();
	private JTextField txtAddress;
	private JTextField txtDate;
	private JTextField txtCityInfo;
	private JTextField txtPhoneNum;
	private JTextField txtServ1;
	private JTextField txtServ2;
	private JTextField txtDesc2;
	private JTextField txtDesc;
	private JTextField txtTotal1;
	private JTextField txtTotal2;
	private final JSeparator separator_9 = new JSeparator();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					proposal window = new proposal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public proposal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
        frame.setBounds(100, 100, 660, 513);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(56, 16, 2, 0);
		separator_1.setOrientation(SwingConstants.VERTICAL);
		frame.getContentPane().add(separator_1);
		
		JLabel LBLcustomerName = new JLabel("Customer Name:");
		LBLcustomerName.setBounds(122, 9, 151, 14);
		frame.getContentPane().add(LBLcustomerName);
		txtCustName.setBounds(273, 6, 151, 20);
		frame.getContentPane().add(txtCustName);
		txtCustName.setColumns(10);
		
		JLabel lblDate = new JLabel("Date: ");
		lblDate.setBounds(522, 9, 30, 14);
		frame.getContentPane().add(lblDate);
		
		txtDate = new JTextField();
		txtDate.setBounds(558, 6, 36, 20);
		frame.getContentPane().add(txtDate);
		txtDate.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(122, 32, 472, 2);
		frame.getContentPane().add(separator);
		
		JLabel lblAddress = new JLabel("Address: ");
		lblAddress.setBounds(122, 43, 151, 14);
		frame.getContentPane().add(lblAddress);
		
		txtAddress = new JTextField();
		txtAddress.setBounds(273, 40, 321, 20);
		frame.getContentPane().add(txtAddress);
		txtAddress.setColumns(10);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(122, 66, 472, 2);
		frame.getContentPane().add(separator_2);
		
		JLabel lblCityInfo = new JLabel("City, State, Zip code");
		lblCityInfo.setBounds(122, 77, 151, 14);
		frame.getContentPane().add(lblCityInfo);
		
		txtCityInfo = new JTextField();
		txtCityInfo.setBounds(273, 74, 321, 20);
		frame.getContentPane().add(txtCityInfo);
		txtCityInfo.setColumns(10);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(122, 100, 472, 2);
		frame.getContentPane().add(separator_3);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setBounds(122, 111, 151, 14);
		frame.getContentPane().add(lblPhoneNumber);
		
		txtPhoneNum = new JTextField();
		txtPhoneNum.setBounds(273, 108, 321, 20);
		frame.getContentPane().add(txtPhoneNum);
		txtPhoneNum.setColumns(10);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(116, 134, 484, 2);
		separator_4.setForeground(SystemColor.desktop);
		frame.getContentPane().add(separator_4);
		separator_9.setBounds(600, 134, 2, 98);
		separator_9.setForeground(SystemColor.desktop);
		separator_9.setOrientation(SwingConstants.VERTICAL);
		frame.getContentPane().add(separator_9);
		
		JLabel lblService = new JLabel("Service");
		lblService.setBounds(122, 142, 151, 14);
		lblService.setFont(new Font("Tahoma", Font.BOLD, 11));
		frame.getContentPane().add(lblService);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setBounds(304, 142, 120, 14);
		lblDescription.setFont(new Font("Tahoma", Font.BOLD, 11));
		frame.getContentPane().add(lblDescription);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setBounds(455, 142, 97, 14);
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 11));
		frame.getContentPane().add(lblTotal);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(116, 162, 484, 2);
		separator_5.setForeground(SystemColor.desktop);
		frame.getContentPane().add(separator_5);
		
		txtServ1 = new JTextField();
		txtServ1.setBounds(122, 170, 151, 20);
		frame.getContentPane().add(txtServ1);
		txtServ1.setColumns(10);
		
		txtDesc = new JTextField();
		txtDesc.setBounds(304, 170, 120, 20);
		frame.getContentPane().add(txtDesc);
		txtDesc.setColumns(10);
		
		txtTotal1 = new JTextField();
		txtTotal1.setBounds(455, 170, 97, 20);
		frame.getContentPane().add(txtTotal1);
		txtTotal1.setColumns(10);
		
		JSeparator separator_7 = new JSeparator();
		separator_7.setBounds(116, 196, 484, 2);
		separator_7.setForeground(SystemColor.desktop);
		frame.getContentPane().add(separator_7);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setBounds(114, 134, 2, 98);
		separator_6.setForeground(SystemColor.desktop);
		separator_6.setOrientation(SwingConstants.VERTICAL);
		frame.getContentPane().add(separator_6);
		
		txtServ2 = new JTextField();
		txtServ2.setBounds(122, 204, 151, 20);
		frame.getContentPane().add(txtServ2);
		txtServ2.setColumns(10);
		
		txtDesc2 = new JTextField();
		txtDesc2.setBounds(304, 204, 120, 20);
		frame.getContentPane().add(txtDesc2);
		txtDesc2.setColumns(10);
		
		txtTotal2 = new JTextField();
		txtTotal2.setBounds(455, 204, 97, 20);
		frame.getContentPane().add(txtTotal2);
		txtTotal2.setColumns(10);
		
		JSeparator separator_8 = new JSeparator();
		separator_8.setBounds(116, 230, 484, 2);
		separator_8.setForeground(SystemColor.desktop);
		frame.getContentPane().add(separator_8);
		
		JLabel lblCreditCard = new JLabel("Credit Card payments will be charged an additional 2.7%");
		lblCreditCard.setBounds(122, 263, 478, 17);
		lblCreditCard.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frame.getContentPane().add(lblCreditCard);
		
		JLabel lblContract1 = new JLabel("WORK AUTHORIZATION:  I, the undersigned owner / property manager / tenant (circle one) of the Job Site Address listed above ");
		lblContract1.setBounds(122, 286, 480, 25);
		lblContract1.setFont(new Font("Tahoma", Font.PLAIN, 7));
		frame.getContentPane().add(lblContract1);
		
		JLabel lblContract2 = new JLabel(" hereby affirm that (i) I am authorized to execute this Agreement, and (ii) by signing below, I authorize M & B Services, Inc. to ");
		lblContract2.setBounds(122, 311, 486, 9);
		lblContract2.setFont(new Font("Tahoma", Font.PLAIN, 7));
		frame.getContentPane().add(lblContract2);
		
		JLabel lblContract3 = new JLabel("perform such other labor and use such materials as it deems advisable to complete the project.  I have read this Agreement, ");
		lblContract3.setBounds(122, 326, 486, 9);
		lblContract3.setFont(new Font("Tahoma", Font.PLAIN, 7));
		frame.getContentPane().add(lblContract3);
		
		JLabel lblContract4 = new JLabel("including the Terms and Conditions on the reverse side and agree to be bound by them. ");
		lblContract4.setBounds(122, 341, 486, 9);
		lblContract4.setFont(new Font("Tahoma", Font.PLAIN, 7));
		frame.getContentPane().add(lblContract4);
		
		JLabel lblSigniture = new JLabel("Customer Signature ___________");
		lblSigniture.setBounds(122, 382, 151, 11);
		lblSigniture.setFont(new Font("Tahoma", Font.PLAIN, 9));
		frame.getContentPane().add(lblSigniture);
		
		JLabel lblPrintedName = new JLabel("Printed Name: _________");
		lblPrintedName.setBounds(304, 382, 120, 11);
		lblPrintedName.setFont(new Font("Tahoma", Font.PLAIN, 9));
		frame.getContentPane().add(lblPrintedName);
		
		JLabel lblNewLabel = new JLabel("Date: _____");
		lblNewLabel.setBounds(455, 381, 97, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnConvertToPdf = new JButton("Generate");
		btnConvertToPdf.setBounds(122, 426, 182, 23);
		frame.getContentPane().add(btnConvertToPdf);
	}

}
