package org.viajou.crudviajou.plano;

import java.sql.Date;

public class Plano {
    // Declarando os atributos
    private String descricao;
    private boolean livrePropaganda;
    private String nome;
    private double preco;
    private Date dataCriacao;
    private Date dataAtualizacao;

// Métodos Construtores
    // Construtor com todos os atributos da classe, exceto o ID por ser serial
    public Plano(String descricao, boolean livrePropaganda, String nome, double preco) {
        this.descricao = descricao;
        this.livrePropaganda=livrePropaganda;
        this.nome = nome;
        this.preco = preco;
    }

    // Construtor Vazio
    public Plano() {}

    // Getters e Setters
    // Descricao
    public String getDescricao() { return this.descricao; }

    public void setDescricao(String descricao) { this.descricao = descricao; }

    // LivrePropaganda
    public boolean isLivrePropaganda(){ return this.livrePropaganda; }

    public void setLivrePropaganda(boolean livrePropaganda){ this.livrePropaganda = livrePropaganda; }

    // Nome
    public String getNome() { return this.nome; }

    public void setNome(String nome) { this.nome = nome; }

    // Preco
    public double getPreco() { return this.preco; }

    public void setPreco(double preco) { this.preco = preco; }

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
                "\nData de criação: " + dataCriacao +
                "\nData da última atualizacao: " + dataAtualizacao;

    }
}
