public interface MembershipFunction{
    //crisp input is passes
    //it's the exact vakue measured, the specific data point we wanna evaluate.
    double getMembershipDegree(double x);
}