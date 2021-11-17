<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*,java.util.*"%>
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
String barcode=request.getParameter("barcode");
try
{
Class.forName("com.mysql.jdbc.Driver");
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/onlinebookstore", "root", "");
Statement st=conn.createStatement();
int i=st.executeUpdate("DELETE FROM books WHERE barcode="+barcode);%>
<div class= "title">
<h1>Book Delete Successfully</h1>
</div>
<%
}
catch(Exception e)
{
System.out.print(e);
e.printStackTrace();
}
%>