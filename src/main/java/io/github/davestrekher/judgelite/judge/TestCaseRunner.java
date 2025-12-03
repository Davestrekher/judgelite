package io.github.davestrekher.judgelite.judge;

import java.io.IOException;
import java.util.List;

import io.github.davestrekher.judgelite.model.CasoTeste;

public class TestCaseRunner {

  private ExecutionEngine exec = new ExecutionEngine();

  public JudgeResult rodarTodosTestes(String submissionId, String problemId, String linguagem)
      throws IOException, InterruptedException {

    List<CasoTeste> tests = carregarTestes(problemId);

    for (CasoTeste t : tests) {

      RunResult result = exec.executar(submissionId, t.entrada, linguagem);

      if (result.error == RunResult.RunErrorType.RUNTIME_ERROR) {
        return JudgeResult.runtimeError();
      }

      if (result.error == RunResult.RunErrorType.TIME_LIMIT_EXCEEDED) {
        return JudgeResult.timeLimitExceeded();
      }

      boolean ok = result.stdout.trim().equals(t.saidaEsperada.trim());
      if (!ok) {
        return JudgeResult.wrongAnswer();
      }
    }

    return JudgeResult.accepted();
  }

  public List<CasoTeste> carregarTestes(String problemId) {
    List<CasoTeste> list;

    // Contador para contar cada caso teste
    int contador = 0;

    // Requisição pro Banco de Dados pedindo cada caso teste
    // ProblemaDAO p = new ProblemaDAO();
    // CasoTeste c = p.getCasoTeste(contador, problemId);
    while (c != null) {
      list.add(c);
      contador++;
    }

    return list;
  }

}
