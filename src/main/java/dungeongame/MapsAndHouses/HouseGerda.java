package dungeongame.MapsAndHouses;

import dungeongame.bot.Bot;
import dungeongame.botcharacter.characterdetails.inventory.Item;
import dungeongame.keyboards.KeyboardInHouse;
import dungeongame.keyboards.StandardKeyboard;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.methods.send.SendVoice;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class HouseGerda {

    private static final Item item1 = new Item("Schwert", 10, 0);
    private static final Item item2 = new Item("Schild", 0, 20);
    private static final Item item3 = new Item("Helm", 0, 5);
    private static final Item item4 = new Item("Brustplatte", 0, 15);
    private static final Item item5 = new Item("Handschuhe", 5, 0);
    private static final Item item6 = new Item("Stiefel", 2, 0);
    private static final Item item7 = new Item("Ring der Stärke", 15, 0);
    private static final Item item8 = new Item("Amulett der Verteidigung", 0, 25);
    private static final Item item9 = new Item("Umhang", 0, 10);
    private static final Item item10 = new Item("Gürtel", 3, 0);
    public static void HouseGerdaInteraction(Bot bot, Update update) {

        //checking if the player : pressed yes, is on the right position, is the first time here
        if (bot.getCharacter().getPlayerState().getCurrentX() == 0 && bot.getCharacter().getPlayerState().getCurrentY() == 1 && update.getMessage().getText().equals("Ja") && bot.isHouseGerdaFlag() && !bot.isHouseMillersFlag()) {
            KeyboardInHouse keyboardInHouse = new KeyboardInHouse();
            keyboardInHouse.createKeyboardInHouseGerda(update.getMessage().getChatId());
            sendPicture(bot, update.getMessage().getChatId(), "https://db3pap006files.storage.live.com/y4m5f4JGvy-28L6MSZ5NBPUVodfvreyYAoJ_cUfqZS_ExZyYHnWrzY9N2syM11EE21G1PVdPgCSUlqLmMU6wDEtBTtn1MQAiabo7bXQzxlag8YPGq4RDdNt9amA-jNhLhdhhAJ5zq8SGJIONOJ89K4J-RoNSyavjYpCMkxzMX3zAQFyZcWynqmC1ekbQOUghFvEZE3eFgFNspGXDu2jSNan3HNbyqsuf0N5c8M1atTCre0?encodeFailures=1&width=883&height=883");

            sendText(bot, update.getMessage().getChatId(), "Du findest eine Rüstung");
            bot.getCharacter().getInventory().addItems(item1);
            bot.getCharacter().getInventory().addItems(item2);
            bot.getCharacter().getInventory().addItems(item3);
            bot.getCharacter().getInventory().addItems(item4);
            bot.getCharacter().getInventory().addItems(item5);
            bot.getCharacter().getInventory().addItems(item6);
            bot.getCharacter().getInventory().addItems(item7);
            bot.getCharacter().getInventory().addItems(item8);
            bot.getCharacter().getInventory().addItems(item9);
            bot.getCharacter().getInventory().addItems(item10);
            bot.getCharacter().getAttributes().setStrength(bot.getCharacter().getInventory().combinedAttackStrength());
            bot.getCharacter().getAttributes().setDefense(bot.getCharacter().getInventory().combinedDefensiveStrength());

            bot.setHouseGerdaFlag(false);
        }

        else if (bot.getCharacter().getPlayerState().getCurrentX() == 0 && bot.getCharacter().getPlayerState().getCurrentY() == 1 && update.getMessage().getText().equals("Ja") && bot.isHouseGerdaFlag() && bot.isHouseMillersFlag()) {
            sendText(bot,update.getMessage().getChatId(),"Die Tür ist verschlossen.");
            StandardKeyboard standardKeyboard = new StandardKeyboard();
            standardKeyboard.createKeyboardLeavingHouses(update.getMessage().getChatId());
        }

        else if (bot.getCharacter().getPlayerState().getCurrentX() == 0 && bot.getCharacter().getPlayerState().getCurrentY() == 1 && update.getMessage().getText().equals("Ja") && !bot.isHouseGerdaFlag() && !bot.isHouseMillersFlag()) {
            KeyboardInHouse keyboardInHouse = new KeyboardInHouse();
            keyboardInHouse.createKeyboardInHouseMiller(update.getMessage().getChatId());
            sendText(bot,update.getMessage().getChatId(),"Der Raum ist leer, es herrscht Stille");
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
