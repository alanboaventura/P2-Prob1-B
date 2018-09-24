package p2.prob1.b;

import problema1.AIFFSuperPlayer;
import problema1.WAVPlayer;
import problema1.wmaPlay;

/**
 * Classe responsável por manusear arquivos de audio de forma padronizada.
 * <p>
 *
 * Extensões suportadas:
 * <ul>
 * <li>WMA</li>
 * <li>AIFF</li>
 * <li>WAV</li>
 * </ul>
 */
public class ReprodutorDeAudio implements FormatoAudio {

    /**
     * Atributo responsável por armazenar a extensão do arquivo carregado para
     * manuseio.
     */
    private String extensaoArquivo;

    /**
     * Localização atual da reprodução do arquivo (em segundos).
     */
    private Integer localizaoAudio = 0;

    /**
     * Objeto responsável pelas ações a serem realizadas em arquivos de audio.
     * <p>
     *
     * <b>IMPORTANTE:</b> Para sua utilização, é necessário fazer uso de
     * <code>cast</code> para acessar os métodos de cada classe externa.
     */
    private Object reprodutor;

    /**
     * @see FormatoAudio#abrir(java.lang.String)
     */
    @Override
    public void abrir(String arquivo) {
        if (arquivo == null) {
            return;
        }

        extensaoArquivo = arquivo.split("\\.")[1];

        switch (extensaoArquivo) {
            case "wma":
                reprodutor = new wmaPlay();
                ((wmaPlay) reprodutor).setFile(arquivo);
                ((wmaPlay) reprodutor).open();
                break;
            case "aiff":
                reprodutor = new AIFFSuperPlayer(arquivo);
                break;
            case "wav":
                reprodutor = new WAVPlayer(arquivo);
                break;
        }
    }

    /**
     * @see FormatoAudio#reproduzir()
     */
    @Override
    public void reproduzir() {
        switch (extensaoArquivo) {
            case "wma":
                ((wmaPlay) reprodutor).setLocation(localizaoAudio);
                ((wmaPlay) reprodutor).play();
                break;
            case "aiff":
                ((AIFFSuperPlayer) reprodutor).play();
                break;
            case "wav":
                ((WAVPlayer) reprodutor).play();
                break;
        }
    }

    /**
     * @see FormatoAudio#pausar()
     */
    @Override
    public void pausar() {
        switch (extensaoArquivo) {
            case "wma":
                ((wmaPlay) reprodutor).stop();
                localizaoAudio = ((wmaPlay) reprodutor).getLocation();
                break;
            case "aiff":
                localizaoAudio = ((AIFFSuperPlayer) reprodutor).pause();
                break;
            case "wav":
                ((WAVPlayer) reprodutor).stop();
                break;
        }
    }

    /**
     * @see FormatoAudio#parar()
     */
    @Override
    public void parar() {
        switch (extensaoArquivo) {
            case "wma":
                ((wmaPlay) reprodutor).stop();
                ((wmaPlay) reprodutor).setLocation(0);
                break;
            case "aiff":
                ((AIFFSuperPlayer) reprodutor).stop();
                ((AIFFSuperPlayer) reprodutor).setCursor(0);
                break;
            case "wav":
                ((WAVPlayer) reprodutor).stop();
                ((WAVPlayer) reprodutor).reward(((WAVPlayer) reprodutor).reward(0));
                break;
        }
    }

    /**
     * @see FormatoAudio#avancar(int)
     */
    @Override
    public void avancar(int segundos) {
        switch (extensaoArquivo) {
            case "wma":
                ((wmaPlay) reprodutor).setLocation(((wmaPlay) reprodutor).getLocation() + segundos);
                break;
            case "aiff":
                ((AIFFSuperPlayer) reprodutor).setCursor(((AIFFSuperPlayer) reprodutor).pause() + segundos);
                ((AIFFSuperPlayer) reprodutor).play();
                break;
            case "wav":
                ((WAVPlayer) reprodutor).forward(segundos * 1000);
                break;
        }
    }

    /**
     * @see FormatoAudio#retornar(int)
     */
    @Override
    public void retornar(int segundos) {
        switch (extensaoArquivo) {
            case "wma":
                ((wmaPlay) reprodutor).setLocation(((wmaPlay) reprodutor).getLocation() - segundos);
                break;
            case "aiff":
                final int localizacaoAtual = ((AIFFSuperPlayer) reprodutor).pause();
                ((AIFFSuperPlayer) reprodutor).setCursor(localizacaoAtual - segundos);
                ((AIFFSuperPlayer) reprodutor).play();
                break;
            case "wav":
                ((WAVPlayer) reprodutor).reward(segundos * 1000);
                break;
        }
    }

    /**
     * @see FormatoAudio#liberar()
     * <p>
     *
     * <b>IMPORTANTE:</b> Não é necessário parar o arquivo antes de chamar esse
     * método, o arquivo já é parado nessa implementação.
     */
    @Override
    public void liberar() {
        switch (extensaoArquivo) {
            case "wma":
                ((wmaPlay) reprodutor).stop();
                reprodutor = null;
                System.gc();
                break;
            case "aiff":
                ((AIFFSuperPlayer) reprodutor).release(); // Internamente ele já para o arquivo.
                break;
            case "wav":
                ((WAVPlayer) reprodutor).stop();
                reprodutor = null;
                System.gc(); // Precisamos forçar a passagem do GC aqui para chamar o método destructor.
                break;
        }

        localizaoAudio = 0;
    }

    /**
     * @see FormatoAudio#reproduzirSimples(java.lang.String)
     */
    @Override
    public void reproduzirSimples(String arquivo) {
        abrir(arquivo);
        reproduzir();
    }

    /**
     * @see FormatoAudio#pararSimples()
     */
    @Override
    public void pararSimples() {
        liberar();
    }
}
