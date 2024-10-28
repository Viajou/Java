package com.example.servletviajou.Model;

import java.util.Date;

public class Admin {
    // Declarando os atributos
    private int id;
    private String nome;
    private String email;
    private String senha;
    private String urlImagem;
    private Date dataCriacao;
    private Date dataAtualizacao;

// Métodos Construtores

    // Construtor com todos os atributos da classe, exceto o ID por ser serial
    public Admin(String nome, String email, String senha, String urlImagem, Date dataCriacao) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.urlImagem = urlImagem;
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


    // UrlImagem
    public String getUrlImagem() { return this.urlImagem; }

    public void setUrlImagem(String urlImagem) { this.urlImagem = urlImagem; }

    // DataCriacao
    public Date getDataCriacao() { return this.dataCriacao; }

    // DataAtualizacao
    public Date getDataAtualizacao() { return dataAtualizacao; }

    public void setDataAtualizacao(Date dataAtualizacao) { this.dataAtualizacao = dataAtualizacao; }

    // Método toString
    public String toString() {
        return "Nome: " + this.nome +
                "\nEmail:" + this.email +
                "\nSenha: " + this.senha +
                "\nURL da imagem: " + this.urlImagem +
                "\nData de criação do admin: "+ this.dataCriacao +
                "\nData da última atualização: "+ this.dataAtualizacao;
    }
}
