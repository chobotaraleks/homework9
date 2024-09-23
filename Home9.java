import java.util.Random;

public class MatrixTask {
    public static void main(String[] args) {
        // Створення двовимірного масиву 4x4
        int[][] matrix = new int[4][4];
        Random rand = new Random();

        // Заповнення масиву випадковими числами від 1 до 50
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matrix[i][j] = rand.nextInt(50) + 1;
            }
        }

        // Виведення матриці
        System.out.println("Матриця 4x4:");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }

        // Обчислення суми елементів парних та непарних рядків
        int evenRowSum = 0;
        int oddRowSum = 0;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i % 2 == 0) {
                    evenRowSum += matrix[i][j];
                } else {
                    oddRowSum += matrix[i][j];
                }
            }
        }

        // Обчислення добутку елементів парних та непарних стовпців
        long evenColProduct = 1;
        long oddColProduct = 1;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (j % 2 == 0) {
                    evenColProduct *= matrix[i][j];
                } else {
                    oddColProduct *= matrix[i][j];
                }
            }
        }

        // Виведення результатів
        System.out.println("\nСума елементів у парних рядках (0, 2): " + evenRowSum);
        System.out.println("Сума елементів у непарних рядках (1, 3): " + oddRowSum);
        System.out.println("Добуток елементів у парних стовпцях (0, 2): " + evenColProduct);
        System.out.println("Добуток елементів у непарних стовпцях (1, 3): " + oddColProduct);

        // Перевірка, чи є матриця магічним квадратом
        boolean isMagicSquare = checkMagicSquare(matrix);
        if (isMagicSquare) {
            System.out.println("\nМатриця є магічним квадратом.");
        } else {
            System.out.println("\nМатриця не є магічним квадратом.");
        }
    }

    // Метод для перевірки, чи є матриця магічним квадратом
    public static boolean checkMagicSquare(int[][] matrix) {
        int sumDiagonal1 = 0, sumDiagonal2 = 0;
        for (int i = 0; i < 4; i++) {
            sumDiagonal1 += matrix[i][i];
            sumDiagonal2 += matrix[i][3 - i];
        }
        if (sumDiagonal1 != sumDiagonal2) {
            return false;
        }

        int magicSum = sumDiagonal1;

        for (int i = 0; i < 4; i++) {
            int rowSum = 0, colSum = 0;
            for (int j = 0; j < 4; j++) {
                rowSum += matrix[i][j];
                colSum += matrix[j][i];
            }
            if (rowSum != magicSum || colSum != magicSum) {
                return false;
            }
        }

        return true;
    }
}

