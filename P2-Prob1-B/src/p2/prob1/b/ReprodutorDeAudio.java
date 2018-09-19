package p2.prob1.b;

import problema1.AIFFSuperPlayer;
import problema1.WAVPlayer;
import problema1.wmaPlay;

public class ReprodutorDeAudio implements FormatoAudio {

    private String extensaoArquivo;

    // Segundos
    private Integer localizaoAudio;

    private wmaPlay wmaPlay;

    private AIFFSuperPlayer aiffSuperPlayer;

    private WAVPlayer wavPlayer;

    @Override
    public void abrir(String arquivo) {
        if (arquivo == null) {
            return;
        }

        extensaoArquivo = arquivo.split(".")[1];

        switch (extensaoArquivo) {
            case "wma":
                wmaPlay = new wmaPlay();
                wmaPlay.setFile(arquivo);
                wmaPlay.open();
                break;
            case "aiff":
                aiffSuperPlayer = new AIFFSuperPlayer(arquivo);
                break;
            case "wav":
                wavPlayer = new WAVPlayer(arquivo);
                break;
        }
    }

    @Override
    public void reproduzir() {
        switch (extensaoArquivo) {
            case "wma":
                wmaPlay.setLocation(localizaoAudio);
                wmaPlay.play();
                break;
            case "aiff":
                aiffSuperPlayer.play();
                break;
            case "wav":
                wavPlayer.play();
                break;
        }
    }

    @Override
    public void pausar() {
        switch (extensaoArquivo) {
            case "wma":
                wmaPlay.stop();
                localizaoAudio = wmaPlay.getLocation();
                break;
            case "aiff":
                localizaoAudio = aiffSuperPlayer.pause();
                break;
            case "wav":
                wavPlayer.stop();
                break;
        }
    }

    @Override
    public void parar() {
        switch (extensaoArquivo) {
            case "wma":
                wmaPlay.stop();
                wmaPlay.setLocation(0);
                break;
            case "aiff":
                aiffSuperPlayer.stop();
                aiffSuperPlayer.setCursor(0);
                break;
            case "wav":
                wavPlayer.stop();
                wavPlayer.reward(wavPlayer.reward(0));
                break;
        }
    }

    @Override
    public void avancar(int segundos) {
        switch (extensaoArquivo) {
            case "wma":
                wmaPlay.setLocation(wmaPlay.getLocation() + segundos);
                break;
            case "aiff":
                final int localizacaoAtual = aiffSuperPlayer.pause();
                aiffSuperPlayer.setCursor(localizacaoAtual + segundos);
                aiffSuperPlayer.play();
                break;
            case "wav":
                wavPlayer.forward(segundos * 1000);
                break;
        }
    }

    @Override
    public void retornar(int segundos) {
        switch (extensaoArquivo) {
            case "wma":
                wmaPlay.setLocation(wmaPlay.getLocation() - segundos);
                break;
            case "aiff":
                final int localizacaoAtual = aiffSuperPlayer.pause();
                aiffSuperPlayer.setCursor(localizacaoAtual - segundos);
                aiffSuperPlayer.play();
                break;
            case "wav":
                wavPlayer.reward(segundos * 1000);
                break;
        }
    }

    @Override
    public void liberar() {
        switch (extensaoArquivo) {
            case "wma":
                // Rever isso.
                wmaPlay.stop();
                wmaPlay = null;
                System.gc();
                break;
            case "aiff":
                aiffSuperPlayer.release();
                break;
            case "wav":
                wavPlayer.stop(); // Ver se precisa parar.
                wavPlayer = null;
                System.gc(); // Precisamos forçar a passagem do GC aqui para chamar o método destructor.
                break;
        }
    }
}
