

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
@WebServlet("/tpb")
public class tpb extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public tpb() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String one = request.getParameter("idhtml");
		String two = request.getParameter("namehtml");
		
		searchdb(one, two, response);
	}
	
	void searchdb(String idPAR, String namePAR, HttpServletResponse response) throws IOException
	{
		PrintWriter printer = response.getWriter();
		
		Connection c = null;
		PreparedStatement ps = null;
		String state = "";
		
		try {
			connectdb.connect(getServletContext());
			c = connectdb.connectvar;
			int valid = 0;
			
			if (idPAR.isEmpty() && namePAR.isEmpty())
			{
				state = "select * from tptable;";
				ps = c.prepareStatement(state);
				valid = 1;
			}
			else if (!idPAR.isEmpty() && !namePAR.isEmpty())
			{
				state = "select * from tptable where id like \'%" + idPAR
						+ "%\' and name like \'%" + namePAR
						+ "%\';";
				ps = c.prepareStatement(state);
				valid = 1;
			}
			else if (!idPAR.isEmpty() && namePAR.isEmpty())
			{
				state = "select * from tptable where id like \'%" + idPAR + "%\';";
				ps = c.prepareStatement(state);
				valid = 1;
			}
			else if (idPAR.isEmpty() && !namePAR.isEmpty())
			{
				state = "select * from tptable where name like \'%" + namePAR + "%\';";
				ps = c.prepareStatement(state);
				valid = 1;
			}
	
			
			ResultSet res = ps.executeQuery();
			
			if(res.next())
			{
				res.previous();
				while (res.next())
					{
						int idresp = res.getInt("id");
						String nameresp = res.getString("name");
						
						printer.println("<h1>");
						printer.println("ID: " + idresp + ", ");
						printer.println("User: " + nameresp + ", ");
						printer.println("<h1/>");
						
					}
			}
			
			else
			{
				printer.println("No Results!");
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
