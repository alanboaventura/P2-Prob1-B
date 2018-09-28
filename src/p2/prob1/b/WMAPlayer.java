package p2.prob1.b;

import problema1.wmaPlay;

public class WMAPlayer implements  FormatoAudio {

    wmaPlay player;

    @Override
    public void abrir(String arquivo) {
        player = new wmaPlay();
        player.setFile(arquivo);
        player.open();
        player.setLocation(0);
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
        player.stop();
    }

    @Override
    public void avancar(int segundos) {
        player.setLocation(player.getLocation() + segundos);
    }

    @Override
    public void retornar(int segundos) {
        player.setLocation(player.getLocation() - segundos);
    }

    @Override
    public void liberar() {
        player = null;
    }

    @Override
    public void reproduzirSimples(String arquivo) {
        player = new wmaPlay();
        player.setFile(arquivo);
        player.open();
        player.setLocation(0);
        player.play();
    }

    @Override
    public void pararSimples() {
        player.stop();
        player.stop();
        player = null;
    }
}
