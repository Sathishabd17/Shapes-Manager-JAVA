package Shapes;

public class Circle extends Shape {
	double Radius;
	
	public Circle() {
		// TODO Auto-generated constructor stub
		ShapeType = "Circle";
	}
	
	@Override
	public void GetInput() {
		// TODO Auto-generated method stub
		GetShapeID();
		ps.println("Enter Radius: ");
		Radius = in.nextDouble();
		CalculateArea();
	}

	@Override
	public void CalculateArea() {
		// TODO Auto-generated method stub
		SurfaceArea = (22.0/7) * Radius * Radius;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String out = String.format("%-10s   %-10s   %10.2f   Radius: %-10.2f", ShapeType,ShapeID,SurfaceArea,Radius);
		return out;
	}

	@Override
	public String toCSvString() {
		// TODO Auto-generated method stub
		String out = String.format("%s,  %s,  %f,  %f", ShapeType,ShapeID,SurfaceArea,Radius);
		return out;
	}
	
	public void deserialize(String buff){
		super.deserialize(buff);
		String tokens[] = buff.split(",");
		Radius = Double.parseDouble(tokens[3]);
		tokens = null;
	}

}
