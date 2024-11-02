<%--
  Created by IntelliJ IDEA.
  User: heloisamachado-ieg
  Date: 02/11/2024
  Time: 17:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Crud</title>
</head>
<body>
<h1>Inserindo plano</h1>
<form action="/InserirPlano-servlet" method="post">
    <label for="nome">Nome do plano: </label>
    <input type="text" name="nome" id="nome" placeholder="Ex: Systeam+">]
    <br><br>
    <label for="descricao"> descrição do plano: </label>
    <input type="text" name="descricao" id="descricao" placeholder="Ex: Plano anual">
    <br><br>
    <label for="livre_propaganda"> Livre de propaganda?</label>
    <input type="text" name="livre_propaganda" id="livre_propaganda" placeholder="Ex: true/false">
    <br><br>
    <label for="preco">Preço do plano: </label>
    <input type="text" name="preco" id="preco" placeholder="Ex: 53,89">
    <br><br>
    <label for="duracao">Duração do plano</label>
    <input type="text" name="duracao" id="duracao" placeholder="Ex: 6 meses">
    <br><br>
    <input type="submit" value="Inserir plano">
</form>
</body>
</html>
