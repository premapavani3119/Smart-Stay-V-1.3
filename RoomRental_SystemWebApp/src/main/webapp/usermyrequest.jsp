<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.model.Booking" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Requests</title>

    <style>
        /* page background gradient */
        body {
            margin: 0;
            font-family: Arial, Helvetica, sans-serif;
            background: linear-gradient(to right, #AACDDC, #AACDDC);
            color: #222;
        }

        .container {
            max-width: 1000px;
            margin: 40px auto;
            background: rgba(255,255,255,0.92);
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 6px 18px rgba(0,0,0,0.08);
        }

        h2 {
            margin-top: 0;
            text-align: center;
            color: #0b4f6c;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 12px;
        }

        th, td {
            padding: 10px 12px;
            border: 1px solid #d0d7db;
            text-align: left;
            font-size: 14px;
        }

        th {
            background: linear-gradient(to right, #0b4f6c, #2b8aa3);
            color: #fff;
            font-weight: 600;
        }

        tr:nth-child(even) td {
            background: #f7fbfc;
        }

        .actions a {
            display: inline-block;
            margin-right: 6px;
            padding: 6px 10px;
            font-size: 13px;
            text-decoration: none;
            border-radius: 4px;
            color: #fff;
        }

        .btn-accept { background: #198754; }
        .btn-reject { background: #dc3545; }

        .status-badge {
            display: inline-block;
            padding: 4px 8px;
            border-radius: 12px;
            font-size: 13px;
            color: #fff;
        }

        .status-accepted { background: #198754; }
        .status-pending  { background: #ffc107; color: #222; }
        .status-rejected { background: #dc3545; }
    </style>
</head>
<body>
<div class="container">
    <h2>All Room Requests</h2>

    <table>
        <tr>
            <th>Booking ID</th>
            <th>User ID</th>
            <th>Room ID</th>
            <th>Request Date</th>
            <th>Status</th>
            
        </tr>

        <%
            List<Booking> list = (List<Booking>) request.getAttribute("requests");
            if (list != null) {
                for (Booking b : list) {
                    String status = b.getStatus() == null ? "" : b.getStatus().trim();
                    String statusClass = "status-pending";
                    if ("accepted".equalsIgnoreCase(status)) statusClass = "status-accepted";
                    else if ("rejected".equalsIgnoreCase(status)) statusClass = "status-rejected";
        %>
        <tr>
            <td><%= b.getBookingid() %></td>
            <td><%= b.getUserid() %></td>
            <td><%= b.getRoomid() %></td>
            <td><%= b.getRequest_date() %></td>
            <td>
                <span class="status-badge <%= statusClass %>"><%= status.isEmpty() ? "N/A" : status %></span>
            </td>
            
        </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td colspan="6" style="text-align:center; padding:18px;">No requests found.</td>
        </tr>
        <%
            }
        %>
    </table>
</div>
</body>
</html>
