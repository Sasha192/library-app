<html>
<head>
    <title>Create book</title>
</head>
<body>
    <%@ include file="index.jsp" %>
    <form action="${pageContext.request.contextPath}/book/add" method="post">
        <div class="container">
            <h1>Register</h1>
            <p>Please fill in this form to create an account.</p>
            <table border="1">
                <tr>
                    <td>Book title:</td>
                    <td><input value="${name}" name="name"/></td>
                </tr>
                <tr>
                    <td>Year:</td>
                    <td><input value="${year}" name="year"/></td>
                </tr>
                <tr>
                    <td>Price:</td>
                    <td><input value="${price}" name="price"></td>
                </tr>
                <tr>
                    <td></td>
                    <button type="submit">Confirm</button><br>
                    <br>
                    <a href="${pageContext.request.contextPath}/book/all">all books</a>
                </tr>
            </table>
        </div>
    </form>
</body>
</html>
