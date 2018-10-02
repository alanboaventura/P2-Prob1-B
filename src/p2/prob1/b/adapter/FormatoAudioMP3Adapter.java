package p2.prob1.b.adapter;

import p2.prob1.b.FormatoAudio;
import problema1.MP3DJ;

public class FormatoAudioMP3Adapter implements FormatoAudio {

    private MP3DJ reprodutor;

    @Override
    public void abrir(String arquivo) {
        reprodutor = new MP3DJ();
        reprodutor.setFile(arquivo);
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
        reprodutor.reward(reprodutor.reward(0));
    }

    @Override
    public void avancar(int segundos) {
        reprodutor.forward(segundos);
    }

    @Override
    public void retornar(int segundos) {
        reprodutor.reward(segundos);
    }

    @Override
    public void liberar() {
        reprodutor = null; // Precisamos forçar a passagem do GC aqui para chamar o método destructor.
        System.gc();
    }
}