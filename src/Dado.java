public class Dado {
    private int nLados;
    private int lado;

    public Dado() {
        nLados = 7;
    }

    public Dado(int n) {
        nLados = n;
    }

    public int rolar() {
        Random rd = new Random();
        lado = rd.getIntRand(1, nLados);

        return lado;
    }

    public int getLado() {
        return lado;
    }

    @Override
    public String toString() {
        
        int l = getLado();
        String s = "";
        if (l == 1){
            s = "+-----+\n|     |\n|  *  |\n|     |\n+-----+\n";
        } else if (l == 2){
            s = "+-----+\n|*    |\n|     |\n|    *|\n+-----+\n";
        } else if (l == 3){
            s = "+-----+\n|*    |\n|  *  |\n|    *|\n+-----+\n";
        } else if (l == 4){
            s = "+-----+\n|*   *|\n|     |\n|*   *|\n+-----+\n";
        } else if (l == 5){
            s = "+-----+\n|*   *|\n|  *  |\n|*   *|\n+-----+\n";
        } else if (l == 6){
            s = "+-----+\n|*   *|\n|*   *|\n|*   *|\n+-----+\n";
        }
        
        return s;
    }

    public static void main(String[] args) {
        Dado dado = new Dado();
        dado.rolar();
        System.out.println(dado.getLado());
        System.out.println(dado.toString());
    }
}