<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Login</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
body{
    background: linear-gradient(to right, #AACDDC, #AACDDC);
}
.login-box{
    max-width:400px;
    margin:100px auto;
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

<div class="login-box">
    <div class="card shadow p-4">
        <h3 class="text-center mb-4">User Login</h3>

        <form action="Userlogin" method="post">
            <div class="mb-3">
                <label>Email</label>
                <input type="email" name="email" class="form-control" required>
            </div>

            <div class="mb-3">
                <label>Password</label>
                <input type="password" name="password" class="form-control" required>
            </div>

            <button type="submit" class="btn btn-custom">Login</button>

            <p class="text-center mt-3">
                Don't have an account? <a href="Register.jsp">Register Here</a>
            </p>
        </form>
    </div>
</div>

</body>
</html>