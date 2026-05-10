package tech.thorley.cleancode;

public class DataDrivenShapes {

	public static final int CIRCLE = 0;
	public static final int RECTANGLE = 1;
	public static final int TRIANGLE = 2;
	
	public static final double[] LOOK_UP_TABLE = {
			Math.PI,
			1.0,
			0.5
	};
	
	public int type;
    public double width;
    public double height;
    
	public DataDrivenShapes(int type, double height, double width ) {
		this.type = type;
		this.height = height;
		this.width = width;
				
	}
}
