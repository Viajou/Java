package org.viajou.crudviajou.tourVirtual;

import java.util.Date;

public class TourVirtual {
    String descricao;
    String video;
    double mediaClassificacao;
    int qntClassificacao;
    double preco;
    int idAtracao;
    int idFigurinhas;

    public TourVirtual(String descricao, String video, int qntClassificacao, double mediaClassificacao, double preco, int idAtracao, int idFigurinhas) {
        this.descricao = descricao;
        this.video = video;
        this.qntClassificacao = qntClassificacao;
        this.mediaClassificacao = mediaClassificacao;
        this.preco = preco;
        this.idAtracao = idAtracao;
        this.idFigurinhas = idFigurinhas;
    }

    public TourVirtual() {
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public double getMediaClassificacao() {
        return mediaClassificacao;
    }

    public void setMediaClassificacao(double mediaClassificacao) {
        this.mediaClassificacao = mediaClassificacao;
    }

    public int getQntClassificacao() {
        return qntClassificacao;
    }

    public void setQntClassificacao(int qntClassificacao) {
        this.qntClassificacao = qntClassificacao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getIdAtracao() {
        return idAtracao;
    }

    public void setIdAtracao(int idAtracao) {
        this.idAtracao = idAtracao;
    }

    public int getIdFigurinhas() {
        return idFigurinhas;
    }

    public void setIdFigurinhas(int idFigurinhas) {
        this.idFigurinhas = idFigurinhas;
    }
}
