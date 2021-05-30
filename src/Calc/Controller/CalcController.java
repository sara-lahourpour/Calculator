package Calc.Controller;

import Calc.Model.CalcModel;
import Calc.View.CalcView;

public class CalcController {

    private CalcModel calcModel;
    private CalcView calView;

    public CalcController(CalcModel calcModel,CalcView calcView){
        this.calcModel=calcModel;
        this.calView=calcView;
        initView();
    }

    public void addNum(int num){
        calcModel.addNumber(num);
    }

    public void addOp(String op){
        calcModel.addOperator(op);
    }

    public void addTxt(String text){
        calcModel.addText(text);
    }

    public String getResult(){
        return Double.toString(calcModel.CalculateResult());
    }

    public String getScreen(){
        String strTxt="";
        for (String string: calcModel.getText()) {
            strTxt=strTxt+string;
        }
        return strTxt;
    }

    public void clear(){
        clearScreen();
        clearNumbers();
        clearOperators();
    }

    public void clearNumbers(){
        calcModel.getNumbers().removeAllElements();
    }

    public void clearOperators(){
        calcModel.getOperators().removeAllElements();
    }

    public void clearScreen(){
        calcModel.getText().removeAllElements();
    }

    private void initView() {
        calView.setController(this);
    }
}
