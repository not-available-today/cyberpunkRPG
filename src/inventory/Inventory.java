package inventory;

import characters.GameCharacter;
import characters.player_characters.PlayerCharacter;
import cli.GameConsole;
import inventory.power_ups.MedPack;
import inventory.power_ups.Psycho;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Inventory {

    public ArrayList<Item> powerUps;
    public ArrayList<Item> arsenal;
    public ArrayList<Item> miscellaneous;
    public ArrayList<ArrayList> rucksack;

    private int weaponsLimit;
    private int storageLimit;

    public Inventory(PlayerCharacter player) {
        this.rucksack = new ArrayList<>();
        this.powerUps = new ArrayList<>();
        this.arsenal = new ArrayList<>();
        this.miscellaneous = new ArrayList<>();
        this.rucksack.add(powerUps);
        arsenalInitialization(player);
        powerUpInitialization(player);


    }



    private void powerUpInitialization(PlayerCharacter player) {
        MedPack meds = new MedPack();
        player.getRucksack().getPowerUps().add(meds);
        for (int i = 0;i< getPowerUps().size()-2;i++){
            getPowerUps().add(new Psycho());
        }
    }


    private void arsenalInitialization(GameCharacter player) {
        getArsenal().add(player.getPrimaryWeapon());
        getArsenal().add(player.getSecondaryWeapon());
    }

    public ArrayList<Item> getPowerUps() {
        return this.powerUps;
    }

    public ArrayList<Item> getArsenal() {
        return this.arsenal;
    }

    public ArrayList<Item> getMiscellaneous() {
        return this.miscellaneous;
    }


    public int getWeaponsLimit() {
        return weaponsLimit;

    }

    public void setWeaponsLimit(int weaponsLimit) {
        this.weaponsLimit = weaponsLimit;
    }

    public int getStorageLimit() {
        return storageLimit;
    }

    public void setStorageLimit(int storageLimit) {
        this.storageLimit = storageLimit;
    }

    public void viewRucksack() {
        for (Item item : getPowerUps()) {
            System.out.print(getPowerUps().indexOf(item));item.printInfo();
        }
    }

    public void viewMenu(ArrayList<Item> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(i + ". ");
            list.get(i).printInfo();
        }
    }

    public void viewMainInventoryMenu() {
        System.out.println("""
                1. View All
                2. Power Ups
                3. Arsenal
                4. Miscellaneous
                """);
    }

    public void selectMenuToView() {
        try{
            itemMenuSelection();
        }catch (NoSuchElementException e){
            GameConsole.invalidChoice();
            itemMenuSelection();
        }
    }

    private void itemMenuSelection() {
        Scanner sc = new Scanner(System.in);
        int selection = 0;
        while (selection < 1 || selection > 3) {
            viewMainInventoryMenu();
            selection = sc.nextInt();
            switch (selection) {
                case 1 -> viewRucksack();
                case 2 -> viewMenu(getPowerUps());
                case 3 -> viewMenu(getArsenal());
                case 4 -> viewMenu(getMiscellaneous());
                default -> GameConsole.invalidChoice();
            }

        }
    }


}
