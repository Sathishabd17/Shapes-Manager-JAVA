package Shapes;

import java.io.PrintStream;
import java.util.Scanner;

public abstract class Shape {
	protected PrintStream ps = System.out;
	protected Scanner in = new Scanner (System.in);
	
	protected String ShapeType;
	protected String ShapeID;
	protected double SurfaceArea;
	
	abstract public void GetInput();
	abstract public void CalculateArea();
	abstract public String toString();
	abstract public String toCSvString();
	
	public void deserialize(String buff)
	{
		String tokens[] = buff.split(",");
		ShapeType = tokens[0];
		ShapeID = tokens[1];
		SurfaceArea = Double.parseDouble(tokens[2]);
		tokens = null;
	}
	
	public Shape(){
		ShapeID = "undefined";
	}
	
	public Shape(String ShapeType, String ShapeID){
		this.ShapeType = ShapeType;
		this.ShapeID = ShapeID;
	}
	
	protected void GetShapeID(){
		ps.println("Enter Shape ID: ");
		ShapeID = in.next();
	}
}
