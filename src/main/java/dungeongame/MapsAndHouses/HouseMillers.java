package dungeongame.MapsAndHouses;

import dungeongame.bot.Bot;
import dungeongame.botcharacter.characterdetails.inventory.Item;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.methods.send.SendVoice;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class HouseMillers {

    private static final Item keys = new Item("Schlüssel", 0, 0);

    public static void HouseMillerInteraction(Bot bot, Update update) {


        if (bot.getCharacter().getPlayerState().getCurrentX() == 1 && bot.getCharacter().getPlayerState().getCurrentY() == 2 && update.getMessage().getText().equals("Ja")) {
           sendPicture(bot,update.getMessage().getChatId(),"https://db3pap006files.storage.live.com/y4mF7uBq52brL0MCC9J4Pg80OiQpqXwK5KCkLnRadbLgghUmA0BKgF96fc5dcojM8y_MtftOo6ARPnl0eKirLX2Dh3ejaTmM5do9uGau7QPzKHCp0J6ab3g10ZYNjtPE22Md-GazHjXqGtT2pRYz1uP31DzVb0cX1IIR1jhgT5wHQFBkFGIfqV2TwfQ3A98fucfWpW1Ceb9qxZRnvKOReEI4MK_N1CnzQrNphr4d-EELqY?encodeFailures=1&width=220&height=220");
            sendVoice(bot,update.getMessage().getChatId(),"https://public.db.files.1drv.com/y4m1e8XzmbOM0BnU3W-7Qjwj5CwKhQu4RRhMHulIFyqtOdlAGLXBWPuLqnmMz-zwN5tyU4UNUB6tjAqVQnL5m0Dh4AcLEQH6c66W9NkOcgibHEUCseC54GCRJdxpW6dKAm0mUkGRnFxAIHnzHiXVlkdmD4e774enDtih27DEExMMwrQ2biqDX03iiCPaq1VaAXSMPiy8kCOaZyAxcc5GT1Ka-Q7haC-tAuSj-0RvOBAnYU?AVOverride=1");


            try {
                Thread.sleep(34000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            sendText(bot,update.getMessage().getChatId(),"Du steckst den Schlüssel in dein Inventar");
            bot.getCharacter().getInventory().addItems(keys);
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