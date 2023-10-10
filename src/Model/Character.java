package Model;

import java.util.regex.Pattern;

public class Character {
    private int attack;// от 1 до 30
    private int protection;// от 1 до 30
    private int maxHealth;
    private int health;// до какого-то  N
    //private int damage; // урон, что получил от M(1) до  N , что является здоровьем
    private int minDamage; // M
    private int maxDamage; // M
    private boolean alive;
    private String name;

    public Character(String name, int attack, int protection, int maxHealth, int minDamage, int maxDamage) {
        setName(name);
        setAttack(attack);
        setProtection(protection);
        setMaxHealth(maxHealth);
        setCurHealth(maxHealth);
        setMinDamage(minDamage);
        setMaxDamage(maxDamage);
        this.alive = true;
    }

    public boolean isAlive() {
        return alive;
    }

    protected void setAlive(boolean alive) {
        this.alive = alive;
    }

    public static int rnd(int min, int max) { //рандом в диапазоне
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

    public void attack(Character character) {
        System.out.println(this.getName() + " attack " + character.getName());
        int modifier = this.getAttack() - character.getProtection() + 1;
        if (modifier <= 0) {
            modifier = 1;
        }
        System.out.println("Modifier of attack " + modifier);
        boolean isAttack = false;
        System.out.println("The value of the dice:");
        for (int i = 0; i < modifier; i++) {
            int rand = rnd(1, 6);
            System.out.println(" dice " + i + " : " + rand);
            if (rand >= 5) {
                isAttack = true;
                break;
            }
        }
        if (character.isAlive()) {
            if(isAttack) {
                int damage = rnd(this.getMinDamage(), this.getMaxDamage());
                character.setCurHealth(character.getCurHealth() - damage);
                System.out.println(character.getName() + " has " + character.getCurHealth() + " health after the attack from " + this.getName());
                if (character.getCurHealth() <= 0) {
                    character.setAlive(false);
                    System.out.println(character.getName() + " has died.");
                }
            }
        } else {
            System.out.println(character.getName() + " is already dead.");
        }
    }

    protected void setName(String name) {
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
        return health;
    }

    public int getMinDamage() {
        return minDamage;
    }

    public int getMaxDamage() {
        return maxDamage;
    }

    public String getName() {
        return name;
    }

    protected void setProtection(int protection) {
        if (protection <= 0 || protection > 30) {
            throw new IllegalArgumentException("Wrong input: health cannot be negative or more 30.");
        }
        this.protection = protection;
    }

    protected void setAttack(int attack) {
        if (attack <= 0 || attack > 30) {
            throw new IllegalArgumentException("Wrong input: health cannot be negative or more 30.");
        }
        this.attack = attack;
    }


    protected void setCurHealth(int health) {
        if (health < 0) {
            this.health = 0;
        } else if (health > this.getMaxHealth()) {
            this.health = this.getMaxHealth();
        } else {
            this.health = health;
        }
    }

    protected void setMaxHealth(int health) {
        if (health < 0) {
            throw new IllegalArgumentException("Wrong input: health cannot be negative.");
        }
        this.maxHealth = health;
    }

    protected void setMinDamage(int minDamage) {
        if (minDamage < 0) {
            throw new IllegalArgumentException("Wrong input: damage cannot be negative.");
        }
        this.minDamage = minDamage;
    }

    protected void setMaxDamage(int maxDamage) {
        if (maxDamage < 0) {
            throw new IllegalArgumentException("Wrong input: damage cannot be negative.");
        }
        this.maxDamage = maxDamage;
    }

}
