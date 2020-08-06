package Shapes;

public class Rectangle extends Shape {
	double length, breadth;
	
	public Rectangle() {
		// TODO Auto-generated constructor stub
		ShapeType = "Rectangle";
	}
	@Override
	public void GetInput() {
		// TODO Auto-generated method stub
		GetShapeID();
		ps.println("Enter Length: ");
		length = in.nextDouble();
		ps.println("Enter Width: ");
		breadth = in.nextDouble();
		CalculateArea();
	}

	@Override
	public void CalculateArea() {
		// TODO Auto-generated method stub
		SurfaceArea = length * breadth;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String out = String.format("%-10s   %-10s   %10.2f   Length: %-10.2f   Breadth: %-10.2f", ShapeType,ShapeID,SurfaceArea,length,breadth);
		return out;
	}

	@Override
	public String toCSvString() {
		// TODO Auto-generated method stub
		String out = String.format("%s,  %s,  %f,  %f,  %f", ShapeType,ShapeID,SurfaceArea,length,breadth);
		return out;
	}
	
	public void deserialize(String buff){
		super.deserialize(buff);
		String tokens[] = buff.split(",");
		length = Double.parseDouble(tokens[3]);
		breadth = Double.parseDouble(tokens[4]);
		tokens = null;
	}

}
