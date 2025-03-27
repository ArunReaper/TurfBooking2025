
//async function hashPassword(password) {
//    const salt = bcrypt.genSaltSync(10);
//    const hashedPassword = bcrypt.hashSync(password, salt);
//    return hashedPassword;
//}

async function login(identifier, password) {
    //const hashedPassword = await hashPassword(password);

    try {
        const response = await fetch('http://localhost:8080/wwp/webapi/service/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ identifier, password }),
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