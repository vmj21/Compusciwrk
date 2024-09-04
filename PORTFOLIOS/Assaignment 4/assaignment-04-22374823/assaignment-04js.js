function createUser() {
    var title = document.getElementById('title').value;
    var firstname = document.getElementById('firstname').value;
    // Retrieve other input field values

    var xhr = new XMLHttpRequest();
    xhr.open('POST', 'users.php', true);
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.onreadystatechange = function() {
        if(xhr.readyState == 4 && xhr.status == 200) {
            var response = JSON.parse(xhr.responseText);
            alert(response.message);
        }
    };
    xhr.send('submit=1&title=' + title + '&firstname=' + firstname /* + other fields */);
}

function searchUsers() {
    var searchName = document.getElementById('searchName').value;

    var xhr = new XMLHttpRequest();
    xhr.open('POST', 'retrieve.php', true);
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.onreadystatechange = function() {
        if(xhr.readyState == 4 && xhr.status == 200) {
            var users = JSON.parse(xhr.responseText);
            var userListDiv = document.getElementById('userList');
            userListDiv.innerHTML = '';

            if(users.length > 0) {
                for(var i = 0; i < users.length; i++) {
                    var user = users[i];
                    userListDiv.innerHTML += 'FirstName: ' + user.firstname + 'Surname:' + user.surname +
                     'Mobile:' + user.mobile + 'Email:' + user.email + 
                     'AddressLine1:' + user.AddressLine1 + 'AddressLine2:' + user.AddressLine2 + 
                     'Town:' + user.Town + 'County:' + user.County + 'Eircode:' + user.Eircode;
                    // Display other user info
                }
            } else {
                userListDiv.innerHTML = 'No users found';
            }
        }
    };
    xhr.send('search=1&searchName=' + searchName);
}
