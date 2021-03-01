package com.iraqsofit.speedoo.home;


import com.iraqsofit.speedoo.ConnectState;
import com.iraqsofit.speedoo.ErorrEvent;
import com.iraqsofit.speedoo.Main;
import com.iraqsofit.speedoo.OnRestartEvent;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.util.Duration;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Stream;

@Component
public class HomeController implements Initializable  , OnRestartEvent {
    @FXML
    private Button run;
    private  static ErorrEvent erorrEvent;
    @FXML
    private HBox stop;
    @FXML
    private HBox restart;
    @FXML
    private FontAwesomeIconView stop_icon;
    @FXML
    private FontAwesomeIconView re_icon;
    private  Timeline timeline;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (!(Main.getContext()==null)){
            if (Main.isRunning()){
                setborder(run);
                run.setText("Server Running");
                intStop(true);
            }
        }else {
            intStop(false);
        }
        Main.setOnRestartEvent(this);
    }

    public void setborder(Button pane) {
        Color[] colors = Stream.of("#4971FF", "#9dc869", "#6fba82")
                .map(Color::web)
                .toArray(Color[]::new);
        List<Border> list = new ArrayList<>();
        int mills[] = {-300};
        KeyFrame keyFrames[]  = Stream.iterate(0, i -> i+1)
                .limit(100)
                .map(i -> new LinearGradient(0, 0, 1, 1, true, CycleMethod.NO_CYCLE, new Stop[]{new Stop(0, colors[i%colors.length]), new Stop(1, colors[(i+1)%colors.length])}))
                .map(lg -> new Border(new BorderStroke(lg, BorderStrokeStyle.SOLID, new CornerRadii(75), new BorderWidths(2))))
                .map(b -> new KeyFrame(Duration.millis(mills[0]+=300), new KeyValue(pane.borderProperty(), b, Interpolator.EASE_IN)))
                .toArray(KeyFrame[]::new);
        timeline= new Timeline(keyFrames);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    @FXML
    void RunServerbut(MouseEvent event) {
        if (Main.getContext()==null){
            new Main().StartServer();
        }else {
            if (!Main.getContext().isRunning()) {
                new Main().StartServer();
            }else {
                getErorrEvent().onErorr("Server already Running");
            }
        }

    }

    @Override
    public void onRestart(String[] arag) {

    }



    @Override
    public void ConectionState(String massage, ConnectState connectState) {
        if (connectState==ConnectState.CONNECTED){
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    setborder(run);
                    run.setText("Server Running");
                    intStop(true);
                }
            });
        }else if (connectState==ConnectState.CONNECTED_FILED){
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    run.setText("Run Server");
                    getErorrEvent().onErorr(massage);
                }
            });
        }else if (connectState==ConnectState.LOODING){
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    run.setText("Connecting...");
                }
            });
        }
    }

    public static ErorrEvent getErorrEvent() {
        return erorrEvent;
    }

    @FXML
    void Stop(MouseEvent event) {
       Main.StopServer();
       getErorrEvent().onErorr("Server Stop");
       run.setText("Run Server");
       timeline.stop();
       intStop(false);
    }

    @FXML
    void reStart(MouseEvent event) {
       new Main().restart();
    }
    public void intStop(boolean stat){
        stop.setVisible(stat);
        restart.setVisible(stat);
        stop_icon.setVisible(stat);
        re_icon.setVisible(stat);
    }

    public static void setErorrEvent(ErorrEvent erorrEvent) {
        HomeController.erorrEvent = erorrEvent;
    }
}
