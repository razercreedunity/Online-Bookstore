<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
String id = request.getParameter("id");
String driver = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3307/";
String database = "onlinebookstore";
String userid = "root";
String password = "";
try {
Class.forName(driver);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}
Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>
<html>
<link rel="stylesheet" type="text/css" href="update.css">
<div class="main">
<ul>
<li><a href="sample2.html">Home</a></li>
<li><a href="AddBook.html">Add Books</a></li>
<li><a href="removeindex.jsp">Remove Books</a></li>
<li><a href="updateindex.jsp">Update Books</a></li>
<li><a href="index.html">Logout</a></li>
</ul>
</div>	
<div class="tab">
<div class= "col-md-4">
<form action= "" method= "get">
<input type="text" class="form-control" name="q" placeholder="Search here..."/>
</form>
</div>

<p></p>
<table class="table table-bordered table-striped table-hover">
<thead>
<tr>
<th>Barcode</th>
<th>Name</th>
<th>Author</th>
<th>Price</th>
<th>Quantity</th>
</tr>
</thead>
<tbody>
<%
try{
connection = DriverManager.getConnection(connectionUrl+database, userid, password);
statement=connection.createStatement();
String query = request.getParameter("q");
String data;
if(query!=null){
    data ="select * from books where name like '%"+query+"%'";
}else{
	data= "select * from books";
}
resultSet = statement.executeQuery(data);
while(resultSet.next()){
	%>
<tr>
<td><%=resultSet.getString("barcode") %></td>
<td><%=resultSet.getString("name") %></td>
<td><%=resultSet.getString("author") %></td>
<td><%=resultSet.getInt("price") %></td>
<td><%=resultSet.getInt("quantity") %></td>
</tr>
<%
}
connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>

</table>
</div>
</html>