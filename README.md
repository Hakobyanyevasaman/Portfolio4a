# Portfolio4a

CCS2600 Portfolio 4.2 — fuzzy membership functions (Java).

| File | Member | Function |
|------|--------|----------|
| `MembershipFunction.java` | Team | Interface |
| `TriangularFunction.java` | 1 | Triangular |
| `TrapezoidalFunction.java` | 1 | Trapezoidal |
| `GaussianFunction.java` | 2 | Gaussian |
| `BellFunction.java` | 2 | Bell shape |

Compile:

```bash
javac *.java
```

Example (Member 2):

```java
MembershipFunction gaussian = new GaussianFunction(5.0, 1.5);
System.out.println(gaussian.getMembershipDegree(5.0)); // 1.0

MembershipFunction bell = new BellFunction(5.0, 2.0, 2.0);
System.out.println(bell.getMembershipDegree(8.0)); // ~0.0588
```