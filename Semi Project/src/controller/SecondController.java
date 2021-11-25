package controller;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;

import javax.imageio.ImageIO;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class SecondController {
	@FXML private ImageView imageView;

	@FXML
    private Label label;
	
    @FXML
    private MenuItem open;
	
	@FXML
    private MenuItem quitmenu;
   
    @FXML
    private MenuItem Projecttesigner;

    @FXML
    private MenuItem Projecttester;

    @FXML
    private MenuItem debugger;
    

    @FXML
    private MenuItem viewcode;
    
    @FXML
    private MenuItem sepiatone;

    @FXML
    private MenuItem grayscale;
    

    @FXML
    private MenuItem blurred;
    
    @FXML
    private MenuItem cropimage;
    
    @FXML
    private MenuItem negativepositive;
    
    @FXML
    private MenuItem Rotateimage;
   

    @FXML
    void ExitMenus(ActionEvent event) {
         System.out.println("You Selected Exit");
         System.exit(0);
    }

    @FXML
    void CoderProfile(ActionEvent event) throws IOException, URISyntaxException {
//    	
//    	   engine= web.getEngine();
//         engine.loadContent("https://www.sololearn.com/profile/16889292");
           Desktop d = Desktop.getDesktop();  
           d.browse(new URI("https://www.sololearn.com/profile/16889292"));
           System.out.println("Developer Profile Opened");
    }
    
  
    @FXML
    void ProjectDesigner(ActionEvent event) throws IOException, URISyntaxException {
    	   Desktop d = Desktop.getDesktop();  
           d.browse(new URI("https://www.sololearn.com/profile/16889292"));
           System.out.println("ProjectDesigner Profile Opened");
    }

    @FXML
    void ProjectTester(ActionEvent event) throws IOException, URISyntaxException {
    	   Desktop d = Desktop.getDesktop();  
           d.browse(new URI("https://www.sololearn.com/profile/21502303"));
           System.out.println("ProjectTester Profile Opened");
    }
    

    @FXML
    void ViewCode(ActionEvent event) {
            // Code file ..........................
    	
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(new Stage());

        try {
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()){
            	// scanner.nextLine() + "\n" pass as a argument
             
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
    

    @FXML
    void OpenFile(ActionEvent event) {
          FileChooser fileChooser = new FileChooser();
          File file = fileChooser.showOpenDialog(new Stage());

          try {
              Scanner scanner = new Scanner(file);
              while(scanner.hasNextLine()){
              	// scanner.nextLine() + "\n" pass as a argument
               
              }
          } catch (FileNotFoundException e) {
              e.printStackTrace();
          }

      }
    
    @FXML
    void SepiaTone(ActionEvent event) throws IOException {
        Transform t =new Transform();
   	    t.Transform1();
        System.out.println("Sepia Tone Image !");
    }



	@FXML
    void Grayscale(ActionEvent event) {
       Transform t =new Transform();
	   t.Transform2();
	   System.out.println("Grayscale Image!");
    }
	

    @FXML
    void BlurredImage(ActionEvent event) throws IOException, InterruptedException {
    	Transform t =new Transform();
    	t.Transform3();
    	System.out.println("Blurred Image !");
    }
    

    @FXML
    void CropImage(ActionEvent event) {
    	Transform t =new Transform();
    	t.Transform4();
    }
    
    @FXML
    void NegativePositive(ActionEvent event) throws IOException {
    	Transform t =new Transform();
    	t.Transform5();                   //..... Unhandled  exception remaind....//
    }
     

    @FXML
    void RotateImage(ActionEvent event) {
    	 
    	try {

              BufferedImage originalImage = ImageIO.read(new File("C:\\Users\\hp\\Desktop\\Lynar Moon\\Beautiful.JPG"));

              BufferedImage subImage = rotateImage(originalImage);

              File rotatedImageFile = new File("C:\\Users\\hp\\Desktop\\Beautiful.JPG");

              ImageIO.write(subImage, "jpg", rotatedImageFile);

              System.out.println("New Rotated Image File Path: "+rotatedImageFile.getPath());

          } catch (IOException e) {
              e.printStackTrace();
          }
      }
     public static BufferedImage rotateImage(BufferedImage imageToRotate) {
        int widthOfImage = imageToRotate.getWidth();
        int heightOfImage = imageToRotate.getHeight();
        int typeOfImage = imageToRotate.getType();

        BufferedImage newImageFromBuffer = new BufferedImage(widthOfImage, heightOfImage, typeOfImage);

        Graphics2D graphics2D = newImageFromBuffer.createGraphics();

        graphics2D.rotate(Math.toRadians(90), widthOfImage / 2, heightOfImage / 2);
        graphics2D.drawImage(imageToRotate, null, 0, 0);

        return newImageFromBuffer;
    }
    
     
	
}
