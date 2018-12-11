package model.db;

import java.util.*;

import model.domain.Question;
 
public class Questions {
 
    //private ArrayList<Question> questions;
    private Map<Question, List<String>> qa;
 
    public Questions() {
        //this.questions = new ArrayList<Question>();
        this.qa = new HashMap<>();
    }

    public void addQA(Question question, String answer) { //WAS VROEGER addQuestion
        if (question == null || answer == null || answer.trim().isEmpty()) {
            throw new DbException("The answer and/or can not be empty!");
        }
        else {
            for (Question q : this.qa.keySet()) {
                if (q.getQuestion().equals(question.getQuestion()) && q.getCategoryTitle().equals(question.getCategoryTitle())) { //Als vraag bestaat
                    for (String a : this.qa.get(question)) { //Antwoorden afgaan
                        if (a.equals(answer)) { //Als antwoord al bestaat
                            throw new DbException("Answer already exists!");
                        }
                        else { //Anders toevoegen
                            this.qa.get(question).add(answer);
                        }
                    }
                }
                else { //Als vraag niet bestaat
                    List<String> answers = new ArrayList<>();
                    answers.add(answer);
                    this.qa.put(question, answers); //Vraag toevoegen
                }
            }
        }
    }
 
    public void deleteQuestion(Question question) {
        this.qa.remove(question);
    }

    public void deleteAnswer(Question question, String answer) {
        Iterator i = this.qa.get(question).iterator();

        while (i.hasNext()) {
            String a = (String)i.next();
            if (a.equals(answer)) {
                i.remove();
            }
        }
    }
 
    public Question getQuestion(String question) {
        Question result = null;

        for (Question q : this.questions) {
            if (q.getQuestion().equals(question)) {
                result = q;
            }
        }
        if (result == null) {
            throw new DbException("Question was not found!");
        } else {
            return result;
        }
    }
 
    public Set<Question> getQuestions() {
        return qa.keySet();
    }

    public List<String> getAllAnswersFromQuestion(Question question) {
        List<String> antwoorden = new ArrayList<>();

         if (qa.containsKey(question)){
             antwoorden.addAll(qa.get(question));
         }
    }

    public String getCorrectAnswer() {

    }

}