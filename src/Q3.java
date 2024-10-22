import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Q3 {

    private static AFD criarAutomato() {
        Estado q0 = new Estado("q0");
        Estado q1 = new Estado("q1");

        Set<Estado> estados = new HashSet<>(Arrays.asList(q0, q1));
        Set<Estado> estadosFinais = new HashSet<>(Collections.singletonList(q0));

        Set<Character> alfabeto = new HashSet<>();

        AFD afd = new AFD(estados, alfabeto, q0, estadosFinais, false);

        afd.definirTransicoes(q0, '0', q1);
        afd.definirTransicoes(q0, '1', q1);
        afd.definirTransicoes(q1, '0', q1);
        afd.definirTransicoes(q1, '1', q1);

        return afd;
    }

    public static void executar() {
        AFD afd3 = criarAutomato();
        afd3.exibirResultado("");
        afd3.exibirResultado("0");
        afd3.exibirResultado("1");
        afd3.exibirResultado("01");
        afd3.exibirResultado("10");
        afd3.exibirResultado("AAA");
    }

    public static void main(String[] args) {
        executar();
    }

}
