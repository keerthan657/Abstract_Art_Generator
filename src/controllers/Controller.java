package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;

import others.Exporter;
import others.WindowCaptureException;
import others.colorPalette;
import others.layer;
import functionalities.art;

public class Controller
{
    private layer layer1, layer2;
    private colorPalette myColorPalette;

    // references to various buttons, slider, and other nodes
    public Button generateButton, generateRandomlyButton, exportButton;
    public ComboBox<String> cPalette1, cPalette2, cPalette3, cPalette4;
    public ComboBox<String> overlayOptions;
    public ComboBox<String> l1shape, l1style, l2shape, l2style;
    public Slider l1Cslider, l1Sslider, l2Cslider, l2Sslider;
    public CheckBox animatorButton;

    // button functionalities
    public void OnGenerateButtonClicked()
    {
        System.out.println("\nButton clicked: Generate");

        setupClasses();

        if(animatorButton.isSelected()) {
            art.generateAnimation(layer1, layer2, myColorPalette, overlayOptions.getValue());
        }
        else {
            art.generateArt(layer1, layer2, myColorPalette, overlayOptions.getValue());
        }
    }
    public void OnGenerateRandomlyButtonClicked()
    {
        System.out.println("\nButton clicked: Generate Randomly");

        //generating random values for all variables
        String[] colors = new String[]{"Red", "Blue", "Green", "Black", "Cyan", "Orange", "Pink", "Yellow", "Purple"};
        cPalette1.setValue(colors[(int)(Math.random()* colors.length)]);
        cPalette2.setValue(colors[(int)(Math.random()* colors.length)]);
        cPalette3.setValue(colors[(int)(Math.random()* colors.length)]);
        cPalette4.setValue(colors[(int)(Math.random()* colors.length)]);
        String[] myStyles = new String[]{"Chaotic", "Horizontal", "Vertical", "Cornered"};
        l1style.setValue(myStyles[(int)(Math.random()* myStyles.length)]);
        l2style.setValue(myStyles[(int)(Math.random()* myStyles.length)]);
        String[] myShapes = new String[]{"Square", "Rectangle", "Circle", "Lines", "Polygons", "Dots", "Ring"};
        l1shape.setValue(myShapes[(int)(Math.random()* myShapes.length)]);
        l2shape.setValue(myShapes[(int)(Math.random()* myShapes.length)]);
        String[] myOverlays = new String[]{"None", "Left Diagonal", "Right Diagonal", "Both"};
        overlayOptions.setValue(myOverlays[(int)(Math.random() * myOverlays.length)]);
        l1Sslider.setValue((int)(Math.random() * 100));
        l2Sslider.setValue((int)(Math.random() * 100));
        l1Cslider.setValue((int)(Math.random() * 100));
        l2Cslider.setValue((int)(Math.random() * 100));

        setupClasses();

        art.generateArt(layer1, layer2, myColorPalette, overlayOptions.getValue());
    }
    public void OnExportButtonClicked()
    {
        System.out.println("\nButton clicked: Export");
        try {
            Exporter.getWindow();
        }
        catch (WindowCaptureException e) {
            System.out.println(e);
        }
        catch (Exception f) {
            System.out.println(f);
        }
    }

    @FXML
    public void initialize() {

        // ComboBox initializations
        cPalette1.getItems().addAll("Red", "Blue", "Green", "Black", "Cyan", "Orange", "Pink", "Yellow", "Purple");
        cPalette2.getItems().addAll("Red", "Blue", "Green", "Black", "Cyan", "Orange", "Pink", "Yellow", "Purple");
        cPalette3.getItems().addAll("Red", "Blue", "Green", "Black", "Cyan", "Orange", "Pink", "Yellow", "Purple");
        cPalette4.getItems().addAll("Red", "Blue", "Green", "Black", "Cyan", "Orange", "Pink", "Yellow", "Purple");

        overlayOptions.getItems().addAll("None", "Left Diagonal", "Right Diagonal", "Both");

        l1style.getItems().addAll("Chaotic", "Horizontal", "Vertical", "Cornered");
        l2style.getItems().addAll("Chaotic", "Horizontal", "Vertical", "Cornered");
        l1shape.getItems().addAll("Square", "Rectangle", "Circle", "Lines", "Polygons", "Dots", "Ring");
        l2shape.getItems().addAll("Square", "Rectangle", "Circle", "Lines", "Polygons", "Dots", "Ring");


        // slider functionalities - for debug
        l1Cslider.valueProperty().addListener(e -> {
            //System.out.println("L1 complexity Slider = " + (int)l1Cslider.getValue());
        });
        l1Sslider.valueProperty().addListener(e -> {
            //System.out.println("L1 style Slider = " + (int)l1Sslider.getValue());
        });
        l2Cslider.valueProperty().addListener(e -> {
            //System.out.println("L2 complexity Slider = " + (int)l2Cslider.getValue());
        });
        l2Sslider.valueProperty().addListener(e -> {
            //System.out.println("L2 style Slider = " + (int)l2Sslider.getValue());
        });

        animatorButton.setOnAction(e -> {
            if(animatorButton.isSelected())
            {
                l1style.setDisable(true);
                l2style.setDisable(true);
            }
            else
            {
                l1style.setDisable(false);
                l2style.setDisable(false);
            }
        });

        l1shape.setOnAction(e -> {
            if(animatorButton.isSelected())
            {
                l1style.setDisable(true);
                if(l1shape.getValue().equals("Lines"))
                {
                    l1Sslider.setDisable(true);
                }
                else
                {
                    l1Sslider.setDisable(false);
                }
            }
            else {
                if (l1shape.getValue().equals("Polygons")) {
                    l1style.setValue("Chaotic");
                    l1style.setDisable(true);
                    l1Sslider.setDisable(false);
                } else if (l1shape.getValue().equals("Lines")) {
                    l1Sslider.setDisable(true);
                    l1style.setDisable(false);
                } else {
                    enable1All();
                }
            }
        });
        l2shape.setOnAction(e -> {
            if(animatorButton.isSelected())
            {
                l2style.setDisable(true);
                if(l2shape.getValue().equals("Lines"))
                {
                    l2Sslider.setDisable(true);
                }
                else
                {
                    l2Sslider.setDisable(false);
                }
            }
            else {
                if (l2shape.getValue().equals("Polygons")) {
                    l2style.setValue("Chaotic");
                    l2style.setDisable(true);
                    l2Sslider.setDisable(false);
                } else if (l2shape.getValue().equals("Lines")) {
                    l2Sslider.setDisable(true);
                    l2style.setDisable(false);
                } else {
                    enable2All();
                }
            }
        });
    }

    private void setupClasses()
    {
        layer1 = new layer(l1style.getValue(), l1shape.getValue(), l1Cslider.getValue(), l1Sslider.getValue());
        layer2 = new layer(l2style.getValue(), l2shape.getValue(), l2Cslider.getValue(), l2Sslider.getValue());

        myColorPalette = new colorPalette(cPalette1.getValue(), cPalette2.getValue(), cPalette3.getValue(), cPalette4.getValue());
    }

    private void enable1All()
    {
        l1style.setDisable(false);
        l1shape.setDisable(false);
        l1Cslider.setDisable(false);
        l1Sslider.setDisable(false);
    }
    private void enable2All()
    {
        l2style.setDisable(false);
        l2shape.setDisable(false);
        l2Cslider.setDisable(false);
        l2Sslider.setDisable(false);
    }
}
