import java.util.*;

public class ClassRoom_Task2_Question1 {

    static int[][] normalMultiply(int[][] A, int[][] B) {
        int n = A.length;
        int[][] C = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                for (int j = 0; j < n; j++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        return C;
    }

    static int[][] add(int[][] A, int[][] B) {
        int n = A.length;
        int[][] C = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                C[i][j] = A[i][j] + B[i][j];
            }
        }

        return C;
    }

    static int[][] subtract(int[][] A, int[][] B) {
        int n = A.length;
        int[][] C = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                C[i][j] = A[i][j] - B[i][j];
            }
        }

        return C;
    }

    static int[][] split(int[][] A, int row, int col, int size) {
        int[][] result = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                result[i][j] = A[row + i][col + j];
            }
        }

        return result;
    }

    static int[][] combine(int[][] C11, int[][] C12,
                           int[][] C21, int[][] C22) {

        int n = C11.length;
        int[][] C = new int[n * 2][n * 2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                C[i][j] = C11[i][j];
                C[i][j + n] = C12[i][j];
                C[i + n][j] = C21[i][j];
                C[i + n][j + n] = C22[i][j];
            }
        }

        return C;
    }

    static int[][] strassen(int[][] A, int[][] B) {

        int n = A.length;

        if (n <= 2) {
            return normalMultiply(A, B);
        }

        int size = n / 2;

        int[][] A11 = split(A, 0, 0, size);
        int[][] A12 = split(A, 0, size, size);
        int[][] A21 = split(A, size, 0, size);
        int[][] A22 = split(A, size, size, size);

        int[][] B11 = split(B, 0, 0, size);
        int[][] B12 = split(B, 0, size, size);
        int[][] B21 = split(B, size, 0, size);
        int[][] B22 = split(B, size, size, size);

        int[][] M1 = strassen(add(A11, A22), add(B11, B22));

        int[][] M2 = strassen(add(A21, A22), B11);

        int[][] M3 = strassen(A11, subtract(B12, B22));

        int[][] M4 = strassen(A22, subtract(B21, B11));

        int[][] M5 = strassen(add(A11, A12), B22);

        int[][] M6 = strassen(subtract(A21, A11), add(B11, B12));

        int[][] M7 = strassen(subtract(A12, A22), add(B21, B22));

        int[][] C11 = add(subtract(add(M1, M4), M5), M7);

        int[][] C12 = add(M3, M5);

        int[][] C21 = add(M2, M4);

        int[][] C22 = add(subtract(add(M1, M3), M2), M6);

        return combine(C11, C12, C21, C22);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] A = new int[n][n];
        int[][] B = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                A[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                B[i][j] = sc.nextInt();
            }
        }

        int[][] result = strassen(A, B);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}