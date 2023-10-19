package dungeongame.bot;
import dungeongame.Basiccommands.VoiceSender;
import dungeongame.MapsAndHouses.HouseMillers;
import dungeongame.botcharacter.Character;
import dungeongame.Basiccommands.BasicCommandHandler;
import dungeongame.Basiccommands.LookingAroundHandler;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;


public class Bot extends TelegramLongPollingBot {

    private final Character character;
    private boolean voiceFlag = true;
    private boolean houseMillersFlag = true;
    private boolean houseGerdaFlag = true;

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

        BasicCommandHandler.basicCommands(this, update);   //reaction to Menu commands/moving and output
        LookingAroundHandler.handleLookingAround(this,update); //reaction to
        if (voiceFlag) VoiceSender.sendVoice(this, VoiceSender.createSoundEffect(update.getMessage().getChatId()));
        HouseMillers.HouseMillerInteraction(this,update);
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


    //getter Character to use information in other classes
    public Character getCharacter() {
        return character;
    }


}
