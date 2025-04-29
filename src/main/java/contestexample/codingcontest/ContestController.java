package contestexample.codingcontest;
    import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
    public class ContestController {

        @FXML
        private ComboBox<String> flavorComboBox;

        @FXML
        private Button addScoopButton, newConeButton, printReceiptButton;

        @FXML
        private TreeView<String> treeView;

        private Order currentOrder = new Order();
        private Cone currentCone = null;
        private TreeItem<String> rootItem = new TreeItem<>("Order");

        @FXML
        public void initialize() {
            // Initialize flavors
            flavorComboBox.getItems().addAll("Chocolate", "Vanilla", "Strawberry", "Mango");

            // Setup TreeView
            treeView.setRoot(rootItem);
            treeView.setShowRoot(false);
        }

        @FXML
        private void handleNewCone() {
            currentCone = new Cone();
            currentOrder.addCone(currentCone);

            TreeItem<String> coneItem = new TreeItem<>("Cone - " + new SimpleDateFormat("HH:mm:ss").format(currentCone.getDate()));
            rootItem.getChildren().add(coneItem);

            treeView.getSelectionModel().select(coneItem);
        }

        @FXML
        private void handleAddScoop() {
            if (currentCone == null) {
                showAlert("Error", "No cone created yet. Please create a cone first!");
                return;
            }
            if (flavorComboBox.getValue() == null) {
                showAlert("Error", "Please select a flavor first!");
                return;
            }
            if (currentCone.getScoops().size() >= 3) {
                showAlert("Error", "Maximum 3 scoops per cone!");
                return;
            }

            String selectedFlavor = flavorComboBox.getValue();
            double price = getPriceForFlavor(selectedFlavor);
            Scoop scoop = new Scoop(selectedFlavor, price);

            currentCone.addScoop(scoop);

            // Add to TreeView
            TreeItem<String> selectedConeItem = treeView.getSelectionModel().getSelectedItem();
            if (selectedConeItem != null) {
                selectedConeItem.getChildren().add(new TreeItem<>(scoop.getFlavor() + " ($" + String.format("%.2f", scoop.getPrice()) + ")"));
                selectedConeItem.setExpanded(true);
            }
        }

        @FXML
        private void handlePrintReceipt() {
            currentOrder.printReceipt();
        }

        private double getPriceForFlavor(String flavor) {
            switch (flavor) {
                case "Chocolate": return 2.50;
                case "Vanilla": return 2.00;
                case "Strawberry": return 2.20;
                case "Mango": return 2.30;
                default: return 2.00;
            }
        }

        private void showAlert(String title, String message) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle(title);
            alert.setContentText(message);
            alert.showAndWait();
        }
        @FXML
        private void HandleTheFlavour() {
            String selected = flavorComboBox.getValue();
            System.out.println("Flavor selected: " + selected);
        }

    }