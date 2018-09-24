package p2.prob1.b;

public class Main {

    public static void main(String args[]) {
        ReprodutorDeAudio reprodutorDeAudio = new ReprodutorDeAudio();

        System.out.println("WMA:");
        wma(reprodutorDeAudio);
        System.out.println("");
        System.out.println("");
        System.out.println("AIFF:");
        aiff(reprodutorDeAudio);
        System.out.println("");
        System.out.println("");
        System.out.println("WAV:");
        wav(reprodutorDeAudio);
    }

    /*
     * Anotações:
     *
     * Só podemos avançar ou retroceder o audio caso o arquivo esteja
     * reproduzindo. 
     * Vai de 10 em 10 segundos para cada instrução.
     */
    private static void wma(ReprodutorDeAudio reprodutorDeAudio) {
        final String arquivo = "Teste.wma";

        reprodutorDeAudio.abrir(arquivo);
        reprodutorDeAudio.reproduzir();
        reprodutorDeAudio.avancar(20);
        reprodutorDeAudio.pausar();
        reprodutorDeAudio.reproduzir();
        reprodutorDeAudio.retornar(25);
        reprodutorDeAudio.liberar();

        System.out.println("");
        System.out.println("Reproduzir simples:");
        reprodutorDeAudio.reproduzirSimples(arquivo);
        System.out.println("Parar simples:");
        reprodutorDeAudio.pararSimples();
    }

    /*
     * Anotações:
     *
     * Vai de 7 em 7 segundos para cada instrução.
     */
    private static void aiff(ReprodutorDeAudio reprodutorDeAudio) {
        final String arquivo = "Teste.aiff";

        reprodutorDeAudio.abrir(arquivo);
        reprodutorDeAudio.reproduzir();
        reprodutorDeAudio.pausar();
        reprodutorDeAudio.avancar(20);
        reprodutorDeAudio.reproduzir();
        reprodutorDeAudio.retornar(25);
        reprodutorDeAudio.liberar();

        System.out.println("");
        System.out.println("Reproduzir simples:");
        reprodutorDeAudio.reproduzirSimples(arquivo);
        System.out.println("Parar simples:");
        reprodutorDeAudio.pararSimples();
    }

    /*
     * Anotações: 
     * 
     * Vai de 7 em 7 segundos para cada instrução.
     */
    private static void wav(ReprodutorDeAudio reprodutorDeAudio) {
        final String arquivo = "Teste.wav";

        reprodutorDeAudio.abrir(arquivo);
        reprodutorDeAudio.reproduzir();
        reprodutorDeAudio.avancar(50);
        reprodutorDeAudio.pausar();
        reprodutorDeAudio.retornar(50);
        reprodutorDeAudio.reproduzir();
        reprodutorDeAudio.liberar();

        System.out.println("");
        System.out.println("Reproduzir simples:");
        reprodutorDeAudio.reproduzirSimples(arquivo);
        System.out.println("Parar simples:");
        reprodutorDeAudio.pararSimples();
    }
}
