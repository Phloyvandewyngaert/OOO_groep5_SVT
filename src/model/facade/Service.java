package model.facade;

import java.util.ArrayList;
import java.util.Observable;

import model.db.*;
import model.domain.*;

public class Service extends Observable{

	private Categories categories;
	private Questions questions;
	
	public Service(){
		this.categories = new Categories();
		this.questions = new Questions();
	}
	
	public void addCategorie(Category category){
		this.categories.addCategory(category);
		this.setChanged();
		this.notifyObservers(this);
	}
	
	public void addQuestion(Question question) {
		this.questions.addQuestion(question);
		this.setChanged();
		this.notifyObservers(this);
	}
	
	public void deleteCategorie(Category category){
		this.categories.deleteCategory(category);
		this.setChanged();
		this.notifyObservers(this);
	}
	
	public void deleteQuestion(Question question){
		this.questions.deleteQA(question);
		this.setChanged();
		this.notifyObservers(this);
	}
	
	public ArrayList<Category> getCategories(){
		return categories.getCategories();
	}
	
	public ArrayList<Question> getQuestions(){
		return questions.getQuestions();
	}
	
}
