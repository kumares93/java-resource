package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Button;
import java.util.Locale;
import java.util.ResourceBundle;
import java.awt.Color;
import java.awt.Font;

public class Arithmetic {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton btnTamilFont;
	String lang="en";
	String country="US";
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Arithmetic window = new Arithmetic("en","US");
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
	public Arithmetic() {
		initialize();
	}
	
	public Arithmetic(String lang,String country) {
		this.lang=lang;
		this.country=country;
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 * @throws FileNotFoundException 
	 */
	private void initialize()  {
		Locale locale = new Locale(lang,country);
		
		ResourceBundle r = ResourceBundle.getBundle("gui\\bundle", locale);
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		textField.setBounds(34, 44, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(285, 44, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(187, 87, 86, 28);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnAdd = new JButton(r.getString("add"));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x,y,z;
				try {
					x=Integer.parseInt(textField.getText());
					y=Integer.parseInt(textField_1.getText());
					z=x+y;
					textField_2.setText(z+"");
				}catch(Exception ee) {
					JOptionPane.showMessageDialog(null, r.getString("enter"));
				}
			}
		});
		btnAdd.setBounds(34, 128, 89, 23);
		frame.getContentPane().add(btnAdd);
		
		JButton btnSub = new JButton(r.getString("sub"));
		btnSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x,y,z;
				try {
					x=Integer.parseInt(textField.getText());
					y=Integer.parseInt(textField_1.getText());
					z=x-y;
					textField_2.setText(z+"");
				}catch(Exception ee) {
					JOptionPane.showMessageDialog(null,r.getString("enter"));
				}
			}
		});
		btnSub.setBounds(34, 162, 89, 23);
		frame.getContentPane().add(btnSub);
		
		JButton btnTamil = new JButton(r.getString("close"));
		btnTamil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnTamil.setBounds(321, 203, 89, 23);
		frame.getContentPane().add(btnTamil);
		
		JLabel lblAnswer = new JLabel(r.getString("answer"));
		lblAnswer.setBounds(91, 87, 86, 28);
		frame.getContentPane().add(lblAnswer);
		
		btnTamilFont = new JButton("French");
		btnTamilFont.setLocale(new Locale("ta", "IN"));
		btnTamilFont.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//System.out.println("French");
				lang="ta";
				country="IN";
				frame.dispose();
				Arithmetic arithmetic = new Arithmetic("ta","IN");
				arithmetic.frame.setVisible(true);
				
			}
		});
		btnTamilFont.setBounds(20, 203, 118, 23);
		frame.getContentPane().add(btnTamilFont);
		
		JButton btnMul = new JButton(r.getString("mul"));
		btnMul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x,y,z;
				try {
					x=Integer.parseInt(textField.getText());
					y=Integer.parseInt(textField_1.getText());
					z=x*y;
					textField_2.setText(z+"");
				}catch(Exception ee) {
					JOptionPane.showMessageDialog(null,r.getString("enter"));
				}
			}
		});
		btnMul.setBounds(267, 126, 89, 23);
		frame.getContentPane().add(btnMul);
		
		JButton btnDiv = new JButton(r.getString("div"));
		btnDiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x,y,z;
				try {
					x=Integer.parseInt(textField.getText());
					y=Integer.parseInt(textField_1.getText());
					z=x/y;
					textField_2.setText(z+"");
				}catch(Exception ee) {
					JOptionPane.showMessageDialog(null, r.getString("enter"));
				}
			}
		});
		btnDiv.setBounds(267, 162, 89, 23);
		frame.getContentPane().add(btnDiv);
		
		JButton button = new JButton("English");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Arithmetic arithmetic = new Arithmetic("en","US");
				arithmetic.frame.setVisible(true);
			}
		});
		button.setBounds(151, 203, 109, 23);
		frame.getContentPane().add(button);
		
		JLabel label = new JLabel(r.getString("calc"));
		label.setFont(new Font("Tahoma", Font.BOLD, 18));
		label.setBounds(145, 11, 189, 33);
		frame.getContentPane().add(label);
		
		
	}
}
