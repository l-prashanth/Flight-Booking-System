package com.prashanth.flight.controller;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.springframework.stereotype.Controller;

@Controller
public class TestController{

    public void test(Stage primaryStage){
        Button btn1 = new Button("Say, Hello World");
        btn1.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                // TODO Auto-generated method stub
                System.out.println("hello world");
            }
        });
        StackPane root = new StackPane();
        root.getChildren().add(btn1);
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setTitle("First JavaFX Application");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public void dummy(Stage primaryStage){
        Button btn1 = new Button("Say, Hello World");
        btn1.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                // TODO Auto-generated method stub
                System.out.println("hello world");
            }
        });
        StackPane root = new StackPane();
        root.getChildren().add(btn1);
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setTitle("First JavaFX Application");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
//    @Override
//    public void start(Stage primaryStage) throws Exception {
//        // TODO Auto-generated method stub
//        Button btn1 = new Button("Say, Hello World");
//        btn1.setOnAction(new EventHandler<ActionEvent>() {
//
//            @Override
//            public void handle(ActionEvent arg0) {
//                // TODO Auto-generated method stub
//                System.out.println("hello world");
//            }
//        });
//        StackPane root = new StackPane();
//        root.getChildren().add(btn1);
//        Scene scene = new Scene(root, 600, 400);
//        primaryStage.setTitle("First JavaFX Application");
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }

}
