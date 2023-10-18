package dungeongame.botcharacter.characterdetails;

public class Playerposition {
    private int currentX;
    private int currentY;

    public Playerposition(int initialX, int initialY) {
        this.currentX = initialX;
        this.currentY = initialY;
    }

    public int getCurrentX() {
        return currentX;
    }

    public int getCurrentY() {
        return currentY;
    }

    public void setCurrentXUp() {
        if (currentX >= 0 && currentX < 2) {
            currentX++;
        }
    }

    public void setCurrentYUp() {
        if (currentY >= 0 && currentY < 2) {
            currentY++;
        }
    }

    public void setCurrentXDown() {
        if (currentX > 0 && currentX <= 2) {
            currentX--;
        }
    }

    public void setCurrentYDown() {
        if (currentY > 0 && currentY <= 2) {
            currentY--;
        }
    }
}
