package io.github.davestrekher.judgelite.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import io.github.davestrekher.judgelite.controller.ConnectionFactory;
import io.github.davestrekher.judgelite.model.CasoTeste;
import io.github.davestrekher.judgelite.model.listaDinamica;

public class CasoTesteDao implements IDAO<CasoTeste, Integer> {

    @Override
    public void createData(CasoTeste caso) {
        String sql = "INSERT INTO casoteste (entrada, saida, id_problemas, contador) VALUES (?, ?, ?, ?)";

        try {
            Connection conn = new ConnectionFactory().getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, caso.obterEntrada());
            pst.setString(2, caso.obterSaida());
            pst.setInt(3, caso.obterId_problemas());
            pst.setInt(4, caso.obterContador());
            pst.executeUpdate();
            pst.execute();
            pst.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public CasoTeste readData(Integer id) {
        return null;
    }

    public CasoTeste readData(int contador, int id_problemas) {
        String sql = "SELECT * FROM casoteste WHERE contador = ? AND id_problemas = ?";
        CasoTeste caso = null;

        try {
            Connection conn = new ConnectionFactory().getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, contador);
            pst.setInt(2, id_problemas);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                caso = new CasoTeste(rs.getInt("id_problemas"), rs.getString("entrada"), rs.getString("saida"),
                        rs.getInt("contador"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return caso;
    }

    @Override
    public listaDinamica<CasoTeste> getAllData() {
        String sql = "select * from casoteste";
        PreparedStatement pst;
        Connection conexao;
        ResultSet rs;
        listaDinamica<CasoTeste> listCasoTeste = null;
        try {
            conexao = (new ConnectionFactory()).getConnection();
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs != null) {
                listCasoTeste = new listaDinamica<>();
                while (rs.next()) {
                    CasoTeste caso = new CasoTeste(rs.getInt("id_problemas"), rs.getString("entrada"),
                            rs.getString("saida"), rs.getInt("contador"));
                    listCasoTeste.add(caso);
                }
            }
            rs.close();
            pst.close();
            conexao.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listCasoTeste;
    }

    // @Override
    public void updateData(CasoTeste caso) {
        String sql = "UPDATE casoteste SET entrada = ?, saida = ? "
                + "WHERE contador = ? AND id_problemas = ?";

        try {
            Connection conn = new ConnectionFactory().getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, caso.obterEntrada());
            pst.setString(2, caso.obterSaida());
            pst.setInt(3, caso.obterContador());
            pst.setInt(4, caso.obterId_problemas());

            pst.executeUpdate();
            pst.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @Override
     *           public void deleteData(Integer contador) {
     *           throw new UnsupportedOperationException("Use deleteData(contador,
     *           id_problemas)");
     *           }
     **/

    public void deleteData(int contador, int id_problemas) {
        String sql = "DELETE FROM casoteste WHERE contador = ? AND id_problemas = ?";
        try {
            Connection conn = new ConnectionFactory().getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setInt(1, contador);
            pst.setInt(2, id_problemas);

            pst.executeUpdate();
            pst.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}