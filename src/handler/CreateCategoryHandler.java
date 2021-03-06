package handler;

import controller.CategoryController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import view.panels.CategoryDetailPane;
import view.panels.CategoryOverviewPane;

public class CreateCategoryHandler  implements EventHandler<ActionEvent> {
	Stage stage;
	CategoryController categoryController;
	CategoryOverviewPane categoryOverviewPane;
	CategoryDetailPane categoryDetailPane;
	
	public CreateCategoryHandler(CategoryDetailPane detailPane, CategoryOverviewPane overviewPane, CategoryController categoryController) {
		this.categoryController = categoryController;
		this.categoryDetailPane = detailPane;
		this.categoryOverviewPane = overviewPane;
	}

	@Override
	public void handle(ActionEvent event) {
		try {
			this.stage = new Stage();
			BorderPane pane = new BorderPane();
			pane.setCenter(categoryDetailPane);
			Scene scene = new Scene(pane);
			stage.setScene(scene);
			stage.show();
			categoryDetailPane.setSaveAction(new SaveCategoryHandler(categoryDetailPane,categoryOverviewPane,categoryController,stage));
			categoryDetailPane.setCancelAction(new CancelCategoryHandler(stage,categoryDetailPane));
		} catch (Exception e) {
			Scene scene = new Scene(new GridPane());
			showAlert(Alert.AlertType.ERROR, scene.getWindow(), "Form Error!", e.getMessage());
		}
	}

	private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
		Alert alert = new Alert(alertType);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.initOwner(owner);
		alert.show();
	}
}