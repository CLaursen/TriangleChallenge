package main;
public class TriangleService implements ShapeService<Triangle> {
    
    private final Validator<Triangle> Validator;

    public TriangleService() {
        Validator = new TriangleValidator();
    }

    public Triangle create(int[] sides) throws TriangleException {
        Triangle triangle = new Triangle(sides[0], sides[1], sides[2]);
        if (Validator.validate(triangle)) {
            return triangle;
        }

        throw new TriangleException("Triangle is not valid");
    }
    
    private boolean isEquilateral(int a, int b, int c) {
        return a == b && a == c;
    }

    private boolean isIsosceles(int a, int b, int c) {
        return a == b || a == c || b == c;
    }

    public String getType(Triangle shape) {
        if (isEquilateral(shape.sideA, shape.sideB, shape.sideC)) {
        return TriangleType.equilateral.toString();
        }
        
        if (isIsosceles(shape.sideA, shape.sideB, shape.sideC)) {
            return TriangleType.isosceles.toString();
        }

        return TriangleType.scalene.toString();
    }
}