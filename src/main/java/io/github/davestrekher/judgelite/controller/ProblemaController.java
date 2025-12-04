package io.github.davestrekher.judgelite.controller;

import io.github.davestrekher.judgelite.model.Problema;
import io.github.davestrekher.judgelite.model.listaDinamica;
import io.github.davestrekher.judgelite.dao.ProblemaDao;

public class ProblemaController {

  public void cadastrarProblema(Integer id, java.util.Date data_problema, String dificuldade, String enunciado,
      String nome, String entrada, String saida, String id_usuarioprofessor) {
    Problema problema = new Problema(id, data_problema, dificuldade, enunciado, nome, entrada, saida,
        id_usuarioprofessor);
    ProblemaDao problemaDao = new ProblemaDao();
    problemaDao.createData(problema);
  }

  public listaDinamica<Problema> listarProblemas() {
    ProblemaDao problemaDao = new ProblemaDao();
    return problemaDao.getAllData();
  }

  public Problema pesquisarProblema(Integer id) {
    ProblemaDao problemaDao = new ProblemaDao();
    return problemaDao.readData(id);
  }

  public void atualizarProblema(Integer id, java.util.Date data_problema, String dificuldade, String enunciado,
      String nome, String entrada, String saida, String id_usuarioprofessor) {
    Problema problema = new Problema(id, data_problema, dificuldade, enunciado, nome, entrada, saida,
        id_usuarioprofessor);
    ProblemaDao problemaDao = new ProblemaDao();
    problemaDao.updateData(problema);
  }

  public void deletarProblema(Integer id) {
    ProblemaDao problemaDao = new ProblemaDao();
    problemaDao.deleteData(id);
  }

}
