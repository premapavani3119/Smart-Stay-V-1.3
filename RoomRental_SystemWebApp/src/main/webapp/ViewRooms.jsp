 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List" %>
<%@ page import="com.model.Rooms" %>
<!DOCTYPE html>
<html>
<head>
<title>Available Rooms</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

</head>
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
</style>

<body>

<div class="container mt-5">

<h2 class="text-center">Available Rooms</h2>

<div class="row">

<%
List<Rooms> rooms = (List<Rooms>)request.getAttribute("roomList");
if(rooms != null){
for(Rooms r : rooms){
%>

<div class="col-md-4">

<div class="card shadow mt-4">

<div class="card-body">

<h5><%=r.getTitle()%></h5>

<p><b>Description:</b> <%=r.getDescription()%></p>

<p><b>Price:</b> ₹ <%=r.getPrice()%></p>

<p><b>Sharing_type:</b> <%=r.getSharing_type()%></p>

<p><b>Available:</b> <%=r.getAvailablerooms()%></p>

<a href="<%=request.getContextPath()%>/RoomDetailsServlet?roomId=<%=r.getRoomId()%>" 
                       class="btn btn-custom">View Details</a>


</div>

</div>

</div>

<%
}
}
%>

</div>

</div>

</body>
</html>
