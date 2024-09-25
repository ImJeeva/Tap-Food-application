<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.food.model.Menu, com.food.model.User" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Restaurant Menu</title>
    <link rel="stylesheet" href="CSS/Menu.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"/>
</head>
<body>
    <header class="header">
        <nav>
            <a href="index.jsp"> <!-- <div class="logo animate__animated animate__bounce"> -->
            </a>
            <ul>
                <%
                User user = (User) session.getAttribute("loggedInUser");
                if (user != null) {
                %>
                <li><a>Welcome, <%= user.getUserName() %>!</a></li>
                <li><a href="restaurant">Restaurants</a></li>
                <li><a href="#">About Us</a></li>
                <li><a href="ViewOrderHistory">Order History</a></li>
                <li><a href="ViewCart" id="cart-button" class="cart">
                    <i class="fas fa-shopping-cart"></i> Cart <span id="cart-count"></span></a>
                </li>
                <li><a href="logout" class="login-btn">Logout</a></li>
                <% } else { %>
                <li><a href="index.jsp">Home</a></li>
                <li><a href="#">About Us</a></li>
                <li><a href="aboutme.html">Contact</a></li>
                <li><a href="login.jsp" class="login-btn">Login</a></li>
                <li><a href="signup.jsp" class="signup-btn">SignUp</a></li>
                <% } %>
            </ul>
        </nav>
    </header>

    <div class="container">
        <h1 class="container-header">Our Menu</h1>
        <div class="menu-list">
            <% 
            @SuppressWarnings("unchecked")
            List<Menu> menuList = (List<Menu>) request.getAttribute("menuList");
            if (menuList != null && !menuList.isEmpty()) {
                for (Menu menu : menuList) {
            %>
            <div class="menu-item">
                <div class="im">
                    <img src="images/<%= menu.getImagePath() %>" alt="<%= menu.getItemName() %>">
                </div>
                <h3><%= menu.getItemName() %></h3>
                <p><%= menu.getDescription() %></p>
                <p>Price: <%= menu.getPrice() %></p>
                
                <form action="cart" method="post" class="add-to-cart-form">
                    <input type="hidden" name="itemId" value="<%= menu.getMenuId() %>">
                    <input type="hidden" name="itemName" value="<%= menu.getItemName() %>">
                    <input type="hidden" name="itemPrice" value="<%= menu.getPrice() %>">
                    Quantity: <input type="number" name="quantity" value="1" min="1" class="quantity-input">
                    <input type="submit" value="Add to Cart" class="add-to-cart">
                    
                    <% if (user != null) { %>
                        <input type="hidden" name="restId" value="<%= menu.getRestaurantId() %>">
                        <input type="hidden" name="cid" value="<%= user.getUserID() %>">
                    <% } %>
                </form>
            </div>
            <% 
                }
            } else {
            %>
            <p>No Menu items available.</p>
            <% 
            }
            %>
        </div>
    </div>

    <script>
        document.addEventListener('DOMContentLoaded', function() {
            // Attach a submit event listener to all forms with class 'add-to-cart-form'
            document.querySelectorAll('.add-to-cart-form').forEach(function(form) {
                form.addEventListener('submit', function(event) {
                    // Show a confirmation dialog
                    const userConfirmed = confirm('Do you really want to add this item to the cart?');
                    // If the user does not confirm, prevent the form submission
                    if (!userConfirmed) {
                        event.preventDefault();
                    }
                });
            });
        });
    </script>
</body>
</html>
