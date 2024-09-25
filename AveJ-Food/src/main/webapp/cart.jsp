<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.food.model.CartItem, com.food.model.User" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cart</title>
    <link rel="stylesheet" href="CSS/carts.css"> <!-- Corrected the CSS link -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"/>
</head>
<body>
    <header>
        <nav>
            <ul>
                <% 
                User user = (User) session.getAttribute("loggedInUser");
                if (user != null) {
                %>
                <li><a>Welcome, <%= user.getUserName() %>!</a></li>
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
    
    <main>
        <section class="cart-container animate__animated animate__fadeIn">
        <h1>Your cart</h1>
            <% 
            List<CartItem> cartList = (List<CartItem>) session.getAttribute("cartList");
            double totalAmount = 0.0;
            if (cartList != null && !cartList.isEmpty()) {
                for (CartItem cartItem : cartList) { 
                    double itemTotal = cartItem.getQuantity() * cartItem.getPrice();
                    totalAmount += itemTotal;
            %>
            <div class="cart-item">
                <h3><%= cartItem.getItemName() %></h3>
                <p>Price: ₹<%= cartItem.getPrice() %></p>     
                <p>Quantity: <%= cartItem.getQuantity() %></p>
                <p>Total: ₹<%= itemTotal %></p>
                <form action="UpdateCart"  class="update-form">
                    <input type="hidden" name="cartId" value="<%= cartItem.getCartId() %>">
                    <label>Quantity: <input type="number" name="quantity" value="<%= cartItem.getQuantity() %>" min="1"></label>
                    <input type="submit" name="action" value="Update" class="btn update-btn">
                </form>
                <form action="DeleteCart"  class="remove-form">
                    <input type="hidden" name="cartId" value="<%= cartItem.getCartId() %>">
                    <input type="submit" name="action" value="Remove" class="btn remove-btn">
                </form>
            </div>
            <% 
                }
            } else { 
            %>
            <p>Your cart is empty.</p>
            <% } %>
        </section>

        <% if (cartList != null && !cartList.isEmpty()) { %>
        <section class="cart-summary">
            <h2>Total Amount: ₹<%= totalAmount %></h2>
        </section>
        <% } %>
        
        <section class="cart-actions">
<%--             <% 
            Integer restaurantId = (Integer) session.getAttribute("restaurantId");
            if (restaurantId != null) { 
            %> --%>
                <form action="restaurant" method="post" class="checkout-form">
                    <input type="submit" value="Add more" class="btn add-more-items-btn">
                    
                </form>
<%--             <% } else { %>
                <p></p>
            <% } %> --%>

            <% if (cartList != null && user != null) { 
            	
            	for(CartItem cartItem:cartList){
            %>
            		
                <form action="orderHistory"  class="checkout-form">
                <input type = "hidden" name ="cid" value="<%= user.getUserID() %>" >
                <input type = "hidden" name ="restaueantId" value="<%= cartItem.getRestaurantId() %>" >
                <input type = "hidden" name ="quantity" value="<%= cartItem.getQuantity() %>" >
                <input type = "hidden" name ="itemName" value="<%= cartItem.getItemName() %>" >
                 <%  } %>  
                   <input type = "hidden" name ="totalAmount" value=" <%= totalAmount %>" >
                   <input type="submit" value="Proceed to Checkout" class="btn proceed-to-checkout-btn">
                </form>
             <% 
             } else if (user == null) {
                response.sendRedirect("login.jsp");
            } %>
        </section>
    </main>
</body>
</html>
