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

import java.util.ArrayList;
import java.util.Random;


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
    private Hero hero= new Hero(300,250 ,0,"C:\\Users\\oscar\\IdeaProjects\\Runner_Project\\heros.png", 84, 100 );

    private ArrayList<Foe> traps = new ArrayList<Foe>();
    private StaticThing gameoverscene=new StaticThing(666,375,"C:\\Users\\oscar\\IdeaProjects\\Runner_Project\\Game Over.png");

    static Random rand = new Random();



    public GameScene(Pane root, double width, double height, boolean depthbuffer) {
        super(root, width, height, depthbuffer);
        this.Cam = new Camera(800, 420, 200, 200);
        this.left = new StaticThing(800, 600, "C:\\Users\\oscar\\IdeaProjects\\Runner_Project\\desert.png");
        this.right = new StaticThing(800, 600, "C:\\Users\\oscar\\IdeaProjects\\Runner_Project\\desert.png");
        this.right2 = new StaticThing(800, 600, "C:\\Users\\oscar\\IdeaProjects\\Runner_Project\\desert.png");
        this.lifebar=new LifeCount(499,499,"C:\\Users\\oscar\\IdeaProjects\\Runner_Project\\health_bar.png");

        for (int k=0;k<10;k++){
            this.traps.add(new Foe(2000+rand.nextInt(10000), 290, 3, "C:\\Users\\oscar\\IdeaProjects\\Runner_Project\\trap.png", 179, 78));
        }


        /** Initialisation du background et du héros*/
        left.getImg().setX(0);
        left.getImg().setY(0);

        right.getImg().setX(800);
        right.getImg().setY(0);

        lifebar.getImg().setX(-30);
        lifebar.getImg().setY(-35);
        lifebar.getImg().setViewport(new Rectangle2D(0,10,499,105));
        lifebar.getImg().setFitHeight(90);
        lifebar.getImg().setFitWidth(300);
        lifebar.getImg().setPreserveRatio(false);

        gameoverscene.getImg().setY(2000); // hors de l'écran
        gameoverscene.getImg().setFitHeight(500);
        gameoverscene.getImg().setFitWidth(1000);
        gameoverscene.getImg().setPreserveRatio(false);

        root.getChildren().add(left.getImg());
        root.getChildren().add(right.getImg());
        root.getChildren().add(right2.getImg());
        root.getChildren().add(lifebar.getImg());
        for (Foe t: traps) {
            root.getChildren().add(t.getImg());
        }

        root.getChildren().add(hero.getImg());
        root.getChildren().add(gameoverscene.getImg());

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
            hero.setInvincibility((hero.getInvincibility()-5000000));
            update();
            for (Foe t: traps){
                t.update();
            }
            if (!hero.isInvicible()){
                for (Foe t : traps) {
                    if (t.GetHitbox().intersects(hero.GetHitbox())) {
                        System.out.println("intersect");
                        System.out.println(hero.getInvincibility());
                        hero.setInvincibility(250000000);
                        lifebar.lifelost();
                        if (lifebar.getNboflives() == 0) {
                            gameoverscene.getImg().setY(-50);
                            gameoverscene.getImg().setX(270);
                            timer.stop();
                        }
                    }
                }
            }
            lastUpdate=now;
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
