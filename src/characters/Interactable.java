package characters;

import characters.npc_classes.NPC;
import characters.player_characters.PlayerCharacter;
import inventory.Item;

import java.util.ArrayList;

public interface Interactable {

    void speak(PlayerCharacter player, NPC npc);

    void takeItem(ArrayList<Item> list, Item i);

    void dropItem(ArrayList<Item> list, Item i);

    void buyItem(ArrayList<Item> list, Item i);

    void sellItem(ArrayList<Item> list, Item i);

}
