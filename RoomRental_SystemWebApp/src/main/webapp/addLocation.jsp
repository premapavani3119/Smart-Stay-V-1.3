<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Add Location</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

</head>
<style>
body{
background: linear-gradient(to right,#AACDDC,#AACDDC);
}
.container{
max-width:500px;
margin-top:80px;
}
</style>

<body>

<div class="container">
<div class="card shadow p-4">

<h3 class="text-center mb-4">Add Location</h3>

<form action="addLocationServlet" method="post">

<div class="mb-3">
<label>City</label>
<input type="text" name="city" class="form-control" required>
</div>

<div class="mb-3">
<label>Area</label>
<input type="text" name="area" class="form-control" required>
</div>

<div class="mb-3">
<label>State</label>
<input type="text" name="state" class="form-control" required>
</div>

<div class="mb-3">
<label>Pincode</label>
<input type="text" name="pincode" class="form-control" required>
</div>

<button class="btn btn-primary">Add Location</button>

</form>

</div>

</div>

</body>
</html>