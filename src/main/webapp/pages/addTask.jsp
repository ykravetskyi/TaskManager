<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add New Task</title>
</head>
<body>
<form action="/reg/new_task" method="post">
    <div>
        <input type="text" name="name" placeholder="name">
    </div>
    <div>
        <input type="text" name="description" placeholder="description">
    </div>
    <div>
        <input type="submit" value="Add">
    </div>
    <div>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </div>
</form>
<form action="/home" method="get">
    <button>Go to home</button>
</form>
</body>
</html>
