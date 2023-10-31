<%@ page import="com.example.lab5t2.DB.Employees" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.lab5t2.DB.DBconnection" %><%--
    Document   : main_page
    Created on : 16 окт. 2023 г., 19:35:23
    Author     : brylo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Таблица сотрудников</title>
		<link href="styles1.css" rel="stylesheet">
		
	</head>
	<body onload="setAllSearch()">
		<form method="post" onsubmit="preventSend()">
			<div class="center">
				Номер сотрудника: <br/> <input id="txt_empl_num" class='textfield' type='text' name='employee_number' value="Например, 1" /> <br/>
				Имя сотрудника: <br/> <input id="txt_empl_name" class='textfield' type='text' name='employee_name' value="Например, Иванов" /> <br/>
				<input type="submit" class="btn" id="btn_num_search" name='num_search' value="Поиск по номеру" onclick="setNumSearch()">
				<input type="submit" class="btn" id="btn_name_search" name='name_search' value="Поиск по имени" onclick="setNameSearch()"> <br/> <br/>
				<input type="submit" class='btn' id="btn_empl" name='show_employees' value="Информация о сотрудниках" onclick="setAllSearch()"> <br/>

			</div>
			<a id='add_empl' href=''> добавить сотрудника </a> <br/>
			<table id="table" class='table' width='90%' border='2px' cellspacing='0px' cellpadding='4px' align='center'>

				<thead>
				<tr>
					<th colspan='10'>Информация о сотрудниках</th>
				</tr>
				<tr>
					<th></th>
					<th>Номер сотрудника</th>
					<th>Имя сотрудника</th>
					<th>Менеджер</th>
					<th>Зарплата</th>
					<th>Номер подразделения</th>
					<th>Название подразделения</th>
					<th>Город</th>
					<th>Разряд ETC</th>
					<th></th>
				</tr>
				</thead>
<%--				<tbody>--%>
<%--				<%--%>
<%--					List<Employees> employees = DBconnection.SelectAllQuery();--%>

<%--					for (Employees employee : employees) {--%>
<%--				%>--%>
<%--				<tr>--%>
<%--					<td><input type='checkbox' class="rowCheckbox"></td>--%>
<%--					<td><%= employee.getNum() %></td>--%>
<%--					<td><%= employee.getName() %></td>--%>
<%--					<td><%= employee.getManager() %></td>--%>
<%--					<td><%= employee.getPay() %></td>--%>
<%--					<td><%= employee.getNumrazd() %></td>--%>
<%--					<td><%= employee.getNamerazd() %></td>--%>
<%--					<td><%= employee.getCity() %></td>--%>
<%--					<td><%= employee.getRazryad() %></td>--%>
<%--				</tr>--%>
<%--				<%--%>
<%--					}--%>
<%--				%>--%>
				</tbody>
<%--				<tr>--%>
<%--					<th>--%>
<%--						<input type='checkbox' class="rowCheckbox">--%>
<%--					</th>--%>
<%--					<td>1</td>--%>
<%--					<td>Иван Иванов</td>--%>
<%--					<td>Senior разработчик</td>--%>
<%--					<td>18.09.2019</td>--%>
<%--					<td>412</td>--%>
<%--					<td></td>--%>
<%--				</tr>--%>
<%--				<tr>--%>
<%--					<th>--%>
<%--						<input type='checkbox' class="rowCheckbox">--%>
<%--					</th>--%>
<%--					<td>2</td>--%>
<%--					<td>Ольга Бондарева</td>--%>
<%--					<td>Дизайнер</td>--%>
<%--					<td>21.10.2019</td>--%>
<%--					<td>431</td>--%>
<%--					<td></td>--%>
<%--				</tr>--%>
<%--				<tr>--%>
<%--					<th>--%>
<%--						<input type='checkbox' class="rowCheckbox">--%>
<%--					</th>--%>
<%--					<td>3</td>--%>
<%--					<td>Полина Юдина</td>--%>
<%--					<td>Middle разработчик</td>--%>
<%--					<td>31.11.2019</td>--%>
<%--					<td>132</td>--%>
<%--					<td></td>--%>
<%--				</tr>--%>
<%--				<tr>--%>
<%--					<th>--%>
<%--						<input type='checkbox' class="rowCheckbox">--%>
<%--					</th>--%>
<%--					<td>4</td>--%>
<%--					<td>Анна Иванова</td>--%>
<%--					<td>Веб-разработчик</td>--%>
<%--					<td>18.11.2019</td>--%>
<%--					<td>532</td>--%>
<%--					<td></td>--%>
<%--				</tr>--%>
<%--				<tr>--%>
<%--					<th>--%>
<%--						<input type='checkbox' class="rowCheckbox">--%>
<%--					</th>--%>
<%--					<td>5</td>--%>
<%--					<td>Максим Маслов</td>--%>
<%--					<td>UI-дизайнер</td>--%>
<%--					<td>20.11.2019</td>--%>
<%--					<td>313</td>--%>
<%--					<td></td>--%>
<%--				</tr>--%>
<%--				<tr>--%>
<%--					<th>--%>
<%--						<input type='checkbox' class="rowCheckbox">--%>
<%--					</th>--%>
<%--					<td>6</td>--%>
<%--					<td>Иван Михайлов</td>--%>
<%--					<td>Junior разработчик</td>--%>
<%--					<td>25.12.2019</td>--%>
<%--					<td>515</td>--%>
<%--					<td></td>--%>
<%--				</tr>--%>
<%--				<tr>--%>
<%--					<th>--%>
<%--						<input type='checkbox' class="rowCheckbox">--%>
<%--					</th>--%>
<%--					<td>7</td>--%>
<%--					<td>Евангелина Анимовна</td>--%>
<%--					<td>Уборщик</td>--%>
<%--					<td>18.2.2020</td>--%>
<%--					<td>612</td>--%>
<%--					<td></td>--%>
<%--				</tr>--%>
<%--				<tr>--%>
<%--					<th>--%>
<%--						<input type='checkbox' class="rowCheckbox">--%>
<%--					</th>--%>
<%--					<td>8</td>--%>
<%--					<td>Андрей Чернышев</td>--%>
<%--					<td>Уборщик</td>--%>
<%--					<td>20.2.2020</td>--%>
<%--					<td>424</td>--%>
<%--					<td></td>--%>
<%--				</tr>--%>
<%--				<tr>--%>
<%--					<th>--%>
<%--						<input type='checkbox' class="rowCheckbox">--%>
<%--					</th>--%>
<%--					<td>9</td>--%>
<%--					<td>Полина Смирнова</td>--%>
<%--					<td>Middle-разработчик</td>--%>
<%--					<td>7.3.2020</td>--%>
<%--					<td>732</td>--%>
<%--					<td></td>--%>
<%--				</tr>--%>
<%--				<tr>--%>
<%--					<th>--%>
<%--						<input type='checkbox' class="rowCheckbox">--%>
<%--					</th>--%>
<%--					<td>10</td>--%>
<%--					<td>Андрей Андреев</td>--%>
<%--					<td>UX-дизайнер</td>--%>
<%--					<td>18.3.2020</td>--%>
<%--					<td>749</td>--%>
<%--					<td></td>--%>
<%--				</tr>--%>
				<tr>
					<td colspan='9'></td>
					<td><a id='href_delete' href>Удалить</a></td>
				</tr>
			</table>
		</form>
		<div id="confirmationDialog" class="dialog">
			<p>Вы уверены, что хотите удалить элемент?</p>
			<button id="confirm_delete" onclick="confirmDialog()">Удалить</button>
			<button id="cancel_delete" onclick="cancelDialog()">Отмена</button>
		</div>
		<script src="script.js"></script>
		<script src="newscript.js"></script>
	</body>
</html>
