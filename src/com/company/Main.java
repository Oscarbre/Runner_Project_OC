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
        primaryStage.setTitle("Runner Project - Oscar Chêne");
        Group root = new Group();
        Pane pane = new Pane(root);
        Scene theScene = new Scene(pane, 1600, 600,true);
        primaryStage.setScene(theScene);
        primaryStage.show();

             /** Mise en place du background */
        GameScene.left.getImg().setX(0);
        GameScene.left.getImg().setY(0);
        GameScene.right.getImg().setX(800);
        GameScene.right.getImg().setY(0);
        root.getChildren().add(GameScene.left.getImg());
        root.getChildren().add(GameScene.right.getImg());

            /** Mise en place du héros */
        Image spriteSheet = new Image("C:\\Users\\oscar\\IdeaProjects\\Runner_Project\\heros.png");
        ImageView sprite = new ImageView(spriteSheet);

            /** Définition un rectangle qui fait un zoom sur une zone de l'image (pour le héros)*/
        sprite.setViewport(new Rectangle2D(20,0,75,100));
        sprite.setX(GameScene.Cam.getX());                                                                              // permet de choisir la position du rectangle
        sprite.setY(GameScene.Cam.getY());
        root.getChildren().add(sprite);







    }

         public static void main(String[] args) {
             launch(args);



         }
}
