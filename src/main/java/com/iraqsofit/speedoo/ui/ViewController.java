package com.iraqsofit.speedoo.ui;

import com.iraqsofit.speedoo.ErorrEvent;
import com.iraqsofit.speedoo.Main;
import com.iraqsofit.speedoo.home.HomeController;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


@Component
 public class ViewController implements Initializable , ErorrEvent {
    @FXML
    private AnchorPane mainLayout;
    @FXML
    private BorderPane borderpan;
    private double xOffset,yOffset;
    @FXML
    private HBox pane_error;
    @FXML
    private FontAwesomeIconView icon_close;
    @FXML
    private Label massage_error;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        HomeController.setErorrEvent(this);
        HintErorr();
        mainLayout.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = getStage().getX() - event.getScreenX();
                yOffset = getStage().getY() - event.getScreenY();
            }
        });
        mainLayout.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                getStage().setX(event.getScreenX() + xOffset);
                getStage().setY(event.getScreenY() + yOffset);
            }
        });
        try {
            LoadView("/fxml/home.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



   @FXML
   void Close(MouseEvent event) {
        if (!(Main.getThread()==null)) {
            Main.getThread().stop();
            System.exit(0);
        }else{
            System.exit(0);
        }
   }

   @FXML
   void Down(MouseEvent event) {
      getStage().setIconified(true);
   }

   public Stage getStage(){
        return (Stage) mainLayout.getScene().getWindow();
   }

   @FXML
   void Home(MouseEvent event) throws IOException {
       LoadView("/fxml/home.fxml");
   }

   @FXML
   void Setting(MouseEvent event) throws IOException {
      LoadView("/fxml/setting.fxml");
   }

   public void LoadView( String path) throws IOException {
      Parent root=null;
      try {
         FXMLLoader loader = new FXMLLoader();
         URL xmlUrl = getClass().getResource(path);
         loader.setLocation(xmlUrl);
        // loader.setControllerFactory(Main.getContext()::getBean);
         borderpan.setBottom(loader.load());
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

    @Override
    public void onErorr(String errorMassage) {
        ShowErorr();
        massage_error.setText(errorMassage);
    }
    @FXML
    void CloseError(MouseEvent event) {
      HintErorr();
    }
    public void ShowErorr(){
        pane_error.setPrefHeight(45);
        icon_close.setVisible(true);
        massage_error.setVisible(true);
    }
    public void HintErorr(){
        pane_error.setPrefHeight(0);
        icon_close.setVisible(false);
        massage_error.setVisible(false);
    }
}
