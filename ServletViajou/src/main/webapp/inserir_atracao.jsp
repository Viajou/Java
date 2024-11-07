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
    <link rel="stylesheet" href="CSS/inserir2.css">
</head>
<body>

<header>
    <img src="images/Viajou logo pequena.svg" alt="Viajou Logo" id="viajou-logo">
    <%
        // Recupera a URL da imagem e nome do admin armazenados na sessão
        HttpSession sessao = request.getSession();
        String urlImagem = (String) sessao.getAttribute("urlImagem");
        String nomeAdmin = (String) sessao.getAttribute("nomeAdmin");
    %>

    <!-- Adiciona a imagem do admin logado, se existir -->
    <div class="usuario">
        <img src="<%= urlImagem %>" alt="" class="admin-image">
        <h3 class="admin-name"><%= nomeAdmin %></h3>
    </div>
</header>

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
        <div class="form-container">
            <label for="nome">Nome da atração: </label>
            <input class="entrada" type="text" name="nome" id="nome" placeholder="Ex:Catavento" required>

            <label for="descricao">Descrição da atração: </label>
            <input class="entrada" type="text" name="descricao" id="descricao" placeholder="Ex:Museu" required>

            <label for="endereco">Endereço da atração: </label>
            <input class="entrada" type="text" name="endereco" id="endereco" placeholder="Ex: Av.Getulio vagas" required>

            <label>Acessibilidade da atração: </label>
            <label>
                <input class="entrada" type="radio" name="acessibilidade" value="true" required> Sim
            </label>

            <label>
                <input class="entrada" type="radio" name="acessibilidade" value="false" required> Não
            </label>

            <label for="categoria">Categoria da atração: </label>
            <input class="entrada" type="text" name="categoria" id="categoria" placeholder="Ex: Exposições" required>

        </div>
        <div class="botoes2">
            <a  class="voltar" href="listar_atracao.jsp">Voltar</a>
            <input class="entrada" type="submit" value="Inserir tour">
        </div>
    </form>
</body>
</html>
