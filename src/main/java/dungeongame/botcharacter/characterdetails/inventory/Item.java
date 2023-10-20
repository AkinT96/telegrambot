package dungeongame.botcharacter.characterdetails.inventory;


public class Item {
    private String name;
    private int attackStrengthOfItem;
    private int defensiveStrengthOfItem;

    public Item(String name, int attackStrengthOfItem, int defensiveStrengthOfItem) {
        this.name = name;
        this.attackStrengthOfItem = attackStrengthOfItem;
        this.defensiveStrengthOfItem = defensiveStrengthOfItem;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAttackStrengthOfItem() {
        return attackStrengthOfItem;
    }

    public int getDefensiveStrengthOfItem() {
        return defensiveStrengthOfItem;
    }


}
