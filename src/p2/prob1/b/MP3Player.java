package p2.prob1.b;

import problema1.MP3DJ;

public class MP3Player implements FormatoAudio {
    MP3DJ player;
    @Override
    public void abrir(String arquivo) {
        player = new MP3DJ();
        player.setFile(arquivo);
    }

    @Override
    public void reproduzir() {
        player.play();
    }

    @Override
    public void pausar() {
        player.stop();
    }

    @Override
    public void parar() {
        player.stop();
        player.reward(player.reward(0));
    }

    @Override
    public void avancar(int segundos) {
        player.forward(segundos);
    }

    @Override
    public void retornar(int segundos) {
        player.reward(segundos);
    }

    @Override
    public void liberar() {
        player = null;
    }

    @Override
    public void reproduzirSimples(String arquivo) {
        player = new MP3DJ();
        player.setFile(arquivo);
        player.play();
    }

    @Override
    public void pararSimples() {
        player.stop();
        player = null;
    }
}
