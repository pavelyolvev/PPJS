function setNumSearch(){
    let txtfield = document.getElementById("txt_empl_num").value;
    fetch("/lab5t2-1.0-SNAPSHOT/getEmployees?operation=SelectOnNum&num="+txtfield)
        .then(response => {
            if (response.ok) {
                return response.json();
            } else {
                alert("Нет связи с сервером. Ошибка при получении данных:" + response.status);
                return null;
            }
        })
        .then(data => {
            if (data.length !== 0)
                updateTableWithData(data);
            else alert("Нет связи с базой данный или запрос вернул 0 строк");
        })
        .catch(error => {
            console.error("Ошибка при получении данных: " + error);
        });
}
function setEmplDel(num){
    fetch("/lab5t2-1.0-SNAPSHOT/getEmployees?operation=DeleteOnNumQuery&num="+num)
        .then(response => response.json())
        .then(data => {
            if (data.length !== 0)
                updateTableWithData(data);
            else alert("Нет связи с базой данный или запрос вернул 0 строк");
        })
        .catch(error => {
            console.error("Ошибка при получении данных: " + error);
        });
}

function setNameSearch(){
    let txtfield = encodeURIComponent(document.getElementById("txt_empl_name").value);
    fetch("/lab5t2-1.0-SNAPSHOT/getEmployees?operation=SelectOnName&name="+txtfield)
        .then(response => {
            if (response.ok) {
                return response.json();
            } else {
                alert("Нет связи с сервером. Ошибка при получении данных:" + response.status);
                return null;
            }
        })
        .then(data => {
            if (data.length !== 0)
                updateTableWithData(data);
            else alert("Нет связи с базой данный или запрос вернул 0 строк");
        })
        .catch(error => {
            console.error("Ошибка при получении данных: " + error);
        });
}
function setAllSearch(){
    fetch("/lab5t2-1.0-SNAPSHOT/getEmployees?operation=SelectAll")
        .then(response => {
            if (response.ok) {
                return response.json();
            } else {
                alert("Нет связи с сервером. Ошибка при получении данных:" + response.status);
                return null;
            }
        })
        .then(data => {
            console.log(data)
            if (data.length !== 0)
                updateTableWithData(data);
            else alert("Нет связи с базой данный или запрос вернул 0 строк");
        })
        .catch(error => {
            console.error("Ошибка при получении данных: " + error);
        });
}
function updateTableWithData(data) {
    const table = document.getElementById("table");
    table.innerHTML = `
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
    `;

    data.forEach(employee => {
        const row = table.insertRow();
        // Вам нужно будет адаптировать следующие строки под структуру данных
        const checkCell = row.insertCell(0);
        const numCell = row.insertCell(1);
        const nameCell = row.insertCell(2);
        const managerCell = row.insertCell(3);
        const salaryCell = row.insertCell(4);
        const deptNumCell = row.insertCell(5);
        const deptNameCell = row.insertCell(6);
        const cityCell = row.insertCell(7);
        const etcCell = row.insertCell(8);
        const actionCell = row.insertCell(9);

        checkCell.innerHTML = "<input type='checkbox' class=\"rowCheckbox\">"; // Здесь вы можете добавить дополнительные данные
        numCell.innerHTML = employee.num;
        nameCell.innerHTML = employee.nameE;
        managerCell.innerHTML = employee.manager;
        salaryCell.innerHTML = employee.pay;
        deptNumCell.innerHTML = employee.numrazd;
        deptNameCell.innerHTML = employee.namerazd;
        cityCell.innerHTML = employee.city;
        etcCell.innerHTML = employee.razryad;
        actionCell.innerHTML = ""; // Здесь вы можете добавить дополнительные действия
    });
    const deleteRow = table.insertRow();
    const spaceCell = deleteRow.insertCell(0);
    const deleteCell = deleteRow.insertCell(1);
    spaceCell.colSpan = 9;
    deleteCell.innerHTML = "<a id='href_delete' onclick='deleteEmployees()' href>Удалить</a>";
}
function preventSend(){
    event.preventDefault();
}
function deleteEmployees(){
    event.preventDefault();
    showConfirmationDialog();
}
function showConfirmationDialog() {
    const dialog = document.getElementById("confirmationDialog");
    dialog.style.display = "block";
}
function confirmDialog(){
    const table = document.getElementById("table");
    const dialog = document.getElementById("confirmationDialog");
    const checkboxes = table.getElementsByClassName("rowCheckbox");
    for (var i = 0; i < checkboxes.length; i++) {
        if(checkboxes[i].checked){
            const emplNum = checkboxes[i].closest("tr").cells[1].textContent;
            setEmplDel(emplNum);
            console.log(emplNum);
        }

    }
    dialog.style.display = "none";
}
function cancelDialog(){
    const dialog = document.getElementById("confirmationDialog");
    dialog.style.display = "none";
}