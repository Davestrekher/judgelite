package io.github.davestrekher.judgelite.judge;

import java.io.IOException;

public class CompilerService {
  public int compilar(Integer submissionId, String linguagem) throws IOException, InterruptedException {
    // Importante para a formatação de string
    String comandoDeCompilacao = "";
    // Aqui vai o nome do arquivo que será usado para colocar o código-fonte, pois o
    // comando executar da seguinte maneira: Ex: "javac" "Template.java"
    String nomeDoArquivo = "Template";
    String tipoDeArquivo = "";

    // Define o comando de compilação e o tipo de arquivo da linguagem escolhida
    // NOTA: o compilador da linguagem deve, obviamente, estar instalado no
    // computador de quem executa o judge.
    switch (linguagem) {
      case "Java":
        comandoDeCompilacao = "javac";
        tipoDeArquivo = ".java";
        break;
      case "C++":
        comandoDeCompilacao = "gcc";
        tipoDeArquivo = ".cpp";
        break;
      case "Python":
        return 0;// Python não compila
    }

    // Formata a string final do nome do arquivo + tipo (ex: "Main" + ".java" =
    // "Main.java")
    String arquivoFinal = nomeDoArquivo + tipoDeArquivo;

    ProcessBuilder pb = new ProcessBuilder(
        comandoDeCompilacao, arquivoFinal);

    // IMPORTANTE: define o diretório onde o pb será executado
    // Não faço ideia se esse modo de definir o path vai funcionar. Requer testes
    String folder = "/target/submissions/" + submissionId;
    pb.directory(new java.io.File(folder));

    // Redireciona o erro. Não sei bem o que faz, mas aparentemente é bom deixar em
    // true
    pb.redirectErrorStream(true);
    Process process = pb.start();

    // Exitcode = 1 -> Erro
    // Exitcode = 0 -> Não houve erro
    int exitCode = process.waitFor();

    return exitCode;
  }
}