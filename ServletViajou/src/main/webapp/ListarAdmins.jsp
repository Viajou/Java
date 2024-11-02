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
    <link rel="shortcut icon" type="imagex/svg" href="images/icone-viajou.svg">
    <title>Crud</title>
    <link rel="stylesheet" href="Cascanding-styles-sheets/crud.css">
</head>
<body>
<header>
    <img src="images/Viajou logo pequena.svg" alt="Viajou Logo" id="Viajou-logo">
</header>
<aside>
    <nav>
        <ul>
            <li><a href="#"><img src="images/icone-user-crud.svg" alt="">Admin</a></li>
            <li><a href="#"><img src="images/icone-eventos-crud.svg" alt="">Eventos</a></li>
            <li><a href="#"><img src="images/icone-panos-crud.svg" alt="">Planos</a></li>
            <li><a href="#"><img src="images/icone-excursao-crud.svg" alt="">Excursão</a></li>
            <li><a href="#"><img src="images/icone-eventos-crud.svg" alt="">Atração</a></li>
            <li><a href="#"><img src="images/icone-viagemVirtual-crud.svg" alt="">Tour Virtual</a></li>
        </ul>
    </nav>
</aside>
<main>
    <h1>Membros</h1>
    <section class="table-section">
        <table>
            <thead>
            <tr>
                <th>Imagem</th>
                <th>ID</th>
                <th>Nome</th>
                <th>Email</th>
                <th>Opções</th>
            </tr>
            </thead>

            <a href=InserirAdmin.jsp>
                <button>
                    Inserir Admin
                </button>
            </a>
            <a href="AlterarAdmin.jsp">
                <button>
                    Alterar admin
                </button>
            </a>
            <tbody>
            <%
                AdminDAO adminDAO = new AdminDAO();
                ResultSet busca = adminDAO.buscar();

                try {
                    while ((busca.next())) {
            %>
            <tr>
                <td><img class="img" src="<%= busca.getString("url_imagem")%>" alt="Foto de Perfil"></td>
                <td><%= busca.getInt("id") %></td>
                <td><%= busca.getString("nome") %></td>
                <td><%= busca.getString("email") %></td>
            </tr>
            <%
                    }
                } catch (SQLException sqle) {
                    sqle.getMessage();
                }
            %>
            </tbody>
        </table>
    </section>
</main>
</body>
</html>
