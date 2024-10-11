package org.viajou.crudviajou.plano;

import java.sql.Date;

public class Plano {
    private String descricao;
    private boolean livrePropaganda;
    private String nome;
    private double preco;
    private Date dataCriacao;
    private Date dataAtualizacao;


    // Métodos Construtores
    public Plano(){

    }

    public Plano(String descricao, boolean livrePropaganda, String nome, double preco, Date dataCriacao, Date dataAtualizacao) {
        this.descricao = descricao;
        this.livrePropaganda=livrePropaganda;
        this.nome = nome;
        this.preco = preco;
        this.dataCriacao = dataCriacao;
        this.dataAtualizacao = dataAtualizacao;
    }

    // Getters e Setters
    // descricao
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    // livrePropaganda
    public boolean getLivrePropaganda(){
        return livrePropaganda;
    }
    public void setLivrePropaganda(boolean livrePropaganda){
        this.livrePropaganda=livrePropaganda;
    }

    // nome
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    // preco
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }

    // dataCriacao
    public Date getDataCriacao() {
        return dataCriacao;
    }
    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    // dataAtualizacao
    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }
    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    @Override
    public String toString() {
        if (livrePropaganda){
            return "Descrição: " + descricao +
                    "\nPlano é livre de propagandas? Sim" +
                    "\nNome: " + nome +
                    "\nPreço: " + preco +
                    "\nData de criação: " + dataCriacao +
                    "\nData da última atualizacao: " + dataAtualizacao;
        }
        else {
            return "Descrição: " + descricao +
                    "\nPlano é livre de propagandas? Não" +
                    "\nNome: " + nome +
                    "\nPreço: " + preco +
                    "\nData de criação: " + dataCriacao +
                    "\nData da última atualizacao: " + dataAtualizacao;
        }
    }
}
