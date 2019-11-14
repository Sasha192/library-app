<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Book info</title>
</head>
<body>
    <%@ include file="index.jsp" %>
    <h2>Book info</h2>
    <table border="2">
        <tr>
            <th>Id</th>
            <th>Title</th>
            <th>Price</th>
            <th>Authors</th>
        </tr>
        <tr>
            <td>${book.id}</td>
            <td>${book.title}</td>
            <td>${book.price}</td>
            <td>${book.authors}</td>
        </tr>
    </table>
</body>
</html>
