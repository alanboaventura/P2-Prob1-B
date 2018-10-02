package p2.prob1.b.adapter;

import p2.prob1.b.FormatoAudio;
import problema1.AIFFSuperPlayer;

import java.security.InvalidParameterException;

/**
 * Adpter para manuseio de um arquivo de audio com o formato <code>aiff</code>.
 */
public class FormatoAudioAiffAdapter implements FormatoAudio {

    public FormatoAudioAiffAdapter(String arquivo) {
        abrir(arquivo);
    }

    /**
     * Reprodutor do formato <code>aiff</code>.
     */
    private AIFFSuperPlayer reprodutor;

    /**
     * @see FormatoAudio#abrir(String)
     */
    @Override
    public void abrir(String arquivo) {
        if (arquivo == null) {
            throw new InvalidParameterException("Nome de arquivo de audio INVÁLIDO!");
        }

        reprodutor = new AIFFSuperPlayer(arquivo);
    }

    /**
     * @see FormatoAudio#reproduzir()
     */
    @Override
    public void reproduzir() {
        reprodutor.play();
    }

    /**
     * @see FormatoAudio#pausar()
     */
    @Override
    public void pausar() {
        reprodutor.pause();
    }

    /**
     * @see FormatoAudio#parar()
     */
    @Override
    public void parar() {
        reprodutor.stop();
        reprodutor.setCursor(0);
    }

    /**
     * @see FormatoAudio#avancar(int)
     */
    @Override
    public void avancar(int segundos) {
        reprodutor.setCursor(reprodutor.pause() + segundos);
        reprodutor.play();
    }

    /**
     * @see FormatoAudio#retornar(int)
     */
    @Override
    public void retornar(int segundos) {
        final int localizacaoAtual = reprodutor.pause();
        reprodutor.setCursor(localizacaoAtual - segundos);
        reprodutor.play();
    }

    /**
     * @see FormatoAudio#liberar()
     */
    @Override
    public void liberar() {
        reprodutor.release();
    }
}
