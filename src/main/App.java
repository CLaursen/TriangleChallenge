package main;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Triangle myTriangle;
        ShapeService<Triangle> triangleService = new TriangleService();
        int[] sides = new int[3];
        Scanner inputScanner = new Scanner(System.in);

        for (int i = 0; i < sides.length; i++) {
            System.out.println("input the length as an integer of side: " + (i+1));
            sides[i] = inputScanner.nextInt();
        }

        inputScanner.close();

        try {
            myTriangle = triangleService.create(sides);
            System.out.println(triangleService.getType(myTriangle));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
