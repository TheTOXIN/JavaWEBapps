<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create</title>
</head>
<body>
    <form name="user" action="/update" method="post">
        <p>id: </p><input title="ID" type="text" name="id" value="${user.id}"> <br>
        <p>Name: </p><input title="NAME" type="text" name="name" value="${user.name}"> <br>
        <p>E-mail: </p><input title="E-MAIL" type="text" name="email" value="${user.email}"><br>
        <p>Age: </p> <input title="AGE" type="text" name="age" value="${user.age}"><br>
        <input type="submit" value="EDIT">
    </form>
</body>
</html>