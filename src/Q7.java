import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q7 {

    private static AFD criarAutomato() {
        Estado q0 = new Estado("q0");
        Estado q1 = new Estado("q1");
        Estado q2 = new Estado("q2");
        Estado q3 = new Estado("q3");
        Estado q4 = new Estado("q4");

        Set<Estado> estados = new HashSet<>(Arrays.asList(q0, q1, q2, q3, q4));
        Set<Estado> estadosFinais = new HashSet<>(Arrays.asList(q1, q2));

        Set<Character> alfabeto = new HashSet<>(Arrays.asList('0', '1'));

        AFD afd = new AFD(estados, alfabeto, q0, estadosFinais, false);

        afd.definirTransicoes(q0, '0', q1);
        afd.definirTransicoes(q0, '1', q2);
        afd.definirTransicoes(q1, '0', q1);
        afd.definirTransicoes(q1, '1', q3);
        afd.definirTransicoes(q2, '0', q4);
        afd.definirTransicoes(q2, '1', q2);
        afd.definirTransicoes(q3, '0', q1);
        afd.definirTransicoes(q3, '1', q3);
        afd.definirTransicoes(q4, '0', q4);
        afd.definirTransicoes(q4, '1', q2);

        return afd;
    }

    public static void executar() {
        AFD afd7 = criarAutomato();
        afd7.exibirResultado("0");
        afd7.exibirResultado("1");
        afd7.exibirResultado("10");
        afd7.exibirResultado("000");
        afd7.exibirResultado("001001");
        afd7.exibirResultado("010");
        afd7.exibirResultado("101");
    }

    public static void main(String[] args) {
        executar();
    }

}
