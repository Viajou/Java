<%--
  Created by IntelliJ IDEA.
  User: brunasalla-ieg
  Date: 05/11/2024
  Time: 09:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Alterar Plano</title>
    <link rel="stylesheet" href="CSS/Alterar.css">
    <link rel="stylesheet" href="CSS/crud.css">
    <link rel="stylesheet" href="CSS/encontrado.css">
</head>
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
        <img src="<%= urlImagem %>" alt="Imagem do Admin" class="admin-image">
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
            <li><a href="https://area-restrita-dev.onrender.com/index.html">Área Restrita</a></li>
        </ul>
    </nav>
</aside>
<body>

<h1>Alterar Plano</h1>

<div class="fundo">
    <div class="formulario">
        <form class="alteracao">
            <h2>Atual</h2>
            <div class="campo">
                <label for="idAtual">Id atual</label>
                <input class="entrada" type="number" id="idAtual" name="idAtual" disabled value="<%=request.getParameter("id")%>">
            </div>
            <div class="campo">
                <label for="descricaoAtual">Descrição atual</label>
                <input class="entrada" type="text" id="descricaoAtual" name="descricaoAtual" disabled value="<%=request.getParameter("descricao")%>">
            </div>
            <div class="campo">
                <label for="LivrePropagandaAtual">Livre Propaganda</label>
                <input class="entrada" type="text" id="LivrePropagandaAtual" name="livrePropagandaAtual" disabled value="<%=request.getParameter("livrePropaganda")%>">
            </div>
            <div class="campo">
                <label for="nomeAtual">Nome atual</label>
                <input class="entrada" type="text" id="nomeAtual" name="nomeAtual" disabled value="<%request.getParameter("nome");%>">
            </div>
            <div class="campo">
                <label for="precoAtual">Preço atual</label>
                <input class="entrada" type="text" id="precoAtual" name="precoAtual" disabled value="<%request.getParameter("preco");%>">
            </div>

            <div class="botoes">
                <button>
                    <a href="listar_plano.jsp">Voltar</a>
                </button>
            </div>
        </form>

        <form method="post" action="/AlterarPlano-servlet?id=<%=request.getParameter("id")%>">
            <h2>Novo</h2>
            <div class="campo">
                <label for="novaDescricao">Nova descrição</label>
                <input class="entrada" type="text" id="novaDescricao" name="novaDescricao" placeholder="Nova descrição">
            </div>
            <div class="campo">
                <label>Livre Propaganda</label>
                <label>
                    <input class="entrada" type="radio" name="novoLivrePropaganda" value="true">Sim
                </label>
                <label>
                    <input class="entrada" type="radio" name="novoLivrePropaganda" value="true">Não
                </label>
            </div>
            <div class="campo">
                <label for="novoNome">Novo nome</label>
                <input class="entrada" type="text" id="novoNome" name="novoNome" placeholder="Novo nome">
            </div>
            <div class="campo">
                <label for="novoPreco">Novo Preço</label>
                <input class="entrada" type="text" id="novoPreco" name="novoPreco" placeholder="Novo preço">
            </div>

            <div class="botoes">
                <input type="submit" value="Alterar">
            </div>
        </form>
    </div>
</div>>

</body>
</html>
