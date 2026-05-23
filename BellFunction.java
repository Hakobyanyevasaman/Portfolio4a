public class BellFunction implements MembershipFunction {
    // centre, half-width, and slope/shape parameter
    private double center;
    private double width;
    private double slope;

    public BellFunction(double center, double width, double slope) {
        if (width <= 0 || slope <= 0) {
            throw new IllegalArgumentException(
                "Parameters not valid: width and slope must be > 0");
        }
        this.center = center;
        this.width = width;
        this.slope = slope;
    }

    @Override
    public double getMembershipDegree(double x) {
        // mu(x) = 1 / (1 + |((x - c) / a)^(2b)|)
        double ratio = (x - center) / width;
        double power = Math.pow(Math.abs(ratio), 2.0 * slope);
        double membership = 1.0 / (1.0 + power);

        // keeping the result in [0, 1]
        return Math.max(0.0, Math.min(1.0, membership));
    }
}
