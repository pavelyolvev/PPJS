document.addEventListener("DOMContentLoaded", function() {
	function addFocusEventListeners(inputElement, focusmsg, blurmsg) {
    // Добавляем обработчик события "фокус получен"
    inputElement.addEventListener("focus", function() {
		if(inputElement.value == blurmsg)
			inputElement.value = focusmsg;
    });

    // Добавляем обработчик события "фокус потерян"
    inputElement.addEventListener("blur", function() {
		if(inputElement.value == focusmsg)
			inputElement.value = blurmsg;
    });
	}
	function isValNaN(val){
		if(isNaN(val))
			throw new Error("Введено не число")

		//if(isNaN(val))

	}
	var dialog = document.getElementById("confirmationDialog");
	var hrefDel = document.getElementById("href_delete");
	var txtEmplNum = document.getElementById("txt_empl_num");
	var txtEmplName = document.getElementById("txt_empl_name");
	var btnNumSrch = document.getElementById("btn_num_search");
	var btnNameSrch = document.getElementById("btn_name_search");
	var addEmpl = document.getElementById("add_empl");
	var confirmButton = document.getElementById("confirm_delete");
	var cancelButton = document.getElementById("cancel_delete");

	var table = document.getElementById("table");
	var checkboxes = table.getElementsByClassName("rowCheckbox");


    addEmpl.addEventListener("click", function() {
		var url2 = 'empl_save.html';
		if(txtEmplName.value !== "Например, Иванов")
			 url2 += '?name=' + txtEmplName.value;
		window.open(url2, '_blank');
    });
    btnNumSrch.addEventListener("click", function() {
		try{
			isValNaN(txtEmplNum.value)
		} catch (err){
			alert(err.message);
		}

    });
    hrefDel.addEventListener("click", function(event) {
		event.preventDefault();
		showConfirmationDialog();
    });
	txtEmplNum.addEventListener("keydown", function(event) {
    if (event.keyCode === 13) { //13 - код клавиши Enter
		isValNaN(txtEmplNum.value)


    }
	});
	addFocusEventListeners(txtEmplNum, "", "Например, 1")
	addFocusEventListeners(txtEmplName, "", "Например, Иванов")
	
	confirmButton.addEventListener("click", function() {
    
	// скрытие строки
	for (var i = 0; i < checkboxes.length; i++) {
		if(checkboxes[i].checked)
			checkboxes[i].closest("tr").style.display = "none";
	}
    dialog.style.display = "none";
	});

	cancelButton.addEventListener("click", function() {
    dialog.style.display = "none";
	});
	
	// функция вызова диалогового окна
	function showConfirmationDialog() {
    dialog.style.display = "block";
	}
	
	
});
