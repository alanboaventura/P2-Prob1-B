package p2.prob1.b;


public class FormatFactory {

    public FormatoAudio getPlayer(String arquivo){
        String ext = arquivo.split("\\.")[1];
        switch (ext){
            case "aiff":
                return new AIFFPlayer();
            case "wma":
                return new WMAPlayer();
            case "wav":
                return new WAVPlayer();
            case "mp3":
                return new MP3Player();
        }
        return null;
    }
}
