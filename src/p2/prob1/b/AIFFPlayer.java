    package p2.prob1.b;

import problema1.AIFFSuperPlayer;

public class AIFFPlayer implements FormatoAudio {

    AIFFSuperPlayer player;

    @Override
    public void abrir(String arquivo) {
        player = new AIFFSuperPlayer(arquivo);
    }

    @Override
    public void reproduzir() {
        player.play();
    }

    @Override
    public void pausar() {
        player.pause();
    }

    @Override
    public void parar() {
        player.stop();
    }

    @Override
    public void avancar(int segundos) {
        player.setCursor(player.pause() + segundos);
        player.play();
    }

    @Override
    public void retornar(int segundos) {
        player.setCursor(player.pause() - segundos);
        player.play();
    }

    @Override
    public void liberar() {
        player.release();
    }

    @Override
    public void reproduzirSimples(String arquivo) {
        player = new AIFFSuperPlayer(arquivo);
        player.play();
    }

    @Override
    public void pararSimples() {
        player.stop();
        player.release();
    }
}
