package Shapes;

public class Square extends Shape {
	double Side;
	
	public Square(){
		ShapeType = "Square";
	}
	
	@Override
	public void GetInput() {
		// TODO Auto-generated method stub
		GetShapeID();
		ps.println("Enter a side length: ");
		Side = in.nextDouble();
		CalculateArea();
	}

	@Override
	public void CalculateArea() {
		// TODO Auto-generated method stub
		SurfaceArea = Side * Side;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String out = String.format("%-10s   %-10s   %10.2f   Side Length: %-10.2f", ShapeType,ShapeID,SurfaceArea,Side);
		return out;
	}

	@Override
	public String toCSvString() {
		// TODO Auto-generated method stub
		String out = String.format("%s,  %s,  %f,  %f", ShapeType,ShapeID,SurfaceArea,Side);
		return out;
	}
	
	public void deserialize(String buff){
		super.deserialize(buff);
		String tokens [] = buff.split(",");
		Side = Double.parseDouble(tokens[3]);
		tokens = null;
	}

}
