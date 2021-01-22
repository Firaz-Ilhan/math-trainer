package org.trainer.model2;

public interface Arithmetic {

    int[] createTask();

    String renderTask();

    boolean checkSolution(int userInput);   //only in TaskBasis, not in child classes

    String getRenderedTask();   //only in TaskBasis, not in child classes

    int getSolution();  //only in TaskBasis, not in child classes
}
