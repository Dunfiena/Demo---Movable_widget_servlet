<%@ page import="com.example.web_assign_1.Model.User" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page language="java" session="true" %>
<% User user = (User)request.getAttribute("user");
String username = (String)request.getAttribute("username2");%>

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="App_CSS.css">
    <link rel="stylesheet" href="popup_signin%20CSS.css">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">

    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
    <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>

    <title>Tsk*AP</title>
</head>
<style>
    .draggable { width: 200px; height: 125px; padding: 5px; float: left; font-size: .9em; }
    .ui-widget-header p, .ui-widget-content p { margin: 0; }
</style>
<script>
    $( function() {
        $( ".draggable" ).draggable({ grid: [ 20, 20 ] });
    } );
    function openAddForm() {
        document.getElementById("addTask").style.display = "block";
    }

    function closeAddForm() {
        document.getElementById("addTask").style.display = "none";
    }

</script>
<body>

<div class="draggable"> <div class="Title">TskApp</div> </div >
<div class="draggable"> <div class="subtitle">By Sophie Dunfield</div></div>
<div class="draggable"> <div class="welcome">Welcome:
<%=user.getUserName()%>
</div></div>


<c:forEach var="tasks" items="${tasks.taskName}">
<div class="draggable ui-widget-content">
    <form class="container" method="get">
        <div class="widget_header">
               Task Name: <c:out value="${tasks.getTaskName()}"></c:out>
        </div>
        <div class="dueDate">
            Due Date: <c:out value="${tasks.getDueDate()}"></c:out>
        </div>
        <div class="description">
            Desciption: <br><c:out value="${tasks.getDescription()}"></c:out>
        </div>
    </form>
</div>
</c:forEach>


<!-- Add tasks -->
<div class="draggable">
    <button class="open-button" onclick="openAddForm()">Add<br>Task</button>

    <!-- The form -->
    <div class="form-popup" id="addTask">
        <form method="post" class="form-container" action="login.jsp">
            <h1>Add<br>Task</h1>

            <label><b>Task Name</b>
            <input type="text" placeholder="Enter task name" name="taskname" required>
            </label>

            <label><b>Due Date</b>
            <input type="password" placeholder="Enter due date" name="dueDate" required>
            </label>

            <label><b>Task Description</b>
            <input type="password" placeholder="Enter description" name="description" required>
            </label>

            <button type="submit" class="btn">Register</button>
            <button type="button" class="btn cancel" onclick="closeAddForm()">Close</button>
        </form>
    </div>
</div>

</body>
</html>