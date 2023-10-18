package dungeongame.bot;

import dungeongame.botcharacter.Character;
import dungeongame.botcharacter.characterdetails.inventory.Item;
import dungeongame.keyboards.Keyboardinfrontofhouse;
import dungeongame.keyboards.StarterKeyboard;
import dungeongame.mapandfindingitems.Map;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendVoice;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot {

    private final Character character;
    Item hut = new Item("Hut", 2, 1);
    Item lederweste = new Item("Lederweste", 5, 3);
    Item eisenhelm = new Item("Eisenhelm", 3, 8);
    Item stiefel = new Item("Stiefel", 1, 2);
    Item robe = new Item("Robe", 2, 5);
    Item handschuhe = new Item("Handschuhe", 1, 1);
    Item schwereRuestung = new Item("Schwere Rüstung", 8, 12);
    Item magierrobe = new Item("Magierrobe", 4, 6);
    Item kettenhemd = new Item("Kettenhemd", 6, 7);
    Item umhang = new Item("Umhang", 2, 3);


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
        lookingAround(update);


    }





    private void lookingAround(Update update) {
        Message message;
        message = update.getMessage();
        Long chatId = message.getChatId();
        Keyboardinfrontofhouse keyboardinfrontofhouse = new Keyboardinfrontofhouse();
        SendMessage sendMessage = new SendMessage();
        if (message.getText().equals("\uD83D\uDC41")) {
            if (character.getPlayerState().getCurrentX() == 0) {
                switch (character.getPlayerState().getCurrentY()) {
                    case 0, 2:
                        sendMessage.setText("Um dich herum ist alles grün und friedlich. Es ist ruhig, vielleicht zu ruhig?");
                        sendMessage.setChatId(chatId);
                        try {
                            execute(sendMessage);
                        } catch (TelegramApiException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 1:
                        keyboardinfrontofhouse.createKeyboardInFrontOfHouse(chatId);
                        break;

                }
            } else if (character.getPlayerState().getCurrentX() == 1) {
                switch (character.getPlayerState().getCurrentY()) {
                    case 0,1:
                        sendMessage.setText("Um dich herum ist alles grün und friedlich. Es ist ruhig, vielleicht zu ruhig?");
                        sendMessage.setChatId(chatId);
                        try {
                            execute(sendMessage);
                        } catch (TelegramApiException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 2:
                        keyboardinfrontofhouse.createKeyboardInFrontOfHouse(chatId);
                        break;
                }

            } else if (character.getPlayerState().getCurrentX() == 2) {
                switch (character.getPlayerState().getCurrentY()) {
                    case 0:
                        keyboardinfrontofhouse.createKeyboardInFrontOfHouse(chatId);
                        break;
                    case 1, 2:
                        sendMessage.setText("Um dich herum ist alles grün und friedlich. Es ist ruhig, vielleicht zu ruhig?");
                        sendMessage.setChatId(chatId);
                        try {
                            execute(sendMessage);
                        } catch (TelegramApiException e) {
                            e.printStackTrace();
                        }
                        break;
                }
            }
        }
    }




    //Basic commands to move around and to print an Intro for the start.(+ sending soundtrack once)
    private void basicCommands(Update update) {
        StarterKeyboard starterKeyboard = new StarterKeyboard();
        Map map = new Map();
        if (update.hasMessage()) {
            Message message = update.getMessage();
            Long chatId = message.getChatId();


            //starting point with Intro and keyboard
            if (message.hasText() && message.getText().equals("/start")) {
                starterKeyboard.createStartKeyboard(chatId);
                soundeffekt(chatId);
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

            if (message.getText().equals("/charakter")){
                SendMessage sendMessage = new SendMessage();
                sendMessage.setChatId(chatId);
                sendMessage.setText(character.getAttributes().toString());
                try {
                    execute(sendMessage);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }






        }
    }


    //Caption and source of the soundtrack
    private void soundeffekt(Long chatId) {
        SendVoice sendVoice = new SendVoice();
        sendVoice.setChatId(chatId);
        sendVoice.setCaption("Spiel mich ab");
        sendVoice.setVoice(new InputFile("https://public.db.files.1drv.com/y4mRWoNdgN8x17sIGeKlg1mTkPEKDv2STGZuOQ2Ut5Kl0RzoNi2LyzrtzcSIPyuAXGUVXQjj6mVVfHdOqnyvKPO_0ElLosRqhanRnoUdccd-1_9ZuMSz3hpR7ZCdYe-Q1TY40es7mH62gZAyhbP-I_TR6IhgAApCYc_qEJWx_pKWhJaeSNwmoY64A5_3jNn9Z03bt36RsmtQbyOkoQT9IweQmzjUdI7mNAQSFLa1HoESOM?AVOverride=1"));
        try {
            execute(sendVoice);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }




}

