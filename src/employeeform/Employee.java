package employeeform;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Locale;
import java.util.ResourceBundle;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Color;

public class Employee {

	JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	Connection conn=null;
	static String eid;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Employee window = new Employee();
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
	public Employee() {
		initialize();
		 conn=ConnectionClass.connectify();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(204, 204, 153));
		frame.setBounds(100, 100, 590, 337);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(398, 75, 120, 31);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(302, 68, 86, 41);
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(302, 128, 86, 41);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		frame.getContentPane().add(lblPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(398, 211, 105, 31);
		Image image = new ImageIcon(this.getClass().getResource("/ok.png")).getImage();
		btnLogin.setIcon(new ImageIcon(image));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {	
					String sql="select * from employeeinfo where eid=? and password=? ";
					PreparedStatement ptst = conn.prepareStatement(sql);
					ptst.setString(1,textField.getText() ); 
					ptst.setString(2,passwordField.getText() );
					ResultSet rs = ptst.executeQuery();
					int count=0;
					while(rs.next())
					{
						count++;
					}
					//JOptionPane.showMessageDialog(null, count+"");
					if(count==1) {
						JOptionPane.showMessageDialog(null, "Username and password matches");
						eid=textField.getText();
						frame.dispose();
						ptst.close();
						conn.close();
						Detials detials = new Detials();
						detials.setVisible(true);
					}else JOptionPane.showMessageDialog(null, "Username and Password mismatch \n        try again! ");
					}
			catch(Exception e) {
				JOptionPane.showMessageDialog(null,"Username and Password mismatch \n        try again! ");
				
			}
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 14));
		frame.getContentPane().add(btnLogin);
		
		JButton btnNewuser = new JButton("NewUser");
		btnNewuser.setBounds(38, 212, 105, 29);
		btnNewuser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				
					new NewEvent().setVisible(true);
			}
		});
		btnNewuser.setFont(new Font("Tahoma", Font.BOLD, 14));
		frame.getContentPane().add(btnNewuser);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(398, 136, 120, 29);
		passwordField.setEchoChar('*');
		frame.getContentPane().add(passwordField);
		
		JLabel label = new JLabel("");
		label.setBounds(36, 75, 240, 67);
		Image image1 = new ImageIcon(this.getClass().getResource("/bg.png")).getImage();
		label.setIcon(new ImageIcon(image1));
		frame.getContentPane().add(label);
		
		JButton btnForgetPass = new JButton("Forget Password");
		btnForgetPass.setBounds(189, 212, 160, 29);
		btnForgetPass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				
				new ForgetPass().setVisible(true);
			}
		});
		btnForgetPass.setFont(new Font("Tahoma", Font.BOLD, 14));
		frame.getContentPane().add(btnForgetPass);
		
		JLabel lblRegnantSoftwareSolution = new JLabel("Regnant Software Solution - Employee portal");
		lblRegnantSoftwareSolution.setBounds(48, 11, 480, 46);
		lblRegnantSoftwareSolution.setFont(new Font("Tahoma", Font.BOLD, 20));
		frame.getContentPane().add(lblRegnantSoftwareSolution);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(10, 0, 564, 277);
		Image image2 = new ImageIcon(this.getClass().getResource("/log1.png")).getImage();
		label.setIcon(new ImageIcon(image2));
		frame.getContentPane().add(label_1);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setToolTipText("");
		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenu mnNew = new JMenu("New");
		mnFile.add(mnNew);
		
		JMenuItem mntmNewuser = new JMenuItem("NewUser");
		mnNew.add(mntmNewuser);
		mntmNewuser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				
				new NewEvent().setVisible(true);
			}
		});
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			System.exit(0);
			}
		});
		
		JMenu mnPassword = new JMenu("Password");
		menuBar.add(mnPassword);
		
		JMenuItem mntmForgetPassword = new JMenuItem("Forget Password");
		mnPassword.add(mntmForgetPassword);
		mntmForgetPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				
				new ForgetPass().setVisible(true);
			}
		});
	}
}
