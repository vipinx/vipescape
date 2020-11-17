package vipinx.vipescape.trigger;

import javafx.scene.Scene;
import vipinx.vipescape.EscapeMap;
import vipinx.vipescape.VipEscape;
import vipinx.vipescape.item.EscapeItem;
import vipinx.vipescape.trigger.action.EscapeTriggerAction;

import java.util.ArrayList;

/**
 * TODO triggers can trigger animation
 * TODO triggers can play sound
 * TODO triggers can edit inventory
 * TODO triggers can add/remove triggers
 * TODO triggers can change visual of scene
 * TODO triggers can be one-time use with completion remembered (IE 3 keys for box in sagrario's)
 * TODO triggers can require completion of other triggers
 * TODO triggers have ids describing scene and trigger
 */
public class EscapeTrigger {

    private final int triggerId;
    private boolean isEnabled;
    private final EscapeTriggerBounds bounds;
    private final String itemIdRequired;
    private final ArrayList<EscapeTriggerAction> triggerActions;
    private boolean isCompleted = false;
    private final boolean markCompletedOnActivation;

    /**
     *
     * @param triggerId the id of the trigger, used for external access
     * @param enabledByDefault if the trigger is enabled at beginning of escape, determines initial state of trigger
     * @param bounds an EscapeTriggerBounds containing the bounds of the trigger
     * @param itemIdRequired a string "a:b" where a is the item id and b is the item state id (NULL if no item required)
     */
    public EscapeTrigger(int triggerId, boolean enabledByDefault, EscapeTriggerBounds bounds, String itemIdRequired, ArrayList<EscapeTriggerAction> triggerActions, boolean markCompletedOnActivation) {
        this.triggerId = triggerId;
        this.isEnabled = enabledByDefault;
        this.bounds = bounds;
        this.itemIdRequired = itemIdRequired;
        this.triggerActions = triggerActions;
        this.markCompletedOnActivation = markCompletedOnActivation;
    }

    public boolean canTrigger(double mouseX, double mouseY, EscapeItem inHand) {
        // if trigger currently active
        if (!isEnabled) return false;

        // if in bounds
        if (!isInRange(mouseX, bounds.getLeftBound(), bounds.getRightBound()) || !isInRange(mouseY, bounds.getTopBound(), bounds.getBotBound())) return false;

        // if requires item and using correct item
        if (itemIdRequired != null && !inHand.getFullId().equals(itemIdRequired)) return false;

        return true;
    }

    /**
     * Executes the function of the trigger
     */
    public void activate() {
        if (markCompletedOnActivation) {
            isCompleted = true;
        }
        for (EscapeTriggerAction action : triggerActions) {
            action.activate();
        }
        // enable all triggers to enable
        // disable all triggers to disable (INCLUDING ITSELF IF IT SELF DISABLES)
    }

    /**
     * Enables the trigger
     */
    protected void enable() {
        this.isEnabled = true;
    }

    /**
     * Disables the trigger
     */
    protected void disable() {
        this.isEnabled = false;
    }

    /**
     * Returns the id of this trigger
     */
    protected int getTriggerId() {
        return this.triggerId;
    }

    /**
     * Returns true if the trigger is marked as completed (only happens if trigger is set to mark as completed on activation)
     */
    public boolean getIfCompleted() {
        return this.isCompleted;
    }

    /**
     * Returns true if a given double is within a set range
     * @param toTest the double to test
     * @param min the minimum bound to test
     * @param max the maximum bound to test
     */
    private boolean isInRange(double toTest, double min, int max) {
        return (toTest >= min && toTest <= max);
    }

}

