package com.company;

import java.util.Scanner;

public class Main {
        public static void printResult(Calculator calculator, Scanner scan){
            System.out.print("Результат: ");
            System.out.println(calculator.calculate());
        }

        public static Calculator menu(Scanner scan){
            System.out.println("Доступны следующие операции:");
            System.out.println("1) с одним числом");
            System.out.println("2) с двумя числами");
            System.out.print("Выберите тип операции: ");
            int choice = scan.nextInt();
            Calculator calc;
            System.out.println();
            switch (choice) {
                case (1) -> {
                    System.out.println("Доступны следующие операции:");
                    System.out.println("1) sin (синус)");
                    System.out.println("2) cos (косинус)");
                    System.out.println("3) sqrt (квадратный корень)");
                    calc = new Calculator(scan, true); //isSingle == true
                    return calc;
                }
                case (2) -> {
                    System.out.println("Доступны следующие операции:");
                    System.out.println(" + (сложение)");
                    System.out.println(" - (вычитание)");
                    System.out.println(" * (умножение)");
                    System.out.println(" / (деление)");
                    System.out.println(" % (вычисление процента)");
                    calc = new Calculator(scan, false); //isSingle == false
                    return calc;
                }
                default -> {
                    System.out.println("Некорректный ввод. Повторите ещё раз: ");
                    return menu(scan);
                }
            }
        }

        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            Calculator calculator = menu(scan);
            printResult(calculator, scan);

        }
}
