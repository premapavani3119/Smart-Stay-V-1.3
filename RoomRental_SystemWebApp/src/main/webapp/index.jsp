<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Room Rental System</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
    body {
        background: linear-gradient(to right, #AACDDC, #AACDDC);
        height: 100vh;
        display: flex;
        align-items: center;
        justify-content: center;
    }
    .card {
        border-radius: 15px;
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

<div class="container text-center">
    <div class="card shadow-lg p-5">
        <h1 class="mb-4">🏠 Welcome to Smart Stay V-1.3</h1>
        <p class="mb-4">Find your perfect room easily and quickly.</p>

        <div class="d-grid gap-3">
            <a href="adminlogin.jsp" class="btn btn-custom">Admin Login</a>
            <a href="login.jsp" class="btn btn-custom">User Login</a>
            <a href="Register.jsp" class="btn btn-custom">User Register</a>
        </div>
    </div>
</div>

</body>
</html>