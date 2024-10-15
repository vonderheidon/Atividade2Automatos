import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AutomatoFinitoDeterministico {

    private Set<Estado> estados;
    private Set<Character> alfabeto;
    private Estado estadoInicial;
    private Set<Estado> estadosFinais;
    private Map<Estado, Map<Character, Estado>> funcaoDeTransicao;
    private boolean aceitaCadeiaVazia;


    public AutomatoFinitoDeterministico(Set<Estado> estados, Set<Character> alfabeto, Estado estadoInicial, Set<Estado> estadosFinais, boolean aceitaCadeiaVazia) {
        this.estados = estados;
        this.alfabeto = alfabeto;
        this.estadoInicial = estadoInicial;
        this.estadosFinais = estadosFinais;
        this.aceitaCadeiaVazia = aceitaCadeiaVazia;
        this.funcaoDeTransicao = new HashMap<>();

        for (Estado estado : this.estados) {
            this.funcaoDeTransicao.put(estado, new HashMap<>());
        }
    }

    public void definirTransicoes(Estado estadoOrigem, Character simbolo, Estado estadoDestino) {
        this.funcaoDeTransicao.get(estadoOrigem).put(simbolo, estadoDestino);
    }

    public void verificarCadeia(String cadeia) {
        Estado estadoAtual = estadoInicial;

        for (char simbolo : cadeia.toCharArray()) {
            if (!this.alfabeto.contains(simbolo)) {
                System.out.println("Cadeia Rejeitada: Símbolo inválido '" + simbolo + "' na cadeia " + cadeia);
                return;
            }
            if (funcaoDeTransicao.get(estadoAtual).get(simbolo) == null) {
                System.out.println("Cadeia Rejeitada: Não há transição definida para o símbolo '" + simbolo + "'");
                return;
            }
            estadoAtual = funcaoDeTransicao.get(estadoAtual).get(simbolo);
        }

        if (this.estadosFinais.contains(estadoAtual)) {
            System.out.println("Cadeia Aceita: " + cadeia);
        } else {
            System.out.println("Cadeia Rejeitada: " + cadeia);
        }
    }

    public void exibirResultado(String cadeia) {
        if (cadeia.isEmpty() && aceitaCadeiaVazia) {
            System.out.println("Cadeia Vazia Aceita");
        } else if (cadeia.isEmpty()) {
            System.out.println("Cadeia Rejeitada: (vazia)");
        } else {
            verificarCadeia(cadeia);
        }
    }
}
