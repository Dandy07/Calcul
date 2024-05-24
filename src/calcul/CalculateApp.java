package calcul;

import static calcul.CalculateUtil.readInputFromConsole;

public class CalculateApp extends CalculateService {
    public void start() {
        // ""hello" "+" "hello""
        String input = readInputFromConsole();
        // 1 2 3 4 5 - элементы
        // 0 1 2 3 4 - индексы
        // "hello", "+", "hello";
        try {
            String[] result = stringInputFilter(input);
            String operand1 = result[0];
            String operator = result[1];
            String operand2 = result[2];
            calculate(operand1, operator, operand2);
        } catch (Exception e) {
            System.out.println("Ошибка приложения");
        }
    }

    //    "hello" + "hello"
//    "100" + "500"
//    "Hi World!" - "World!"
//    "Bye-bye!" - "World!"
//    "Java" * 5
//    "Example!!!" / 3

    public void calculate(String operand1, String operator, String operand2) {
        switch (operator) {
            case "+" -> sum(operand1, operand2);
            case "-" -> subtraction(operand1, operand2);
            case "*" -> multiply(operand1, operand2);
            case "/" -> divide(operand1, operand2);
            default -> throw new IllegalArgumentException("Неподдерживаемый оператор: " + operator);
        }
    }

    private void sum(String operand1, String operand2) {
        String answer = operand1 + operand2;
        String result = checkAnswerLength(answer);
        System.out.println(result);
    }

    private void subtraction(String operand1, String operand2) {
        if (operand1.contains(operand2)) {
            String replace = operand1.replace(operand2, "");
            System.out.println(replace);
        } else {
            System.out.println(operand1);
        }
    }

    private void multiply(String operand1, String operand2) {
        int valueOperand2 = Integer.parseInt(operand2);
        String answer = "";
        while (valueOperand2 != 0) {
            answer = answer + operand1;
            valueOperand2 = valueOperand2 - 1;
        }
        String result = checkAnswerLength(answer);
        System.out.println(result);
    }

    private void divide(String operand1, String operand2) {
        int newLength = operand1.length() / Integer.parseInt(operand2);
        String result = operand1.substring(0, newLength);
        System.out.println(result);
    }
}
