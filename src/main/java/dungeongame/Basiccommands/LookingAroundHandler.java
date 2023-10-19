package dungeongame.Basiccommands;
import dungeongame.bot.Bot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import dungeongame.keyboards.KeyboardInFrontOfHouse;
public class LookingAroundHandler {

    public static void handleLookingAround(Bot bot, Update update) {
        Message message = update.getMessage();
        Long chatId = message.getChatId();
        KeyboardInFrontOfHouse keyboardinfrontofhouse = new KeyboardInFrontOfHouse();
        SendMessage sendMessage = new SendMessage();

        if (message.getText().equals("\uD83D\uDC41")) {
            if (bot.getCharacter().getPlayerState().getCurrentX() == 0) {
                switch (bot.getCharacter().getPlayerState().getCurrentY()) {
                    case 0, 2:
                        sendMessage.setText("Um dich herum ist alles grün und friedlich. Es ist ruhig, vielleicht zu ruhig?");
                        sendMessage.setChatId(chatId);
                        try {
                            bot.execute(sendMessage);
                        } catch (TelegramApiException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 1:
                        keyboardinfrontofhouse.createKeyboardInFrontOfHouseGerade(chatId);
                        break;
                }
            } else if (bot.getCharacter().getPlayerState().getCurrentX() == 1) {
                switch (bot.getCharacter().getPlayerState().getCurrentY()) {
                    case 0, 1:
                        sendMessage.setText("Um dich herum ist alles grün und friedlich. Es ist ruhig, vielleicht zu ruhig?");
                        sendMessage.setChatId(chatId);
                        try {
                            bot.execute(sendMessage);
                        } catch (TelegramApiException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 2:
                        keyboardinfrontofhouse.createKeyboardInFrontOfHouseMiller(chatId);
                        break;
                }
            } else if (bot.getCharacter().getPlayerState().getCurrentX() == 2) {
                switch (bot.getCharacter().getPlayerState().getCurrentY()) {
                    case 0:
                        if (bot.isWolvesAlive()) keyboardinfrontofhouse.createKeyboardInFrontOfHouseGreyWolves(chatId);
                        else keyboardinfrontofhouse.createKeyboardInFrontOfHouseGreyWolvesAfterFight(chatId);
                        break;
                    case 1, 2:
                        sendMessage.setText("Um dich herum ist alles grün und friedlich. Es ist ruhig, vielleicht zu ruhig?");
                        sendMessage.setChatId(chatId);
                        try {
                            bot.execute(sendMessage);
                        } catch (TelegramApiException e) {
                            e.printStackTrace();
                        }
                        break;
                }
            }
        }
    }
}

