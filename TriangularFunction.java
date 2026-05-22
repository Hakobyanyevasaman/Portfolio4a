public class TriangularFunction implements MembershipFunction{
    // start point, peak point, end point
    private double a;
    private double b;
    private double c;

    public TriangularFunction(double a, double b, double c){
        if(!(a <= b && b <= c)) {
            throw new IllegalArgumentException ("Parameters not valid: should be a <= b and b <= c");
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override 
    public double getMembershipDegree(double x){
        //if the crisp calue is either a or c or outiside of the range, the membership is 0.
        if (x <= a || x >= c) {
            return 0.0;
        }
        double leftSlope;
        // If b and a are the same number, we can't divide by b - a because that's zero.
        if (b == a) {
            leftSlope = 1.0;
        } else {
            leftSlope = (x - a) / (b - a);
        }

        double rightSlope;
        // If c and b are the same number, we can't divide by c - b because that's zero.
        if (c == b) {
            rightSlope = 1.0;
        } else {
            rightSlope = (c - x) / (c - b);
        }

        // finding the minimum of the two slopes and ensuring it does not go below 0
        double minSlopes = Math.min(leftSlope, rightSlope);
        return Math.max(minSlopes, 0.0);
    }

}