package Shapes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ShapesManager {
	ArrayList<Shape> shapes = new ArrayList<Shape>();
	
	public enum ShapeTypes {Square,Rectangle,Cube,Circle};
	
	String shapesFileName = "D:\\Java\\JavaTraining\\ShapesManager\\src\\Shapes\\Shapes.txt";
	
	public boolean AddShape(ShapeTypes shapetype)
	{
		Shape s = null;
		switch (shapetype)
		{
			case Square:
				s = new Square();
				break;
			case Rectangle:
				s = new Rectangle();
				break;
			case Cube:
				s = new Cube();
				break;
			case Circle:
				s = new Circle();
				break;
		}
		
		s.GetInput();
		shapes.add(s);
		AddShape2File(s);
		s = null;
		return true;
	}

	public void AddShape2File(Shape s)
	{
		FileWriter f = null;
		try{
			f = new FileWriter(shapesFileName,true);
			BufferedWriter bw = new BufferedWriter(f);
			bw.write(s.toCSvString());
			bw.newLine();
			bw.close();
			f.close();
		} catch (Exception e){
			e.printStackTrace();
		}finally {
			f = null;
		}
	}
	
	public void ListShapes()
	{
		System.out.println("List of Shapes...");
		for(Shape s:shapes)
		{
			System.out.println(s.toString());
		}
	}
	
	public ShapesManager(){
		boolean filefound = new File(shapesFileName).isFile();
		if (filefound)
		{
			FileReader f = null;
			try{
				f = new FileReader(shapesFileName);
				BufferedReader br  = new BufferedReader(f);
				String buff;
				while ((buff = br.readLine()) != null)
				{
					String tokens[] = buff.split(",");
					Shape s = null;
					switch (tokens[0])
					{
						case "Square":
							s = new Square();
							break;
						case "Rectangle":
							s = new Rectangle();
							break;
						case "Cube":
							s = new Cube();
							break;
						case "Circle":
							s = new Circle();
							break;
					}
					
					s.deserialize(buff);
					shapes.add(s);
				}
				br.close();
				f.close();
				
				}catch(Exception e){
					e.printStackTrace();
				}finally 
				{
					f = null;
				}
		}	
}

	
	public Shape getShape(String shapeId)
	{
		Shape res = null;
		for (Shape s : shapes)
		{
			String sid = s.ShapeID.trim();
			if(sid.equals(shapeId))
			{
				res = s;
				break;
			}
		}
		return res;
	}
	
	public void deleteShape()
	{
		System.out.println("Enter ShapeID: ");
		Scanner in = new Scanner(System.in);
		String shapeId = in.next();
		Shape s = getShape(shapeId);
		if (s == null)
		{
			System.out.println("Invalid Shape Id.");
			return;
		}
		
		System.out.println(s.toString());
		System.out.println("Are you sure to delete? (Y/N)");
		String opt = in.next();
		if (opt.toUpperCase().equals("Y"))
		{
			shapes.remove(s);
			
			FileWriter f = null;
			try{
				f = new FileWriter(shapesFileName);
				BufferedWriter bw = new  BufferedWriter(f);
				for(Shape s2: shapes)
				{
					bw.write(s2.toCSvString());
					bw.newLine();
				}
					bw.close();
					f.close();	
				}catch(Exception e){
					e.printStackTrace();
				}finally{
					f = null;
				}
		}
		return;
	}
	
}
