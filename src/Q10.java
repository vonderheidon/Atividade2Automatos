import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Q10 {

    public static void executar() {
        Estado q0 = new Estado("q0");
        Estado q1 = new Estado("q1");
        Estado q2 = new Estado("q2");
        Estado q3 = new Estado("q3");

        Set<Estado> estados = new HashSet<>(Arrays.asList(q0, q1, q2, q3));
        Set<Estado> estadosFinais = new HashSet<>(Collections.singletonList(q3));

        Set<Character> alfabeto = new HashSet<>(Arrays.asList('0', '1'));

        AFN afn = new AFN(estados, alfabeto, q0, estadosFinais);
        afn.definirTransicoes(q0, '0', new HashSet<>(Arrays.asList(q0, q1)));
        afn.definirTransicoes(q0, '1', new HashSet<>(Collections.singletonList(q2)));
        afn.definirTransicoes(q1, '1', new HashSet<>(Collections.singletonList(q3)));
        afn.definirTransicoes(q2, '0', new HashSet<>(Collections.singletonList(q3)));

        AFD afdConvertido = afn.converterParaAFD();

        afdConvertido.exibirResultado("0");
        afdConvertido.exibirResultado("1");
        afdConvertido.exibirResultado("10");
        afdConvertido.exibirResultado("000");
        afdConvertido.exibirResultado("001001");
        afdConvertido.exibirResultado("010");
        afdConvertido.exibirResultado("101");
    }

    public static void main(String[] args) {
        executar();
    }
}
