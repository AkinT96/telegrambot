package dungeongame.Basiccommands;

import dungeongame.bot.Bot;
import dungeongame.keyboards.StandardKeyboard;
import dungeongame.MapsAndHouses.Map;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class BasicCommandHandler {

    public static void basicCommands(Bot bot, Update update) {
        StandardKeyboard standardKeyboard = new StandardKeyboard();
        Map map = new Map();


        if (update.hasMessage()) {
            Message message = update.getMessage();
            Long chatId = message.getChatId();
            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(chatId);



            if (message.hasText() && message.getText().equals("/start") || message.getText().equals("/tastatur")) {
                standardKeyboard.createStartKeyboard(chatId);
            }

            if (message.getText().equals("⬆️")) {
                bot.getCharacter().getPlayerState().setCurrentXUp();
            }
            if (message.getText().equals("⬇️")) {
                bot.getCharacter().getPlayerState().setCurrentXDown();
            }
            if (message.getText().equals("➡️")) {
                bot.getCharacter().getPlayerState().setCurrentYDown();
            }
            if (message.getText().equals("⬅️")) {
                bot.getCharacter().getPlayerState().setCurrentYUp();
            }

            if (message.getText().equals("/karte")) {
                map.showMap(chatId, bot.getCharacter().getPlayerState().getCurrentX(), bot.getCharacter().getPlayerState().getCurrentY());
            }

            if (message.getText().equals("/charakter")) {

                sendMessage.setText(bot.getCharacter().getAttributes().toString());
                try {
                    bot.execute(sendMessage);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
            if (message.getText().equals("/inventar")){
                sendMessage.setText(bot.getCharacter().getInventory().showInventory());
                try {
                    bot.execute(sendMessage);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }


}
