package employeeform;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import java.awt.Color;

@SuppressWarnings("serial")
public class Leave extends JFrame {

	private JPanel contentPane;
	 ResultSet rs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Leave frame = new Leave();
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
	public Leave() throws Exception {
		
		String s=Employee.eid;
		
		JOptionPane.showMessageDialog(null, s);
		Connection conn=ConnectionClass.connectify();
		try {	
			
			String sql = "select * from employeeleave where eid=?";
			PreparedStatement ptst = conn.prepareStatement(sql);
			ptst.setInt(1,Integer.parseInt(s));
			rs = ptst.executeQuery();
			boolean x=rs.next();
			JOptionPane.showMessageDialog(null, x+"");
			}
	catch(Exception e) {
		JOptionPane.showMessageDialog(null, e);
		
	}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 615, 462);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem menuItem_4 = new JMenuItem("Logout");
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Employee().frame.setVisible(true);
			}
		});
		mnFile.add(menuItem_4);
		
		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		
		
		
		
		JMenuItem menuItem_1 = new JMenuItem("Edit Password");
		mnEdit.add(menuItem_1);
		
		JMenu mnPersonal = new JMenu("Personal");
		menuBar.add(mnPersonal);
		
		JMenuItem menuItem_2 = new JMenuItem("Personal Detials");
		mnPersonal.add(menuItem_2);
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();try {
					new Detials().setVisible(true);}catch(Exception e1) {}
			}
		});
		
		JMenu mnAcademics = new JMenu("Academics");
		menuBar.add(mnAcademics);
		
		JMenuItem mntmAcadamicDetials = new JMenuItem("Acadamic Detials");
		mnAcademics.add(mntmAcadamicDetials);
		mntmAcadamicDetials.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();try {
				new Acadamic().setVisible(true);}catch(Exception e1) {}
			}
		});
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new PassEdit().setVisible(true);
			}
		});
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEmployeeLeaveBalance = new JLabel("Employee Leave Balance");
		lblEmployeeLeaveBalance.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEmployeeLeaveBalance.setBounds(262, 28, 271, 30);
		contentPane.add(lblEmployeeLeaveBalance);
		
		JLabel label = new JLabel("");
		Image image1 = new ImageIcon(this.getClass().getResource("/log1.png")).getImage();
		label.setIcon(new ImageIcon(image1));
		label.setBounds(10, 11, 256, 64);
		contentPane.add(label);
		
		JLabel lblTotalNoOf = new JLabel("Total No. of Leaves");
		lblTotalNoOf.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTotalNoOf.setBounds(96, 133, 142, 30);
		contentPane.add(lblTotalNoOf);
		
		JLabel lblLeavesApplied = new JLabel("Leaves Applied");
		lblLeavesApplied.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLeavesApplied.setBounds(96, 188, 103, 30);
		contentPane.add(lblLeavesApplied);
		
		JLabel lblAvailableLeaves = new JLabel("Available Leaves");
		lblAvailableLeaves.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAvailableLeaves.setBounds(97, 243, 141, 30);
		contentPane.add(lblAvailableLeaves);
		
		JLabel label_1 = new JLabel(rs.getLong(2)+"");
		label_1.setBounds(327, 133, 103, 30);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel(rs.getInt(3)+"");
		label_2.setBounds(327, 188, 103, 30);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel(rs.getInt(4)+"");
		label_3.setBounds(327, 243, 103, 30);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("Employee Id");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_4.setBounds(96, 99, 98, 23);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel(Employee.eid);
		label_5.setBounds(327, 105, 136, 29);
		contentPane.add(label_5);
		
		JButton btnstPage = new JButton("Personal Detials");
		btnstPage.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnstPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				try {
					new Detials().setVisible(true);
				}catch(Exception e1) {
					
				}
			}
		});
		btnstPage.setBounds(57, 352, 142, 23);
		contentPane.add(btnstPage);
		
		JButton btnPreviousPage = new JButton("Previous Page");
		btnPreviousPage.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnPreviousPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				try {
					new Acadamic().setVisible(true);
				}catch(Exception e2) {
					
				}
			}
		});
		btnPreviousPage.setBounds(231, 352, 136, 23);
		contentPane.add(btnPreviousPage);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				try {
					new Employee().frame.setVisible(true);
				}catch(Exception e1) {
					
				}
			}
		});
		btnLogout.setBounds(416, 352, 103, 23);
		contentPane.add(btnLogout);
		
		JLabel label_6 = new JLabel("");
		label_6.setBounds(0, 0, 599, 402);
		Image image2 = new ImageIcon(this.getClass().getResource("/ad.jpg")).getImage();
		label_6.setIcon(new ImageIcon(image2));
		contentPane.add(label_6);
		
		
	}

}
