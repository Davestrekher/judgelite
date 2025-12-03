package io.github.davestrekher.judgelite.judge;

public class RunResult {
  public enum RunErrorType {
    NONE,
    RUNTIME_ERROR,
    TIME_LIMIT_EXCEEDED
  }

  public String stdout;
  public RunErrorType error;

  // Os seguintes metodos servem para indicar se houve algum erro em CADA teste,
  // run por run, sendo úteis para organizar melhor o TestCaseRunner que fará os
  // testes individualmente
  public static RunResult success(String out) {
    RunResult r = new RunResult();
    r.stdout = out;
    r.error = RunErrorType.NONE;
    return r;
  }

  public static RunResult runtimeError(String msg) {
    RunResult r = new RunResult();
    r.stdout = msg;
    r.error = RunErrorType.RUNTIME_ERROR;
    return r;
  }

  public static RunResult timeLimit() {
    RunResult r = new RunResult();
    r.error = RunErrorType.TIME_LIMIT_EXCEEDED;
    return r;
  }
}
