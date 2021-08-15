package functionalities;

import layer_shapes.AnimationBox;
import others.canvasBox;
import others.colorPalette;
import others.layer;
import others.UninitializedFieldException;

public class art
{
    public static void generateArt(layer layer1, layer layer2, colorPalette myColorPalette, String overlay)
    {
        System.out.println("Displaying non-animated art");
        // for debug
        layer1.debugDisplay();
        layer2.debugDisplay();
        myColorPalette.debugDisplay();

        if(layer1.isValid() && layer2.isValid() && myColorPalette.isValid())
        {
            canvasBox myCanvas = new canvasBox(layer1, layer2, myColorPalette);
            myCanvas.initialize();
            myCanvas.display(overlay);
        }
        else
        {
            //System.out.println("Error: some fields are uninitialized");
            try {
                throw new UninitializedFieldException("some fields uninitialized");
            } catch (UninitializedFieldException e) {
                System.out.println(e);
            }
        }
    }

    public static void generateAnimation(layer layer1, layer layer2, colorPalette myColorPalette, String overlay)
    {
        System.out.println("Displaying animated art");
        // for debug
        layer1.debugDisplay();
        layer2.debugDisplay();
        myColorPalette.debugDisplay();

        if(layer1.isValid() && layer2.isValid() && myColorPalette.isValid()) {
            AnimationBox anim = new AnimationBox(layer1, layer2, myColorPalette);
            anim.initialize();
            anim.display(overlay);
        }
        else
        {
            try {
                throw new UninitializedFieldException("some fields uninitialized");
            } catch (UninitializedFieldException e) {
                System.out.println(e);
            }
        }
    }
}
