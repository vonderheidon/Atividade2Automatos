import java.util.HashSet;
import java.util.Set;

public class Q1_1 {

    private static AFD criarAutomato() {
        Estado q0 = new Estado("q0");
        Estado q1 = new Estado("q1");

        Set<Estado> estados = new HashSet<>(Set.of(q0, q1));
        Set<Estado> estadosFinais = new HashSet<>(Set.of(q1));
        Set<Character> alfabeto = new HashSet<>(Set.of('0', '1'));

        AFD afd = new AFD(estados, alfabeto, q0, estadosFinais, false);

        afd.definirTransicoes(q0, '0', q0);
        afd.definirTransicoes(q0, '1', q1);
        afd.definirTransicoes(q1, '0', q1);
        afd.definirTransicoes(q1, '1', q1);

        return afd;
    }

    public static void executar() {
        AFD afd = criarAutomato();
        afd.exibirResultado("1000");
        afd.exibirResultado("0001");
        afd.exibirResultado("000");
        afd.exibirResultado("1");
        afd.exibirResultado("0");
    }

    public static void main(String[] args) {
        executar();
    }

}
