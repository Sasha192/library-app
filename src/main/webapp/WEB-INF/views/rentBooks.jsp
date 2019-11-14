<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Rent info</title>
    </head>
    <body>
        <%@ include file="index.jsp" %>
        <h2>Rent info</h2>
        <table border="2">
            <tr>
                <th>Id</th>
                <th>Title</th>
                <th>Year</th>
                <th>Price</th>
                <th>Info</th>
                <th>Authors</th>
                <th>Rent</th>
            </tr>
            <c:forEach var="rent" items="${rent_list}">
                <tr>
                    <td>${rent.id}</td>
                    <td>${rent.rentDate}</td>
                    <td>${rent.user}</td>
                    <td>${rent.book}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/book/${rent.book.id}">Info</a>
                    </td>
                    <td>${rent.book.authors}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/rent/return_book?book_id=${rent.book.id}">Return</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
