package Model;


public class Player extends Character {
    private int liveAmount;

    public Player(String name, int attack, int protection, int maxHealth, int minDamage) {
        super(name, attack, protection, maxHealth, minDamage);
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
            if (liveAmount < 0) {
                if (this.getCurHealth() < 0) {
                    System.out.println(this.getName() + " is died ");
                    this.setAlive(false);
                }
            }
        } else {
            System.out.println("You are already died");
        }
    }

}
