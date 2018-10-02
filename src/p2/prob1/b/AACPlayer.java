package p2.prob1.b;

public class AACPlayer implements FormatoAudio {
    problema1.AACPlayer player;
    @Override
    public void abrir(String arquivo) {
        player = new problema1.AACPlayer(arquivo);
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

    }

    @Override
    public void pararSimples() {

    }
}
