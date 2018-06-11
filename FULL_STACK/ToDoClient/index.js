var addButton = document.getElementById('add');
var inputTask = document.getElementById('new-task');
var unfinishedTasks = document.getElementById('unfinished-tasks');
var finishedTasks = document.getElementById('finished-tasks');
var loginWindow = document.getElementById("login");
var rootWindow = document.getElementById("root");
var descriptionWindow = document.getElementById("description");

function createNewElement(task, finish) {
	var checkbox=document.createElement('button');
	checkbox.className="material-icons checkbox";

	if (finish) {
		checkbox.innerHTML="<i class='material-icons'>check_box</i>";
	} else {
		checkbox.innerHTML="<i class='material-icons'>check_box_outline_blank</i>";
	}

	var label=document.createElement('label');
	label.innerText=task;

	var input=document.createElement('input');
	input.type="text";

    var descriptionButton=document.createElement('button');
    descriptionButton.className="material-icons description";
    descriptionButton.innerHTML="<i class='material-icons'>description</i>";

	var editButton=document.createElement('button');
	editButton.className="material-icons edit";
	editButton.innerHTML="<i class='material-icons'>edit</i>";

	var deleteButton=document.createElement('button');
	deleteButton.className="material-icons delete";
	deleteButton.innerHTML="<i class='material-icons'>delete</i>";

	var listItem=document.createElement('li');
	listItem.appendChild(checkbox);
	listItem.appendChild(label);
	listItem.appendChild(input);
    listItem.appendChild(deleteButton);
    listItem.appendChild(editButton);
    listItem.appendChild(descriptionButton);

    return listItem;
}

function addTask() {
	if (inputTask.value) {
		var listItem = createNewElement(inputTask.value, false);
		unfinishedTasks.appendChild(listItem);
		bindTaskEvents(listItem, finishTask);
		inputTask.value = "";
	}
	//save();
}

function deleteTask() {
	 var listItem = this.parentNode;
	 var ul = listItem.parentNode;
	 ul.removeChild(listItem);
	 //save();
}

function editTask() {
	var editButton = this;
	var listItem = editButton.parentNode;
	var label = listItem.querySelector('label');
	var input = listItem.querySelector('input');
	var containsClass = listItem.classList.contains('editMode');	

	if (containsClass) {
		label.innerText = input.value;
		editButton.className = "material-icons edit";
		editButton.innerHTML = "<i class='material-icons'>edit</i>";
	} else {
		input.value = label.innerText;
		editButton.className = "material-icons save";
		editButton.innerHTML = "<i class='material-icons'>save</i>";
	}

	listItem.classList.toggle('editMode');
	//save();
}

function showDescription() {
	rootWindow.style.filter = "blur(3px)";
	descriptionWindow.style.display = "block";
}

function hideDescription() {
    rootWindow.style.filter = "blur(0px)";
    descriptionWindow.style.display = "none";
}

function finishTask() {
	var checkbox = this;
	var listItem = checkbox.parentNode;
	var containsClass = listItem.classList.contains('editMode');	

	if (!containsClass) {
		checkbox.className="material-icons checkbox";
		checkbox.innerHTML="<i class='material-icons'>check_box</i>"

		finishedTasks.appendChild(listItem);
		bindTaskEvents(listItem, unfinishTask);
	} else {
		alert("СОХРАНИТЕ TODO");
	}
	//save();
}

function unfinishTask() {
	var checkbox = this;
	var listItem = checkbox.parentNode;
	var containsClass = listItem.classList.contains('editMode');	

	if (!containsClass) {
		checkbox.className = "material-icons checkbox";
		checkbox.innerHTML = "<i class='material-icons'>check_box_outline_blank</i>";

		unfinishedTasks.appendChild(listItem);
		bindTaskEvents(listItem, finishTask);
	} else {
		alert("СОХРАНИТЕ TODO");
	}
	//save();
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

function save() {
	var unfinishedTasksArr = [];
	for (var i = 0; i < unfinishedTasks.children.length; i++) {
		unfinishedTasksArr.push(unfinishedTasks.children[i].getElementsByTagName('label')[0].innerText);
	}

	var finishedTasksArr = [];
	for (var i = 0; i < finishedTasks.children.length; i++) {
		finishedTasksArr.push(finishedTasks.children[i].getElementsByTagName('label')[0].innerText);
	}

	localStorage.removeItem('todo');
	localStorage.setItem('todo', JSON.stringify({
		unfinishedTasks: unfinishedTasksArr,
		finishedTasks: finishedTasksArr
	}));
}

function load() {
    for (var i = 0; i < data.unfinishedTasks.length; i++) {
        var listItem = createNewElement(data.unfinishedTasks[i], false);
        unfinishedTasks.appendChild(listItem);
        bindTaskEvents(listItem, finishTask);
    }

    for (var i = 0; i < data.finishedTasks.length; i++) {
        var listItem = createNewElement(data.finishedTasks[i], true);
        finishedTasks.appendChild(listItem);
        bindTaskEvents(listItem, unfinishTask);
    }
}

function login() {
	hideLogin();
}

function showLogin() {
	loginWindow.style.display="block";
	rootWindow.style.display="none";
}

function hideLogin() {
    loginWindow.style.display="none";
    rootWindow.style.display="block";
}

var sign = true;
function changeHeader() {
	sign = !sign;
	if (sign) {
		signHeader.innerText = "SIGN IN";
	} else {
        signHeader.innerText = "SIGN UP";
	}
}

function main() {
	var data = JSON.parse(localStorage.getItem('todo'));

	if (data == null) {
		showLogin();
    } else {
		hideLogin();
	}
}

main();
addButton.onclick = addTask;