package view.panels;

import controller.CategoryController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class CategoryDetailPane extends GridPane {
	private Button btnOK, btnCancel;
	private TextField titleField, descriptionField;
	private ComboBox<String> categoryField;
	private CategoryController categoryController;

	public CategoryDetailPane(CategoryController categoryController) {
		this.categoryController = categoryController;

		this.setPrefHeight(150);
		this.setPrefWidth(300);

		this.setPadding(new Insets(5, 5, 5, 5));
		this.setVgap(5);
		this.setHgap(5);

		this.add(new Label("Title:"), 0, 0, 1, 1);
		titleField = new TextField();
		this.add(titleField, 1, 0, 1, 1);

		this.add(new Label("Description:"), 0, 1, 1, 1);
		descriptionField = new TextField();
		this.add(descriptionField, 1, 1, 1, 1);

		this.add(new Label("Main Category:"), 0, 2, 1, 1);
		categoryField = new ComboBox<String>();
		categoryField.setValue("Main");
		categoryField.getItems().addAll("Main", "Sub");
		this.add(categoryField, 1, 2, 1, 1);

		btnCancel = new Button("Cancel");
		this.add(btnCancel, 0, 3, 1, 1);

		btnOK = new Button("Save");
		btnOK.isDefaultButton();
		this.add(btnOK, 1, 3, 1, 1);
	}

	public void setSaveAction(EventHandler<ActionEvent> saveAction) {
		btnOK.setOnAction(saveAction);
	}

	public void setCancelAction(EventHandler<ActionEvent> cancelAction) {
		btnCancel.setOnAction(cancelAction);
	}

	public String getTitle() {
		return titleField.getText();
	}

	public String getDescription() {
		return descriptionField.getText();
	}

	public Boolean isMainCategory() {
		System.out.println("Nieuwe categorie in " + categoryField.getValue() + " toegevoegd" );
		if (categoryField.getValue() == "Main") {
			return true;
		} else {
			return false;
		}
	}

	public void emptyFields() {
		titleField.clear();
		descriptionField.clear();
		categoryField.setValue("Main");
	}
}
