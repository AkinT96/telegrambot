package dungeongame.bot;

import dungeongame.botcharacter.Character;
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


    //
    private void lookingAround(Update update) {
        Message message;
        message = update.getMessage();
        Long chatId = message.getChatId();
        SendMessage sendMessage = new SendMessage();

        if (message.getText().equals("\uD83D\uDC41")) {
            if (character.getPlayerState().getCurrentX() == 0) {
                switch (character.getPlayerState().getCurrentY()) {
                    case 0:
                        sendMessage.setText("Um dich herum ist gähnende leere!");
                        sendMessage.setChatId(chatId);
                        try {
                            execute(sendMessage);
                        } catch (TelegramApiException e) {
                            e.printStackTrace();
                        }
                    case 1:

                    case 2:

                }
            } else if (character.getPlayerState().getCurrentX() == 1) {
                switch (character.getPlayerState().getCurrentY()) {
                    case 0:

                        break;
                    case 1:

                        break;
                    case 2:

                        break;
                }

            } else if (character.getPlayerState().getCurrentX() == 2) {
                switch (character.getPlayerState().getCurrentY()) {
                    case 0:

                    case 1:

                    case 2:

                }
            }
        }
    }




    //Basic commands to move around and to print a Intro for the start.(+ sending soundtrack once)
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






        }
    }


    //Caption and source of the soundtrack
    private void soundeffekt(Long chatId) {
        SendVoice sendVoice = new SendVoice();
        sendVoice.setChatId(chatId);
        sendVoice.setCaption("Spiel mich ab");
        sendVoice.setVoice(new InputFile("https://public.db.files.1drv.com/y4mkpM8VmB8guJkN30h7QX0YWDVsLlvrYHE8ktwns4ENnHhu65pF4i1CJWbjDJ6iC-JlPXOFwXb0cwJUJdm_TLqSqmow2EKX1fUkXDEoVCeFE1FZ6zFJICInVYUpqGbIblrxZuKA3timJH6q2hJ8OLYXWYrT6JaG8vbWO5Lq71i64xaXA-BIULfvQwCwymUR12zV0wsp9VTc6DBJbOzd_JLHKbAAnMEwA8tU-Wg8fE3Yh8?AVOverride=1"));
        try {
            execute(sendVoice);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }




}

