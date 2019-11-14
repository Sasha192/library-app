<jsp:useBean id="allBooks" scope="request" type="java.util.List"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%@ include file="index.jsp" %>
    <div align="center">
        <h2> Select what you want to buy</h2>
        <table border="3">
            <tr>
                <th>Id</th>
                <th>Title</th>
                <th>Price</th>
                <th>Info</th>
                <th>Authors</th>
                <th>Rent</th>
            </tr>
            <c:forEach var="book" items="${allBooks}">
                <tr>
                    <td>${book.id}</td>
                    <td>${book.title}</td>
                    <td>${book.price}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/book/${book.id}">Info</a>
                    </td>
                    <td>
                            ${book.authors}
                    </td>
                    <td>
                        <a href="${pageContext.request.contextPath}/rent/rent_book?book_id=${book.id}">Rent</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
