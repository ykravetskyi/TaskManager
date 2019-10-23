<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main</title>
</head>
<body>
<h1>All tasks</h1>
<form action="/addTask" method="get">
    <button>Add task</button>
</form>
<hr>
<ul>
    <c:forEach items="${tasks}" var="task">
    <li>
        <p>Name: ${task.getName()}</p>
        <p>Description: ${task.getDescription()}</p>
        <p>Workers:
            <ul>
                <c:forEach items="${task.getUsers()}" var="user">
                <li>
        <p>${user.getUsername()}</p></li>
    </c:forEach>
</ul>
</p>
<form action="/task/${task.getId()}" method="get">
    <button>Edit</button>
</form>
<form action="/delete/task/${task.getId()}" method="get">
    <button>Delete</button>
</form>
<form action="" method="post">
    <button>Share</button>
</form>
</li>
<hr>
</c:forEach>
</ul>
<form action="/logout" method="get">
    <button>Log out</button>
</form>
</body>
</html>

<a href="/task/${task.getId()}">
</a>