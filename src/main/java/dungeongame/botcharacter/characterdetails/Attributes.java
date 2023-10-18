package dungeongame.botcharacter.characterdetails;

public class Attributes {
    private int life;
    private int strength;
    private int defense;
    private int level;

    public Attributes(){
        this.life = 100;
        this.strength =0;
        this.defense = 0;
        this.level = 0;
    }

    @Override
    public String toString() {
        return "Attribute:\n" +
                "Leben: " + life +
                "\n Stärke: " + strength +
                "\n Defensive: " + defense +
                "\n Level: " + level;
    }
}
