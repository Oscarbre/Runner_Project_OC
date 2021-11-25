package com.company;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;


/** Classe qui définit une scène et les objets présents dessus, notamment :
 * - Background
 * - Caméra
 * - Héros
 */

public class GameScene extends Scene {


    private Camera Cam;
    private StaticThing left;
    private StaticThing right;
    private StaticThing right2;
    private LifeCount lifebar;
    private Hero hero= new Hero(300,250 ,0,"C:\\Users\\oscar\\IdeaProjects\\Runner_Project\\heros.png", 84, 100 );;

    public GameScene(Pane root, double width, double height, boolean depthbuffer) {
        super(root, width, height, depthbuffer);
        this.Cam = new Camera(800, 420, 200, 200);
        this.left = new StaticThing(800, 600, "C:\\Users\\oscar\\IdeaProjects\\Runner_Project\\desert.png");
        this.right = new StaticThing(800, 600, "C:\\Users\\oscar\\IdeaProjects\\Runner_Project\\desert.png");
        this.right2 = new StaticThing(800, 600, "C:\\Users\\oscar\\IdeaProjects\\Runner_Project\\desert.png");
        this.lifebar=new LifeCount(499,499,"C:\\Users\\oscar\\IdeaProjects\\Runner_Project\\health_bar.png");

        /** Initialisation du background et du héros*/
        left.getImg().setX(0);
        left.getImg().setY(0);

        right.getImg().setX(800);
        right.getImg().setY(0);

        lifebar.getImg().setX(-30);
        lifebar.getImg().setY(-35);
        lifebar.getImg().setViewport(new Rectangle2D(0,10,499,110));
        lifebar.getImg().setFitHeight(90);
        lifebar.getImg().setFitWidth(300);
        lifebar.getImg().setPreserveRatio(false);

        root.getChildren().add(left.getImg());
        root.getChildren().add(right.getImg());
        root.getChildren().add(right2.getImg());
        root.getChildren().add(lifebar.getImg());


        root.getChildren().add(hero.getImgAT());

        timer.start();

        this.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.SPACE) {
                if(hero.getAttitude()!=1 & hero.getAttitude()!=-1){
                    hero.jump();
                }
            }


        });
    }



        /** Mise en place du timer pour les animations  */

    private long lastUpdate=0;
    private Integer decalage =0;


    private AnimationTimer timer = new AnimationTimer()
       {public void handle(long now){
        if (now - lastUpdate >= 15500000) {
            hero.update();
            update();
            lastUpdate=now;
            //      Cam.update(time);
        }
        }
    };

        /** Setter et Getter */

    public AnimationTimer getTimer() {
        return timer;
    }

        /** Fonction d'actualisation de la scène */

    public void update(){
        decalage=(decalage+10)%800;
        left.getImg().setViewport(new Rectangle2D(decalage,0,800,600));
        right.getImg().setX(800-decalage);
        right2.getImg().setX(1600-decalage);


    }

        /** Fonction pour sauter */

    EventHandler<KeyEvent> hd = new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent kv) {
                if (kv.getSource() == KeyCode.SPACE){
                    hero.jump();
                }
            }
        };


}
