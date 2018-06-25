package employeeform;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.JList;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.List;
import java.awt.Scrollbar;
import java.awt.Choice;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class NewEvent extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JFrame frame1;
	private JTextField textField_5;
	private JTextField textField_6;
	private JPasswordField passwordField;
	private JTextField textField_7;
	private JPasswordField passwordField_1;
	private JTextField textField_4;
	private JTextField textField_8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewEvent frame = new NewEvent();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NewEvent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 677, 771);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnFile.add(mntmExit);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEmployeeForm = new JLabel("Employee Form");
		lblEmployeeForm.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblEmployeeForm.setBounds(293, 17, 188, 36);
		contentPane.add(lblEmployeeForm);
		
		JLabel lblEmployeeId = new JLabel("Employee ID");
		lblEmployeeId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmployeeId.setBounds(98, 110, 112, 26);
		contentPane.add(lblEmployeeId);
		
		textField = new JTextField();
		textField.setBounds(266, 107, 188, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblName.setBounds(98, 158, 133, 32);
		contentPane.add(lblName);
		
		textField_1 = new JTextField();
		textField_1.setBounds(266, 163, 188, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSurname.setBounds(98, 201, 112, 26);
		contentPane.add(lblSurname);
		
		textField_2 = new JTextField();
		textField_2.setBounds(266, 203, 188, 26);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAge.setBounds(98, 238, 112, 37);
		contentPane.add(lblAge);
		
		textField_3 = new JTextField();
		textField_3.setBounds(266, 245, 188, 26);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblSetPassword = new JLabel("Set Password");
		lblSetPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSetPassword.setBounds(98, 286, 133, 28);
		contentPane.add(lblSetPassword);
		
		JButton btnSave = new JButton("Create");
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {if(Integer.parseInt(passwordField.getText())==Integer.parseInt((passwordField_1).getText()) ) {
					
					
					Connection conn=ConnectionClass.connectify();
					String sql="insert into employeeinfo values(?,?,?,?,?,?,?,?,?,?) ";
					PreparedStatement ptst = conn.prepareStatement(sql);
					ptst.setInt(1,Integer.parseInt(textField.getText() ));
					ptst.setString(2,textField_1.getText() );
					ptst.setString(3,textField_2.getText() );
					ptst.setInt(5,Integer.parseInt(textField_3.getText() ));
					
					ptst.setInt(4,Integer.parseInt(passwordField.getText()));
					ptst.setLong(6,Long.parseLong(textField_5.getText() ));
					ptst.setString(7,textField_6.getText() );
					ptst.setString(8,textField_7.getText() );
					ptst.setInt(9,Integer.parseInt(textField_4.getText()));
					ptst.setString(10,(textField_8.getText()));
					int x = ptst.executeUpdate();

					
					if(x==1) {
						ptst.close();
						String sql1="insert into employeeacad values(?,?,?,?,?,?,?) ";
						PreparedStatement ptst1 = conn.prepareStatement(sql1);
						ptst1.setInt(1, Integer.parseInt(textField.getText()));
						ptst1.setString(2, null);
						ptst1.setInt(3, 0);
						ptst1.setString(4, null);
						ptst1.setInt(5, 0);
						ptst1.setString(6, null);
						ptst1.setInt(7, 0);
						ptst1.executeUpdate();
						ptst1.close();
						String sql2="insert into employeeleave values(?,?,?,?) ";
						PreparedStatement ptst2 = conn.prepareStatement(sql2);
						ptst2.setInt(1, Integer.parseInt(textField.getText()));
						ptst2.setInt(2, 24);
						ptst2.setInt(3, 0);
						ptst2.setInt(4, 0);
						ptst2.executeUpdate();
						JOptionPane.showMessageDialog(null, "Record Saved Successfully");
						ptst2.close();
						conn.close();
						dispose();  
				        new Employee().frame.setVisible(true);
					}else JOptionPane.showMessageDialog(null, "Give your Correct Detials");}else JOptionPane.showMessageDialog(null, "Password mismatch");
					}
			catch(Exception ee) {
				JOptionPane.showMessageDialog(null, ee);
				
			}
			}
		});
		btnSave.setBounds(332, 656, 89, 23);
		contentPane.add(btnSave);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(523, 656, 89, 23);
		contentPane.add(btnExit);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
	            
				dispose();  
		        new Employee().frame.setVisible(true);
		       
		        
			}
		});
		btnNewButton.setBounds(121, 656, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblOnlyNumericValues = new JLabel("*only numeric values");
		lblOnlyNumericValues.setBounds(464, 295, 122, 14);
		contentPane.add(lblOnlyNumericValues);
		
		JLabel lblonlyNumericValues = new JLabel("*only numeric values");
		lblonlyNumericValues.setBounds(478, 118, 122, 14);
		contentPane.add(lblonlyNumericValues);
		
		JLabel lblMobile = new JLabel("Mobile");
		lblMobile.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMobile.setBounds(98, 377, 133, 28);
		contentPane.add(lblMobile);
		
		JLabel lblSecurityQue = new JLabel("Security Que");
		lblSecurityQue.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSecurityQue.setBounds(98, 580, 133, 28);
		contentPane.add(lblSecurityQue);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(266, 380, 188, 26);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(266, 583, 188, 26);
		contentPane.add(textField_6);
		
		JLabel lblWhatIsThe = new JLabel("What is the name of your pet?");
		lblWhatIsThe.setBounds(66, 619, 185, 26);
		contentPane.add(lblWhatIsThe);
		
		JLabel lblcaseSensitive = 
				new JLabel("*Case Sensitive");
		lblcaseSensitive.setBounds(472, 589, 114, 14);
		contentPane.add(lblcaseSensitive);
		
		JLabel lblConformPassword = new JLabel("Conform Password");
		lblConformPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblConformPassword.setBounds(98, 327, 133, 28);
		contentPane.add(lblConformPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(266, 330, 188, 26);
		contentPane.add(passwordField);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(266, 436, 188, 26);
		contentPane.add(textField_7);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmail.setBounds(98, 433, 133, 28);
		contentPane.add(lblEmail);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(266, 289, 188, 26);
		contentPane.add(passwordField_1);
		
		JLabel lblDoj = new JLabel("DOJ");
		lblDoj.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDoj.setBounds(98, 489, 133, 28);
		contentPane.add(lblDoj);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(266, 492, 188, 26);
		contentPane.add(textField_4);
		
		JLabel label = new JLabel("");
		Image image1 = new ImageIcon(this.getClass().getResource("/log1.png")).getImage();
		label.setIcon(new ImageIcon(image1));
		label.setBounds(23, 11, 260, 42);
		contentPane.add(label);
		
		JLabel lblBloodGroup = new JLabel("Address");
		lblBloodGroup.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBloodGroup.setBounds(98, 541, 133, 28);
		contentPane.add(lblBloodGroup);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(266, 544, 188, 26);
		contentPane.add(textField_8);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(-24, 0, 685, 711);
		Image image2 = new ImageIcon(this.getClass().getResource("/pa1.jpeg")).getImage();
		label_1.setIcon(new ImageIcon(image2));
		contentPane.add(label_1);
	}
}
