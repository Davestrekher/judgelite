package io.github.davestrekher.judgelite.dao;

import io.github.davestrekher.judgelite.model.Professor;
import io.github.davestrekher.judgelite.model.listaDinamica;
import io.github.davestrekher.judgelite.controller.ConnectionFactory;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class ProfessorDao implements IDAO<Professor, String> {
  @Override
  public listaDinamica<Professor> getAllData() {
    String sql = "select * from professor";
    PreparedStatement pst;
    Connection conexao;
    ResultSet rs;
    listaDinamica<Professor> listProfessor = null;
    try {
      conexao = (new ConnectionFactory()).getConnection();
      pst = conexao.prepareStatement(sql);
      rs = pst.executeQuery();
      if (rs != null) {
        listProfessor = new listaDinamica<>();
        while (rs.next()) {
          Professor professor = new Professor();
          professor.definirNome(rs.getString("nome"));
          professor.definirTipo_usuario(rs.getString("tipo_usuario"));
          professor.definirSenha(rs.getString("senha"));
          professor.definirEmail(rs.getString("email"));
          professor.definirUsuario_name(rs.getString("usuario_name"));
          listProfessor.add(professor);
        }
      }
      rs.close();
      pst.close();
      conexao.close();
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
    return listProfessor;
  }

  @Override
  public void createData(Professor professor) {
    Connection conexao;
    String sql = "insert into usuario(nome, tipo_usuario, senha, email, usuario_name) values(?, ?, ?, ?, ?)";
    PreparedStatement pst;
    try {
      conexao = (new ConnectionFactory()).getConnection();
      pst = conexao.prepareStatement(sql);
      pst.setString(1, professor.obterNome());
      pst.setString(2, professor.obterTipo_usuario());
      pst.setString(3, professor.obterSenha());
      pst.setString(4, professor.obterEmail());
      pst.setString(5, professor.obterUsuario_name());
      pst.execute();
      pst.close();
      conexao.close();
    } catch (SQLException ex) {
      ex.printStackTrace();
    }

    sql = "insert into professor(nome, tipo_usuario, senha, email, usuario_name) values(?, ?, ?, ?, ?)";
    try {
      conexao = (new ConnectionFactory()).getConnection();
      pst = conexao.prepareStatement(sql);
      pst.setString(1, professor.obterNome());
      pst.setString(2, professor.obterTipo_usuario());
      pst.setString(3, professor.obterSenha());
      pst.setString(4, professor.obterEmail());
      pst.setString(5, professor.obterUsuario_name());

      pst.execute();
      pst.close();
      conexao.close();
    } catch (SQLException ex) {
      ex.printStackTrace();
    }

  }

  @Override
  public Professor readData(String primary) {

    String sql = "SELECT * FROM professor WHERE usuario_name = ?";
    try (Connection conexao = new ConnectionFactory().getConnection();
        PreparedStatement pst = conexao.prepareStatement(sql)) {
      pst.setString(1, primary); // usa o parâmetro certo
      try (ResultSet rs = pst.executeQuery()) {
        if (rs.next()) { // move para a primeira linha
          Professor professor = new Professor();
          professor.definirNome(rs.getString("nome"));
          professor.definirTipo_usuario(rs.getString("tipo_usuario"));
          professor.definirSenha(rs.getString("senha"));
          professor.definirEmail(rs.getString("email"));
          professor.definirUsuario_name(rs.getString("usuario_name"));
          return professor;
        }
      }
    } catch (SQLException ex) {
      ex.printStackTrace();
    }

    return null; // não encontrado

  }

  // @Override
  public void updateData(Professor professor) {
    String sql = "UPDATE professor SET nome = ?, tipo_usuario = ?, senha = ?, email = ? "
        + "WHERE usuario_name = ?";
    try (Connection conexao = new ConnectionFactory().getConnection();
        PreparedStatement pst = conexao.prepareStatement(sql)) {

      pst.setString(1, professor.obterNome());
      pst.setString(2, professor.obterTipo_usuario());
      pst.setString(3, professor.obterSenha());
      pst.setString(4, professor.obterEmail());
      pst.setString(5, professor.obterUsuario_name());

      pst.executeUpdate();
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
  }

  // @Override
  public void deleteData(String usuario_name) {
    String sql = "DELETE FROM professor WHERE usuario_name = ?";
    try (Connection conexao = new ConnectionFactory().getConnection();
        PreparedStatement pst = conexao.prepareStatement(sql)) {
      pst.setString(1, usuario_name);
      pst.executeUpdate();
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
  }
}