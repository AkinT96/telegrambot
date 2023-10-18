package dungeongame.keyboards;

import dungeongame.bot.Bot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class StarterKeyboard extends Bot {
    public void createStartKeyboard(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText("""
                Hallo Krieger! Beweise dich in großen Abenteuern und zeige deine Stärke.
                Im Menu kannst du dir deine Attribute, Position und dein Inventar anzeigen lassen.
                Der rote Punkt markiert deine Position.
                Eine Übersicht über deine Befehle:
                \uD83D\uDC41 Schaue dich um
                ↕\uFE0F Benutzte die Pfeile um in die jeweilige Richtung zu gehen
                ↪\uFE0F Kehre, wenn möglich, zurück zum Startpunkt

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


    private ReplyKeyboardMarkup getReplyKeyboardMarkup() {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();

        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        KeyboardButton button1 = new KeyboardButton("\uD83D\uDC41");
        KeyboardButton button2 = new KeyboardButton("⬆\uFE0F");
        KeyboardButton button3 = new KeyboardButton("⬇\uFE0F");
        KeyboardButton button4 = new KeyboardButton("⬅\uFE0F");
        KeyboardButton button5 = new KeyboardButton("➡\uFE0F");
        KeyboardButton button6 = new KeyboardButton("↪\uFE0F");

        row.add(button1);
        row.add(button2);
        row.add(button3);
        row.add(button4);
        row.add(button5);
        row.add(button6);
        keyboard.add(row);
        replyKeyboardMarkup.setKeyboard(keyboard);


        return replyKeyboardMarkup;
    }
}
