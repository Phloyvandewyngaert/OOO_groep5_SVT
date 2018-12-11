package controller;
 
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import model.domain.Category;
import model.domain.Question;
import model.facade.Service;

public class QuestionController implements Observer {
    private final Service service;
    private Stage stage;
   
    public QuestionController() {
        service = new Service();
        service.addObserver(this);
        this.stage = new Stage();
        
        Question question1 = new Question("Which pattern defines a family of algorithms, encapsulates them and makes them exchangeable?", "Design patterns");
        Question question2 = new Question("What design principle is the least applicable with the Strategy pattern?", "Design principles");

        service.addQuestion(question1);
        service.addQuestion(question2);
    }
   
    public Service getService() {
        return this.service;
    }
   
    public void AddQuestion(String question, String categoryTitle) {
        Question q = new Question(question, categoryTitle);
        this.service.addQuestion(q);
    }
   
    public ArrayList<Question> getQuestions(){
        return service.getQuestions();
    }

    public ArrayList<String> getAllCategorieTitles() {
        ArrayList<String> categories = new ArrayList<>();
        for (Category c: this.service.getCategories()) {
            categories.add(c.getTitle());
        }
        return categories;
    }
    
	public ObservableList<Question> getQuestionObservable() {
		ObservableList<Question> questions = FXCollections.observableArrayList(service.getQuestions());
		return questions;
	}
 
    @Override
    public void update(Observable o, Object arg) {
       
    }
}