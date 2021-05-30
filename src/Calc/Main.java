package Calc;


import Calc.Controller.CalcController;
import Calc.Model.CalcModel;
import Calc.View.CalcView;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        //---------------------------
        //      some experience
        //---------------------------


        //if i set the look & feel to Nimbus i can't set the tabbedPane in vertical order
        //but i do not have such a problem in other look and feels


        //----------------------------------------------------------
        //      how to know what look and feel do we have
        //----------------------------------------------------------

//        for (UIManager.LookAndFeelInfo info: UIManager.getInstalledLookAndFeels()) {
//            System.out.println(info.getClassName());
//        }
//
//        System.out.println("\n\n\n\n");
//
//

        //----------------------------------------------------------
        //      what is the default system look and feel
        //----------------------------------------------------------

//        System.out.println(UIManager.getSystemLookAndFeelClassName());


        try {

            //------------------------------------------
            //      set Look & Feel -----> Nimbus
            //------------------------------------------


            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
//            UIManager.setLookAndFeel(
//                    UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

        CalcView calcView = new CalcView();
        CalcModel calcModel=new CalcModel();
        CalcController calcController=new CalcController(calcModel,calcView);

    }
}
