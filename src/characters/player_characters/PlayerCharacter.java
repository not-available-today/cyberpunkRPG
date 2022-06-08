package characters.player_characters;

import characters.GameCharacter;
import characters.Interactable;
import characters.npc_classes.NPC;
import cli.GameConsole;
import inventory.Item;
import inventory.weapons.Weapon;
import main.auxilliary_tools.Narrator;
import main.gameplay.Game;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public abstract class PlayerCharacter extends GameCharacter implements Interactable {


    private int moveCounter;
    private int damageMultiplier;
    private String characterColor;
    private Game.affiliation affiliation;
    private Weapon primaryWeapon;
    private Weapon secondaryWeapon;
    private int wallet;


    //region getters/setters
    public int getMoveCounter() {
        return this.moveCounter;
    }

    public void setMoveCounter(int moveCounter) {
        this.moveCounter = moveCounter;
    }

    public final int getDamageMultiplier() {
        return this.damageMultiplier;
    }

    public final void setDamageMultiplier(int statMultiplier) {
        this.damageMultiplier = statMultiplier;
    }

    public final String getCharacterColor() {
        return this.characterColor;
    }

    public void setCharacterColor(String characterColor) {
        this.characterColor = characterColor;
    }

    public Game.affiliation getAffiliation() {
        return this.affiliation;
    }

    public void setAffiliation(Game.affiliation affiliation) {
        this.affiliation = affiliation;
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

    public Integer getWallet() {
        return this.wallet;
    }

    public void setWallet(int wallet) {
        this.wallet = wallet;
    }

    //endregion

    //region Stats,Info and LevelUp
    public abstract int getHealthFormula();

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

    public final void selectAffiliation() {
        try {
            affiliationSelection();
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
            GameConsole.invalidChoice();
            System.out.println();
            affiliationSelection();
            System.out.println();
        }
    }

    public final void affiliationSelection() throws NoSuchElementException {
        int choice;
        Scanner sc = new Scanner(System.in);
        if (sc.hasNext()) {
            choice = sc.nextInt();
            switch (choice) {
                case 1 -> setAffiliation(Game.affiliation.CORPORATE);
                case 2 -> setAffiliation(Game.affiliation.PARAMILITARY);
                case 3 -> setAffiliation(Game.affiliation.REVOLUTIONARY);
                case 4 -> setAffiliation(Game.affiliation.MAFIA);
                case 5 -> setAffiliation(Game.affiliation.INDEPENDENT);
                default -> selectAffiliation();
            }
        }
    }

    public final void selectPlayerColor() {
        try {
            colorSelection();
        } catch (NoSuchElementException e) {
            GameConsole.invalidChoice();
            colorSelection();
        }
    }

    private void colorSelection() {
        int selection;
        do {
            Scanner sc = new Scanner(System.in);
            printColorMenu();
            selection = sc.nextInt();
            switch (selection) {
                case 1 -> setCharacterColor(Narrator.RED);
                case 2 -> setCharacterColor(Narrator.CYAN);
                case 3 -> setCharacterColor(Narrator.PURPLE);
                case 4 -> setCharacterColor(Narrator.GREEN);
                case 5 -> setCharacterColor(Narrator.YELLOW);
                default -> colorSelection();
            }
        } while (selection < 1 || selection > 5);


    }

    private boolean rareUpgrade() {
        if (getLevel() % 3 == 0) {
            setDamageMultiplier(getDamageMultiplier() + 1);
            setArmorClass(getArmorClass() + 1);
            return true;
        }
        return false;
    }

    public final void levelUp() {
        addMedPack();
        getEquippedWeapon().upgradeWeapon(this);
        setLevel(getLevel() + 1);
        setHealth(getHealthFormula() + getMaxHealth());
        printLevelUpMessage(rareUpgrade(), getHealthFormula());
        setMaxHealth(getHealth());

        GameConsole.moveForward();
    }


    //endregion

    //region actions
    public final void incrementMoveCounter() {
        setMoveCounter(getMoveCounter() + 1);
    }

    public abstract void useSpecialAbility(NPC opponent, PlayerCharacter activePlayer);

    public void equipWeapon() {
        Scanner sc = new Scanner(System.in);
        printWeaponsMenu();
        String selection = sc.nextLine();
        switch (selection) {
            case "1" -> setEquippedWeapon(getPrimaryWeapon());
            case "2" -> setEquippedWeapon(getSecondaryWeapon());
            default -> equipWeapon();
        }
    }

    public final void heal() {
        incrementMoveCounter();
        if (getMeds().getQuantity() > 0) {
            getMeds().setQuantity(getMeds().getQuantity() - 1);
            setHealth(getHealth() + getMeds().getStrength());
            System.out.println("Healed successfully");
            calculateHealthToAdd();
        } else {
            System.out.println("No MedPacks left");
        }
    }

    @Override
    public void block(GameCharacter c) {

        System.out.println("Blocked the hit");
        incrementMoveCounter();
    }

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
        setWallet(getWallet() - i.getPrice());
    }

    @Override
    public void sellItem(ArrayList<Item> list, Item i) {
        list.remove(i);
        setWallet(getWallet() + i.getPrice());
    }
    //endregion


    @Override
    public abstract void printImage();

    public final void printAffiliationMenu() {
        System.out.println(Narrator.GREEN + "===============CHOOSE YOUR CLAN===============" + Narrator.ANSI_RESET +
                           "\n(1)  ANTHRAX CORPORATION LTD.(ANCORP)" +
                           "\n(2)  NATIONAL FRONT PARAMILITARY DIVISION(NFPD)" +
                           "\n(3)  SYNDICALIST LIBERATION FRONT(SLF)" +
                           "\n(4)  LA COSA NOSTRA COMPANY(CNC)" +
                           "\n(5)  INDEPENDENT(IND)");
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


    public void printWeaponsMenu() {
        System.out.println("Select a weapon:\n");
        System.out.print("1. ");
        getPrimaryWeapon().printInfo();
        System.out.println();
        System.out.print("2. ");
        getSecondaryWeapon().printInfo();
    }

    public final void printPlayerInformation() {
        System.out.println("Character Information: ");
        if (this.getName() != null) {
            System.out.println(getCharacterColor() + getName() + " the " + this.baseClassToString() + Narrator.ANSI_RESET);
        } else {
            System.out.println(getCharacterColor() + this.baseClassToString() + Narrator.ANSI_RESET);
        }
        System.out.println("Affiliation   :" + getAffiliation() +
                           "\nLevel       :" + getLevel() +
                           "\nHealth      :" + getHealth() + "/" + getMaxHealth() +
                           "\nMedPacks    :" + getMeds().getQuantity() +
                           "\nArmor Class :" + getArmorClass() +
                           "\nSpecial Move:" + getCharacterColor() + this.specialMoveToString() + Narrator.ANSI_RESET);
    }

    private void printColorMenu() {
        System.out.println("""
                Select Your Desired Color:
                1. Red
                2. Blue
                3. Purple
                4. Green
                5. Yellow""");
    }

    public abstract String specialMoveToString();

    public abstract String baseClassToString();
}
