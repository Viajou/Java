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
  <title>Buscar Admin por ID</title>
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
  <h1>Buscar Admin por ID</h1>
  <form action="BuscarAdminPorIdServlet" method="get">
    <label for="id">ID do Admin:</label>
    <input type="text" id="id" name="id" required>
    <button type="submit">Buscar</button>
  </form>

  <section class="table-section">
    <table>
      <thead>
      <tr>
        <th>Imagem</th>
        <th>ID</th>
        <th>Nome</th>
        <th>Email</th>
        <th>Data criação</th>
        <th>Data Atualização</th>
      </tr>
      </thead>
      <tbody>
  <%
    String idStr = request.getAttribute("id") != null ? request.getAttribute("id").toString() : null;
    ResultSet busca = (ResultSet) request.getAttribute("resultadoBusca");

    if (busca != null) {
      if (busca.next()) {
  %>
  <h2>Resultados da Busca</h2>
  <tr>
    <td><img class="img" src="<%= busca.getString("url_imagem") %>" alt="Foto de Perfil"></td>
    <td><%= busca.getInt("id") %></td>
    <td><%= busca.getString("nome") %></td>
    <td><%= busca.getString("email") %></td>
    <td><%= busca.getString("data_criacao") %></td>
    <td><%= busca.getString("data_atualizacao") %></td>
  </tr>
  <%
  } else {
  %>
  <h2>Admin não encontrado.</h2>
  <%
      }
    }
  %>
      </tbody>
    </table>
  </section>
</main>
</body>
</html>
