package org.bala.functional.xface;

public interface Shape {
	
	void draw();
	
	double area();
	
	default double volume(double length) {
		return length * area();
	}

}
