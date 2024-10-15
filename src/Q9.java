import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q9 {

    private static AutomatoFinitoDeterministico criarAutomato() {
        Estado qIgual = new Estado("qIgual");
        Estado qMais0_1 = new Estado("qMais0_1");
        Estado qMais0_2 = new Estado("qMais0_2");
        Estado qMais1_1 = new Estado("qMais1_1");
        Estado qErro = new Estado("qErro");

        Set<Estado> estados = new HashSet<>(Arrays.asList(qIgual, qMais0_1, qMais0_2, qMais1_1, qErro));
        Set<Estado> estadosFinais = new HashSet<>(Arrays.asList(qMais0_1, qMais0_2));

        Set<Character> alfabeto = new HashSet<>(Arrays.asList('0', '1'));

        AutomatoFinitoDeterministico afd = new AutomatoFinitoDeterministico(estados, alfabeto, qIgual, estadosFinais, false);

        afd.definirTransicoes(qIgual, '0', qMais0_1);
        afd.definirTransicoes(qIgual, '1', qMais1_1);
        afd.definirTransicoes(qMais0_1, '0', qMais0_2);
        afd.definirTransicoes(qMais0_1, '1', qIgual);
        afd.definirTransicoes(qMais0_2, '0', qMais0_2);
        afd.definirTransicoes(qMais0_2, '1', qMais0_1);
        afd.definirTransicoes(qMais1_1, '0', qIgual);
        afd.definirTransicoes(qMais1_1, '1', qErro);
        afd.definirTransicoes(qErro, '0', qErro);
        afd.definirTransicoes(qErro, '1', qErro);

        return afd;
    }

    public static void executar() {
        AutomatoFinitoDeterministico afd9 = criarAutomato();
        afd9.exibirResultado("00");
        afd9.exibirResultado("01");
        afd9.exibirResultado("10");
        afd9.exibirResultado("11");
        afd9.exibirResultado("000");
        afd9.exibirResultado("111");
        afd9.exibirResultado("0011010");
        afd9.exibirResultado("110");
        afd9.exibirResultado("0101");
    }
}
