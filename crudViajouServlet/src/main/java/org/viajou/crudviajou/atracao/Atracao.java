package org.viajou.crudviajou.atracao;

public class Atracao {
    private String descricao;
    private String nome;
    private String endereco;
    private boolean acessibilidade;
    private String categoria;

    public Atracao(String descricao, String nome, String endereco, boolean acessibilidade, String categoria) {
        this.descricao = descricao;
        this.nome = nome;
        this.endereco = endereco;
        this.acessibilidade = acessibilidade;
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public boolean getAcessibilidade() {
        return acessibilidade;
    }

    public void setAcessibilidade(boolean acessibilidade) {
        this.acessibilidade = acessibilidade;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String toString() {
        return "Atracao{" +
                "descricao='" + descricao + '\'' +
                ", nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", acessibilidade=" + acessibilidade +
                ", categoria='" + categoria + '\'' +
                '}';
    }
}
