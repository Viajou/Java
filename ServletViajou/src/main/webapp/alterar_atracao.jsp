
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
            <form >

                <h2>Atual</h2>
                <div class="campo">
                    <label for="id">Acessibilidade da atração: </label>
                    <input class="entrada" type="text" name="id" id="id" value="<%= request.getParameter("id")%>" disabled>
                </div>

                <div class="campo">
                    <label for="nome">Nome da atração: </label>
                    <input class="entrada" type="text" name="nome" id="nome" value="<%= request.getParameter("nome")%>" disabled>
                </div>

                <div class="campo">
                    <label for="descricao">Descrição da atração: </label>
                    <input class="entrada" type="text" name="descricao" id="descricao" value="<%= request.getParameter("descricao")%>" disabled>
                </div>

                <div class="campo">
                    <label for="endereco">Endereço da atração: </label>
                    <input class="entrada" type="text" name="endereco" id="endereco" value="<%= request.getParameter("endereco")%>" disabled>
                </div>


                <div class="campo">
                    <label for="acessibilidade">Acessibilidade da atração: </label>
                    <input class="entrada" type="text" name="acessibilidade" id="acessibilidade" value="<%= request.getParameter("acessibilidade")%>" disabled>
                </div>


                <div class="campo">
                    <label for="categoria">Categoria da atração: </label>
                    <input class="entrada" type="text" name="categoria" id="categoria" value="<%= request.getParameter("categoria")%>" disabled>
                </div>


                <div class="botoes">
                    <button>
                        <a href="listar_atracao.jsp">Voltar</a>
                    </button>
                </div>
            </form><!-- Fechamento do primeiro form -->


            <form action="AlterarAtracao-servlet?id=<%= request.getParameter("id")%>" method="post">

                <h2>Novo</h2>

                <div class="campo">
                    <label for="novo-nome">Novo nome da atração: </label>
                    <input class="entrada" type="text" name="novo-nome" id="novo-nome" placeholder="Ex:Catavento">
                </div>

                <div class="campo">
                    <label for="nova-descricao">Nova descrição da atração: </label>
                    <input class="entrada" type="text" name="nova-descricao" id="nova-descricao" placeholder="Ex:Museu">
                </div>

                <div class="campo">
                    <label for="novo-endereco">Novo endereço da atração: </label>
                    <input class="entrada" type="text" name="novo-endereco" id="novo-endereco" placeholder="Ex: Av.Getulio vagas">
                </div>

                <div class="campo">
                    <label>Acessibilidade</label>
                    <label>
                        <input class="entrada" type="radio" name="nova-acessibilidade" value="true">Sim
                    </label>
                    <label>
                        <input class="entrada" type="radio" name="nova-acessibilidade" value="true">Não
                    </label>
                </div>

                <div class="campo">
                    <label for="nova-categoria">Nova categoria da atração: </label>
                    <input class="entrada" type="text" name="nova-categoria" id="nova-categoria" placeholder="Ex: Exposições">
                </div>

                <div class="botoes">
                    <input type="submit" value="Alterar">
                </div>

            </form>
       </div>


  </div>
</body>
</html>


