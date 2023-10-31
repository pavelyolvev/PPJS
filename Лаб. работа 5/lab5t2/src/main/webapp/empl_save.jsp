<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Добавление сотрудника</title>
    <link href="styles1.css" rel="stylesheet">
</head>
<body>
<div class="center">
    Имя сотрудника: <br/> <input id="txt_add_empl_name" class='textfield' type='text' name='employee_name' /> <br/>
    Менеджер: <br/> <input id="txt_add_empl_manager" class='textfield' type='text' name='employee_name' /> <br/>
    Зарплата: <br/> <input id="txt_add_empl_pay" class='textfield' type='text' name='employee_name' /> <br/>
    Номер подразделения: <br/> <input id="txt_add_empl_numrazd" class='textfield' type='text' name='employee_name' /> <br/>
    Название подразделения: <br/> <input id="txt_add_empl_namerazd" class='textfield' type='text' name='employee_name' /> <br/>
    Город: <br/> <input id="txt_add_empl_city" class='textfield' type='text' name='employee_name' /> <br/>
    Разряд ETC: <br/> <input id="txt_add_empl_razryad" class='textfield' type='text' name='employee_name' /> <br/>
    <button type="button" class="btn" id="btn_empl_save" name='empl_save' onclick="addEmployee()">Сохранить</button>

</div>
    <script src="empl_save_script.js"></script>
</body>
</html>