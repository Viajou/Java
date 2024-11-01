<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/erro.css">
</head>
<body>
<div>
    <img src="<%= request.getContextPath() %>/images/erro.svg" alt="">
    <h1>Ops, parece que tivemos algum problema</h1>
    <p>Tente novamente mais tarde</p>
</div>
</body>
</html>

