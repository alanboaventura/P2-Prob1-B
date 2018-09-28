package p2.prob1.b;

public class WAVPlayer implements FormatoAudio {

    problema1.WAVPlayer player;

    @Override
    public void abrir(String arquivo) {
        player = new problema1.WAVPlayer(arquivo);
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
        player.reward(player.reward(0));
        player.stop();
    }

    @Override
    public void avancar(int segundos) {
        player.forward(player.forward(0) + (segundos * 1000));
    }

    @Override
    public void retornar(int segundos) {
        player.reward(player.reward(0) - (segundos * 1000));
    }

    @Override
    public void liberar() {
        player = null;
    }

    @Override
    public void reproduzirSimples(String arquivo) {
        player = new problema1.WAVPlayer(arquivo);
        player.play();
    }

    @Override
    public void pararSimples() {
        player.reward(player.reward(0));
        player.stop();
        player = null;
    }
}
