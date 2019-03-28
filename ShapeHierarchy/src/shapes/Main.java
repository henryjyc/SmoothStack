package shapes;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Shape shape;
		Rectangle rect = new Rectangle();
		Triangle tri = new Triangle();
		Circle cir = new Circle();
		
		System.out.println("Running Rectangle functions...");
		rect.calculateArea();
		rect.display();
		
		System.out.println("Running Triangle functions...");
		tri.calculateArea();
		tri.display();
		
		System.out.println("Running Circle functions...");
		cir.calculateArea();
		cir.display();
		
		System.out.println("Running Rectangle from a shape object");
		shape = new Rectangle();
		shape.calculateArea();
		shape.display();
	}

}
