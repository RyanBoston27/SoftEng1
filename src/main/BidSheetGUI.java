package oneLastTry;

import java.awt.EventQueue;

import javax.swing.JFrame;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BidSheetGUI {

	private JFrame frame;
	private JLabel lblPropertyLine2;
	private JTextField txtName;
	private JTextField txtEmail;
	private JTextField txtJobAdd;
	private JTextField txtDate;
	private JTextField txtPhone;
	private JTextField txtBillAdd;
	private JTextField txtAddFt;
	private JTextField txtAppFt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BidSheetGUI window = new BidSheetGUI();
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
	public BidSheetGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 486, 611);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCusName = new JLabel("Customer Name:  ");
		lblCusName.setBounds(6, 6, 86, 14);
		frame.getContentPane().add(lblCusName);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setBounds(295, 6, 27, 14);
		frame.getContentPane().add(lblDate);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(6, 26, 86, 14);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblNewLabel_4 = new JLabel("Phone:");
		lblNewLabel_4.setBounds(288, 26, 34, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblJobAdd = new JLabel("Job Site Address:");
		lblJobAdd.setBounds(6, 46, 86, 14);
		frame.getContentPane().add(lblJobAdd);
		
		JLabel lblBillAdd = new JLabel("Billing Address:");
		lblBillAdd.setBounds(6, 66, 86, 14);
		frame.getContentPane().add(lblBillAdd);
		
		JLabel lblDesc = new JLabel("Description of services to be performed:");
		lblDesc.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDesc.setBounds(6, 86, 234, 14);
		frame.getContentPane().add(lblDesc);
		
		JSeparator separator1 = new JSeparator();
		separator1.setBounds(0, 106, 470, 2);
		frame.getContentPane().add(separator1);
		
		JLabel lblWaterServ = new JLabel("1. Water Service:");
		lblWaterServ.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblWaterServ.setBounds(6, 114, 109, 14);
		frame.getContentPane().add(lblWaterServ);
		
		JLabel lblSize = new JLabel("Size:");
		lblSize.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSize.setBounds(125, 114, 28, 14);
		frame.getContentPane().add(lblSize);
		
		JLabel lblApproxFt1 = new JLabel("Approx. feet:  ");
		lblApproxFt1.setBounds(221, 114, 81, 14);
		frame.getContentPane().add(lblApproxFt1);
		
		JLabel lblDrop = new JLabel("Drop:  ");
		lblDrop.setBounds(388, 106, 41, 20);
		frame.getContentPane().add(lblDrop);
		
		JLabel lblBackFlow = new JLabel("Back flow:");
		lblBackFlow.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBackFlow.setBounds(16, 139, 69, 14);
		frame.getContentPane().add(lblBackFlow);
		
		JLabel lblPropertyLine = new JLabel("Property Line:");
		lblPropertyLine.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPropertyLine.setBounds(4, 163, 81, 14);
		frame.getContentPane().add(lblPropertyLine);
		
		JLabel lblAddHorFt = new JLabel("Additional horizontal Ft:");
		lblAddHorFt.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAddHorFt.setBounds(222, 139, 134, 14);
		frame.getContentPane().add(lblAddHorFt);
		
		JLabel lblBlvd = new JLabel("Blvd:");
		lblBlvd.setBounds(233, 163, 27, 14);
		frame.getContentPane().add(lblBlvd);
		
		JLabel lblCityMain = new JLabel("City main:");
		lblCityMain.setBounds(295, 163, 48, 14);
		frame.getContentPane().add(lblCityMain);
		
		JLabel lblSewerService = new JLabel("2: Sewer Service: ");
		lblSewerService.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSewerService.setBounds(10, 190, 105, 14);
		frame.getContentPane().add(lblSewerService);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(0, 188, 470, 2);
		frame.getContentPane().add(separator_2);
		
		JLabel lblSize2 = new JLabel("Size:");
		lblSize2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSize2.setBounds(94, 190, 59, 14);
		frame.getContentPane().add(lblSize2);
		
		JLabel lblApproxFt2 = new JLabel("Approx. feet:");
		lblApproxFt2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblApproxFt2.setBounds(198, 190, 81, 14);
		frame.getContentPane().add(lblApproxFt2);
		
		lblPropertyLine2 = new JLabel("Property Line:");
		lblPropertyLine2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPropertyLine2.setBounds(72, 224, 81, 14);
		frame.getContentPane().add(lblPropertyLine2);
		
		JLabel lblCityMain_1 = new JLabel("City main:");
		lblCityMain_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCityMain_1.setBounds(220, 215, 59, 14);
		frame.getContentPane().add(lblCityMain_1);
		
		JSeparator separator2 = new JSeparator();
		separator2.setBounds(0, 236, 470, 2);
		frame.getContentPane().add(separator2);
		
		JLabel lblLiningService = new JLabel("3: lining Service:");
		lblLiningService.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLiningService.setBounds(10, 240, 105, 14);
		frame.getContentPane().add(lblLiningService);
		
		JLabel lblSize3 = new JLabel("Size:");
		lblSize3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSize3.setBounds(115, 240, 59, 14);
		frame.getContentPane().add(lblSize3);
		
		JLabel lblApproxFt3 = new JLabel("Approx. feet:  ");
		lblApproxFt3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblApproxFt3.setBounds(222, 240, 76, 14);
		frame.getContentPane().add(lblApproxFt3);
		
		JLabel lblExcavate = new JLabel("Excavate:  ");
		lblExcavate.setBounds(243, 265, 59, 14);
		frame.getContentPane().add(lblExcavate);
		
		JLabel lblTranLiner = new JLabel("Transition Liner:");
		lblTranLiner.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTranLiner.setBounds(51, 275, 123, 14);
		frame.getContentPane().add(lblTranLiner);
		
		JLabel lblFurnish = new JLabel("4. Furnish permits:");
		lblFurnish.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFurnish.setBounds(0, 292, 93, 14);
		frame.getContentPane().add(lblFurnish);
		
		JLabel lblBreakUp = new JLabel("5.  Break-up floor:");
		lblBreakUp.setBounds(6, 317, 99, 14);
		frame.getContentPane().add(lblBreakUp);
		
		JLabel lblRecement = new JLabel("6. Recement floor: ");
		lblRecement.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRecement.setBounds(0, 345, 99, 14);
		frame.getContentPane().add(lblRecement);
		
		JLabel lblTraffic = new JLabel("7. Traffic Control:");
		lblTraffic.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTraffic.setBounds(-7, 370, 99, 14);
		frame.getContentPane().add(lblTraffic);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(6, 421, 454, 107);
		frame.getContentPane().add(textArea);
		
		JLabel lblRemarks = new JLabel("Remarks:");
		lblRemarks.setBounds(10, 405, 46, 14);
		frame.getContentPane().add(lblRemarks);
		
		JSeparator separator3 = new JSeparator();
		separator3.setBounds(0, 394, 470, 2);
		frame.getContentPane().add(separator3);
		
		JLabel lblExplain = new JLabel("Explain:");
		lblExplain.setBounds(253, 290, 46, 14);
		frame.getContentPane().add(lblExplain);
		
		txtName = new JTextField();
		txtName.setBounds(102, 3, 173, 20);
		frame.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(102, 23, 173, 20);
		frame.getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		
		txtJobAdd = new JTextField();
		txtJobAdd.setBounds(102, 43, 358, 20);
		frame.getContentPane().add(txtJobAdd);
		txtJobAdd.setColumns(10);
		
		txtDate = new JTextField();
		txtDate.setBounds(337, 3, 123, 20);
		frame.getContentPane().add(txtDate);
		txtDate.setColumns(10);
		
		txtPhone = new JTextField();
		txtPhone.setBounds(337, 23, 123, 20);
		frame.getContentPane().add(txtPhone);
		txtPhone.setColumns(10);
		
		txtBillAdd = new JTextField();
		txtBillAdd.setBounds(102, 63, 358, 20);
		frame.getContentPane().add(txtBillAdd);
		txtBillAdd.setColumns(10);
		
		JRadioButton rdbtn34 = new JRadioButton("3/4\"");
		rdbtn34.setBounds(159, 114, 46, 14);
		frame.getContentPane().add(rdbtn34);
		
		JRadioButton rdbtn1 = new JRadioButton("1\"");
		rdbtn1.setBounds(159, 131, 46, 14);
		frame.getContentPane().add(rdbtn1);
		
		JRadioButton rdbtn2 = new JRadioButton("2\"");
		rdbtn2.setBounds(159, 148, 46, 14);
		frame.getContentPane().add(rdbtn2);
		
		JCheckBox chckBackFlow = new JCheckBox("");
		chckBackFlow.setHorizontalAlignment(SwingConstants.LEFT);
		chckBackFlow.setBounds(91, 135, 27, 23);
		frame.getContentPane().add(chckBackFlow);
		
		JCheckBox chckPropLine = new JCheckBox("");
		chckPropLine.setBounds(91, 159, 27, 23);
		frame.getContentPane().add(chckPropLine);
		
		JCheckBox chckBlvd = new JCheckBox("");
		chckBlvd.setHorizontalAlignment(SwingConstants.LEFT);
		chckBlvd.setBounds(263, 159, 27, 23);
		frame.getContentPane().add(chckBlvd);
		
		JCheckBox chckDrop = new JCheckBox("");
		chckDrop.setBounds(427, 105, 21, 23);
		frame.getContentPane().add(chckDrop);
		
		txtAddFt = new JTextField();
		txtAddFt.setBounds(362, 136, 86, 20);
		frame.getContentPane().add(txtAddFt);
		txtAddFt.setColumns(10);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(303, 109, 72, 22);
		frame.getContentPane().add(textArea_1);
		
		JCheckBox chckCityMain = new JCheckBox("");
		chckCityMain.setBounds(348, 159, 27, 23);
		frame.getContentPane().add(chckCityMain);
		
		JCheckBox chckFurnish = new JCheckBox("");
		chckFurnish.setBounds(118, 292, 21, 23);
		frame.getContentPane().add(chckFurnish);
		
		JCheckBox chckBreak = new JCheckBox("");
		chckBreak.setBounds(117, 317, 22, 23);
		frame.getContentPane().add(chckBreak);
		
		JCheckBox chckRece = new JCheckBox("");
		chckRece.setBounds(118, 344, 21, 23);
		frame.getContentPane().add(chckRece);
		
		JCheckBox chckTraffic = new JCheckBox("");
		chckTraffic.setBounds(117, 370, 22, 23);
		frame.getContentPane().add(chckTraffic);
		
		JRadioButton rdbtn4 = new JRadioButton("4\"");
		rdbtn4.setBounds(159, 190, 48, 14);
		frame.getContentPane().add(rdbtn4);
		
		JRadioButton rdbtn6 = new JRadioButton("6\"");
		rdbtn6.setBounds(159, 207, 46, 14);
		frame.getContentPane().add(rdbtn6);
		
		JTextArea textAppFt2 = new JTextArea();
		textAppFt2.setBounds(289, 188, 72, 22);
		frame.getContentPane().add(textAppFt2);
		
		JCheckBox chckCityMain2 = new JCheckBox("");
		chckCityMain2.setBounds(283, 215, 27, 23);
		frame.getContentPane().add(chckCityMain2);
		
		JCheckBox chckPropLine2 = new JCheckBox("");
		chckPropLine2.setBounds(159, 220, 21, 18);
		frame.getContentPane().add(chckPropLine2);
		
		JRadioButton rdbtn4_1 = new JRadioButton("4\"");
		rdbtn4_1.setBounds(179, 240, 48, 14);
		frame.getContentPane().add(rdbtn4_1);
		
		JRadioButton rdbtn6_1 = new JRadioButton("6\"");
		rdbtn6_1.setBounds(179, 258, 48, 14);
		frame.getContentPane().add(rdbtn6_1);
		
		JCheckBox chckTranLine2 = new JCheckBox("");
		chckTranLine2.setBounds(179, 271, 27, 23);
		frame.getContentPane().add(chckTranLine2);
		
		txtAppFt = new JTextField();
		txtAppFt.setBounds(295, 237, 129, 20);
		frame.getContentPane().add(txtAppFt);
		txtAppFt.setColumns(10);
		
		JCheckBox chckExcavate = new JCheckBox("");
		chckExcavate.setBounds(295, 261, 27, 23);
		frame.getContentPane().add(chckExcavate);
		
		JCheckBox chckNoPack = new JCheckBox("No Packing Signs");
		chckNoPack.setBounds(295, 286, 123, 23);
		frame.getContentPane().add(chckNoPack);
		
		JCheckBox chckLaneSh = new JCheckBox("Lane Shift");
		chckLaneSh.setBounds(295, 313, 97, 23);
		frame.getContentPane().add(chckLaneSh);
		
		JCheckBox chcksDetour = new JCheckBox("Detour");
		chcksDetour.setBounds(295, 341, 97, 23);
		frame.getContentPane().add(chcksDetour);
		
		JButton btnSub = new JButton("Submit");
		btnSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSub.setBounds(159, 539, 139, 23);
		frame.getContentPane().add(btnSub);
	}
}
