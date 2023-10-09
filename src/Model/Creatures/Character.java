package Model.Creatures;

import java.util.Random;
import Exception.InvalidValueException;
public class Character {
    private int attack;// от 1 до 30
    private int protection;// от 1 до 30
    private int maxHealth;
    private int curHealth;// до какого-то  N
    //private int damage; // урон, что получил от M(1) до  N , что является здоровьем
    private int minDamage; // M
    private int liveAmount=4;
    private boolean alive = true;

    public Character(String name, int attack, int protection, int maxHealth, int minDamage) {
        setAttack(attack);
        setProtection(protection);
        setCurHealth(maxHealth);
        setMinDamage(minDamage);
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public static int rnd(int min, int max) { //рандом в диапазоне
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

    public int modifierAttack(Character character) {// количество кубиков
        int modifier = this.getAttack() - character.getProtection()+ 1;
        if (modifier <= 0) {
            return 1;
        }
        return modifier;
    }

    public int calculateSuccess(int modifierAttack) { //количество атак
        int countAttack = 0;
        while (modifierAttack > 0) {
            int rand = rnd(1, 6);
            if (rand >= 5) {
                countAttack += 1;
            }
            modifierAttack = -1;
        }
        System.out.println(this.name + "have" + countAttack);
        return countAttack;
    }

    public void attack(Character character) {
        if (this.alive) {
            int attack = this.calculateSuccess(modifierAttack(character));//количество атак
            if (attack == 0) {
                System.out.println(this.name + "can't attack to" + character.getName());
                return;
            }
            for (int i = attack; i > 0; attack--) {
                System.out.println("have" + attack + "attack");
                loseHealth(character);
            }

        }
    }

    public void loseHealth(Character character) {
        int healing = (int) (character.getMaxHealth() * 0.3);
        while (character.alive) {
            int rand = rnd(this.getMinDamage(), this.getMaxHealth());
            character.setCurHealth(character.getCurHealth() - rand);
            System.out.println(character.name + "have" + character.getCurHealth() + " health after attack" + this.name);
            if (character.getCurHealth() <= (1 - healing)) {
                character.setCurHealth(character.getCurHealth() + healing);
                System.out.println(character.name + "have" + character.getCurHealth() + " health after healing");
                character.liveAmount--;
                System.out.println(character.name + "have" + character.liveAmount + "healing");
                if (liveAmount == 0) {
                    if (character.getCurHealth() == 0) {
                        System.out.println(character.name + "is died");
                        character.alive = false;
                    }
                }

            }
        }
    }



    public int getMaxHealth() {
        return maxHealth;
    }
    public int getAttack() {return attack;}
    public int getProtection() {return protection;}
    public int getCurHealth() {
        return curHealth;
    }
    public int getMinDamage() {
        return minDamage;
    }
    public int getLiveAmount() {return liveAmount;}
    public String getName() {
        return name;
    }

    public void setProtection(int protection) {
        if(protection <=0 || protection > 30){
            throw new InvalidValueException("wrong input");
        }
        this.protection = protection;
    }

    public void setAttack(int attack) throws InvalidValueException {
        if(attack <=0 || attack > 30){
            throw new InvalidValueException("wrong input");
        }
        this.attack = attack;
    }

    public void setCurHealth(int curHealth) throws InvalidValueException {
        if(this.maxHealth<curHealth || this.curHealth<0){
            throw new InvalidValueException("wrong input");
        }
        this.curHealth = curHealth;
    }

    public void setMaxHealth(int maxHealth) throws InvalidValueException {
        if (maxHealth < 0){
            throw new InvalidValueException("wrong input");
        }
        this.maxHealth = maxHealth;
    }

    public void setMinDamage(int minDamage) throws InvalidValueException {
        if (this.minDamage < 0 || this.minDamage>=this.getMaxHealth()) {
            throw new InvalidValueException("wrong input");
        }
        this.minDamage = minDamage;
    }


    public void setLiveAmount(int liveAmount) {
        this.liveAmount = liveAmount;
    }


}
