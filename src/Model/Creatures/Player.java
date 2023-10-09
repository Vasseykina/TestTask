package Model.Creatures;

public class Player extends Character{
    private int maxHealth;
    private int liveAmount=4;

    public Player(String name, int attack, int protection, int maxHealth, int minDamage) {
        super(name, attack, protection, maxHealth, minDamage);
        this.maxHealth = maxHealth;
    }

}
