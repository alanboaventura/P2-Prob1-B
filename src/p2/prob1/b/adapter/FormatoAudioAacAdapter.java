package p2.prob1.b.adapter;

import p2.prob1.b.FormatoAudio;
import problema1.AACPlayer;

/**
 * Adpter para manuseio de um arquivo de audio com o formato <code>aac</code>.
 */
public class FormatoAudioAacAdapter implements FormatoAudio {

    public FormatoAudioAacAdapter(String arquivo) {
        abrir(arquivo);
    }

    /**
     * Reprodutor do formato <code>aac</code>.
     */
    private AACPlayer reprodutor;

    /**
     * @see FormatoAudio#abrir(String)
     */
    @Override
    public void abrir(String arquivo) {
        reprodutor = new AACPlayer(arquivo);
        reprodutor.open();
        reprodutor.setLocation(0);
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
        reprodutor.stop();
    }

    /**
     * @see FormatoAudio#avancar(int)
     */
    @Override
    public void avancar(int segundos) {
        reprodutor.setLocation(reprodutor.getLocation() + segundos);
    }

    /**
     * @see FormatoAudio#retornar(int)
     */
    @Override
    public void retornar(int segundos) {
        reprodutor.setLocation(reprodutor.getLocation() - segundos);
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