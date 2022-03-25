

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.*;
import java.sql.*;

/**
 * Servlet implementation class tpa
 */
@WebServlet("/tpa")
public class tpa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public tpa() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		viewdb(response);
	}
	
	void viewdb(HttpServletResponse response) throws IOException
	{
		PrintWriter printer = response.getWriter();
		
		Connection c = null;
		PreparedStatement ps = null;
		String sql = "";
		
		try {
			connectdb.connect(getServletContext());
			c = connectdb.connectvar;
			
			sql = "select * from tptable;";
			ps = c.prepareStatement(sql);
	
			
			ResultSet res = ps.executeQuery();
			
			if(res.next())
			{
				res.previous();
				while (res.next())
					{
						int resI = res.getInt("id");
						String resN = res.getString("name");
						
						printer.println("<h1>");
						printer.println("ID: " + resI + ", ");
						printer.println("User: " + resN + ", ");
						printer.println("<h1/>");
						
					}
			}
			
			else
			{
				printer.println("Database Empty!");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
