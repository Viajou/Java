<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
        <link rel="stylesheet" href="./CSS/error.css">
        <%@ page isErrorPage="true" %>
        <meta http-equiv="refresh" content="5; URL='<%= request.getAttribute("caminho")%>'" />
    </head>
    <body>
    <div>
        <img src="./images/erro.svg" alt="">
        <h1>Ops, parece que tivemos algum problema</h1>
        <p>Tente novamente mais tarde</p>
        <p><%= request.getAttribute("errorMessage")%></p>
    </div>
    </body>
</html>

