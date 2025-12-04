package io.github.davestrekher.judgelite.controller;

import io.github.davestrekher.judgelite.dao.UsuarioProblemaDao;
import io.github.davestrekher.judgelite.model.UsuarioProblema;
import io.github.davestrekher.judgelite.model.listaDinamica;

public class UsuarioProblemaController {
      public void cadastrarControllerUsuarioProblema(String usuario_name, int id_problemas) {
            UsuarioProblema usuarioProblema = new UsuarioProblema(usuario_name, id_problemas);
            UsuarioProblemaDao usuarioProblemaDao = new UsuarioProblemaDao();
            usuarioProblemaDao.createData(usuarioProblema);
      }

      public listaDinamica<UsuarioProblema> listarUsuarioProblema() {
            UsuarioProblemaDao usuarioProblemaDao = new UsuarioProblemaDao();
            return usuarioProblemaDao.getAllData();
      }

      public UsuarioProblema pesquisarUsuarioProblema(String usuario_name, int id_problemas) {
            UsuarioProblemaDao usuarioProblemaDao = new UsuarioProblemaDao();
            return usuarioProblemaDao.readData(usuario_name, id_problemas);
      }

      public void atualizarUsuarioProblema(String usuario_name, int id_problemas, int novoId_problemas) {
            UsuarioProblema usuarioProblema = new UsuarioProblema(usuario_name, id_problemas);
            UsuarioProblemaDao usuarioProblemaDao = new UsuarioProblemaDao();
            usuarioProblemaDao.updateData(usuarioProblema, novoId_problemas);
      }

      public void deletarUsuarioProblema(String usuario_name, int id_problemas) {
            UsuarioProblemaDao usuarioProblemaDao = new UsuarioProblemaDao();
            usuarioProblemaDao.deleteData(usuario_name, id_problemas);
      }
}