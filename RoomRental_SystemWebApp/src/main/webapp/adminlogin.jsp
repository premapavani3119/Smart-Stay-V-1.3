<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Login</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
body{
    background-color:#AACDDC;
}
.login-box{
    max-width:400px;
    margin:100px auto;
}
</style>
</head>

<body>

<div class="login-box">
    <div class="card shadow p-4">
        <h3 class="text-center mb-4">Admin Login</h3>

        <form action="AdminLoginServlet" method="post">
            <div class="mb-3">
                <label> Name</label>
                <input type="text" name="aname" class="form-control" required>
            </div>
            

            <div class="mb-3">
                <label>Password</label>
                <input type="password" name="apsw" class="form-control" required>
            </div>

            <button type="submit" class="btn btn-dark w-100">Login</button>
        </form>
    </div>
</div>

</body>
</html>