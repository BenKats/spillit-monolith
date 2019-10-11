console.log('Landing Page JS connected');

let token = null;

document.querySelector('.signup-text').addEventListener('click', toggleEntry);
document.querySelector('.login-text').addEventListener('click', toggleEntry);

function toggleEntry(e) {
    console.log(e.target.className);
    //TODO make the toggle switch classes instead of changing display css rule
    let usernameField = document.getElementById('user-form');
    let altEmailField = document.getElementById('altEmail-form');
    let mobileField = document.getElementById('mobile-form');
    let urlField = document.getElementById('url-form');
    let bttn = document.getElementById('submit-button');
    if (e.target.className === 'login-text') {
        usernameField.style.display = 'none';
        mobileField.style.display = 'none';
        urlField.style.display = 'none';
        altEmailField.style.display = 'none';
        bttn.className = 'signin-bttn';
        bttn.innerText = 'Sign In';
    }
    if (e.target.className === 'signup-text') {
        usernameField.style.display = 'block';
        mobileField.style.display = 'block';
        urlField.style.display = 'block';
        altEmailField.style.display = 'block';
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
    let altEmail = document.getElementById('alt-email');
    let mobile = document.getElementById('mobile');
    let url = document.getElementById('url');
    callSignup(
        username.value,
        password.value,
        email.value,
        altEmail.value,
        mobile.value,
        url.value
    );
}

function callSignup(username, password, email, altEmail, mobile, url) {
    fetch('http://thesi.generalassemb.ly:8080/signup', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({
            username: username,
            password: password,
            email: email
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
            callCreateProfile(altEmail, mobile, url);
        })
        .catch(error => {
            console.error(error);
        });
}

function callCreateProfile(altEmail, mobile, url) {
    console.log(`You're in call create profile, token is ${token}`);
    console.log('localstorage contains:' + window.localStorage.getItem(token));
    if (token == null) {
        console.error('Can not create profile, token is null');
    }
    fetch('http://thesi.generalassemb.ly:8080/profile', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            Authorization: 'Bearer ' + token
        },
        body: JSON.stringify({
            additionalEmail: altEmail,
            mobile: mobile,
            address: url
        })
    })
        .then(res => {
            console.log(res);
            return res.json();
        })
        .then(res => {
            console.log('Whats inside?');
            console.log(res);
            console.log('You in');
            redirectHome();
        })
        .catch(error => {
            console.error(error);
        });
    console.log(`TOKEN INSIDE CALL SIGNUP IS ${token}`);
}

function returningUser() {
    // e.preventDefault();
    let email = document.getElementById('email');
    let password = document.getElementById('password');
    console.log(email);
    console.log(password);
    callLogin(email.value, password.value);
}
function callLogin(email, password) {
    fetch('http://thesi.generalassemb.ly:8080/login', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({
            email: email,
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
