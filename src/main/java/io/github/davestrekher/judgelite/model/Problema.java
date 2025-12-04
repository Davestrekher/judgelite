package io.github.davestrekher.judgelite.model;

import java.util.Date;

public class Problema {

    private int id_problemas;
    private Date data_problema;
    private String dificuldade;
    private String enunciado;
    private String nome;
    private String entrada;
    private String saida;
    private String id_usuarioprofessor;

    public Problema() {
    }

    public Problema(int id_problemas, Date data_problema, String dificuldade,
            String enunciado, String nome, String entrada,
            String saida, String id_usuarioprofessor) {

        this.id_problemas = id_problemas;
        this.data_problema = data_problema;
        this.dificuldade = dificuldade;
        this.enunciado = enunciado;
        this.nome = nome;
        this.entrada = entrada;
        this.saida = saida;
        this.id_usuarioprofessor = id_usuarioprofessor;
    }

    public int obterId_problemas() {
        return id_problemas;
    }

    public void definirId_problemas(int id_problemas) {
        this.id_problemas = id_problemas;
    }

    public Date obterData_problema() {
        return data_problema;
    }

    public void definirData_problema(Date data_problema) {
        this.data_problema = data_problema;
    }

    public String obterDificuldade() {
        return dificuldade;
    }

    public void definirDificuldade(String dificuldade) {
        this.dificuldade = dificuldade;
    }

    public String obterEnunciado() {
        return enunciado;
    }

    public void definirEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public String obterNome() {
        return nome;
    }

    public void definirNome(String nome) {
        this.nome = nome;
    }

    public String obterEntrada() {
        return entrada;
    }

    public void definirEntrada(String entrada) {
        this.entrada = entrada;
    }

    public String obterSaida() {
        return saida;
    }

    public void definirSaida(String saida) {
        this.saida = saida;
    }

    public String obterId_usuarioprofessor() {
        return id_usuarioprofessor;
    }

    public void definirId_usuarioprofessor(String id_usuarioprofessor) {
        this.id_usuarioprofessor = id_usuarioprofessor;
    }

}