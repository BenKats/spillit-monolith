console.log('Profile Page JS connected');

let token = window.localStorage.getItem('token');
let test = null;

console.log(token);

createNewPostField();
callListPosts();

// console.log(postArr);
function callListPosts() {
    fetch('http://localhost:8181/post/list-all', {
        method: 'GET'
    }) //Force break
        .then(res => {
            // console.log(res);
            return res;
        })
        .then(res => {
            return res.json();
        })
        .then(res => {
            displayPosts(res);
            return res;
        })
        .then(res => {
            displayComments(res);
            return res;
        })

        .catch(error => {
            console.error(error);
        });
}

function displayPosts(postArr) {
    let feedContainer = document.querySelector('.feed-container');
    for (let i = 0; i < postArr.length; i++) {
        // console.log(postArr[i]);
        let newPost = document.createElement('div');
        let newTitleContainer = document.createElement('div');
        let newCommentContainer = document.createElement('div');
        let newTitle = document.createElement('h5');
        let newDesc = document.createElement('h5');
        let newUser = document.createElement('h6');
        let newDeleteBttn = document.createElement('button');
        let newToggleComments = document.createElement('a');
        newToggleComments.classList.add('toggleComments');
        let pid = postArr[i].id;

        feedContainer.appendChild(newPost);
        newPost.append(newTitleContainer, newCommentContainer);
        newTitleContainer.append(newTitle, newDesc, newUser, newToggleComments, newDeleteBttn);

        //set classes, attributes
        //set the pid of the div to the post id
        newPost.setAttribute('pid', pid);

        newToggleComments.addEventListener('click', toggleComments);
        newTitleContainer.classList.add('title-container');
        newTitleContainer.id = pid;
        newCommentContainer.classList.add('all-comment-container');
        newCommentContainer.setAttribute('ccid', pid);

        //set text content
        newTitle.innerText = postArr[i].title;
        newDesc.innerText = postArr[i].description;
        newUser.innerText = `Username: ${postArr[i].user.username}`;
        newDeleteBttn.innerText = 'Delete';
        newDeleteBttn.value = pid;
        newDeleteBttn.addEventListener('click', deletePost);
        newToggleComments.innerText = 'Toggle Comments';
        console.log(
            `post id iz ${pid} new title inner text is ${postArr[i].title} newDesc.innerText ${newDesc.innerText} `
        );
        callGetCommentsByPostId(pid);
    }
    createNewCommentField();
}
function displayComments(postArr) {
    for (let i = 0; i < postArr.length; i++) {
        console.log('Inside display Comments this is pid' + postArr[i].id);
        let pid = postArr[i].id;

        if (sessionStorage.getItem(pid) != null) {
            //retrieve cached comments relative to the pid and convert back to JSON
            let postComments = JSON.parse(window.sessionStorage.getItem(pid.toString()));

            // console.log('contents of postComments');
            // console.log(postComments);

            let targetCommentContainer = document.querySelector(`[ccid="${pid}"]`);
            console.log(postComments[0].text);

            for (let j = 0; j < postComments.length; j++) {
                //Create new elements
                let newCommentContainer = document.createElement('div');
                let newComment = document.createElement('p');
                let newUser = document.createElement('p');
                let newDeleteBttn = document.createElement('button');
                //Append
                targetCommentContainer.appendChild(newCommentContainer);
                newCommentContainer.append(newUser, newComment, newDeleteBttn);
                //Assign Attributes
                newCommentContainer.setAttribute('cid', postComments[j].id);
                newCommentContainer.classList.add('comment-container');
                //Assign Text
                newComment.innerText = postComments[j].description;
                newUser.innerText = `Username: ${postComments[j].user.username}`;
                newDeleteBttn.innerText = 'Delete';

                newDeleteBttn.addEventListener('click', deleteComment);
                newDeleteBttn.value = postComments[j].id;
            }
        }
    }
}
function callGetCommentsByPostId(pid) {
    fetch(`http://localhost:8181/comment/list/bypost/${pid}`, {
        method: 'GET'
    })
        .then(res => {
            console.log(res.status);
            return res.json();
        })
        .then(res => {
            getCommentArr(res, pid);
        })
        .catch(error => {
            console.error(error);
        });
}

function getCommentArr(commentArr, pid) {
    console.log(`post ${pid} is`);
    console.log(commentArr);
    //doesn't cache comments if no comments exist, otherwise convert JSON object to string and store in session storage
    if (commentArr.length > 0) {
        window.sessionStorage.setItem(`${pid}`, JSON.stringify(commentArr));
    }
}

function deleteComment(e) {
    e.preventDefault();
    callDeleteComment(e.target.value);
    console.log(e.target.value);
}
function deletePost(e) {
    e.preventDefault();
    callDeletePost(e.target.value);
    console.log(e.target.value);
}

function callDeleteComment(cid) {
    fetch(`http://localhost:8181/comment/delete/${cid}`, {
        method: 'DELETE',
        headers: {
            Authorization: 'Bearer ' + token
        }
    })
        .then(res => {
            console.log(res);

            return res;
        })
        .then(res => {
            console.log(res);
            console.log(res.status);
            if (res.status === 401) {
                alert('You can only delete your own comments');
            } else if (res.status === 200) {
                alert(
                    'You deleted the comment succesfully, refresh the page 2-3 times for update to take effect'
                );
            }

            // console.log(res.json());
            return res.json();
        })
        .then(res => {
            console.log(res);
            return res;
        })
        .catch(error => {
            console.error(error);
        });
}
function callDeletePost(pid) {
    fetch(`http://localhost:8181/post/delete/${pid}`, {
        method: 'DELETE',
        headers: {
            Authorization: 'Bearer ' + token
        }
    })
        .then(res => {
            console.log(res);

            return res;
        })
        .then(res => {
            console.log(res);
            console.log(res.status);
            if (res.status === 401) {
                alert('You can only delete your own Posts');
            } else if (res.status === 200) {
                alert(
                    'You deleted the post succesfully, refresh the page for update to take effect'
                );
            }

            // console.log(res.json());
            return res.json();
        })
        .then(res => {
            console.log(res);
            return res;
        })
        .catch(error => {
            console.error(error);
        });
}

function createNewPostField() {
    let feedContainer = document.querySelector('.feed-container');
    let formContainer = document.createElement('form');
    let newPostTitle = document.createElement('h4');
    let titleInput = document.createElement('input');
    let descInput = document.createElement('input');
    let submitBttn = document.createElement('button');
    feedContainer.appendChild(formContainer);
    formContainer.append(newPostTitle, titleInput, descInput, submitBttn);

    titleInput.classList.add('post-title-form');
    descInput.classList.add('post-desc-form');
    submitBttn.classList.add('newPostSubmit');

    newPostTitle.innerText = 'Create New Post';
    titleInput.placeholder = 'Post Title';
    descInput.placeholder = 'Description';
    submitBttn.innerText = 'Submit';
    submitBttn.addEventListener('click', callCreatePost);
}
function createNewCommentField() {
    // console.log(titleContainer.length);
    let titleContainer = document.querySelectorAll('.title-container');
    for (let i = 0; i < titleContainer.length; i++) {
        let formContainer = document.createElement('form');
        let newComment = document.createElement('h6');
        let descInput = document.createElement('input');
        let commentBttn = document.createElement('button');
        titleContainer[i].appendChild(formContainer);
        formContainer.append(newComment, descInput, commentBttn);
        descInput.classList.add('comment-desc-form');
        newComment.innerText = 'Create New Comment';
        descInput.placeholder = 'Description';
        commentBttn.innerText = 'comment';
        commentBttn.value = i;
        descInput.setAttribute('fid', titleContainer[commentBttn.value].id);
        commentBttn.addEventListener('click', callCreateComment);
        console.log(titleContainer[commentBttn.value].id);
    }
}

function callCreatePost(e) {
    e.preventDefault();
    console.log(`${document.querySelector('.post-title-form').value}`);
    let title = document.querySelector('.post-title-form');
    let desc = document.querySelector('.post-desc-form');
    fetch('http://localhost:8181/post', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            Authorization: 'Bearer ' + token
        },
        body: JSON.stringify({
            title: title.value,
            description: desc.value
        })
    })
        .then(res => {
            if (res.status === 200) {
                alert('New Post Created');
            }
            return res;
        })
        .catch(error => {
            console.error(error);
        });
    title.value = null;
    desc.value = null;
}
function callCreateComment(e) {
    e.preventDefault();
    let titleContainer = document.querySelectorAll('.title-container');
    let postNum = titleContainer[e.target.value].id;
    // console.log(`${document.querySelector('.post-title-form').value}`);
    console.log(postNum);
    let text = document.querySelector(`[fid="${postNum}"]`);
    console.log('trying to pass ' + text.value);
    // let text = desc[num];
    fetch(`http://localhost:8181/comment/${postNum}`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            Authorization: 'Bearer ' + token
        },
        body: JSON.stringify({
            description: text.value
        })
    })
        .then(res => {
            console.log(res);
            if (res.status === 200) {
                alert('Comment Created');
            }
            return res;
        })
        .catch(error => {
            console.error(error);
        });

    text.value = null;
}
function refresh() {
    location.reload();
}

function toggleComments(event) {
    let comments = event.target.parentElement.nextSibling;
    if (comments.style.display == 'block') {
        comments.style.display = 'none';
    } else {
        comments.style.display = 'block';
    }
}
