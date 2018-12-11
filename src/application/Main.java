package application;

import controller.CategoryController;
import controller.QuestionController;
import handler.CreateCategoryHandler;
import handler.CreateQuestionHandler;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import view.panels.AssesMainPane;
import view.panels.CategoryDetailPane;
import view.panels.CategoryOverviewPane;
import view.panels.MessagePane;
import view.panels.QuestionDetailPane;
import view.panels.QuestionOverviewPane;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {

		try {
			CategoryController categoryController = new CategoryController();
			CategoryOverviewPane categoryOverviewPanel = new CategoryOverviewPane(categoryController);
			CategoryDetailPane categoryDetailPane = new CategoryDetailPane(categoryController);
			
			QuestionController questionController = new QuestionController();
			QuestionOverviewPane questionOverviewPanel = new QuestionOverviewPane(questionController);
			QuestionDetailPane questionDetailPane = new QuestionDetailPane(questionController);
			
			MessagePane messagePane = new MessagePane(categoryController, questionController);
			//TestPane testpane = new TestPane(categoryController);
			Group root = new Group();
			Scene scene = new Scene(root, 750, 400);

			BorderPane borderPane = new AssesMainPane(messagePane, categoryOverviewPanel, questionOverviewPanel);
			borderPane.prefHeightProperty().bind(scene.heightProperty());
			borderPane.prefWidthProperty().bind(scene.widthProperty());

			root.getChildren().add(borderPane);
			primaryStage.setScene(scene);
			primaryStage.sizeToScene();

			primaryStage.show();
			
			categoryOverviewPanel.setNewAction(new CreateCategoryHandler(categoryDetailPane, categoryOverviewPanel, categoryController));
			questionOverviewPanel.setNewAction(new CreateQuestionHandler(questionDetailPane, questionOverviewPanel, questionController));
			//messagePane.setStartAction(new StartTestHandler(categoryController, testpane));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
