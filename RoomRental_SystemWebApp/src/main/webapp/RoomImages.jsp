<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Room Gallery</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" 
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-4">
    <h2>Room Images</h2>
    <div id="roomCarousel" class="carousel slide" data-bs-ride="carousel">
        <div class="carousel-inner">
            <c:forEach var="img" items="${images}" varStatus="status">
                <div class="carousel-item ${status.first ? 'active' : ''}">
                   <img src="${pageContext.request.contextPath}/${img}" 
                         class="d-block w-100" alt="Room Image">

                </div>
            </c:forEach>
        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#roomCarousel" data-bs-slide="prev">
            <span class="carousel-control-prev-icon"></span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#roomCarousel" data-bs-slide="next">
            <span class="carousel-control-next-icon"></span>
        </button>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
