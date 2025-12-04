package io.github.davestrekher.judgelite.model;

public class Professor extends Usuario {
    public Professor() {
    }

    public Professor(String tipo_usuario, String nome, String senha, String email, String usuario_name) {
        super(tipo_usuario, nome, senha, email, usuario_name);
    }

    public void definirNome(String nome) {
        super.definirNome(nome);
    }

    public void definirTipo_usuario(String tipo_usuario) {
        super.definirTipo_usuario(tipo_usuario);
    }

    public void definirSenha(String senha) {
        super.definirSenha(senha);
    }

    public void definirEmail(String email) {
        super.definirEmail(email);
    }

    public void definirUsuario_name(String usuario_name) {
        super.definirUsuario_name(usuario_name);
    }

    // Métodos "obter"
    public String obterNome() {
        return super.obterNome();
    }

    public String obterTipo_usuario() {
        return super.obterTipo_usuario();
    }

    public String obterSenha() {
        return super.obterSenha();
    }

    public String obterEmail() {
        return super.obterEmail();
    }

    public String obterUsuario_name() {
        return super.obterUsuario_name();
    }
}