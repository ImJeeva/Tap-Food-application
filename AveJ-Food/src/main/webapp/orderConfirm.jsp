<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.food.model.User" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Order Confirmation</title>
    <link rel="stylesheet" href="CSS/oConfirm.css">
</head>
<body onload="startAnimation()"> <!-- Added onload to trigger animation when page loads -->
    <header class="animate__animated animate__fadeInDown">
        <nav>
            <a href="index.jsp">
                <div class="logo animate__animated animate__bounce"></div>
            </a>
            <ul>
                <% 
                User user = (User) session.getAttribute("loggedInUser");
                if (user != null) {
                %>
                <li><a>Welcome, <%=user.getUserName()%>!</a></li>
                <li><a href="restaurant">Restaurants</a></li>
                <li><a href="#">About Us</a></li>
                <li><a href="ViewOrderHistory">Order History</a></li>
                <li><a href="logout" class="login-btn">Logout</a></li>
                <% } else { %>
                <li><a href="index.jsp">Home</a></li>
                <li><a href="HTML/aboutme.html">About Us</a></li>
                <li><a href="aboutme.html">Contact</a></li>
                <li><a href="login.jsp" class="login-btn">Login</a></li>
                <li><a href="signup.jsp" class="signup-btn">SignUp</a></li>
                <% } %>
            </ul>
        </nav>
    </header>

    <div class="container">
        <h1 class="header">Your Order is Being Processed</h1>
        
        <div class="animation-container">
            <div class="truck">
                <img src="https://cdn-icons-png.freepik.com/512/10473/10473350.png" alt="Delivery Truck Animation">
            </div>
        </div>

        <div id="order-message" class="order-message hidden">
            <% if (user != null) { %>
            <h2> Hey <%= user.getUserName() %>! Order Confirmed!</h2>
            <p>Thank you for your purchase.</p>
            <% } else { %>
            <h2>Order Confirmation</h2>
            <p>Please <a href="login.jsp">login</a> to see your order details.</p>
            <% } %>
        </div>
    </div>

    <script src="JavaScript/OrderConfirm.js"></script>
</body>
</html>
