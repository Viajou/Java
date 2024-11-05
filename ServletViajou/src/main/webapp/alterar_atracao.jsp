
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*" %>
<%@ page import="com.example.servletviajou.DAO.AdminDAO" %>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Alterar Atração</title>
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
            <li><a href="https://area-restrita-main.onrender.com"><img src="images/cadeado.svg" alt="">Área Restrita</a></li>        </ul>
    </nav>
</aside>

<h1>Alterar atração</h1>

    <div class="fundo">
        <div class="formulario">
            <form action="AlterarAtracao-servlet" method="post">

                <h2>Atual</h2>

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
            </form>


            <form action="AlterarAtracao-servlet" method="post">

                <h2>Novo</h2>

                <label for="novo_nome">Novo nome da atração: </label>
                <input type="text" name="nome" id="novo_nome" placeholder="Ex:Catavento">

                <br><br>

                <label for="nova_descricao">Nova descrição da atração: </label>
                <input type="text" name="descricao" id="Nova_descricao" placeholder="Ex:Museu">

                <br><br>

                <label for="novo_endereco">Novo endereço da atração: </label>
                <input type="text" name="endereco" id="novo_endereco" placeholder="Ex: Av.Getulio vagas">

                <br><br>

                <label for="nova_acessibilidade">Nova acessibilidade da atração: </label>
                <input type="text" name="acessibilidade" id="nova_acessibilidade" placeholder="Ex: true/false">

                <br><br>

                <label for="nova_categoria">Nova categoria da atração: </label>
                <input type="text" name="categoria" id="nova_categoria" placeholder="Ex: Exposições">
            </form>


       </div>

            <div class="botoes">
                <button>
                    <a href="listar_atracao.jsp">Voltar</a>
                </button>
                <input type="submit" value="Alterar">
            </div>
  </div>
</body>
</html>


