public class Main {

    public static double f(double x, double y) {
        return Math.sin(x) - y;
    }

    public static void rungeKutta3(double x0, double y0, double h, double xEnd) {
        double x = x0;
        double y = y0;

        System.out.printf("x = %.2f, y = %.6f%n", x, y);

        while (x < xEnd) {
            double k1 = h * f(x, y);
            double k2 = h * f(x + h / 2.0, y + k1 / 2.0);
            double k3 = h * f(x + h, y - k1 + 2 * k2);

            y += (k1 + 4 * k2 + k3) / 6.0;
            x += h;

            System.out.printf("x = %.2f, y = %.6f%n", x, y);
        }
    }

    public static void main(String[] args) {
        double x0 = 0.0;
        double y0 = 1.0;
        double h = 0.1;
        double xEnd = 1.0;

        rungeKutta3(x0, y0, h, xEnd);
    }
}
