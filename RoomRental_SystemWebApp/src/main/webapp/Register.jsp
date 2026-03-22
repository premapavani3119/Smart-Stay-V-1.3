<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Registration</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
body{
    background-color:#eef2f3;
}
.register-box{
    max-width:600px;
    margin:50px auto;
}
</style>
</head>

<body>

<div class="register-box">
    <div class="card shadow p-4">
        <h3 class="text-center mb-4">User Registration</h3>

        <form action="RegisterServlet" method="post">

            <div class="mb-3">
                <label>Full Name</label>
                <input type="text" name="fullname" class="form-control" required>
            </div>

            <div class="mb-3">
                <label>Email</label>
                <input type="email" name="email" class="form-control" required>
            </div>

            <div class="mb-3">
                <label>Password</label>
                <input type="password" name="password" class="form-control" required>
            </div>

            <div class="mb-3">
                <label>Phone</label>
                <input type="text" name="phone" class="form-control">
            </div>

            <div class="mb-3">
                <label>Gender</label>
                <select name="gender" class="form-select">
                    <option value="M">Male</option>
                    <option value="F">Female</option>
                    <option value="O">Other</option>
                </select>
            </div>

            <div class="mb-3">
                <label>Age</label>
                <input type="number" name="age" class="form-control">
            </div>

            <div class="mb-3">
                <label>Occupation</label>
                <input type="text" name="occupation" class="form-control">
            </div>

            <button type="submit" class="btn btn-success w-100">Register</button>

            <p class="text-center mt-3">
                Already have account? <a href="login.jsp">Login Here</a>
            </p>

        </form>
    </div>
</div>

</body>
</html>