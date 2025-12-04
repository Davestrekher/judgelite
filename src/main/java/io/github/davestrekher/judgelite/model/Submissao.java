package io.github.davestrekher.judgelite.model;

public class Submissao {

    private String codigoFonte;
    private java.sql.Date dataSubmissao;
    private String linguagem;
    private String status;
    private int idSubmissao;
    private String usuarioName;

    public Submissao() {
    }

    public Submissao(String codigoFonte, java.sql.Date dataSubmissao, String linguagem,
            String status, int idSubmissao, String usuarioName) {
        this.codigoFonte = codigoFonte;
        this.dataSubmissao = dataSubmissao;
        this.linguagem = linguagem;
        this.status = status;
        this.idSubmissao = idSubmissao;
        this.usuarioName = usuarioName;
    }

    public String obterCodigoFonte() {
        return codigoFonte;
    }

    public java.sql.Date obterDataSubmissao() {
        return dataSubmissao;
    }

    public String obterLinguagem() {
        return linguagem;
    }

    public String obterStatus() {
        return status;
    }

    public int obterIdSubmissao() {
        return idSubmissao;
    }

    public String obterUsuarioName() {
        return usuarioName;
    }

    public void definirCodigoFonte(String codigoFonte) {
        this.codigoFonte = codigoFonte;
    }

    public void definirDataSubmissao(java.sql.Date dataSubmissao) {
        this.dataSubmissao = dataSubmissao;
    }

    public void definirLinguagem(String linguagem) {
        this.linguagem = linguagem;
    }

    public void definirStatus(String status) {
        this.status = status;
    }

    public void definirIdSubmissao(int idSubmissao) {
        this.idSubmissao = idSubmissao;
    }

    public void definirUsuarioName(String usuarioName) {
        this.usuarioName = usuarioName;
    }
}
