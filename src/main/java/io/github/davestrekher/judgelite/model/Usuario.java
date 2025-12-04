package io.github.davestrekher.judgelite.model;

public abstract class Usuario {
    private String tipo_usuario;
    private String nome;
    private String senha;
    private String email;
    private String usuario_name;

    public Usuario() {
    }

    public Usuario(String tipo_usuario, String nome, String senha, String email, String usuario_name) {
        this.tipo_usuario = tipo_usuario;
        this.nome = nome;
        this.senha = senha;
        this.email = email;
        this.usuario_name = usuario_name;
    }

    public void definirNome(String nome) {
        this.nome = nome;
    }

    public void definirTipo_usuario(String tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }

    public void definirSenha(String senha) {
        this.senha = senha;
    }

    public void definirEmail(String email) {
        this.email = email;
    }

    public void definirUsuario_name(String usuario_name) {
        this.usuario_name = usuario_name;
    }

    public String obterNome() {
        return nome;
    }

    public String obterTipo_usuario() {
        return tipo_usuario;
    }

    public String obterSenha() {
        return senha;
    }

    public String obterEmail() {
        return email;
    }

    public String obterUsuario_name() {
        return usuario_name;
    }
}