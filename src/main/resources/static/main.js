const formData = new FormData();
formData.append("file", fileInput.files[0]);

fetch("http://localhost:8080/file/upload", {
    method: "POST",
    body: formData,
}).then(response => response.text())
.then(data => alert(data));