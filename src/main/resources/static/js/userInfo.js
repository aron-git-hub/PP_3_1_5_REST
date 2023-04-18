document.addEventListener('DOMContentLoaded', userPageLoader)

async function getData() {
    const URL = 'api/user';
    let response = await fetch(URL);
    return response.json();
}

async function createPage(user, table) {
    const roles = [];
    for (let role of user.roles) {
        roles.push(' ' + role.name.toString().substring(5));
    }

    let tr = document.createElement('tr');
    tr.innerHTML = `
                    <td>${user.id}</td>
                    <td>${user.username}</td>
                    <td>${user.firstName}</td>
                    <td>${user.secondName}</td>
                    <td>${user.age}</td>
                    <td>${roles}</td>`;
                    table.appendChild(tr);
}

async function userPageLoader(event) {
    event.preventDefault();
    const TABLE = document.getElementById('user-info');
    let user = await getData();
    await createPage(user, TABLE);
}