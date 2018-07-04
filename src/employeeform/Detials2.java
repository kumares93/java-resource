package employeeform;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenuBar;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Detials2 extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_4;
	private JTextField textField_2;
	private JTextField textField;
	private ResultSet rs;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Detials2 frame = new Detials2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public Detials2() throws Exception {
		String s=Employee.eid;
		Connection conn1=ConnectionClass.connectify();
		try {	
			String sql="select * from employeeinfo where eid=?";
			PreparedStatement ptst = conn1.prepareStatement(sql);
			ptst.setString(1,s );
			rs = ptst.executeQuery();
			rs.next();
			}
	catch(Exception e) {
		JOptionPane.showMessageDialog(null, e);
		
	}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 596);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem menuItem = new JMenuItem("Save");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {	
					Connection conn=ConnectionClass.connectify();
					String sql="UPDATE employeeinfo SET email=?,doj=?,address =?,secure=? WHERE eid=?";
					PreparedStatement ptst = conn.prepareStatement(sql);
					ptst.setString(1,textField_1.getText() );
					ptst.setString(3,textField_4.getText() );
					ptst.setInt(2,Integer.parseInt(textField_2.getText()) );
					ptst.setString(4,(textField.getText()) );
					ptst.setInt(5,Integer.parseInt(Employee.eid));
					
					int result = ptst.executeUpdate();
					if(result==1) {
						JOptionPane.showMessageDialog(null, "Successfully record Modified");
						dispose();
						new Acadamic().setVisible(true);
					}else JOptionPane.showMessageDialog(null, "Something Went Wrong \n Consult Development Team");
					
					}
			catch(Exception ee) {
				JOptionPane.showMessageDialog(null, ee);
				
			}				
			}
		});
		mnFile.add(menuItem);
		
		JMenuItem menuItem_2 = new JMenuItem("Logout");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Employee().frame.setVisible(true);
			}
		});
		mnFile.add(menuItem_2);
		
		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		
		JMenuItem menuItem_1 = new JMenuItem("Edit Password");
		mnEdit.add(menuItem_1);
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new PassEdit().setVisible(true);
			}
		});
		
		JMenu mnAcademics = new JMenu("Academics");
		menuBar.add(mnAcademics);
		
		JMenuItem mntmAcademicMarks = new JMenuItem("Academic Marks");
		mnAcademics.add(mntmAcademicMarks);
		mntmAcademicMarks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();try {
					new Acadamic().setVisible(true);}catch(Exception ee) {}
				
			}
		});
		
		JMenu mnLeave = new JMenu("Leave");
		menuBar.add(mnLeave);
		
		JMenuItem mntmLeaveBalance = new JMenuItem("Leave Balance");
		mnLeave.add(mntmLeaveBalance);
		mntmLeaveBalance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();try {
					new Leave().setVisible(true);}catch(Exception ee) {}
				
			}
		});
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		Image image1 = new ImageIcon(this.getClass().getResource("/log1.png")).getImage();
		label.setIcon(new ImageIcon(image1));
		label.setBounds(10, 11, 256, 64);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Employee Detials");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_1.setBackground(new Color(204, 204, 255));
		label_1.setBounds(265, 18, 231, 57);
		contentPane.add(label_1);
		
		JLabel lblEmpId = new JLabel("Employee Id");
		lblEmpId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmpId.setBounds(54, 100, 98, 23);
		contentPane.add(lblEmpId);
		
		textField_1 = new JTextField();
		textField_1.setText(rs.getString(8));
		textField_1.setColumns(10);
		textField_1.setBounds(217, 164, 185, 36);
		contentPane.add(textField_1);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmail.setBounds(54, 169, 98, 23);
		contentPane.add(lblEmail);
		
		JLabel lblDoj = new JLabel("DOJ");
		lblDoj.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDoj.setBounds(54, 235, 66, 23);
		contentPane.add(lblDoj);
		
		textField_4 = new JTextField();
		textField_4.setText(rs.getString(10));
		textField_4.setColumns(10);
		textField_4.setBounds(217, 299, 185, 36);
		contentPane.add(textField_4);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAddress.setBounds(54, 304, 98, 23);
		contentPane.add(lblAddress);
		
		textField_2 = new JTextField();
		textField_2.setText(rs.getInt(9)+"");
		textField_2.setColumns(10);
		textField_2.setBounds(217, 230, 185, 36);
		contentPane.add(textField_2);
		
		JLabel lblNewLabel = new JLabel(Employee.eid);
		lblNewLabel.setBounds(217, 86, 136, 48);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Previous Page");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				try {
				new Detials().setVisible(true);}
				catch(Exception ee) {JOptionPane.showMessageDialog(null, ee.getMessage());
				}
			}
		});
		btnNewButton.setBounds(54, 465, 152, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Save & Next");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {	
					Connection conn=ConnectionClass.connectify();
					String sql="UPDATE employeeinfo SET email=?,doj=?,address =?,secure=? WHERE eid=?";
					PreparedStatement ptst = conn.prepareStatement(sql);
					ptst.setString(1,textField_1.getText() );
					ptst.setString(3,textField_4.getText() );
					ptst.setInt(2,Integer.parseInt(textField_2.getText()) );
					ptst.setString(4,(textField.getText()) );
					ptst.setInt(5,Integer.parseInt(Employee.eid));
					
					int result = ptst.executeUpdate();
					if(result==1) {
						JOptionPane.showMessageDialog(null, "Successfully record Modified");
						dispose();
						new Acadamic().setVisible(true);
					}else JOptionPane.showMessageDialog(null, "Something Went Wrong \n Consult Development Team");
					
					}
			catch(Exception ee) {
				JOptionPane.showMessageDialog(null, ee);
				
			}
			}
		});
		btnNewButton_1.setBounds(232, 465, 142, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Logout");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();  
		        new Employee().frame.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(407, 465, 104, 23);
		contentPane.add(btnNewButton_2);
		
		JLabel label_2 = new JLabel("Security Question");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_2.setBounds(53, 378, 153, 23);
		contentPane.add(label_2);
		
		textField = new JTextField();
		textField.setText(rs.getString(7));
		textField.setColumns(10);
		textField.setBounds(216, 373, 185, 36);
		contentPane.add(textField);
		
		JLabel label_3 = new JLabel("What is name of your pet animal?");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_3.setBounds(417, 384, 197, 14);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.setBounds(10, 0, 614, 536);
		Image image2 = new ImageIcon(this.getClass().getResource("/bg.png")).getImage();
		label_4.setIcon(new ImageIcon(image2));
		contentPane.add(label_4);
	}
}
