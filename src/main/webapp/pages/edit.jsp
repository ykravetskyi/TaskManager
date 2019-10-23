<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Task</title>
</head>
<body>
<p>Old Name: ${task.getName()}</p>
<p>Old Description: ${task.getDescription()}</p>
<form action="/task/${task.getId()}/edit" method="post" autocomplete="on">
    <h1>Edit</h1>
    <div>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </div>
    <p>
        <label for="new_name">Your login</label>
        <input id="new_name" name="new_name" type="text"
               placeholder="new name"/>
    </p>
    <p>
        <label for="new_description">Your login</label>
        <input id="new_description" name="new_description" type="text"
               placeholder="new_description"/>
    </p>
    <p>
        <input type="submit" value="Edit"/>
    </p>
    <p><a href="/home">Cansel edit</a>
    </p>
</form>
</body>
</html>
