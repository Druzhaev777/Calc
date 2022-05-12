package com.company;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String inputString;
        Pattern p = Pattern.compile("([+]|-|[*]|/|^|%)");
        //шаблон для регулярного выражения.
        Matcher m;
        //их поиск
        double result = 0;
        System.out.println("введите, пожуй лыста вот так - '2 + 3' или '+ 3' без кавычек: ");
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                if (scanner.hasNextLine()) {
                    inputString = scanner.nextLine();
                    m = p.matcher(inputString);
                    if (m.find()) {
                        result = calculate(inputString.split("\\s+"), result);
                        System.out.println(result);
                    } else {
                        System.out.println("Непральна дядя Фёдор!");
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("surprise mother****er");
            e.printStackTrace();
        }
    }

    private static double calculate(String[] split, double previousResult) throws Exception {
        double result;
        String operand;
        double number1;
        double number2;
        if (split.length == 3) {
            number1 = Double.parseDouble(split[0]);
            operand = split[1];
            number2 = Double.parseDouble(split[2]);
        } else if (split.length == 2) {
            number1 = previousResult;
            operand = split[0];
            number2 = Double.parseDouble(split[1]);
        } else {
            throw new Exception("Всё фигня, давай по новой !");
        }
        switch (operand) {
            case "+":
                result = number1 + number2;
                break;
            case "-":
                result = number1 - number2;
                break;
            case "*":
                result = number1 * number2;
                break;
            case "/":
                result = number1 / number2;
                break;
            case "^":
                result = Math.pow(number1, number2);
                break;
            case "%":
                result = number1 % number2;
                break;
            default:
                throw new Exception("Ну будь человеком!");
        }
        return result;
    }
}


/*
 *метод возвращает  результат математического выражения обработанного блоке switch case, в котором находится одно
 * значение, с которым сравнивается значение переменной,и инструкция в виде программного кода
 *
 * @param split делит строку на подстроки с помощью регулярного выражения
 * @param previousResult предыдущий результат
 * @return результат математичеких выражений
 * @throws Exception предупреждяет об исключении
 * Метод parse используется для извлечения из строки числового значения необходимого типа
 * switch case-это блок, в котором находится одно значение, с которым сравнивается значение переменной
 */

