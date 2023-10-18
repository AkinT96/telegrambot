package dungeongame.botcharacter.characterdetails;

import dungeongame.bot.Bot;
import dungeongame.botcharacter.characterdetails.inventory.Item;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    private final List<Item> inventory = new ArrayList<>();



    public void addItems(Item item){
        inventory.add(item);
    }

    public String showInventory() {
        if (!inventory.isEmpty()) {
            StringBuilder inventoryText = new StringBuilder("Dein Inventar:\n");
            for (Item item : inventory) {
                inventoryText.append(item.getName()).append("\n");
            }
            return inventoryText.toString();
        } else {
            return "Dein Inventar ist leer";
        }
    }



}
