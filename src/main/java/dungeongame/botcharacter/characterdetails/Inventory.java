package dungeongame.botcharacter.characterdetails;

import dungeongame.bot.Bot;
import dungeongame.botcharacter.characterdetails.inventory.Item;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    private final List<Item> inventory = new ArrayList<>();


    public void addItems(Item item) {
        inventory.add(item);
    }

    public String showInventory() {
        if (!inventory.isEmpty()) {
            StringBuilder inventoryText = new StringBuilder("Dein Inventar:\n");
            for (Item item : inventory) {
                inventoryText.append(item.getName()).append("\n Angriffswert: ").append(item.getAttackStrengthOfItem()).append("\t Verteidigungswert: ").append(item.getDefensiveStrengthOfItem()).append("\n");
            }
            return inventoryText.toString();
        } else {
            return "Dein Inventar ist leer";
        }
    }

    public int combinedAttackStrength() {
        int combinedAttack = 0;
        for (Item item : inventory) {
            combinedAttack += item.getAttackStrengthOfItem();
        }
        return combinedAttack;
    }

    public int combinedDefensiveStrength() {
        int combinedDefense = 0;

        for (Item item : inventory) {
            combinedDefense += item.getAttackStrengthOfItem();
        }
        return combinedDefense;
    }


}
