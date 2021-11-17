package servlets;

import java.sql.*;

import javax.servlet.*;

import sql.IBookConstants;

import java.io.*;

public class RemoveBookServlet extends GenericServlet {
	public void service(ServletRequest req, ServletResponse res) throws IOException, ServletException {
		
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		String bkid = req.getParameter("barcode");
		try {
			Connection con = DBConnection.getCon();	
			PreparedStatement zs = con.prepareStatement("Select * from " + IBookConstants.TABLE_BOOK);
			PreparedStatement ps = con.prepareStatement(
					"delete from " + IBookConstants.TABLE_BOOK + "  where " + IBookConstants.COLUMN_BARCODE + "=?");
				
			ResultSet rs = zs.executeQuery();
			RequestDispatcher rd = req.getRequestDispatcher("RemoveBooks.html");
			rd.include(req, res);
			pw.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/remove.css\" />");
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
				pw.println("</tbody>");
			pw.println("</table>");
			
			}
			
			
			ps.setString(1, bkid);
			int k = ps.executeUpdate();
			if (k == 1) {
				
				rd.include(req, res);
				pw.println("<div class=\"tab\">Book Removed Successfully</div>");
				pw.println("<div class=\"tab\"><a href=\"RemoveBooks.html\">Remove more Books</a></div>");

			} 
			else {
				
				rd.include(req, res);
				pw.println("<div class=\"tab\">Book Not Available In The Store</div>");
				pw.println("<div class=\"tab\"><a href=\"RemoveBooks.html\">Remove more Books</a></div>");
			}
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
