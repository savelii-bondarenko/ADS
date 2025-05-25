import java.util.Arrays;

public class Main {

    private static final int N = 4;

    public static void main(String[] args) {
        double[][] A = {
                { 2, -9, -3, -6 },
                { 3, -5,  4,  1 },
                { 0,  1,  4, -3 },
                { 6, -3,  9,  6 }
        };

        double[] b = { -22, 6, 62, 30 };

        System.out.println("\nСистема рівнянь:");
        printSystem(A, b);

        int[] P = new int[N];
        double[][] L = new double[N][N];
        double[][] U = new double[N][N];
        lupDecompose(A, L, U, P);

        System.out.println("\nМатриця перестановки P:");
        printPermutationMatrix(P);

        System.out.println("\nНижня трикутна матриця L:");
        printMatrix(L);

        System.out.println("\nВерхня трикутна матриця U:");
        printMatrix(U);

        double[] Pb = new double[N];
        for (int i = 0; i < N; i++) {
            Pb[i] = b[P[i]];
        }

        double[] y = forwardSubstitution(L, Pb);

        double[] x = backwardSubstitution(U, y);

        System.out.println("\nРозв’язок системи:");
        for (int i = 0; i < N; i++) {
            System.out.printf("x%d = %.4f\n", i + 1, x[i]);
        }
    }

    static void lupDecompose(double[][] A, double[][] L, double[][] U, int[] P) {
        int n = A.length;
        double[][] A_copy = new double[n][n];
        for (int i = 0; i < n; i++) {
            P[i] = i;
            A_copy[i] = Arrays.copyOf(A[i], n);
        }

        for (int k = 0; k < n; k++) {
            double max = 0;
            int k_prime = -1;
            for (int i = k; i < n; i++) {
                if (Math.abs(A_copy[i][k]) > max) {
                    max = Math.abs(A_copy[i][k]);
                    k_prime = i;
                }
            }

            if (max == 0) {
                throw new RuntimeException("Матриця вироджена");
            }

            int tempP = P[k];
            P[k] = P[k_prime];
            P[k_prime] = tempP;

            double[] tempRow = A_copy[k];
            A_copy[k] = A_copy[k_prime];
            A_copy[k_prime] = tempRow;

            for (int i = k + 1; i < n; i++) {
                A_copy[i][k] /= A_copy[k][k];
                for (int j = k + 1; j < n; j++) {
                    A_copy[i][j] -= A_copy[i][k] * A_copy[k][j];
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i > j) {
                    L[i][j] = A_copy[i][j];
                    U[i][j] = 0;
                } else if (i == j) {
                    L[i][j] = 1;
                    U[i][j] = A_copy[i][j];
                } else {
                    L[i][j] = 0;
                    U[i][j] = A_copy[i][j];
                }
            }
        }
    }

    static double[] forwardSubstitution(double[][] L, double[] b) {
        int n = L.length;
        double[] y = new double[n];
        for (int i = 0; i < n; i++) {
            y[i] = b[i];
            for (int j = 0; j < i; j++) {
                y[i] -= L[i][j] * y[j];
            }
        }
        return y;
    }

    static double[] backwardSubstitution(double[][] U, double[] y) {
        int n = U.length;
        double[] x = new double[n];
        for (int i = n - 1; i >= 0; i--) {
            x[i] = y[i];
            for (int j = i + 1; j < n; j++) {
                x[i] -= U[i][j] * x[j];
            }
            x[i] /= U[i][i];
        }
        return x;
    }

    static void printMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double val : row) {
                System.out.printf("%10.4f ", val);
            }
            System.out.println();
        }
    }

    static void printPermutationMatrix(int[] P) {
        int n = P.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print((P[i] == j ? "1" : "0") + " ");
            }
            System.out.println();
        }
    }

    static void printSystem(double[][] A, double[] b) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                System.out.printf("%+4.0fx%d ", A[i][j], j + 1);
            }
            System.out.printf("= %+6.2f\n", b[i]);
        }
    }
}
