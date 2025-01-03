<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Profile</title>
</head>
<body>
    <h1>Welcome, ${user.name}</h1>
    <p>Email: ${user.email}</p>
    
    <c:if test="${user.loggedIn}">
        <p>Status: Logged In</p>
    </c:if>
    
    <c:forEach var="project" items="${user.projects}">
        <p>Project Name: ${project.name}</p>
    </c:forEach>
</body>
</html>
