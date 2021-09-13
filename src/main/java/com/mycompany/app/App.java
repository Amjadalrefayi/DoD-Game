package com.mycompany.app;

import java.io.FileNotFoundException;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Formatter;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import com.graphbuilder.struc.LinkedList;
import com.mycompany.app.GameFolder.GameInitializer;
import com.mycompany.app.GameFolder.GameState;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.FloatProperty;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.ScrollEvent;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class App extends Application {

    public static GameInitializer gameInitializer = new GameInitializer();
    public static boolean pause = false;
    Group root = new Group();
    double factorzoom = 1;
    double h = 0;
    double l = 0;
    Stage stage = new Stage();

    @Override
    public void start(Stage primaryStage) throws Exception {
        Button button1 = new Button("Play Game");
        Button button2 = new Button("Pause");
        Button button3 = new Button("State");

        button1.setTranslateX(510);
        button1.setTranslateY(485);

        button2.setTranslateX(510);
        button2.setTranslateY(535);

        button3.setTranslateX(510);
        button3.setTranslateY(585);

        button1.setPrefSize(180, 40);
        button2.setPrefSize(180, 40);
        button3.setPrefSize(180, 40);

        Group yoyo = new Group();

        ImageView ee = new ImageView("mk.png");
        yoyo.getChildren().add(ee);

        yoyo.getChildren().add(button1);
        yoyo.getChildren().add(button2);
        yoyo.getChildren().add(button3);
        Scene scene = new Scene(yoyo, 1200, 650);
        stage.setTitle("JavaFX Button");

        stage.setScene(scene);

        stage.show();
        Scene sc = new Scene(root, 1300, 600);

        button1.setOnAction(MouseEvent -> {
            // g.getChildren().add(cc);
            primaryStage.setScene(sc);
            primaryStage.show();

            primaryStage.setOnCloseRequest(e -> {
                System.exit(0);
            });

            Timeline tl = new Timeline();
            tl.setCycleCount(Timeline.INDEFINITE);
            tl.setAutoReverse(true);
            tl.getKeyFrames().add(new KeyFrame(Duration.seconds(0.01), e -> {
                print();

            }));

            sc.setOnScroll((ScrollEvent event) -> {
                if (event.getDeltaY() < 0) {
                    factorzoom *= 1.1;
                } else {
                    factorzoom /= 1.1;
                }

            });

            sc.setOnKeyPressed(e -> {
                if (e.getCode() == KeyCode.SPACE) {
                    if (pause) {
                        tl.pause();
                        pause = !pause;
                        GameInitializer.gameState = GameState.Paused;
                        System.out.println(GameInitializer.gameState);
                    } else {
                        tl.play();
                        pause = !pause;
                        GameInitializer.gameState = GameState.Running;
                        System.out.println(GameInitializer.gameState);

                    }

                }
                if (e.getCode() == KeyCode.P) {
                    factorzoom *= 1.1;
                }
                if (e.getCode() == KeyCode.R) {
                    factorzoom /= 1.1;
                }
                if (e.getCode() == KeyCode.DOWN) {
                    if (l < gameInitializer.grid.getNUM_CELLS())
                        l -= 10;

                }
                if (e.getCode() == KeyCode.UP) {
                    if (l < 0)
                        l += 10;
                }
                if (e.getCode() == KeyCode.RIGHT) {
                    if (h < gameInitializer.grid.getNUM_CELLS())
                        h -= 10;
                }
                if (e.getCode() == KeyCode.LEFT) {
                    if (h < 0)
                        h += 10;
                }

            });

        });

    }

    void print() {
        Circle circle;
        root.getChildren().clear();
        ImageView mkm = new ImageView("lol.jpg");
        root.getChildren().add(mkm);
        Rectangle river = new Rectangle(Revier.x - (Revier.length / 2), Revier.y - (Revier.width / 2), Revier.length,
                Revier.width);
        river.setFill(javafx.scene.paint.Color.CYAN);
        root.getChildren().add(river);

        for (int i = 0; i < gameInitializer.grid.AaA; i++)
            for (int j = 0; j < gameInitializer.grid.AaA; j++) {
                for (int k = 0; k < gameInitializer.grid.regions[i][j].units.size(); k++) {
                    Unit print_unit = new Unit();
                    print_unit = gameInitializer.grid.regions[i][j].units.get(k);
                    // System.out.println(print_unit.getUnitType());
                    circle = new Circle(print_unit.getPosition().getCenterX() * this.factorzoom + this.h,
                            print_unit.getPosition().getCenterY() * this.factorzoom + this.l,
                            print_unit.getPosition().getRadius() * this.factorzoom);
                    switch (print_unit.getUnitName()) {

                        case TeslaTank:
                            Image image = new Image("teslatank.png");
                            circle.setFill(new ImagePattern(image));
                            break;

                        case Sniper:
                            image = new Image("sniper.png");
                            circle.setFill(new ImagePattern(image));

                            break;

                        case MirageTank:
                            image = new Image("miragetank.png");
                            circle.setFill(new ImagePattern(image));

                            break;

                        case Infantry:
                            image = new Image("infantry.png");
                            circle.setFill(new ImagePattern(image));

                            break;

                        case GrizzlyTank:
                            image = new Image("grizallytank.png");
                            circle.setFill(new ImagePattern(image));

                            break;

                        case NavySEAL:
                            image = new Image("navyseal.png");
                            circle.setFill(new ImagePattern(image));

                            break;

                        case TankDestroyer:
                            image = new Image("tankdestroyer.png");
                            circle.setFill(new ImagePattern(image));

                            break;

                        case PrismTank:
                            image = new Image("prismtank.png");
                            circle.setFill(new ImagePattern(image));

                            break;

                        case Pillbox:
                            image = new Image("Pillbox.png");
                            circle.setFill(new ImagePattern(image));

                            break;

                        case PrismTower:
                            image = new Image("prismtower.png");
                            circle.setFill(new ImagePattern(image));

                            break;

                        case GrandCannon:
                            image = new Image("grangcannon.png");
                            circle.setFill(new ImagePattern(image));

                            break;

                        case MAINBASE:
                            image = new Image("mainbase.png");
                            circle.setFill(new ImagePattern(image));
                            break;

                        case BlackEagle:
                            image = new Image("blackeagle.png");
                            circle.setFill(new ImagePattern(image));
                            circle.setRadius(30);

                            break;

                        case PatriotMissileSystem:
                            image = new Image("patriot.png");
                            circle.setFill(new ImagePattern(image));

                            break;
                        case Valley:
                            image = new Image("Valley.png");
                            circle.setFill(new ImagePattern(image));

                            break;
                    }

                    root.getChildren().add(circle);

                }
            }
    }

    public static void main(String[] args) throws FileNotFoundException {

        // new Thread(() -> {
        //     launch(args);
        // }).start();
        //  gameInitializer.remainingTime.start();
        // for (int i = 0; i < gameInitializer.grid.AaA; i++)
        //     for (int j = 0; j < gameInitializer.grid.AaA; j++)
        //         for (int k = 0; k < gameInitializer.grid.regions[i][j].units.size(); k++) {
        //             Unit thread_unit = new Unit();
        //             thread_unit = gameInitializer.grid.regions[i][j].units.get(k);
        //             if (thread_unit.getUnitName() != UnitType.Valley) {
        //                 Thread thread = new Thread(thread_unit);
        //                 thread.start();
        //             }
        //         }
     
        Formatter s = new Formatter();
        s.format("%1$+020.10f",10.2);
        class A {
            protected int get(){ return 5; }
            }
            class B extends A{
            protected int get(){ return 2; }
            }
            class C extends B{
            public int Get(){ return 7; }
            }
          
           
            // A xn = new A();
            // B x1 = new C();
            // C b2 = new C();
            // System.out.println(xn.get());int xamm=4;
            // double nnnn = xamm/0;

            // System.out.println(1+2+"0amjad"+1+2+3);
            // int meme = 'a';
            // char amm = 'a';
            // int jkj = (int)amm;
            // Float ammm;
            // Integer n = (int)1;
            // int nn = (Integer)2;
            int []x = {5,6,7};
            System.out.println(x[0]);
            A(x);
            System.out.println(x[0]);



       
        

    }
   public static void A(int [] x)
    {
        x[0]=1;
    }
}
