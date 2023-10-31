
function addEmployee(){
    let name = document.getElementById("txt_add_empl_name").value;
    let manager = document.getElementById("txt_add_empl_manager").value;
    let pay = document.getElementById("txt_add_empl_pay").value;
    let numrazd = document.getElementById("txt_add_empl_numrazd").value;
    let namerazd = document.getElementById("txt_add_empl_namerazd").value;
    let city = document.getElementById("txt_add_empl_city").value;
    let razryad = document.getElementById("txt_add_empl_razryad").value;
    console.log(name);
    fetch(`/lab5t2-1.0-SNAPSHOT/getEmployees?operation=AddEmployee&name=${name}&manager=${manager}&pay=${pay}&numrazd=${numrazd}&namerazd=${namerazd}&city=${city}&razryad=${razryad}
    `)
        .then(() => {
            window.location.href = "/lab5t2-1.0-SNAPSHOT/";
        })
        .catch(error => {
            console.error("Ошибка при получении данных: " + error);
        });
}