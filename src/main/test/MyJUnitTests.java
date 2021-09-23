package main.test;

import main.Triangle;
import main.TriangleException;
import main.TriangleService;
import main.ShapeService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Before;
import org.junit.Test;

public class MyJUnitTests {
    Triangle triangleEquilateral;
    Triangle triangleIsosceles;
    Triangle triangleScalene;
    ShapeService<Triangle> testTriangleService;

    @Before
    public void setUp() {
        testTriangleService = new TriangleService();
    }

    @Test
    public void testEquilateral() {
        triangleEquilateral = new Triangle(6, 6, 6);
        assertEquals("3 sides of equal length should be equilateral", testTriangleService.getType(triangleEquilateral), "equilateral");
    }

    @Test
    public void testIsosceles1() {
        triangleIsosceles = new Triangle(6, 6, 4);
        assertEquals("2 sides of equal length should be isosceles", testTriangleService.getType(triangleIsosceles), "isosceles");
    }
    
    @Test
    public void testIsosceles2() {
        triangleIsosceles = new Triangle(4, 6, 4);
        assertEquals("2 sides of equal length should be isosceles", testTriangleService.getType(triangleIsosceles), "isosceles");
    }
    
    @Test
    public void testIsosceles3() {
        triangleIsosceles = new Triangle(6, 4, 4);
        assertEquals("2 sides of equal length should be isosceles", testTriangleService.getType(triangleIsosceles), "isosceles");
    }

    @Test
    public void testScalene() {
        triangleScalene = new Triangle(7, 6, 4);
        assertEquals("no sides of equal length should be scalene", testTriangleService.getType(triangleScalene), "scalene");
    }

    @Test
    public void testValidatorNoNegativeLengthsAllowed1() {
        int[] triangleSides = new int[]{-1, 2, 3};
        assertThrows(TriangleException.class,() -> { testTriangleService.create(triangleSides); } );
    }

    @Test
    public void testValidatorNoNegativeLengthsAllowed2() {
        int[] triangleSides = new int[]{1, -2, 3};
        assertThrows(TriangleException.class,() -> { testTriangleService.create(triangleSides); } );
    }

    @Test
    public void testValidatorNoNegativeLengthsAllowed3() {
        int[] triangleSides = new int[]{1, 2, -3};
        assertThrows(TriangleException.class,() -> { testTriangleService.create(triangleSides); } );
    }
    
    @Test
    public void testValidatorNoOneSideLongerThanTheOtherTwoCombined1() {
        int[] triangleSides = new int[]{6, 2, 3};
        assertThrows(TriangleException.class,() -> { testTriangleService.create(triangleSides); } );
    }
    
    @Test
    public void testValidatorNoOneSideLongerThanTheOtherTwoCombined2() {
        int[] triangleSides = new int[]{4, 8, 3};
        assertThrows(TriangleException.class,() -> { testTriangleService.create(triangleSides); } );
    }
    
    @Test
    public void testValidatorNoOneSideLongerThanTheOtherTwoCombined3() {
        int[] triangleSides = new int[]{6, 2, 9};
        assertThrows(TriangleException.class,() -> { testTriangleService.create(triangleSides); } );
    }
}