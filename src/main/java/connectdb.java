import java.sql.*;
import javax.servlet.ServletContext;

public class connectdb {
	static Connection connectvar = null;
	static ServletContext ct;
	
	static void connect()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			property.getCField(ct);
			connectvar = DriverManager.getConnection(urlG(), userG(), passG());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static String passG() {
		// TODO Auto-generated method stub
		return property.field("password");
	}

	private static String userG() {
		// TODO Auto-generated method stub
		return property.field("user");
	}

	private static String urlG() {
		// TODO Auto-generated method stub
		return property.field("url");
	}
	
	public static void connect(ServletContext c)
	{
		ct = c;
		
		connect();
	}
}
