package norvidi.view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import norvidi.Main;
import norvidi.model.Work;

public class WorkOverviewController {
    @FXML
    private TableView<Work> WorkTable;
    @FXML
    private TableColumn<Work, String> numberColumn;
    @FXML
    private TableColumn<Work, String> clientColumn;

    @FXML
    private Label numberLabel;
    @FXML
    private Label clientLabel;
    @FXML
    private Label addressLabel;
    @FXML
    private Label zoneLabel;
    @FXML
    private Label dateLabel;
    @FXML
    private Label priceLabel;
    @FXML
    private Label ivaLabel;
    @FXML
    private Label totalLabel;

    // Reference to the main application.
    private Main main;

    /**
     * O construtor.
     * O construtor é chamado antes do método inicialize().
     */
    public WorkOverviewController() {
    }

    /**
     * Inicializa a classe controller. Este método é chamado automaticamente
     *  após o arquivo fxml ter sido carregado.
     */
    @FXML
    private void initialize() {
        // Inicializa a tablea de pessoa com duas colunas.
        numberColumn.setCellValueFactory(cellData -> cellData.getValue().numberProperty());
        clientColumn.setCellValueFactory(cellData -> cellData.getValue().clientProperty());
    }

    /**
     * É chamado pela aplicação principal para dar uma referência de volta a si mesmo.
     *
     * @param main
     */
    public void setMainApp(Main main) {
        this.main = main;

        // Adiciona os dados da observable list na tabela
        WorkTable.setItems(main.getWorkData());
    }
}
