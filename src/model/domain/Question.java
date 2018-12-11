package model.domain;

public class Question {
	
	private String question;
	private String categoryTitle;
	
	public Question(String question, String categoryTitle) {
		setQuestion(question);
		setCategoryTitle(categoryTitle);
	}

	public String getQuestion() { return question; }
	
	public String getCategoryTitle() {
		return categoryTitle;
	}

	public void setQuestion(String question) {
		if (question == null || question.trim().isEmpty()) {
			throw new DomainException("Question can not be empty!");
		}
		this.question = question;
	}

	public void setCategoryTitle(String categoryTitle) {
		if (categoryTitle == null || categoryTitle.trim().isEmpty()) {
			throw new DomainException("Category can not be empty!");
		}
		this.categoryTitle = categoryTitle;
	}
}