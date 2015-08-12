package com.example.stanleyopara.geoquiz;

/**
 * SImple Model Class that encapsulates geo questions
 */
public class TrueFalseQuestion {

    /**Variable that stores resource id of question string */
    private int id;

    /**Variable that stores true or false answer to question */
    private boolean answer;

    public TrueFalseQuestion(int id, boolean answer){
        this.id = id;
        this.answer = answer;
    }

    public int getId() {
        return id;
    }

    public boolean isAnswer() {
        return answer;
    }
}
