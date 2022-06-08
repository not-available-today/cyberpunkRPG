package inventory.weapons.explosives;


import characters.player_characters.PlayerCharacter;
import main.auxilliary_tools.Dice;

public class PlasmaGrenade extends Explosive {

    private int plasmaDamage;

    public PlasmaGrenade() {
        setQuantity(5);
        setBurnDamage(Dice.d6(2));
        setPlasmaDamage(Dice.d8(2));
        setDamage(Dice.d4(1) + getPlasmaDamage() + getBurnDamage());
        setName("Plasma Grenade");
    }

    public int getPlasmaDamage() {
        return plasmaDamage;
    }

    public void setPlasmaDamage(int plasmaDamage) {
        this.plasmaDamage = plasmaDamage;
    }

    @Override
    public void printInfo() {
        System.out.println(getName() +
                           "\nQuantity            :" + getQuantity() +
                           "\nMaximum Capacity    :" + getMaxQuantity() +
                           "\nBurn Damage         :" + getBurnDamage()+
                           "\nPlasma Damage       :" + getPlasmaDamage()+
                           "\nTotal Damage        :" + getDamage());
    }

    @Override
    public void upgradeWeapon(PlayerCharacter p) {
        setQuantity(getMaxQuantity() + Dice.d4(2));
        setMaxQuantity(getQuantity());
        setBurnDamage(getBurnDamage() + Dice.d4(1));
        setPlasmaDamage(getPlasmaDamage() + Dice.d6(1));
        setDamage(getDamage() + getPlasmaDamage() + getBurnDamage());
    }

    @Override
    public void depleteWeapon(int roll) {

    }
}
