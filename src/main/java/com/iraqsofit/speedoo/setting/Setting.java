package com.iraqsofit.speedoo.setting;


import com.iraqsofit.speedoo.PropertiesCache;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

@Component
public class Setting implements Initializable  {
    private static final String MASSAGE ="to save the connection settings,you must close a program and restart the program to update the connection settings";
    @FXML
    private TextField uri_databse;
    @FXML
    private AnchorPane pane;
    @FXML
    private TextField username_database;

    @FXML
    private TextField username_Password;

    @FXML
    private TextField prot_server;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        uri_databse.setText(PropertiesCache.getInstance().getProperty("spring.datasource.url"));
        username_Password.setText(PropertiesCache.getInstance().getProperty("spring.datasource.password"));
        username_database.setText(PropertiesCache.getInstance().getProperty("spring.datasource.username"));
        prot_server.setText(PropertiesCache.getInstance().getProperty("server.port"));
    }

    @FXML
    void Save(MouseEvent event) throws IOException {
       SaveAndClose();
    }

    public  void upadtaProperties(){
        PropertiesCache.getInstance().setProperty("spring.datasource.url",uri_databse.getText());
        PropertiesCache.getInstance().setProperty("spring.datasource.password",username_Password.getText());
        PropertiesCache.getInstance().setProperty("spring.datasource.username",username_database.getText());
        PropertiesCache.getInstance().setProperty("server.port",prot_server.getText());
    }

    public void SaveAndClose(){
        ButtonType yes = new ButtonType("yes", ButtonBar.ButtonData.OK_DONE);
        ButtonType no = new ButtonType("no", ButtonBar.ButtonData.CANCEL_CLOSE);
        Alert alert = new Alert(Alert.AlertType.NONE,MASSAGE, yes,no);
        alert.initStyle(StageStyle.UNDECORATED);
        DialogPane dialogPane = alert.getDialogPane();
       // dialogPane.setPrefHeight(150);
        dialogPane.getStylesheets().add(
                getClass().getResource("/fxml/dialog.css").toExternalForm());
        alert.setTitle("Save and Close");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.orElse(no) == yes) {
            upadtaProperties();
            Stage window = (Stage) pane.getScene().getWindow();
            System.exit(0);
            window.close();
        }
    }




}
