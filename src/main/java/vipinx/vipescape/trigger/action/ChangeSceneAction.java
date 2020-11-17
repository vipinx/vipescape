package vipinx.vipescape.trigger.action;

import javafx.scene.Scene;
import javafx.stage.Stage;
import vipinx.vipescape.EscapeMap;
import vipinx.vipescape.VipEscape;

/**
 * Class that handles changing scenes for triggers
 */
public class ChangeSceneAction implements EscapeTriggerAction {

    private final int newSceneId;

    /**
     * Initializes ChangeSceneAction with the scene it will change to
     * @param newSceneId the scene to change to on trigger activation
     */
    public ChangeSceneAction(int newSceneId) {
        this.newSceneId = newSceneId;
    }

    /**
     * Calls the method to execute the trigger
     */
    public void activate() {
        changeScene();
    }


    /**
     * Changes the scene and tells the map the new scene
     */
    private void changeScene() {
        // get map and stage
        EscapeMap currentMap = VipEscape.getCurrentMap();
        Stage stage = VipEscape.getStage();

        // get the current JavaFX Scene
        Scene newScene = currentMap.getScenes().get(newSceneId).getScene();

        // change the current scene and tell the map you changed the scene
        currentMap.updateCurrentSceneId(newSceneId);
        stage.setScene(newScene);
    }

}
