package io.github.davestrekher.judgelite.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import io.github.davestrekher.judgelite.model.Estudante;
import io.github.davestrekher.judgelite.model.listaDinamica;
import io.github.davestrekher.judgelite.controller.ConnectionFactory;

import java.sql.PreparedStatement;

public class EstudanteDao implements IDAO<Estudante, String> {
    @Override
    public listaDinamica<Estudante> getAllData() {
        String sql = "select * from estudante";
        PreparedStatement pst;
        Connection conexao;
        ResultSet rs;
        listaDinamica<Estudante> listEstudantes = null;
        try {
            conexao = (new ConnectionFactory()).getConnection();
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs != null) {
                listEstudantes = new listaDinamica<>();
                while (rs.next()) {
                    Estudante estudante = new Estudante();
                    estudante.definirNome(rs.getString("nome"));
                    estudante.definirTipo_usuario(rs.getString("tipo_usuario"));
                    estudante.definirSenha(rs.getString("senha"));
                    estudante.definirEmail(rs.getString("email"));
                    estudante.definirUsuario_name(rs.getString("usuario_name"));
                    listEstudantes.add(estudante);
                }
            }
            rs.close();
            pst.close();
            conexao.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listEstudantes;
    }

    @Override
    public void createData(Estudante estudante) {
        Connection conexao;
        String sql = "insert into usuario(nome, tipo_usuario, senha, email, usuario_name) values(?, ?, ?, ?, ?)";
        PreparedStatement pst;
        try {
            conexao = (new ConnectionFactory()).getConnection();
            pst = conexao.prepareStatement(sql);
            pst.setString(1, estudante.obterNome());
            pst.setString(2, estudante.obterTipo_usuario());
            pst.setString(3, estudante.obterSenha());
            pst.setString(4, estudante.obterEmail());
            pst.setString(5, estudante.obterUsuario_name());
            pst.execute();
            pst.close();
            conexao.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        sql = "insert into estudante(nome, tipo_usuario, senha, email, usuario_name) values(?, ?, ?, ?, ?)";
        try {
            conexao = (new ConnectionFactory()).getConnection();
            pst = conexao.prepareStatement(sql);
            pst.setString(1, estudante.obterNome());
            pst.setString(2, estudante.obterTipo_usuario());
            pst.setString(3, estudante.obterSenha());
            pst.setString(4, estudante.obterEmail());
            pst.setString(5, estudante.obterUsuario_name());

            pst.execute();
            pst.close();
            conexao.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public Estudante readData(String primary) {
        String sql = "SELECT * FROM estudante WHERE usuario_name = ?";
        try (Connection conexao = new ConnectionFactory().getConnection();
                PreparedStatement pst = conexao.prepareStatement(sql)) {
            pst.setString(1, primary); // usa o parâmetro certo
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) { // move para a primeira linha
                    Estudante estudante = new Estudante();
                    estudante.definirNome(rs.getString("nome"));
                    estudante.definirTipo_usuario(rs.getString("tipo_usuario"));
                    estudante.definirSenha(rs.getString("senha"));
                    estudante.definirEmail(rs.getString("email"));
                    estudante.definirUsuario_name(rs.getString("usuario_name"));
                    return estudante;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null; // não encontrado
    }

    // @Override
    public void updateData(Estudante estudante) {
        String sql = "UPDATE estudante SET nome = ?, tipo_usuario = ?, senha = ?, email = ? "
                + "WHERE usuario_name = ?";
        try (Connection conexao = new ConnectionFactory().getConnection();
                PreparedStatement pst = conexao.prepareStatement(sql)) {

            pst.setString(1, estudante.obterNome());
            pst.setString(2, estudante.obterTipo_usuario());
            pst.setString(3, estudante.obterSenha());
            pst.setString(4, estudante.obterEmail());
            pst.setString(5, estudante.obterUsuario_name());

            pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // @Override
    public void deleteData(String usuario_name) {
        String sql = "DELETE FROM estudante WHERE usuario_name = ?";
        try (Connection conexao = new ConnectionFactory().getConnection();
                PreparedStatement pst = conexao.prepareStatement(sql)) {
            pst.setString(1, usuario_name);
            pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}