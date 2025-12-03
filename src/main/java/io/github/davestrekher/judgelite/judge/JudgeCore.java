package io.github.davestrekher.judgelite.judge;

public class JudgeCore {
  private final int SUBMISSAO_ACEITA = 0;
  private final int ERRO_COMPILACAO = 1;
  private final int ERRO_RUNTIME = 2;
  private final int ERRO_WRONG_ANSWER = 3;
  private final int ERRO_TEMPO_EXCEDIDO = 4;

  private CompilerService compiler;
  private ExecutionEngine executer;
  private TestCaseRunner tester;

  public JudgeResult judgement(String problemId, String submissionId) {
    // Requisição ao banco de dados para saber o tipo de linguagem
    // SubmissionDAO submission = new Submission();
    // String linguagem = submission.getLinguagem(submissionId);

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
