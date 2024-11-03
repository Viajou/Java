<%@ page import="com.example.servletviajou.DAO.AdminDAO" %>
<%@ page import="com.example.servletviajou.Model.Admin" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>


<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Crud</title>

</head>
<body>
<h1>Aterar admin</h1>
<br><br>
<form action="alterarAdmin-servlet" method="post">
    <label for="Id"> Id do admin</label>
    <input type="number" name="id" id="id" placeholder="Ex: 0">
    <br><br>
    <label for="nome">Nome do admin:</label>
    <input type="text" name="nome" id="nome" placeholder="Ex: Joao">
    <br><br>
    <label for="email">Email do admin:</label>
    <input type="text" name="email" id="email" placeholder="Ex: usuari@gmail.com">
    <br><br>
    <label for="url_imagem">Foto do admin:</label>
    <input type="text" name="url_imagem" id="url_imagem" placeholder="Ex: https://imagem-usuario">
    <br><br>
    <label for="novaSenha">Nova senha do admin:</label>
    <input type="text" name="novaSenha" id="novaSenha" placeholder="Ex: 12345">
    <br><br>



    <input type="submit" value="Alterar usuario" >
</form>
<br><br>
<a href="listar_admin.jsp">
    <button>Voltar</button>
</a>
</body>
</html>
