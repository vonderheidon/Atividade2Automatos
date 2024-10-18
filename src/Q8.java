import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Q8 {

    private static AutomatoFinitoDeterministico criarAutomato() {
        Estado q0 = new Estado("q0");
        Estado q1 = new Estado("q1");
        Estado q2 = new Estado("q2");

        Set<Estado> estados = new HashSet<>(Arrays.asList(q0, q1, q2));
        Set<Estado> estadosFinais = new HashSet<>(Collections.singletonList(q1));

        Set<Character> alfabeto = new HashSet<>(Arrays.asList('0', '1'));

        AutomatoFinitoDeterministico afd = new AutomatoFinitoDeterministico(estados, alfabeto, q0, estadosFinais, false);

        afd.definirTransicoes(q0, '0', q0);
        afd.definirTransicoes(q0, '1', q1);
        afd.definirTransicoes(q1, '0', q0);
        afd.definirTransicoes(q1, '1', q0);
        afd.definirTransicoes(q2, '0', q2);
        afd.definirTransicoes(q2, '1', q2);

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

    public static void main(String[] args) {
        executar();
    }

}
