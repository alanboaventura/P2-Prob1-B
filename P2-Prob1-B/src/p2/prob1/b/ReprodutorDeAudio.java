package p2.prob1.b;

import problema1.AIFFSuperPlayer;
import problema1.WAVPlayer;
import problema1.wmaPlay;

public class ReprodutorDeAudio implements FormatoAudio {

    private String extensaoArquivo;

    // Segundos
    private Integer localizaoAudio;

    private Object audio;
    
    
    @Override
    public void abrir(String arquivo) {
        if (arquivo == null) {
            return;
        }

        extensaoArquivo = arquivo.split(".")[1];

        switch (extensaoArquivo) {
            case "wma":
                audio = new wmaPlay();
                ((wmaPlay)audio).setFile(arquivo);
                ((wmaPlay)audio).open();
                break;
            case "aiff":
                audio = new AIFFSuperPlayer(arquivo);
                break;
            case "wav":
                audio = new WAVPlayer(arquivo);
                break;
        }
    }

    @Override
    public void reproduzir() {
        switch (extensaoArquivo) {
            case "wma":
                ((wmaPlay)audio).setLocation(localizaoAudio);
                ((wmaPlay)audio).play();
                break;
            case "aiff":
                ((AIFFSuperPlayer)audio).play();
                break;
            case "wav":
                ((WAVPlayer)audio).play();
                break;
        }
    }

    @Override
    public void pausar() {
        switch (extensaoArquivo) {
            case "wma":
                ((wmaPlay)audio).stop();
                localizaoAudio = ((wmaPlay)audio).getLocation();
                break;
            case "aiff":
                localizaoAudio = ((AIFFSuperPlayer)audio).pause();
                break;
            case "wav":
                ((WAVPlayer)audio).stop();
                break;
        }
    }

    @Override
    public void parar() {
        switch (extensaoArquivo) {
            case "wma":
                ((wmaPlay)audio).stop();
                ((wmaPlay)audio).setLocation(0);
                break;
            case "aiff":
                ((AIFFSuperPlayer)audio).stop();
                ((AIFFSuperPlayer)audio).setCursor(0);
                break;
            case "wav":
                ((WAVPlayer)audio).stop();
                ((WAVPlayer)audio).reward(((WAVPlayer)audio).reward(0));
                break;
        }
    }

    @Override
    public void avancar(int segundos) {
        switch (extensaoArquivo) {
            case "wma":
                ((wmaPlay)audio).setLocation(((wmaPlay)audio).getLocation() + segundos);
                break;
            case "aiff":
                ((AIFFSuperPlayer)audio).setCursor(((AIFFSuperPlayer)audio).pause() + segundos);
                ((AIFFSuperPlayer)audio).play();
                break;
            case "wav":
                ((WAVPlayer)audio).forward(segundos * 1000);
                break;
        }
    }

    @Override
    public void retornar(int segundos) {
        switch (extensaoArquivo) {
            case "wma":
                ((wmaPlay)audio).setLocation(((wmaPlay)audio).getLocation() - segundos);
                break;
            case "aiff":
                final int localizacaoAtual = ((AIFFSuperPlayer)audio).pause();
                ((AIFFSuperPlayer)audio).setCursor(localizacaoAtual - segundos);
                ((AIFFSuperPlayer)audio).play();
                break;
            case "wav":
                ((WAVPlayer)audio).reward(segundos * 1000);
                break;
        }
    }

    @Override
    public void liberar() {
        switch (extensaoArquivo) {
            case "wma":
                // Rever isso.
                ((wmaPlay)audio).stop();
                audio = null;
                System.gc();
                break;
            case "aiff":
                ((AIFFSuperPlayer)audio).release();
                break;
            case "wav":
                ((WAVPlayer)audio).stop(); // Ver se precisa parar.
                audio = null;
                System.gc(); // Precisamos forçar a passagem do GC aqui para chamar o método destructor.
                break;
        }
    }
}
