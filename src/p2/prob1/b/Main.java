package p2.prob1.b;

import p2.prob1.b.facade.FormatoAudioFacade;
import p2.prob1.b.factory.FormatoAudioFactory;

public class Main {

    public static void main(String args[]) {
        System.out.println("WMA:");
        wma();
        System.out.println("");
        System.out.println("");
        System.out.println("AIFF:");
        aiff();
        System.out.println("");
        System.out.println("");
        System.out.println("WAV:");
        wav();
    }

    /*
     * Anotações:
     *
     * Só podemos avançar ou retroceder o audio caso o arquivo esteja
     * reproduzindo.
     * Vai de 10 em 10 segundos para cada instrução.
     */
    private static void wma() {
        final String arquivo = "Teste.wma";

        FormatoAudio reprodutorDeAudio = FormatoAudioFactory.getFormatoAudio(arquivo);
        reprodutorDeAudio.reproduzir();
        reprodutorDeAudio.avancar(20);
        reprodutorDeAudio.pausar();
        reprodutorDeAudio.reproduzir();
        reprodutorDeAudio.retornar(25);
        reprodutorDeAudio.parar();
        reprodutorDeAudio.reproduzir();
        reprodutorDeAudio.parar();
        reprodutorDeAudio.liberar();

        System.out.println("");
        System.out.println("Reproduzir simples:");
        FormatoAudioFacade.reproduzirSimples(arquivo);
        System.out.println("Parar simples:");
        FormatoAudioFacade.pararSimples();
    }

    /*
     * Anotações:
     *
     * Vai de 7 em 7 segundos para cada instrução.
     */
    private static void aiff() {
        final String arquivo = "Teste.aiff";

        FormatoAudio reprodutorDeAudio = FormatoAudioFactory.getFormatoAudio(arquivo);
        reprodutorDeAudio.reproduzir();
        reprodutorDeAudio.pausar();
        reprodutorDeAudio.avancar(20);
        reprodutorDeAudio.reproduzir();
        reprodutorDeAudio.retornar(25);
        reprodutorDeAudio.parar();
        reprodutorDeAudio.reproduzir();
        reprodutorDeAudio.parar();
        reprodutorDeAudio.liberar();

        System.out.println("");
        System.out.println("Reproduzir simples:");
        FormatoAudioFacade.reproduzirSimples(arquivo);
        System.out.println("Parar simples:");
        FormatoAudioFacade.pararSimples();
    }

    /*
     * Anotações:
     *
     * Vai de 7 em 7 segundos para cada instrução.
     */
    private static void wav() {
        final String arquivo = "Teste.wav";

        FormatoAudio reprodutorDeAudio = FormatoAudioFactory.getFormatoAudio(arquivo);
        reprodutorDeAudio.reproduzir();
        reprodutorDeAudio.avancar(20);
        reprodutorDeAudio.pausar();
        reprodutorDeAudio.reproduzir();
        reprodutorDeAudio.retornar(25);
        reprodutorDeAudio.parar();
        reprodutorDeAudio.reproduzir();
        reprodutorDeAudio.parar();
        reprodutorDeAudio.liberar();

        System.out.println("");
        System.out.println("Reproduzir simples:");
        FormatoAudioFacade.reproduzirSimples(arquivo);
        System.out.println("Parar simples:");
        FormatoAudioFacade.pararSimples();
    }
}
