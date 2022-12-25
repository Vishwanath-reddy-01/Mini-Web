<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login</title>
<link rel="stylesheet" href="lstyle.css">
</head>
<body>

<div class="container">
        <form action="loginServlet" method="post">
            <div>
                <label for="Email"><b>Email</b></label>
                <input type="email" placeholder="Registered Email" name="email" id="email" class="input" required>

            </div>
            <div>
                <label for="psw"><b>Password</b></label>
                <input type="password" placeholder="Enter Password" name="psw" id="psw" class="input" required>
            </div>
            <button type="submit" class="login">LOGIN</button>
        </form>
    </div>

</body>
</html>