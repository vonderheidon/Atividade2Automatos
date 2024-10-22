import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q2 {

    private static AFD criarAutomato() {
        Estado q0 = new Estado("q0");
        Estado q1 = new Estado("q1");
        Estado q3 = new Estado("q3");

        Set<Estado> estados = new HashSet<>(Arrays.asList(q0, q1, q3));
        Set<Estado> estadosFinais = new HashSet<>(Arrays.asList(q1));

        Set<Character> alfabeto = new HashSet<>(Arrays.asList('0', '1'));

        AFD afd = new AFD(estados, alfabeto, q0, estadosFinais, false);

        afd.definirTransicoes(q0, '0', q1);
        afd.definirTransicoes(q0, '1', q3);
        afd.definirTransicoes(q1, '0', q1);
        afd.definirTransicoes(q1, '1', q1);
        afd.definirTransicoes(q3, '0', q3);
        afd.definirTransicoes(q3, '1', q3);

        return afd;
    }

    public static void executar() {
        AFD afd = criarAutomato();
        afd.exibirResultado("0111");
        afd.exibirResultado("1110");
        afd.exibirResultado("0");
        afd.exibirResultado("10");
    }

    public static void main(String[] args) {
        executar();
    }

}
