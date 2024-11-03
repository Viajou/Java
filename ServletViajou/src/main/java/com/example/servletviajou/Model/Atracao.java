package com.example.servletviajou.Model;

import java.util.Date;

public class Atracao {
    // Declarando os atributos
    private int id;
    private String descricao;
    private String nome;
    private String endereco;
    private boolean acessibilidade;
    private String categoria;
    private Date dataCriacao;
    private Date dataAtualizacao;

    // Construtor com todos os atributos da classe, exceto o ID por ser serial
    public Atracao(String descricao, String nome, String endereco, boolean acessibilidade, String categoria) {
        this.descricao = descricao;
        this.nome = nome;
        this.endereco = endereco;
        this.acessibilidade = acessibilidade;
        this.categoria = categoria;
    }

    // Construtor Vazio
    public Atracao() {
    }

//  Métodos Getters e Setters
    // O ID não pode ser alterado, então apenas o método get é criado para acessá-lo
    public int getId() { return this.id; }

    // Descricao
    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    // Nome
    public String getNome() { return this.nome; }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // Endereco
    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    // Acessibilidade
    public boolean getAcessibilidade() {
        return this.acessibilidade;
    }

    public void setAcessibilidade(boolean acessibilidade) {
        this.acessibilidade = acessibilidade;
    }

    // Categoria
    public String getCategoria() {
        return this.categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    // DataCriacao
    public Date getDataCriacao() { return this.dataCriacao; }

    // DataAtualizacao
    public Date getDataAtualizacao() { return this.dataAtualizacao; }

    public void setDataAtualizacao(Date dataAtualizacao) { this.dataAtualizacao = dataAtualizacao; }

    //  Método toString
    public String toString() {
        return "Descrição: " + this.descricao +
                "\nNome: " + this.nome +
                "\nEndereco: " + this.endereco +
                "\nÉ acessivel? " + this.acessibilidade +
                "\nCategoria: " + this.categoria +
                "\nData de criação da atração: " + this.dataCriacao +
                "\nData da última atualização: " + this.dataAtualizacao;
    }
}
