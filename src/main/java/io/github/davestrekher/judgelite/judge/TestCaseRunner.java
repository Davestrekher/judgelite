package io.github.davestrekher.judgelite.judge;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.github.davestrekher.judgelite.controller.CasoTesteController;
import io.github.davestrekher.judgelite.model.CasoTeste;

public class TestCaseRunner {

  private ExecutionEngine exec = new ExecutionEngine();

  public JudgeResult rodarTodosTestes(Integer submissionId, Integer problemId, String linguagem)
      throws IOException, InterruptedException {

    List<CasoTeste> tests = carregarTestes(problemId);

    for (CasoTeste t : tests) {

      RunResult result = exec.executar(submissionId, t.obterEntrada(), linguagem);

      if (result.error == RunResult.RunErrorType.RUNTIME_ERROR) {
        return JudgeResult.runtimeError();
      }

      if (result.error == RunResult.RunErrorType.TIME_LIMIT_EXCEEDED) {
        return JudgeResult.timeLimitExceeded();
      }

      // Esse trim() remove os espaços em branco antes e depois da string para tentar
      // evitar erros devidos a forma como a string é extraída
      boolean ok = result.stdout.trim().equals(t.obterSaida().trim());
      if (!ok) {
        return JudgeResult.wrongAnswer();
      }
    }

    return JudgeResult.accepted();
  }

  public ArrayList<CasoTeste> carregarTestes(Integer problemId) {
    ArrayList<CasoTeste> list = new ArrayList<CasoTeste>();

    // Contador para contar cada caso teste
    int contador = 0;

    // Requisição pro Banco de Dados pedindo cada caso teste
    CasoTesteController casosController = new CasoTesteController();
    CasoTeste c = casosController.pesquisarCasoTeste(contador, problemId);
    while (c != null) {
      list.add(c);
      contador++;
    }

    return list;
  }

}
