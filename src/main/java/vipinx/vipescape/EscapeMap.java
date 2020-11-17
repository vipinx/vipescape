package vipinx.vipescape;

import vipinx.vipescape.trigger.EscapeTrigger;

import java.util.ArrayList;

/**
 * TODO method to print all scenes, triggers, items, item states with respective ids, names, pictures, etc
 */
public class EscapeMap {

    private final String name;
    private final ArrayList<EscapeScene> scenes;
    private int currentSceneId;

    /**
     * Initializes the EscapeMap object by:
     *  - storing name and escape scenes
     *  - defining the scene the map starts on
     *  - setting up click handlers for each JavaFX Scene
     * @param name the title or name of the escape map
     * @param scenes an ArrayList containing an EscapeScene object for each scene in game (SCENE ID MUST EQUAL INDEX IN ARRAYLIST)
     * @param initialSceneId the scene id of the scene the map starts on
     */
    protected EscapeMap(String name, ArrayList<EscapeScene> scenes, int initialSceneId) {
        // store variables
        this.name = name;
        this.scenes = scenes;
        this.currentSceneId = initialSceneId;

        // set up click handler
        for (EscapeScene es : scenes) {
            es.getScene().setOnMouseClicked((e) -> {
                // get location of click
                double mouseX = e.getSceneX();
                double mouseY = e.getSceneY();

                // find a trigger under click
                ArrayList<EscapeTrigger> triggers = VipEscape.getCurrentMap().getCurrentScene().getTriggers();
                for (EscapeTrigger t : triggers) {
                    // if click is on trigger and trigger requirements are met
                    if (t.canTrigger(mouseX, mouseY, null))
                        t.activate();
                }
            });
        }
    }

    /**
     * Returns the title or name of the escape map
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns an ArrayList containing all EscapeScene objects in the map
     */
    public ArrayList<EscapeScene> getScenes() {
        return this.scenes;
    }

    /**
     * Returns the currently displayed EscapeScene
     */
    public EscapeScene getCurrentScene() {
        return this.scenes.get(currentSceneId);
    }

    /**
     * Notifies the EscapeMap object that the scene has changed
     * @param newCurrentSceneId the scene id that is the new scene
     */
    public void updateCurrentSceneId(int newCurrentSceneId) {
        this.currentSceneId = newCurrentSceneId;
    }


    protected boolean getIfTriggerCompleted(int triggerSceneId, int triggerId) {
        return scenes.get(triggerSceneId).getTriggers().get(triggerId).getIfCompleted();
    }

}
