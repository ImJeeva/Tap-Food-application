<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign Up</title>
    <link rel="stylesheet" href="CSS/logsign.css">
</head>
<body>
    <header>
        <nav>

            <a href="index.jsp"></a>
            <ul>
                <li><a href="index.jsp">Home</a></li>
                <li><a href="#">Browse Restaurant</a></li>
                <li><a href="#">About Us</a></li>
                <li><a href="aboutme.html">Contact</a></li>
                <li><a href="login.jsp">Login</a></li>
            </ul>
        </nav>
    </header>

    <section class="auth-section">
        <div class="auth-container">
            <div class="auth-right">
                <h2 class="hero-header">Sign up</h2>
                <form action="signup">
                    <input type="text" placeholder="User Name" name="username">
                    <input type="password" placeholder="Password" name="password">
                    <input type="password" placeholder="Confirm Password" name="confirmPassword">
                    <input type="email" placeholder="Email" name="email">
                    <input type="text" placeholder="address" name="address">
                    <input type="text" placeholder="Role-Customer" name="role">
                    <div class="terms">
                        <input type="checkbox" id="terms">
                        <label for="terms">I Agree To The Terms and Conditions</label>
                    </div>
                    <button type="submit" class="signup-btn">Sign Up</button>
                </form>
                <p class="switch-auth">Already have an account? <a href="login.jsp">Login</a></p>
            </div>
        </div>
    </section>
    <section class="sliding-banner">
        <div class="banner-content">
            <p>Special Offer: Get 50% off on your first order! Use code: Avej%50</p>
        </div>
    </section>
    
    <footer>
        <p>2023 Tap Foods. All rights reserved.</p>
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