package view.panels;

import controller.CategoryController;
import controller.QuestionController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class MessagePane extends GridPane {
	private Button testButton;
	private CategoryController categoryController;
	private QuestionController questionController;
	public MessagePane (CategoryController categoryController, QuestionController questionController){
		
		this.categoryController=categoryController;
		this.questionController=questionController;

	    setBorder(new Border(new BorderStroke(Color.BLACK, 
	            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

		this.setPadding(new Insets(5, 5, 5, 5));
        this.setVgap(5);
        this.setHgap(5);
        
		testButton = new Button("Evaluate");
		
		add(testButton, 0,1,1,1);
		setHalignment(testButton, HPos.CENTER);
	}
	
	public void setStartAction(EventHandler<ActionEvent> startAction) {
		testButton.setOnAction(startAction);
	}

}
