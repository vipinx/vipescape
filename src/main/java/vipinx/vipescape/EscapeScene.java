package vipinx.vipescape;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import vipinx.vipescape.trigger.EscapeTrigger;

import java.util.ArrayList;

/**
 * EscapeScene
 *
 * Each screen the player can see is represented by an EscapeScene object.
 * EscapeScene contains:
 *  - the image of the background of the scene
 *  - the id of the scene
 *  - a list of EscapeTrigger objects currently active in the scene
 *  - a JavaFX Canvas and GraphicsContext
 *  - a JavaFX Scene and Group
 *
 *  The Canvas contains the currently rendered scene. When a visual change is made, it will be drawn to the Canvas.
 *  If the EscapeScene is unloaded, the canvas is preserved, and is shown again when the EscapeScene is loaded again.
 *
 *  There is a getter method for the Scene object that will be persistent throughout the game, like the Canvas.
 *
 *  TODO create an arraylist that keeps chronological track of all overdraws so they can be redone if the entire frame needs to be redrawn
 */
public class EscapeScene {

    private final String backgroundImageUrl;
    private final int sceneId;
    private ArrayList<EscapeTrigger> triggers;

    private final Canvas sceneCanvas;
    private GraphicsContext gc;

    private Group group;
    private Scene scene;

    /**
     * Initializes the EscapeScene object and necessary variables
     * @param backgroundImageUrl the path to the background image for the scene
     * @param sceneId the id of the scene to be handled by the map
     * @param triggers an ArrayList of all triggers, enabled or disabled, in the scene
     */
    protected EscapeScene(int sceneId, String backgroundImageUrl, ArrayList<EscapeTrigger> triggers) {
        // grab window width and height
        int stageWidth = VipEscape.getStageWidth();
        int stageHeight = VipEscape.getStageHeight();

        // initialize variables
        this.backgroundImageUrl = backgroundImageUrl;
        this.sceneId = sceneId;

        // store triggers
        this.triggers = triggers;

        // initialize canvas and graphicscontext
        sceneCanvas = new Canvas(stageWidth, stageHeight);
        gc = sceneCanvas.getGraphicsContext2D();

        // draw initial layout of the scene
        Image backgroundImage = new Image(backgroundImageUrl, stageWidth, stageHeight, true, true);
        gc.drawImage(backgroundImage, 0, 0);

        // creates scene object for display
        group = new Group(sceneCanvas);
        scene = new Scene(group, stageWidth, stageHeight);
    }

    /**
     * Returns the Scene object for display
     */
    public Scene getScene() {
        return this.scene;
    }

    /**
     * Returns the graphicscontext for when updates need to be drawn to the canvas
     */
    public GraphicsContext getGc() {
        return this.gc;
    }

    /**
     * Returns the list of triggers currently active in the scene
     */
    protected ArrayList<EscapeTrigger> getTriggers() {
        return this.triggers;
    }

}
