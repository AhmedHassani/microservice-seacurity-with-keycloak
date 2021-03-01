package com.iraqsofit.speedoo;
import com.iraqsofit.speedoo.ui.Ex;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


/*
 // write by Ahmed Rahman Hassani
 */
@SpringBootApplication
public class Main  extends Application {
    private static OnRestartEvent onRestartEvent;
    static ConfigurableApplicationContext context;
    private static Stage stage;
    private  FXMLLoader fxmlLoader;
    private static Thread  thread;
    private static String[] savedArgs;
    public static String[] getArgs() {
        return savedArgs;
    }
    public static void main(String[] args) {
        savedArgs=args;
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        setStage(stage);
        fxmlLoader =new FXMLLoader(getClass().getResource("/fxml/main.fxml"));
        stage.setScene(new Scene(fxmlLoader.load()));
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }

    public static ConfigurableApplicationContext getContext() {
        return context;
    }

    @Override
    public void stop() throws Exception {
        if (!(context==null)){
            context.close();
        }
    }

    public static void  StopServer(){
        context.stop();
    }

    public static boolean isRunning(){
        return context.isRunning();
    }

    public  void StartServer(){
         thread = new Thread(() -> {
            try {
                getOnRestartEvent().ConectionState("Connecting...", ConnectState.LOODING);
                context = SpringApplication.run(Main.class,"");
                getOnRestartEvent().ConectionState("Connect", ConnectState.CONNECTED);
            }catch (BeanCreationException exception){
                getOnRestartEvent().ConectionState(
                        new Ex(exception.getMessage()).getMassage(),
                        ConnectState.CONNECTED_FILED);
                thread.stop();
            }
        });
        thread.setDaemon(false);
        thread.start();
    }



    public  void restart() {
        ApplicationArguments args = context.getBean(ApplicationArguments.class);
        thread = new Thread(() -> {
            try {
                getOnRestartEvent().ConectionState("Connecting...",ConnectState.LOODING);
                context.close();
                context = SpringApplication.run(Main.class,args.getSourceArgs());
                getOnRestartEvent().ConectionState("Connect", ConnectState.CONNECTED);
            }catch (BeanCreationException exception){
                getOnRestartEvent().ConectionState(
                        new Ex(exception.getMessage()).getMassage(),
                        ConnectState.CONNECTED_FILED);
                thread.stop();
            }
        });
        thread.setDaemon(false);
        thread.start();
    }


    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        Main.stage = stage;
    }

    public static OnRestartEvent getOnRestartEvent() {
        return Main.onRestartEvent;
    }

    public static void setOnRestartEvent(OnRestartEvent onRestartEvent) {
        Main.onRestartEvent = onRestartEvent;
    }

    public FXMLLoader getFxmlLoader() {
        return fxmlLoader;
    }

    public void setFxmlLoader(FXMLLoader fxmlLoader) {
        this.fxmlLoader = fxmlLoader;
    }

    public static Thread getThread() {
        return thread;
    }


}
