package dungeongame.bot;

import dungeongame.botcharacter.Character;
import dungeongame.keyboards.StarterKeyboard;
import dungeongame.mapsandfindingitems.Map;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot {

    private final Character character;


    public Bot(){
        this.character = new Character();

    }
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

        basicCommands(update);



    }






    private void basicCommands(Update update) {
        StarterKeyboard starterKeyboard = new StarterKeyboard();
        Map map = new Map();
        if (update.hasMessage()) {
            Message message = update.getMessage();
            Long chatId = message.getChatId();


            //starting point with Intro and keyboard
            if (message.hasText() && message.getText().equals("/start")) {
                starterKeyboard.createStartKeyboard(chatId);
            }
            //moving character on the map
            if (message.getText().equals("⬆️")) {
                 character.getPlayerState().setCurrentXUp();
            }
            if (message.getText().equals("⬇️")) {
                character.getPlayerState().setCurrentXDown();
            }
            if (message.getText().equals("➡️")) {
                character.getPlayerState().setCurrentYDown();
            }
            if (message.getText().equals("⬅️")) {
                character.getPlayerState().setCurrentYUp();
            }


            //output map with current position
            if (message.getText().equals("/karte")){
                map.showMap(chatId,character.getPlayerState().getCurrentX(),character.getPlayerState().getCurrentY());
            }






        }
    }


    //5507628743


}

