package norvidi;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import norvidi.model.Work;
import norvidi.view.WorkOverviewController;

import java.io.IOException;
import java.time.LocalDate;

public class Main extends Application {

    /*private TableView<Workeeee> tbl = new TableView<Workeeee>();*/
    private ObservableList<Work> Works = FXCollections.observableArrayList();

    @Override
    public void start(Stage primaryStage) throws Exception {

        /*Workeeee reader = new Workeeee();

        ObservableList<Workeeee> workeeees = FXCollections.observableArrayList(reader.readWorksFromExcelFile("C:\\Users\\Goncalo\\Desktop\\norvidi.xlsx", 1));
*/
        Works.add(new Work("001/P/06", "Sporstyle", "Cimo da Vila - S. João de Ponte", "Guimarães", LocalDate.now(), 51190, 10749, 61939));
        showWorkOverview();


        /*tbl.setItems(workeeees);*/

        /*upFile upit = new upFile();
        upit.httpConn(excelFilePath, "Excel\"norvidi");*/

    }

    public void showWorkOverview() {
        try {

            // Carrega a person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/PersonOverview.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();


            // Dá ao controlador acesso à the main app.
            WorkOverviewController controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public ObservableList<Work> getWorkData() {
        return Works;
    }
    public static void main(String[] args) {
        launch(args);
    }
}
