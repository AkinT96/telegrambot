package dungeongame.keyboards;

import dungeongame.bot.Bot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class KeyboardInHouse extends Bot {

    public void createKeyboardInHouseGreyWolves(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText("An der Klingel steht Haus Grauwolf. Du hörst knurren. Willst du das Haus betreten?");
        sendMessage.setChatId(chatId);

        ReplyKeyboardMarkup replyKeyboardMarkup = getReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void createKeyboardInHouseMiller(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText("Eine Menschenmenge steht vor dir");
        sendMessage.setChatId(chatId);

        ReplyKeyboardMarkup replyKeyboardMarkup = getReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void createKeyboardInHouseGerda(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText("Du betrittst einen Menschenleeren Raum");
        sendMessage.setChatId(chatId);

        ReplyKeyboardMarkup replyKeyboardMarkup = getReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }







    private ReplyKeyboardMarkup getReplyKeyboardMarkup() {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();

        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        KeyboardButton button1 = new KeyboardButton("Haus verlassen");

        row.add(button1);
        keyboard.add(row);

        replyKeyboardMarkup.setKeyboard(keyboard);
        replyKeyboardMarkup.setResizeKeyboard(true);

        return replyKeyboardMarkup;
    }
}
