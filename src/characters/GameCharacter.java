package characters;

import inventory.power_ups.MedPack;
import inventory.weapons.Weapon;
import main.auxilliary_tools.Narrator;

public abstract class GameCharacter implements Fightable {

    private int armorClass;
    private int health;
    private int maxHealth;
    private int level;
    private String name;
    private Weapon equippedWeapon;
    private  MedPack meds;


    public final int getArmorClass() {
        return this.armorClass;
    }

    public final void setArmorClass(int i) {
        this.armorClass = i;
    }

    public final int getHealth() {
        return health;
    }

    public final void setHealth(int health) {
        this.health = health;
    }

    public final int getMaxHealth() {
        return maxHealth;
    }

    public final void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public final int getLevel() {
        return level;
    }

    public final void setLevel(int level) {
        this.level = level;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String name) {
        this.name = name;
    }

    public Weapon getEquippedWeapon() {
        return equippedWeapon;
    }

    public void setEquippedWeapon(Weapon equippedWeapon) {
        this.equippedWeapon = equippedWeapon;
    }

    public MedPack getMeds() {
        return meds;
    }

    public void setMeds(MedPack meds) {
        this.meds = meds;
    }

    public abstract int[] rollStats();

    public abstract void initializeWeapons();

    @Override
    public int dealDamage(int roll) {
        getEquippedWeapon().setDamage(getEquippedWeapon().getDamage()*roll/4);
        return getEquippedWeapon().getDamage();
    }

    @Override
    public int takeDamage(GameCharacter c) {
        return getArmorClass()-c.getEquippedWeapon().getDamage();
    }


    public void initializeMedPack(){
        this.meds = new MedPack();
    }

    public final void addMedPack() {
        getMeds().setQuantity(getMeds().getQuantity() + 1);
    }

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

    public final void printStatRoll(int[] stats) {
        System.out.println("Max Health      : " + stats[0]);
        System.out.println("Armor Class     : " + stats[1]);
        System.out.println("Specials        : " + stats[2]);
        System.out.println("MedPacks        : " + stats[3]);
        System.out.println();
        System.out.println(Narrator.RED+"(s) select stats");
        System.out.println("(r) re-roll"+Narrator.ANSI_RESET);
    }

    public final void printInflictedDamage(int d) {
        if(d<0){
            System.out.println(d+" damage");
        }else
            System.out.println("-"+d + " damage");
    }

    public abstract void printDamageCapability();

    public abstract void printPlayerInformation();

    public static void printClassDescription(){}

    public abstract String regularAttackToString();

    public abstract void printImage();

}
