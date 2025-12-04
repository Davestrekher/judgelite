package io.github.davestrekher.judgelite.model;

public class UsuarioProblema {
    private String usuario_name;
    private int id_problemas;

    public UsuarioProblema() {
    }

    public UsuarioProblema(String usuario_name, int id_problemas) {
        this.usuario_name = usuario_name;
        this.id_problemas = id_problemas;
    }

    public String obterUsuario_name() {
        return usuario_name;
    }

    public void definirUsuario_name(String usuario_name) {
        this.usuario_name = usuario_name;
    }

    public int obterId_problemas() {
        return id_problemas;
    }

    public void definirId_problemas(int id_problemas) {
        this.id_problemas = id_problemas;
    }
}
