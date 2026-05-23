public class GaussianFunction implements MembershipFunction {
    // centre (peak) and standard deviation
    private double center;
    private double sigma;

    public GaussianFunction(double center, double sigma) {
        if (sigma <= 0) {
            throw new IllegalArgumentException("Parameters not valid: sigma must be > 0");
        }
        this.center = center;
        this.sigma = sigma;
    }

    @Override
    public double getMembershipDegree(double x) {
        // mu(x) = exp(-((x - c)^2) / (2 * sigma^2))
        double diff = x - center;
        double exponent = -(diff * diff) / (2.0 * sigma * sigma);
        double membership = Math.exp(exponent);

        // keeping the result in [0, 1]
        return Math.max(0.0, Math.min(1.0, membership));
    }
}
