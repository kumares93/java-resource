package employeeform;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.Properties;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

public class ForgetPass extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	ResultSet rs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ForgetPass frame = new ForgetPass();
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
	public ForgetPass() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
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
		contentPane.setBackground(new Color(255, 255, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblForgetPassword = new JLabel("Forget Password");
		lblForgetPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblForgetPassword.setBounds(123, 11, 194, 25);
		contentPane.add(lblForgetPassword);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUsername.setBounds(36, 47, 84, 32);
		contentPane.add(lblUsername);
		
		JLabel lblNewLabel = new JLabel("Security Question");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(36, 90, 133, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblWhatIsThe = new JLabel("What is the name of your Pet Animal?");
		lblWhatIsThe.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblWhatIsThe.setBounds(184, 81, 240, 41);
		contentPane.add(lblWhatIsThe);
		
		textField = new JTextField();
		textField.setBounds(184, 47, 176, 32);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(184, 118, 176, 41);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnChangePassword = new JButton("Get Password");
		btnChangePassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection conn=ConnectionClass.connectify();
					String sql="select * from employeeinfo where eid=? ";
					PreparedStatement ptst = conn.prepareStatement(sql);
					ptst.setInt(1,Integer.parseInt(textField.getText() ));
					
					rs = ptst.executeQuery();
					rs.next();
					if(rs.getString(7).equals(textField_1.getText())) {
						//JOptionPane.showMessageDialog(null,"Your Password is:"+rs.getString(4)+"\n Please Remember the password" );
						try{
							  String host="smtp.gmail.com";
							  final String user="rakesh.sateesh@gmail.com";
							  final String pass="rocky959";
							  String from="rakesh.sateesh@gmail.com";
							  String to=rs.getString(8);
							  String subject="Regarding Password";
							  String messageText="Your password is :"+rs.getInt(4)+"\n Please try to change the password!";
							  boolean sessionDebug=false;
						  Properties prop=new Properties();
						  
						  prop.put("mail.smtp.starttls.enable","true");
						  prop.put("mail.smtp.host",host);
						  prop.put("mail.smtp.port","587");
						  prop.put("mail.smtp.auth","true");
						  prop.put("mail.smtp.starttls.required","true");
						  
						  //java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
						  Session session=Session.getDefaultInstance(prop,null);
						      session.setDebug(sessionDebug);
							  Message message=new MimeMessage(session);
							  message.setFrom(new InternetAddress(from));
							  InternetAddress[] address={new InternetAddress(to)};
							  message.setRecipients(Message.RecipientType.TO, address);
							  message.setSubject(subject);
							  message.setText(messageText);
							  message.setSentDate(new Date());
							  Transport transport=session.getTransport("smtp");
							  transport.connect(host,user,pass);
							  transport.sendMessage(message, message.getAllRecipients());
							  transport.close();
							  JOptionPane.showMessageDialog(null, "Password is delivered to your Email id successfully.....");
						  }
						  catch(Exception ee)
						  {
							  JOptionPane.showMessageDialog(null,ee);
						  }
						dispose();  
				        new Employee().frame.setVisible(true);
					}else JOptionPane.showMessageDialog(null,"Your Your Id/Answer is not match" );
					
						rs.close();
						ptst.close();
						conn.close();
						
					}
			catch(Exception ee) {
				JOptionPane.showMessageDialog(null, ee);
				
			}
			}
		});
		btnChangePassword.setBounds(156, 206, 138, 23);
		contentPane.add(btnChangePassword);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();  
		        new Employee().frame.setVisible(true);
			}
		});
		btnExit.setBounds(315, 206, 89, 23);
		contentPane.add(btnExit);
		
		JLabel label = new JLabel("");
		label.setBounds(-99, 0, 533, 240);
		Image image1 = new ImageIcon(this.getClass().getResource("/pa1.jpeg")).getImage();
		label.setIcon(new ImageIcon(image1));
		contentPane.add(label);
	}
}
