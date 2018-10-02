package p2.prob1.b.adapter;

import p2.prob1.b.FormatoAudio;
import problema1.AACPlayer;

public class FormatoAudioAacAdapter implements FormatoAudio {

    private AACPlayer reprodutor;

    @Override
    public void abrir(String arquivo) {
        reprodutor = new AACPlayer(arquivo);
        reprodutor.open();
        reprodutor.setLocation(0);
    }

    @Override
    public void reproduzir() {
        reprodutor.play();
    }

    @Override
    public void pausar() {
        reprodutor.stop();
    }

    @Override
    public void parar() {
        reprodutor.stop();
        reprodutor.stop();
    }

    @Override
    public void avancar(int segundos) {
        reprodutor.setLocation(reprodutor.getLocation() + segundos);
    }

    @Override
    public void retornar(int segundos) {
        reprodutor.setLocation(reprodutor.getLocation() - segundos);
    }

    @Override
    public void liberar() {
        reprodutor = null; // Precisamos forçar a passagem do GC aqui para chamar o método destructor.
        System.gc();
    }
}