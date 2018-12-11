package view.panels;

import controller.QuestionController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
 
public class QuestionDetailPane extends GridPane {
    private Button btnOK, btnCancel, btnAdd, btnRemove;
    private ListView statementsArea;
    private TextField questionField, statementField, feedbackField;
    private ComboBox categoryField;
    private QuestionController questionController;
 
    public QuestionDetailPane(QuestionController questionController) {
        this.questionController = questionController;

        this.setPrefHeight(300);
        this.setPrefWidth(320);
       
        this.setPadding(new Insets(5, 5, 5, 5));
        this.setVgap(5);
        this.setHgap(5);
       
        this.add(new Label("Question: "), 0, 0, 1, 1);
        questionField = new TextField();
        this.add(questionField, 1, 0, 2, 1);
       
        this.add(new Label("Statement: "), 0, 1, 1, 1);
        statementField = new TextField();
        this.add(statementField, 1, 1, 2, 1);

        this.add(new Label("Statements: "), 0, 2, 1, 1);
        statementsArea = new ListView();
        //statementsArea.setPrefRowCount(5);
        statementsArea.setEditable(false);
        this.add(statementsArea, 1, 2, 2, 5);
 
        Pane addRemove = new HBox();

            btnAdd = new Button("Add");
            btnAdd.setOnAction(new AddStatementListener());
            addRemove.getChildren().add(btnAdd);
 
            btnRemove = new Button("Remove");
            btnRemove.setOnAction(new RemoveStatementListener());
            addRemove.getChildren().add(btnRemove);

        this.add(addRemove, 1, 8, 2, 1);
 
        this.add(new Label("Category: "), 0, 9, 1, 1);
        categoryField = new ComboBox<String>();
        //categoryField.getItems().addAll(controller.getAllCategorieTitles());
        categoryField.getItems().addAll("Main", "Sub");
        this.add(categoryField, 1, 9, 2, 1);

        this.add(new Label("Feedback: "), 0, 10, 1, 1);
        feedbackField = new TextField();
        this.add(feedbackField, 1, 10, 2, 1);
 
        btnCancel = new Button("Cancel");
        this.add(btnCancel, 0, 11, 1, 1);
 
        btnOK = new Button("Save");
        btnOK.isDefaultButton();
        this.add(btnOK, 1, 11, 2, 1);
    }

    class AddStatementListener implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            statementsArea.getItems().add(statementField.getText());
        }
    }

    class RemoveStatementListener implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            statementsArea.getItems().remove(statementField.getText());
        }
    }
 
	public void setSaveAction(EventHandler<ActionEvent> saveAction) {
		btnOK.setOnAction(saveAction);
	}

	public void setCancelAction(EventHandler<ActionEvent> cancelAction) {
		btnCancel.setOnAction(cancelAction);
	}

    public String getQuestion() {
    	return questionField.getText();
    }

    public String getCategoryTitle() {
        return (String)categoryField.getValue();
    }
    
	public void emptyFields() {
		questionField.clear();
		statementField.clear();
		statementsArea.refresh();
		feedbackField.clear();
	}
}