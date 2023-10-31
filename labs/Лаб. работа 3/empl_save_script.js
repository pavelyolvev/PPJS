document.addEventListener("DOMContentLoaded", function() {
    var name = new URLSearchParams(window.location.search).get("name");
    var txtEmplName = document.getElementById("txt_empl_name");

    txtEmplName.value = name;
});