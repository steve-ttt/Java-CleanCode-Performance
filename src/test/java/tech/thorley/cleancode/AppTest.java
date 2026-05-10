package tech.thorley.cleancode;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class AppTest {

    @Test
    public void oopCircle() {
        Circle c = new Circle(5.0);
        assertEquals(Double.valueOf(5.0), c.getRadius());
        c.setRadius(-25.56);
        assertEquals(Double.valueOf(-25.56), c.getRadius());
        
        Double gotArea = c.area();
        Double wantArea = Math.PI * -25.56 * -25.56;
        Double diff = Math.abs(gotArea - wantArea);
        assertTrue(diff < 0.01);
                
    }
    
    @Test 
    public void oopRectangle() {
    	Rectangle r = new Rectangle();
    	r.setWidth(4.0);
    	r.setHeight(5.5);
    	assertEquals(Double.valueOf(4.0), r.getWidth());
    	assertEquals(Double.valueOf(5.5), r.getHeight());
    	Rectangle r1 = new Rectangle(23.4, 45.6);
    	Double wantArea = 23.4 * 45.6;
    	Double gotArea  = r1.area();
    	assertEquals(wantArea, gotArea);
    	
    }
    
    @Test 
    public void oopTriangle() {
    	Triangle t = new Triangle(23.4, 45.6);
    	assertEquals(Double.valueOf(23.4), t.getWidth());
    	assertEquals(Double.valueOf(45.6), t.getHeight());
    	
    	Double wantArea = 0.5 * 23.4 * 45.6;
    	Double gotArea  = t.area();
    	assertEquals(wantArea, gotArea);
    	
    }
    
    @Test
    public void dataDrivenShapeTest() {        
        DataDrivenShapes c1 = new DataDrivenShapes(DataDrivenShapes.CIRCLE, -25.56, -25.56);
        double gotAreaCircle = (c1.width * c1.height * DataDrivenShapes.LOOK_UP_TABLE[c1.type]);
        double wantAreaCircle = Math.PI * -25.56 * -25.56;
        assertEquals(wantAreaCircle, gotAreaCircle, 0.0001);

        DataDrivenShapes r1 = new DataDrivenShapes(DataDrivenShapes.RECTANGLE, 2.3, 2.3);        
        double gotAreaRect = (r1.width * r1.height * DataDrivenShapes.LOOK_UP_TABLE[r1.type]);
        double wantAreaRect = 2.3 * 2.3 * 1.0;
        assertEquals(wantAreaRect, gotAreaRect, 0.0001);

        DataDrivenShapes t1 = new DataDrivenShapes(DataDrivenShapes.TRIANGLE, 69.69, 42.42);
        double gotAreaTriangle = (t1.width * t1.height * DataDrivenShapes.LOOK_UP_TABLE[t1.type]);
        double wantAreaTriangle = 42.42 * 69.69 * 0.5;      
        assertEquals(wantAreaTriangle, gotAreaTriangle, 0.0001);
    }
    
}
