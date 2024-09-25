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
