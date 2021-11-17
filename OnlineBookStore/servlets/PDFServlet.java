package servlets;

import java.sql.*;
import java.io.*;
import javax.servlet.*;


import constants.IOnlineBookStoreConstants;
import sql.IBookConstants;

public class PDFServlet extends GenericServlet {
	
	
	public void service(ServletRequest req, ServletResponse res) throws IOException, ServletException {
		
		PrintWriter pw = res.getWriter();
		res.setContentType(IOnlineBookStoreConstants.CONTENT_TYPE_TEXT_HTML);
		//String total = (String)req.getAttribute("value");
		String total= req.getParameter("value"); 
		try {
			
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("select * from " + IBookConstants.TABLE_BOOK);
			ResultSet rs = ps.executeQuery();			
			RequestDispatcher rd = req.getRequestDispatcher("pdf.html");
			rd.include(req, res);
			
			pw.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/pdf.css\" />");
			pw.println("<div class=\"title\">");
			pw.println("<h1>" + total + "<h1>");
			pw.println("<h1>\"You have successfully paid.\"<h1>");
			pw.println("</div>");
			
		} catch (Exception e) {
			e.printStackTrace();
	}
}
}