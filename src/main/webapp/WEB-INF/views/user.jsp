<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Details</title>
</head>
<body>
<h2>User Information</h2>
<%-- 判断 user 对象是否存在 --%>
<p>ID: ${user.id}</p>
<p>Username: ${user.username}</p>
<p>Email: ${user.email}</p>
</body>
</html>