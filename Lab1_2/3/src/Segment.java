class Segment {
    private final double x1, y1, x2, y2;

    public Segment(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public double length() {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public double calculateAngle() {
        // Обчислення кута між відрізками, використовуючи косинус кута
        double dotProduct = (x1 * x2 + y1 * y2);
        double magnitudeA = Math.sqrt(x1 * x1 + y1 * y1);
        double magnitudeB = Math.sqrt(x2 * x2 + y2 * y2);
        double cosTheta = dotProduct / (magnitudeA * magnitudeB);
        return Math.acos(cosTheta) * (180 / Math.PI); // Повертаємо кут у градусах
    }

    @Override
    public String toString() {
        return String.format("Start: (%.2f, %.2f), End: (%.2f, %.2f)", x1, y1, x2, y2);
    }
}
