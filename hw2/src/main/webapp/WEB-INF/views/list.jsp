<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>List of Items</title>
</head>
<body>
<h1>List of Items</h1>
<ul>
    <c:forEach var="item" items="${data}">
        <li>${item}</li>
    </c:forEach>
</ul>
</body>
</html>
