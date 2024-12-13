import java.util.Arrays;

public class actionsOnArrays {
    public static void main(String[] args) {

        int[] b = {10, 3, 2, -53, -6, -2, -16, 55, 221};

        int[] c = transformArray(b);
        System.out.println("Массив C до сортировки: " + Arrays.toString(c));

        selectionSort(c);
        System.out.println("Массив C после сортировки: " + Arrays.toString(c));
    }

    public static int[] transformArray(int[] b) {

        int count = 0;
        for (int value : b) {
            if (value < 0) {
                count++;
            }
        }

        int[] c = new int[count];
        int index = 0;
        for (int value : b) {
            if (value < 0) {
                c[index++] = value * 4;
            }
        }
        return c;
    }

    public static void selectionSort(int[] array) {
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {

            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }
}
