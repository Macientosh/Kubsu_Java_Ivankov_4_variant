import java.util.Random;

public class actionOnMatrix {
    public static void main(String[] args) {
        int n = 4;
        int[][] matrix = createRandomMatrix(n, -10, 50);
        System.out.println("Матрица A:");
        printMatrix(matrix);

        int minMainDiagonal = Integer.MAX_VALUE;
        int maxMainDiagonal = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int element = matrix[i][i];
            if (element < minMainDiagonal) {
                minMainDiagonal = element;
            }
            if (element > maxMainDiagonal) {
                maxMainDiagonal = element;
            }
        }

        int productMainDiagonal = minMainDiagonal * maxMainDiagonal;
        System.out.println("\nМинимальный элемент главной диагонали: " + minMainDiagonal);
        System.out.println("Максимальный элемент главной диагонали: " + maxMainDiagonal);
        System.out.println("Произведение минимального и максимального элементов главной диагонали: " + productMainDiagonal);

        System.out.println("\nМатрица после умножения побочной диагонали на " + maxMainDiagonal + ":");
        for (int i = 0; i < n; i++) {
            matrix[i][n - i - 1] *= maxMainDiagonal;
        }
        printMatrix(matrix);
    }

    public static int[][] createRandomMatrix(int n, int min, int max) {
        Random random = new Random();
        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = random.nextInt(max - min + 1) + min;
            }
        }

        return matrix;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.printf("%5d", value);
            }
            System.out.println();
        }
    }
}

