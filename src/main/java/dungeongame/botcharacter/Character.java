package dungeongame.botcharacter;

import dungeongame.botcharacter.characterdetails.Attributes;
import dungeongame.botcharacter.characterdetails.Inventory;
import dungeongame.botcharacter.characterdetails.Playerposition;

public class Character {

    private Playerposition playerposition;
    private Inventory inventory;
    private Attributes attributes;

    public Character() {
        this.playerposition = new Playerposition(0, 0);
        this.inventory = new Inventory();
        this.attributes = new Attributes();
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

    public Attributes getAttributes() {
        return attributes;
    }

    public void setPlayerposition(Playerposition playerposition) {
        this.playerposition = playerposition;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }
}

