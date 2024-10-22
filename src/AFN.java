import java.util.*;

public class AFN {
    private Set<Estado> estados;
    private Set<Character> alfabeto;
    private Estado estadoInicial;
    private Set<Estado> estadosFinais;
    private Map<Estado, Map<Character, Set<Estado>>> funcaoDeTransicao;

    public AFN(Set<Estado> estados, Set<Character> alfabeto, Estado estadoInicial, Set<Estado> estadosFinais) {
        this.estados = estados;
        this.alfabeto = alfabeto;
        this.estadoInicial = estadoInicial;
        this.estadosFinais = estadosFinais;
        this.funcaoDeTransicao = new HashMap<>();
        for (Estado estado : this.estados) {
            this.funcaoDeTransicao.put(estado, new HashMap<>());
            for (char simbolo : alfabeto) {
                this.funcaoDeTransicao.get(estado).put(simbolo, new HashSet<>());
            }
            this.funcaoDeTransicao.get(estado).put(null, new HashSet<>());
        }
    }

    public void definirTransicoes(Estado estadoOrigem, Character simbolo, Set<Estado> estadosDestino) {
        this.funcaoDeTransicao.get(estadoOrigem).get(simbolo).addAll(estadosDestino);
    }

    public Set<Estado> mover(Estado estado, Character simbolo) {
        return this.funcaoDeTransicao.get(estado).get(simbolo);
    }

    public AFD converterParaAFD() {
        Set<Set<Estado>> novosEstados = new HashSet<>();
        Map<Set<Estado>, Map<Character, Set<Estado>>> novaFuncaoDeTransicao = new HashMap<>();
        Set<Set<Estado>> estadosFinaisAFD = new HashSet<>();

        Set<Estado> estadoInicialAFD = epsilon(Collections.singleton(this.estadoInicial));
        Queue<Set<Estado>> fila = new LinkedList<>();
        fila.add(estadoInicialAFD);
        novosEstados.add(estadoInicialAFD);

        while (!fila.isEmpty()) {
            Set<Estado> conjuntoAtual = fila.poll();
            novaFuncaoDeTransicao.put(conjuntoAtual, new HashMap<>());

            for (char simbolo : this.alfabeto) {
                Set<Estado> moverResultado = new HashSet<>();
                for (Estado estado : conjuntoAtual) {
                    moverResultado.addAll(mover(estado, simbolo));
                }

                Set<Estado> fechoMoverResultado = epsilon(moverResultado);

                if (!novosEstados.contains(fechoMoverResultado)) {
                    novosEstados.add(fechoMoverResultado);
                    fila.add(fechoMoverResultado);
                }

                novaFuncaoDeTransicao.get(conjuntoAtual).put(simbolo, fechoMoverResultado);

                if (!Collections.disjoint(fechoMoverResultado, this.estadosFinais)) {
                    estadosFinaisAFD.add(fechoMoverResultado);
                }
            }
        }

        Set<Estado> novosEstadosAFD = new HashSet<>();
        Map<Set<Estado>, Estado> mapeamentoDeEstados = new HashMap<>();
        for (Set<Estado> conjuntoEstados : novosEstados) {
            Estado novoEstado = new Estado(conjuntoEstados.toString());
            novosEstadosAFD.add(novoEstado);
            mapeamentoDeEstados.put(conjuntoEstados, novoEstado);
        }

        Set<Estado> novosEstadosFinaisAFD = new HashSet<>();
        for (Set<Estado> estadosFinaisConjunto : estadosFinaisAFD) {
            novosEstadosFinaisAFD.add(mapeamentoDeEstados.get(estadosFinaisConjunto));
        }

        AFD afd = new AFD(
                novosEstadosAFD, this.alfabeto, mapeamentoDeEstados.get(estadoInicialAFD), novosEstadosFinaisAFD, false
        );

        for (Map.Entry<Set<Estado>, Map<Character, Set<Estado>>> transicao : novaFuncaoDeTransicao.entrySet()) {
            Estado estadoOrigem = mapeamentoDeEstados.get(transicao.getKey());
            for (Map.Entry<Character, Set<Estado>> entradaTransicao : transicao.getValue().entrySet()) {
                afd.definirTransicoes(estadoOrigem, entradaTransicao.getKey(), mapeamentoDeEstados.get(entradaTransicao.getValue()));
            }
        }

        return afd;
    }

    private Set<Estado> epsilon(Set<Estado> estados) {
        Set<Estado> fecho = new HashSet<>(estados);
        Stack<Estado> pilha = new Stack<>();
        pilha.addAll(estados);

        while (!pilha.isEmpty()) {
            Estado estado = pilha.pop();
            Set<Estado> epsilonTransicoes = mover(estado, null);
            for (Estado e : epsilonTransicoes) {
                if (!fecho.contains(e)) {
                    fecho.add(e);
                    pilha.push(e);
                }
            }
        }

        return fecho;
    }
}
