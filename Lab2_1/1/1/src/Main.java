public class Main {

    public static double f(double x) {
        return 0.5 * Math.exp(Math.sqrt(1 + 2 * x));
    }

    public static double leftRectangleMethod(double a, double b, double h) {
        double sum = 0.0;
        for (double x = a; x < b; x += h) {
            sum += f(x);
        }
        return sum * h;
    }

    public static double rightRectangleMethod(double a, double b, double h) {
        double sum = 0.0;
        for (double x = a + h; x <= b; x += h) {
            sum += f(x);
        }
        return sum * h;
    }

    public static double middleRectangleMethod(double a, double b, double h) {
        double sum = 0.0;
        for (double x = a + h / 2; x < b; x += h) {
            sum += f(x);
        }
        return sum * h;
    }

    public static double trapeziaMethod(double a, double b, double h) {
        double sum = 0.5 * (f(a) + f(b));
        for (double x = a + h; x < b; x += h) {
            sum += f(x);
        }
        return sum * h;
    }

    public static double simpsonMethod(double a, double b, double h) {
        int n = (int)((b - a) / h);
        if (n % 2 != 0) {
            n++;
            h = (b - a) / n;
        }

        double sum = f(a) + f(b);
        for (int i = 1; i < n; i++) {
            double x = a + i * h;
            sum += (i % 2 == 0) ? 2 * f(x) : 4 * f(x);
        }
        return (h / 3) * sum;
    }

    public static void main(String[] args) {
        double a = 1.0;
        double b = 2.0;
        double h = 0.002;

        double left = leftRectangleMethod(a, b, h);
        double right = rightRectangleMethod(a, b, h);
        double middle = middleRectangleMethod(a, b, h);
        double trap = trapeziaMethod(a, b, h);
        double simp = simpsonMethod(a, b, h);

        System.out.printf("Метод лівих прямокутників:     %.6f\n", left);
        System.out.printf("Метод правих прямокутників:    %.6f\n", right);
        System.out.printf("Метод середніх прямокутників:  %.6f\n", middle);
        System.out.printf("Метод трапецій:                %.6f\n", trap);
        System.out.printf("Метод Сімпсона:                %.6f\n", simp);
    }
}
