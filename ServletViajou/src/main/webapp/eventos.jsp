<%--
  Created by IntelliJ IDEA.
  User: biancaclarindo-ieg
  Date: 01/11/2024
  Time: 11:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.servletviajou.DAO.EventosDAO" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Eventos</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/crud_eventos.css">
</head>
<body>
<header>
    <a href="viajouPage.jsp"><img class="logo" src="/images/logo-login-crud.svg" alt="Logo"></a>
</header>

<div class="menu">
    <ul>
        <li id="item1">
            <a href="${pageContext.request.conextPath}/membros.jsp">
                <img src="/images/icone-user-crud.svg" alt="Ícone de Usuários">
                <p>Usuários</p>
            </a>
        </li>
        <li id="item2">
            <a href="${pageContext.request.conextPath}/eventos.jsp">
                <img src="/images/icone-eventos-crud.svg" alt="Ícone de Eventos">
                <p>Eventos</p>
            </a>
        </li>
        <li id="item3">
            <a href="${pageContext.request.conextPath}/planos.jsp">
                <img src="/images/icone-panos-crud.svg" alt="Ícone de Planos">
                <p>Planos</p>
            </a>
        </li>
        <li id="item4">
            <a href="${pageContext.request.conextPath}/excursao.jsp">
                <img src="/images/icone-excursao-crud.svg" alt="Ícone de Excursões">
                <p>Excursões</p>
            </a>
        </li>
        <li id="item5">
            <a href="${pageContext.request.conextPath}/tourVitual.jsp">
                <img src="/images/icone-viagemVirtual-crud.svg" alt="Ícone de Viagem Virtual">
                <p>Viagem virtual</p>
            </a>
        </li>
    </ul>
</div>

<div class="cont_menu">
    <div class="titulo_tab">
        <div class="lado_esquerdo">
            <h1>Eventos</h1>
            <div class="adicionar">
                <button>
                    <a href="#novouser">Adicionar</a>
                </button>
            </div>
        </div>
        <div class="adicionar">
            <fieldset>
                <legend>Buscar</legend>
                <input class="buscar" type="text">
            </fieldset>
        </div>
    </div>
</div>


<div class="tabela">
    <%
        EventosDAO eventosDAO = new EventosDAO(); // instanciando eventosDAO
        ResultSet buscar = eventosDAO.buscar(); // busca os eventos

        try {
            while (buscar.next()){
                //apresenta os resultados


    %>
    <div class="bloco">
        <img src="/images/img-exursao-crud-temp.svg" alt="Imagem de Excursão">
        <div class="texto">
            <h5><%=buscar.getString("nome")%></h5> <!--nome do evento -->
            <p><%=buscar.getDate("data")%></p>
        </div>
        <div class="botoes">
            <a href="${pageContext.request.conextPath}/alterarEvento.jsp">
                <img src="/images/botao-editar-eventos.svg" alt="Botão Editar">
            </a>
            <a href="${pageContext.request.conextPath}/DeletarEvento.jsp">
                <img src="/images/excluir-crud-eventos.svg" alt="Botão Excluir">
            </a>
        </div>
    </div>

    <%
          } // fim do while
        } catch (SQLException sqle){
            //tratamento de exceções
            sqle.printStackTrace(); // imprime o erro
        }
    %>
</div>
</body>
</html>
