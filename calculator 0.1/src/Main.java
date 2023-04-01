import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    public static void main(String[] args) throws IOException {
        System.out.println("Запуск программы.");
        System.out.print("Введите арифметическую операцию: ");

        //Создание переменной для считывания вовода с концоли
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String userInput = reader.readLine();

        // Вызов основного метода подчёта, получение результата и выведение в концоль
        String result = calc(userInput);
        System.out.print("Результат вычесления: " + result);
    }

    public static String calc(String userInput) {

        //Создание обекта наших проверок
        Check check = new Check();
        Converter converter = new Converter();

        //Получение индекса оператора, затем получение самого оператора при помощи метода String.substring()
        int operatorIndex = check.getOperatorIndex(userInput);
        String operator = userInput.substring(operatorIndex, operatorIndex + 1);

        //Получен escape-последовательности для корректной работы String.split() из оператора, котрорый только что получили
        String esc = check.getEscapeSequence(operator);
        String[] userInputArray = userInput.split(esc);

        //Проверка на количество элементов в массиве. Если не равно 2, некорректный ввод
        if (userInputArray.length != 2) {
            throw new ArithmeticException("Некорректный ввод");
        }

        //Каждый элемент полученного через split массива борезаем от пробелов при помощи trim
        for (int i = 0; i < userInputArray.length; i++) {
            userInputArray[i] = userInputArray[i].trim();
        }
        int firstNumber = 0;
        int secondNumber = 0;
        // Флаг
        boolean isRim = false;
        
        try {
            //если числа арабские
             firstNumber = Integer.parseInt(userInputArray[0]);
             secondNumber = Integer.parseInt(userInputArray[1]);
        }catch ( NumberFormatException e){
            try {
                //Если нет, то числа римские, и мы пытаемся их конвертировать в арабские, а после ставим флаг
                firstNumber = converter.rimToArab(userInputArray[0]);
                secondNumber = converter.rimToArab(userInputArray[1]);
                isRim = true;
            }catch (ConvertException ex) {
                // ввод не кроектен
                ex.printStackTrace();
                //Критическая пошибка. Завершение программы
                System.exit(0);
            }
        }
        //Проверка диапазона [1, 10]
        check.isCorrent(firstNumber, secondNumber);

        //Получаем result при помощи вспомогательного метода calculate
        int result = check.calculate(firstNumber, operator, secondNumber);

        //Если изначально были римские числа
        if (isRim){
            return converter.arabToRim(result);
        }

        return result + "";


    }

}

