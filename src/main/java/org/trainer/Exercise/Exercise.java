package org.trainer.Exercise;

public class Exercise {
    public String level;
    private int result;


    public String question(){
        return "Something went wrong";
    }

    public String isTrue(int userInput){
        if(result == userInput){return "\u2713";}
        else return "\033[31mX  \033[0m";

    }


    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

/*
        public Exercise(String level){
            this.level = level;
        }
    */
}
