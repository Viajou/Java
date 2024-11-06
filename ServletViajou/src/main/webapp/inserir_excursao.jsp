<%--
  Created by IntelliJ IDEA.
  User: biancaclarindo-ieg
  Date: 03/11/2024
  Time: 19:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inserir atraçaõ</title>
    <link rel="stylesheet" href="CSS/crud.css">
    <link rel="stylesheet" href="CSS/inserir2.css">
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
            <li><a href="https://area-restrita-dev.onrender.com/index.html">Área Restrita</a></li>

        </ul>
    </nav>
</aside>
<h1>Inserir excursao</h1>
<form action="InserirAtracao-servlet" method="post">

    <div class="form-container">
        <label for="nome">Nome da excursao: </label>
        <input type="text" name="nome" id="nome" placeholder="Ex:Catavento">

        <label for="nome_empresa">Nome da empresa: </label>
        <input type="text" name="descricao" id="nome_empresa" placeholder="Ex:Museu">

        <label for="site">Site da empresa: </label>
        <input type="text" name="endereco" id="site" placeholder="Ex: Av.Getulio vagas">

        <label for="capacidade">Capacidade: </label>
        <input type="text" name="acessibilidade" id="capacidade" placeholder="Ex: true/false">

        <label for="duracao">duração:</label>
        <input type="text" name="categoria" id="duracao" placeholder="Ex: Exposições">

        <label for="preco">Preço:</label>
        <input type="text" name="categoria" id="preco" placeholder="Ex: Exposições">

        <label for="data_inicio">Data de Inicio:</label>
        <input type="text" name="categoria" id="data_inicio" placeholder="Ex: Exposições">

        <label for="data_termino">Data de término:</label>
        <input type="text" name="categoria" id="data_termino" placeholder="Ex: Exposições">
    </div>


    <div class="botoes2">
        <a  class="voltar" href="listar_tour_virtual.jsp">Voltar</a>
        <input type="submit" value="Inserir tour">
    </div>
</form>
</body>
</html>
