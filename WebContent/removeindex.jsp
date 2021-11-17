<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
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
<!DOCTYPE html>
<html>
<link rel="stylesheet" type="text/css" href="update.css">
<div class="main">
<ul>
<li><a href="sample2.html">Home</a></li>
<li><a href="AddBook.html">Add Books</a></li>
<li><a href="seachindex.jsp">View Books</a></li>
<li><a href="updateindex.jsp">Update Books</a></li>
<li><a href="index.html">Logout</a></li>
</ul>
</div>	
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<body>
<div class="tab">
<table border="1">
<tr>
<th>Barcode</th>
<th>Name</th>
<th>Author</th>
<th>Price</th>
<th>Quantity</th>
<th>Action</th>
</tr>

<%
try{
connection = DriverManager.getConnection(connectionUrl+database, userid, password);
statement=connection.createStatement();
String sql ="select * from books";
resultSet = statement.executeQuery(sql);
int i=0;
while(resultSet.next()){
%>
<tr>
<td><%=resultSet.getString("barcode") %></td>
<td><%=resultSet.getString("name") %></td>
<td><%=resultSet.getString("author") %></td>
<td><%=resultSet.getInt("price") %></td>
<td><%=resultSet.getInt("quantity") %></td>
<td><a href="delete.jsp?barcode=<%=resultSet.getString("barcode") %>"><button type="button" class="delete" onclick="return confirm('Are you sure you want to delete this item?')">Delete</button></a></td>
</tr>

<%
i++;
}
connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>
</table>
</div>
</body>
</html>