import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q7 {

    private static AutomatoFinitoDeterministico criarAutomato() {
        Estado q0 = new Estado("q0");
        Estado q1 = new Estado("q1");
        Estado q2 = new Estado("q2");
        Estado qAceito0 = new Estado("qAceito0");
        Estado qAceito1 = new Estado("qAceito1");

        Set<Estado> estados = new HashSet<>(Arrays.asList(q0, q1, q2, qAceito0, qAceito1));
        Set<Estado> estadosFinais = new HashSet<>(Arrays.asList(qAceito0, qAceito1));

        Set<Character> alfabeto = new HashSet<>(Arrays.asList('0', '1'));

        AutomatoFinitoDeterministico afd = new AutomatoFinitoDeterministico(estados, alfabeto, q0, estadosFinais, false);

        afd.definirTransicoes(q0, '0', q1);
        afd.definirTransicoes(q0, '1', q2);
        afd.definirTransicoes(q1, '0', q1);
        afd.definirTransicoes(q1, '1', q1);
        afd.definirTransicoes(q1, '0', qAceito0);
        afd.definirTransicoes(q2, '1', q2);
        afd.definirTransicoes(q2, '0', q2);
        afd.definirTransicoes(q2, '1', qAceito1);
        afd.definirTransicoes(qAceito0, '0', qAceito0);
        afd.definirTransicoes(qAceito0, '1', qAceito0);
        afd.definirTransicoes(qAceito1, '0', qAceito1);
        afd.definirTransicoes(qAceito1, '1', qAceito1);

        return afd;
    }

    public static void executar() {
        AutomatoFinitoDeterministico afd7 = criarAutomato();
        afd7.exibirResultado("0");
        afd7.exibirResultado("10");
        afd7.exibirResultado("000");
        afd7.exibirResultado("1001001");
        afd7.exibirResultado("010");
        afd7.exibirResultado("101");
    }
}
