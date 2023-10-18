package dungeongame.inventory;


public class Item  {
    private String name;
    private int attackStrengthOfItem;
    private int defensiveStrengthOfItem;
    public Item(String name, int attackStrengthOfItem, int defensiveStrengthOfItem){
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

    public void setAttackStrengthOfItem(int attackStrengthOfItem) {
        this.attackStrengthOfItem = attackStrengthOfItem;
    }

    public int getDefensiveStrengthOfItem() {
        return defensiveStrengthOfItem;
    }

    public void setDefensiveStrengthOfItem(int defensiveStrengthOfItem) {
        this.defensiveStrengthOfItem = defensiveStrengthOfItem;
    }
}
