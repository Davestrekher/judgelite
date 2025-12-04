package io.github.davestrekher.judgelite.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
      private static final String USERNAME = "postgres";
      private static final String PASSWORD = "1234";
      private static final String DB_URL = "jdbc:postgresql://localhost:5432/judgelite";

      public Connection getConnection() throws SQLException {
            Connection conexao = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            return conexao;
      }
}