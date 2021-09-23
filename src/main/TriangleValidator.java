package main;
public class TriangleValidator implements Validator<Triangle> {
    public boolean validate(Triangle triangle) {
        boolean valid = true;

        valid &= validatePositiveSides(triangle);
        valid &= validateShape(triangle);

        return valid;
    }

    private boolean validatePositiveSides(Triangle triangle) {
        return triangle.sideA > 0 && triangle.sideB > 0 && triangle.sideC > 0;
    }

    private boolean validateShape(Triangle triangle) {
        return
            triangle.sideA < triangle.sideB + triangle.sideC &&
            triangle.sideB < triangle.sideA + triangle.sideC &&
            triangle.sideC < triangle.sideA + triangle.sideB;
    }
}