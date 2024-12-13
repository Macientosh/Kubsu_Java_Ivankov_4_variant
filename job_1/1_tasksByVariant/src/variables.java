public class variables {
        public static void main(String[] args) {
            if (args.length == 2) {
                try {
                    // Преобразуем аргументы в целые числа
                    int x = Integer.parseInt(args[0]);
                    int y = Integer.parseInt(args[1]);

                    // Если сумма больше 20, выводим утроенный квадрат первого числа
                    if (x + y > 20) {
                        int result = 3 * (x * x);
                        System.out.println("Результат: " + result);
                    }
                    // Иначе выводим куб второго числа
                    else {
                        int result = y * y * y;
                        System.out.println("Результат: " + result);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка: оба параметра должны быть целыми числами.");
                }
            } else {
                System.out.println("Ошибка: программа ожидает ровно два параметра.");
            }
        }
}
