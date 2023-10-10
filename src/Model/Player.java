package Model;


public class Player extends Character {
    private int liveAmount;

    public Player(String name, int attack, int protection, int maxHealth, int minDamage, int maxDamage) {
        super(name, attack, protection, maxHealth, minDamage, maxDamage);
        this.liveAmount = 4;
    }

    public void healingHealth() {
        int healing = (int) (this.getMaxHealth() * 0.3);
        if (this.isAlive()==true) {
            if (liveAmount > 0) {
                System.out.println("(healing for "+this.getName()+ " : + " + healing+ " )");
                this.setCurHealth(this.getCurHealth() + healing);

                System.out.println(this.getName() + " have " + this.getCurHealth() + " health after healing ");
                this.liveAmount--;
            }
        } else {
            System.out.println("You are already died");
        }
    }

}
