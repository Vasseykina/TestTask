import Model.Monster;
import Model.Player;

public class Main {
    public static void main(String[] args) {
        Monster monster = new Monster("Boo",12,6,100,10, 20);
        Player player = new Player("player",18,3,100,15,25);


        //int playerAttack = player.calculateSuccess(monster);
        //monster.calculateSuccess(player);

        while(player.isAlive() && monster.isAlive()) {
            player.attack(monster);
            monster.attack(player);
            if(player.isAlive() && player.getCurHealth() <= player.getMaxHealth()*0.7) {
                player.healingHealth();
            }
        }
    }
}