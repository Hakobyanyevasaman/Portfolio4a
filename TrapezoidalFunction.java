public class TrapezoidalFunction implements MembershipFunction {
    //Start point, First peak point, Second peak point, End point
    private double a;  
    private double b;  
    private double c; 
    private double d; 

    public TrapezoidalFunction(double a, double b, double c, double d) {
        // ensuring that the parameters are in the correct order
        if (!(a <= b && b <= c && c <= d)) {
            throw new IllegalArgumentException("Parameters not valid: should be a <= b <= c <= d");
        }
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    @Override
    public double getMembershipDegree(double x) {
        //if the crisp calue is either a or d or outiside of the range, the membership is 0.
        if (x <= a || x >= d) {
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
        // If d and c are the same number, we can't divide by d - c because that's zero.
        if (d == c) {
            rightSlope = 1.0;
        } else {
            rightSlope = (d - x) / (d - c);
        }
        
        // The trapezoid has a flat top capped at 1.0
        double tempMin = Math.min(leftSlope, 1.0);
        double finalMin = Math.min(tempMin, rightSlope);
        
        // ensuring the final value does not drop below 0
        return Math.max(finalMin, 0.0);
    }
}