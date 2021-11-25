package controller;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class SampleController  {
	
	@FXML
	private Label Status;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private Button submit;

    @FXML
    void Validation(ActionEvent event) throws Exception {
    	Stage title = new Stage();
    	title.setTitle("Project Login");
    	if(username.getText().equals("20MCA1455")&&password.getText().equals("Veer$$123")) {
    		Status.setText("Vasu Loggedin");
    		System.out.println("Vasu Has Loggedin");
    		try {
    	        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/designings/AnimatePage.fxml"));
    	        Parent root1 = (Parent) fxmlLoader.load();
    	        Stage stage = new Stage();
    	        stage.setScene(new Scene(root1));  
    	        stage.show();
    	    } catch(Exception e) {
    	        e.printStackTrace();
    	    }
    	//	Stage stage = (Stage) submit.getScene().getWindow();  // for New stage with close previous one
        // 	 stage.close();                                       // Here need to extra scence ..............
                      
    	}
    	else if (username.getText().equals("20MCA1446")&& password.getText().equals("Password@2000"))
    	{
    		Status.setText("A.S. Loggedin");
       		System.out.println("A.S. Has Loggedin");
    		try {
    	        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/designings/AnimatePage.fxml"));
    	        Parent root1 = (Parent) fxmlLoader.load();
    	        Stage stage = new Stage();
    	        stage.setScene(new Scene(root1));  
    	        stage.show();
    	    } catch(Exception e) {
    	        e.printStackTrace();
    	    }
    	}
    	else if(username.getText().equals("20MCA1465")&& password.getText().equals("Vivek@123")) 
    	{
    		Status.setText("Vivek Loggedin");
    		System.out.println("Vivek Has Loggedin");
    		try {
    	        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/designings/AnimatePage.fxml"));
    	        Parent root1 = (Parent) fxmlLoader.load();
    	        Stage stage = new Stage();
    	        stage.setScene(new Scene(root1));  
    	        stage.show();
    	    } catch(Exception e) {
    	        e.printStackTrace();
    	    }

    	}
    	
    	else 
    	{  
    	   Alert alert = new Alert(AlertType.WARNING);    // Alert Warning Login Page
    	   alert.getDialogPane().setPrefSize(230, 200);
//    	   alert.showAndWait();	   							// wait two dailog box
           Status.setText("Login Failed");
           alert.setTitle("Login Error");
		   alert.setHeaderText("Something Went Wrong Try Again");
           alert.show();              									// Alert Show
           System.out.println("Login Failed");
    	}
    //	 Stage stage = new Stage();
    	
    	 
    			
    }
   
}