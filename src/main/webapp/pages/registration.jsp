<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Task Manager Registration</title>
</head>
<body>
<div id="register" class="animate form">
    <form action="/reg/new_u" method="post" autocomplete="on">
        <h1>Registration</h1>
        <div>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </div>
        <p>
            <label for="username" class="uname">Your login</label>
            <input id="username" name="username" type="text"
                   placeholder="myusername"/>
        </p>
        <p>
            <label for="email"> Your e-mail</label>
            <input id="email" name="email" required="required" type="email"
                   placeholder="example@gmail.com"/>
        </p>
        <p>
            <label for="password">Your password</label>
            <input id="password" name="password" required="required" type="password"
                   placeholder="123456"/>
        </p>
        <p>
            <label for="password_confirm">Confirm your password</label>
            <input id="password_confirm" name="password_confirm" required="required"
                   type="password" placeholder="123456"/>
        </p>
        <p>
            <input type="submit" value="Registration"/>
        </p>
        <p>Already registered?<a href="/login">Sign in</a>
        </p>
    </form>
</div>
</body>
</html>
