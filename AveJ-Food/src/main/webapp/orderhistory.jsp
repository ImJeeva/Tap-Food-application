<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.food.model.OrderHistorys" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Order History</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"/>
    <link rel="stylesheet" href="CSS/orderHistory.css">
</head>
<body>
    <!-- Header Section -->
    <header class="animate__animated animate__fadeInDown bg-dark text-white py-3">
        <nav class="navbar navbar-expand-lg navbar-dark container">
            <a class="navbar-brand" href="index.jsp">FoodApp</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item"><a class="nav-link" href="index.jsp">Home</a></li>
                    <li class="nav-item"><a class="nav-link" href="#">About Us</a></li>
                    <li class="nav-item"><a class="nav-link" href="aboutme.html">Contact</a></li>
                    <li class="nav-item"><a class="nav-link" href="logout">Logout</a></li>
                </ul>
            </div>
        </nav>
    </header>

    <!-- Order History Section -->
    <div class="container my-5 animate__animated animate__fadeInUp">
        <h1 class="text-center mb-4">Order History</h1>

        <%
            List<OrderHistorys> orderHistorys = (List<OrderHistorys>) session.getAttribute("orderHistory");

            if (orderHistorys != null && !orderHistorys.isEmpty()) {
        %>
        <table class="table table-hover table-bordered">
            <thead class="thead-dark">
                <tr>
                    <th scope="col">Order ID</th>
                    <th scope="col">Item Name</th>
                    <th scope="col">Quantity</th>
                    <th scope="col">Total Amount</th>
                </tr>
            </thead>
            <tbody>
                <%
                    for (OrderHistorys order : orderHistorys) {
                %>
                <tr>
                    <th scope="row"><%= order.getOrderHistoryId() %></th>
                    <td><%= order.getItemName() %></td>
                    <td><%= order.getQuantity() %></td>
                    <td>₹<%= order.getTotalAmount() %></td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
        <% 
            } else { 
        %>
        <p class="text-center">You have no order history.</p>
        <% 
            } 
        %>
    </div>

    <!-- Scripts -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
