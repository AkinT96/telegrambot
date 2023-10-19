package dungeongame.keyboards;

import dungeongame.bot.Bot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class StandardKeyboard extends Bot {


    //Keyboard with starting message
    public void createStartKeyboard(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText("""
                Hallo Krieger! Ein kleines Dörfchen hat dich zur Hilfe gerufen. Um dich herum kein Mensch.
                Kannst du herausfinden, was hier passiert ist?
                Im Menu kannst du dir deine Attribute, Position und dein Inventar anzeigen lassen.
                Der rote Punkt markiert deine Position.
                Eine Übersicht über deine Befehle:
                \uD83D\uDC41 Schaue dich um
                ↕\uFE0F Benutzte die Pfeile um in die jeweilige Richtung zu gehen

                Viel Erfolg Abenteurer!""");
        sendMessage.setChatId(chatId);

        ReplyKeyboardMarkup replyKeyboardMarkup = getReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    // keyboard after leaving a house
    public void createKeyboardLeavingHouses(Long chatID){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText("In welche Richtung geht es Krieger?");
        sendMessage.setChatId(chatID);

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
        KeyboardButton button1 = new KeyboardButton("\uD83D\uDC41");
        KeyboardButton button2 = new KeyboardButton("⬆️");
        KeyboardButton button3 = new KeyboardButton("⬇️");
        KeyboardButton button4 = new KeyboardButton("⬅️");
        KeyboardButton button5 = new KeyboardButton("➡️");

        row.add(button1);
        row.add(button2);
        row.add(button3);
        row.add(button4);
        row.add(button5);
        keyboard.add(row);

        replyKeyboardMarkup.setKeyboard(keyboard);
replyKeyboardMarkup.setResizeKeyboard(true);

        return replyKeyboardMarkup;
    }
}
