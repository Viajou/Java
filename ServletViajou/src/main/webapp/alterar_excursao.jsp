<%--
  Created by IntelliJ IDEA.
  User: biancaclarindo-ieg
  Date: 03/11/2024
  Time: 19:02
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
    <title>Alterar excursões</title>

</head>
<body>
<h1>Alterar excursão</h1>
<br><br>
<form action="AlterarExcursao-servlet" method="post">

    <label for="novoSite">Novo site: </label>
    <input type="text" name="site" id="novoSite" placeholder="Ex: http:empresa.com">

    <br>

    <label for="descricao">Nova descrição do evento:</label>
    <input type="text" name="descricao" id="descricao" placeholder="Ex: Evento de música ao vivo">

    <br>

    <label for="capacidade">Nova capacidade da excursão:</label>
    <input type="text" name="capacidade" id="capacidade" placeholder="Ex: 1500">

    <br>

    <label for="duracao">Nova duração:</label>
    <input type="text" name="duracao" id="duracao" placeholder="Ex: 15:30">

    <br>

    <label for="data-inicio">Nova data de início do evento:</label>
    <input type="text" name="data-inicio" id="data-inicio" placeholder="Formato: aaaa-mm-dd">

    <br>

    <label for="data-termino">Nova data de término da excursão:</label>
    <input type="text" name="data-termino" id="data-termino" placeholder="Formato: aaaa-mm-dd">

    <br>

    <label for="preco-total">Novo preço total:</label>
    <input type="text" name="preco-total" id="preco-total" placeholder="Ex: 34.50">

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
