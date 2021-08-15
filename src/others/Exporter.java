package others;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.*;

public class Exporter
{
    /*public static void getWindow() throws WindowCaptureException
    {
        // Find explorer window by the title
        WindowManager windowManager = WindowManager.getInstance();
        com.teamdev.jxdesktop.ui.Window explorerWindow = (com.teamdev.jxdesktop.ui.Window) windowManager.findWindow("Canvas Window - testing");
        if (explorerWindow == null) {
            System.out.println("Could not find a required window to capture image");
            throw new WindowCaptureException("Could not find a required window to capture image");
        }

        // Capturing the specific window
        ImageCapture imageCapture = ImageCapture.create(new WindowSource(explorerWindow));
        imageCapture.setCaptureArea(new Rectangle(50, 50, 800, 600));
        try {
            imageCapture.
                    takeSnapshot()
                    .resize(new Dimension(640, 480))
                    .save(new File(getFileName()), ImageFormat.PNG);
        } catch (IOException e) {
            throw new WindowCaptureException("Failed");
        }

        imageCapture.release();
    }*/

    public static void getWindow() throws WindowCaptureException
    {
        try {
            Robot robot = new Robot();
            String format = "jpg";
            String fileName = getFileName();

            //Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            Rectangle captureRect = new Rectangle(0, 30, 800, 600);
            BufferedImage screenFullImage = robot.createScreenCapture(captureRect);
            ImageIO.write(screenFullImage, format, new File(fileName));
        } catch (AWTException | IOException ex) {
            System.err.println(ex);
            throw new WindowCaptureException("Failed");
        }
    }

    public static String getFileName()
    {
        String ret;
        ret = "image-0.jpg";

        File f = new File("C:\\Users\\Kirtheen kumar\\Documents\\Study material\\SEM 4\\OOPS - Java\\partB\\test_HelloFX_v6");
        ArrayList<String> names = new ArrayList<String>(Arrays.asList(f.list()));
        System.out.println("Files found: " + names);

        Pattern pat = Pattern.compile("image-[0-9]{1}.jpg");
        Matcher mat;

        for (String name: names)
        {
            mat = pat.matcher(name);
            // Find the last file that matches
            if(mat.matches())
            {
                //System.out.println("Matched: "+name);
                int count;
                if(name.length()==11) {
                    count = Integer.parseInt(name.substring(6, 7));
                    //System.out.println("Count: "+count);
                    ret = "image-" + (count + 1) + ".jpg";
                }
                else {
                    count = Integer.parseInt(name.substring(6, 8));
                    //System.out.println("Count: "+count);
                    ret = "image-" + (count + 1) + ".jpg";
                }
            }
        }
        System.out.println("Saved as " + ret);
        return ret;
    }
}