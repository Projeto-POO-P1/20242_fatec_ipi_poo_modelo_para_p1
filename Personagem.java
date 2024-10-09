import java.util.Random;

public class Personagem {
    String nome;
    private int energia;
    private int fome;
    private int sono;

    Personagem() {
        System.out.println("Construindo novo personagem");
        energia = 10;
        fome = 0;
        sono = 0;
    }

    Personagem(int energia, int fome, int sono) {
        System.out.println("Construindo novo personagem");
        this.energia = energia < 0 || energia > 10 ? 10 : energia;
        this.fome = fome >= 0 && fome <= 10 ? fome : 0;
        this.sono = sono >= 0 && sono <= 10 ? sono : 0;
    }

    static void exibirAnuncio() {
        String[] anuncios = {
            "Coca cola *anuncio da Coca cola*",
            "O personagem morre. *anuncio de plano de saúde*",
            "'Cama King Size por apenas 12x com juros RS: 99,90 recupere dois de energia com essa cama. *PNG de Cama*",
            "Fique livre de anuncios por apenas RS: 29,99 por mês!!! *anuncio do jogo*",
            "Novo Personagem Rank SSS: *PNG do personagem SSShrek*",
            "Tigrinho está pagando muito bem!!! *Diz dono do Tigrinho antes de ser preso por dar golpe em usuarios*",
            "Clique aqui para ganhar muito dinheiro!!! *clonacartao.com.br*"
        };
        Random gerador = new Random();
        int indice = gerador.nextInt(anuncios.length);
        System.out.println(anuncios[indice]);
        try {
            Thread.sleep(30000); // Espera 30 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void cacar() {
        if (energia >= 2) {
            System.out.printf("%s caçando\n", nome);
            energia -= 2; // energia = energia - 2
        } else {
            System.out.printf("%s sem energia para caçar\n", nome);
        }
        if (fome < 10) fome = fome + 1;
        sono = sono == 10 ? sono : sono + 1;
    }

    void comer() {
        if (fome >= 1) {
            System.out.println(nome + " comendo");
            energia = Math.min(energia + 1, 10);
            fome--;
        } else {
            System.out.println(nome + " sem fome");
        }
    }

    void dormir() {
        if (sono >= 1) {
            System.out.print(nome + " dormindo\n");
            energia = energia == 10 ? energia : energia + 1;
            sono -= 1;
        } else {
            System.out.println(nome + " sem sono");
        }
    }

    void atacar(Personagem outro) {
        if (energia > 0 && outro.getenergia() > 0) { // Verifica se ambos os personagens estão vivos
            System.out.println(nome + " ataca " + outro.nome + "!");
            outro.setEnergia(outro.getenergia() - 1);
            System.out.println(outro.nome + " agora tem " + outro.getenergia() + " de energia.");
            if (outro.getenergia() <= 0) {
                System.out.println(outro.nome + " morreu!");
            }
        } else if (energia <= 0) {
            System.out.println(nome + " não pode atacar porque está morto.");
        } else {
            System.out.println(outro.nome + " já está morto.");
        }
    }

    public String toString() {
        return String.format("%s: e:%d, f:%d, s:%d", nome, energia, fome, sono);
    }

    public int getenergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }
}