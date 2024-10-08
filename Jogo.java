import java.util.Random;
 
public class Jogo{
 
    public static void main(String[] args)throws Exception {
 
        var gerador = new Random(); //cria um gerador
 
        int acaoDoplayer1; // declarar variáveis
 
        int acaoDoplayer2;
 
        int vivo1 = 1, vivo2 = 1; //principal fator de ocorrer o looping infinito
 
        Personagem player1 = new Personagem();
 
        Personagem player2 = new Personagem(2,10,10);
 
        player1.nome= "Kratos";
 
        player2.nome = "Ze Preguica";
 
        while(vivo1 > 0 || vivo2 > 0){
            if(vivo1 > 0){
            acaoDoplayer1 = gerador.nextInt(3); // gerador de 3 numeros (0,1,2)
 
            if (acaoDoplayer1 == 0) {
 
                player1.cacar();
 
            } else if (acaoDoplayer1 == 1) {
 
                player1.comer();
 
            } else if (acaoDoplayer1 == 2) {
 
                player1.dormir();
 
            }
 
            System.out.println(player1); // mostra status do player1
 
            System.out.println("****************************");
            //Thread.sleep(5000); // espera 5 segundos para realizar a próxima instrução
           
        }
           
            if(vivo2 > 0){
 
            acaoDoplayer2 = gerador.nextInt(10) + 1; // gerador de 10 números (1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
 
            if (acaoDoplayer2 >= 1 && acaoDoplayer2 <= 6) { // 60%
 
                player2.dormir();
 
            } else if (acaoDoplayer2 > 6 && acaoDoplayer2 <= 9) { // 30%
 
                player2.comer();
 
            } else if (acaoDoplayer2 == 10) { // 10%
 
                player2.cacar();
 
            }
 
            System.out.println(player2); // mostra status do player2
 
            System.out.println("****************************");
 
            Thread.sleep(5000); // espera 5 segundos para realizar a próxima instrução
        }
            //Morte do Personagem
 
            if (player1.getenergia() <= 0 && player2.getenergia() <= 0){
 
                System.out.println("Players Died!");
 
                break;
 
            } else if (player1.getenergia() <= 0){
 
                System.out.println("Player1 Died!\n");                
                vivo1 = 0;
            } else if ( player2.getenergia() <= 0){
 
                System.out.println("Player2 Died!\n");
                vivo2 = 0;
            }
        }
    }
 
}
 