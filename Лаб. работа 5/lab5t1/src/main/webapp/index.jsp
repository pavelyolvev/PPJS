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
<%
    String num1 = request.getParameter("num1");
    String num2 = request.getParameter("num2");
    String operation = request.getParameter("operation");
    double result = 0;
// Остальной код обработки формы
%>
<h1>Калькулятор!</h1>
<form method="post">
    Число 1: <input name="num1" type="text" value="<%= (num1 != null) ? num1 : "" %>"/> <br>
    Число 2: <input name="num2" type="text" value="<%= (num2 != null) ? num2 : "" %>"/> <br>
    <input name="operation" type="submit" value="+"/>
    <input name="operation" type="submit" value="-"/>
    <input name="operation" type="submit" value="*"/>
    <input name="operation" type="submit" value="/"/>
</form>
<h3>Операция: <%= (operation != null) ? operation : "" %>
</h3>
<%

    if (num1 != null && num2 != null && operation != null) {
        try {
            double n1 = Double.parseDouble(num1);
            double n2 = Double.parseDouble(num2);

            switch (operation) {
                case "+":
                    result = n1 + n2;
                    break;
                case "-":
                    result = n1 - n2;
                    break;
                case "*":
                    result = n1 * n2;
                    break;
                case "/":
                    if (n2 != 0) {
                        result = n1 / n2;
                    } else {
                        request.setAttribute("errorMessage", "Произошла ошибка: Деление на ноль невозможно.");
                        request.getRequestDispatcher("/error.jsp?error=NaN").forward(request, response);
                    }
                    break;
                default:
                    request.setAttribute("errorMessage", "Произошла ошибка: Неверная операция. Ошибка сервера.");
                    request.getRequestDispatcher("/error.jsp?error=NaN").forward(request, response);
            }
        } catch (NumberFormatException e) {
            request.setAttribute("errorMessage", "Произошла ошибка: Введено не число.");
            request.getRequestDispatcher("/error.jsp?error=NaN").forward(request, response);
        }
    }
%>
<h2>Результат: <%= result %>
</h2>
</body>
</html>
