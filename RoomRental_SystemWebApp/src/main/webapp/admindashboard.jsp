<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%
String admin = (String)session.getAttribute("admin");

if(admin == null){
    response.sendRedirect("adminlogin.jsp");
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Dashboard</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

<style>

body{

background: linear-gradient(to right,#AACDDC, #AACDDC);

}

.btn-custom {
    background-color: #81A6C6;   /* your custom color */
    color: white;               /* text color */
}
.btn-custom:hover {
    background-color: #6b8fae;   /* darker shade on hover */
    color: white;
}


.dashboard-box{
max-width:900px;
margin:80px auto;
background: linear-gradient(to right, #AACDDC, #AACDDC);
}

.card{
transition:0.3s;
}

.card:hover{
transform:scale(1.05);
}

</style>

</head>

<body>

<div class="container dashboard-box">

<h2 class="text-center mb-5">Admin Dashboard</h2>

<div class="row">

<div class="col-md-4 mb-4">
<div class="card shadow text-center p-4">
<h4>Add Location</h4>
<p>Add new cities and areas</p>
<a href="addLocation.jsp" class="btn btn-custom">Open</a>
</div>
</div>

<div class="col-md-4 mb-4">
<div class="card shadow text-center p-4">
<h4>Add Room</h4>
<p>Add rooms for rental</p>
<a href="addroom.jsp" class="btn btn-custom">Open</a>
</div>
</div>

<div class="col-md-4 mb-4">
<div class="card shadow text-center p-4">
<h4>View Requests</h4>
<p>Check user booking requests</p>
<a href="AdminViewRoomRequests" class="btn btn-custom">Open</a>
</div>
</div>



<div class="col-md-4 mb-4">
<div class="card shadow text-center p-4">
<h4>Logout</h4>
<p>Exit from admin panel</p>
<a href="LogoutServlet" class="btn btn-custom">Logout</a>
</div>
</div>

</div>

</div>

</body>
</html>