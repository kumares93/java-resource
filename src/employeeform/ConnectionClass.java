package employeeform;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.*;

public class ConnectionClass {
	public static Connection connectify(){
	try {	String lang="en";
		String country="US";
		Locale locale = new Locale(lang,country);
		ResourceBundle r = ResourceBundle.getBundle("employeeform/bundle", locale);

			Class.forName(r.getString("forname"));

			Connection conn=DriverManager.getConnection(r.getString("ip"),r.getString("user"),r.getString("pass"));
			
			//JOptionPane.showMessageDialog(null,"Connection Successfully Done" );
			return conn;
			}
	catch(Exception e) {
		JOptionPane.showMessageDialog(null, e);
		return null;
	}
		}
}
