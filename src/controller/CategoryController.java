package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import model.domain.Category;
import model.facade.Service;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class CategoryController implements Observer {
	private final Service service;
	private Stage stage;
	private int questionNumber = 0;

	public CategoryController() {
		service = new Service();
		service.addObserver(this);
		this.stage = new Stage();

		Category cat1 = new Category("Design principles", "The SOLID design principles.", true);
		Category cat2 = new Category("Java", "java extra's.", true);

		service.addCategorie(cat1);
		service.addCategorie(cat2);
	}

	public Service getService() {
		return this.service;
	}

	public void AddCategorie(String name, String description, boolean mainCategorie) {
		Category categorie = new Category(name, description, mainCategorie);
		this.service.addCategorie(categorie);
	}

	public ArrayList<Category> getCategories() {
		return service.getCategories();
	}

	public ArrayList<String> getCategoriesTitle() {
		ArrayList<String> categories = new ArrayList<String>();
		for (Category s : this.service.getCategories()) {
			categories.add(s.getTitle());
		}
		return categories;
	}

	public ObservableList<Category> getCategorieObservable() {
		ObservableList<Category> categories = FXCollections.observableArrayList(service.getCategories());
		return categories;
	}

	@Override
	public void update(Observable arg0, Object arg1) {

	}
}
