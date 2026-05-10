package tech.thorley.cleancode;

import java.util.Random;


public class App {
    public static void main(String[] args) {
        
        
        int size = 1_000_000;
        Shape[] shapes = new Shape[size];
        DataDrivenShapes[] dataDrivenShapes = new DataDrivenShapes[size];
        
        Random rand = new Random(42);
        for (int i = 0; i < size; i++) {
            int pick = rand.nextInt(3);
            double val1 = rand.nextDouble();
            double val2 = rand.nextDouble(); // Always pull two values to keep the psudo random tracking the same from the seed

            // OOP Array
            if (pick == 0) shapes[i] = new Circle(val1);
            else if (pick == 1) shapes[i] = new Rectangle(val1, val2);
            else shapes[i] = new Triangle(val1, val2);
        }

        rand = new Random(42); // Re-seed
        for (int i = 0; i < size; i++) {
            int pick = rand.nextInt(3);
            double val1 = rand.nextDouble();
            double val2 = rand.nextDouble();

            // Data-Driven Array
            dataDrivenShapes[i] = new DataDrivenShapes(pick, val1, val2);
        }
        
        // Warm up the JIT
        for (int i = 0; i < 100; i++) {
            runBenchmark(shapes); 
            runDataDrivenBenchmark(dataDrivenShapes);
        }

        // Actual Timing
        long start = System.nanoTime();
        double result = runBenchmark(shapes);
        long end = System.nanoTime();
        System.out.println("Shape test Clean Code style");
        System.out.println("Time: " + (end - start) + "ns. Result: " + result);
        System.out.println("-------------------------------------------");

        // Actual Timing
        long ddStart = System.nanoTime();
        double ddResult = runDataDrivenBenchmark(dataDrivenShapes);
        long ddEnd = System.nanoTime();
        System.out.println("Shape test Data Driven style");
        System.out.println("Time: " + (ddEnd - ddStart) + "ns. Result: " + ddResult);
        System.out.println("-------------------------------------------");
        System.out.printf("Difference is %.2f %% faster\n", (float)(end - start) / (ddEnd - ddStart) * 100 );
    }
    
    public static double runBenchmark(Shape[] shapes) {
        double accumulator = 0.0;
        for (int i = 0; i < shapes.length; i++) {
            accumulator += shapes[i].area();
        }
        
        return accumulator;
    }
    
    public static double runDataDrivenBenchmark(DataDrivenShapes[] shapes) {
        double accumulator = 0.0;
        double[] table = DataDrivenShapes.LOOK_UP_TABLE;

        for (int i = 0; i < shapes.length; i++) {
        	DataDrivenShapes s = shapes[i];
            accumulator += (s.width * s.height * table[s.type]);
        }
        
        return accumulator;
    }
}
