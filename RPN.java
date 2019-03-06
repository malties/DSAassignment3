package Assignments;

import java.util.Stack;
import java.util.Scanner;

class RPN {
    private Stack<String> evaluationStack = new Stack<String>();

    // Main input loop
    public void loop() {
        Scanner in = new Scanner(System.in);

        final String prompt = "> ";
        System.out.print(prompt);

        while (in.hasNext()) {
            String s = in.next();
            if (s.equals("quit") || s.equals("q")) {
                System.out.println("Quitting");
                break;
            }
            System.out.println("Got a string: " + s);
            addToken(s);
            evaluate();
            System.out.print(prompt);
        }
        in.close();
    }

    // Evaluate the stack and push the result back in the same stack
    public void evaluate() {

        if (evaluationStack.lastElement().equals("+")){
            evaluationStack.pop();
            int num1 = Integer.parseInt(evaluationStack.pop());
            int num2 = Integer.parseInt(evaluationStack.pop());
            int num3 = num2 + num1;
            evaluationStack.push(Integer.toString(num3));
            System.out.println(getEvaluationStack());
        }else if(evaluationStack.lastElement().equals("-")){
            evaluationStack.pop();
            int num1 = Integer.parseInt(evaluationStack.pop());
            int num2 = Integer.parseInt(evaluationStack.pop());
            int num3 = num2-num1;
            evaluationStack.push(Integer.toString(num3));
            System.out.println(getEvaluationStack());
        }else if (evaluationStack.lastElement().equals("*")){
            evaluationStack.pop();
            int num1 = Integer.parseInt(evaluationStack.pop());
            int num2 = Integer.parseInt(evaluationStack.pop());
            int num3 = num2 * num1;
            evaluationStack.push(Integer.toString(num3));
            System.out.println(getEvaluationStack());
        }else if (evaluationStack.lastElement().equals("/")){
            evaluationStack.pop();
            int num1 = Integer.parseInt(evaluationStack.pop());
            int num2 = Integer.parseInt(evaluationStack.pop());
            int num3 = num2/num1;
            evaluationStack.push(Integer.toString(num3));
            System.out.println(getEvaluationStack());
        }else{
            System.out.println(getEvaluationStack());
        }
    }

    // To visualise the token stack
    public String toString() {
        StringBuilder res = new StringBuilder();
        return res.toString();
    }

    // For unit test purposes
    public void addToken(String token) {
        evaluationStack.add(token);
    }

    // For unit test purposes
    public Stack<String> getEvaluationStack() {
        Stack<String> copy = new Stack<String>();
        copy.addAll(evaluationStack);
        return copy;
    }


    public static void main(String[] args) {
        RPN calc = new RPN();
        calc.loop();
    }
}
