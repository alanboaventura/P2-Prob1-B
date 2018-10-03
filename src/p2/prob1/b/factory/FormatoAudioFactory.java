package p2.prob1.b.factory;

import p2.prob1.b.FormatoAudio;
import p2.prob1.b.adapter.FormatoAudioAacAdapter;
import p2.prob1.b.adapter.FormatoAudioAiffAdapter;
import p2.prob1.b.adapter.FormatoAudioMP3Adapter;
import p2.prob1.b.adapter.FormatoAudioWavAdapter;
import p2.prob1.b.adapter.FormatoAudioWmaAdapter;

import java.security.InvalidParameterException;

/**
 * Factory para criação do objeto para manuseio de uma determinada extensão de arquivo de audio.
 *
 * Extensões suportadas:
 * <ul>
 * <li>WMA</li>
 * <li>AIFF</li>
 * <li>WAV</li>
 * </ul>
 */
public class FormatoAudioFactory {

    /**
     * Retorna um objeto de uma determinada classe (Adapter) para manuseio do arquivo de audio informado via parâmetro.
     *
     * @param arquivo Arquivo que deve ter seu reprodutor (Adapter) retornado.
     * @return Um objeto da classe Adapter que deverá ser responsável pelo manuseio do arquivo informado.
     */
    public static FormatoAudio getFormatoAudio(String arquivo) {
        if (arquivo != null) {
            String extensaoArquivo = arquivo.split("\\.")[1];

            switch (extensaoArquivo) {
                case "wma":
                    return new FormatoAudioWmaAdapter(arquivo);
                case "aiff":
                    return new FormatoAudioAiffAdapter(arquivo);
                case "wav":
                    return new FormatoAudioWavAdapter(arquivo);
                case "aac":
                    return new FormatoAudioAacAdapter(arquivo);
                case "mp3":
                    return new FormatoAudioMP3Adapter(arquivo);
                default:
                    throw new InvalidParameterException("Formato de arquivo de audio INVÁLIDO!");
            }
        }

        return null;
    }
}
