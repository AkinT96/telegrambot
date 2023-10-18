package dungeongame.bot;

import dungeongame.characterandfights.Character;
import dungeongame.keyboards.StarterKeyboard;
import dungeongame.mapandpathing.Map;
import dungeongame.inventory.Inventory;
import dungeongame.mapandpathing.UserState;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

public class Bot extends TelegramLongPollingBot {
    private UserState userState;
    private Inventory inventory;
    private Character character;
    private StarterKeyboard starterKeyboard;
    @Override
    public String getBotUsername() {
        return "Dungeonbot";
    }

    @Override
    public String getBotToken() {
        return "6504637536:AAGG-g2LVs-wV8HmoesYi3V65rPzQb6fvmk";
    }


    @Override
    public void onUpdateReceived(Update update) {
        this.userState = new UserState(0,0);
        this.inventory = new Inventory();
        this.character = new Character();
        this.starterKeyboard = new StarterKeyboard();




        basicCommands(update);
    }





    private void basicCommands(Update update) {
        if (update.hasMessage()) {
            Message message = update.getMessage();
            Long chatId = message.getChatId();


            //starting point with Intro
            if (message.hasText() && message.getText().equals("/start")) {
                starterKeyboard.createStartKeyboard(chatId);
            }
            //output character attributes
            if (message.getText().equals("/charakter")) {
                character.showCharacterAttributes(chatId);
            }
            //output map with current position
            if (message.getText().equals("/karte")) {
                Map Map = new Map();
                Map.showMap(chatId,userState.getCurrentX(),userState.getCurrentY());
            }
            //output current Inventory
            if (message.getText().equals("/inventar")) {
                inventory.showInventory(chatId);
            }




        }
    }


    //5507628743


}

