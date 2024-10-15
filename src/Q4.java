import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Q4 {

    private static AutomatoFinitoDeterministico criarAutomato() {
        Estado q0 = new Estado("q0");
        Estado qErro = new Estado("qErro");

        Set<Estado> estados = new HashSet<>(Arrays.asList(q0, qErro));
        Set<Estado> estadosFinais = new HashSet<>(Collections.singletonList(q0));

        Set<Character> alfabeto = new HashSet<>(Arrays.asList('0', '1'));

        AutomatoFinitoDeterministico afd = new AutomatoFinitoDeterministico(estados, alfabeto, q0, estadosFinais, true);

        afd.definirTransicoes(q0, '0', qErro);
        afd.definirTransicoes(q0, '1', qErro);
        afd.definirTransicoes(qErro, '0', qErro);
        afd.definirTransicoes(qErro, '1', qErro);

        return afd;
    }

    public static void executar() {
        AutomatoFinitoDeterministico afd = criarAutomato();
        afd.exibirResultado("");
        afd.exibirResultado("1");
    }
}
