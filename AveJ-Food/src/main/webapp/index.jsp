<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.List, com.food.model.Restaurant, com.food.model.User" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Food Delivery App</title>
   <link rel="stylesheet" href="CSS/stylee.css">
</head>
<body>
    <header>
        <nav>
            <div class="logo animate__animated animate__bounce"></div>
            <ul>
                <% 
                User user = (User) session.getAttribute("loggedInUser");
                if(user != null) {
                %>
                <li><a>Welcome, <%=user.getUserName()%>!</a></li>
                <li><a href="restaurant">Restaurants</a></li>
                <li><a href="#">About Us</a></li>
                <li><a href="ViewOrderHistory">Order History</a></li>
                <li><a href="logout" class="login-btn">Logout</a></li>
                <%
                } else{
                %>
                <li><a href="index.jsp">Home</a></li>
                <li><a href="#">About Us</a></li>
                <li><a href="aboutme.html">Contact</a></li>
                <li><a href="login.jsp" class="login-btn">Login</a></li>
                <li><a href="signup.jsp" class="signup-btn">SignUp</a></li>  
                <%
                }
                %>
            </ul>
        </nav>
    </header>
    
   
         
 <section class="hero">
        <div class="hero-content animate__animated animate__fadeIn">
            <h1>Order food online from 1000+ restaurants!</h1>
            <p>Food delivery service that's easy & convenient!</p>
            <form action="restaurant" id="searchForm">
                <div class="search-box animate__animated animate__fadeInUp">
                    <select required name="city" id="city">
                        <option value="" disabled selected>City</option>
                        <option value="Chennai">Chennai</option>
                        <option value="Bengaluru">Bengaluru</option>
                        <option value="Mumbai">Mumbai</option>
                        <option value="Hyderabad">Hyderabad</option>
                        <option value="Pune">Pune</option>
                        <option value="Delhi">Delhi</option>
                        <option value="Kerala">Kerala</option>
                        <option value="Gujarat">Gujarat</option>
                    </select>
                    <input type="text" placeholder="District Name" name="district" id="district">
                    <button type="submit" class="show-restaurants">SHOW RESTAURANTS</button>
                </div>
            </form>
        </div>
    </section>
    
    <section class="how-it-works">
        <h1 >How it Work</h1>
        <p>Get your favourite food in 4 simple steps</p>
        <div class="steps">
            <div class="step">
                <img src="images/tick.jpeg" alt="Search">
                <h3>Easy Signup</h3>
                <p>Create your account quickly with our simple registration process.</p>
            </div>
            <div class="step">
                <img src="images/searching.jpeg" alt="Choose">
                <h3>Browse Options</h3>
                <p>Explore a variety of services and find what you need in seconds.</p>
            </div>
            <div class="step">
                <img src="images/step2.png" alt="Pay">
                <h3>Order Effortlessly</h3>
                <p>Place your order with just a few clicks.</p>
            </div>
            <div class="step">
                <img src="images/step3.png" alt="Enjoy">
                <h3>Secure Payments</h3>
                <p>Pay confidently with our robust, secure payment gateway.</p>
            </div>
        </div>
    </section>
    <section class="featured-dishes">
        <h1 class="header">Featured Dishes</h1>
        <div class="dishes">
                    <div class="dish" class="c">
                <img src="images/biriyani.jpg" alt="biriyani">
                <h3>Biriyani</h3>
                <p>Fresh Biriyani with Hyderabadi style.</p>
            </div>
            <div class="dish" class="a">
                <img src="images/pizza.jpeg" alt="Pizza">
                <h3>Margherita Pizza</h3>
                <p>Classic pizza topped with fresh mozzarella, juicy tomatoes, and fragrant basil.</p>
            </div>
            <div class="dish" class="b">
                <img src="images/burgers.jpeg" alt="Burger">
                <h3>Burger</h3>
                <p>Grilled chicken breast with bacon,Swiss cheese.</p>
            </div>
            <div class="dish" class="c">
                <img src="images/chicken.jpeg" alt="Sushi">
                <h3>BBQ Chicken Pizza</h3>
                <p>Savory barbecue sauce base topped with grilled chicken, red onions, and cilantro</p>
            </div>
        </div>
    </section>
    <section class="restaurants" style="background-color: rgb(255, 253, 253)">
        <h1 class="header">Popular Restaurants</h1>
        
        
        
        
        
        <div class="restaurant-container">
            <div class="restaurant-item">
                <img src="images/biriyani.jpg" alt="Restaurant 1">
                <h3>Biryani Bliss</h3>
                <p>North Indian Biryani</p>
                <span>40-45 mins</span>
            </div>
            <div class="restaurant-item">
                <img src="images/pizzapar.jpeg" alt="Restaurant 1">
                <h3>Pizza Paradise</h3>
                <p>Top Picking</p>
                <span>40-45 mins</span>
            </div>
            <div class="restaurant-item">
               <img src="images/wok.jpeg" alt="Restaurant 1"> 
                <h3>Chinese Wok</h3>
                <p>Chinese,Asian,Tibetan,Desserts</p>
                <span>25-30 mins</span>
            </div>
            <div class="restaurant-item">
                <img src="images/burgerk.jpeg" alt="Restaurant 1">
                <h3>Burger King</h3>
                <p>Burger,American</p>
                <span>40-45 mins</span>
            </div>
            <div class="restaurant-item">
                <img src="images/mcdavif.avif" alt="Restaurant 1">
                <h3>McDonald's</h3>
                <p>Burger,Beverages,Cafe,Desserts</p>
                <span>40-45 mins</span>
            </div>
            <div class="restaurant-item">
                <img src="images/ice.avif" alt="Restaurant 1">
                <h3>Havmor Havfunn Ice Cream</h3>
                <p>Ice Cream, Beverages</p>
                <span>40-45 mins</span>
            </div>
            <div class="restaurant-item">
                <img src="images/pizza.jpeg" alt="Restaurant 1">
                <h3>Domaino's Pizza</h3>
                <p>Pizzas, Italian, Deserts</p>
                <span>40-45 mins</span>
            </div>
            <div class="restaurant-item">
                <img src="images/subway.avif" alt="Restaurant 1">
                <h3>Subway</h3>
                <p>SALADS, Snacks, Desserts</p>
                <span>30-40 mins</span>
            </div>
            <div class="restaurant-item">
                <img src="images/kfc.jpeg" alt="Restaurant 1">
                <h3>KFC</h3>
                <p>Burgers, Fast Foods</p>
                <span>40-45 mins</span>
            </div>
            <div class="restaurant-item">
                <img src="images/favif.avif" alt="Restaurant 1">
                <h3>Sizzling Curries</h3>
                <p>Narth Indain,Chinese</p>
                <span>25-30 mins</span>
            </div>
            <div class="restaurant-item">
                <img src="images/momavif.avif" alt="Restaurant 1">
                <h3>Woe! Momo</h3>
                <p>Tibetan, Healthy Foods</p>
                <span>40-45 mins</span>
            </div>
            <div class="restaurant-item">
                <img src="images/anand.avif" alt="Restaurant 1">
                <h3>A2B - Ananda Bhavan</h3>
                <p>South Indian</p>
                <span>40-45 mins</span>
            </div>
            
        </div>
    </section>
    <section class="testimonials">
        <h1 class="header">What Our Customers Say</h1>
        <div class="testimonial">
            <p>"Easy-to-use app with fantastic service, ensuring a seamless ordering process!"</p>
            <h4>- Vikrant Rona </h4>
        </div>
        <div class="testimonial">
            <p>""Great variety and perfect for every craving! The app is user-friendly and the customer service is excellent." I'm a regular customer now!"</p>
            <h4>- Natasha</h4>
        </div>
    </section>
    <section class="sliding-banner">
        <div class="banner-content">
            <p>Special Offer: Get 50% off on your first order! Use code: Avej%50</p>
        </div>
    </section>
    
    <footer>
        <div class="footer-content">
            <p>&copy; 2024 Tap Foods.</p>
            <ul>
                <li><a href="#">Privacy Policy</a></li>
                <li><a href="#">Terms of Service</a></li>
                <li><a href="#">Contact Us</a></li>
            </ul>
        </div>
    </footer>
    <script>
        window.addEventListener('scroll', function() {
            const nav = document.querySelector('nav');
            if (window.scrollY > 50) {
                nav.classList.add('scrolled');
            } else {
                nav.classList.remove('scrolled');
            }
        });

        document.getElementById('searchForm').addEventListener('submit', function(event) {
            const user = '<%=user != null%>';
            if (!user) {
                event.preventDefault();
                alert("Please log in or sign up first.");
                window.location.href = 'login.jsp';
            }
        });
    </script>
    <script src="JavaScript/main.js"></script>  
</body>
</html>