package io.github.davestrekher.judgelite.dao;

import io.github.davestrekher.judgelite.model.Problema;
import io.github.davestrekher.judgelite.model.listaDinamica;
import io.github.davestrekher.judgelite.controller.ConnectionFactory;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class ProblemaDao implements IDAO<Problema, Integer> {
    @Override
    public listaDinamica<Problema> getAllData() {
        String sql = "select * from problema";
        PreparedStatement pst;
        Connection conexao;
        ResultSet rs;
        listaDinamica<Problema> listProblema = null;
        try {
            conexao = (new ConnectionFactory()).getConnection();
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs != null) {
                listProblema = new listaDinamica<>();
                while (rs.next()) {
                    Problema problema = new Problema();
                    problema.definirId_problemas(rs.getInt("id_problemas"));
                    java.sql.Date dataSql = rs.getDate("data_problema");
                    java.util.Date dataUtil = new java.util.Date(dataSql.getTime());
                    problema.definirData_problema(dataUtil);
                    problema.definirDificuldade(rs.getString("dificuldade"));
                    problema.definirEnunciado(rs.getString("enuciado"));
                    problema.definirNome(rs.getString("nome"));
                    problema.definirEntrada(rs.getString("entrada"));
                    problema.definirSaida(rs.getString("saida"));
                    problema.definirId_usuarioprofessor(rs.getString("id_usuarioprofessor"));
                    listProblema.add(problema);
                }
            }
            rs.close();
            pst.close();
            conexao.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listProblema;
    }

    @Override
    public void createData(Problema problema) {
        Connection conexao;
        String sql = "insert into problema(id_problemas, data_problema, dificuldade, enuciado, nome, entrada, saida, id_usuarioprofessor) values(?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pst;
        try {
            conexao = (new ConnectionFactory()).getConnection();
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, problema.obterId_problemas());
            java.util.Date dataUtil = problema.obterData_problema();
            java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());
            pst.setDate(2, dataSql);
            pst.setString(3, problema.obterDificuldade());
            pst.setString(4, problema.obterEnunciado());
            pst.setString(5, problema.obterNome());
            pst.setString(6, problema.obterEntrada());
            pst.setString(7, problema.obterSaida());
            pst.setString(8, problema.obterId_usuarioprofessor());
            pst.execute();
            pst.close();
            conexao.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Problema readData(Integer primary) {
        String sql = "SELECT * FROM problema WHERE id_problemas = ?";
        try (Connection conexao = new ConnectionFactory().getConnection();
                PreparedStatement pst = conexao.prepareStatement(sql)) {
            pst.setInt(1, primary);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    Problema problema = new Problema();
                    problema.definirId_problemas(rs.getInt("id_problemas"));
                    java.sql.Date dataSql = rs.getDate("data_problema");
                    if (dataSql != null) {
                        problema.definirData_problema(new java.util.Date(dataSql.getTime()));
                    }
                    problema.definirDificuldade(rs.getString("dificuldade"));
                    problema.definirEnunciado(rs.getString("enunciado"));
                    problema.definirNome(rs.getString("nome"));
                    problema.definirEntrada(rs.getString("entrada"));
                    problema.definirSaida(rs.getString("saida"));
                    problema.definirId_usuarioprofessor(rs.getString("usuario_professor"));
                    return problema;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null; // não encontrado
    }

    // @Override
    public void updateData(Problema problema) {
        String sql = "UPDATE problema SET data_problema = ?, dificuldade = ?, enuciado = ?, nome = ?, entrada = ?, saida = ?, id_usuarioprofessor = ? "
                + "WHERE id_problemas = ?";
        try (Connection conexao = new ConnectionFactory().getConnection();
                PreparedStatement pst = conexao.prepareStatement(sql)) {

            java.util.Date dataUtil = problema.obterData_problema();
            java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());
            pst.setDate(1, dataSql);
            pst.setString(2, problema.obterDificuldade());
            pst.setString(3, problema.obterEnunciado());
            pst.setString(4, problema.obterNome());
            pst.setString(5, problema.obterEntrada());
            pst.setString(6, problema.obterSaida());
            pst.setString(7, problema.obterId_usuarioprofessor());
            pst.setInt(8, problema.obterId_problemas());

            pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // @Override
    public void deleteData(Integer id_problemas) {
        String sql = "DELETE FROM problema WHERE id_problemas = ?";
        try (Connection conexao = new ConnectionFactory().getConnection();
                PreparedStatement pst = conexao.prepareStatement(sql)) {
            pst.setInt(1, id_problemas);
            pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}