<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="java.util.*,com.model.Booking" %>

<html>
<head>

<title>Admin Room Requests</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

</head>

<body>

<div class="container mt-5">

<h3 class="text-center">All Room Requests</h3>

<table class="table table-bordered mt-4">

<tr class="table-dark">

<th>BookingID</th>
<th>UserID</th>
<th>RoomID</th>
<th>Date</th>
<th>Status</th>
<th>Action</th>

</tr>

<%

List<Booking> list = (List<Booking>)request.getAttribute("reqList");

if(list!=null){

for(Booking b:list){

%>

<tr>

<td><%=b.getBookingid()%></td>
<td><%=b.getUserid()%></td>
<td><%=b.getRoomid()%></td>
<td><%=b.getRequest_date()%></td>
<td><%=b.getStatus()%></td>

<td>

<a href="UpdateRequestStatusServlet?bookingid=<%=b.getBookingid()%>&status=Approved"
class="btn btn-success btn-sm">Accept</a>

<a href="UpdateRequestStatusServlet?bookingid=<%=b.getBookingid()%>&status=Rejected"
class="btn btn-danger btn-sm">Reject</a>

</td>

</tr>

<%
}
}
%>

</table>

</div>

</body>
</html>