<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="com.example.servletviajou.DAO.TourVirtualDAO" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" type="imagex/svg" href="images/icone-viajou.svg">
    <title>Listar Tour Virtual</title>
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
<<<<<<< HEAD
            <li><a href="listar_tour_virtual.jsp"><img src="images/icone-viagemVirtual-crud.svg" alt="">Tour Virtual</a></li>
            <li><a href="https://area-restrita-dev.onrender.com/index.html">Área Restrita</a></li>
=======
            <li><a href="#"><img src="images/icone-viagemVirtual-crud.svg" alt="">Tour Virtual</a></li>
            <li><a href="https://area-restrita-main.onrender.com">Área Restrita</a></li>
>>>>>>> 3cd3279e2dee16e870fbb2aaf9c7d7dbfc543262
        </ul>
    </nav>
</aside>
<main>
    <h1>Tours Virtuais</h1>

    <div class="button-group">

        <a href="inserir_tour_virtual.jsp">
            <button class="inserir">Adicionar</button>
        </a>

        <form action=BuscarTourVirtual-servlet method="get" class="search-form">
            <input type="text" name="search" placeholder="Buscar tour..." required>
            <button type="submit">Buscar</button>
        </form>
        <a href="listar_tour_virtual.jsp"> <!-- Substitua "listar_admin.jsp" pela URL da sua página de listagem -->
            <button class="all">All</button>
        </a>
    </div>


    <%
        // Verifica se naoEncontrado não é nulo
        String naoEncontrado = (String) request.getAttribute("naoEncontrado");
        if (naoEncontrado == null) {
    %>
    <section class="table-section">
        <table>
            <thead>
            <tr>
                <th>ID</th>
                <th>Descricao</th>
                <th>URL do vídeo</th>
                <th>Média classificações</th>
                <th>Qnt classificações</th>
                <th>Preco</th>
                <th>ID atração</th>
                <th>ID figurinha</th>
                <th>Criação</th>
                <th>Atualização</th>
                <th>Opções</th>
            </tr>
            </thead>
            <tbody>
            <%
                ResultSet busca = (ResultSet) request.getAttribute("resultados");
                if (busca == null) {
                    TourVirtualDAO tourDAO = new TourVirtualDAO();
                    busca = tourDAO.buscar();
                }
            %>
            <%
                try {
                    while (busca.next()) {
                        int tourId = busca.getInt("id");
            %>
            <tr>
                <td><%= tourId %></td>
                <td><%= busca.getString("descricao") %></td>
                <td><%= busca.getString("video") %></td>
                <td><%= busca.getDouble("media_classificacao") %></td>
                <td><%= busca.getInt("qnt_classificacao") %></td>
                <td><%= busca.getString("preco") %></td>
                <td><%= busca.getInt("id_atracao") %></td>
                <td><%= busca.getInt("id_figurinhas") %></td>
                <td><%= busca.getDate("data_criacao") %></td>
                <td><%= busca.getDate("data_atualizacao") %></td>
                <td>
                    <a href="alterar_tour_virtual.jsp?id=<%= busca.getInt("id") %>&descricao=<%=busca.getString("descricao")%>&video=<%=busca.getString("video")%>&media_classificacao=<%= busca.getDouble("media_classificacao")%>&qnt_classificacao=<%= busca.getInt("qnt_classificacao") %>&preco=<%= busca.getString("preco") %>&id_atracao=<%= busca.getInt("id_atracao")%>&id_figurinhas=<%=busca.getInt("id_figurinhas")%>">
                        <button class="deletar">
                            <img src="images/lapis.svg" alt="">
                        </button>
                    </a>
                    <a href="DeletarTourVirtual-servlet?id=<%= tourId %>" onclick="return confirm('Tem certeza que deseja deletar este tour virtual?')">
                        <button class="deletar">
                            <img src="images/lixeira.svg" alt="">
                        </button>
                    </a>
                </td>
            </tr>
            <%
                    }
                } catch (SQLException sqle) {
                    sqle.printStackTrace();
                }
            %>
            </tbody>
        </table>
    </section>
    <%
    } else {
    %>
    <p class="naoEncontrado"><%= request.getAttribute("naoEncontrado")%></p>
    <%
        }
    %>
</main>
</body>
</html>
