/**
 * 
 */function startAnimation() {
    const truck = document.querySelector('.truck');
    const message = document.getElementById('order-message');

    // Start moving the truck with animation
    truck.style.animation = "moveTruck 5s forwards";
    
    // Show the "Order Confirmed" message after the truck moves off-screen
    setTimeout(() => {
        message.classList.remove('hidden');
    }, 4000); // Timing to ensure it appears after the truck moves out
}
