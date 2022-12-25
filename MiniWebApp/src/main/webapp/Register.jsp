<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<link rel="stylesheet" href="Rstyle.css">
</head>
<body>

 <form action="RegisterServlet" method="post">
        <div class="container">
            <h1>Register</h1>
            <p>Please fill this form to create an account...!</p>
            <hr>
            <div class="name" id="name">
                <label for="FirstName"><b>First Name</b></label>
                <input type="text" placeholder="First Name" name="FirstName" id="FirstName" class="input" required>

            </div>
            <div class="name">
                <label for="LastName"><b>Last Name</b></label>
                <input type="text" placeholder="Last Name" name="LastName" id="LastName" class="input" required>
            </div>
            <div class="name" id="name">
                <label for="email"><b>Email</b></label>
                <input type="text" placeholder="Enter Email" name="email" id="email" class="input" required>
            </div>
            <div class="name">
                <label for="psw"><b>Password</b></label>
                <input type="password" placeholder="Enter Password" name="psw" id="psw" class="input" required>
            </div>
            <div>
                <label for="address"><b>Address</b></label>

                <textarea placeholder="Permanent Address is best" name="address" id="address" class="address" rows="5" required></textarea>
            </div>
            <hr>
            <div class="name" id="name">
               <label for="gender"><b>Gender :</b></label><br>
                <input type="radio" id="male" name="gender" value="Male">
                <label for="male">Male</label>
                <input type="radio" id="css" name="gender" value="Female">
                <label for="female">Female</label>
                <input type="radio" id="javascript" name="gender" value="Others">
                <label for="others">Others</label>
            </div>
            <div class="name">
                <label for="DOB"><b>Date of Birth</b></label><br>
                <input type="date" id="birthday" name="DOB" required>
            </div>


            <button type="submit" class="registerbtn">Register</button>
        </div>

        <div class="container signin">
            <p>Already have an account? <a href="login.jsp">Sign in</a>.</p>
        </div>
    </form>

</body>
</html>