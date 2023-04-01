public class Check {
    // Получение индекса нашего оператора. Если в вводе нет корректного символа арифметической операции = ошибка
    public int getOperatorIndex(String userInput) {
        String[] array = {"+", "-", "*", "/"};

        for (String elem : array) {
            if (userInput.contains(elem)) {
                return userInput.indexOf(elem);

            }

        }
        throw new ArithmeticException("Пользователь ввёл не верный знак табуляции");
    }

    //при помощи оператора получаем escape-последовательность для корректной работы метода split
    public String getEscapeSequence(String operator){
        switch (operator){
            case "+":
                return "\\+";
            case "-":
                return "-";
            case "*":
                return "\\*";
            case "/":
                return "/";
        }
        //заглушка
        return "";
    }

    //проверка пользовательских чисел на принадлежность диапазону, от 1 до 10 включительно
    public boolean isCorrent(int first, int second) {
        boolean isCorrectFirst = (first >=1 && first <= 10);
        boolean isCorrectSecond = (second >=1 && second <= 10);

        if (isCorrectFirst && isCorrectSecond) {
            return true;
        } else {
            throw new ArithmeticException("Ведённые числа должны быть в диапазоне [1, 10}");
        }

    }


    //При помощи конструкции switch-case проводим арифметические операции.
    public int calculate(int first, String operator , int second) {
        switch (operator) {
            case "+":
                return first + second;
            case "-":
                return first - second;
            case "*":
                return first * second;
            case "/":
                return first / second;
        }
        //заглушка
        return 0;
    }


}

