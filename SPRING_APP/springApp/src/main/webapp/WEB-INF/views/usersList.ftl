<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Users</title>
    <style>
        th {
            color: white;
            background: black;
        }
        td {
            color: black;
            background: darkgray;
        }
    </style>
</head>
<body>
<h1>List of users:</h1>
<table>
    <tr>
        <th>id</th>
        <th>Name</th>
        <th>E-mail</th>
        <th>AGE</th>
    </tr>
    <#list users as user>
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.email}</td>
            <td>${user.age}</td>
        </tr>
    </#list>
</table>
</body>
</html>