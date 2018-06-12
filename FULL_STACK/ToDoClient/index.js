var inputTask = document.getElementById('new-task');
var unfinishedTasks = document.getElementById('unfinished-tasks');
var finishedTasks = document.getElementById('finished-tasks');
var loginWindow = document.getElementById("login");
var rootWindow = document.getElementById("root");
var descriptionWindow = document.getElementById("description");
var underWindow = document.getElementById("under");
var signHeader = document.getElementById("sign");
var loginInput = document.getElementById("log-input");
var passwordInput = document.getElementById("pas-input");
var registerInput = document.getElementById("reg-input");
var welcomeMsg = document.getElementById("welcome");
var boxWindow = document.getElementById("description");

function createNewElement(task, finish) {
    var checkbox = document.createElement('button');
    checkbox.className = "material-icons checkbox";

    if (finish) {
        checkbox.innerHTML = "<i class='material-icons'>check_box</i>";
    } else {
        checkbox.innerHTML = "<i class='material-icons'>check_box_outline_blank</i>";
    }

    var label = document.createElement('label');
    label.innerText = task;

    var input = document.createElement('input');
    input.type = "text";

    var descriptionButton = document.createElement('button');
    descriptionButton.className = "material-icons description";
    descriptionButton.innerHTML = "<i class='material-icons'>description</i>";

    var editButton = document.createElement('button');
    editButton.className = "material-icons edit";
    editButton.innerHTML = "<i class='material-icons'>edit</i>";

    var deleteButton = document.createElement('button');
    deleteButton.className = "material-icons delete";
    deleteButton.innerHTML = "<i class='material-icons'>delete</i>";

    var listItem = document.createElement('li');
    listItem.appendChild(checkbox);
    listItem.appendChild(label);
    listItem.appendChild(input);
    listItem.appendChild(deleteButton);
    listItem.appendChild(editButton);
    listItem.appendChild(descriptionButton);

    return listItem;
}

function createTask() {
    if (inputTask.value) {
        var task = {
            title: inputTask.value,
            finished: false,
            description: "",
            date: new Date().toISOString().substring(0, 10),
            user: "https://to-do-server.herokuapp.com/rest/users/" + token
        };

        load(task);
        inputTask.value = "";

        return task;
    }

    return null;
}

function deleteTask() {
    var li = this.parentNode;
    var title = li.querySelector('label').innerText;
    var ul = li.parentNode;

    ul.removeChild(li);

    for (var i = 0; i < tasks.length; i++) {
        if (tasks[i].title === title) {
            angular.element(document.getElementById('ToDo')).scope().removeTask(tasks[i]);
        }
    }
}

function editTask() {
    var editButton = this;
    var listItem = editButton.parentNode;
    var label = listItem.querySelector('label');
    var input = listItem.querySelector('input');
    var containsClass = listItem.classList.contains('editMode');
    var title = label.innerText;

    if (containsClass) {
        label.innerText = input.value;
        editButton.className = "material-icons edit";
        editButton.innerHTML = "<i class='material-icons'>edit</i>";

        for (var i = 0; i < tasks.length; i++) {
            if (tasks[i].title === title) {
                tasks[i].title = input.value;
                angular.element(document.getElementById('ToDo')).scope().updateTask(tasks[i]);
            }
        }
    } else {
        input.value = label.innerText;
        editButton.className = "material-icons save";
        editButton.innerHTML = "<i class='material-icons'>save</i>";
    }

    listItem.classList.toggle('editMode');
}

function showDescription() {
    rootWindow.style.filter = "blur(3px)";
    descriptionWindow.style.display = "block";

    var descriptionButton = this;
    var listItem = descriptionButton.parentNode;
    var label = listItem.querySelector('label');
    var title = label.innerText;
    var h2 = boxWindow.querySelector('h2');
    var h4 = boxWindow.querySelector('h4');
    var textarea = boxWindow.querySelector('textarea');

    for (var i = 0; i < tasks.length; i++) {
        if (tasks[i].title === title) {
            var task = tasks[i];
            h2.innerText = task.title;
            h4.innerText = task.date;
            textarea.value = task.description;
        }
    }
}

function hideDescription() {
    rootWindow.style.filter = "blur(0px)";
    descriptionWindow.style.display = "none";

    var h2 = boxWindow.querySelector('h2');
    var title = h2.innerText;
    var textarea = boxWindow.querySelector('textarea');

    for (var i = 0; i < tasks.length; i++) {
        if (tasks[i].title === title) {
            tasks[i].description = textarea.value;
            angular.element(document.getElementById('ToDo')).scope().updateTask(tasks[i]);
        }
    }
}

function finishedTask() {
    var checkbox = this;
    var li = checkbox.parentNode;
    var containsClass = li.classList.contains('editMode');

    if (!containsClass) {
        checkbox.className = "material-icons checkbox";
        checkbox.innerHTML = "<i class='material-icons'>check_box</i>"

        finishedTasks.appendChild(li);
        bindTaskEvents(li, unfinishedTask);

        var title = li.querySelector('label').innerText;
        for (var i = 0; i < tasks.length; i++) {
            if (tasks[i].title === title) {
                tasks[i].finished = true;
                angular.element(document.getElementById('ToDo')).scope().updateTask(tasks[i]);
            }
        }
    } else {
        alert("СОХРАНИТЕ TODO");
    }
}

function unfinishedTask() {
    var checkbox = this;
    var li = checkbox.parentNode;
    var containsClass = li.classList.contains('editMode');

    if (!containsClass) {
        checkbox.className = "material-icons checkbox";
        checkbox.innerHTML = "<i class='material-icons'>check_box_outline_blank</i>";

        unfinishedTasks.appendChild(li);
        bindTaskEvents(li, finishedTask);

        var title = li.querySelector('label').innerText;
        for (var i = 0; i < tasks.length; i++) {
            if (tasks[i].title === title) {
                tasks[i].finished = false;
                angular.element(document.getElementById('ToDo')).scope().updateTask(tasks[i]);
            }
        }
    } else {
        alert("СОХРАНИТЕ TODO");
    }
}

function bindTaskEvents(listItem, checkboxEvent) {
    var checkbox = listItem.querySelector('button.checkbox');
    var editButton = listItem.querySelector('button.edit');
    var deleteButton = listItem.querySelector('button.delete');
    var descriptionButton = listItem.querySelector('button.description');

    checkbox.onclick = checkboxEvent;
    editButton.onclick = editTask;
    deleteButton.onclick = deleteTask;
    descriptionButton.onclick = showDescription;
}

function load(task) {
    var listItem = createNewElement(task.title, task.finished);

    if (task.finished) {
        finishedTasks.appendChild(listItem);
        bindTaskEvents(listItem, unfinishedTask)
    } else {
        unfinishedTasks.appendChild(listItem);
        bindTaskEvents(listItem, finishedTask)
    }
}

function processLogin() {
    if (loginInput.value.length === 0 || passwordInput.value.length === 0)
        return null;

    return {
        login: loginInput.value,
        password: passwordInput.value,
        reg: registerInput.checked
    };
}

function showLogin() {
    loginWindow.style.display = "block";
    rootWindow.style.display = "none";
    underWindow.style.display = "none";
}

function hideLogin() {
    loginWindow.style.display = "none";
    rootWindow.style.display = "block";
    underWindow.style.display = "block";
}

function showError() {
    $("#message").show('slow');
    setTimeout(function () {
        $("#message").hide('slow');
    }, 3000);
}

function changeHeader() {
    if (registerInput.checked) {
        signHeader.innerText = "SIGN IN";
    } else {
        signHeader.innerText = "SIGN UP";
    }
}

function showUser(user) {
    welcomeMsg.innerText = "Welcome " + user.login;
}

function showTask(task) {
    load(task);
}

function main() {
    var data = JSON.parse(localStorage.getItem('todo'));

    if (data === null) {
        showLogin();
    } else {
        hideLogin();
    }
}

main();