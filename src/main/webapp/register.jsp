<%@ page import="com.example.web_assign_1.Model.Task" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.web_assign_1.Model.User" %>
<%@ page import="com.example.web_assign_1.HelloServlet" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page language="java" session="true" %>

<% HelloServlet h = new HelloServlet();
    User user = null;
    user = (User) request.getAttribute("user");
    if (user == null){
        user = new User(999,"Guest","Guest","Guest","Guest","Guest");
    }
%>
<% ArrayList<Task> tasks = (ArrayList<Task>)request.getAttribute("tasks"); %>

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

    function openLoginForm() {
        document.getElementById("myloginForm").style.display = "block";
    }

    function closeLoginForm() {
        document.getElementById("myloginForm").style.display = "none";
    }

    function openRegForm() {
        document.getElementById("myRegForm").style.display = "block";
    }

    function closeRegForm() {
        document.getElementById("myRegForm").style.display = "none";
    }
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
<div class="draggable"> <div class="welcome">Welcome:<%=user.getUserName()%></div></div>


<div class="draggable ui-widget-content">
    <form class="container" method="get">
        <div class="widget_header">
            <%--                Task Name: <%=tasks.get(0).getTaskName()%> <hr>--%>
        </div>
        <div class="dueDate">
            <%--                Due Date: <%=tasks.get(0).getDueDate()%>--%>
        </div>
        <div class="description">
            <%--                Desciption: <br><%=tasks.get(0).getDescription()%>--%>
            <%%>

        </div>
    </form>
</div>

<!-- Login Button -->
<div class="draggable">
    <button class="open-button" onclick="openLoginForm()">Login</button>

    <!-- The form -->
    <div class="form-popup" id="myloginForm">
        <form class="form-container" method="post" action="index.jsp">
            <%--@declare id="email"--%><%--@declare id="psw"--%><%--@declare id="username"--%><%--@declare id="hashpass"--%><h1>Login</h1>

            <label for="userName"><b>User Name</b></label>
            <input type="text" placeholder="Enter user name" name="userName" required>

            <label for="hashpass"><b>Password</b></label>
            <input type="password" placeholder="Enter Password" name="hashpass" required>

            <button type="submit" class="btn">Login</button>
            <button type="button" class="btn cancel" onclick="closeLoginForm()">Close</button>
        </form>
    </div>
</div>


<!-- Register button -->
<div class="draggable">
    <button class="open-button" onclick="openRegForm()">Regi<br>ster</button>

    <!-- The form -->
    <div class="form-popup" id="myRegForm">
        <form action="/action_page.php" class="form-container">
            <%--@declare id="email"--%><%--@declare id="psw"--%><%--@declare id="fname"--%><%--@declare id="lname"--%>
            <h1>Register</h1>

            <label for="userName"><b>Username</b></label>
            <input type="text" placeholder="Enter user name" name="username" required>

            <label for="psw"><b>Password</b></label>
            <input type="password" placeholder="Enter Password" name="psw" required>

            <button type="submit" class="btn">Register</button>
            <button type="button" class="btn cancel" onclick="closeRegForm()">Close</button>
        </form>
    </div>
</div>


<!-- Add tasks -->
<div class="draggable">
    <button class="open-button" onclick="openAddForm()">Add<br>Task</button>

    <!-- The form -->
    <div class="form-popup" id="addTask">
        <form action="/addTask.php" class="form-container">
            <%--@declare id="email"--%><%--@declare id="psw"--%><%--@declare id="fname"--%><%--@declare id="lname"--%>
            <%--@declare id="taskname"--%><%--@declare id="duedate"--%><%--@declare id="description"--%><h1>Add<br>Task</h1>

            <label for="Taskname"><b>Task Name</b></label>
            <input type="text" placeholder="Enter task name" name="taskname" required>

            <label for="dueDate"><b>Due Date</b></label>
            <input type="password" placeholder="Enter due date" name="dueDate" required>

            <label for="description"><b>Task Description</b></label>
            <input type="password" placeholder="Enter description" name="description" required>

            <button type="submit" class="btn">Register</button>
            <button type="button" class="btn cancel" onclick="closeAddForm()">Close</button>
        </form>
    </div>
</div>

</body>
</html>