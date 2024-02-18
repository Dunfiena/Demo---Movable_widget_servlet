<%@ page import="com.example.web_assign_1.Model.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.web_assign_1.Model.Task" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page language="java" session="true" %>
<%  User user = (User)request.getAttribute("user");
    ArrayList<Task> tasks = new ArrayList<>();
    tasks = (ArrayList<Task>)request.getAttribute("tasks");%>

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="App_CSS.css">
    <link rel="stylesheet" href="popup_signin%20CSS.css">
    <link rel="stylesheet" href="taskWidgetCSS.css">

    <link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">

    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
    <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>

    <title>Tsk*AP</title>
</head>
<style>
    .draggable { width: 300px; height: 150px; padding: 5px; float: left; font-size: .9em; }
    .ui-widget-header p, .ui-widget-content p { margin: 0; }
</style>
<script>
    $( function() {
        $( ".draggable" ).draggable({ grid: [ 1, 1 ] });
    } );

    function toggleEditTask() {
        let x = document.getElementById("editTask");
        if (x.style.display === "none") {
            x.style.display = "block";
        } else {
            x.style.display = "none";
        }
    }

    function toggleAddForm() {
        let x = document.getElementById("addTask");
        if (x.style.display === "none") {
            x.style.display = "block";
        } else {
            x.style.display = "none";
        }
    }

    function toggleDeleteForm() {
        let x = document.getElementById("deleteTask");
        if (x.style.display === "none") {
            x.style.display = "block";
        } else {
            x.style.display = "none";
        }
    }
    function removeTask(id){
        let x = document.getElementById("deleteTask");
        document.getElementById("delTaskId").innerHTML=id
        if (x.style.display === "none") {
            x.style.display = "block";
        } else {
            x.style.display = "none";
        }
    }
    function minimize(id, id2, id3, id4, text){
        const x = document.getElementById(id);
        const y = document.getElementById(id2);
        const z = document.getElementById(id3);
        if (x.style.display === "none") {
            x.style.display = "block";
            y.style.height = "150px"
            z.style.width = "10%"
            document.getElementById(id4).innerHTML=""
        } else {
            x.style.display = "none";
            y.style.height = "25px"
            z.style.width = "100%"
            z.style.height= "25px"
            document.getElementById(id4).innerHTML=text
        }
    }

    function editTask(id){
        let x = document.getElementById("editTask");
        document.getElementById("editTaskID").innerHTML=id
        if (x.style.display === "none") {
            x.style.display = "block";
        } else {
            x.style.display = "none";
        }
    }

    function expandTask(id){

    }

</script>
<body>

<div class="draggable"> <div class="Title">TskApp</div> </div >
<div class="draggable"> <div class="subtitle">By Sophie Dunfield</div></div>
<div class="draggable"> <div class="welcome">Welcome:
<%=user.getUserName()%>
</div></div>


<%if (tasks !=null){
    for(Task task: tasks){
%>
<!-- This is a widget -->
<div class="draggable ui-widget-content" id="widget2<%=task.getTaskId()%>">
    <div class="widget-main-body">
        <div class="widget_left" id="widget<%=task.getTaskId()%>">
            <div class="task_header" >
                Task Name: <%=task.getTaskName()%>
            </div>
            <div class="dueDate">
                Due Date: <%=task.getDueDate()%>
            </div>
            <div class="description">
                Description: <br><%=task.getDescription()%>
            </div>
        </div>
        <div class="widget_right" id="widget3<%=task.getTaskId()%>">
            <div class="sideBar">
                <span class="sideBar_Text" id="widgetTitle<%=task.getTaskId()%>"></span>
                <button class="sideBar_button" type="button" onclick="removeTask(<%=task.getTaskId()%>)"> A </button>
                <button class="sideBar_button" type="button" onclick='minimize("widget<%=task.getTaskId()%>", "widget2<%=task.getTaskId()%>", "widget3<%=task.getTaskId()%>", "widgetTitle<%=task.getTaskId()%>", "<%=task.getTaskName()%>")'> M </button>
                <button class="sideBar_button" type="button" onclick="editTask(<%=task.getTaskId()%>)"> U </button>
                <button class="sideBar_button" type="button" onclick="expandTask('widget<%=task.getTaskId()%>')"> E </button>
            </div>
        </div>
    </div>
</div>
<%}
}%>


<!-- Add tasks -->
    <div class="draggable">
        <div class="button-window">
            <button class="open-button" onclick="toggleAddForm()">Add<br>Task</button>
        </div>
    </div>

    <!-- The form -->
    <div class="form-popup" id="addTask">
        <form method="post" class="form-container" action="addTask">
            <h1>Add<br>Task</h1>
            <input type="hidden" name="userID" value="<%=user.getUser_id()%>">
            <label><b>Task Name</b>
            <input type="text" placeholder="Enter task name" name="taskname" required>
            </label>

            <label><b>Due Date</b>
            <input type="text" placeholder="Enter due date" name="dueDate" required>
            </label>

            <label><b>Task Description</b>
            <input type="text" placeholder="Enter description" name="description" required>
            </label>

            <button type="submit" class="btn">Add Task</button>
            <button type="button" class="btn cancel" onclick="toggleAddForm()">Close</button>
        </form>
    </div>


<!-- Delete tasks -->
<div class="draggable">
<!-- The form -->
    <div class="form-popup" id="deleteTask">
        <form method="post" class="form-container" action="deleteTask">
            <h1>Delete<br>Task</h1>
            <input type="hidden" id="delTaskId" name="taskID"/>
            <input type="hidden" name="userID" value="<%=user.getUser_id()%>"/>

            Are you sure you want to remove this task from your account
            (Tasks are permanently deleted when this is done)
            <button type="submit" class="btn">Delete Task</button>
            <button type="button" class="btn cancel" onclick="toggleDeleteForm()">Close</button>
        </form>
    </div>
</div>

<!-- update tasks -->
<div class="draggable">
    <!-- The form -->
    <div class="form-popup" id="editTask">
        <form method="post" class="form-container" action="editTask">
            <h1>Update<br>Task</h1>
            <input type="hidden" id="editTaskID" name="taskID"/>
            <input type="hidden" name="userID" value="<%=user.getUser_id()%>"/>

            <label><b>Task Name</b>
                <input type="text" placeholder="Enter task name" name="taskname" required>
            </label>

            <label><b>Due Date</b>
                <input type="text" placeholder="Enter due date" name="dueDate" required>
            </label>

            <label><b>Task Description</b>
                <input type="text" placeholder="Enter description" name="description" required>
            </label>
            <button type="submit" class="btn">Edit Task</button>
            <button type="button" class="btn cancel" onclick="toggleEditTask()">Close</button>
        </form>
    </div>
</div>

</body>
</html>