<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
        .draggable { width: 250px; height: 125px; padding: 5px; float: left; font-size: 0.9em; }
        .ui-widget-header p, .ui-widget-content p { margin: 0; }
    </style>
    <script>
        $( function() {
            $( ".draggable" ).draggable({ grid: [ 20, 20 ] });
        } );
        function toggleLoginForm() {
            let x = document.getElementById("myloginForm");
            if (x.style.display === "none") {
                x.style.display = "block";
            } else {
                x.style.display = "none";
            }
        }
        function toggleRegForm() {
            let x = document.getElementById("myRegForm")
            if (x.style.display === "none") {
                x.style.display = "block";
            } else {
                x.style.display = "none";
            }}

    </script>
    <body>

    <div class="draggable"> <div class="Title">TskApp</div> </div >
    <div class="draggable"> <div class="subtitle">By Sophie Dunfield</div></div>

    <!-- Login Button -->
    <div class="draggable">
        <div class="button-window">
            <button class="open-button" onclick="toggleLoginForm()">Login</button>
        </div>
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
                <button type="button" class="btn cancel" onclick="toggleLoginForm()">Close</button>
            </form>
        </div>
    </div>


    <!-- Register button -->
    <div class="draggable">
        <button class="open-button" onclick="toggleRegForm()">Regi<br>ster</button>

        <!-- The form -->
        <div class="form-popup" id="myRegForm">
            <form class="form-container" method="post" action="register">
                    <h1>Register</h1>

                <label><b>Username</b>
                <input type="text" placeholder="Enter user name" name="username" required>
                </label>
                <label><b>Email</b>
                    <input type="text" placeholder="Enter email" name="email" required>
                </label>
                <label><b>Password</b>
                <input type="password" placeholder="Enter Password" name="password" required>
                </label>
                <button type="submit" class="btn">Register</button>
                <button type="button" class="btn cancel" onclick="toggleRegForm()">Close</button>
            </form>
        </div>
    </div>
    </body>
</html>