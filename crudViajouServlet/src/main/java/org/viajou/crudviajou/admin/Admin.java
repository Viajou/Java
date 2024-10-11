package org.viajou.crudviajou.admin;

public class Admin {
    private int id;
    private String nome;
    private String email;
    private String senha;
    private String url_imagem;

    public Admin() {
    }

    // criando o metodo construdor para ppoter iniciar o objeto junto com as variaveis.
    public Admin(String nome, String email, String senha, String url_imagem) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.url_imagem = url_imagem;
    }

    public int getId() {
        return id;
    }

    //criando os metodos get e set de todas as variaveis
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getUrl_imagem() {
        return url_imagem;
    }

    public void setUrl_imagem(String url_imagem) {
        this.url_imagem = url_imagem;
    }
    //    fazendo o toString para a saida do objeto podemos ver os valores de cada variavel
//    e não o endereo de memoria
    @Override
    public String toString() {
        return "Admin.AdminTabela{" +
                "nome='" + this.nome + '\'' +
                ", email='" + this.email + '\'' +
                ", senha='" + this.senha + '\'' +
                ", url_imagem='" + this.url_imagem + '\'' +
                '}';
    }
}
