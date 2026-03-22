<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>



<%@ page import="java.util.List" %>
<%@ page import="com.model.Location" %>
<%@ page import="com.Dao.RoomDao" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Room</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
body{
background: linear-gradient(to right, #AACDDC, #AACDDC);
}
.container{
max-width:500px;
margin-top:80px;
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

</head>

<body>

<div class="container">
<div class="card shadow p-4">

<h3 class="text-center mb-4">Add Room</h3>

<form action="addroomservlet" method="post" enctype="multipart/form-data">

<div class="mb-3">
<label>Title</label>
<input type="text" name="title" class="form-control" required>
</div>

<div class="mb-3">
<label>Description</label>
<textarea name="description" class="form-control"></textarea>
</div>

<div class="mb-3">
<label>Price</label>
<input type="number" name="price" class="form-control" required>
</div>

<div class="mb-3">
  <label>Location</label>
  <select name="locationid" class="form-select" required>
    <%
       RoomDao dao = new RoomDao();
       List<Location> locations = dao.getAllLocations();  // you’ll need a Location model + DAO method
       for(Location loc : locations) {
    %>
       <option value="<%= loc.getLocationId() %>">
           <%= loc.getCity() %> - <%= loc.getArea() %>
       </option>
    <%
       }
    %>
  </select>
</div>



<div class="mb-3">
<label>Room Type</label>
<select name="sharing_type" class="form-select">
<option value="Single">Single</option>
<option value="Double">Double</option>
<option value="Family">Family</option>
</select>
</div>
<div class="mb-3">
<label>Avalabile Rooms</label>
<input type="number" name="availablerooms" class="form-control" required>
</div>


<div class="mb-3">
<label>Status</label>
<select name="status" class="form-select"> 
<option value ="Available">Available</option>
<option value =" Not Avalable">Not Available</option>
</select>

</div>

<!-- Image Upload Fields -->
    <div class="mb-3">
        <label>Image 1</label>
        <input type="file" name="img1" class="form-control">
    </div>

    <div class="mb-3">
        <label>Image 2</label>
        <input type="file" name="img2" class="form-control">
    </div>

    <div class="mb-3">
        <label>Image 3</label>
        <input type="file" name="img3" class="form-control">
    </div>

    <button type="submit" class="btn btn-custom">Add Room</button>
</form>

<p class="text-success mt-3">${successMsg}</p>
<p class="text-danger mt-3">${error}</p>

</div>
</div>

<button type="submit" class="btn btn-custom">Add Room</button>



</body>
</html>