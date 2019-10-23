<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Share page</title>
</head>
<body>
<form action="/share/to_mail/${task.getId()}" method="post" autocomplete="on">
    <h1>Share</h1>
    <div>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </div>
    <p>
        <label for="email">e-mail to share</label>
        <input id="email" name="email" required="required" type="email"
               placeholder="example@gmail.com"/>
    </p>
    <p>
        <input type="submit" value="Share"/>
    </p>
</form>
</body>
</html>
