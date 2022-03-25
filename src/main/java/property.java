import java.util.Properties;
import javax.servlet.ServletContext;
import java.io.InputStream;

public class property {
	static Properties prop = new Properties();
	
	public static void getCField(ServletContext sc) throws Exception
	{
		String pathS = "/WEB-INF/config.properties";
		
		InputStream streamI = sc.getResourceAsStream(pathS);
		
		prop.load(streamI);
	}
	
	public static String field(String in)
	{
		return prop.getProperty(in).trim();
	}
}
