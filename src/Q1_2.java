import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q1_2 {
    private static AFD criarAutomato() {
        Estado q0 = new Estado("q0");
        Estado q1 = new Estado("q1");
        Estado q2 = new Estado("q2");

        Set<Estado> estados = new HashSet<>(Arrays.asList(q0, q1, q2));
        Set<Estado> estadosFinais = new HashSet<>(Arrays.asList(q2));

        Set<Character> alfabeto = new HashSet<>(Arrays.asList('0', '1'));

        AFD afd = new AFD(estados, alfabeto, q0, estadosFinais, false);

        afd.definirTransicoes(q0, '0', q1);
        afd.definirTransicoes(q0, '1', q0);
        afd.definirTransicoes(q1, '0', q2);
        afd.definirTransicoes(q1, '1', q1);
        afd.definirTransicoes(q2, '0', q2);
        afd.definirTransicoes(q2, '1', q2);

        return afd;
    }

    public static void executar() {
        AFD afd = criarAutomato();
        afd.exibirResultado("010");
        afd.exibirResultado("00");
        afd.exibirResultado("011");
        afd.exibirResultado("0");
        afd.exibirResultado("1111111100");
    }

    public static void main(String[] args) {
        executar();
    }

}