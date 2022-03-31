

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.*;
import java.sql.*;

/**
 * Servlet implementation class tbb
 */
@WebServlet("/tpc")
public class tpc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public tpc() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String one = request.getParameter("idinsert");
		String two = request.getParameter("nameinsert");
		
		insertdb(one, two, response);
	}
	
	void insertdb(String idPAR, String namePAR, HttpServletResponse response) throws IOException
	{
		PrintWriter printer = response.getWriter();
		
		Connection c = null;
		PreparedStatement ps = null;
		String state = "INSERT INTO tptable (id, name) values (?, ?)";
		
		try {
			connectdb.connect(getServletContext());
			c = connectdb.connectvar;
			
			ps = c.prepareStatement(state);
	
			ps.setInt(1, Integer.parseInt(idPAR));
			ps.setString(2, namePAR);
			
			ps.execute();
			c.close();
			
			printer.println("Inserted ID: " + idPAR);
			printer.println("Inserted name: " + namePAR);
			
			
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
