public class logicalBranches {
    public static void main(String[] args) {
        if (args.length == 1) {
            try {
                // Парсим аргумент
                double x = Double.parseDouble(args[0]);

                double Y, F;

                // Вычисляем Y
                if (x <= 1) {
                    Y = Math.pow(x, 5) + Math.atan(8 * x);
                } else if (x > 1 && x <= 2) {
                    Y = 5 * x - (1 + Math.pow(3, x));
                } else {
                    Y = 1.0 / Math.tan(2 * x + 1);
                }

                // Вычисляем F
                if (x <= 1) {
                    F = Math.exp(Math.tan(x) + 1);
                } else if (x > 1 && x <= 2) {
                    F = Math.pow(x, 4) - Math.tan(4 * x);
                } else {
                    F = Math.sqrt(x);
                }

                // Выводим результаты
                System.out.println("Y = " + Y);
                System.out.println("F = " + F);

            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите число в качестве параметра.");
            }
        } else {
            System.out.println("Ошибка: программа ожидает ровно один параметр.");
        }
    }
}
