package Shapes;

import java.io.PrintStream;
import java.util.Scanner;

import Shapes.ShapesManager.ShapeTypes;

public class Menu {
	PrintStream ps = System.out;
	Scanner in = new Scanner(System.in);
	ShapesManager sm = new ShapesManager();
	
	private void DisplayHeader()
	{
		ps.println("SHAPES MANAGER PROJECT");
	}
	
	public void DisplayMainMenu(){
		
		int sel =0;
		while (sel != 9)
		{
			DisplayHeader();
			ps.println();
			ps.println("Main Menu");
			ps.println();
			ps.println("1. Add Shape");
			ps.println("2. Delete Shape");
			ps.println("3. List Shapes");
			ps.println("9. Exit");
			ps.println("Enter Your Choice : ");
			
			sel = in.nextInt();
			
			switch (sel)
			{
				case 1 :
					DisplayShapesMenu();
					break;
				case 2 :
					sm.deleteShape();
					break;
				case 3 :
					sm.ListShapes();
					break;
				case 9 : 
					break;
				default :
					ps.println("Invalid selection. Try again...\n");
					break;
			}
		}
	}

	private void DisplayShapesMenu(){
		
		int sel = 0;
		
		while (sel != 9)
		{
			ps.println("\nShapes Menu");
			ps.println();
			ps.println("1. Square");
			ps.println("2. Rectangle");
			ps.println("3. Cube");
			ps.println("4. Circle");
			ps.println("9. Exit");
			ps.println("Enter your choice: ");
			
			sel = in.nextInt();
			switch(sel)
			{
				case 1:
					sm.AddShape(ShapeTypes.Square);
					break;
				case 2:
					sm.AddShape(ShapeTypes.Rectangle);
					break;
				case 3:
					sm.AddShape(ShapeTypes.Cube);
					break;
				case 4:
					sm.AddShape(ShapeTypes.Circle);
					break;
				case 9:
					break;
				default :
					ps.println("Invalid selection. Try again...\n");
					break;
			}
		}
		
	}
	
}
