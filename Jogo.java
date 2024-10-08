import java.util.Random;
public class Jogo{
    public static void main(String[] args)throws Exception {
        var gerador = new Random(); //cria um gerador
        int acao;
        int vivo = 1; //principal fator de ocorrer o looping infinito
        Personagem player1 = new Personagem();
        player1.nome= "Kratos";
        
        while(vivo > 0){
            acao = gerador.nextInt(3); // gerador de 3 numeros (0,1,2)
            
            if (acao == 0){
                player1.cacar();
            }

            if (acao == 1){
                player1.comer();
            }

            if (acao == 2){
                player1.dormir();
            }
            System.out.println(player1); //mostra status player1
            System.out.println("****************************");
            Thread.sleep(5000); //espera 5 segundos para realizar proxima instrução
        }

    }
}