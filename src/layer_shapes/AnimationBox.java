package layer_shapes;

import functionalities.drawable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import others.colorPalette;
import others.layer;
import others.Animator;

import java.util.ArrayList;

public class AnimationBox
{
    private layer layer1, layer2;
    private colorPalette myColorPalette;
    private Stage stage;

    public AnimationBox(layer layer1, layer layer2, colorPalette myColorPalette)
    {
        this.layer1 = layer1;
        this.layer2 = layer2;
        this.myColorPalette = myColorPalette;
    }

    public void initialize()
    {
        stage = new Stage();
        stage.setTitle("Canvas Window - testing");

        // stops user interaction with other windows,
        // i.e. this window needs to be closed when new art needs to be generated
        stage.initModality(Modality.APPLICATION_MODAL);
    }

    public void display(String overlay)
    {
        Group layout = new Group();

        Animator anim = new Animator(layout, layer1, layer2);
        anim.run();

        ArrayList<Color> al = new ArrayList<Color>();

        //fillColors(al, 3);
        al.add(drawable.myColors[(int) (Math.random() * drawable.myColors.length)]);
        al.add(drawable.myColors[(int) (Math.random() * drawable.myColors.length)]);
        al.add(drawable.myColors[(int) (Math.random() * drawable.myColors.length)]);

        Stop[] stops = new Stop[] { new Stop(0, al.get(0)),
                new Stop(0.5, al.get(1)),
                new Stop(1, al.get(2))};
        LinearGradient lg2 = new LinearGradient(0, 0, 0.5, 0.5, true, CycleMethod.REFLECT, stops);


        if(overlay.equals("Left Diagonal")) {
            Rectangle overlay_rect = new Rectangle();

            Stop[] stops1 = new Stop[]{new Stop(0, Color.BLACK),
                    new Stop(1, Color.TRANSPARENT)};
            LinearGradient lg3 = new LinearGradient(0, 1, 0.5, 0.5, true, CycleMethod.REFLECT, stops1);
            overlay_rect.setFill(lg3);
            overlay_rect.setX(0);
            overlay_rect.setY(0);
            overlay_rect.setWidth(800.0);
            overlay_rect.setHeight(600);
            layout.getChildren().add(overlay_rect);
        }
        else if(overlay.equals("Right Diagonal")) {
            Rectangle overlay_rect = new Rectangle();

            Stop[] stops1 = new Stop[]{new Stop(0, Color.BLACK),
                    new Stop(1, Color.TRANSPARENT)};
            LinearGradient lg3 = new LinearGradient(0, 0, 0.5, 0.5, true, CycleMethod.REFLECT, stops1);
            overlay_rect.setFill(lg3);
            overlay_rect.setX(0);
            overlay_rect.setY(0);
            overlay_rect.setWidth(800.0);
            overlay_rect.setHeight(600);
            layout.getChildren().add(overlay_rect);
        }
        else if(overlay.equals("Both")){

            Rectangle overlay_rect1 = new Rectangle();
            Rectangle overlay_rect2 = new Rectangle();

            Stop[] stops1 = new Stop[]{new Stop(0, Color.BLACK),
                    new Stop(0.5, Color.TRANSPARENT)};
            LinearGradient lg3 = new LinearGradient(0, 0, 0.5, 0.5, true, CycleMethod.REFLECT, stops1);
            LinearGradient lg4 = new LinearGradient(0, 1, 0.5, 0.5, true, CycleMethod.REFLECT, stops1);
            overlay_rect1.setFill(lg3);
            overlay_rect1.setX(0);
            overlay_rect1.setY(0);
            overlay_rect1.setWidth(800.0);
            overlay_rect1.setHeight(600);
            overlay_rect2.setFill(lg4);
            overlay_rect2.setX(0);
            overlay_rect2.setY(0);
            overlay_rect2.setWidth(800.0);
            overlay_rect2.setHeight(600);
            layout.getChildren().add(overlay_rect1);
            layout.getChildren().add(overlay_rect2);
        }

        Scene scene = new Scene(layout, 800, 600, lg2);

        stage.setScene(scene);

        stage.showAndWait();
    }

    public void close()
    {
        stage.close();
    }
}
