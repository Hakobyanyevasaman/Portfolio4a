public class SigmoidFunction implements MembershipFunction {
    // c = inflection point (where membership = 0.5)
    // a = slope parameter (positive = rising, negative = falling)
    private double center;
    private double slope;
 
    public SigmoidFunction(double center, double slope) {
        if (slope == 0) {
            throw new IllegalArgumentException(
                "Parameters not valid: slope must not be 0");
        }
        this.center = center;
        this.slope = slope;
    }
 
    @Override
    public double getMembershipDegree(double x) {
        // mu(x) = 1 / (1 + e^(-a * (x - c)))
        double membership = 1.0 / (1.0 + Math.exp(-slope * (x - center)));
 
        // keeping the result in [0, 1]
        return Math.max(0.0, Math.min(1.0, membership));
    }
}
 
