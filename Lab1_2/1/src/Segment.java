class Segment {
    private final double x1, y1, x2, y2;

    // Конструктор для ініціалізації координат початку та кінця
    public Segment(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    // Метод для обчислення довжини відрізка
    public double length() {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    // Метод для обчислення кута з віссю OX
    public double angle() {
        return Math.toDegrees(Math.atan2(y2 - y1, x2 - x1));
    }

    // Метод для виведення інформації про відрізок
    @Override
    public String toString() {
        return String.format("Start: (%.2f, %.2f), End: (%.2f, %.2f)", x1, y1, x2, y2);
    }
}