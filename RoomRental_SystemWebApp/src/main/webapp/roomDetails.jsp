<%@ page import="com.model.Rooms" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
<title>Room Details</title>

<style>

body{
font-family: Arial;
background: linear-gradient(to right,#AACDDC, #AACDDC);
}


.container{
width:60%;
margin:auto;
margin-top:40px;
}

.card{
background:white;
padding:25px;
border-radius:8px;
box-shadow:0px 0px 10px gray;
}

h2{
color:#333;
}

p{
font-size:16px;
}

.btn{
padding:10px 15px;
background:#81A6C6;
color:white;
text-decoration:none;
border-radius:5px;
}

.btn:hover{
background:#6b8fae;
}

</style>

</head>

<body>

<div class="container">

<%
Rooms r = (Rooms)request.getAttribute("room");
%>

<%
String msg = request.getParameter("msg");
if("requestsent".equals(msg)){
%>

<div style="background:#d4edda;color:#155724;padding:10px;border-radius:5px;margin-bottom:15px;">
✅ Room request sent successfully!
</div>

<%
}
%>

<% if(r != null){ %>

<div class="card">

<h2><%=r.getTitle()%></h2>

<p><b>Description:</b> <%=r.getDescription()%></p>

<p><b>Price:</b> ₹ <%=r.getPrice()%></p>

<p><b>Sharing_type:</b> <%=r.getSharing_type()%></p>

<p><b>Available Rooms:</b> <%=r.getAvailablerooms()%></p>

<a href="RequestRoomServlet?roomId=<%=r.getRoomId()%>" class="btn btn-custom">
Request Room
</a>
</div>

<% } else { %>

<div class="card">

<h2>No Room Found</h2>

<p>The requested room details are not available.</p>

<a href="ViewRoomsServlet" class="btn">Back to Rooms</a>

</div>

<% } %>

</div>

</body>
</html>