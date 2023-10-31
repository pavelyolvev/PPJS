function getGenerated(){

    fetch("/lab6-1.0-SNAPSHOT/imageServlet")
        .then(response => {
        if (response.ok) {
            return response.blob(); // Получаем изображение в виде объекта Blob
        }
        throw new Error("Network response was not ok.");
        })
        .then(blob => {
            // В blob теперь содержится изображение
            // Вы можете использовать его, например, для отображения на веб-странице
            const img = document.getElementById("genImg");
            const a = document.getElementById("genImg-href");
            img.src = URL.createObjectURL(blob);
            a.href=URL.createObjectURL(blob);

        })
        .catch(error => {
            console.error("Error:", error);
        });


}