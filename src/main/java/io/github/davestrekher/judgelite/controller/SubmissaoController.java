package io.github.davestrekher.judgelite.controller;

import io.github.davestrekher.judgelite.dao.SubmissaoDao;
import io.github.davestrekher.judgelite.model.Submissao;
import io.github.davestrekher.judgelite.model.listaDinamica;

public class SubmissaoController {

  public void cadastrarSubmissao(String codigoFonte,
      java.sql.Date dataSubmissao,
      String linguagem,
      String status,
      int idSubmissao,
      String usuarioName) {

    Submissao sub = new Submissao(codigoFonte,
        dataSubmissao,
        linguagem,
        status,
        idSubmissao,
        usuarioName);

    SubmissaoDao subDao = new SubmissaoDao();
    subDao.createData(sub);
  }

  public listaDinamica<Submissao> listarSubmissoes() {
    SubmissaoDao subDao = new SubmissaoDao();
    return subDao.getAllData();
  }

  public Submissao pesquisarSubmissao(Integer idSubmissao) {
    SubmissaoDao subDao = new SubmissaoDao();
    return subDao.readData(idSubmissao);
  }

  public void atualizarSubmissao(String codigoFonte,
      java.sql.Date dataSubmissao,
      String linguagem,
      String status,
      int idSubmissao,
      String usuarioName) {

    Submissao sub = new Submissao(codigoFonte, dataSubmissao, linguagem, status, idSubmissao, usuarioName);
    SubmissaoDao subDao = new SubmissaoDao();
    subDao.updateData(sub);
  }

  public void deletarSubmissao(int idSubmissao) {
    SubmissaoDao subDao = new SubmissaoDao();
    subDao.deleteData(idSubmissao);
  }

}