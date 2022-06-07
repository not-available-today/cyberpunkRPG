package characters;

import inventory.weapons.Weapon;

public abstract class GameCharacter implements Fightable {
    protected int armorClass;
    private int health;
    private int maxHealth;
    private int level;
    private String name;
    private Weapon primaryWeapon;
    private Weapon secondaryWeapon;
    private Weapon equippedWeapon;

    public Weapon getEquippedWeapon() {
        return equippedWeapon;
    }

    public void setEquippedWeapon(Weapon equippedWeapon) {
        this.equippedWeapon = equippedWeapon;
    }

    public void equipWeapon(){

    }

    public final int getMaxHealth() {
        return maxHealth;
    }

    public final void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public final int getHealth() {
        return health;
    }

    public final void setHealth(int health) {
        this.health = health;
    }

    public final int getLevel() {
        return level;
    }

    public final void setLevel(int level) {
        this.level = level;
    }

    public final int getArmorClass() {
        return this.armorClass;
    }

    public final void setArmorClass(int i) {
        this.armorClass = i;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String name) {
        this.name = name;
    }

    public Weapon getPrimaryWeapon() {
        return this.primaryWeapon;
    }

    public void setPrimaryWeapon(Weapon primaryWeapon) {
        this.primaryWeapon = primaryWeapon;
    }

    public Weapon getSecondaryWeapon() {
        return this.secondaryWeapon;
    }

    public void setSecondaryWeapon(Weapon secondaryWeapon) {
        this.secondaryWeapon = secondaryWeapon;
    }

    @Override
    public int takeDamage(GameCharacter c) {
        return c.dealDamage() * (100 - getArmorClass()) / 100;
    }

    @Override
    public int dealDamage() {
        return getPrimaryWeapon().getDamage()*getLevel();
    }

    public abstract String regularAttackToString();

    public final void printStatRoll(int[] stats) {
        System.out.println("Max Health: " + stats[0]);
        System.out.println("Armor Class: " + stats[1]);
        System.out.println("Specials: " + stats[2]);
        System.out.println("MedPacks: " + stats[3]);
        System.out.println("(s) select stats");
        System.out.println("(r) re-roll");
    }

    public abstract int[] rollStats();

    protected void calculateHealthToAdd() {
        if (getHealth() <= getMaxHealth()) {
            System.out.println("+10 Health Added");
        }
        if (getHealth() > getMaxHealth()) {
            int healthAdded = 10 - (getHealth() - getMaxHealth());
            setHealth(getMaxHealth());
            System.out.println("+" + healthAdded + " Health Added");
        }
    }

    public abstract void printPlayerStats();

    public final void printInflictedDamage(int d) {
        if(d>0){
            System.out.println("-"+d+" damage");
        }else
            System.out.println(d + " damage");
    }

    public abstract void printImage();

    public abstract void printDamageCapability();
}
