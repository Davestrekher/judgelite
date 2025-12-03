package io.github.davestrekher.judgelite.judge;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ExecutionEngine {

  public RunResult executar(String submissionId, String input, String linguagem)
      throws IOException, InterruptedException {
    // Importante para a formatação de string
    String comandoDeExecucao = "";
    // Aqui vai o nome do arquivo que será usado para colocar o código-fonte, pois o
    // comando executar da seguinte maneira: Ex: "java" "Template"
    String nomeDoArquivo = "Template";
    String tipoDeArquivo = "";

    ProcessBuilder pb;
    String arquivoFinal;

    // Define o comando de compilação e o tipo de arquivo da linguagem escolhida
    // NOTA: o compilador da linguagem deve, obviamente, estar instalado no
    // computador de quem executa o judge.
    switch (linguagem) {
      case "Java":
        comandoDeExecucao = "java";
        tipoDeArquivo = "";
        arquivoFinal = nomeDoArquivo + tipoDeArquivo;
        pb = new ProcessBuilder(
            comandoDeExecucao, arquivoFinal);
        break;
      case "C++":
        comandoDeExecucao = ".\\" + nomeDoArquivo;
        pb = new ProcessBuilder(
            comandoDeExecucao);
        break;
      case "Python":
        comandoDeExecucao = "python";
        tipoDeArquivo = ".py";
        arquivoFinal = nomeDoArquivo + tipoDeArquivo;
        pb = new ProcessBuilder(
            comandoDeExecucao, arquivoFinal);
        break;
      default:
        pb = new ProcessBuilder(
            "java", "Template");
    }

    // IMPORTANTE: define o diretório onde o pb será executado
    // Não faço ideia se esse modo de definir o path vai funcionar. Requer testes
    String folder = "/target/submissions" + submissionId;
    pb.directory(new java.io.File(folder));

    // Redireciona o erro. Não sei bem o que faz, mas aparentemente é bom deixar em
    // true
    pb.redirectErrorStream(true);

    try {
      Process p = pb.start();

      // Envia input
      if (input != null) {
        p.getOutputStream().write(input.getBytes());
        p.getOutputStream().close();
      }

      // Timeout
      boolean finished = p.waitFor(2, TimeUnit.SECONDS);

      // Se deu timeout, termina o processo e retorna o erro
      if (!finished) {
        p.destroyForcibly();
        return RunResult.timeLimit();
      }

      int exit = p.exitValue();
      String output = new String(p.getInputStream().readAllBytes());

      // Se houve algum erro de runtime, retorna o erro
      if (exit != 0) {
        return RunResult.runtimeError(output);
      }

      // Caso não houve nenhum erro de Runtime ou timeout, indica sucesso eretorna o
      // output
      return RunResult.success(output);

    } catch (Exception e) {
      // Caso dê qualquer outro erro que caia em Exception, retorna erro de runtime
      return RunResult.runtimeError(e.getMessage());
    }
  }
}
