package tech.thorley.cleancode;

public class Circle implements Shape{
	private double radius = 0.0;
	
	public Circle(double radius) {
		this.radius = radius;
	}
	
	public double area() {
		double area = Math.PI * this.radius * this.radius;
		return area;
	}
	
	public double getRadius() {
		return this.radius;
	}
	
	public void setRadius (double radius) {
		this.radius = radius;
	}
	
}
