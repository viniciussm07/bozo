package main;
import java.util.ArrayList;

public class Bozo {
    public static void main(String[] args) throws Exception {
        int contadorRodada = 1;
        Placar placar = new Placar();
        RolaDados dados = new RolaDados(5);
        String bufferString = "";
        int bufferInt;
        ArrayList<Integer> arrListInt = new ArrayList<>();
        boolean[] quais = { false, false, false, false, false };
        while (contadorRodada < 11) {
            do {
                System.out.println("****** Rodada: " + contadorRodada + "\nPrecione ENTER para iniciar a rodada");
                bufferString = EntradaTeclado.leString();
            } while (bufferString.length() != 0);
            dados.rolar();
            System.out.println(dados.toString());
            for (int j = 0; j < 2; j++) {
                System.out.println("Digite o número do dado que quiser rolar novamente (separado por espaços), caso não queira apenas precione Enter");

                bufferString = EntradaTeclado.leString();
                if (bufferString != "") {
                    for (int i = 0; i < bufferString.length(); i++) {
                        if (bufferString.charAt(i) != ' ' && bufferString.charAt(i) < '6'
                                && bufferString.charAt(i) > '0') {
                            arrListInt.add(Character.getNumericValue(bufferString.charAt(i)));
                        }
                    }
                    for (int i = 0; i < arrListInt.size(); i++) {
                        quais[arrListInt.get(i) - 1] = true;
                    }
                    dados.rolar(quais);
                    System.out.println(dados.toString());
                    
                }
                for (int k = 0; k < quais.length; k++) {
                    quais[k] = false;
                }
                arrListInt.clear();
            }

            try {
                System.out.println(placar.toString());
                System.out.println("Digite uma posição para atualizar seu placar");
                bufferInt = EntradaTeclado.leInt();
                System.out.println("\n");
            } catch (Exception e) {
                System.out.println("Não foi digitado um inteiro");
                return;
            }
            placar.add(bufferInt, dados.valoresDados);
            System.out.println(placar.toString());

            contadorRodada++;
            // Resetando variáveis
            bufferString = "";
            bufferInt = 0;
            for (int i = 0; i < quais.length; i++) {
                quais[i] = false;
            }
            arrListInt.clear();
        }
        /*
         * Pedir para o usuário escolher os dados a serem rolados
         * Rolar os dados que o usuário selecionou (2a vez)
         * Pedir para o usuário escolher os dados a serem rolados
         * Rolar os dados que o usuário selecionou (3a vez)
         * Mostrar o placar atual
         * Pedir para o usuário selecionar a posição que quer ocupar
         * Mostrar o placar atualizado
         * No final, mostrar o número de pontos obtidos
         */
        System.out.println("Sua pontuação foi de: " + placar.getScore());
    }
}
