package p2.prob1.b.adapter;

import p2.prob1.b.FormatoAudio;
import problema1.WAVPlayer;

import java.security.InvalidParameterException;

/**
 * Adpter para manuseio de um arquivo de audio com o formato <code>wav</code>.
 */
public class FormatoAudioWavAdapter implements FormatoAudio {

    public FormatoAudioWavAdapter(String arquivo) {
        abrir(arquivo);
    }

    /**
     * Reprodutor do formato <code>wav</code>.
     */
    private WAVPlayer reprodutor;

    /**
     * @see FormatoAudio#abrir(String)
     */
    @Override
    public void abrir(String arquivo) {
        if (arquivo == null) {
            throw new InvalidParameterException("Nome de arquivo de audio INVÁLIDO!");
        }

        reprodutor = new WAVPlayer(arquivo);
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
        reprodutor.stop();
    }

    /**
     * @see FormatoAudio#parar()
     */
    @Override
    public void parar() {
        reprodutor.stop();
        reprodutor.reward(reprodutor.reward(0));
    }

    /**
     * @see FormatoAudio#avancar(int)
     */
    @Override
    public void avancar(int segundos) {
        reprodutor.forward(segundos * 1000);
    }

    /**
     * @see FormatoAudio#retornar(int)
     */
    @Override
    public void retornar(int segundos) {
        reprodutor.reward(segundos * 1000);
    }

    /**
     * @see FormatoAudio#liberar()
     */
    @Override
    public void liberar() {
        reprodutor = null; // Precisamos forçar a passagem do GC aqui para chamar o método destructor.
        System.gc();
    }
}
