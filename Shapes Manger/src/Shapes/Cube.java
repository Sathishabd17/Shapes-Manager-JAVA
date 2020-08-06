package Shapes;

public class Cube extends Shape {
	double length,breadth,height;
	
	public Cube() {
		// TODO Auto-generated constructor stub
		ShapeType = "Cube";
	}
	@Override
	public void GetInput() {
		// TODO Auto-generated method stub
		GetShapeID();
		ps.println("Enter Length: ");
		length = in.nextDouble();
		ps.println("Enter Breadth: ");
		breadth = in.nextDouble();
		ps.println("Enter Height: ");
		height = in.nextDouble();
		CalculateArea();
	}

	@Override
	public void CalculateArea() {
		// TODO Auto-generated method stub
		SurfaceArea = 2 * (length*breadth + breadth*height);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String out = String.format("%-10s   %-10s   %10.2f   Length: %-10.2f   Breadth: %-10.2f   Height: %-10.2f", ShapeType,ShapeID,SurfaceArea,length,breadth,height);
		return out;
	}

	@Override
	public String toCSvString() {
		// TODO Auto-generated method stub
		String out = String.format("%s,  %s,  %f,  %f,  %f,  %f", ShapeType,ShapeID,SurfaceArea,length,breadth,height);
		return out;
	}
	
	public void deserialize (String buff){
		super.deserialize(buff);
		String tokens[] = buff.split(",");
		length = Double.parseDouble(tokens[3]);
		breadth = Double.parseDouble(tokens[4]);
		height = Double.parseDouble(tokens[5]);
		tokens = null;
		
	}

}
