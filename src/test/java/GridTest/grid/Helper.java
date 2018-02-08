package GridTest.grid;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;



public class Helper {
	
	public static String getPropValue(String ar,String file)throws Exception
	{
		String result="";
		
		Properties prop = new Properties();
		String name= file + ".properties";
		InputStream str = new FileInputStream(name);
		
		if(str!=null)
		{
			prop.load(str);
			result=prop.getProperty(ar);
		}
		
		
		return result;
	}
	
	public static boolean valid(String s)
	{
		boolean result = false;
		
		if(s!=null)
		{
		String[] or = {"QA","qa","Test","test","Automation"};
		String[] and = {"Java","Selenium"};
		
		 for(String r:or)
		 {
			 if(s.toLowerCase().contains(r.toLowerCase()))
			 {
				 if(s.toLowerCase().contains(and[0].toLowerCase())||s.toLowerCase().contains(and[1].toLowerCase()))
				 {
					 result = true;
					 break;
				 }
			 }
		 }
		}
		return result;
	}

}
