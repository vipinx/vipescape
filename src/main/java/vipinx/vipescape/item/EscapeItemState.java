package vipinx.vipescape.item;

/**
 * Container class for a state of an item
 * Different states of the same item may have different sprites and names, and must have different state ids
 * EscapeItemState is utilized by EscapeItem and is required in the constructor of EscapeItem.
 * An EscapeItem with only one state will have one EscapeItemState object.
 */
public class EscapeItemState {

    private final String imageUrl;
    private final String name;
    private final int stateId;

    /**
     * Initializes the EscapeItemState object and all variables
     * @param imageUrl the path to the sprite of the EscapeItem
     * @param name the name of the EscapeItem (specific to this EscapeItemState)
     * @param stateId the id of this state
     */
    protected EscapeItemState(String imageUrl, String name, int stateId) {
        this.imageUrl = imageUrl;
        this.name = name;
        this.stateId = stateId;
    }

    /**
     * Getter for sprite image url
     */
    protected String getImageURL() {
        return this.imageUrl;
    }

    /**
     * getter for name of item in this state
     */
    protected String getName() {
        return this.name;
    }

    /**
     * getter for the id of this state
     */
    protected int getStateId() {
        return this.stateId;
    }

}
