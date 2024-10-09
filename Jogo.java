import java.util.Random;

public class Jogo {

    public static void main(String[] args) throws Exception {

        // Exibir anúncio antes da criação dos personagens
        Personagem.exibirAnuncio();

        var gerador = new Random(); // cria um gerador

        int acaoDoplayer1; // declarar variáveis
        int acaoDoplayer2;

        Personagem player1 = new Personagem();
        Personagem player2 = new Personagem(2, 10, 10);

        player1.nome = "Kratos";
        player2.nome = "Ze Preguica";

        while (true) {
            if (player1.getenergia() > 0) {
                acaoDoplayer1 = gerador.nextInt(4); // gerador de 4 números (0,1,2,3)

                if (acaoDoplayer1 == 0) {
                    player1.cacar();
                } else if (acaoDoplayer1 == 1) {
                    player1.comer();
                } else if (acaoDoplayer1 == 2) {
                    player1.dormir();
                } else if (acaoDoplayer1 == 3 && player2.getenergia() > 0) { // Verifica se o player2 está vivo antes de atacar
                    player1.atacar(player2); // Chama o método atacar da classe Personagem
                }

                System.out.println(player1); // mostra status do player1
                System.out.println("****************************");
                Thread.sleep(5000); // espera 5 segundos para realizar a próxima instrução
            }

            if (player2.getenergia() > 0) {
                acaoDoplayer2 = gerador.nextInt(11); // gerador de 11 números (0 a 10)

                if (acaoDoplayer2 >= 1 && acaoDoplayer2 <= 6) { // 60%
                    player2.dormir();
                } else if (acaoDoplayer2 > 6 && acaoDoplayer2 <= 9) { // 30%
                    player2.comer();
                } else if (acaoDoplayer2 == 10) { // 10%
                    player2.cacar();
                } else if (acaoDoplayer2 == 0 && player1.getenergia() > 0) { // Verifica se o player1 está vivo antes de atacar
                    player2.atacar(player1); // Chama o método atacar da classe Personagem
                }

                System.out.println(player2); // mostra status do player2
                System.out.println("****************************");
                Thread.sleep(5000); // espera 5 segundos para realizar a próxima instrução
            }

            // Morte do Personagem
            if (player1.getenergia() <= 0 && player2.getenergia() <= 0) {
                System.out.println("Players Died!");
                break;
            } else if (player1.getenergia() <= 0) {
                System.out.println("Player1 Died!\n");
            } else if (player2.getenergia() <= 0) {
                System.out.println("Player2 Died!\n");
            }
        }
    }
}