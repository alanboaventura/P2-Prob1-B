package p2.prob1.b;

public class Main {

    public static void main(String args[]) {

        FormatFactory factory = new FormatFactory();

        String arquivo = "asd.aiff";

        FormatoAudio player = factory.getPlayer(arquivo);


        player.abrir(arquivo);
        player.reproduzir();

    }
}
