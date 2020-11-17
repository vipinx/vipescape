package vipinx.vipescape;

import javafx.application.Application;
import javafx.stage.Stage;
import vipinx.vipescape.trigger.EscapeTrigger;
import vipinx.vipescape.trigger.EscapeTriggerBounds;
import vipinx.vipescape.trigger.action.ChangeSceneAction;
import vipinx.vipescape.trigger.action.EscapeTriggerAction;

import java.util.ArrayList;

// TODO randomized solutions
// TODO scene registering system, trigger registering system, item registering system, itemstate registering system (to ensure proper control of ids)
public class VipEscape extends Application {

    private static EscapeMap currentMap = null;
    private static Stage stage = null;
    private static final int stageWidth = 800;
    private static final int stageHeight = 600;

    public static void main(String[] args) {
        Application.launch(args);
    }

    public void start(Stage stage) {
        // ties stage to global variable so it can be accessed by the map
        VipEscape.stage = stage;



        // begin map creation

        // create scene 0 triggers
        ArrayList<EscapeTrigger> scene0Triggers = new ArrayList<>();

        // scene 0 trigger 0
        EscapeTriggerBounds scene0Trigger0Bounds = new EscapeTriggerBounds(0, 100, 0, 600);
        ArrayList<EscapeTriggerAction> scene0Trigger0TriggerActions = new ArrayList<>();
        EscapeTriggerAction scene0Trigger0ChangeScene = new ChangeSceneAction(1);
        scene0Trigger0TriggerActions.add(scene0Trigger0ChangeScene);
        EscapeTrigger scene0Trigger0 = new EscapeTrigger(0, true, scene0Trigger0Bounds, null, scene0Trigger0TriggerActions, false);
        scene0Triggers.add(scene0Trigger0);

        // create scene 0
        EscapeScene scene0 = new EscapeScene(0, "images/backgrounds/0.png", scene0Triggers);


        // create scene 1 triggers
        ArrayList<EscapeTrigger> scene1Triggers = new ArrayList<>();

        // scene 1 trigger 0
        EscapeTriggerBounds scene1Trigger0Bounds = new EscapeTriggerBounds(700, 800, 0, 600);
        EscapeTriggerAction scene1Trigger0ChangeScene = new ChangeSceneAction(0);
        ArrayList<EscapeTriggerAction> scene1Trigger0TriggerActions = new ArrayList<>();
        scene1Trigger0TriggerActions.add(scene1Trigger0ChangeScene);
        EscapeTrigger scene1Trigger0 = new EscapeTrigger(1, true, scene1Trigger0Bounds, null, scene1Trigger0TriggerActions, false);
        scene1Triggers.add(scene1Trigger0);

        // create scene 1
        EscapeScene scene1 = new EscapeScene(1, "images/backgrounds/1.png", scene1Triggers);


        // group scenes together
        ArrayList<EscapeScene> escapeMapScenes = new ArrayList<>();
        escapeMapScenes.add(scene0);
        escapeMapScenes.add(scene1);

        // finish map creation
        currentMap = new EscapeMap("testMap", escapeMapScenes, 0);



        stage.setTitle(VipEscape.getCurrentMap().getName());
        stage.setResizable(false);
        stage.setScene(currentMap.getCurrentScene().getScene());
        stage.sizeToScene(); // fixes stage size bug with stage.setResizable
        stage.show();
    }

    /**
     * Used for external access of the EscapeMap
     * @return the EscapeMap object currently being played
     */
    public static EscapeMap getCurrentMap() {
        return currentMap;
    }

    /**
     * Used for external access of the Stage
     * @return the JavaFX Stage of the program
     */
    public static Stage getStage() {
        return stage;
    }

    /**
     * Used to get the set window width
     * @return the width of the JavaFX Stage
     */
    public static int getStageWidth() {
        return stageWidth;
    }

    /**
     * Used to get the set window width
     * @return the width of the JavaFX Stage
     */
    public static int getStageHeight() {
        return stageHeight;
    }

}
