package org.viajou.crudviajou.excursao;

import java.util.Date;

public class Excursao {


        private String nomeEmpresa;
        private int capacidade;
        private String duracao;
        private String site;
        private double precoTotal;
        private Date dataInicio;
        private Date dataTermino;
        private String categoria;
        private int idAtracao;

    public Excursao() {
        this.nomeEmpresa = nomeEmpresa;
        this.capacidade = capacidade;
        this.duracao = duracao;
        this.site = site;
        this.precoTotal = precoTotal;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.categoria = categoria;
        this.idAtracao = idAtracao;
    }

    public String getNomeEmpresa() {
            return nomeEmpresa;
        }

        public void setNomeEmpresa(String nomeEmpresa) {
            this.nomeEmpresa = nomeEmpresa;
        }

        public int getCapacidade() {
            return capacidade;
        }

        public void setCapacidade(int capacidade) {
            this.capacidade = capacidade;
        }

        public String getDuracao() {
            return duracao;
        }

        public void setDuracao(String duracao) {
            this.duracao = duracao;
        }

        public String getSite() {
            return site;
        }

        public void setSite(String site) {
            this.site = site;
        }

        public double getPrecoTotal() {
            return precoTotal;
        }

        public void setPrecoTotal(double precoTotal) {
            this.precoTotal = precoTotal;
        }

        public Date getDataInicio() {
            return dataInicio;
        }

        public void setDataInicio(Date dataInicio) {
            this.dataInicio = dataInicio;
        }

        public Date getDataTermino() {
            return dataTermino;
        }

        public void setDataTermino(Date dataTermino) {
            this.dataTermino = dataTermino;
        }

        public String getCategoria() {
            return categoria;
        }

        public void setCategoria(String categoria) {
            this.categoria = categoria;
        }

        public int getIdAtracao() {
            return idAtracao;
        }


    public String toString() {
        return "Excursao{" +
                "nomeEmpresa='" + nomeEmpresa + '\'' +
                ", capacidade=" + capacidade +
                ", duracao='" + duracao + '\'' +
                ", site='" + site + '\'' +
                ", precoTotal=" + precoTotal +
                ", dataInicio=" + dataInicio +
                ", dataTermino=" + dataTermino +
                ", categoria='" + categoria + '\'' +
                ", idAtracao=" + idAtracao +
                '}';
    }
}
