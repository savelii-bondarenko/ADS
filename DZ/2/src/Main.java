public class Main {

    public static void main(String[] args) {
        int n = 3;

        double[] y = {1.0, 0.0, -1.0};

        double x = 0.0;
        double xEnd = 2.0;
        double h = 0.1;

        System.out.println("\nРезультати обчислення:");
        System.out.printf("x\t");
        for (int i = 0; i < n; i++) System.out.printf("y%d\t\t", i);
        System.out.println();

        while (x <= xEnd + 1e-10) {
            printState(x, y);
            y = rungeKuttaStep(x, y, h, n);
            x += h;
        }
    }

    static double[] rungeKuttaStep(double x, double[] y, double h, int n) {
        double[] k1 = f(x, y, n);
        double[] yTemp = new double[n];

        for (int i = 0; i < n; i++) {
            yTemp[i] = y[i] + h * k1[i] / 2;
        }
        double[] k2 = f(x + h / 2, yTemp, n);

        for (int i = 0; i < n; i++) {
            yTemp[i] = y[i] - h * k1[i] + 2 * h * k2[i];
        }
        double[] k3 = f(x + h, yTemp, n);

        double[] yNext = new double[n];
        for (int i = 0; i < n; i++) {
            yNext[i] = y[i] + (h / 6) * (k1[i] + 4 * k2[i] + k3[i]);
        }

        return yNext;
    }

    static double[] f(double x, double[] y, int n) {
        double[] dy = new double[n];

        for (int i = 0; i < n - 1; i++) {
            dy[i] = y[i + 1];
        }

        dy[n - 1] = -y[0] + x;

        return dy;
    }

    static void printState(double x, double[] y) {
        System.out.printf("%.4f\t", x);
        for (double v : y) {
            System.out.printf("%.6f\t", v);
        }
        System.out.println();
    }
}
