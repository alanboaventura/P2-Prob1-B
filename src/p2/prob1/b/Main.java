package p2.prob1.b;

import p2.prob1.b.facade.FormatoAudioFacade;
import p2.prob1.b.factory.FormatoAudioFactory;

public class Main {

    public static void main(String args[]) {
        System.out.println("WMA:");
        wma();
        System.out.println();
        System.out.println();
        System.out.println("AIFF:");
        aiff();
        System.out.println();
        System.out.println();
        System.out.println("WAV:");
        wav();
        System.out.println();
        System.out.println();
        System.out.println("AAC:");
        aac();
        System.out.println();
        System.out.println();
        System.out.println("MP3:");
        mp3();
    }

    private static void wma() {
        final String arquivo = "Teste.wma";
        testar(arquivo);
    }

    private static void aiff() {
        final String arquivo = "Teste.aiff";
        testar(arquivo);
    }

    private static void wav() {
        final String arquivo = "Teste.wav";
        testar(arquivo);
    }

    private static void aac() {
        final String arquivo = "Teste.aac";
        testar(arquivo);
    }

    private static void mp3() {
        final String arquivo = "Teste.mp3";
        testar(arquivo);
    }

    private static void testar(String arquivo) {
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
