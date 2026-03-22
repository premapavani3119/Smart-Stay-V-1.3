<%@ page import="com.model.Users" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Profile</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<style>
body { background: #f5f5f5; font-family: Arial; }
.container { max-width: 600px; margin: 50px auto; }
.card { padding: 20px; border-radius: 8px; background: white; box-shadow: 0 0 10px gray; }
h2 { margin-bottom: 20px; color: #333; }
</style>
</head>
<body>

<div class="container">
<%
Users user = (Users) request.getAttribute("user");
if(user != null){
%>
<div class="card">
<h2>My Profile</h2>
<p><b>Full Name:</b> <%= user.getFullname() %></p>
<p><b>Email:</b> <%= user.getEmail() %></p>
<p><b>Phone:</b> <%= user.getPhone() %></p>
<p><b>Gender:</b> <%= user.getGender() %></p>
<p><b>Age:</b> <%= user.getAge() %></p>
<p><b>Occupation:</b> <%= user.getOccupation() %></p>

<a href="home.jsp" class="btn btn-primary mt-3">Back to Home</a>
</div>
<%
} else {
	
%>
<div class="card">
<h2>No user found!</h2>
<a href="login.jsp" class="btn btn-primary mt-3">Login</a>
</div>
<%
}
%>
</div>

</body>
</html>