<%--
  Created by IntelliJ IDEA.
  User: biancaclarindo-ieg
  Date: 03/11/2024
  Time: 20:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.example.servletviajou.DAO.AdminDAO" %>
<%@ page import="com.example.servletviajou.Model.Admin" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>


<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Alterar tour</title>

</head>
<body>
<h1>Alterar tour</h1>
<br><br>
<form action="AlterarTourVirtual-servlet" method="post">

    <label for="nome">Novo nome: </label>
    <input type="text" name="nome" id="nome" placeholder="Ex: http:empresa.com">

    <br>

    <label for="descricao">Nova descrição do evento:</label>
    <input type="text" name="descricao" id="descricao" placeholder="Ex: Evento de música ao vivo">

    <br>

    <label for="video">Nova capacidade da excursão:</label>
    <input type="text" name="video" id="video" placeholder="Ex: 1500">

    <br>

    <label for="classificacao">Nova classificação:</label>
    <input type="text" name="classificacao" id="classificacao" placeholder="Ex: 15:30">

    <br>

    <label for="data-inicio">Nova data de início do evento:</label>
    <input type="text" name="data-inicio" id="data-inicio" placeholder="Formato: aaaa-mm-dd">

    <br>

    <label for="preco">Novo preço:</label>
    <input type="text" name="preco" id="preco" placeholder="Formato: aaaa-mm-dd">

    <br>

    <label for="data-atualizacao">Data de atualização:</label>
    <input type="text" name="data-atualizacao" id="data-atualizacao" placeholder="Ex: 76">

    <br>

    <input type="submit" value="Alterar excursão">
</form>
<br><br>
<a href="listar_excursao.jsp">
    <button>Voltar</button>
</a>
</body>
</html>
