package employeeform;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;
import java.sql.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Color;

public class Detials extends JFrame {

	private JPanel contentPane;
	Connection conn=null;
	ResultSet rs=null;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Detials frame = new Detials();
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
	public Detials()throws Exception {
		String s=Employee.eid;
		conn=ConnectionClass.connectify();
		try {	
			String sql="select * from employeeinfo where eid=?";
			PreparedStatement ptst = conn.prepareStatement(sql);
			ptst.setString(1,s );
			rs = ptst.executeQuery();
			rs.next();
			}
	catch(Exception e) {
		JOptionPane.showMessageDialog(null, e);
		
	}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 671, 637);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnMenu = new JMenu("File");
		menuBar.add(mnMenu);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {	
					String sql="UPDATE employeeinfo SET NAME=?,surname=?,age =?,phone=?,secure=? WHERE eid=?";
					PreparedStatement ptst = conn.prepareStatement(sql);
					ptst.setString(1,textField.getText() );
					ptst.setString(2,textField_1.getText() );
					ptst.setInt(3,Integer.parseInt(textField_2.getText()) );
					ptst.setLong(4,Long.parseLong(textField_3.getText()) );
					
					ptst.setInt(5,Integer.parseInt(Employee.eid));
					
					int result = ptst.executeUpdate();
					if(result==1) {
						JOptionPane.showMessageDialog(null, "Successfully record Modified");
					}else JOptionPane.showMessageDialog(null, "Something Went Wrong \n Consult Development Team");
					
					}
			catch(Exception ee) {
				JOptionPane.showMessageDialog(null, ee);
				
			}
			}
		});
		mnMenu.add(mntmSave);
		
		JMenuItem mntmLogout = new JMenuItem("Logout");
		mntmLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();  
		        new Employee().frame.setVisible(true);
			}
		});
		mnMenu.add(mntmLogout);
		
		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		
		JMenuItem mntmEditPassword = new JMenuItem("Edit Password");
		mnEdit.add(mntmEditPassword);
		
		JMenu mnAcademics = new JMenu("Academics");
		menuBar.add(mnAcademics);
		
		JMenuItem menuItem = new JMenuItem("Academic Marks");
		mnAcademics.add(menuItem);
		
		JMenu mnLeave = new JMenu("Leave");
		menuBar.add(mnLeave);
		
		JMenuItem menuItem_1 = new JMenuItem("Leave Balance");
		mnLeave.add(menuItem_1);
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();try {
				new Leave().setVisible(true);}catch(Exception ee) {}
			}
		});
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();try {
				new Acadamic().setVisible(true);}catch(Exception e1) {}
			}
		});
		mntmEditPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new PassEdit().setVisible(true);
			}
		});
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBackground(new Color(204, 204, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(65, 128, 98, 23);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblName);
		
		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setBounds(65, 192, 98, 23);
		lblSurname.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblSurname);
		
		JLabel lblNewLabel = new JLabel("Age");
		lblNewLabel.setBounds(65, 258, 66, 23);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblNewLabel);
		
		JLabel lblEmployeeId = new JLabel("Employee ID");
		lblEmployeeId.setBounds(65, 77, 98, 23);
		lblEmployeeId.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblEmployeeId);
		
		JButton btnEdit = new JButton("Save & Next");
		btnEdit.setBounds(240, 497, 127, 23);
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {	
					String sql="UPDATE employeeinfo SET NAME=?,surname=?,age =?,phone=? WHERE eid=?";
					PreparedStatement ptst = conn.prepareStatement(sql);
					ptst.setString(1,textField.getText() );
					ptst.setString(2,textField_1.getText() );
					ptst.setInt(3,Integer.parseInt(textField_2.getText()) );
					ptst.setLong(4,Long.parseLong(textField_3.getText()) );
					ptst.setInt(5,Integer.parseInt(Employee.eid));
					
					int result = ptst.executeUpdate();
					if(result==1) {
						JOptionPane.showMessageDialog(null, "Successfully record Modified");
						dispose();
						new Detials2().setVisible(true);
					}else JOptionPane.showMessageDialog(null, "Something Went Wrong \n Consult Development Team");
					
					}
			catch(Exception ee) {
				JOptionPane.showMessageDialog(null, ee);
				
			}
			}
		});
		btnEdit.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(btnEdit);
		
		JButton btnClose = new JButton("Logout");
		btnClose.setBounds(424, 497, 89, 23);
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();  
		        new Employee().frame.setVisible(true);
		       
			}
		});
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(btnClose);
		
		JLabel lblNewLabel_1 = new JLabel(rs.getInt(1)+"");
		lblNewLabel_1.setBounds(228, 79, 146, 23);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(228, 123, 185, 36);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setText(rs.getString(2)+"");
		
		textField_1 = new JTextField();
		textField_1.setBounds(228, 187, 185, 36);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setText(rs.getString(3));
		
		textField_2 = new JTextField();
		textField_2.setBounds(228, 253, 185, 36);
		textField_2.setColumns(10);
		contentPane.add(textField_2);
		textField_2.setText(rs.getInt(5)+"");
		
		JButton btnEditPassword = new JButton("Edit Password");
		btnEditPassword.setBounds(46, 497, 153, 23);
		btnEditPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
		        new PassEdit().setVisible(true);
			}
		});
		btnEditPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(btnEditPassword);
		
		JLabel lblEmployeeForm = new JLabel("Employee Detials");
		lblEmployeeForm.setBounds(306, 11, 273, 57);
		lblEmployeeForm.setBackground(new Color(204, 204, 255));
		lblEmployeeForm.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblEmployeeForm);
		
		textField_3 = new JTextField();
		textField_3.setBounds(228, 334, 185, 36);
		textField_3.setText("0");
		textField_3.setColumns(10);
		contentPane.add(textField_3);
		textField_3.setText(rs.getLong(6)+"");
		
		JLabel lblMobile = new JLabel("Mobile");
		lblMobile.setBounds(65, 339, 66, 23);
		lblMobile.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblMobile);
		
		JLabel label = new JLabel("");
		label.setBounds(10, 11, 273, 55);
		Image image1 = new ImageIcon(this.getClass().getResource("/log1.png")).getImage();
		label.setIcon(new ImageIcon(image1));
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(0, 0, 655, 577);
		Image image = new ImageIcon(this.getClass().getResource("/bg1.png")).getImage();
		label_1.setIcon(new ImageIcon(image));
		contentPane.add(label_1);
	}
}
