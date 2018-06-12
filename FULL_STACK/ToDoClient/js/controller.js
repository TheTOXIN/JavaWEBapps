var app = angular.module('ToDoApp', []);
var token;
var user;
var tasks = [];

app.controller('ToDoCtrl', function ($scope, $http) {

    $scope.loginUser = function () {
        showLoader();

        var request = processLogin();

        if (request === null) return;

        $http.post("https://to-do-server.herokuapp.com/login/", request)
            .then(function (response) {
                token = response.data.userId;
                if (token === null) {
                    showError();
                } else {
                    $scope.getUser(token);
                    $scope.toDoUser(token);

                    saveToken(token);
                    hideLogin();
                }
            });

        hideLoader();
    };

    $scope.toDoUser = function (token) {
        $http.post("https://to-do-server.herokuapp.com/todo/", {userId: token})
            .then(function (response) {
                var tasksId = response.data.tasksId;
                $scope.getTasks(tasksId);
            });
    };

    $scope.getUser = function (token) {
        $http.get("https://to-do-server.herokuapp.com/rest/users/" + token)
            .then(function (response) {
                user = response.data;
                showUser(response.data);
            });
    };

    $scope.getTasks = function (tasksId) {
        for (var i = 0; i < tasksId.length; i++) {
            $http.get("https://to-do-server.herokuapp.com/rest/tasks/" + tasksId[i])
                .then(function (response) {
                    tasks.push(response.data);
                    showTask(response.data);
                });
        }
    };

    $scope.addTask = function () {
        showLoader();
        var task = createTask();
        if (task === null) return;
        $http.post("https://to-do-server.herokuapp.com/rest/tasks/", task)
            .then(function (response) {
                tasks.push(response.data);
                showNotification("ADD", false);
            })
            .catch(function () {
                showNotification("ERROR", true);
            });
        hideLoader();
    };

    $scope.removeTask = function (task) {
        showLoader();
        $http.delete(task._links.self.href)
            .then(function () {
                showNotification("DELETE", false);
            })
            .catch(function () {
                showNotification("ERROR", true);
            });
        hideLoader();
    };

    $scope.updateTask = function (task) {
        showLoader();
        $http.patch(task._links.self.href, {
            title: task.title,
            finished: task.finished,
            description: task.description,
            date: task.date,
        }).then(function () {
            showNotification("UPDATE", false);
        })
        .catch(function () {
            showNotification("ERROR", true);
        });
        hideLoader();
    };
});