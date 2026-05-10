package tech.thorley.cleancode;

public class Rectangle implements Shape{

	private double width = 0.0;
	private double height = 0.0;

	public Rectangle () {}
	
	public Rectangle (double width, double height) {
		this.width = width;
		this.height = height;
	}
	
	public double area() {
		double area = height * width;
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
