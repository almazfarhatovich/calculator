package com.company;

import java.util.Scanner;

public class Calculator {
    private DataSet data;
    private SingleDataSet singleData;
    private final Scanner scanner;
    private boolean isSingleDataSet;

    public Calculator(Scanner scan, boolean isSingle){
        scanner = scan;
        isSingleDataSet = isSingle;
        if (isSingleDataSet){
            singleData = new SingleDataSet(scanner);
            data = null;
        } else {
            data = new DataSet(scanner);
            singleData = null;
        }
    }

    public Calculator(DataSet newData){
        scanner = newData.getScanner();
        data = newData;
    }


    public double newCalculation(){
        System.out.println("Неверная операция. Повторите ввод. ");
        if (isSingleDataSet){
            singleData = new SingleDataSet(scanner);
        } else {
            data = new DataSet(scanner);
        }
        return calculate();
    }

    public double calculate(){
        if (isSingleDataSet && singleData.isOperationWrong() || !isSingleDataSet && data.isOperationWrong()){
            return newCalculation();
        } else {
            if (isSingleDataSet){
                double num1 = singleData.getNum1();
                return switch (singleData.getOperation()) {
                    case ('1') -> // sin
                            Math.sin(num1);
                    case ('2') -> // cos
                            Math.cos(num1);
                    case ('3') -> // sqrt
                            Math.sqrt(num1);
                    default -> newCalculation();
                };

            } else {
                double num1 = data.getNum1();
                double num2 = data.getNum2();
                return switch (data.getOperation()) {
                    case ('+') -> num1 + num2;
                    case ('-') -> num1 - num2;
                    case ('*') -> num1 * num2;
                    case ('/') -> num1 / num2;
                    case ('%') -> num1 * num2 / 100;
                    default -> newCalculation();
                };
            }
        }
    }
}
