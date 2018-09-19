package p2.prob1.b;

/**
 * Interface responsável por definir a assinatura dos métodos para manipulação
 * de um arquivo de audio.
 */
public interface FormatoAudio {

    public void abrir(String arquivo);

    public void reproduzir();

    public void pausar();

    public void parar();

    public void avancar(int segundos);

    public void retornar(int segundos);

    public void liberar();
}
