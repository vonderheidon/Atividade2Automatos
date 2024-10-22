import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Q5 {

    private static AFD criarAutomato() {
        Estado q0 = new Estado("q0");

        Set<Estado> estados = new HashSet<>(Collections.singletonList(q0));
        Set<Estado> estadosFinais = new HashSet<>(Collections.singletonList(q0));

        Set<Character> alfabeto = new HashSet<>(Arrays.asList('0', '1'));

        AFD afd = new AFD(estados, alfabeto, q0, estadosFinais, false);

        afd.definirTransicoes(q0, '0', q0);
        afd.definirTransicoes(q0, '1', q0);

        return afd;
    }

    public static void executar() {
        AFD afd = criarAutomato();
        afd.exibirResultado("1");
        afd.exibirResultado("0");
        afd.exibirResultado("010");
        afd.exibirResultado("02");
    }

    public static void main(String[] args) {
        executar();
    }

}
