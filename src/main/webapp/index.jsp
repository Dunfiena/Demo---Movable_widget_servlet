<%@ page import="com.example.web_assign_1.HelloServlet" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% HelloServlet h = new HelloServlet(); %>

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
        function openLoginForm() {document.getElementById("myloginForm").style.display = "block";}
        function closeLoginForm() {document.getElementById("myloginForm").style.display = "none";}
        function openRegForm() {document.getElementById("myRegForm").style.display = "block";}
        function closeRegForm() {document.getElementById("myRegForm").style.display = "none";}

    </script>
    <body>

    <div class="draggable"> <div class="Title">TskApp</div> </div >
    <div class="draggable"> <div class="subtitle">By Sophie Dunfield</div></div>

    <!-- Login Button -->
    <div class="draggable">
        <button class="open-button" onclick="openLoginForm()">Login</button>
        <!-- The form -->
        <div class="form-popup" id="myloginForm">
            <form class="form-container" method="post" action="login">
                <h1>Login</h1>
                <label><b>User Name</b>
                <input type="text" placeholder="Enter user name" name="userName" required>
                </label>

                <label><b>Password</b>
                <input type="password" placeholder="Enter Password" name="hashpass" required>
                </label>
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
            <form class="form-container" method="post" action="register">
                    <h1>Register</h1>

                <label><b>Username</b>
                <input type="text" placeholder="Enter user name" name="username" required>
                </label>
                <label><b>Password</b>
                <input type="password" placeholder="Enter Password" name="psw" required>
                </label>
                <button type="submit" class="btn">Register</button>
                <button type="button" class="btn cancel" onclick="closeRegForm()">Close</button>
            </form>
        </div>
    </div>
    </body>
</html>