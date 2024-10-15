import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Q8 {

    private static AutomatoFinitoDeterministico criarAutomato() {
        Estado qPar = new Estado("qPar");
        Estado qImpar = new Estado("qImpar");
        Estado qErro = new Estado("qErro");

        Set<Estado> estados = new HashSet<>(Arrays.asList(qPar, qImpar, qErro));
        Set<Estado> estadosFinais = new HashSet<>(Collections.singletonList(qImpar));

        Set<Character> alfabeto = new HashSet<>(Arrays.asList('0', '1'));

        AutomatoFinitoDeterministico afd = new AutomatoFinitoDeterministico(estados, alfabeto, qPar, estadosFinais, false);

        afd.definirTransicoes(qPar, '0', qPar);
        afd.definirTransicoes(qPar, '1', qImpar);
        afd.definirTransicoes(qImpar, '0', qPar);
        afd.definirTransicoes(qImpar, '1', qPar);
        afd.definirTransicoes(qErro, '0', qErro);
        afd.definirTransicoes(qErro, '1', qErro);

        return afd;
    }

    public static void executar() {
        AutomatoFinitoDeterministico afd8 = criarAutomato();
        afd8.exibirResultado("1");
        afd8.exibirResultado("011");
        afd8.exibirResultado("111");
        afd8.exibirResultado("0");
        afd8.exibirResultado("000");
        afd8.exibirResultado("101");
        afd8.exibirResultado("10101");
        afd8.exibirResultado("1110111");
    }
}
