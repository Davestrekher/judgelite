package io.github.davestrekher.judgelite.judge;

import java.io.IOException;

import io.github.davestrekher.judgelite.controller.SubmissaoController;
import io.github.davestrekher.judgelite.model.Submissao;

public class JudgeCore {
  private final int SUBMISSAO_ACEITA = 0;
  private final int ERRO_COMPILACAO = 1;
  private final int ERRO_RUNTIME = 2;
  private final int ERRO_WRONG_ANSWER = 3;
  private final int ERRO_TEMPO_EXCEDIDO = 4;

  private CompilerService compiler;
  private TestCaseRunner tester;

  public JudgeResult judgement(Integer problemId, Integer submissionId) throws IOException, InterruptedException {
    // Requisição ao banco de dados para saber o tipo de linguagem
    SubmissaoController subs = new SubmissaoController();
    Submissao submission = subs.pesquisarSubmissao(submissionId);
    String linguagem = submission.obterLinguagem();

    // Compila o código (CompilerService)
    compiler = new CompilerService();
    int saida = compiler.compilar(submissionId, linguagem);

    if (saida != 0) {
      return JudgeResult.compileError();
    }

    // Testa as entradas e saídas do código (TestCaseRunner)
    tester = new TestCaseRunner();
    return tester.rodarTodosTestes(submissionId, problemId, linguagem);
  }
}
