<%@ page import="java.util.List"%>
<%@ page import="com.model.Booking"%>

<%@ page import="java.util.*,com.model.Booking" %>

<html>
<head>
<title>Admin Requests</title>
</head>

<body>

<h2>All Room Requests</h2>

<table border="1" cellpadding="10">

<tr>
<th>Booking ID</th>
<th>User ID</th>
<th>Room ID</th>
<th>Request Date</th>
<th>Status</th>
<th>Action</th>
</tr>

<%
List<Booking> list = (List<Booking>)request.getAttribute("requests");

if(list != null){
for(Booking b : list){
%>

<tr>

<td><%= b.getBookingid() %></td>
<td><%= b.getUserid() %></td>
<td><%= b.getRoomid() %></td>
<td><%= b.getRequest_date() %></td>
<td><%= b.getStatus() %></td>

<td>

<a href="UpdateRequestStatusServlet?bookingId=<%=b.getBookingid()%>&status=Accepted">
<button>Accept</button>
</a>

<a href="UpdateRequestStatusServlet?bookingId=<%=b.getBookingid()%>&status=Rejected">
<button>Reject</button>
</a>

</td>

</tr>

<%
}
}
%>

</table>

</body>
</html>