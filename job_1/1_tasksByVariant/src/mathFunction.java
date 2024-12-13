public class mathFunction {
    public static void main(String[] args) {
        if (args.length == 2) {
            try {
                // Парсим аргументы
                double a = Double.parseDouble(args[0]);
                double b = Double.parseDouble(args[1]);

                // Вычисляем max и min
                double max = Math.max(2 * a, b);
                double min1 = Math.min(a, 4 + b);
                double min2 = Math.min(a, 4 + b);

                // Вычисляем значение d по формуле
                double numerator = max - 10 * Math.sqrt(min1) + 4.2 * min2;
                double denominator = 1 + max / min1;

                double d = numerator / denominator;

                // Выводим результат
                System.out.println("Результат d: " + d);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите два числа в качестве параметров.");
            }
        } else {
            System.out.println("Ошибка: программа ожидает ровно два параметра.");
        }
    }
}
