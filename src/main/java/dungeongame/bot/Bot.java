package dungeongame.bot;
import dungeongame.botcharacter.Character;
import dungeongame.mapandbasiccommands.BasicCommandHandler;
import dungeongame.mapandbasiccommands.LookingAroundHandler;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;


public class Bot extends TelegramLongPollingBot {

    private final Character character;

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
        BasicCommandHandler.basicCommands(this, update);   //soundtrack is imported in this method
        LookingAroundHandler.handleLookingAround(this,update);
    }



    public Character getCharacter() {
        return character;
    }
}
