package com.example.servletviajou.Model;

import java.util.Date;

public class TourVirtual {
    // Declarando os atributos
    private String descricao;
    private String video;
    private double mediaClassificacao;
    private int qntClassificacao;
    private double preco;
    private int idAtracao;
    private int idFigurinhas;
    private Date dataCriacao;
    private Date dataAtualizacao;

//  Métodos construtores
    // Construtor com todos os atributos da classe, exceto o ID por ser serial
    public TourVirtual(String descricao, String video, int qntClassificacao, double mediaClassificacao, double preco, int idAtracao, int idFigurinhas) {
        this.descricao = descricao;
        this.video = video;
        this.qntClassificacao = qntClassificacao;
        this.mediaClassificacao = mediaClassificacao;
        this.preco = preco;
        this.idAtracao = idAtracao;
        this.idFigurinhas = idFigurinhas;
    }

    // Construtor Vazio
    public TourVirtual() {}

//  Métodos Getters e Setters
    // Descricao
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    // Video
    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    // MediaClassificacao
    public double getMediaClassificacao() {
        return mediaClassificacao;
    }

    public void setMediaClassificacao(double mediaClassificacao) {
        this.mediaClassificacao = mediaClassificacao;
    }

    // QntClassificacao
    public int getQntClassificacao() {
        return qntClassificacao;
    }

    public void setQntClassificacao(int qntClassificacao) {
        this.qntClassificacao = qntClassificacao;
    }

    // Preco
    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    // IdAtracao
    public int getIdAtracao() {
        return idAtracao;
    }

    public void setIdAtracao(int idAtracao) {
        this.idAtracao = idAtracao;
    }

    // IdFigurinhas
    public int getIdFigurinhas() {
        return idFigurinhas;
    }

    public void setIdFigurinhas(int idFigurinhas) {
        this.idFigurinhas = idFigurinhas;
    }

    // DataCriacao
    public Date getDataCriacao() { return this.dataCriacao; }

    // DataAtualizacao
    public Date getDataAtualizacao() { return dataAtualizacao; }

    public void setDataAtualizacao(Date dataAtualizacao) { this.dataAtualizacao = dataAtualizacao; }

    // Método toString
    public String toString() {
        return "Descrição: " + this.descricao +
                "\nVídeo: " + this.video +
                "\nMédia das classificações: " + this.mediaClassificacao +
                "\nQuantidade de classificações: " + this.qntClassificacao +
                "\nPreço: " + this.preco +
                "\nId da atração: " + this.idAtracao +
                "\nId da figurinha: " + this.idFigurinhas +
                "\nData de criação do tour: " + this.dataCriacao +
                "\nData da última atualizacao: " + this.dataAtualizacao;
    }
}
