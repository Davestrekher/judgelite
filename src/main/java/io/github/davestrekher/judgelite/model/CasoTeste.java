package io.github.davestrekher.judgelite.model;

public class CasoTeste {
    private int id_problemas;
    private static String entrada;
    private static String saida;
    private int contador;

    // Construtor padrão
    public CasoTeste() {
    }

    // Construtor com parâmetros
    public CasoTeste(int id_problemas, String entrada, String saida, int contador) {
        this.id_problemas = id_problemas;
        this.entrada = entrada;
        this.saida = saida;
        this.contador = contador;
    }

    // Métodos setters (definir)
    public void definirId_problemas(int id_problemas) {
        this.id_problemas = id_problemas;
    }

    public void definirEntrada(String entrada) {
        this.entrada = entrada;
    }

    public void definirContador(int contador) {
        this.contador = contador;
    }

    public void definirSaida(String saida) {
        this.saida = saida;
    }

    // Métodos getters (obter)
    public int obterId_problemas() {
        return id_problemas;
    }

    public String obterEntrada() {
        return entrada;
    }

    public String obterSaida() {
        return saida;
    }

    public int obterContador() {
        return contador;
    }
}
