package norvidi;

import com.google.api.services.drive.Drive;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

import static norvidi.GDrive.getDriveService;



public class Main extends Application {

    static TableView tbl;

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Norvidi Client Manager");

        tbl = new TableView();
        StackPane sp = new StackPane();
        sp.getChildren().add(tbl);

        Scene scn = new Scene(sp, 750, 500);
        primaryStage.setScene(scn);
        primaryStage.show();

        // Build a new authorized API client service.
        Drive service = getDriveService();

        String fileId = "0B8USYnKeDsgoN0RMT0dIQXZtS0E";
        OutputStream outputStream = new ByteArrayOutputStream();
        service.files().export(fileId, "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet").executeMediaAndDownloadTo(outputStream);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
