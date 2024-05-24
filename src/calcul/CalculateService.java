package calcul;

public class CalculateService {
    // ""hello" "+" "hello""
     String[] stringInputFilter(String input) throws Exception {
         // первичная инициализация массивов
        String[] afterHandlerArr = new String[3];
         // "hello","+","hello"
        String[] result = new String[3];

        // первый фильтр - смотрим какой знак в строке
        if (input.contains("+") || input.contains("-")) {
            afterHandlerArr = lineHandlerSumOrSub(input);
        }
        if (input.contains("*") || input.contains("/")) {
            afterHandlerArr = lineHandlerMultOrDiv(input);
        }
        String operand1 = afterHandlerArr[0];
        String operator = afterHandlerArr[1];
        String operand2 = afterHandlerArr[2];
        // проверка длину строк
        if (operand1.length() > 10 || operand2.length() > 10) {
            throw new Exception("Строка не может быть длиннее 10 символов");
        }
        result[0] = operand1;
        result[1] = operator;
        result[2] = operand2;
        return result;
    }

     String[] lineHandlerSumOrSub(String input) {
        String[] arr = new String[3];
        // Удаляем кавычки в начале и конце строки
        input = input.substring(1, input.length() - 1);
        // Находим индекс первой кавычки
        int firstIndex = input.indexOf('\"') + 1;
        // Находим индекс второй кавычки
        int secondIndex = input.indexOf('\"', firstIndex);
        // Получаем первую строку
        String operand1 = input.substring(0, firstIndex - 1);
        // Получаем вторую строку (символ минус)
        String operator = input.substring(firstIndex, secondIndex).trim();
        // Получаем третью строку
        String operand2 = input.substring(secondIndex + 1).trim();
        // Если третья строка начинается с кавычки, удаляем её
        if (operand2.startsWith("\"")) {
            operand2 = operand2.substring(1);
        }
        // Если третья строка заканчивается кавычкой, удаляем её
        if (operand2.endsWith("\"")) {
            operand2 = operand2.substring(0, operand2.length() - 1);
        }
        // добавляем в результирующий массив операнды и оператор
        arr[0] = operand1;
        arr[1] = operator;
        arr[2] = operand2;
        return arr;
    }
     String[] lineHandlerMultOrDiv(String input) {
        String[] result = new String[3];
        // Находим индекс первой кавычки
        int firstIndex = input.indexOf("\"");
        // Находим индекс второй кавычки
        int secondIndex = input.lastIndexOf("\"");
        // Извлекаем операнд1
        String operand1 = input.substring(firstIndex, secondIndex + 1);
        // избавляемся от лишних кавычек
        operand1 = operand1.replace("\"", "");
        // Удаляем операнд1 из выражения
        String remainingExpression = input.substring(secondIndex + 1).trim();
        // Разделяем оставшееся выражение на оператор и операнд2
        String[] parts = remainingExpression.split(" ");
        // Извлекаем оператор и операнд2
        String operator = parts[0];
        String operand2 = parts[1];
        // добавляем в результирующий массив операнды и оператор
        result[0] = operand1;
        result[1] = operator;
        result[2] = operand2;
        return result;
    }
     String checkAnswerLength(String result) {
        if (result.length() > 40) {
            return result.substring(0, 40) + "...";
        }
        return result;
    }
}
