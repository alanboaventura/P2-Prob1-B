package p2.prob1.b.adapter;

import p2.prob1.b.FormatoAudio;
import problema1.wmaPlay;

import java.security.InvalidParameterException;

/**
 * Adpter para manuseio de um arquivo de audio com o formato <code>wma</code>.
 */
public class FormatoAudioWmaAdapter implements FormatoAudio {

    public FormatoAudioWmaAdapter(String arquivo) {
        abrir(arquivo);
    }

    /**
     * Reprodutor do formato <code>wma</code>.
     */
    private wmaPlay reprodutorWma = new wmaPlay();

    /**
     * Localização atual da reprodução do arquivo (em segundos).
     */
    private Integer localizaoAudioAuxiliar = 0;

    /**
     * @see FormatoAudio#abrir(java.lang.String)
     */
    @Override
    public void abrir(String arquivo) {
        if (arquivo == null) {
            throw new InvalidParameterException("Nome de arquivo de audio INVÁLIDO!");
        }
        if (reprodutorWma == null) {
            reprodutorWma = new wmaPlay();
        }

        reprodutorWma.setFile(arquivo);
        reprodutorWma.open();
    }

    /**
     * @see FormatoAudio#reproduzir()
     */
    @Override
    public void reproduzir() {
        reprodutorWma.setLocation(localizaoAudioAuxiliar);
        reprodutorWma.play();
    }

    /**
     * @see FormatoAudio#pausar()
     */
    @Override
    public void pausar() {
        reprodutorWma.stop();
        localizaoAudioAuxiliar = reprodutorWma.getLocation();
    }

    /**
     * @see FormatoAudio#parar()
     */
    @Override
    public void parar() {
        reprodutorWma.stop();
        reprodutorWma.setLocation(0);
        localizaoAudioAuxiliar = 0;
    }

    /**
     * @see FormatoAudio#avancar(int)
     */
    @Override
    public void avancar(int segundos) {
        reprodutorWma.setLocation(reprodutorWma.getLocation() + segundos);
    }

    /**
     * @see FormatoAudio#retornar(int)
     */
    @Override
    public void retornar(int segundos) {
        reprodutorWma.setLocation(reprodutorWma.getLocation() - segundos);
    }

    /**
     * @see FormatoAudio#liberar()
     */
    @Override
    public void liberar() {
        reprodutorWma = null; // Precisamos forçar a passagem do GC aqui para chamar o método destructor.
        System.gc();
    }
}
