<!DOCTYPE html>
<html>
  <head>
    <title>Formulario de Login</title>
    <link rel="stylesheet" href="CSS/style.css">
  </head>
  <body>
  <div id="fundo">
      <div id="ImagemLogin">
        <img src="<%= request.getContextPath() %>/images/ImagemLogin.svg" alt="">
      </div>
      <div id="formulario">
          <form action="LoginServlet" id="meuFormulario" method="post">
              <label for="email">Email:</label>
              <input type="email" id="email" name="email" placeholder="Exemplo: user@gmail.com" required>

              <label for="senha">Senha:</label>
              <input type="password" id="senha" name="senha" required>

              <%-- Exibe a mensagem de erro, se estiver presente --%>
              <% String errorMessage = (String) request.getAttribute("errorMessage"); %>
              <% if (errorMessage != null) { %>
              <p style="color:red; font-family: LevenimBold; margin-right: auto"><%= errorMessage %></p>
              <% } %>


              <button type="submit">Entrar</button>
          </form>
      </div>
    </div>
  </body>
</html>
