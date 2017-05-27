package codeu.chat.client.simplegui;

import codeu.chat.client.ClientContext;
import codeu.chat.client.Controller;
import codeu.chat.client.View;
import codeu.chat.util.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Created by Bing Liang on 5/27/17.
 * Redesign the GUI by JavaFX
 * The Template Code is form YouTube JavaFX tutorials:
 * https://www.youtube.com/watch?v=S_JN7zO12H4&index=2&list=PL6gx4Cwl9DGBzfXLWLSYVy8EbTdpGbUIG
 */


    public class ChatGUI extends Application {
    private final static Logger.Log LOG = Logger.newLog(ChatSimpleGui.class);

    private ClientContext clientContext;

    public ChatGUI() {
    }

    Button loginButton;
    Button signupButton;

    public void runtest(String[] args) {
        Application.launch(args);
    }

    public void run(Controller controller, View view, String[] args) {
        clientContext = new ClientContext(controller, view);
        Application.launch(args);
    }



    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("ChatApp");
        HBox box = new HBox(20);
        box.setPadding(new Insets(10));
        box.setAlignment(Pos.CENTER);


        loginButton = new Button("Login");
        signupButton = new Button("Sign Up");
        box.getChildren().addAll(loginButton, signupButton);

        StackPane layout = new StackPane();
        layout.getChildren().add(box);

        Scene scence = new Scene(layout, 300, 300);
        primaryStage.setScene(scence);
        primaryStage.show();

    }
}
