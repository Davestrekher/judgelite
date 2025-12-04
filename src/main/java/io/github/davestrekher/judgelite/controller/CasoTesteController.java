package io.github.davestrekher.judgelite.controller;

import io.github.davestrekher.judgelite.dao.CasoTesteDao;
import io.github.davestrekher.judgelite.model.CasoTeste;
import io.github.davestrekher.judgelite.model.listaDinamica;

public class CasoTesteController {

    public void cadastrarCasoTeste(int id_problemas, String entrada, String saida, int contador) {
        CasoTeste caso = new CasoTeste(id_problemas, entrada, saida, contador);
        CasoTesteDao casoTesteDao = new CasoTesteDao();
        casoTesteDao.createData(caso);
    }

    public listaDinamica<CasoTeste> listarCasosTestes() {
        CasoTesteDao caso = new CasoTesteDao();
        return caso.getAllData();
    }

    public CasoTeste pesquisarCasoTeste(Integer contador, Integer id_problema) {
        CasoTeste casoTeste = new CasoTeste();
        CasoTesteDao casoTesteDao = new CasoTesteDao();
        return casoTesteDao.readData(contador, id_problema);
    }

    public void atualizarCasoTeste(int id_problemas, String entrada, String saida, int contador) {
        CasoTeste caso = new CasoTeste(id_problemas, entrada, saida, contador);
        CasoTesteDao casoTesteDao = new CasoTesteDao();
        casoTesteDao.updateData(caso);
    }

    public void deletarCasoTeste(int contador, int id_problemas) {
        CasoTesteDao casoTesteDao = new CasoTesteDao();
        casoTesteDao.deleteData(contador, id_problemas);
    }

}
