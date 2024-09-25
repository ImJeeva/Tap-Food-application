<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="CSS/logsign.css">
</head>
<body>


   
    <header>
        <nav>
           <a href="index.jsp"> <div class="logo"></div></a>
            <ul>
                <li><a href="index.jsp">Home</a></li>
                <li><a href="#">Browse Restaurant</a></li>
                <li><a href="#">About Us</a></li>

                <li><a href="aboutme.html">Contact</a></li>

                <li><a href="signup.jsp">Sign Up</a></li>
            </ul>
        </nav>
    </header>
    
    <section class="auth-section">
 
        <div class="auth-container">
            <div class="auth-left">
               <h2 class="hero-header">Welcome</h2>
                <h2 class="hero-header">Login to your account</h2>
                <form action="login" method="post">
                
                
                    <input type="text" name="email" placeholder="Email" required="required">
                    <input type="password" name="password" placeholder="Password" required="required">
                    <a href="#" class="forgot-password">Forgot Password?</a>
                    <button type="submit" class="login-btn">Login</button>
                </form>
                <p class="switch-auth">Don't have an account? <a href="signup.jsp">Sign Up</a></p>
            </div>
        </div>
    </section>
    <section class="sliding-banner">
        <div class="banner-content">
            <p>Special Offer: Get 50% off on your first order! Use code: Avej%50</p>
        </div>
    </section>
    
    <footer>
        <p>2024 Tap Foods. All rights reserved.</p>
    </footer>
    <script src="JavaScript/loginANDsignup.js">
        window.addEventListener('scroll', function() {
            const nav = document.querySelector('nav');
            if (window.scrollY > 50) {
                nav.classList.add('scrolled');
            } else {
                nav.classList.remove('scrolled');
            }
        });
    </script>
</body>
</html>