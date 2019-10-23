<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Task Manager - Login</title>
</head>
<body>
    <form action="/login" method="post" autocomplete="on">
        <h1>Log in</h1>
        <div>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </div>
        <p>
            <label for="username">Your login</label>
            <input id="username" name="username" type="text" placeholder="login"/>
        </p>
        <p>
            <label for="password">Your password</label>
            <input id="password" name="password" type="password" placeholder="pssword"/>
        </p>
        <p class="login button">
            <input type="submit" value="Sign in"/>
        </p>
        <p class="change_link">Don't have an account?<a href="/registration" class="to_register">Sing up</a>
        </p>
    </form>
</body>
</html>