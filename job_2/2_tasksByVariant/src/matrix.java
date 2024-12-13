import java.util.Random;

public class matrix {
    public static void main(String[] args) {

        int rows = 6;
        int columns = 3;

        int[][] matrix = createRandomMatrix(rows, columns, -10, 50);
        System.out.println("Матрица:");
        printMatrix(matrix);

        int[] vectorB = getMaxInColumns(matrix);
        System.out.println("\nВектор B (максимальные значения в столбцах):");
        printVector(vectorB);
    }

    public static int[][] createRandomMatrix(int rows, int columns, int min, int max) {
        Random random = new Random();
        int[][] matrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = random.nextInt(max - min + 1) + min;
            }
        }

        return matrix;
    }

    public static int[] getMaxInColumns(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        int[] maxValues = new int[columns];

        for (int j = 0; j < columns; j++) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < rows; i++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                }
            }
            maxValues[j] = max;
        }

        return maxValues;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.printf("%5d", value);
            }
            System.out.println();
        }
    }

    public static void printVector(int[] vector) {
        for (int value : vector) {
            System.out.printf("%5d", value);
        }
        System.out.println();
    }
}
