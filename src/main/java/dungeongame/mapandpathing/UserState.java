package dungeongame.mapandpathing;

public class UserState {
    private int currentX;
    private int currentY;

    public UserState(int initialX, int initialY) {
        this.currentX = initialX;
        this.currentY = initialY;
    }

    public int getCurrentX() {
        return currentX;
    }

    public void setCurrentX(int currentX) {
        this.currentX = currentX;
    }

    public int getCurrentY() {
        return currentY;
    }

    public void setCurrentY(int currentY) {
        this.currentY = currentY;
    }
}
