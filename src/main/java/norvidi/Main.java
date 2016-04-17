package norvidi;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.lang.reflect.Array;
import java.util.List;

public class Main extends Application {

    private TableView<Work> tbl = new TableView<Work>();

    @Override
    public void start(Stage primaryStage) throws Exception {


        primaryStage.setTitle("Norvidi Client Manager");
        StackPane sp = new StackPane();

        Work reader = new Work();

        TableView<Work> table = new TableView<Work>();
        ObservableList<Work> Works = FXCollections.observableArrayList(reader.readWorksFromExcelFile("C:\\Users\\Goncalo\\Desktop\\norvidi.xlsx", 1));

        tbl.setEditable(true);

        TableColumn number = new TableColumn("ORC N");
        TableColumn client = new TableColumn("Cliente");
        TableColumn address = new TableColumn("Morada");
        TableColumn zone = new TableColumn("Zona");
        TableColumn date = new TableColumn("Data");
        TableColumn price = new TableColumn("Valor");
        TableColumn iva = new TableColumn("IVA");
        TableColumn total = new TableColumn("Total");

        tbl.getColumns().addAll(number, client, address, zone, date, price, iva, total);
        tbl.setItems(Works);

        sp.getChildren().add(tbl);
        Scene scn = new Scene(sp, 750, 500);
        primaryStage.setScene(scn);
        primaryStage.show();
        /*upFile upit = new upFile();
        upit.httpConn(excelFilePath, "Excel\"norvidi");*/

    }


    public static void main(String[] args) {
        launch(args);
    }
}
