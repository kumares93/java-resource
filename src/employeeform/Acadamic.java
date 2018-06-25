package employeeform;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.Color;

public class Acadamic extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private ResultSet rs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Acadamic frame = new Acadamic();
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
	public Acadamic() throws Exception {
		String s=Employee.eid;
		Connection conn1=ConnectionClass.connectify();
		try {	
			String sql="select * from employeeacad where eid=?";
			PreparedStatement ptst = conn1.prepareStatement(sql);
			ptst.setString(1,s );
			rs = ptst.executeQuery();
			rs.next();
			}
	catch(Exception e) {
		JOptionPane.showMessageDialog(null, e);
		
	}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 662, 526);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem menuItem = new JMenuItem("Save");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {	
					Connection conn=ConnectionClass.connectify();
					String sql="UPDATE employeeacad SET school=?,smark=?,inter=?,imark=?,ug=?,ugmark=? WHERE eid=?";
					PreparedStatement ptst = conn.prepareStatement(sql);
					ptst.setString(1,textField.getText() );
					ptst.setInt(2,Integer.parseInt(textField_1.getText()) );
					ptst.setString(3,textField_2.getText() );
					ptst.setInt(4,Integer.parseInt(textField_3.getText()) );
					ptst.setString(5,textField_4.getText() );
					ptst.setInt(6,Integer.parseInt(textField_5.getText()) );
					ptst.setInt(7,Integer.parseInt(Employee.eid));
					
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
		
		JMenu mnPersonalDetials = new JMenu("Personal");
		menuBar.add(mnPersonalDetials);
		
		JMenuItem mntmPersonalDetials = new JMenuItem("Personal Detials");
		mnPersonalDetials.add(mntmPersonalDetials);
		mntmPersonalDetials.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				try {
				new Detials().setVisible(true);}catch(Exception e1) {}
			}
		});
		
		JMenu mnLeave = new JMenu("Leave");
		menuBar.add(mnLeave);
		
		JMenuItem menuItem_4 = new JMenuItem("Leave Balance");
		mnLeave.add(menuItem_4);
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();try {
				new Leave().setVisible(true);}catch(Exception ee) {}
			}
		});
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new ForgetPass().setVisible(true);
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
		
		JLabel lblEmployeeAcademicDetials = new JLabel("Employee Academic Detials");
		lblEmployeeAcademicDetials.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEmployeeAcademicDetials.setBounds(276, 11, 317, 64);
		contentPane.add(lblEmployeeAcademicDetials);
		
		JLabel label_1 = new JLabel("Employee Id");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_1.setBounds(20, 86, 98, 23);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel(Employee.eid);
		label_2.setBounds(130, 86, 136, 29);
		contentPane.add(label_2);
		
		JLabel lblSchool = new JLabel("School");
		lblSchool.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSchool.setBounds(92, 164, 109, 23);
		contentPane.add(lblSchool);
		
		textField = new JTextField();
		textField.setText(rs.getString(2));
		textField.setColumns(10);
		textField.setBounds(228, 155, 185, 36);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setText(rs.getInt(3)+"");
		textField_1.setColumns(10);
		textField_1.setBounds(502, 151, 74, 36);
		contentPane.add(textField_1);
		
		JLabel lblInstitute = new JLabel("Institute");
		lblInstitute.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblInstitute.setBounds(276, 109, 185, 29);
		contentPane.add(lblInstitute);
		
		JLabel lblPercentage = new JLabel("Percentage");
		lblPercentage.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPercentage.setBounds(493, 109, 128, 29);
		contentPane.add(lblPercentage);
		
		JLabel lblIntermediate = new JLabel("Intermediate");
		lblIntermediate.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIntermediate.setBounds(92, 259, 109, 23);
		contentPane.add(lblIntermediate);
		
		textField_2 = new JTextField();
		textField_2.setText(rs.getString(4));
		textField_2.setColumns(10);
		textField_2.setBounds(228, 250, 185, 36);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setText(rs.getInt(5)+"");
		textField_3.setColumns(10);
		textField_3.setBounds(502, 246, 74, 36);
		contentPane.add(textField_3);
		
		JLabel lblUg = new JLabel("UG");
		lblUg.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUg.setBounds(92, 341, 109, 23);
		contentPane.add(lblUg);
		
		textField_4 = new JTextField();
		textField_4.setText(rs.getString(6));
		textField_4.setColumns(10);
		textField_4.setBounds(228, 332, 185, 36);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setText(rs.getInt(7)+"");
		textField_5.setColumns(10);
		textField_5.setBounds(502, 328, 74, 36);
		contentPane.add(textField_5);
		
		JButton btnNewButton = new JButton("Previous page");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				try {
				new Detials2().setVisible(true);}catch(Exception eee) {
					JOptionPane.showMessageDialog(null, "Something went wrong");
				}
			}
		});
		btnNewButton.setBounds(60, 418, 141, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Save & Next");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {	
					Connection conn=ConnectionClass.connectify();
					String sql="UPDATE employeeacad SET school=?,smark=?,inter=?,imark=?,ug=?,ugmark=? WHERE eid=?";
					PreparedStatement ptst = conn.prepareStatement(sql);
					ptst.setString(1,textField.getText() );
					ptst.setInt(2,Integer.parseInt(textField_1.getText()) );
					ptst.setString(3,textField_2.getText() );
					ptst.setInt(4,Integer.parseInt(textField_3.getText()) );
					ptst.setString(5,textField_4.getText() );
					ptst.setInt(6,Integer.parseInt(textField_5.getText()) );
					ptst.setInt(7,Integer.parseInt(Employee.eid));
					
					int result = ptst.executeUpdate();
					if(result==1) {
						JOptionPane.showMessageDialog(null, "Successfully record Modified");
						
						dispose();
						new Leave().setVisible(true);
					}else JOptionPane.showMessageDialog(null, "Something Went Wrong \n Consult Development Team");
					
					}
			catch(Exception ee) {
				JOptionPane.showMessageDialog(null, ee);
				
			}
			}
		});
		btnNewButton_1.setBounds(259, 418, 142, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();  
		        new Employee().frame.setVisible(true);
			}
		});
		btnLogout.setBounds(466, 418, 110, 23);
		contentPane.add(btnLogout);
		
		JLabel label_3 = new JLabel("");
		label_3.setBounds(0, -40, 681, 516);
		Image image2 = new ImageIcon(this.getClass().getResource("/ad.jpg")).getImage();
		label_3.setIcon(new ImageIcon(image2));
		contentPane.add(label_3);
	}
}
