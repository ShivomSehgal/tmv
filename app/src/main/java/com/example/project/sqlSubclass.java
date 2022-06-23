package com.example.project;

public class sqlSubclass {

    private String Query;
    private  String Answer;

    public sqlSubclass(String Query, String Answer){
        this.Query = Query;
        this.Answer = Answer;
    }

    public String getAnswer() {
        return Answer;
    }

    public String getQuery() {
        return Query;
    }
}
