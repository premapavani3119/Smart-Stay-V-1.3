<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    // Check if user is logged in
    String user = (String) session.getAttribute("user");
    if (user == null) {
        // If no user in session, redirect to login page
        response.sendRedirect("userlogin.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Dashboard</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        nav {
            margin-bottom: 20px;
        }
        nav a {
            margin-right: 15px;
            text-decoration: none;
            color: blue;
        }
        nav a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <h2>Welcome, <%= user %>!</h2>

    <!-- Navigation bar -->
    <nav>
        <a href="profile.jsp">Profile</a>
        <a href="bookings.jsp">Bookings</a>
        <a href="${pageContext.request.contextPath}/logout">Logout</a>
    </nav>

    <hr/>

    <p>This is your user dashboard. From here you can access your profile, manage bookings, or log out.</p>
</body>
</html>
