import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Q4 {

    private static AutomatoFinitoDeterministico criarAutomato() {
        Estado q0 = new Estado("q0");
        Estado q1 = new Estado("q1");

        Set<Estado> estados = new HashSet<>(Arrays.asList(q0, q1));
        Set<Estado> estadosFinais = new HashSet<>(Collections.singletonList(q0));

        Set<Character> alfabeto = new HashSet<>(Arrays.asList('0', '1'));

        AutomatoFinitoDeterministico afd = new AutomatoFinitoDeterministico(estados, alfabeto, q0, estadosFinais, true);

        afd.definirTransicoes(q0, '0', q1);
        afd.definirTransicoes(q0, '1', q1);
        afd.definirTransicoes(q1, '0', q1);
        afd.definirTransicoes(q1, '1', q1);

        return afd;
    }

    public static void executar() {
        AutomatoFinitoDeterministico afd = criarAutomato();
        afd.exibirResultado("");
        afd.exibirResultado("1");
        afd.exibirResultado("10");
        afd.exibirResultado("0");
        afd.exibirResultado("a");
    }

    public static void main(String[] args) {
        executar();
    }

}
