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

    @Override
    public String toString() {
        return String.format("Start: (%.2f, %.2f), End: (%.2f, %.2f)", x1, y1, x2, y2);
    }
}