package Calc.Model;

import java.util.Stack;

public class CalcModel {

    private Stack<Integer> numbers;
    private Stack<String> operators;
    private Stack<String> text;

    public CalcModel(){
        numbers=new Stack<>();
        operators=new Stack<>();
        text=new Stack<>();
    }

    public void addNumber(int num){
        numbers.add(num);
        addText(Double.toString(num));
    }

    public void addOperator(String op){
        operators.add(op);
        addText(op);
    }

    public void addText(String txt){
        text.add(txt);
    }

    public double CalculateResult(){
        double first;
        double last;
        double result = 0;
        String op;
        while (!operators.isEmpty()){

            op= operators.pop();
            switch (op){
                case "+": {
                    last=numbers.pop();
                    first=numbers.pop();
                    result += first + last;
                    break;
                }case "-": {
                    last=numbers.pop();
                    first=numbers.pop();
                    result += first - last;
                    break;
                }case "/'": {
                    last=numbers.pop();
                    first=numbers.pop();
                    result += first % last;
                    break;
                }case "÷": {
                    last=numbers.pop();
                    first=numbers.pop();
                    result+=first / last;
                    break;
                }case "x": {
                    last=numbers.pop();
                    first=numbers.pop();
                    result += first * last;
                    break;
                }case "sin":{
                    last=numbers.pop();
                    result +=Math.sin(last);
                    break;
                }case "tan":{
                    last=numbers.pop();
                    result +=Math.tan(last);
                    break;
                }case "log":{
                    last=numbers.pop();
                    result +=Math.log10(last);
                    break;
                } case "":{

                }
            }
        }

        return result;
    }

    public Stack<String> getText() {
        return text;
    }

    public Stack<Integer> getNumbers() {
        return numbers;
    }

    public Stack<String> getOperators() {
        return operators;
    }

//    public void clearText(){
//        text.removeAllElements();
//    }

}
