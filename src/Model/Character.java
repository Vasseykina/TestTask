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


    public Character(String name, int attack, int protection, int maxHealth, int minDamage) {
        setName(name);
        setAttack(attack);
        setProtection(protection);
        setMaxHealth(maxHealth);
        setCurHealth(maxHealth);
        setMinDamage(minDamage);
        this.alive = true;
    }


    public static int rnd(int min, int max) { //рандом в диапазоне
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

//    public int modifierAttack() {// количество кубиков
//
//        return modifier;
//    }


    public int calculateSuccess(Character character) { //количество атак
        int modifier = this.getAttack() - character.getProtection() + 1; //количество кубиков
        if (modifier <= 0) {
            modifier= 1;
        }
        System.out.println(this.getName() + " have " + modifier + " modifier\n" );
        int countAttack = 0;
        while (modifier > 0) {
            int rand = rnd(1, 6);
            if (rand >= 5) {
                countAttack += 1;
            }
            modifier = -1;
        }
        System.out.println(this.getName() + " have " + countAttack+ " countAttack\n" );
        return countAttack;
    }

    //    public void attack(Character character) {
//        if (this.alive) {
//            int attack = this.calculateSuccess(modifierAttack(character));//количество атак
//            if (attack == 0) {
//                System.out.println(this.name + "can't attack to" + character.getName());
//                return;
//            }
//            for (int i = attack; i > 0; attack--) {
//                System.out.println("have" + attack + "attack");
//                while(character.alive){
//
//                }
//            }
//
//        }
//    }
    public void attack(Character character) {
        int damage = rnd(this.getMinDamage(), character.getCurHealth());
        character.setCurHealth(character.getCurHealth() - damage);
        System.out.println(character.getName() + "have" + character.getCurHealth() + " health after attack" + this.getName());
    }

    public void setName(String name) {
        String regex = "^[a-zA-Z]+$";
        if (!Pattern.matches(regex, name)) {
            throw new IllegalArgumentException("Invalid name. Only letters are allowed.");
        }
        this.name = name;
    }

//    public void healingAndHealth(Character character) {
//        int healing = (int) (character.getMaxHealth() * 0.3);
//        while (character.alive) {
//            int rand = rnd(this.getMinDamage(), this.getMaxHealth());
//            character.setCurHealth(character.getCurHealth() - rand);
//            System.out.println(character.name + "have" + character.getCurHealth() + " health after attack" + this.name);
//            if (character.getCurHealth() <= (1 - healing)) {
//                character.setCurHealth(character.getCurHealth() + healing);
//                System.out.println(character.name + "have" + character.getCurHealth() + " health after healing");
//                character.liveAmount--;
//                System.out.println(character.name + "have" + character.liveAmount + "healing");
//                if (liveAmount == 0) {
//                    if (character.getCurHealth() == 0) {
//                        System.out.println(character.name + "is died");
//                        character.alive = false;
//                    }
//                }
//
//            }
//        }
//    }


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
