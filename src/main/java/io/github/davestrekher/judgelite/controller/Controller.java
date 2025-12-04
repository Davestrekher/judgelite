package io.github.davestrekher.judgelite.controller;

import java.util.Date;

import io.github.davestrekher.judgelite.dao.EstudanteDao;
import io.github.davestrekher.judgelite.model.*;

public class Controller {
    private EstudanteDao estudanteDao;
    private listaDinamica<Estudante> listEstudante;

    public Controller() {
        estudanteDao = new EstudanteDao();
    }

    public void iniciar() {

        CasoTesteController CasoTeste = new CasoTesteController();
        String informacao = "";
        listaDinamica<CasoTeste> listCasoTeste = CasoTeste.listarCasosTestes();
        for (int i = 0; i < listCasoTeste.getSize(); i++) {
            CasoTeste casoTeste = listCasoTeste.getValor(i);
            informacao += "\nNome: " + casoTeste.obterId_problemas() + "\nContador: " + casoTeste.obterContador();

        }
        System.out.println(informacao);

    }
}