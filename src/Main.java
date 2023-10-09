import Model.Monster;
import Model.Player;

public class Main {
    public static void main(String[] args) {
        Monster monster = new Monster("Boo",12,6,80,5);
        Player player = new Player("Too",10,3,90,6);

        System.out.println(player.calculateSuccess(monster));


    }
}