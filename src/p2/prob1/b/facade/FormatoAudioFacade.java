package p2.prob1.b.facade;

import p2.prob1.b.FormatoAudio;
import p2.prob1.b.factory.FormatoAudioFactory;

/**
 * Facade para implementação dos métodos <code>reproduzirSimples</code> e <code>pararSimples</code>.
 */
public class FormatoAudioFacade {

    /**
     * Objeto para manuseio do formato do arquivo de audio em questão.
     */
    private static FormatoAudio formatoAudio;

    /**
     * Abre o arquivo informado via parâmetro e inicia a reprodução do mesmo.
     *
     * @param arquivo Nome do arquivo que deve ser aberto e reproduzido.
     */
    public static void reproduzirSimples(String arquivo) {
        formatoAudio = FormatoAudioFactory.getFormatoAudio(arquivo);
        formatoAudio.abrir(arquivo);
        formatoAudio.reproduzir();
    }

    /**
     * Para a reprodução do arquivo e libera o mesmo em memória.
     */
    public static void pararSimples() {
        formatoAudio.parar();
        formatoAudio.liberar();
    }
}
