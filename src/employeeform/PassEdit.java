package employeeform;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class PassEdit extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PassEdit frame = new PassEdit();
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
	public PassEdit() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 494, 314);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCurrentPassword = new JLabel("Current Password");
		lblCurrentPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCurrentPassword.setBounds(52, 40, 131, 33);
		contentPane.add(lblCurrentPassword);
		
		textField = new JTextField();
		textField.setBounds(239, 40, 158, 33);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewPassword = new JLabel("New Password");
		lblNewPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewPassword.setBounds(52, 94, 131, 33);
		contentPane.add(lblNewPassword);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(239, 100, 158, 33);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(239, 156, 158, 33);
		contentPane.add(textField_2);
		
		JLabel lblConformPassword = new JLabel("Conform Password");
		lblConformPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblConformPassword.setBounds(52, 156, 158, 33);
		contentPane.add(lblConformPassword);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {	
					Connection conn=ConnectionClass.connectify();
					
					String sql="select password from employeeinfo where eid=? ";
					PreparedStatement ptst = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
					ptst.setString(1,Employee.eid );
					ResultSet rs = ptst.executeQuery();
					rs.next();
					JOptionPane.showMessageDialog(null,rs.getInt(1) );
					if(Integer.parseInt(textField.getText())==rs.getInt(1))
					{rs.close();ptst.close();
						if(Integer.parseInt(textField_1.getText())==Integer.parseInt(textField_2.getText())){
							String sql1="UPDATE employeeinfo SET password=? WHERE eid=? ";
							PreparedStatement ptst1 = conn.prepareStatement(sql1);
							ptst1.setInt(2,Integer.parseInt(textField_1.getText()) );
							ptst1.setInt(1,Integer.parseInt(Employee.eid));
							int x = ptst1.executeUpdate();
							if(x==1) {
								JOptionPane.showMessageDialog(null,"Password Successfully Changed" );
							}
							
						}else JOptionPane.showMessageDialog(null,"New Password NotMatching" );
					}else JOptionPane.showMessageDialog(null,"Current Password Wrong" ); 
						dispose();
					new Detials().setVisible(true);
					}
			catch(Exception ee) {
				JOptionPane.showMessageDialog(null, ee);
				
			}
			}
		});
		btnUpdate.setBounds(192, 229, 89, 23);
		contentPane.add(btnUpdate);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {	dispose();
				Detials detials = new Detials();
				detials.setVisible(true);}
			catch(Exception eee) {
				JOptionPane.showMessageDialog(null, eee);
			}
			}
		});
		btnExit.setBounds(330, 229, 89, 23);
		contentPane.add(btnExit);
		
		JLabel label = new JLabel("");
		label.setBounds(-21, 0, 499, 288);
		Image image1 = new ImageIcon(this.getClass().getResource("/pa1.jpeg")).getImage();
		label.setIcon(new ImageIcon(image1));
		contentPane.add(label);
	}

}
