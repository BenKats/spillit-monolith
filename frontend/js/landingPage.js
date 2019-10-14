console.log('Landing Page JS connected');

let token = null;

document.querySelector('.signup-text').addEventListener('click', toggleEntry);
document.querySelector('.login-text').addEventListener('click', toggleEntry);

function toggleEntry(e) {
    console.log(e.target.className);
    //TODO make the toggle switch classes instead of changing display css rule
    let usernameField = document.getElementById('user-form');
    let emailField = document.getElementById('email-form');
    let mobileField = document.getElementById('mobile-form');
    let bttn = document.getElementById('submit-button');
    if (e.target.className === 'login-text') {
        emailField.style.display = 'none';
        mobileField.style.display = 'none';
        bttn.className = 'signin-bttn';
        bttn.innerText = 'Sign In';
    }
    if (e.target.className === 'signup-text') {
        emailField.style.display = 'block';
        mobileField.style.display = 'block';
        bttn.className = 'signup-bttn';
        bttn.innerText = 'Sign Up';
    }
}
function postData(e) {
    e.preventDefault();
    let bttn = document.getElementById('submit-button');
    if (bttn.className === 'signup-bttn') {
        newUser();
    } else if (bttn.className === 'signin-bttn') {
        returningUser();
    } else {
        console.error('What the heck did you click?');
    }
}
function newUser() {
    let username = document.getElementById('username');
    let password = document.getElementById('password');
    let email = document.getElementById('email');
    let mobile = document.getElementById('mobile');
    callSignup(username.value, password.value, email.value, mobile.value);
}

function callSignup(username, password, email, mobile) {
    fetch('http://localhost:8181/signup', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({
            username: username,
            password: password,
            userProfile: {
                email: email,
                mobile: mobile
            }
        })
    })
        .then(res => {
            console.log(res);
            return res.json();
        })
        .then(res => {
            console.log('Whats inside signup token?');
            token = res.token;
            console.log(token);
            redirectHome();
        })
        .catch(error => {
            console.error(error);
        });
}

function returningUser() {
    // e.preventDefault();
    let username = document.getElementById('username');
    let password = document.getElementById('password');
    console.log(username);
    console.log(password);
    callLogin(username.value, password.value);
}
function callLogin(username, password) {
    fetch('http://localhost:8181/login', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({
            username: username,
            password: password
        })
    })
        .then(res => {
            return res.json();
        })
        .then(res => {
            console.log(res.token);
            token = res.token;
            localStorage.setItem('user', token);
            redirectHome();
        })
        .catch(error => {
            console.error(error);
        });
}

function redirectHome() {
    console.log('From redirectHome token: \n' + 'token');
    if (token != null) {
        window.localStorage.setItem('token', token);
        window.location.href = './feed.html';
    }
}
