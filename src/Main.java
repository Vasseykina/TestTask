import Model.Monster;
import Model.Player;

public class Main {
    public static void main(String[] args) {
        Monster monster = new Monster("Boo",12,6,30,5);
        Player player = new Player("player",18,3,40,6);


        //int playerAttack = player.calculateSuccess(monster);
        //monster.calculateSuccess(player);

        int i = 8 ;
        while(i>0) {
            monster.attack(player);
            player.healingHealth();
            i--;
        }
        monster.attack(player);


    }
}