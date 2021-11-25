package controller;

import javafx.event.ActionEvent;

/**
 * Sample Skeleton for 'ProjectDiscription.fxml' Controller Class
 */

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AnimatePage {

    @FXML // fx:id="nextbutton"
    private Button nextbutton; // Value injected by FXMLLoader

    @FXML
    void NextPage(ActionEvent event) {

   		try {
	        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/designings/secondxml.fxml"));
	        Parent root1 = (Parent) fxmlLoader.load();
	        Stage stage = new Stage();
	        stage.setTitle("Image Transformation");
	        stage.setScene(new Scene(root1));  
	        stage.show();
	    } catch(Exception e) {
	        e.printStackTrace();
	    }

    	
    }

}
