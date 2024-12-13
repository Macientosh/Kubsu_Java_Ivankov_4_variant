import java.util.Random;

public class arrays {
    public static void main(String[] args) {

        int[] array = fillRandomIntArray(20, -99, 99);
        printArray("Изначальный массив:", array);

        double[] reciprocalArray = createReciprocalFraction(array);
        printArray("Массив обратных значений:", reciprocalArray);

        int allowedCount = countAllowedValues(array, -50, 50);
        System.out.println("Количество разрешенных значений: " + allowedCount);
    }

    public static int[] fillRandomIntArray(int size, int min, int max) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(max - min + 1) + min;
        }
        return array;
    }

    public static double[] createReciprocalFraction(int[] array) {
        double[] reciprocalArray = new double[array.length];
        for (int i = 0; i < array.length; i++) {
            try {
                reciprocalArray[i] = 1.0 / array[i];
            } catch (ArithmeticException e) {
                reciprocalArray[i] = Double.NaN; // Обработка деления на ноль
            }
        }
        return reciprocalArray;
    }

    public static int countAllowedValues(int[] array, int min, int max) {
        int count = 0;
        for (int value : array) {
            if (value >= min && value <= max) {
                count++;
            }
        }
        return count;
    }

    public static void printArray(String message, int[] array) {
        System.out.println(message);
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void printArray(String message, double[] array) {
        System.out.println(message);
        for (double value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
