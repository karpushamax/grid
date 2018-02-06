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

}
