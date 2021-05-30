package Calc.View;


import Calc.Controller.CalcController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CalcView {


    private CalcController calcController;


    JFrame frame;
    JTabbedPane tabs;


//  -------------------------------------------
//          standard panel and its buttons
//  -------------------------------------------

    // standard panel
    JPanel standardPanel;
    JTextField screenFieldA;
    JPanel ordinaryPanelA;

    // button numbers
    JButton oneA;
    JButton twoA;
    JButton threeA;
    JButton fourA;
    JButton fiveA;
    JButton sixA;
    JButton sevenA;
    JButton eightA;
    JButton nineA;
    JButton zeroA;

    // button operators
    JButton dotA;
    JButton equalA;
    JButton sumA;
    JButton subA;
    JButton mulA;
    JButton divideA;
    JButton remA;
    JButton openParenthesesA;
    JButton closeParenthesesA;
    JButton clearA;


//  ---------------------------------------------
//          scientific panel and its buttons
//  ---------------------------------------------

    // scientific panel
    JPanel scientificPanel;
    JTextField screenFieldB;
    JPanel ordinaryPanelB;
    JPanel specialPanelB;
    int counterShift;

    // button numbers
    JButton oneB;
    JButton twoB;
    JButton threeB;
    JButton fourB;
    JButton fiveB;
    JButton sixB;
    JButton sevenB;
    JButton eightB;
    JButton nineB;
    JButton zeroB;

    // button operators
    JButton dotB;
    JButton equalB;
    JButton sumB;
    JButton subB;
    JButton mulB;
    JButton divideB;
    JButton remB;
    JButton openParenthesesB;
    JButton closeParenthesesB;
    JButton clearB;

    // special button operators
    JButton shiftB;
    JButton sinB;
    JButton cosB;
    JButton tanB;
    JButton cotB;
    JButton logB;
    JButton expB;
    JButton piB;
    JButton eulerB;

    public CalcView() {
        //----------------------------
        //      set the frame
        //-----------------------------
        frame = new JFrame();
        frame.setTitle("AUT Calculator");
        frame.setLocation(500, 300);
        frame.setLayout(new BorderLayout());
        frame.setSize(650, 500);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        frame.setBackground(Color.orange);

        tabs = new JTabbedPane();
        tabs.setSize(500,500);
//        tabs.setPreferredSize(new Dimension(300, 200));
        frame.getContentPane().add(tabs);

//        //-----------------------------
//        //      set the text field
//        //-----------------------------
//        setScreenField();


        //------------------------------------
        //      set the standard calculator
        //------------------------------------
        standardPanel = new JPanel();
//        standardPanel.setSize(300,300);
        standardPanel.setLayout(new GridBagLayout());
        ordinaryPanelA=new JPanel();
//        ordinaryPanelA.setSize(300,300);
        ordinaryPanelA.setLayout(new GridLayout(5,4,5,5));
        setStandardPanel();


        //------------------------------------
        //      set the scientific calculator
        //------------------------------------
        scientificPanel = new JPanel();
        scientificPanel.setLayout(new GridBagLayout());
        ordinaryPanelB=new JPanel();
        ordinaryPanelB.setLayout(new GridLayout(5,4,5,5));
        specialPanelB=new JPanel();
        specialPanelB.setLayout(new GridLayout(5,1,5,5));
        setScientificPanel();

        //--------------------------------------------------------------------
        //      add panels to tab , set tab placement and show the calculator
        //--------------------------------------------------------------------
        tabs.add("Standard", standardPanel);
        tabs.add("Scientific", scientificPanel);
        tabs.setTabPlacement(JTabbedPane.BOTTOM);
        showCalculator();
//        tabs.add(scientificPanel,"<html>Scientific</html>");
//        tabs.setEnabledAt(2, false);
//        tabs.setTitleAt(1, "<html><font color="
//                + (tabs.isEnabledAt(1) ? "black" : "red") + ">"
//                + tabs.getTitleAt(1) + "</font></html>");

//        tabs.setEnabledAt(2, false);

//        frame.getContentPane().add(tabs);


    }


    /**
     *
     * set the screen field of standard calculator
     *
     */
    public void setScreenFieldA() {

        screenFieldA = new JTextField();
        screenFieldA.setEditable(false);
        screenFieldA.setSize(5, 5);
        JScrollPane scrollableTextArea = new JScrollPane(screenFieldA);
//        frame.add(screenFieldA, BorderLayout.NORTH);
    }



    /**
     *
     *  set the screen field of scientific calculator
     *
     */
    public void setScreenFieldB(){
        screenFieldB=new JTextField();
        screenFieldB.setEditable(false);
        screenFieldB.setSize(5, 5);
        JScrollPane scrollableTextArea = new JScrollPane(screenFieldB);

    }


    /**
     *
     * set Ordinary panel for
     * standard panel
     *
     */
    private void setOrdinaryPanelA(){


        ButtonClickHandler buttonHandler=new ButtonClickHandler();
        MouseClickHandler mouseHandler =new MouseClickHandler();

        openParenthesesA = new JButton("(");
//        openParenthesesA.setSize(10,10);
        openParenthesesA.setToolTipText("Open Parentheses");
//        openParenthesesA.setBackground(Color.DARK_GRAY);
//        openParenthesesA.setOpaque(true);
        openParenthesesA.addActionListener(buttonHandler);
        openParenthesesA.addMouseListener(mouseHandler);
        ordinaryPanelA.add(openParenthesesA);

        closeParenthesesA = new JButton(")");
        closeParenthesesA.setToolTipText("Close Parentheses");
//        closeParenthesesA.setBackground(Color.DARK_GRAY);
//        closeParenthesesA.setForeground(Color.gray);
//        closeParenthesesA.setOpaque(true);
//        closeParenthesesA.setBorderPainted(false);
        closeParenthesesA.addActionListener(buttonHandler);
        closeParenthesesA.addMouseListener(mouseHandler);
        ordinaryPanelA.add(closeParenthesesA);

        remA = new JButton("rem");
        remA.setToolTipText("Remaining");
//        remA.setBackground(Color.DARK_GRAY);
//        remA.setOpaque(true);
        remA.addActionListener(buttonHandler);
        remA.addMouseListener(mouseHandler);
        ordinaryPanelA.add(remA);

        clearA = new JButton("C");
        clearA.setToolTipText("Clear");
        clearA.setBackground(Color.ORANGE);
        clearA.setOpaque(true);
        clearA.setBorderPainted(false);
        clearA.addActionListener(buttonHandler);
        clearA.addMouseListener(mouseHandler);
        ordinaryPanelA.add(clearA);


        oneA = new JButton("1");
        oneA.setToolTipText("Number 1");
        oneA.addActionListener(buttonHandler);
        oneA.addMouseListener(mouseHandler);
        ordinaryPanelA.add(oneA);

        twoA = new JButton("2");
        twoA.setToolTipText("Number 2");
        twoA.addActionListener(buttonHandler);
        twoA.addMouseListener(mouseHandler);
        ordinaryPanelA.add(twoA);

        threeA = new JButton("3");
        threeA.setToolTipText("Number 3");
        threeA.addActionListener(buttonHandler);
        threeA.addMouseListener(mouseHandler);
        ordinaryPanelA.add(threeA);

        divideA = new JButton("÷");
        divideA.setToolTipText("Division");
        divideA.addActionListener(buttonHandler);
        divideA.addMouseListener(mouseHandler);
        ordinaryPanelA.add(divideA);

        fourA = new JButton("4");
        fourA.setToolTipText("Number 4");
        fourA.addActionListener(buttonHandler);
        fourA.addMouseListener(mouseHandler);
        ordinaryPanelA.add(fourA);

        fiveA = new JButton("5");
        fiveA.setToolTipText("Number 5");
        fiveA.addActionListener(buttonHandler);
        fiveA.addMouseListener(mouseHandler);
        ordinaryPanelA.add(fiveA);

        sixA = new JButton("6");
        sixA.setToolTipText("Number 6");
        sixA.addActionListener(buttonHandler);
        sixA.addMouseListener(mouseHandler);
        ordinaryPanelA.add(sixA);

        mulA = new JButton("x");
        mulA.setToolTipText("Multiply");
        mulA.addActionListener(buttonHandler);
        mulA.addMouseListener(mouseHandler);
        ordinaryPanelA.add(mulA);

        sevenA = new JButton("7");
        sevenA.setToolTipText("Number 7");
        sevenA.addActionListener(buttonHandler);
        sevenA.addMouseListener(mouseHandler);
        ordinaryPanelA.add(sevenA);

        eightA = new JButton("8");
        eightA.setToolTipText("Number 8");
        eightA.addActionListener(buttonHandler);
        eightA.addMouseListener(mouseHandler);
        ordinaryPanelA.add(eightA);

        nineA = new JButton("9");
        nineA.setToolTipText("Number 9");
//        nineA.setBackground(Color.DARK_GRAY);
//        nineA.setOpaque(true);
//        nineA.setBorderPainted(false);
        nineA.addActionListener(buttonHandler);
        nineA.addMouseListener(mouseHandler);
        ordinaryPanelA.add(nineA);

        subA = new JButton("-");
        subA.setToolTipText("subtract");
        subA.addActionListener(buttonHandler);
        subA.addMouseListener(mouseHandler);
        ordinaryPanelA.add(subA);

        zeroA = new JButton("0");
        zeroA.setToolTipText("Number 0");
        zeroA.addActionListener(buttonHandler);
        zeroA.addMouseListener(mouseHandler);
        ordinaryPanelA.add(zeroA);

        dotA = new JButton(".");
        dotA.setToolTipText("Dot");
        dotA.addActionListener(buttonHandler);
        dotA.addMouseListener(mouseHandler);
        ordinaryPanelA.add(dotA);

        equalA = new JButton("=");
        equalA.setToolTipText("Equal");
        equalA.addActionListener(buttonHandler);
        equalA.addMouseListener(mouseHandler);
        ordinaryPanelA.add(equalA);

        sumA = new JButton("+");
        sumA.setToolTipText("Summation");
//        sumA.setBackground(Color.ORANGE);
//        sumA.setOpaque(true);
//        sumA.setBorderPainted(false);
        sumA.addActionListener(buttonHandler);
        sumA.addMouseListener(mouseHandler);
        ordinaryPanelA.add(sumA);


    }


    /**
     *
     *  set ordinary panel for scientific panel
     *
     */
    public void setOrdinaryPanelB(){

        ButtonClickHandler buttonHandler=new ButtonClickHandler();
        MouseClickHandler mouseHandler =new MouseClickHandler();

        openParenthesesB = new JButton("(");
//        openParenthesesA.setSize(10,10);
        openParenthesesB.setToolTipText("Open Parentheses");
//        openParenthesesA.setBackground(Color.DARK_GRAY);
//        openParenthesesA.setOpaque(true);
        openParenthesesB.addActionListener(buttonHandler);
        openParenthesesB.addMouseListener(mouseHandler);
        ordinaryPanelB.add(openParenthesesB);

        closeParenthesesB = new JButton(")");
        closeParenthesesB.setToolTipText("Close Parentheses");
//        closeParenthesesB.setBackground(Color.DARK_GRAY);
//        closeParenthesesB.setForeground(Color.gray);
//        closeParenthesesB.setOpaque(true);
//        closeParenthesesB.setBorderPainted(false);
        closeParenthesesB.addActionListener(buttonHandler);
        closeParenthesesB.addMouseListener(mouseHandler);
        ordinaryPanelB.add(closeParenthesesB);

        remB = new JButton("rem");
        remB.setToolTipText("Remaining");
//        remA.setBackground(Color.DARK_GRAY);
//        remA.setOpaque(true);
        remB.addActionListener(buttonHandler);
        remB.addMouseListener(mouseHandler);
        ordinaryPanelB.add(remB);

        clearB = new JButton("C");
        clearB.setToolTipText("Clear");
        clearB.setBackground(Color.ORANGE);
        clearB.setOpaque(true);
        clearB.setBorderPainted(false);
        clearB.addActionListener(buttonHandler);
        clearB.addMouseListener(mouseHandler);
        ordinaryPanelB.add(clearB);


        oneB = new JButton("1");
        oneB.setToolTipText("Number 1");
        oneB.addActionListener(buttonHandler);
        oneB.addMouseListener(mouseHandler);
        ordinaryPanelB.add(oneB);

        twoB = new JButton("2");
        twoB.setToolTipText("Number 2");
        twoB.addActionListener(buttonHandler);
        twoB.addMouseListener(mouseHandler);
        ordinaryPanelB.add(twoB);

        threeB = new JButton("3");
        threeB.setToolTipText("Number 3");
        threeB.addActionListener(buttonHandler);
        threeB.addMouseListener(mouseHandler);
        ordinaryPanelB.add(threeB);

        divideB = new JButton("÷");
        divideB.setToolTipText("Division");
        divideB.addActionListener(buttonHandler);
        divideB.addMouseListener(mouseHandler);
        ordinaryPanelB.add(divideB);

        fourB = new JButton("4");
        fourB.setToolTipText("Number 4");
        fourB.addActionListener(buttonHandler);
        fourB.addMouseListener(mouseHandler);
        ordinaryPanelB.add(fourB);

        fiveB = new JButton("5");
        fiveB.setToolTipText("Number 5");
        fiveB.addActionListener(buttonHandler);
        fiveB.addMouseListener(mouseHandler);
        ordinaryPanelB.add(fiveB);

        sixB = new JButton("6");
        sixB.setToolTipText("Number 6");
        sixB.addActionListener(buttonHandler);
        sixB.addMouseListener(mouseHandler);
        ordinaryPanelB.add(sixB);

        mulB = new JButton("x");
        mulB.setToolTipText("Multiply");
        mulB.addActionListener(buttonHandler);
        mulB.addMouseListener(mouseHandler);
        ordinaryPanelB.add(mulB);

        sevenB = new JButton("7");
        sevenB.setToolTipText("Number 7");
        sevenB.addActionListener(buttonHandler);
        sevenB.addMouseListener(mouseHandler);
        ordinaryPanelB.add(sevenB);

        eightB = new JButton("8");
        eightB.setToolTipText("Number 8");
        eightB.addActionListener(buttonHandler);
        eightB.addMouseListener(mouseHandler);
        ordinaryPanelB.add(eightB);

        nineB = new JButton("9");
        nineB.setToolTipText("Number 9");
//        nineB.setBackground(Color.DARK_GRAY);
//        nineB.setOpaque(true);
//        nineB.setBorderPainted(false);
        nineB.addActionListener(buttonHandler);
        nineB.addMouseListener(mouseHandler);
        ordinaryPanelB.add(nineB);

        subB = new JButton("-");
        subB.setToolTipText("subtract");
        subB.addActionListener(buttonHandler);
        subB.addMouseListener(mouseHandler);
        ordinaryPanelB.add(subB);

        zeroB = new JButton("0");
        zeroB.setToolTipText("Number 0");
        zeroB.addActionListener(buttonHandler);
        zeroB.addMouseListener(mouseHandler);
        ordinaryPanelB.add(zeroB);

        dotB = new JButton(".");
        dotB.setToolTipText("Dot");
        dotB.addActionListener(buttonHandler);
        dotB.addMouseListener(mouseHandler);
        ordinaryPanelB.add(dotB);

        equalB = new JButton("=");
        equalB.setToolTipText("Equal");
        equalB.addActionListener(buttonHandler);
        equalB.addMouseListener(mouseHandler);
        ordinaryPanelB.add(equalB);

        sumB = new JButton("+");
        sumB.setToolTipText("Summation");
//        sumB.setBackground(Color.ORANGE);
//        sumB.setOpaque(true);
//        sumB.setBorderPainted(false);
        sumB.addActionListener(buttonHandler);
        sumB.addMouseListener(mouseHandler);
        ordinaryPanelB.add(sumB);

    }


    /**
     *
     *  set special panel for scientific calculator
     *
     */
    private void setSpecialKeyboard(){


        ButtonClickHandler buttonHandler=new ButtonClickHandler();
        MouseClickHandler mouseHandler=new MouseClickHandler();

        shiftB = new JButton("SHIFT");
        shiftB.setToolTipText("Shift");
        shiftB.setBackground(Color.ORANGE);
        shiftB.setOpaque(true);
        shiftB.setBorderPainted(false);
        shiftB.addActionListener(buttonHandler);
        shiftB.addMouseListener(mouseHandler);
        specialPanelB.add(shiftB);

        sinB = new JButton("sin");
        sinB.setToolTipText("Sine");
//        sinB.setBackground(Color.ORANGE);
//        sinB.setOpaque(true);
//        sinB.setBorderPainted(false);
        sinB.addActionListener(buttonHandler);
        sinB.addMouseListener(mouseHandler);
        specialPanelB.add(sinB);



        tanB = new JButton("tan");
        tanB.setToolTipText("Tangent");
        tanB.addActionListener(buttonHandler);
        tanB.addMouseListener(mouseHandler);
        specialPanelB.add(tanB);


        logB = new JButton("log");
        logB.setToolTipText("Logarithm of Base 10");
        logB.addActionListener(buttonHandler);
        logB.addMouseListener(mouseHandler);
        specialPanelB.add(logB);


        piB = new JButton("π");
        piB.setToolTipText("PI(3.14159...)");
        piB.addActionListener(buttonHandler);
        piB.addMouseListener(mouseHandler);
        specialPanelB.add(piB);


    }


    /**
     *
     * set the Standard mode to calculator
     * which includes ordinary panelA and screen fieldA
     *
     */
    public void setStandardPanel() {


        setOrdinaryPanelA();
        setScreenFieldA();
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx=0;
        gbc.gridy=0;
        gbc.gridwidth=400;
        gbc.ipadx=600;
        gbc.ipady=40;
        standardPanel.add(screenFieldA,gbc);
        gbc.fill = GridBagConstraints.HORIZONTAL;


        gbc.gridx=0;
        gbc.gridy=20;
        gbc.gridwidth=10;
        gbc.ipadx=300;
        gbc.ipady=200;
        standardPanel.add(ordinaryPanelA,gbc);
        gbc.fill = GridBagConstraints.HORIZONTAL;




    }


    /**
     *
     * set the scientific calculator
     * which includes :
     *
     * ordinary panelB,
     * special panel,
     * screen fieldB,
     *
     */
    public void setScientificPanel() {

        setScreenFieldB();
        setOrdinaryPanelB();
        setSpecialKeyboard();
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx=0;
        gbc.gridy=0;
        gbc.gridwidth=300;
        gbc.ipadx=600;
        gbc.ipady=40;
        scientificPanel.add(screenFieldB,gbc);
        gbc.fill = GridBagConstraints.HORIZONTAL;


        gbc.gridx=0;
        gbc.gridy=20;
        gbc.gridwidth=100;
        gbc.ipadx=160;
        gbc.ipady=200;
        scientificPanel.add(ordinaryPanelB,gbc);
        gbc.fill = GridBagConstraints.HORIZONTAL;


        gbc.gridx=100;
        gbc.gridy=20;
        gbc.gridwidth=100;
        gbc.ipadx=50;
        gbc.ipady=200;
        scientificPanel.add(specialPanelB,gbc);
        gbc.fill = GridBagConstraints.HORIZONTAL;


    }


    /**
     *
     * @param c controller
     */
    public void setController(CalcController c) {
        this.calcController=c;
    }

    /**
     *
     * making the calculator visible
     * by using the setVisible method
     *
     */
    public void showCalculator() {
        frame.repaint();
        frame.revalidate();
        frame.setVisible(true);
    }

    /**
     *
     * calculator's event handling
     */
    private class ButtonClickHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource().equals(oneA) || e.getSource().equals(oneB)){
                calcController.addNum(1);
                screenFieldA.setText(calcController.getScreen());
                screenFieldB.setText(calcController.getScreen());
                showCalculator();

            }
            else if(e.getSource().equals(twoA) || e.getSource().equals(twoB)){
                calcController.addNum(2);
                screenFieldA.setText(calcController.getScreen());
                screenFieldB.setText(calcController.getScreen());
                showCalculator();

            }
            else if (e.getSource().equals(threeA) ||e.getSource().equals(threeB)){
                calcController.addNum(3);
                screenFieldA.setText(calcController.getScreen());
                screenFieldB.setText(calcController.getScreen());
                showCalculator();

            }
            else if (e.getSource().equals(fourA) || e.getSource().equals(fourB)){
                calcController.addNum(4);
                screenFieldA.setText(calcController.getScreen());
                screenFieldB.setText(calcController.getScreen());
                showCalculator();

            }
            else if (e.getSource().equals(fiveA) || e.getSource().equals(fiveB)){
                calcController.addNum(5);
                screenFieldA.setText(calcController.getScreen());
                screenFieldB.setText(calcController.getScreen());
                showCalculator();

            }
            else if (e.getSource().equals(sixA) || e.getSource().equals(sixB)){
                calcController.addNum(6);
                screenFieldA.setText(calcController.getScreen());
                screenFieldB.setText(calcController.getScreen());
                showCalculator();

            }
            else if (e.getSource().equals(sevenA) || e.getSource().equals(sevenB)){
                calcController.addNum(7);
                screenFieldA.setText(calcController.getScreen());
                screenFieldB.setText(calcController.getScreen());
                showCalculator();

            }
            else if (e.getSource().equals(eightA) || e.getSource().equals(eightB)){
                calcController.addNum(8);
                screenFieldA.setText(calcController.getScreen());
                screenFieldB.setText(calcController.getScreen());
                showCalculator();

            }
            else if (e.getSource().equals(nineA) || e.getSource().equals(nineB)){
                calcController.addNum(9);
                screenFieldA.setText(calcController.getScreen());
                screenFieldB.setText(calcController.getScreen());
                showCalculator();

            }
            else if (e.getSource().equals(zeroA) || e.getSource().equals(zeroB)){
                calcController.addNum(0);
                screenFieldA.setText(calcController.getScreen());
                screenFieldB.setText(calcController.getScreen());
                showCalculator();

            }
            else if (e.getSource().equals(sumA) || e.getSource().equals(sumB)){
                calcController.addOp("+");
                screenFieldA.setText(calcController.getScreen());
                screenFieldB.setText(calcController.getScreen());
                showCalculator();

            }
            else if (e.getSource().equals(subA) || e.getSource().equals(subB)){
                calcController.addOp("-");
                screenFieldA.setText(calcController.getScreen());
                screenFieldB.setText(calcController.getScreen());
                showCalculator();

            }
            else if (e.getSource().equals(remA) || e.getSource().equals(remB)){
                calcController.addOp("/");
                screenFieldA.setText(calcController.getScreen());
                screenFieldB.setText(calcController.getScreen());
                showCalculator();


            }
            else if (e.getSource().equals(divideA) || e.getSource().equals(divideB)){
                calcController.addOp("÷");
                screenFieldA.setText(calcController.getScreen());
                screenFieldB.setText(calcController.getScreen());
                showCalculator();


            }
            else if (e.getSource().equals(mulA) || e.getSource().equals(mulB)){
                calcController.addOp("x");
                screenFieldA.setText(calcController.getScreen());
                screenFieldB.setText(calcController.getScreen());
                showCalculator();


            }
            else if (e.getSource().equals(openParenthesesA) || e.getSource().equals(openParenthesesB)){
                calcController.addOp("(");
                screenFieldA.setText(calcController.getScreen());
                screenFieldB.setText(calcController.getScreen());
                showCalculator();


            }
            else if (e.getSource().equals(closeParenthesesA) || e.getSource().equals(closeParenthesesB)){
                calcController.addOp(")");
                screenFieldA.setText(calcController.getScreen());
                screenFieldB.setText(calcController.getScreen());
                showCalculator();


            }
            else if (e.getSource().equals(sinB)){
                calcController.addOp("sin");
                screenFieldA.setText(calcController.getScreen());
                screenFieldB.setText(calcController.getScreen());
                showCalculator();

            }
            else if (e.getSource().equals(cosB)){
                calcController.addOp("cos");
                screenFieldA.setText(calcController.getScreen());
                screenFieldB.setText(calcController.getScreen());
                showCalculator();

            }
            else if (e.getSource().equals(tanB)){
                calcController.addOp("tan");
                screenFieldA.setText(calcController.getScreen());
                screenFieldB.setText(calcController.getScreen());
                showCalculator();

            }
            else if (e.getSource().equals(cotB)){
                calcController.addOp("cot");
                screenFieldA.setText(calcController.getScreen());
                screenFieldB.setText(calcController.getScreen());
                showCalculator();

            }
            else if (e.getSource().equals(logB)){
                calcController.addOp("log");
                screenFieldA.setText(calcController.getScreen());
                screenFieldB.setText(calcController.getScreen());
                showCalculator();

            }
            else if (e.getSource().equals(expB)){
                calcController.addOp("x^y");
                screenFieldA.setText(calcController.getScreen());
                screenFieldB.setText(calcController.getScreen());
                showCalculator();

            }
            else if (e.getSource().equals(piB)){
                calcController.addOp("pi");
                screenFieldA.setText(calcController.getScreen());
                screenFieldB.setText(calcController.getScreen());
                showCalculator();

            }
            else if (e.getSource().equals(eulerB)){
                calcController.addOp("euler");
                screenFieldA.setText(calcController.getScreen());
                screenFieldB.setText(calcController.getScreen());
                showCalculator();

            }
            else if (e.getSource().equals(equalA) || e.getSource().equals(equalB)){

                screenFieldA.setText(calcController.getScreen() + " = " + calcController.getResult());
                screenFieldB.setText(calcController.getScreen() + " = " + calcController.getResult());
                showCalculator();

            }
            else if (e.getSource().equals(clearA) || e.getSource().equals(clearB)){
                calcController.clear();
                screenFieldA.setText(calcController.getScreen());
                screenFieldB.setText(calcController.getScreen());
                showCalculator();

            }
            else if (e.getSource().equals(shiftB)){
                counterShift++;
                if (counterShift%2==0){
                    sinB.setText("cos");
                    sinB.setToolTipText("Cosine");
                    tanB.setText("cot");
                    tanB.setToolTipText("Cotangent");
                    logB.setText("x^y");
                    logB.setToolTipText("x to the power of y");
                    piB.setText("e");
                    piB.setToolTipText("euler(2.71828...)");
                }
                else {
                    sinB.setText("sin");
                    sinB.setToolTipText("Sine");
                    tanB.setText("tan");
                    tanB.setToolTipText("Tangent");
                    logB.setText("log");
                    logB.setToolTipText("Logarithm of Base 10");
                    piB.setText("π");
                    piB.setToolTipText("PI(3.14159...)");
                }
                showCalculator();

            }
        }
    }

    /**
     *
     * calculator's mouse handler
     */
    private class MouseClickHandler extends MouseAdapter{

        @Override
        public void mouseClicked(MouseEvent e) {

        }
    }

}
