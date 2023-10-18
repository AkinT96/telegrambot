package dungeongame.characterandfights;

import dungeongame.bot.Bot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Character extends Bot {
    private int xp;
    private int lifePoints;
    private int level;
    private int strength;
    private int agility;

    private int armor;

    public Character() {
        this.xp = 0;
        this.lifePoints = 100;
        this.level = 0;
        this.strength = 0;
        this.agility = 0;
        this.armor = 0;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getLifePoints() {
        return lifePoints;
    }

    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    @Override
    public String toString() {
        return "Your Character Attributes:\n" +
                "Experience=" + xp +
                "\nLifePoints=" + lifePoints +
                "\nLevel=" + level +
                "\nStrength=" + strength +
                "\nAgility=" + agility +
                "\nArmor=" + armor;
    }

    public void showCharacterAttributes(long chatId) {
        SendMessage characterInformation = new SendMessage();
        characterInformation.setChatId(chatId);
        characterInformation.setText(toString());
        try {
            execute(characterInformation);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}

