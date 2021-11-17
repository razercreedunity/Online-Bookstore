package servlets;
import java.io.*;

import java.sql.*;
import javax.servlet.*;

import constants.IOnlineBookStoreConstants;
import sql.IBookConstants;
import sql.IUserContants;
public class BuyBooksServlet extends GenericServlet{
	public void service(ServletRequest req,ServletResponse res) throws IOException,ServletException
	{
		PrintWriter pw = res.getWriter();
		res.setContentType(IOnlineBookStoreConstants.CONTENT_TYPE_TEXT_HTML);
		String name= req.getParameter("uname"); 
		try {
			Connection con = DBConnection.getCon();
			RequestDispatcher rd = req.getRequestDispatcher("buybook.html");
			
			rd.include(req, res);
			
			PreparedStatement pt =con.prepareStatement("select * from " +  IBookConstants.TABLE_BOOK + "  where " + IBookConstants.COLUMN_NAME + " like ?");
            pt.setString(1,name+"%"); 

          
            ResultSet rt= pt.executeQuery();                

            /* Printing column names */

            ResultSetMetaData rsmd=rt.getMetaData();
            
           
			
            	pw.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/stylebuy.css\" />");
    			pw.println("<div>");
    			pw.println("<form action=\"buys\" method=\"post\">");
    			pw.println("<table class=\"content-table\">" + 
    					"		<thead>" + 
    					"			<tr>\r\n" + 
    					"				<th>Choose</th>\r\n" + 
    					"				<th>Code</th>\r\n" + 
    					"				<th>Name</th>\r\n" + 
    					"				<th>Author</th>\r\n" + 
    					"				<th>Price</th>\r\n" + 
    					"				<th>Availability</th>\r\n" + 
    					"				<th>Quantity</th>\r\n" + 
    					"			</tr>" +
    		            "          </thead>");
    			
    			
    	            while(rt.next())

    	               {
            	String bCode = rt.getString(1);
				String bName = rt.getString(2);
				String bAuthor = rt.getString(3);
				int bPrice = rt.getInt(4);
				int bAvl = rt.getInt(5);
				
				
				String n = "checked"+bCode;
				String q ="qty"+ bCode;
				pw.println("<tbody>");
				pw.println("<tr>\r\n" + 
						"				<td>\r\n" + 
						"					<input type=\"checkbox\" name="+n+" value=\"pay\" >\r\n" + //Value is made equal to bcode
						"				</td>");
				pw.println("<td>"+bCode+"</td>");
				pw.println("<td>"+bName+"</td>");
				pw.println("<td>"+bAuthor+"</td>");
				pw.println("<td>"+bPrice+"</td>");
				pw.println("<td>"+bAvl+"</td>");
				
				pw.println("<td><input type=\"text\" name="+q+" value=\"0\" text-align=\"center\"></td></tr>");
				pw.println("</tbody>");
    	               } 
				pw.println("<input type=\"submit\" class=\"btn\" value=\" Check Out \">"+"<br/>"+
						"	</form>\r\n");
			
               
			pw.println("</table>");
			pw.println("</div>");
 
			
            

			
			//pw.println("<div class=\"tab\"><a href=\"AddBook.html\">Add More Books</a></div>");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
