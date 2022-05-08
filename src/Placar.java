import java.util.HashMap;
import java.util.Map;

public class Placar {
    Map<Integer, Integer> placar = new HashMap<>();
    boolean[] travaPontuacao = { false, false, false, false, false, false, false, false, false, false };

    public Placar() {
        placar.put(1, -1);
        placar.put(2, -1);
        placar.put(3, -1);
        placar.put(4, -1);
        placar.put(5, -1);
        placar.put(6, -1);
        placar.put(7, -1);
        placar.put(8, -1);
        placar.put(9, -1);
        placar.put(10, -1);
    }

    private boolean verificaFullHand(int[] dados) {
        int[] contadores = contadoresDados(dados);
        boolean verificador1 = false;
        boolean verificador2 = false;

        // Variável auxiliar para que caso uma face se repita 3 vezes, a função continua
        // funcionando
        int aux = 0;
        for (int i = 0; i < contadores.length; i++) {
            if (contadores[i] == 5) {
                verificador1 = true;
                verificador2 = true;
            }
            else if (contadores[i] == 2 ) {
                verificador1 = true;
                aux = contadores[i];
            }
            else if ((contadores[i] >= 3) && (contadores[i] != aux)) {
                verificador2 = true;
            }
        }

        if (verificador1 && verificador2)
            return true;

        return false;

    }

    private boolean verificaSequencia(int[] dados) {
        int[] contadores = contadoresDados(dados);
        boolean verificador = false;

        int contador = 0;
        for (int i = 0; i < contadores.length; i++) {
            if (contadores[i] == 1) {
                contador++;
            }
        }

        if (contador == 5)
            verificador = true;

        return verificador;
    }

    private boolean verificaQuadra(int[] dados) {
        int[] contadores = contadoresDados(dados);
        boolean verificador = false;

        for (int i = 0; i < contadores.length; i++) {
            if (contadores[i] == 4) {
                verificador = true;
            }
        }

        return verificador;
    }

    private boolean verificaQuina(int[] dados) {
        int[] contadores = contadoresDados(dados);
        boolean verificador = false;

        for (int i = 0; i < contadores.length; i++) {
            if (contadores[i] == 5) {
                verificador = true;
            }
        }

        return verificador;
    }

    private int[] contadoresDados(int[] dados) {
        int[] contadores = { 0, 0, 0, 0, 0, 0 };

        for (int i = 0; i < dados.length; i++) {
            if (dados[i] == 1)
                contadores[0]++;
            else if (dados[i] == 2)
                contadores[1]++;
            else if (dados[i] == 3)
                contadores[2]++;
            else if (dados[i] == 4)
                contadores[3]++;
            else if (dados[i] == 5)
                contadores[4]++;
            else if (dados[i] == 6)
                contadores[5]++;
        }
        return contadores;
    }

    private void atualizaPlacar(int posicao, int[] dados) {
        int pontuacao = 0;

        if (posicao == 1) {
            for (int i = 0; i < dados.length; i++) {
                if (dados[i] == 1) {
                    pontuacao++;
                }
            }
        } else if (posicao == 2) {
            for (int i = 0; i < dados.length; i++) {
                if (dados[i] == 2) {
                    pontuacao += 2;
                }
            }
        } else if (posicao == 3) {
            for (int i = 0; i < dados.length; i++) {
                if (dados[i] == 3) {
                    pontuacao += 3;
                }
            }
        } else if (posicao == 4) {
            for (int i = 0; i < dados.length; i++) {
                if (dados[i] == 4) {
                    pontuacao += 4;
                }
            }
        } else if (posicao == 5) {
            for (int i = 0; i < dados.length; i++) {
                if (dados[i] == 5) {
                    pontuacao += 5;
                }
            }
        } else if (posicao == 6) {
            for (int i = 0; i < dados.length; i++) {
                if (dados[i] == 6) {
                    pontuacao += 6;
                }
            }
        } else if (posicao == 7) {
            if (verificaFullHand(dados))
                pontuacao = 15;
            else
                pontuacao = 0;
        } else if (posicao == 8) {
            if (verificaSequencia(dados))
                pontuacao = 20;
        } else if (posicao == 9) {
            if (verificaQuadra(dados))
                pontuacao = 30;
        } else if (posicao == 10) {
            if (verificaQuina(dados))
                pontuacao = 40;
        }

        placar.put(posicao, pontuacao);
    }

    public void add(int posicao, int[] dados) {
        if (travaPontuacao[posicao - 1] == true)
            throw new IllegalArgumentException("Pontuação Já preenchida no placar");
        else {
            atualizaPlacar(posicao, dados);
            travaPontuacao[posicao - 1] = true;
        }
    }

    public int getScore() {
        int score = 0;
        for (int i = 1; i < 10; i++) {
            score += placar.get(i);
        }
        return score;
    }

    @Override
    public String toString() {
        String s = "";

        if (placar.get(1) == -1) {
            s += "(1)    ";
        } else {
            s += placar.get(1) + "     ";
        }

        if (placar.get(7) == -1) {
            s += "|    (7)    |";
        } else {
            s += "|     " + placar.get(7) + "    |";
        }

        if (placar.get(4) == -1) {
            s += "    (4)";
        } else {
            s += "     " + placar.get(4);
        }

        s += "\n--------------------------\n";

        if (placar.get(2) == -1) {
            s += "(2)    ";
        } else {
            s += placar.get(2) + "      ";
        }

        if (placar.get(8) == -1) {
            s += "|    (8)    |";
        } else {
            s += "|    " + placar.get(8) + "    |";
        }

        if (placar.get(5) == -1) {
            s += "    (5)";
        } else {
            s += "     " + placar.get(5);
        }

        s += "\n--------------------------\n";

        if (placar.get(3) == -1) {
            s += "(3)    ";
        } else {
            s += placar.get(3) + "      ";
        }

        if (placar.get(9) == -1) {
            s += "|    (9)    |";
        } else {
            s += "|    " + placar.get(9) + "     |";
        }

        if (placar.get(6) == -1) {
            s += "    (6)";
        } else {
            s += "     " + placar.get(6);
        }

        s += "\n--------------------------\n";

        if (placar.get(10) == -1) {
            s += "       |    (10)   |\n";
        } else {
            s += "       |   " + placar.get(10) + "    |\n";
        }

        return s;
    }

    public static void main(String[] args) {
        Placar placar = new Placar();
        int[] dados = { 1, 1, 1, 1, 2 };
        System.out.println("pontuação inicial: " + placar.getScore());
        placar.add(7, dados);
        System.out.println(placar.toString());
        System.out.println("pontuação: " + placar.getScore());
    }
}
