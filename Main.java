import java.util.Scanner;
 
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
 
        System.out.println("Fuzzy Membership Function Evaluator");
        System.out.print("Enter variable name: ");
        String variableName = scanner.nextLine();
 
        System.out.println("Select membership function type:");
        System.out.println("  1 - Triangular");
        System.out.println("  2 - Trapezoidal");
        System.out.println("  3 - Gaussian");
        System.out.println("  4 - Bell");
        System.out.println("  5 - Sigmoid");
        System.out.print("Enter choice (1-5): ");
        int choice = Integer.parseInt(scanner.nextLine().trim());
 
        MembershipFunction function = null;
 
        try {
            switch (choice) {
                case 1:
                    System.out.print("Enter a (start), b (peak), c (end): ");
                    double[] tri = parseParams(scanner.nextLine(), 3);
                    function = new TriangularFunction(tri[0], tri[1], tri[2]);
                    break;
 
                case 2:
                    System.out.print("Enter a (start), b (first peak), c (second peak), d (end): ");
                    double[] trap = parseParams(scanner.nextLine(), 4);
                    function = new TrapezoidalFunction(trap[0], trap[1], trap[2], trap[3]);
                    break;
 
                case 3:
                    System.out.print("Enter center, sigma (standard deviation): ");
                    double[] gauss = parseParams(scanner.nextLine(), 2);
                    function = new GaussianFunction(gauss[0], gauss[1]);
                    break;
 
                case 4:
                    System.out.print("Enter center, width, slope: ");
                    double[] bell = parseParams(scanner.nextLine(), 3);
                    function = new BellFunction(bell[0], bell[1], bell[2]);
                    break;
 
                case 5:
                    System.out.print("Enter center (inflection point), slope (positive=rising, negative=falling): ");
                    double[] sig = parseParams(scanner.nextLine(), 2);
                    function = new SigmoidFunction(sig[0], sig[1]);
                    break;
 
                default:
                    System.out.println("Invalid choice.");
                    return;
            }
 
            System.out.print("Enter crisp input value: ");
            double x = Double.parseDouble(scanner.nextLine().trim());
 
            double degree = function.getMembershipDegree(x);
            System.out.printf("Membership degree of '%s' at x=%.4f: %.6f%n",
                variableName, x, degree);
 
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
 
        scanner.close();
    }
 
    // parses a space or comma separated line into an array of doubles
    private static double[] parseParams(String line, int expected) {
        String[] parts = line.trim().split("[,\\s]+");
        if (parts.length != expected) {
            throw new IllegalArgumentException(
                "Expected " + expected + " parameters, got " + parts.length);
        }
        double[] values = new double[expected];
        for (int i = 0; i < expected; i++) {
            values[i] = Double.parseDouble(parts[i].trim());
        }
        return values;
    }
}