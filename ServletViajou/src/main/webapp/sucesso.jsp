<%--
  Created by IntelliJ IDEA.
  User: brenosouza-ieg
  Date: 06/11/2024
  Time: 09:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="./CSS/error.css">
    <meta http-equiv="refresh" content="2; URL='<%= request.getAttribute("caminho")%>'" />

</head>
<body>
<div>
    <img src="./images/sucesso.svg" alt="">
    <h1>Ação concluída com sucesso</h1>
    <p>Você será direcionado de volta.</p>
    <p><%= request.getAttribute("sucessMessage")%></p>
</div>
</body>
</html>
