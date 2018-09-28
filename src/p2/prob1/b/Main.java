package p2.prob1.b;

public class Main {

    public static void main(String args[]) {

        FormatoAudio player = null;


        String file = "wav";

        switch (file){
            case "aiff":
                player = new AIFFPlayer();
                break;
            case "wma":
                player = new WMAPlayer();
                break;
            case "wav":
                player = new WAVPlayer();
                break;
        }

        player.abrir(file);
        player.reproduzir();

    }
}
