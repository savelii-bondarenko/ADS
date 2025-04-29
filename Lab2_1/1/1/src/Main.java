public class Main {

    public static double f(double x) {
        return 0.5 * Math.exp(Math.sqrt(1 + 2 * x));
    }

    public static double rectangleMethod(double a, double b, double h) {
        double sum = 0.0;
        for (double x = a; x < b; x += h) {
            sum += f(x);
        }
        return sum * h;
    }

    public static double trapeciaMethod(double a, double b, double h) {
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
        double h = 0.2;

        double rect = rectangleMethod(a, b, h);
        double trap = trapeciaMethod(a, b, h);
        double simp = simpsonMethod(a, b, h);

        System.out.printf("Метод прямокутників: %.6f\n", rect);
        System.out.printf("Метод трапецій: %.6f\n", trap);
        System.out.printf("Метод Сімпсона: %.6f\n", simp);
    }
}
