package norvidi;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Norvidi Client Manager");

        TableView tbl = new TableView();
        StackPane sp = new StackPane();
        sp.getChildren().add(tbl);

        Scene scn = new Scene(sp, 750, 500);
        primaryStage.setScene(scn);
        primaryStage.show();
        upFile upit = new upFile();
        upit.httpConn();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
