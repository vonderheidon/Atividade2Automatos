import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Q6 {

    private static AutomatoFinitoDeterministico criarAutomato() {
        Estado q0 = new Estado("q0");
        Estado q1 = new Estado("q1");
        Estado q2 = new Estado("q2");
        Estado qAceito = new Estado("qAceito");

        Set<Estado> estados = new HashSet<>(Arrays.asList(q0, q1, q2, qAceito));
        Set<Estado> estadosFinais = new HashSet<>(Collections.singletonList(qAceito));

        Set<Character> alfabeto = new HashSet<>(Arrays.asList('0', '1'));

        AutomatoFinitoDeterministico afd = new AutomatoFinitoDeterministico(estados, alfabeto, q0, estadosFinais, false);

        afd.definirTransicoes(q0, '0', q1);
        afd.definirTransicoes(q0, '1', q0);
        afd.definirTransicoes(q1, '0', q1);
        afd.definirTransicoes(q1, '1', q2);
        afd.definirTransicoes(q2, '0', qAceito);
        afd.definirTransicoes(q2, '1', q0);
        afd.definirTransicoes(qAceito, '0', qAceito);
        afd.definirTransicoes(qAceito, '1', qAceito);

        return afd;
    }

    public static void executar() {
        AutomatoFinitoDeterministico afd6 = criarAutomato();
        afd6.exibirResultado("010");
        afd6.exibirResultado("101010");
        afd6.exibirResultado("00101");
        afd6.exibirResultado("111");
        afd6.exibirResultado("000");
    }
}
