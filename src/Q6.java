import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Q6 {

    private static AFD criarAutomato() {
        Estado q0 = new Estado("q0");
        Estado q1 = new Estado("q1");
        Estado q2 = new Estado("q2");
        Estado q3 = new Estado("q3");

        Set<Estado> estados = new HashSet<>(Arrays.asList(q0, q1, q2, q3));
        Set<Estado> estadosFinais = new HashSet<>(Collections.singletonList(q3));

        Set<Character> alfabeto = new HashSet<>(Arrays.asList('0', '1'));

        AFD afd = new AFD(estados, alfabeto, q0, estadosFinais, false);

        afd.definirTransicoes(q0, '0', q1);
        afd.definirTransicoes(q0, '1', q0);
        afd.definirTransicoes(q1, '0', q1);
        afd.definirTransicoes(q1, '1', q2);
        afd.definirTransicoes(q2, '0', q3);
        afd.definirTransicoes(q2, '1', q0);
        afd.definirTransicoes(q3, '0', q3);
        afd.definirTransicoes(q3, '1', q3);

        return afd;
    }

    public static void executar() {
        AFD afd6 = criarAutomato();
        afd6.exibirResultado("010");
        afd6.exibirResultado("101010");
        afd6.exibirResultado("00101");
        afd6.exibirResultado("111");
        afd6.exibirResultado("000");
        afd6.exibirResultado("000110");
    }

    public static void main(String[] args) {
        executar();
    }

}
