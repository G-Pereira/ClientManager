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

public class Main extends Application {

    private TableView tbl = new TableView();

    /*private TableView<Work> table = new TableView<Work>();
    private final ObservableList<Book> data =
            FXCollections.observableArrayList(
                    new Work("A", "Z", "a@example.com"),
                    new Work("B", "X", "b@example.com"),
                    new Work("C", "W", "c@example.com"),
                    new Work("D", "Y", "d@example.com"),
                    new Work("E", "V", "e@example.com")
            );*/


    @Override
    public void start(Stage primaryStage) throws Exception {
        Integer i = 0;
        primaryStage.setTitle("Norvidi Client Manager");
        StackPane sp = new StackPane();
        sp.getChildren().add(tbl);

        String excelFilePath = "C:\\Users\\Goncalo\\Desktop\\norvidi.xlsx";
        Book reader = new Book();
        List<Book> table = reader.readBooksFromExcelFile(excelFilePath, 1);

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

        while (!(table.get(i)+"").contains("null")) {
            System.out.println(table.get(i));
            i++;
        }

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
