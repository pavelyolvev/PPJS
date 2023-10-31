<%-- 
    Document   : newjsp
    Created on : 16 окт. 2023 г., 17:25:48
    Author     : brylo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
<h1>Ошибка! <%= request.getAttribute("errorMessage") %>
</h1>
<a href="/lab5t1-1.0-SNAPSHOT">Вернуться к калькулятору</a>
</body>
</html>
