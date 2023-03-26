// Call the dataTables jQuery plugin
$(document).ready(function() {
  loadUsers();
  $('#usersDataTable').DataTable();
});

async function loadUsers() {
  const request = await fetch("usuarios", {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
  });
  const users = await request.json();
  console.log(users);
  let listUsersHtml = "";
  for(let user of users) {
    let userHTML = "<tr>\n" +
        "                                            <td>"+ user.id +"</td>\n" +
        "                                            <td>"+ user.name +"</td>\n" +
        "                                            <td>"+ user.lastname +"</td>\n" +
        "                                            <td>"+ user.email +"@gmail.com</td>\n" +
        "                                            <td>"+ user.telphone +"</td>\n" +
        "                                            <td>\n" +
        "                                                <a href=\"#\" class=\"btn btn-danger btn-circle btn-sm\">\n" +
        "                                                    <i class=\"fas fa-trash\"></i>\n" +
        "                                                </a>\n" +
        "                                            </td>\n" +
        "                                        </tr>";
    listUsersHtml += userHTML;
  }

  document.querySelector('#usuarios tbody').outerHTML = user;
}
