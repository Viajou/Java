<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="com.example.servletviajou.DAO.AdminDAO" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" type="image/svg+xml" href="images/icone-viajou.svg">
    <title>Listar Admins</title>
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
            <li><a href="#"><img src="images/icone-eventos-crud.svg" alt="">Eventos</a></li>
            <li><a href="listar_plano.jsp"><img src="images/icone-panos-crud.svg" alt="">Planos</a></li>
            <li><a href="#"><img src="images/icone-excursao-crud.svg" alt="">Excursão</a></li>
            <li><a href="listar_atracao.jsp"><img src="images/icone-eventos-crud.svg" alt="">Atração</a></li>
            <li><a href="#"><img src="images/icone-viagemVirtual-crud.svg" alt="">Tour Virtual</a></li>
            <li><a href="https://area-restrita-dev.onrender.com/index.html">Área Restrita</a></li>
        </ul>
    </nav>
</aside>
<main>
    <h1>Administradores</h1>

    <div class="button-group">
        <a href="inserir_admin.jsp">
            <button class="inserir">Adicionar</button>
        </a>

        <form action="BuscarAdminPorIdServlet" method="get" class="search-form">
            <input type="text" name="search" placeholder="Buscar admin..." required>
            <button type="submit">Buscar</button>
        </form>
        <a href="listar_admin.jsp">
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
                <th>Imagem</th>
                <th>ID</th>
                <th>Nome</th>
                <th>Email</th>
                <th>Criação</th>
                <th>Atualização</th>
                <th>Opções</th>
            </tr>
            </thead>
            <tbody>
            <%
                ResultSet busca = (ResultSet) request.getAttribute("resultados");
                if (busca == null) {
                    AdminDAO adminDAO = new AdminDAO();
                    busca = adminDAO.buscar();
                }
            %>
            <%
                try {
                    while (busca.next()) {
                        int adminId = busca.getInt("id");
            %>
            <tr>
                <td><img class="img" src="<%= busca.getString("url_imagem") %>" alt="Foto de Perfil"></td>
                <td><%= adminId %></td>
                <td><%= busca.getString("nome") %></td>
                <td><%= busca.getString("email") %></td>
                <td><%= busca.getString("data_criacao") %></td>
                <td><%= busca.getString("data_atualizacao") %></td>
                <td>
                    <a href="alterar_admin.jsp?id=<%= adminId %>">
                        <button class="alterar">
                            <img src="images/lapis.svg" alt="">
                        </button>
                    </a>
                    <a href="DeletarAdminServlet?id=<%= adminId %>" onclick="return confirm('Tem certeza que deseja deletar este admin?')">
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
