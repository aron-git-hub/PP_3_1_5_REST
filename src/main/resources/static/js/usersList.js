document.addEventListener('DOMContentLoaded', createTable);

async function createTable() {
    const TABLE = document.getElementById('users');
    const URL = '/api/users';
    let response = await fetch(URL);
    let users = await response.json();
    let userData = '';
    for (let user of users) {
        const ROLES = [];
        for (let role of user.roles) {
            ROLES.push(role.name.toString().substring(5));
        }
        userData += `<tr>
                        <td>${user.id}</td>
                        <td>${user.username}</td>
                        <td>${user.firstName}</td>
                        <td>${user.secondName}</td>
                        <td>${user.age}</td>
                        <td>${ROLES}</td>
                        <td>
                            <a type="button" class="btn btn-primary btn-sm" data-bs-toggle="modal"
                            data-bs-target="#modalFrame" onclick="editUser(${user.id})">Edit</a>
                        </td>
                        <td><a type="button" class="btn btn-danger btn-sm" data-bs-toggle="modal"
                            data-bs-target="#modalFrame" onclick="deleteUser(${user.id})">Delete</a>
                        </td>
                    </tr>`
    }
    TABLE.innerHTML = userData;
}