package main;
public class RolaDados {
    Dado[] dados ;
    int[] valoresDados;

    public RolaDados(int n){
        dados = new Dado[n];
        valoresDados = new int[n];
    }

    public int[] rolar(){
        for (int i = 0; i < dados.length; i++){
            dados[i] = new Dado();
            valoresDados[i] = dados[i].rolar();
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return valoresDados;
    }

    public int[] rolar(boolean[] quais){
        for (int i = 0; i < quais.length; i++){
            if (quais[i] == true){
                valoresDados[i] = dados[i].rolar();
                try {
                    Thread.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        return valoresDados;
    }

    private String[][] faces = { { "+-----+    ", "|     |    ", "|  *  |    ", "|     |    ", "+-----+    " },
            { "+-----+    ", "|*    |    ", "|     |    ", "|    *|    ", "+-----+    " },
            { "+-----+    ", "|*    |    ", "|  *  |    ", "|    *|    ", "+-----+    " },
            { "+-----+    ", "|*   *|    ", "|     |    ", "|*   *|    ", "+-----+    " },
            { "+-----+    ", "|*   *|    ", "|  *  |    ", "|*   *|    ", "+-----+    " },
            { "+-----+    ", "|*   *|    ", "|*   *|    ", "|*   *|    ", "+-----+    " } };

    @Override
    // Só funciona para 5 dados
    public String toString(){
        String s = " 1          2          3          4          5\n";

        for (int j = 0; j < 5; j++){
            for (int i = 0; i < 5; i++){
                s += faces[valoresDados[i] - 1][j];
            }
            s += "\n";
        }       
        
        return s;
    }

    public static void main(String[] args) {
        RolaDados dados = new RolaDados(5);
        dados.rolar();
        System.out.printf(dados.toString());
    }
}
