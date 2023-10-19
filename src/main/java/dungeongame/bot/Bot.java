package dungeongame.bot;

import dungeongame.Basiccommands.VoiceSender;
import dungeongame.MapsAndHouses.HouseGerda;
import dungeongame.MapsAndHouses.HouseGreyWolves;
import dungeongame.MapsAndHouses.HouseMillers;
import dungeongame.botcharacter.Character;
import dungeongame.Basiccommands.BasicCommandHandler;
import dungeongame.Basiccommands.LookingAroundHandler;
import dungeongame.keyboards.StandardKeyboard;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;


public class Bot extends TelegramLongPollingBot {

    private final Character character;
    private boolean voiceFlag = true;
    private boolean houseMillersFlag = true;
    private boolean houseGerdaFlag = true;
    private boolean wolvesAlive = true;
    private String[] validWords = {"/karte", "/start", "⬅️", "➡️", "⬇️", "⬆️", "Ja", "Nein", "/charakter", "/inventar", "Haus verlassen",};
    private boolean validWordFlag = false;


    public Bot() {
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
        for (String word : validWords) {
            if (word.equals(update.getMessage().getText())) {
                validWordFlag = true;
                break;
            }
        }
        if (validWordFlag) {
            BasicCommandHandler.basicCommands(this, update);   //reaction to Menu commands/moving and output
            LookingAroundHandler.handleLookingAround(this, update); //reaction to looking around button

            //sending soundeffekt once
            if (voiceFlag) VoiceSender.sendVoice(this, VoiceSender.createSoundEffect(update.getMessage().getChatId()));

            //restarting StandardKeyboard after leaving a house
            if (update.getMessage().getText().equals("Haus verlassen") || update.getMessage().getText().equals("Nein")) {
                StandardKeyboard standardKeyboard = new StandardKeyboard();
                standardKeyboard.createKeyboardLeavingHouses(update.getMessage().getChatId());
            }
            HouseMillers.HouseMillerInteraction(this, update);
            HouseGerda.HouseGerdaInteraction(this, update);
            HouseGreyWolves.HouseGreyWolvesInteraction(this, update);
        }
    }

    //Setter and getter Flags
    public void setVoiceFlag(boolean voiceFlag) {
        this.voiceFlag = voiceFlag;
    }

    public void setHouseMillersFlag(boolean houseMillersFlag) {
        this.houseMillersFlag = houseMillersFlag;
    }

    public void setHouseGerdaFlag(boolean houseGerdaFlag) {
        this.houseGerdaFlag = houseGerdaFlag;
    }

    public boolean isHouseMillersFlag() {
        return houseMillersFlag;
    }

    public boolean isHouseGerdaFlag() {
        return houseGerdaFlag;
    }

    public boolean isWolvesAlive() {
        return wolvesAlive;
    }

    public void setWolvesAlive(boolean wolvesAlive) {
        this.wolvesAlive = wolvesAlive;
    }


    //getter Character to use information in other classes
    public Character getCharacter() {
        return character;
    }


}
