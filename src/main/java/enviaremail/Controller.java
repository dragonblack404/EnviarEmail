package enviaremail;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Controller implements Initializable {
	
	// model 
	
	Model model = new Model();

	// view
	
	@FXML
    private VBox buttonBox;

    @FXML
    private Button cleanButton;

    @FXML
    private Button closeButton;

    @FXML
    private CheckBox conecBox;

    @FXML
    private Label conecLabel;

    @FXML
    private HBox fromBox;

    @FXML
    private Label fromLabel;

    @FXML
    private TextField fromText;

    @FXML
    private TextArea messageArea;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField portText;

    @FXML
    private GridPane root;

    @FXML
    private Button sendButton;

    @FXML
    private HBox serverBox;

    @FXML
    private Label serverLabel;

    @FXML
    private TextField serverText;

    @FXML
    private Label subjectLabel;

    @FXML
    private TextField subjectText;

    @FXML
    private Label toLabel;

    @FXML
    private TextField toText;
    
    public Controller() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/View.fxml"));
		loader.setController(this);
		loader.load();
	}
    
    @Override
	public void initialize(URL location, ResourceBundle resources) {
    	
		try {
			model.serverProperty().bindBidirectional(serverText.textProperty());
	    	model.portProperty().bindBidirectional(portText.textProperty());
	    	model.useSSLProperty().bindBidirectional(conecBox.selectedProperty());
	    	model.fromProperty().bindBidirectional(fromText.textProperty());
	    	model.passwordProperty().bindBidirectional(passwordField.textProperty());
	    	model.toProperty().bindBidirectional(toText.textProperty());
	    	model.subjectProperty().bindBidirectional(subjectText.textProperty());
	    	model.messageProperty().bindBidirectional(messageArea.textProperty());
		} catch (Exception e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("No se puedo enviar el email");
			alert.setContentText(e.getMessage());
			alert.showAndWait();
			e.printStackTrace();
		}
	}
    
    public GridPane getView() {
    	return root;
    }

    @FXML
    void onCleanAction(ActionEvent event) {
    	model.setServer(null);
    	model.setPort(null);
    	model.setUseSSL(false);
    	model.setFrom(null);
    	model.setPassword(null);
    	model.setTo(null);
		model.setSubject(null);
		model.setMessage(null);
    }

    @FXML
    void onCloseAction(ActionEvent event) {
    	App.primaryStage.close();
    }

    @FXML
    void onSendAction(ActionEvent event) {
    	Email email = new SimpleEmail();
    	try {
    		email.setHostName(model.getServer());
	    	email.setSmtpPort(Integer.parseInt(model.getPort()));
    		email.setAuthenticator(new DefaultAuthenticator(model.getFrom(), model.getPassword()));
    		email.setSSLOnConnect(model.useSSL());
			email.setFrom(model.getFrom());
			email.setSubject(model.getSubject());
			email.setMsg(model.getMessage());
			email.addTo(model.getTo());
			email.send();
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Mensaje enviado");
			alert.setHeaderText("Mensaje enviado con éxito " + model.getTo());
			alert.showAndWait();
			model.setTo(null);
			model.setSubject(null);
			model.setMessage(null);
			
		} catch (Exception e) {
		
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("No se puedo enviar el email");
			alert.setContentText(e.getLocalizedMessage());
			alert.showAndWait();
			e.printStackTrace();
		}
    	    	
    }

}