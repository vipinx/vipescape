package vipinx.vipescape.trigger;

/**
 * Container class for the bounds of a trigger
 */
public class EscapeTriggerBounds {

    private final int xLeftBound;
    private final int xRightBound;
    private final int yTopBound;
    private final int yBotBound;

    public EscapeTriggerBounds(int xLeftBound, int xRightBound, int yTopBound, int yBotBound) {
        this.xLeftBound = xLeftBound;
        this.xRightBound = xRightBound;
        this.yTopBound = yTopBound;
        this.yBotBound = yBotBound;
    }

    public int getLeftBound() {
        return this.xLeftBound;
    }

    public int getRightBound() {
        return this.xRightBound;
    }

    public int getTopBound() {
        return this.yTopBound;
    }

    public int getBotBound() {
        return this.yBotBound;
    }

}
