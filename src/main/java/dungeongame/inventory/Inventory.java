package dungeongame.inventory;

import dungeongame.bot.Bot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class Inventory extends Bot {

    private final List<Item> inventory = new ArrayList<>();


    public void addItems(Item item){
        inventory.add(item);
    }

    public String iterateInventory() {
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

    public void showInventory(Long chatID){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText(iterateInventory());
        sendMessage.setChatId(chatID);
        try{
            execute(sendMessage);
        } catch (TelegramApiException e){
            e.printStackTrace();
        }
    }

}
