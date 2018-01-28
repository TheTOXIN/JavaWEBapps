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
            <td><a href="/user/${user.id}">${user.id}</a></td>
            <td>${user.name}</td>
            <td>${user.email}</td>
            <td>${user.age}</td>
            <td><a style="color: red" href="/delete/${user.id}">DELETE</a></td>
            <td><a style="color: green" href="/update/${user.id}">UPDATE</a></td>
        </tr>
    </#list>
</table>
<a href="/add">ADD</a>
</body>
</html>