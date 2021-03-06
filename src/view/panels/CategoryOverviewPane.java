package view.panels;

import controller.CategoryController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class CategoryOverviewPane extends GridPane {
	private TableView table;
	private Button btnNew;
	private CategoryController categoryController;

	public CategoryOverviewPane(CategoryController categoryController) {
		this.categoryController = categoryController;
		this.setPadding(new Insets(5, 5, 5, 5));
		this.setVgap(5);
		this.setHgap(5);

		this.add(new Label("Categories:"), 0, 0, 1, 1);
		
		//CATEGORY OVERVIEW
		TableColumn nameCol= new TableColumn<>("Name");
		TableColumn descriptionCol = new TableColumn<>("description");
		
		nameCol.setCellValueFactory(new PropertyValueFactory("title"));
		descriptionCol.setCellValueFactory(new PropertyValueFactory("description"));		

		table = new TableView<String>();
		table.setPrefWidth(REMAINING);
		table.setItems(categoryController.getCategorieObservable());
		table.getColumns().addAll(nameCol,descriptionCol);
		this.add(table, 0, 1, 2, 6);

		//ADD NEW BUTTON
		btnNew = new Button("New");
		this.add(btnNew, 0, 11, 1, 1);
	}
	
	public void refreshTable(){
		table.getItems().clear();
		table.setItems(categoryController.getCategorieObservable());
	}
	
	public void setNewAction(EventHandler<ActionEvent> newAction) {
		btnNew.setOnAction(newAction);
	}
	
	public void setEditAction(EventHandler<MouseEvent> editAction) {
		table.setOnMouseClicked(editAction);
	}

}