package servlets;
import java.io.*;
import java.sql.*;
import javax.servlet.*;

import constants.IOnlineBookStoreConstants;
import sql.IBookConstants;

public class ViewAdminServlet extends GenericServlet{
	public void service(ServletRequest req,ServletResponse res) throws IOException,ServletException
	{
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("Select * from " + IBookConstants.TABLE_BOOK);
			ResultSet rs = ps.executeQuery();
			RequestDispatcher rd = req.getRequestDispatcher("ViewBooksAdmin.html");
			rd.include(req, res);
			pw.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/styleview.css\" />");
			pw.println("<title>View Book</title>");
			pw.println("<table class=\"content-table\">" + 
					"		<thead>" + 
					"			<tr>\r\n" + 
					"				<tr>" + 
					"				<th>Book Code</th>" + 
					"				<th>Book Name</th>" + 
					"				<th>Book Author</th>" + 
					"				<th>Book Price</th>" + 
					"				<th>Quantity</th>" + 
					"			</tr>" +
					"          </thead>");
			
			while(rs.next())
			{
				String bCode = rs.getString(1);
				String bName = rs.getString(2);
				String bAuthor = rs.getString(3);
				int bPrice = rs.getInt(4);
				int bQty = rs.getInt(5);
				pw.println("<tbody>");
				pw.println("<tr><td>"+bCode+"</td>");
				pw.println("<td>"+bName+"</td>");
				pw.println("<td>"+bAuthor+"</td>");
				pw.println("<td>"+bPrice+"</td>");
				pw.println("<td>"+bQty+"</td></tr>");
			}
			pw.println("</tbody>");
			pw.println("</table>");
			
			
			//pw.println("<div class=\"tab\"><a href=\"AddBook.html\">Add More Books</a></div>");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
