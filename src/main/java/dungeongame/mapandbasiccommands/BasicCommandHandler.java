package dungeongame.mapandbasiccommands;

import dungeongame.bot.Bot;
import dungeongame.keyboards.StarterKeyboard;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendVoice;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class BasicCommandHandler {

    public static void basicCommands(Bot bot, Update update) {
        StarterKeyboard starterKeyboard = new StarterKeyboard();
        Map map = new Map();


        if (update.hasMessage()) {
            Message message = update.getMessage();
            Long chatId = message.getChatId();

            if (message.hasText() && message.getText().equals("/start")) {
                starterKeyboard.createStartKeyboard(chatId);
                try {
                    bot.execute(soundeffekt(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
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
                SendMessage sendMessage = new SendMessage();
                sendMessage.setChatId(chatId);
                sendMessage.setText(bot.getCharacter().getAttributes().toString());
                try {
                    bot.execute(sendMessage);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private static SendVoice soundeffekt(Long chatId) {
        SendVoice sendVoice = new SendVoice();
        sendVoice.setChatId(chatId);
        sendVoice.setCaption("Spiel mich ab");
        sendVoice.setVoice(new InputFile("https://public.db.files.1drv.com/y4mRWoNdgN8x17sIGeKlg1mTkPEKDv2STGZuOQ2Ut5Kl0RzoNi2LyzrtzcSIPyuAXGUVXQjj6mVVfHdOqnyvKPO_0ElLosRqhanRnoUdccd-1_9ZuMSz3hpR7ZCdYe-Q1TY40es7mH62gZAyhbP-I_TR6IhgAApCYc_qEJWx_pKWhJaeSNwmoY64A5_3jNn9Z03bt36RsmtQbyOkoQT9IweQmzjUdI7mNAQSFLa1HoESOM?AVOverride=1"));
        return sendVoice;
    }

}
