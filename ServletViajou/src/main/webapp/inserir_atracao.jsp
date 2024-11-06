<%--
  Created by IntelliJ IDEA.
  User: heloisamachado-ieg
  Date: 02/11/2024
  Time: 21:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inserir atração</title>
    <link rel="stylesheet" href="CSS/crud.css">
    <link rel="stylesheet" href="CSS/Inserir.css">
</head>
<body>

<aside>
    <nav>
        <ul>
            <li><a href="listar_admin.jsp"><img src="images/icone-user-crud.svg" alt="">Admin</a></li>
            <li><a href="listar_eventos.jsp"><img src="images/icone-eventos-crud.svg" alt="">Eventos</a></li>
            <li><a href="listar_plano.jsp"><img src="images/icone-panos-crud.svg" alt="">Planos</a></li>
            <li><a href="listar_excursao.jsp"><img src="images/icone-excursao-crud.svg" alt="">Excursão</a></li>
            <li><a href="listar_atracao.jsp"><img src="images/icone-eventos-crud.svg" alt="">Atração</a></li>
            <li><a href="listar_tour_virtual.jsp"><img src="images/icone-viagemVirtual-crud.svg" alt="">Tour Virtual</a></li>
            <li><a href="https://area-restrita-main.onrender.com"><img src="images/cadeado.svg" alt="">Área Restrita</a></li>            </ul>
    </nav>
</aside>

<h1>Inserir atração</h1>
    <form action="InserirAtracao-servlet" method="post">
        <label for="nome">Nome da atração: </label>
        <input type="text" name="nome" id="nome" placeholder="Ex:Catavento">
        <br><br>
        <label for="descricao">Descrição da atração: </label>
        <input type="text" name="descricao" id="descricao" placeholder="Ex:Museu">
        <br><br>
        <label for="endereco">Endereço da atração: </label>
        <input type="text" name="endereco" id="endereco" placeholder="Ex: Av.Getulio vagas">
        <br><br>
        <label for="acessibilidade">Acessibilidade da atração: </label>
        <input type="text" name="acessibilidade" id="acessibilidade" placeholder="Ex: true/false">
        <br><br>
        <label for="categoria">Categoria da atração: </label>
        <input type="text" name="categoria" id="categoria" placeholder="Ex: Exposições">
        <br>
        <input type="submit" value="Inserir atração">
    </form>
</body>
</html>
