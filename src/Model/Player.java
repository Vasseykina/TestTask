package Model;


public class Player extends Character {
    private int liveAmount;

    public Player(String name, int attack, int protection, int Health, int minDamage) {
        super(name, attack, protection, Health, minDamage);
        this.liveAmount = 4;
    }


    public void healingHealth() {
        int healing = (int) (this.getMaxHealth() * 0.3);
        if (this.isAlive()) {
            if (this.getCurHealth() <= (1 - healing)) {
                this.setCurHealth(this.getCurHealth() + healing);
                System.out.println(this.getName() + "have" + this.getCurHealth() + " health after healing");
                this.liveAmount--;
                System.out.println(this.getName() + "have" + this.liveAmount + "healing");
                if (liveAmount == 0) {
                    if (this.getCurHealth() == 0) {
                        System.out.println(this.getName() + "is died");
                        this.setAlive(false);
                    }
                }

            }
        }
        return;
    }

}
