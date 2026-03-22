<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.model.Users" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Home</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
body{
    background: linear-gradient(to right, #AACDDC, #AACDDC);
}

.btn-custom {
    background-color: #81A6C6;   /* your custom color */
    color: white;               /* text color */
}
.btn-custom:hover {
    background-color: #6b8fae;   /* darker shade on hover */
    color: white;
}

.navbar{
    background-color:#343a40;
}

.navbar a{
    color:white !important;
}

.card{
    border-radius:10px;
}
</style>

</head>

<body>

<!-- Navbar -->

<nav class="navbar navbar-expand-lg">
<div class="container">

<a class="navbar-brand text-white">Room Rental System</a>

<div class="ms-auto">

<span class="text-white me-3">
<%
Users user = (Users)session.getAttribute("user");
%>

Welcome: <%=user.getFullname()%>

<a href="logout" class="btn btn-custom">Logout</a>

</div>

</div>
</nav>


<!-- Main Section -->

<div class="container mt-5">

<div class="row">

<div class="col-md-4">
<div class="card shadow p-4 text-center">

<h4>View Rooms</h4>
<p>Check available rooms</p>

<a href='ViewRoomsServlet'class="btn btn-custom">View Rooms</a>

</div>
</div>


<div class="col-md-4">
<div class="card shadow p-4 text-center">

<h4>My Requests</h4>
<p>See your booking requests</p>

<a href="MyRequestsServlet" class="btn btn-custom">My Requests</a>

</div>
</div>


<div class="col-md-4">
<div class="card shadow p-4 text-center">

<h4>Profile</h4>
<p>View your profile details</p>

<a href="ProfileServlet" class="btn btn-custom">Profile</a>

</div>
</div>


</div>

</div>

</body>
</html>
 