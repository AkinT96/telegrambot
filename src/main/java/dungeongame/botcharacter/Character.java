package dungeongame.botcharacter;

import dungeongame.botcharacter.characterdetails.Inventory;
import dungeongame.botcharacter.characterdetails.Playerposition;

public class Character {

    private Playerposition playerposition;
    private  Inventory inventory;
    public Character() {
        this.playerposition = new Playerposition(0,0);
        Inventory inventory = new Inventory();
    }

    public Playerposition getPlayerState() {
        return playerposition;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

}

