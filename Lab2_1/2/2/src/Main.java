public class Main {

    public static double f(double x) {
        return Math.pow(x, 4) + 6 * Math.pow(x, 2) - 12 * x - 8;
    }

    public static double df(double x) {
        return 4 * Math.pow(x, 3) + 12 * x - 12;
    }

    public static double bisection(double a, double b, double eps) {
        if (f(a) * f(b) >= 0) {
            System.out.println("f(a) і f(b) мають однаковий знак!");
            return Double.NaN;
        }

        if (Math.abs(f(a)) < eps) return a;
        if (Math.abs(f(b)) < eps) return b;

        double c = a;
        while (Math.abs(f(c)) > eps) {
            c = (a + b) / 2;
            if (f(c) * f(a) < 0) b = c;
            else a = c;
        }
        return c;
    }

    public static double newton(double x0, double eps) {
        double x1;
        do {
            if (Math.abs(df(x0)) < eps) {
                System.out.println("Похідна дуже мала, метод Ньютона може не працювати.");
                return Double.NaN;
            }
            x1 = x0 - f(x0) / df(x0);
            if (Math.abs(x1 - x0) < eps) break;
            x0 = x1;
        } while (true);
        return x1;
    }

    public static double secant(double x0, double x1, double eps) {
        double x2;
        do {
            if (Math.abs(f(x1) - f(x0)) < eps) {
                System.out.println("Різниця між f(x1) та f(x0) дуже мала, метод хорд може не працювати.");
                return Double.NaN;
            }
            x2 = x1 - f(x1) * (x1 - x0) / (f(x1) - f(x0));
            if (Math.abs(x2 - x1) < eps) break;
            x0 = x1;
            x1 = x2;
        } while (true);
        return x2;
    }

    public static void main(String[] args) {
        double eps = 1e-6;

        double root1Bisection = bisection(-1.0, 0.0, eps);
        double root1Newton = newton(-0.5, eps);
        double root1Secant = secant(-1.0, 0.0, eps);

        double root2Bisection = bisection(1.0, 2.0, eps);
        double root2Newton = newton(1.5, eps);
        double root2Secant = secant(1.0, 2.0, eps);

        System.out.println("Перший корінь (на [-1, 0]):");
        System.out.printf("  Бісекція: %.6f\n", root1Bisection);
        System.out.printf("  Ньютон:   %.6f\n", root1Newton);
        System.out.printf("  Хорд:     %.6f\n", root1Secant);

        System.out.println("\nДругий корінь (на [1, 2]):");
        System.out.printf("  Бісекція: %.6f\n", root2Bisection);
        System.out.printf("  Ньютон:   %.6f\n", root2Newton);
        System.out.printf("  Хорд:     %.6f\n", root2Secant);
    }
}
