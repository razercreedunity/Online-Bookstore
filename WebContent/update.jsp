<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
String barcode = request.getParameter("barcode");
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
<%
try{
connection = DriverManager.getConnection(connectionUrl+database, userid, password);
statement=connection.createStatement();
String sql ="select * from books where barcode="+barcode;
resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="remove.css">
<body>
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
<div class="login-box">
<form method="post" action="update-process.jsp">
<div class="textbox">
<p>Barcode:</p>
<input type="hidden" name="barcode" value="<%=resultSet.getString("barcode") %>">
<input type="text" name="barcode" readonly="readonly" value="<%=resultSet.getString("barcode") %>">
</div>
<div class="textbox">
<p>Name:</p>
<input type="text" name="name" value="<%=resultSet.getString("name") %>">
</div>
<div class="textbox">
<p>Author:</p>
<input type="text" name="author" value="<%=resultSet.getString("author") %>">
</div>
<div class="textbox">
<p>Price:</p>
<input type="text" name="price" value="<%=resultSet.getInt("price") %>">
</div>
<div class="textbox">
<p>Quantity:</p>
<input type="text" name="quantity" value="<%=resultSet.getInt("quantity") %>">
</div>
<input type="submit" class="btn" value="submit">
</form>
<%
}
connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>
</div>
</body>
</html>