package p2.prob1.b.adapter;

import p2.prob1.b.FormatoAudio;
import problema1.MP3DJ;

/**
 * Adpter para manuseio de um arquivo de audio com o formato <code>mp3</code>.
 */
public class FormatoAudioMP3Adapter implements FormatoAudio {

    public FormatoAudioMP3Adapter(String arquivo) {
        abrir(arquivo);
    }

    /**
     * Reprodutor do formato <code>mp3</code>.
     */
    private MP3DJ reprodutor;

    /**
     * @see FormatoAudio#abrir(String)
     */
    @Override
    public void abrir(String arquivo) {
        reprodutor = new MP3DJ();
        reprodutor.setFile(arquivo);
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
        reprodutor.forward(segundos);
    }

    /**
     * @see FormatoAudio#retornar(int)
     */
    @Override
    public void retornar(int segundos) {
        reprodutor.reward(segundos);
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