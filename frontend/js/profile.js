console.log('Profile Page JS connected');

let token = window.localStorage.getItem('token');
console.log(token);

updateDisplayText();
function updateProfile(e) {
    e.preventDefault();

    // const altEmail = document.getElementById('alt-email');
    const email = document.getElementById('email');
    const mobile = document.getElementById('mobile');
    // const url = document.getElementById('url');
    const bttn = document.getElementById('edit-button');

    const allInputs = document.querySelectorAll('.input-form');
    const allDisplayedText = document.querySelectorAll('.displayed-text');

    updateDisplayText();

    //same number of input-form and displayed-text classes, loop through them all and based on the button they will appear or hide
    if (bttn.textContent === 'Edit') {
        for (let i = 0; i < allInputs.length; i++) {
            allInputs[i].style.display = 'inline';
            allDisplayedText[i].style.display = 'none';
        }

        bttn.textContent = 'Save';
    } else if (bttn.textContent === 'Save') {
        for (let i = 0; i < allInputs.length; i++) {
            allInputs[i].style.display = 'none';
            allDisplayedText[i].style.display = 'inline';
        }
        callCreateProfile(email, mobile);
        bttn.textContent = 'Edit';
    }
    updateDisplayText();
}

function updateDisplayText() {
    const username = document.getElementById('username');
    // const altEmail = document.getElementById('alt-email');
    const email = document.getElementById('email');
    const mobile = document.getElementById('mobile');
    // const url = document.getElementById('url');
    const usernameDisplayed = document.getElementById('username-displayed');
    const emailDisplayed = document.getElementById('email-displayed');
    const mobileDisplayed = document.getElementById('mobile-displayed');
    const urlDisplayed = document.getElementById('url-displayed');

    callGetProfile(
        username,
        // altEmail,
        email,
        mobile,
        // url,
        usernameDisplayed,
        // altEmailDisplayed,
        emailDisplayed,
        mobileDisplayed
        // urlDisplayed
    );
}

function callGetProfile(
    username,
    // altEmail,
    email,
    mobile,
    // url,
    usernameDisplayed,
    emailDisplayed,
    mobileDisplayed
    // urlDisplayed
) {
    fetch('http://localhost:8181/profile', {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json',
            Authorization: 'Bearer ' + token
        }
    })
        .then(res => {
            console.log(res);
            return res;
        })
        .then(res => {
            // console.log(res.json());
            return res.json();
        })
        .then(res => {
            console.log(res);
            username.value = res.user.username;
            // altEmail.value = res.additionalEmail;
            email.value = res.email;
            mobile.value = res.mobile;
            // url.value = res.address;
            usernameDisplayed.innerText = res.user.username;
            // altEmailDisplayed.innerText = res.additionalEmail;
            emailDisplayed.innerText = res.email;
            mobileDisplayed.innerText = res.mobile;
            // urlDisplayed.innerText = res.address;
            document.querySelector(
                'img'
            ).src = `https://api.adorable.io/avatars/285/${username.value}.png`;
        })
        .catch(error => {
            console.error(error);
        });
}

function callCreateProfile(email, mobile) {
    console.log(`You're in call create profile, token is ${token}`);
    console.log('localstorage contains:' + window.localStorage.getItem(token));
    if (token == null) {
        console.error('Can not create profile, token is null');
    }
    fetch('http://localhost:8181/update', {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
            Authorization: 'Bearer ' + token
        },
        body: JSON.stringify({
            email: email.value,
            mobile: mobile.value
        })
    })
        .then(res => {
            console.log(res);
            return res.json();
        })
        .then(res => {
            console.log('Entered create Profile');
            console.log(res);
            console.log('You in');
        })
        .catch(error => {
            console.error(error);
        });
    console.log(`TOKEN INSIDE CALL SIGNUP IS ${token}`);
}
