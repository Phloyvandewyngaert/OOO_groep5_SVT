package view.panels;
 
import controller.QuestionController;
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
 
public class QuestionOverviewPane extends GridPane {
    private TableView table;
    private Button btnNew;
    private QuestionController questionController;
   
    public QuestionOverviewPane(QuestionController questionController) {
        this.questionController = questionController;
        this.setPadding(new Insets(5, 5, 5, 5));
        this.setVgap(5);
        this.setHgap(5);
       
        this.add(new Label("Questions:"), 0, 0, 1, 1);

        //Question overview
        TableColumn questionCol = new TableColumn<>("Question");
        TableColumn categoryCol = new TableColumn<>("Category");
        
        questionCol.setCellValueFactory(new PropertyValueFactory("question"));
		categoryCol.setCellValueFactory(new PropertyValueFactory("categoryTitle"));

        table = new TableView<String>();
        table.setPrefWidth(REMAINING);
        table.setItems(questionController.getQuestionObservable());
        table.getColumns().addAll(questionCol, categoryCol);
        this.add(table, 0, 1, 2, 6);

        //Button add new
        btnNew = new Button("New");
        this.add(btnNew, 0, 11, 1, 1);
    }
    
	public void refreshTable(){
		table.getItems().clear();
		table.setItems(questionController.getQuestionObservable());
	}
   
    public void setNewAction(EventHandler<ActionEvent> newAction) {
    	btnNew.setOnAction(newAction);
    }
   
    public void setEditAction(EventHandler<MouseEvent> editAction) {
        table.setOnMouseClicked(editAction);
    }
 
}