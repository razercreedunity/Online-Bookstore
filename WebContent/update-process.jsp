<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<%! String driverName = "com.mysql.jdbc.Driver";%>
<%!String url = "jdbc:mysql://localhost:3307/onlinebookstore";%>
<%!String user = "root";%>
<%!String psw = "";%>
<link rel="stylesheet" type="text/css" href="update.css">
 <div class="main">
<ul>
<li><a href="sample2.html">Home</a></li>
<li><a href="AddBook.html">Add Books</a></li>
<li><a href="removeindex.jsp">Remove Books</a></li>
<li><a href="seachindex.jsp">View Books</a></li>
<li><a href="updateindex.jsp">Update Books</a></li>
<li><a href="index.html">Logout</a></li>
</ul>
</div>
<%

String barcode = request.getParameter("barcode");
String name=request.getParameter("name");
String author=request.getParameter("author");
int price= Integer.parseInt(request.getParameter("price"));
int quantity= Integer.parseInt(request.getParameter("quantity"));
if(barcode != null)
{
Connection con = null;
PreparedStatement ps = null;
int personID = Integer.parseInt(barcode);
try
{
Class.forName(driverName);
con = DriverManager.getConnection(url,user,psw);
String sql="Update books set barcode=?,name=?,author=?,price=?,quantity=? where barcode="+barcode;
ps = con.prepareStatement(sql);
ps.setString(1,barcode);
ps.setString(2, name);
ps.setString(3, author);
ps.setInt(4, price);
ps.setInt(5, quantity);
int i = ps.executeUpdate();
if(i > 0)
{%>
	<div class= "title">
	<h1>Book Update Successfully</h1>
	</div>
	<%
}
else
{
out.print("There is a problem in updating Record.");
}
}
catch(SQLException sql)
{
request.setAttribute("error", sql);
out.println(sql);
}
}
%>