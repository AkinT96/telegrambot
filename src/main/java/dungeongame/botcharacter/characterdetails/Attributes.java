package dungeongame.botcharacter.characterdetails;

public class Attributes {
    private int life;
    private int strength;
    private int defense;

    public Attributes() {
        this.life = 100;
        this.strength = 0;
        this.defense = 0;
    }

    @Override
    public String toString() {
        return "Attribute:\n" +
                "Leben: " + life +
                "\n Stärke: " + strength +
                "\n Defensive: " + defense;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }
}
