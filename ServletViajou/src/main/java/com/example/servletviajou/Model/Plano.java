package com.example.servletviajou.Model;

import java.sql.Date;

public class Plano {
    // Declarando os atributos
    private String descricao;
    private boolean livrePropaganda;
    private String nome;
    private String preco;
    private String duracao;
    private Date dataCriacao;
    private Date dataAtualizacao;

// Métodos Construtores
    // Construtor com todos os atributos da classe, exceto o ID por ser serial
    public Plano(String nome, String descricao, boolean livrePropaganda, String preco, String duracao) {
        this.descricao = descricao;
        this.livrePropaganda= livrePropaganda;
        this.nome = nome;
        this.preco = preco;
        this.duracao = duracao;
    }

    // Construtor Vazio
    public Plano() {}

    // Getters e Setters
    // Descricao
    public String getDescricao() { return this.descricao; }

    public void setDescricao(String descricao) { this.descricao = descricao; }

    // LivrePropaganda
    public boolean getLivrePropaganda(){ return this.livrePropaganda; }

    public void setLivrePropaganda(boolean livrePropaganda) {
        this.livrePropaganda = livrePropaganda;
    }

    // Nome
    public String getNome() { return this.nome; }

    public void setNome(String nome) { this.nome = nome; }

    // Preco
    public String getPreco() { return this.preco; }

    public void setPreco(String preco) { this.preco = preco; }

    // Duracao
    public String getDuracao() { return this.duracao; }

    public void setDuracao(String duracao) { this.duracao = duracao; }

    // DataCriacao
    public Date getDataCriacao() { return this.dataCriacao; }

    // DataAtualizacao
    public Date getDataAtualizacao() { return this.dataAtualizacao; }

    public void setDataAtualizacao(Date dataAtualizacao) { this.dataAtualizacao = dataAtualizacao; }

    // Método toString
    public String toString() {
        return "Descrição: " + descricao +
                "\nPlano é livre de propagandas?: "+ livrePropaganda +
                "\nNome: " + nome +
                "\nPreço: " + preco +
                "\nDuração: " + duracao +
                "\nData de criação: " + dataCriacao +
                "\nData da última atualizacao: " + dataAtualizacao;

    }
}
