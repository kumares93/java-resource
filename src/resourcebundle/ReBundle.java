package resourcebundle;

import java.util.Locale;
import java.util.ResourceBundle;

public class ReBundle {

	public static void main(String[] args) {
		String lang="ta";
		String country="IN";
		Locale locale = new Locale(lang,country);
		
			ResourceBundle r = ResourceBundle.getBundle("resourcebundle\\bundle", locale);
			String str= r.getString("wish");
			String name=r.getString("name");
			String age=r.getString("age");
			System.out.println(str+"-"+name+"-"+age);
			
			
	}

}
