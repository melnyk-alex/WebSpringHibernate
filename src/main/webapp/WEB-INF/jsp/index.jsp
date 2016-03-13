<%--
  Created by IntelliJ IDEA.
  User: human
  Date: 3/13/16
  Time: 8:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Basic Web Application</title>
</head>
<body>
    <h1>Spring (WEB FLOW + DATA); Hibernate 4</h1>
    
    <ul>${1 gt 2}
        <c:forEach items="${studentList}" var="student">
        <li>${student.id} ${student.name}</li>
        </c:forEach>
    </ul>
</body>
</html>
