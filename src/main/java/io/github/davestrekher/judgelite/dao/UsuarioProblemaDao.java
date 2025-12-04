package io.github.davestrekher.judgelite.dao;

import io.github.davestrekher.judgelite.model.UsuarioProblema;
import io.github.davestrekher.judgelite.model.listaDinamica;
import io.github.davestrekher.judgelite.controller.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioProblemaDao implements IDAO<UsuarioProblema, String> {

    @Override
    public void createData(UsuarioProblema up) {
        String sql = "INSERT INTO usuario_problema(usuario_name, id_problemas) VALUES (?, ?)";
        try (Connection conexao = new ConnectionFactory().getConnection();
                PreparedStatement pst = conexao.prepareStatement(sql)) {

            pst.setString(1, up.obterUsuario_name());
            pst.setInt(2, up.obterId_problemas());
            pst.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public UsuarioProblema readData(String usuario_name, int id_problemas) {
        String sql = "SELECT * FROM usuario_problema WHERE usuario_name = ? AND id_problemas = ?";
        UsuarioProblema up = null;

        try (Connection conexao = new ConnectionFactory().getConnection();
                PreparedStatement pst = conexao.prepareStatement(sql)) {

            pst.setString(1, usuario_name);
            pst.setInt(2, id_problemas);

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    up = new UsuarioProblema(rs.getString("usuario_name"), rs.getInt("id_problemas"));
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return up;
    }

    @Override
    public listaDinamica<UsuarioProblema> getAllData() {
        String sql = "SELECT * FROM usuario_problema";
        listaDinamica<UsuarioProblema> list = new listaDinamica<>();

        try (Connection conexao = new ConnectionFactory().getConnection();
                PreparedStatement pst = conexao.prepareStatement(sql);
                ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                UsuarioProblema up = new UsuarioProblema(rs.getString("usuario_name"), rs.getInt("id_problemas"));
                list.add(up);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return list;
    }

    public void updateData(UsuarioProblema up, int novoId_problemas) {
        String sql = "UPDATE usuario_problema SET id_problemas = ? WHERE usuario_name = ? AND id_problemas = ?";
        try (Connection conexao = new ConnectionFactory().getConnection();
                PreparedStatement pst = conexao.prepareStatement(sql)) {

            pst.setInt(1, novoId_problemas);
            pst.setString(2, up.obterUsuario_name());
            pst.setInt(3, up.obterId_problemas());
            pst.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void deleteData(String usuario_name, int id_problemas) {
        String sql = "DELETE FROM usuario_problema WHERE usuario_name = ? AND id_problemas = ?";
        try (Connection conexao = new ConnectionFactory().getConnection();
                PreparedStatement pst = conexao.prepareStatement(sql)) {

            pst.setString(1, usuario_name);
            pst.setInt(2, id_problemas);
            pst.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public UsuarioProblema readData(String usuario_name) {

        return null;
    }
}
