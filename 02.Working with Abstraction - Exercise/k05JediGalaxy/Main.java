package k05JediGalaxy.jediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] galaxyMatrix = readAndInitializeMatrix(scanner);
        String command = scanner.nextLine();
        long sum = 0;
        while (!command.equals("Let the Force be with you")) {
            int[] jediCordsArr = Arrays.stream(command.split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] evilCords = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            moveEvilAndDestroyStars(galaxyMatrix, new Cords(evilCords[0], evilCords[1]));
            sum += moveJediAndCalculateStars(galaxyMatrix, new Cords(jediCordsArr[0], jediCordsArr[1]));

            command = scanner.nextLine();
        }
        System.out.println(sum);
    }

    private static long moveJediAndCalculateStars(int[][] galaxyMatrix, Cords jediCords) {
        long sum = 0;
        while (canJediStillMove(galaxyMatrix, jediCords)) {
            if (isInMatrix(galaxyMatrix, jediCords)) {

                sum += galaxyMatrix[jediCords.row][jediCords.col];
            }
            jediCords.row--;
            jediCords.col++;
        }
        return sum;
    }

    private static boolean canJediStillMove(int[][] galaxyMatrix, Cords cords) {
        int galaxyMatrixColumns = galaxyMatrix[1].length;
        return cords.row >= 0 && cords.col < galaxyMatrixColumns;
    }

    private static void moveEvilAndDestroyStars(int[][] galaxyMatrix, Cords evilCords) {
        while (canEvilStillMove(evilCords)) {
            if (isInMatrix(galaxyMatrix, evilCords)) {
                galaxyMatrix[evilCords.row][evilCords.col] = 0;
            }
            evilCords.row--;
            evilCords.col--;
        }
    }

    private static boolean isInMatrix(int[][] galaxyMatrix, Cords cords) {
        int galaxyMatrixColumnLenght = galaxyMatrix[0].length;
        return cords.row >= 0 && cords.row < galaxyMatrix.length && cords.col >= 0 && cords.col < galaxyMatrixColumnLenght;
    }

    private static boolean canEvilStillMove(Cords cords) {
        return cords.row >= 0 && cords.col >= 0;
    }

    static int[][] readAndInitializeMatrix(Scanner scanner) {
        int[] dimestions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int x = dimestions[0];
        int y = dimestions[1];

        int[][] matrix = new int[x][y];

        int value = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                matrix[i][j] = value++;
            }
        }
        return matrix;
    }
}
