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

	//var hrefDel = document.getElementById("href_delete");
	var txtEmplNum = document.getElementById("txt_empl_num");
	var txtEmplName = document.getElementById("txt_empl_name");
	var btnNumSrch = document.getElementById("btn_num_search");
	var addEmpl = document.getElementById("add_empl");

	var table = document.getElementById("table");



    addEmpl.addEventListener("click", function() {
		var url2 = 'empl_save.jsp';
		if(txtEmplName.value !== "Например, Иванов")
			 url2 += '?name=' + txtEmplName.value;
		window.open(url2, '');
    });
    btnNumSrch.addEventListener("click", function() {
		try{
			isValNaN(txtEmplNum.value)
		} catch (err){
			alert(err.message);
		}

    });
    // hrefDel.addEventListener("click", function(event) {
	// 	event.preventDefault();
	// 	showConfirmationDialog();
    // });
	txtEmplNum.addEventListener("keydown", function(event) {
    if (event.keyCode === 13) { //13 - код клавиши Enter
		isValNaN(txtEmplNum.value)
	}
	});
	addFocusEventListeners(txtEmplNum, "", "Например, 1")
	addFocusEventListeners(txtEmplName, "", "Например, Иванов")
});
