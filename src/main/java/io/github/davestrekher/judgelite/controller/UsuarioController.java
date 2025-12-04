package io.github.davestrekher.judgelite.controller;

import io.github.davestrekher.judgelite.dao.EstudanteDao;
import io.github.davestrekher.judgelite.dao.ProfessorDao;
import io.github.davestrekher.judgelite.model.Estudante;
import io.github.davestrekher.judgelite.model.Professor;
import io.github.davestrekher.judgelite.model.Usuario;
import io.github.davestrekher.judgelite.model.listaDinamica;

public class UsuarioController {

  public void cadastrarUsuario(String tipo_usuario, String nome, String senha, String email, String usuario_name) {
    Usuario usuario;
    if ((tipo_usuario.equals("e")) || (tipo_usuario.equals("E"))) {
      EstudanteDao estudanteDao = new EstudanteDao();
      usuario = new Estudante(tipo_usuario, nome, senha, email, usuario_name);
      estudanteDao.createData((Estudante) usuario);
    } else {
      ProfessorDao professorDao = new ProfessorDao();
      usuario = new Professor(tipo_usuario, nome, senha, email, usuario_name);
      professorDao.createData((Professor) usuario);
    }
  }

  public listaDinamica<? extends Usuario> listarUsuarios(String tipo_usuario) {

    if (tipo_usuario.equalsIgnoreCase("E")) {
      EstudanteDao estudanteDao = new EstudanteDao();
      return estudanteDao.getAllData();
    }

    ProfessorDao professorDao = new ProfessorDao();
    return professorDao.getAllData();
  }

  public Usuario pesquisarUsuario(String usuario_name, String tipo_usuario) {
    Usuario usuario;
    if ((tipo_usuario.equalsIgnoreCase("E"))) {
      EstudanteDao estudanteDao = new EstudanteDao();
      usuario = estudanteDao.readData(usuario_name);
      return usuario;
    }
    ProfessorDao professorDao = new ProfessorDao();
    usuario = professorDao.readData(usuario_name);
    return (usuario);
  }

  public void atualizarUsuario(String tipo_usuario, String nome, String senha, String email, String usuario_name) {
    if (tipo_usuario.equalsIgnoreCase("E")) {
      EstudanteDao estudanteDao = new EstudanteDao();
      Estudante estudante = new Estudante(tipo_usuario, nome, senha, email, usuario_name);
      estudanteDao.updateData(estudante);
    } else {
      ProfessorDao professorDao = new ProfessorDao();
      Professor professor = new Professor(tipo_usuario, nome, senha, email, usuario_name);
      professorDao.updateData(professor);
    }
  }

  public void deletarUsuario(String tipo_usuario, String usuario_name) {
    if (tipo_usuario.equalsIgnoreCase("E")) {
      EstudanteDao estudanteDao = new EstudanteDao();
      estudanteDao.deleteData(usuario_name);
    } else {
      ProfessorDao professorDao = new ProfessorDao();
      professorDao.deleteData(usuario_name);
    }
  }

}