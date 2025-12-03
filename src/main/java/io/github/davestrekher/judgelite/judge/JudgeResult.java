package io.github.davestrekher.judgelite.judge;

public class JudgeResult {
  public enum JudgeStatus {
    ACCEPTED,
    COMPILE_ERROR,
    RUNTIME_ERROR,
    WRONG_ANSWER,
    TIME_LIMIT_EXCEEDED
  }

  public JudgeStatus status;
  public String message;

  public JudgeResult(JudgeStatus status, String message) {
    this.status = status;
    this.message = message;
  }

  // Os seguintes métodos retornam o status de uma submissão e são úteis para
  // indicar qual o resultado dos testes, se houve algum tipo de erro e qual o
  // erro caso tenha ocorrido.

  public static JudgeResult accepted() {
    return new JudgeResult(JudgeStatus.ACCEPTED, "Accepted");
  }

  public static JudgeResult compileError() {
    return new JudgeResult(JudgeStatus.COMPILE_ERROR, "Compilation Error");
  }

  public static JudgeResult runtimeError() {
    return new JudgeResult(JudgeStatus.RUNTIME_ERROR, "Runtime Error");
  }

  public static JudgeResult wrongAnswer() {
    return new JudgeResult(JudgeStatus.WRONG_ANSWER, "Wrong Answer");
  }

  public static JudgeResult timeLimitExceeded() {
    return new JudgeResult(JudgeStatus.TIME_LIMIT_EXCEEDED, "Time Limit Exceeded");
  }
}
