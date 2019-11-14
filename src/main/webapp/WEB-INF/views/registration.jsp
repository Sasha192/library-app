<html>
<head>
    <title>Registration</title>
</head>
<body>
<jsp:include page="index.jsp"/>
<form action="${pageContext.request.contextPath}/registration/add" method="post">
    <div class="container">
        <h1>Register</h1>
        <hr>
        <label for="username"><b>Username</b></label>
        <input type="text" placeholder="Enter username" name="username" required>

        <label for="firstName"><b>Firstname</b></label>
        <input type="text" placeholder="Enter firstname" name="firstName" required>

        <label for="lastName"><b>Lastname</b></label>
        <input type="text" placeholder="Enter lastname" name="lastName" required>

        <label for="password"><b>Password</b></label>
        <input type="password" placeholder="Enter password" name="password" required>

        <label for="repeatPassword"><b>Repeat password</b></label>
        <input type="password" placeholder="Repeat Password" name="repeatPassword" required>

        <label for="email"><b>E-mail</b></label>
        <input type="email" placeholder="Enter email" name="email" required>
        <hr>
        <button type="submit" class="registration">Register</button>
    </div>

    <div class="container signin">
        <p>Already have an account? <a href="${pageContext.request.contextPath}/login">Log-in</a>.</p>
    </div>
</form>
</body>
</html>
