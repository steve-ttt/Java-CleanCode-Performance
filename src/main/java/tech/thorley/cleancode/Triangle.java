package tech.thorley.cleancode;

public class Triangle implements Shape{

	private double width = 0.0;
	private double height = 0.0;

	public Triangle () {}
	
	public Triangle (double width, double height) {
		this.width = width;
		this.height = height;
	}
	
	public double area() {
		double area = 0.5 * height * width;
		return area;
	}
	public void setWidth(double w) {
		this.width = w;
	}
	public void setHeight(double h) {
		this.height = h;
	}
	public double getWidth() {
		return this.width;
	}
	public double getHeight() {
		return this.height;
	}
}
