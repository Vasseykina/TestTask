package Model;

import java.util.regex.Pattern;

public class Character {
    private int attack;// от 1 до 30
    private int protection;// от 1 до 30
    private int maxHealth;
    private int Health;// до какого-то  N
    //private int damage; // урон, что получил от M(1) до  N , что является здоровьем
    private int minDamage; // M
    private boolean alive;
    private String name;

    public Character(String name, int attack, int protection, int maxHealth, int minDamage) {
        setName(name);
        setAttack(attack);
        setProtection(protection);
        setMaxHealth(maxHealth);
        setCurHealth(maxHealth);
        setMinDamage(minDamage);
        this.alive = true;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        if (alive || !alive) {
            this.alive = alive;
        } else {
            throw new IllegalArgumentException("Invalid value for 'alive'. Use only true or false.");
        }
    }

    public static int rnd(int min, int max) { //рандом в диапазоне
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

    public int calculateSuccess(Character character) { //количество атак
        int modifier = this.getAttack() - character.getProtection() + 1; //количество кубиков
        if (modifier <= 0) {
            modifier = 1;
        }
        System.out.println(this.getName() + " have " + modifier + " modifier");
        int countAttack = 0;
        System.out.println("The value of the dice:");
        for (int i = 0; i < modifier; i++) {
            int rand = rnd(1, 6);
            System.out.println(" dice" + i + " : " + rand);
            if (rand >= 5) {
                countAttack += 1;
            }
        }
        System.out.println(this.getName() + " have " + countAttack + " countAttack");
        return countAttack;
    }

    public void attack(Character character) {
        if (character.isAlive()==true) {
            int damage = rnd(this.getMinDamage(), character.getCurHealth());
            character.setCurHealth(character.getCurHealth() - damage);
            System.out.println(character.getName() + " has " + character.getCurHealth() + " health after the attack from " + this.getName());
            if (character.getCurHealth() < 0) {
                character.setAlive(false);
                System.out.println(character.getName() + " has died.");
            }
        } else {
            System.out.println(character.getName() + " is already dead.");
        }
    }

    public void setName(String name) {
        String regex = "^[a-zA-Z]+$";
        if (!Pattern.matches(regex, name)) {
            throw new IllegalArgumentException("Invalid name. Only letters are allowed.");
        }
        this.name = name;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getAttack() {
        return attack;
    }

    public int getProtection() {
        return protection;
    }

    public int getCurHealth() {
        return Health;
    }

    public int getMinDamage() {
        return minDamage;
    }

    public String getName() {
        return name;
    }

    public void setProtection(int protection) {
        if (protection <= 0 || protection > 30) {
            throw new IllegalArgumentException("Wrong input: health cannot be negative or more 30.");
        }
        this.protection = protection;
    }

    public void setAttack(int attack) {
        if (attack <= 0 || attack > 30) {
            throw new IllegalArgumentException("Wrong input: health cannot be negative or more 30.");
        }
        this.attack = attack;
    }


    public void setCurHealth(int health) {
        if (this.getCurHealth() < 0) {
            this.Health = 0;
        } else if (this.getCurHealth() > this.getMaxHealth()) {
            this.Health = this.getMaxHealth();
        } else {
            this.Health = health;
        }
    }

    public void setMaxHealth(int Health) {
        if (this.Health < 0) {
            throw new IllegalArgumentException("Wrong input: health cannot be negative.");
        }
        this.maxHealth = Health;
    }

    public void setMinDamage(int minDamage) {
        if (this.minDamage < 0) {
            throw new IllegalArgumentException("Wrong input: health cannot be negative.");
        }
        this.minDamage = minDamage;
    }

}
