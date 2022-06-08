package characters.npc_classes;

import characters.GameCharacter;
import inventory.weapons.Weapon;
import inventory.weapons.ballistic.*;
import inventory.weapons.explosives.C4;
import inventory.weapons.explosives.PlasmaGrenade;
import inventory.weapons.melee.HuntingKnife;
import inventory.weapons.melee.Katana;
import inventory.weapons.melee.ShockMace;
import inventory.weapons.psychogenics.Telekenesis;
import inventory.weapons.tech.DroneSwarm;
import inventory.weapons.tech.EMPCannon;
import inventory.weapons.tech.SonicBlast;
import main.auxilliary_tools.Dice;

public abstract class NPC extends GameCharacter {

    public final void setStats(int[] stats) {
        setHealth(stats[0]);
        setMaxHealth(stats[0]);
        setArmorClass(stats[1]);
        setLevel(stats[2]);
    }

    @Override
    public void block(GameCharacter c) {
        System.out.println("Blocked the hit");
    }

    @Override
    public void printImage() {
    }


    public void printPlayerInformation() {
        System.out.println("Enemy stats:");
        System.out.println(getName());
        System.out.println();
        System.out.println("Level: " + getLevel());
        System.out.println("Health: " + getHealth());
        System.out.println("Weapon: " + getEquippedWeapon().getDamage());

    }

    public static Weapon generateYakuzaWeapon() {
        Weapon[] possibleYakuzaWeapons = new Weapon[]{new Katana(), new Uzi(), new Glock17(), new EMPCannon(),
                new C4(), new M82A1SniperRile()};

        return possibleYakuzaWeapons[Dice.d6(1)-1];
    }

    public static Weapon generateCartelWeapon() {
        Weapon[] possibleCartelWeapons = new Weapon[]{new HuntingKnife(), new Uzi(), new ShockMace(),
                new GrenadeLauncher(), new AK47(), new M249SAW()};

        return possibleCartelWeapons[Dice.d6(1)-1];
    }

    public static Weapon generateSTARCorpWeapon() {
        Weapon[] possibleSTARCorpWeapons = new Weapon[]{new Telekenesis(), new M4Carbine(), new Glock17(),
                new PlasmaGrenade(), new DroneSwarm(), new SonicBlast()};
        return possibleSTARCorpWeapons[Dice.d6(1)-1];
    }

    public static String generateYakuzaName() {
        String[] possibleYakuzaNames = new String[]{
                "Hiro Takahashi", "Ikeda Masa", "Shiro Hikaru", "Takamoto Yoichi",
                "Fujii Katashi", "Nagano Nori", "Sawada Shichiro", "Hirano Mikio",
                "Hamamoto Hisashi", "Hino Kenji", "Sano Tadashi", "Sasaki Toru",
                "Kaneshiro Tsutomu", "Toyama Madoka", "Sakai Takahiro","Shimizu Hisoka",
                "Yamamura Yori","Nakamura Ichirou","Morimoto Yuji","Akiyama Shuichi"};
        return possibleYakuzaNames[Dice.d20()-1];
    }

    public static String generateCartelName() {
        String[] possibleCartelNames = new String[]{
                "Manuel Lopez", "Jose Sandoval", "Eduardo Costa", "Pedro Jimenez",
                "Juan Morales", "Francisco Perez", "Armando Cortez", "Joker",
                "Ricardo Milos", "Lucio Martinez", "Luis Ochoa", "Oso",
                "Carlos Montalban", "Pablo Marquez", "Emilio Escobar","Jesus Jimenez",
                "Aldo Ruiz","Alonzo Alvares","Felipe Nunes","Santino Bautista"};
        return possibleCartelNames[Dice.d20()-1];
    }
    public static String generateSTARCorpName() {
        String[] possibleSTARCorpNames = new String[]{
                "Antuan Dixon", "Jacob Miller", "Richard Wilkins", "Donald Dubois",
                "James Blackfield", "David Dillinger", "Mitch O'Hara", "Aaron Park",
                "Robert Packard", "John Stone", "Shane Watson", "Simon Hill",
                "Alice Dark", "Ryan Davis", "George Eire","Sydney Black",
                "Sam White","Lloyd Allen","Daron Niles","Ray Donovan"};
        return possibleSTARCorpNames[Dice.d20()-1];
    }
}
