import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q3 {

    private static AutomatoFinitoDeterministico criarAutomato() {
        Estado q0 = new Estado("q0");
        Estado q1 = new Estado("q1");
        Estado qErro = new Estado("qErro");

        Set<Estado> estados = new HashSet<>(Arrays.asList(q0, q1, qErro));
        Set<Estado> estadosFinais = new HashSet<>(Arrays.asList(q1));

        Set<Character> alfabeto = new HashSet<>(Arrays.asList('0', '1'));

        AutomatoFinitoDeterministico afd = new AutomatoFinitoDeterministico(estados, alfabeto, q0, estadosFinais, false);

        afd.definirTransicoes(q0, '0', q1);
        afd.definirTransicoes(q0, '1', qErro);
        afd.definirTransicoes(q1, '0', q1);
        afd.definirTransicoes(q1, '1', q1);
        afd.definirTransicoes(qErro, '0', qErro);
        afd.definirTransicoes(qErro, '1', qErro);

        return afd;
    }

    public static void executar() {
        AutomatoFinitoDeterministico afd = criarAutomato();
        afd.exibirResultado("0111");
        afd.exibirResultado("1110");
        afd.exibirResultado("0");
        afd.exibirResultado("10");
    }
}
