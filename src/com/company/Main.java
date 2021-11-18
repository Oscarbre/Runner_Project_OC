package com.company;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;




public class Main extends Application {

         @Override
    public void start(Stage primaryStage) throws Exception{

             /** Création de la scène */
        primaryStage.setTitle("Runner Project - Oscar Chêne - 2G2TD1TP1");
        Group root = new Group();
        Pane pane = new Pane(root);
        //Scene theScene = new Scene(pane, 1600, 600,true);
        GameScene theScene = new GameScene(pane, 1600, 600,true);
        primaryStage.setScene(theScene);
        primaryStage.show();


    }

         public static void main(String[] args) {
             launch(args);
         }
}
