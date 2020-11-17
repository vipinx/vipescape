package vipinx.vipescape.item;

import java.util.ArrayList;

public class EscapeItem {

    private String name;
    private int id;
    private int currentState; // By default 1, id of the current state of the object


    EscapeItem(int itemId, String itemName, ArrayList<EscapeItemState> itemStates) {

    }

    public String getName() {
        return name;
    }

    public String getFullId() {
        return id + ":" + currentState;
    }

}
