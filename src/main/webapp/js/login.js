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

    const userData = {
        salt: salt,
        hashedPassword: hashedPassword,
        userId: userId
    };

    const userDataJson = JSON.stringify(userData);

    // Send the salt and hashedPassword to the backend via API call.
    fetch('http://localhost:8080/wwp/webapi/service/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json', // Indicate JSON data
        },
        body: userDataJson, // Send the JSON string in the request body
    })
        .then((response) => {
        if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        }
        return response.json(); // Or response.text() if the backend sends plain text
    })
        .then((data) => {
        // Handle the response data from the backend (JSON object)
        console.log('Response from server:', data);
        // ... process data ...
    })
        .catch((error) => {
        // Handle errors
        console.error('Fetch error:', error);
    });

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