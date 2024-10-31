<!DOCTYPE html>
<html>
<head>
  <title>Formulário de Login</title>
  <link rel="stylesheet" href="Cascanding-styles-sheets/style.css">
</head>
<body>

<div id="fundo">
  <div id="ImagemLogin">
    <img src="<%= request.getContextPath() %>/images/ImagemLogin.svg" alt="">
  </div>
  <div id="formulario">
    <form action="<%= request.getContextPath() %>/LoginServlet" id="meuFormulario" method="post">
      <label for="email">Email:</label>
      <input type="email" id="email" name="email" placeholder="Exemplo: user@gmail.com" required>

      <label for="senha">Senha:</label>
      <input type="password" id="senha" name="senha" required>

      <button type="submit">Entrar</button>
    </form>
  </div>
</div>

</body>
</html>
