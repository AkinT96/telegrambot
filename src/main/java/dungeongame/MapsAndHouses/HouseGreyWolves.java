package dungeongame.MapsAndHouses;

import dungeongame.bot.Bot;
import dungeongame.botcharacter.characterdetails.Playerposition;
import dungeongame.botcharacter.characterdetails.inventory.Item;
import dungeongame.keyboards.KeyboardInHouse;
import dungeongame.keyboards.StandardKeyboard;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.methods.send.SendVoice;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class HouseGreyWolves {

    private static Item leder = new Item("Leder", 0, 0);
    private static final Playerposition resetPosition = new Playerposition(0, 0);

    public static void HouseGreyWolvesInteraction(Bot bot, Update update) {

        //checking if the player : pressed yes, is on the right position, is the first time here
        if (bot.getCharacter().getPlayerState().getCurrentX() == 2 && bot.getCharacter().getPlayerState().getCurrentY() == 0 && update.getMessage().getText().equals("Ja") && !bot.isHouseGerdaFlag() && bot.isWolvesAlive()) {
            KeyboardInHouse keyboardInHouse = new KeyboardInHouse();
            keyboardInHouse.createKeyboardInHouseGreyWolves(update.getMessage().getChatId());
            sendPicture(bot, update.getMessage().getChatId(), "https://db3pap006files.storage.live.com/y4m_Wf-i4hFo7tSScK5PubptbqwzVEJqlAkTMKGyLvPUdk9TyhVhcGUvzae7nx4wVD871J48o44rF4xXE5zn0OjNbNFO-Dd2Xq4DR_ra6Kj57IPeztZDg7vu3xJYxAbU0psdvaB5qsz_ToxzldhkvDiJwaBKiM8HTSNKWQrDdUdK93KNBDIhVheVlUp_u_KidnI6LS2zw7mArwBTuPo6kVEB1U6TEYbDp0eIUzN0PKQMNE?encodeFailures=1&width=883&height=883");
            sendText(bot, update.getMessage().getChatId(), "Dein Krieger befindet sich im Kampf, warte ein wenig");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            sendText(bot, update.getMessage().getChatId(), "Du verlierst ein wenig Leben, aber du hast gesiegt! Du nimmst dir ein wenig Leder mit");
            bot.getCharacter().getInventory().addItems(leder);
            bot.getCharacter().getAttributes().setLife(80);
            bot.setWolvesAlive(false);
        } else if (bot.getCharacter().getPlayerState().getCurrentX() == 2 && bot.getCharacter().getPlayerState().getCurrentY() == 0 && update.getMessage().getText().equals("Ja") && bot.isWolvesAlive()) {
            KeyboardInHouse keyboardInHouse = new KeyboardInHouse();
            keyboardInHouse.createKeyboardInHouseGreyWolves(update.getMessage().getChatId());
            sendPicture(bot, update.getMessage().getChatId(), "https://db3pap006files.storage.live.com/y4m_Wf-i4hFo7tSScK5PubptbqwzVEJqlAkTMKGyLvPUdk9TyhVhcGUvzae7nx4wVD871J48o44rF4xXE5zn0OjNbNFO-Dd2Xq4DR_ra6Kj57IPeztZDg7vu3xJYxAbU0psdvaB5qsz_ToxzldhkvDiJwaBKiM8HTSNKWQrDdUdK93KNBDIhVheVlUp_u_KidnI6LS2zw7mArwBTuPo6kVEB1U6TEYbDp0eIUzN0PKQMNE?encodeFailures=1&width=883&height=883");
            sendText(bot, update.getMessage().getChatId(), "Dein Krieger befindet sich im Kampf, warte ein wenig");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            sendText(bot, update.getMessage().getChatId(), "Du stirbst und verlierst deinen gesamten Besitz. Starte von vorne!");
            bot.getCharacter().setPlayerposition(resetPosition);
            bot.getCharacter().getInventory().removeItemByName("Schlüssel");
            StandardKeyboard standardKeyboard = new StandardKeyboard();
            standardKeyboard.createKeyboardLeavingHouses(update.getMessage().getChatId());
            bot.setHouseMillersFlag(true);
            bot.setHouseGerdaFlag(true);
        } else if (bot.getCharacter().getPlayerState().getCurrentX() == 2 && bot.getCharacter().getPlayerState().getCurrentY() == 0 && update.getMessage().getText().equals("Ja") && !bot.isWolvesAlive()) {
            KeyboardInHouse keyboardInHouse = new KeyboardInHouse();
            keyboardInHouse.createKeyboardInHouseGreyWolvesAfterFight(update.getMessage().getChatId());
        }

    }

    public static void sendPicture(Bot bot, Long chatID, String PictureURL) {
        SendPhoto photo = new SendPhoto();
        photo.setChatId(chatID);
        photo.setPhoto(new InputFile(PictureURL));
        try {
            bot.execute(photo);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    public static void sendVoice(Bot bot, Long chatID, String VoiceURL) {
        SendVoice voice = new SendVoice();
        voice.setChatId(chatID);
        voice.setCaption("Der alte Mann spricht zu dir");
        voice.setVoice(new InputFile(VoiceURL));
        try {
            bot.execute(voice);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    public static void sendText(Bot bot, Long chatID, String Text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatID);
        sendMessage.setText(Text);
        try {
            bot.execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

}
