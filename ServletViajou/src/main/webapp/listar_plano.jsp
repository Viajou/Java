<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="com.example.servletviajou.DAO.AdminDAO" %>
<%@ page import="com.example.servletviajou.DAO.PlanoDAO" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" type="imagex/svg" href="images/icone-viajou.svg">
    <title>Listar Admins</title>
    <link rel="stylesheet" href="CSS/crud.css">
</head>
<body>
<header>
    <img src="images/Viajou logo pequena.svg" alt="Viajou Logo" id="Viajou-logo">
</header>
<aside>
    <nav>
        <ul>
            <li><a href="listar_admin.jsp"><img src="images/icone-user-crud.svg" alt="">Admin</a></li>
            <li><a href="#"><img src="images/icone-eventos-crud.svg" alt="">Eventos</a></li>
            <li><a href="listar_plano.jsp"><img src="images/icone-panos-crud.svg" alt="">Planos</a></li>
            <li><a href="#"><img src="images/icone-excursao-crud.svg" alt="">Excursão</a></li>
            <li><a href="listar_atracao.jsp"><img src="images/icone-eventos-crud.svg" alt="">Atração</a></li>
            <li><a href="#"><img src="images/icone-viagemVirtual-crud.svg" alt="">Tour Virtual</a></li>
        </ul>
    </nav>
</aside>
<main>
    <h1>Planos</h1>

    <div class="button-group">

        <a href="inserir_plano.jsp">
            <button class="inserir">Adicionar</button>
        </a>

        <form action=buscarPlano-servlet method="get" class="search-form">
            <input type="text" name="search" placeholder="Buscar admin..." required>
            <button type="submit">Buscar</button>
        </form>
        <a href="listar_admin.jsp"> <!-- Substitua "listar_admin.jsp" pela URL da sua página de listagem -->
            <button class="all">All</button>
        </a>


    </div>



    <section class="table-section">
        <table>
            <thead>
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Descricao</th>
                <th>Livre propagarnda</th>
                <th>Preço</th>
                <th>Criação</th>
                <th>Atualização</th>
                <th>Opções</th>
            </tr>
            </thead>
            <tbody>
            <%
                ResultSet busca = (ResultSet) request.getAttribute("resultados");
                if (busca == null) {
                    PlanoDAO planoDAO = new PlanoDAO();
                    busca = planoDAO.buscar();
                }
            %>
            <%
                try {
                    while (busca.next()) {
                        int planoId = busca.getInt("id");
            %>
            <tr>
                <td><%= planoId %></td>
                <td><%= busca.getString("nome") %></td>
                <td><%= busca.getString("descricao") %></td>
                <td><%= busca.getBoolean("livre_propaganda") %></td>
                <td><%= busca.getDouble("preco") %></td>
                <td><%= busca.getString("duracao") %></td>
                <td><%= busca.getString("data_criacao") %></td>
                <td><%= busca.getString("data_atualizacao") %></td>
                <td>
<%--                    <a href="alterar_admin.jsp?id=<%= planoId %>">--%>
<%--                        <button class="alterar">--%>
<%--                            <img src="images/lapis.svg" alt=""></img>--%>
<%--                        </button>--%>
<%--                    </a>--%>
                    <a href="deletar_plano.jsp?id=<%= planoId %>" onclick="return confirm('Tem certeza que deseja deletar este admin?')">
                        <button class="deletar">
                            <img src="images/lixeira.svg" alt=""></img>
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
</main>
</body>
</html>
