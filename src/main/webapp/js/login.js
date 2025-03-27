// Install bcryptjs: npm install bcryptjs

const bcrypt = require('bcryptjs');

function hashPassword(password) {
    const salt = await bcrypt.genSalt(10); // Generate a salt
    const hashedPassword = await bcrypt.hash(password, salt); // Hash with salt
    return { salt, hashedPassword };
}

function verifyPassword(password, hashedPassword) {
    return await bcrypt.compare(password, hashedPassword);
}

function login(userId, plainTextPassword) {

    // Hash the password on the client-side.
    const { salt, hashedPassword } = hashPassword(plainTextPassword);

    console.log('Salt:', salt);
    console.log('Hashed Password:', hashedPassword);

    try {
        const response = await fetch('http://localhost:8080/wwp/webapi/service/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ userId, password }), // Send identifier and password
        });

        if (!response.ok) {
            const errorData = await response.json();
            alert(`Login failed: ${errorData.message || 'Unknown error'}`);
            return;
        }

        const data = await response.json();
        alert(data.message || 'Login successful');

        window.location.href = 'index.html';

    } catch (error) {
        console.error('Login error:', error);
        alert('An error occurred during login.');
    }

    //const inputPassword = 'mySecretPassword';
    //const passwordMatch = await verifyPassword(inputPassword, hashedPassword);

    //if (passwordMatch) {
        //console.log('Password matches!');
    //} else {
        //console.log('Password does not match.');
    //}

    //const incorrectPassword = "wrongPassword";
    //const incorrectPasswordMatch = await verifyPassword(incorrectPassword, hashedPassword);

    //if (incorrectPasswordMatch) {
       // console.log("Password matches! (This should not happen)");
    //} else {
        //console.log("Password does not match. (Correct)");
    //}
}