package p2.prob1.b;

/**
 * Interface responsável por definir a assinatura dos métodos para manipulação
 * de um arquivo de audio.
 */
public interface FormatoAudio {

    /**
     * Método para abrir um arquivo de audio.
     *
     * @param arquivo Nome do arquivo que deve ser aberto.
     */
    public void abrir(String arquivo);

    /**
     * Método para reproduzir o arquivo de audio aberto anteriormente.
     */
    public void reproduzir();

    /**
     * Método para pausar o arquivo de audio aberto anteriormente.
     */
    public void pausar();

    /**
     * Método para pausar o arquivo de audio aberto anteriormente.
     */
    public void parar();

    /**
     * Método para avançar alguns segundos de um arquivo de audio que foi
     * aberto. anteriormente.
     *
     * @param segundos Quantidade de segundos que deve ser avançado.
     */
    public void avancar(int segundos);

    /**
     * Método para retroceder alguns segundos de um arquivo de audio que foi
     * aberto.
     *
     * @param segundos Quantidade de segundos que deve ser retrocedido.
     */
    public void retornar(int segundos);

    /**
     * Método para liberar o arquivo de audio aberto anteriormente.
     * <p>
     * <b>IMPORTANTE:</b> Implementar na lógica, o stop do arquivo antes da
     * liberação.
     */
    public void liberar();

    public void reproduzirSimples(String arquivo);

    public void pararSimples();
}
