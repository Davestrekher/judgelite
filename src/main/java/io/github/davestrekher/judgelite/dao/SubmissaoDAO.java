package io.github.davestrekher.judgelite.dao;

import io.github.davestrekher.judgelite.model.Submissao;
import io.github.davestrekher.judgelite.model.listaDinamica;
import io.github.davestrekher.judgelite.controller.ConnectionFactory;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class SubmissaoDao implements IDAO<Submissao, Integer> {

    @Override
    public listaDinamica<Submissao> getAllData() {
        String sql = "SELECT * FROM submissao";
        listaDinamica<Submissao> lista = null;

        try {
            Connection conexao = new ConnectionFactory().getConnection();
            PreparedStatement pst = conexao.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            if (rs != null) {
                lista = new listaDinamica<>();

                while (rs.next()) {
                    Submissao sub = new Submissao();

                    sub.definirCodigoFonte(rs.getString("codigo_fonte"));
                    sub.definirDataSubmissao(rs.getDate("data_submissao"));
                    sub.definirLinguagem(rs.getString("linguagem"));
                    sub.definirStatus(rs.getString("Status"));
                    sub.definirIdSubmissao(rs.getInt("id_submissao"));
                    sub.definirUsuarioName(rs.getString("usuario_name"));

                    lista.add(sub);
                }
            }

            rs.close();
            pst.close();
            conexao.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return lista;
    }

    @Override
    public void createData(Submissao sub) {
        String sql = "INSERT INTO submissao(codigo_fonte, data_submissao, linguagem, Status, id_submissao, usuario_name) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try {
            Connection conexao = new ConnectionFactory().getConnection();
            PreparedStatement pst = conexao.prepareStatement(sql);

            pst.setString(1, sub.obterCodigoFonte());
            pst.setDate(2, sub.obterDataSubmissao());
            pst.setString(3, sub.obterLinguagem());
            pst.setString(4, sub.obterStatus());
            pst.setInt(5, sub.obterIdSubmissao());
            pst.setString(6, sub.obterUsuarioName());

            pst.execute();
            pst.close();
            conexao.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Submissao readData(Integer primary) {
        String sql = "SELECT * FROM submissao WHERE id_submissao = ?";

        try {
            Connection conexao = new ConnectionFactory().getConnection();
            PreparedStatement pst = conexao.prepareStatement(sql);

            pst.setInt(1, primary);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                Submissao sub = new Submissao();

                sub.definirCodigoFonte(rs.getString("codigo_fonte"));
                sub.definirDataSubmissao(rs.getDate("data_submissao"));
                sub.definirLinguagem(rs.getString("linguagem"));
                sub.definirStatus(rs.getString("Status"));
                sub.definirIdSubmissao(rs.getInt("id_submissao"));
                sub.definirUsuarioName(rs.getString("usuario_name"));

                rs.close();
                pst.close();
                conexao.close();
                return sub;
            }

            rs.close();
            pst.close();
            conexao.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null; // não encontrado
    }

    // @Override
    public void updateData(Submissao sub) {
        String sql = "UPDATE submissao SET codigo_fonte = ?, data_submissao = ?, linguagem = ?, Status = ?, usuario_name = ? "
                + "WHERE id_submissao = ?";
        try {
            Connection conexao = new ConnectionFactory().getConnection();
            PreparedStatement pst = conexao.prepareStatement(sql);

            pst.setString(1, sub.obterCodigoFonte());
            pst.setDate(2, sub.obterDataSubmissao());
            pst.setString(3, sub.obterLinguagem());
            pst.setString(4, sub.obterStatus());
            pst.setString(5, sub.obterUsuarioName());
            pst.setInt(6, sub.obterIdSubmissao());

            pst.executeUpdate();
            pst.close();
            conexao.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // @Override
    public void deleteData(Integer id_submissao) {
        String sql = "DELETE FROM submissao WHERE id_submissao = ?";

        try {
            Connection conexao = new ConnectionFactory().getConnection();
            PreparedStatement pst = conexao.prepareStatement(sql);
            pst.setInt(1, id_submissao);
            pst.executeUpdate();
            pst.close();
            conexao.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
