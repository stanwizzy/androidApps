package com.example.stanleyopara.geoquiz;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that manages universe of questions in this application
 */
public class QuestionManager {

    /**
     * For now we are hardcoding all the questions in resources
     * Below is a list of static variable of questions stored in resources
     * TODO: Store questions and associated answers in a DB
     */
    
    private static final int USACapitalQuestion = R.string.USACapitalQuestion;
    private static final boolean USACapitalAnswer = true;

    private static final int UKCapitalQuestion = R.string.UKCapitalQuestion;
    private static final boolean UKCapitalAnswer = true;
    
    private static final int FranceCapitalQuestion = R.string.FranceCapitalQuestion;
    private static final boolean FranceCapitalAnswer = true;
    
    private static final int NigeriaCapitalQuestion = R.string.NigeriaCapitalQuestion;
    private static final boolean NigeriaCapitalAnswer = true;
    
    private static final int ChinaCapitalQuestion = R.string.ChinaCapitalQuestion;
    private static final boolean ChinaCapitalAnswer = true;
    
    public static List<TrueFalseQuestion> getAllQuestions(){
        
        List<TrueFalseQuestion> list = new ArrayList<>();
        list.add(new TrueFalseQuestion(USACapitalQuestion,USACapitalAnswer));
        list.add(new TrueFalseQuestion(UKCapitalQuestion,UKCapitalAnswer));
        list.add(new TrueFalseQuestion(FranceCapitalQuestion,FranceCapitalAnswer));
        list.add(new TrueFalseQuestion(NigeriaCapitalQuestion,NigeriaCapitalAnswer));
        list.add(new TrueFalseQuestion(ChinaCapitalQuestion,ChinaCapitalAnswer));

        return list;
    }

}
