package model.db;

import java.util.ArrayList;
import model.domain.Category;

public class Categories {

	private ArrayList<Category> categories;

	public Categories() {
		this.categories = new ArrayList<Category>();
	}

	public void addCategory(Category category) {
		if (category == null) {
			throw new DbException("The category can not be null!");
		} else {
			for (Category cat : this.categories) {
				if (cat.getTitle().equals(category.getTitle())
						&& cat.getDescription().equals(category.getDescription())) {
					throw new DbException("This category already exists!");
				}
			}
		}
		this.categories.add(category);
	}

	public void deleteCategory(Category category){
		this.categories.remove(category.getTitle());
	}
	
	public Category getCategorie(String name){
		Category result = null;

		for(Category cat:this.categories){
			if(cat.getTitle()==name){
				result = cat;
			}
		}
		if(result ==null ){
			throw new DbException("Category was not found!");
		}else{
			return result;
		}
	}
	
	public int getSizeCategories(){
		return this.categories.size();
	}
	
	public ArrayList<Category> getCategories(){
		return categories;
	}
}
