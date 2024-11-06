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
    <link rel="stylesheet" href="CSS/Alterar.css">
    <link rel="stylesheet" href="CSS/crud.css">
    <link rel="stylesheet" href="CSS/encontrado.css">

</head>
<body>
<header>
    <img src="images/Viajou logo pequena.svg" alt="Viajou Logo" id="Viajou-logo">
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
            <li><a href="https://area-restrita-main.onrender.com"><img src="images/cadeado.svg" alt="">Área Restrita</a></li>        </ul>
    </nav>
</aside>

<h1>Alterar excursão</h1>

<div class="fundo">
    <div class="formulario">

        <form action="listar_atracao.jsp" method="post">

            <h2>Atual</h2>

            <div class="campo">
                <label for="nome">Nome: </label>
                <input type="text" id="nome" name="nome" disabled value="<%= request.getParameter("nome")%>">
            </div>

            <div class="campo">
                <label for="site">Site: </label>
                <input type="text" id="site" name="site"  disabled value="<%= request.getParameter("site")%>">
            </div>

            <br>

            <div class="campo">
                <label for="capacidade">Capacidade da excursão:</label>
                <input type="text" id="capacidade" name="capacidade" disabled value="<%= request.getParameter("capacidade")%>">
            </div>

            <br>

            <div class="campo">
                <label for="duracao">Duração:</label>
                <input type="text" id="duracao" name="duracao"  disabled value="<%= request.getParameter("duracao")%>">
            </div>

            <br>

            <div class="campo">
                <label for="inicio">Data de início do evento:</label>
                <input type="text" id="inicio" name="inicio"  disabled value="<%= request.getParameter("data_inicio")%>" >
            </div>

            <br>

            <div class="campo">
                <label for="termino">Data de término da excursão:</label>
                <input type="text" id="termino" name="termino" disabled value="<%= request.getParameter("data_termino")%>">
            </div>

            <br>

            <div class="campo">
                <label for="preco">Preço total:</label>
                <input type="text" id="preco" name="preco"  disabled value="<%= request.getParameter("preco_total")%>">
            </div>

            <br>

            <div class="campo">
                <label for="atualizacao">Data de atualização:</label>
                <input type="text" id="atualizacao" name="tualizacao" disabled value="<%= request.getParameter("data_atualizacao")%>">
            </div>

            <div class="botoes">
                <button>
                    <a href="listar_excursao.jsp">Voltar</a>
                </button>
            </div>
        </form>

        <form action="AlterarExcursao-servlet" method="post">

            <h2>Novo</h2>

            <div class="campo">
                <label for="novo_nome">Novo nome:</label>
                <input type="text" name="novo_nome" id="novo_nome" placeholder="trilha em...">
            </div>

            <div class="campo">
                <label for="novoSite">Novo site: </label>
                <input type="text" name="site" id="novoSite" placeholder="Ex: http:empresa.com">
            </div>

            <br>

            <div class="campo">
                <label for="nova_capacidade">Nova capacidade da excursão:</label>
                <input type="text" name="capacidade" id="nova_capacidade" placeholder="Ex: 1500">
            </div>

            <br>

            <div class="campo">
                <label for="nova_duracao">Nova duração:</label>
                <input type="text" name="nova_duracao" id="nova_duracao" placeholder="Ex: 15:30">
            </div>

            <br>

            <div class="campo">
                <label for="data-inicio">Nova data de início do evento:</label>
                <input type="text" name="data-inicio" id="data-inicio" placeholder="Formato: aaaa-mm-dd">
            </div>

            <br>

            <div class="campo">
                <label for="data-termino">Nova data de término da excursão:</label>
                <input type="text" name="data-termino" id="data-termino" placeholder="Formato: aaaa-mm-dd">
            </div>

            <br>

            <div class="campo">
                <label for="preco-total">Novo preço total:</label>
                <input type="text" name="preco-total" id="preco-total" placeholder="Ex: 34.50">
            </div>

            <br>

            <div class="campo">
                <label for="data-atualizacao">Data de atualização:</label>
                <input type="text" name="data-atualizacao" id="data-atualizacao" placeholder="Ex: 76">
            </div>

            <div class="botoes">
                <input type="submit" value="Alterar">
            </div>
        </form>
    </div>
</div>

<br><br>
<a href="listar_excursao.jsp">
    <button>Voltar</button>
</a>
</body>
</html>
