import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println(textModifier());
    }

    static String textModifier() {
        String resultString = "";
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите произвольную строк:");
        String raw_string = scanner.nextLine();
        resultString = duplicateCleaner(raw_string, ' ');
        //Далее мы очищаем от дблирования и появления в начале и конце '-"
        //Иначе придется усложнять метод CharChenger
        resultString = duplicateCleaner(resultString, '-');
        resultString = charChenger(resultString);
        resultString = processingString(resultString);
        return resultString;
    }

    static String duplicateCleaner(String str, char symbolForClean) {
        String preResultString = "";
        String resultString = "";
        char prewiousSymbol = '*';
        char currentSymbol;
        for (int i = 0; i <= str.length() - 1; i++) {
            currentSymbol = str.charAt(i);
            if (currentSymbol == symbolForClean && prewiousSymbol == symbolForClean) {
            } else {
                preResultString += currentSymbol;
            }
            prewiousSymbol = currentSymbol;
        }
        //очистка старта и хвоста от симовла
        //Здесь можно переиспользовать уже обьявленую str, но для читаемости кода добавлена
        //переменная resultString
        for (int i = 0; i <= preResultString.length() - 1; i++) {
            if ((i == 0 && preResultString.charAt(i) == symbolForClean) || (i == preResultString.length() - 1
                    && preResultString.charAt(i) == symbolForClean)) {
            } else {
                resultString += preResultString.charAt(i);
            }

        }

        return resultString;
    }

    static String charChenger(String str) {
        String resultString = "";
        for (int i = 0; i <= str.length() - 1; i++) {
            if ((i + 2) <= (str.length() - 1) && str.charAt(i + 1) == '-') {
                //условие можно упростить математически, но тогда будет не очевиден смысл ограничения
                resultString = resultString + str.charAt(i + 2) + str.charAt(i);
                i += 2;
            } else {
                resultString = resultString + str.charAt(i);
            }
        }

        return resultString;
    }

    static String processingString(String str) {
        int summ = 0;
        String resultString = "";
        System.out.println("Длинна строки :" + str.length());
        for (int i = 0; i <= str.length() - 1; i++) {
            switch (str.charAt(i)) {
                case '0':
                    break;
                case '1':
                    summ += 1;
                    break;
                case '2':
                    summ += 2;
                    break;
                case '3':
                    summ += 3;
                    break;
                case '4':
                    summ += 4;
                    break;
                case '5':
                    summ += 5;
                    break;
                case '6':
                    summ += 6;
                    break;
                case '7':
                    summ += 7;
                    break;
                case '8':
                    summ += 8;
                    break;
                case '9':
                    summ += 9;
                    break;
                case '+':
                    resultString += '!';
                    //можно разделить на два метода подсчет суммы и замена плюса
                    //Но это еще один цикл
                    break;
                default:
                    resultString += str.charAt(i);
                    // System.out.println(resultString);
                    break;
            }
        }
        if (summ > 0) {
            resultString += " " + summ;
        }

        return resultString;
    }


//закрывающая кавычка класса Main
}