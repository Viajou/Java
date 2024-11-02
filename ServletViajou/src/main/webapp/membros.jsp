<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.servletviajou.Model.Admin" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="shortcut icon" type="image/svg+xml" href="images/icone-viajou.svg">
        <title>Crud</title>
        <link rel="stylesheet" href="crud.css">
    </head>
    <body>
        <header>
            <img src="images/Viajou logo pequena.svg" alt="" id="Viajou-logo">
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
                    <tbody>
                    <%
                        List<Admin> membros = (List<Admin>) request.getAttribute("membros");
                        for (Admin membro : membros) {
                    %>
                    <tr>
                        <td><div class="img"></div></td>
                        <td><%= membro.getId() %></td>
                        <td><%= membro.getNome() %></td>
                        <td><%= membro.getEmail() %></td>
                        <td id="opcoes">
                            <img src="/images/lapis.svg" alt="">
                            <img src="/images/lixo.svg" alt="">
                        </td>
                    </tr>
                    <%
                        }
                    %>
                    </tbody>
                </table>
            </section>
        </main>
    </body>
</html>
