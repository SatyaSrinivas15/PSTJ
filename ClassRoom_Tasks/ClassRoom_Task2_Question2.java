import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.IntStream;

public class ClassRoom_Task2_Question2 {

    static BiFunction<long[][], long[][], long[][]> add = (A, B) -> {
        int n = A.length;
        long[][] C = new long[n][n];

        IntStream.range(0, n).forEach(i ->
            IntStream.range(0, n).forEach(j ->
                C[i][j] = A[i][j] + B[i][j]
            )
        );

        return C;
    };

    static BiFunction<long[][], long[][], long[][]> subtract = (A, B) -> {
        int n = A.length;
        long[][] C = new long[n][n];

        IntStream.range(0, n).forEach(i ->
            IntStream.range(0, n).forEach(j ->
                C[i][j] = A[i][j] - B[i][j]
            )
        );

        return C;
    };

    static long[][] normalMultiply(long[][] A, long[][] B) {
        int n = A.length;
        long[][] C = new long[n][n];

        IntStream.range(0, n).forEach(i ->
            IntStream.range(0, n).forEach(k ->
                IntStream.range(0, n).forEach(j ->
                    C[i][j] += A[i][k] * B[k][j]
                )
            )
        );

        return C;
    }

    static long[][] split(long[][] A, int row, int col, int size) {
        long[][] result = new long[size][size];

        IntStream.range(0, size).forEach(i ->
            IntStream.range(0, size).forEach(j ->
                result[i][j] = A[row + i][col + j]
            )
        );

        return result;
    }

    static long[][] strassen(long[][] A, long[][] B) {

        int n = A.length;

        if (n <= 2) {
            return normalMultiply(A, B);
        }

        int half = n / 2;

        long[][] A11 = split(A, 0, 0, half);
        long[][] A12 = split(A, 0, half, half);
        long[][] A21 = split(A, half, 0, half);
        long[][] A22 = split(A, half, half, half);

        long[][] B11 = split(B, 0, 0, half);
        long[][] B12 = split(B, 0, half, half);
        long[][] B21 = split(B, half, 0, half);
        long[][] B22 = split(B, half, half, half);

        long[][] M1 = strassen(
                add.apply(A11, A22),
                add.apply(B11, B22)
        );

        long[][] M2 = strassen(
                add.apply(A21, A22),
                B11
        );

        long[][] M3 = strassen(
                A11,
                subtract.apply(B12, B22)
        );

        long[][] M4 = strassen(
                A22,
                subtract.apply(B21, B11)
        );

        long[][] M5 = strassen(
                add.apply(A11, A12),
                B22
        );

        long[][] M6 = strassen(
                subtract.apply(A21, A11),
                add.apply(B11, B12)
        );

        long[][] M7 = strassen(
                subtract.apply(A12, A22),
                add.apply(B21, B22)
        );

        long[][] C11 = add.apply(
                subtract.apply(
                        add.apply(M1, M4), M5
                ), M7
        );

        long[][] C12 = add.apply(M3, M5);

        long[][] C21 = add.apply(M2, M4);

        long[][] C22 = add.apply(
                subtract.apply(
                        add.apply(M1, M3), M2
                ), M6
        );

        long[][] C = new long[n][n];

        IntStream.range(0, half).forEach(i ->
            IntStream.range(0, half).forEach(j -> {
                C[i][j] = C11[i][j];
                C[i][j + half] = C12[i][j];
                C[i + half][j] = C21[i][j];
                C[i + half][j + half] = C22[i][j];
            })
        );

        return C;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        long[][] A = new long[n][n];
        long[][] B = new long[n][n];

        IntStream.range(0, n).forEach(i ->
            IntStream.range(0, n).forEach(j ->
                A[i][j] = sc.nextLong()
            )
        );

        IntStream.range(0, n).forEach(i ->
            IntStream.range(0, n).forEach(j ->
                B[i][j] = sc.nextLong()
            )
        );

        long[][] result = strassen(A, B);

        IntStream.range(0, n).forEach(i -> {
            IntStream.range(0, n).forEach(j -> {
                System.out.print(result[i][j] + " ");
            });
            System.out.println();
        });

        sc.close();
    }
}