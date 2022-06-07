package characters.player_characters;

import characters.GameCharacter;
import characters.Interactable;
import characters.npc_classes.NPC;
import cli.GameConsole;
import inventory.Inventory;
import inventory.Item;
import inventory.power_ups.MedPack;
import main.gameplay.Attack;
import main.gameplay.Game;
import main.auxilliary_tools.Narrator;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public abstract class PlayerCharacter extends GameCharacter implements Interactable {


    protected final Inventory rucksack = new Inventory(this);
    private int moveCounter;
    private int damageMultiplier;
    private int wallet;
    private String characterColor;
    private Game.affiliation affiliation;



    //region getters/setters

    public abstract int getHealthFormula();

    public Game.affiliation getAffiliation() {
        return this.affiliation;
    }

    public void setAffiliation(Game.affiliation affiliation) {
        this.affiliation = affiliation;
    }

    public final int getDamageMultiplier() {
        return this.damageMultiplier;
    }

    public final void setDamageMultiplier(int statMultiplier) {
        this.damageMultiplier = statMultiplier;
    }

    public Integer getWallet() {
        return this.wallet;
    }

    public void setWallet(Integer wallet) {
        this.wallet = wallet;
    }

    public final String getCharacterColor() {
        return this.characterColor;
    }

    public void setCharacterColor(String characterColor) {
        this.characterColor = characterColor;
    }

    public int getMoveCounter() {
        return this.moveCounter;
    }

    public void setMoveCounter(int moveCounter) {
        this.moveCounter = moveCounter;
    }

    public Inventory getRucksack() {
        return this.rucksack;
    }

    public void setRucksack(Inventory rucksack) {
        this.rucksack.powerUps.addAll(rucksack.getPowerUps());
        this.rucksack.setWeaponsLimit(rucksack.getWeaponsLimit());
    }

    //endregion

    //region Stats,Info and LevelUp

    public final void startStatSelection() {
        int[] stats = new int[0];
        Scanner scanner = new Scanner(System.in);
        String s = "";
        while (!s.equalsIgnoreCase("s")) {
            stats = rollStats();
            System.out.println("Roll your stats: ");
            GameConsole.moveForward();
            printStatRoll(stats);
            s = scanner.nextLine();
        }
        setStats(stats);
    }

    public final void setStats(int[] stats) {
        setMoveCounter(0);
        setLevel(1);
        setHealth(stats[0]);
        setMaxHealth(stats[0]);
        setArmorClass(stats[1]);
    }

    public final void chooseAffiliation() {
        Scanner sc = new Scanner(System.in);
        printAffiliationMenu();
        String choice = sc.nextLine();
        switch (choice.toUpperCase()) {
            case "C" -> setAffiliation(Game.affiliation.CORPORATE);
            case "P" -> setAffiliation(Game.affiliation.PARAMILITARY);
            case "R" -> setAffiliation(Game.affiliation.REVOLUTIONARY);
            case "O" -> setAffiliation(Game.affiliation.OUTLAW);
            case "I" -> setAffiliation(Game.affiliation.INDEPENDENT);
            default -> chooseAffiliation();
        }
    }

    public final void levelUp() {
        addMedPack();
        getPrimaryWeapon().upgradeWeapon(this);
        setLevel(getLevel() + 1);
        setHealth(getHealthFormula() + getMaxHealth());
        printLevelUpMessage(rareUpgrade(), getHealthFormula());
        setMaxHealth(getHealth());

        GameConsole.moveForward();
    }

    private boolean rareUpgrade() {
        if (getLevel() % 3 == 0) {
            setDamageMultiplier(getDamageMultiplier() + 1);
            setArmorClass(getArmorClass() + 1);
            rucksackUpgrade();
            return true;
        }
        return false;
    }

    private void rucksackUpgrade() {
        getRucksack().getPowerUps().ensureCapacity(getLevel() * 5);
        getRucksack().setWeaponsLimit(getDamageMultiplier());
    }

    public void selectPlayerColor(){
        try {
            colorSelection();
        }catch (NoSuchElementException e){
            GameConsole.invalidChoice();
            colorSelection();
        }


    }

    private void colorSelection() {
        Scanner sc = new Scanner(System.in);
        int selection = 0;
        while(selection < 1 || selection > 5){
            printColorMenu();
            selection = sc.nextInt();
            switch (selection){
                case 1 -> setCharacterColor(Narrator.RED);
                case 2 -> setCharacterColor(Narrator.CYAN);
                case 3 -> setCharacterColor(Narrator.PURPLE);
                case 4 -> setCharacterColor(Narrator.GREEN);
                case 5 -> setCharacterColor(Narrator.YELLOW);
                default -> GameConsole.invalidChoice();
            }
        }
    }



    //endregion

    public final void incrementMoveCounter() {
        this.moveCounter += 1;
    }

    @Override
    public void block(GameCharacter c) {

        System.out.println("Blocked the hit");
        incrementMoveCounter();
    }

    public abstract void useSpecialAbility(NPC opponent, PlayerCharacter activePlayer);

    public final void heal() {
        incrementMoveCounter();
        if (getRucksack().getPowerUps().size() > 0) {
            getRucksack().getPowerUps().remove(0);
            setHealth(getHealth() + 10);
            System.out.println("Healed successfully");
            calculateHealthToAdd();
        } else {
            System.out.println("No potions left");
        }
    }

    public final void addMedPack() {
        getRucksack().getPowerUps().add(new MedPack());
    }


    @Override
    public abstract void printImage();

    public final void printAffiliationMenu() {
        System.out.println(Narrator.YELLOW +
                           "\n(C)      ANTHRAX CORPORATION LTD.(ANCORP)"+Narrator.CYAN +
                           "\n(P)      NATIONAL FRONT PARAMILITARY DIVISION(NFPD)"+Narrator.RED+
                           "\n(R)      SYNDICALIST LIBERATION FRONT(SLF)"+Narrator.PURPLE+
                           "\n(N)      LA COSA NOSTRA COMPANY(CNC)"+Narrator.GREEN+
                           "\n(I)      INDEPENDENT(IND)" + Narrator.ANSI_RESET);
    }

    private void printLevelUpMessage(boolean flag, int healthUpgrade) {
        System.out.println(Narrator.CYAN + "You've leveled up! " +
                           "\nLevel    +1 " +
                           "\nMedPacks: +1 " +
                           "\nHealth   +" + (getMaxHealth() - healthUpgrade) +
                           Narrator.ANSI_RESET);
        if (flag) {
            System.out.println("Damage      +1hd");
            System.out.println("Armor Class +1");
            System.out.println("Rucksack");
        }
    }

    public final void printPlayerStats() {
        System.out.println("Character Stats: ");
        if (this.getName() != null) {
            System.out.println(getCharacterColor() + getName() + " the " + this.baseClassToString() + Narrator.ANSI_RESET);
        } else {
            System.out.println(getCharacterColor() + this.baseClassToString() + Narrator.ANSI_RESET);
        }
        System.out.println("Affiliation: " + getAffiliation() +
                           "\nLevel: " + getLevel() +
                           "\nHealth: " + getHealth() + "/" + getMaxHealth() +
                           "\nPowerUps: " + getRucksack().getPowerUps().size()+
                           "\nSpecial Move: " + getCharacterColor() + this.specialMoveToString() + Narrator.ANSI_RESET);
    }

    private void printColorMenu(){
        System.out.println("""
                 1. Red
                 2. Blue
                 3. Purple
                 4. Green
                 5. Yellow""");
    }

    public abstract String specialMoveToString();

    public abstract String baseClassToString();


    //region PossibleHits
    protected void disadvantagedHit(NPC opponent, PlayerCharacter player) {
        Attack.disadvantagedHit(opponent, player);
    }

    protected void regularHit(NPC opponent, PlayerCharacter player) {
        Attack.regularHit(opponent, player);
    }

    protected void d4Hit(NPC opponent, PlayerCharacter player) {
        Attack.d4Hit(opponent, player);
    }

    protected void d6Hit(NPC opponent, PlayerCharacter player) {
        Attack.d6Hit(opponent, player);
    }

    protected void d8Hit(NPC opponent, PlayerCharacter player) {
        Attack.d8Hit(opponent, player);
    }

    protected void d10Hit(NPC opponent, PlayerCharacter player) {
        Attack.d10Hit(opponent, player);
    }

    protected void criticalHit(NPC opponent, PlayerCharacter player) {
        Attack.criticalHit(opponent, player);
    }

    protected void specialHit(NPC opponent, PlayerCharacter player) {
        Attack.specialHit(opponent, player);
    }

    //endregion
    @Override
    public void speak(PlayerCharacter player, NPC npc) {

    }

    @Override
    public void takeItem(ArrayList<Item> list, Item i) {
        i.printInfo();
        list.add(i);
    }

    @Override
    public void dropItem(ArrayList<Item> list, Item i) {
        list.remove(i);
    }

    @Override
    public void buyItem(ArrayList<Item> list, Item i) {
        list.add(i);
        setWallet(getWallet()-i.getPrice());
    }

    @Override
    public void sellItem(ArrayList<Item> list, Item i) {
        list.remove(i);
        setWallet(getWallet()+i.getPrice());
    }



}
