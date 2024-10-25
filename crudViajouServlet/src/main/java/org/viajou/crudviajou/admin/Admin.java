package org.viajou.crudviajou.admin;

public class Admin {
    // Declarando os atributos
    private int id;
    private String nome;
    private String email;
    private String senha;
    private String urlImagem;

// Métodos Construtores

    // Construtor com todos os atributos da classe, exceto o ID por ser serial
    public Admin(String nome, String email, String senha, String urlImagem) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
<<<<<<< HEAD
        this.urlImagem = url_imagem;
=======
        this.urlImagem = urlImagem;
>>>>>>> d66e4e48449120020e22a6ea0a11971a712fc0a1
    }

    // Construtor Vazio
    public Admin() {
    }

//  Métodos Getters e Setters
    // O ID não pode ser alterado, então apenas o método get é criado para acessá-lo
    public int getId() {
        return this.id;
    }

    // Nome
    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // Email
    public String getEmail() { return this.email; }

    public void setEmail(String email) {
        this.email = email;
    }

    // Senha
    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

<<<<<<< HEAD
    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
=======
    // UrlImagem
    public String getUrlImagem() {
        return this.urlImagem;
    }

    public void setUrl_imagem(String urlImagem) {
>>>>>>> d66e4e48449120020e22a6ea0a11971a712fc0a1
        this.urlImagem = urlImagem;
    }

    //     Método toString
    public String toString() {
<<<<<<< HEAD
        return "Admin.AdminTabela{" +
                "nome='" + this.nome + '\'' +
                ", email='" + this.email + '\'' +
                ", senha='" + this.senha + '\'' +
                ", url_imagem='" + this.urlImagem + '\'' +
                '}';
=======
        return "Nome: " + this.nome +
                "\nEmail:" + this.email +
                "\nSenha: " + this.senha +
                "\nURL da imagem: " + this.urlImagem;
>>>>>>> d66e4e48449120020e22a6ea0a11971a712fc0a1
    }
}
