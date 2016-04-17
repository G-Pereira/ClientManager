package norvidi;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.List;

public class Main  extends Application  {

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Norvidi Client Manager");
        StackPane sp = new StackPane();


        Work reader = new Work();

        List<Work> booktable = reader.readWorksFromExcelFile("C:\\Users\\Goncalo\\Desktop\\norvidi.xlsx", 1);

        TableView<Work> table = new TableView<Work>();
        ObservableList<Work> Works = FXCollections.observableArrayList(booktable);

        table.setEditable(true);

        TableColumn number = new TableColumn("ORC N");
        TableColumn client = new TableColumn("Cliente");
        TableColumn address = new TableColumn("Morada");
        TableColumn zone = new TableColumn("Zona");
        TableColumn date = new TableColumn("Data");
        TableColumn price = new TableColumn("Valor");
        TableColumn iva = new TableColumn("IVA");
        TableColumn total = new TableColumn("Total");

        table.getColumns().addAll(number, client, address, zone, date, price, iva, total);
        table.setItems(Works);

        sp.getChildren().add(table);
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
