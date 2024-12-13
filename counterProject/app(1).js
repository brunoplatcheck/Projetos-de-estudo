// Set initial count
let count = 0;

// Select value and buttons
const value = document.querySelector('#value');
const btns = document.querySelectorAll('.btn'); // Corrigido querySelectorAll e .btn

// Log buttons to check if they are selected correctly
console.log(btns);

// Add event listener to each button
btns.forEach(function (btn) {
    btn.addEventListener('click', function (e) {
        const styles = e.currentTarget.classList;
        
        // Check which button was clicked
        if (styles.contains('decrease')) {
            count--;
        } else if (styles.contains('increase')) {
            count++;
        } else {
            count = 0;
        }

        // Change color based on count value
        if (count > 0) {
            value.style.color = 'green';
        } else if (count < 0) {
            value.style.color = 'red';
        } else {
            value.style.color = '#222';
        }

        // Update the displayed count
        value.textContent = count;
    });
});
