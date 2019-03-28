import java.util.Scanner;

public class StarPrinter {
	StarPrinter() {//constructor with no params. Prompts user for print type and number of lines
		int type = getType();
		int lines = getLines();
		new StarPrinter(type, lines);
	}
	
	StarPrinter(int lines) {//constructor with the number of lines. prompts user for desired number of lines
		int type = getType();
		new StarPrinter(type, lines);
	}
	
	StarPrinter(int type, int lines) {//constructor that takes both type and number of lines. Does not prompt for input.
		printStars(type, lines);
	}
	
	private void printStars(int type, int lines) {
		switch (type) {
			case 1:
				for(int i = 0; i < lines; i++) {
					for(int j = 0; j < i+1; j++) { System.out.print("*"); }
					System.out.println();
				}
				break;
			case 2:
				for(int i = 0; i < lines; i++) {
					for(int j = lines; j-i > 0; j--) { System.out.print("*"); }
					System.out.println();
				}
				break;
			case 3:
				for(int i = 0; i < lines; i++) {
					for(int j = i; j < lines ; j++) { System.out.print(" "); }
					for(int j = 0; j < 2*i+1; j++) { System.out.print("*"); }
					System.out.println();
				}
				break;
			case 4:
				for(int i = 0; i < lines; i++) {
					for(int j = lines-i; j < lines; j++) { System.out.print(" "); }
					for(int j = 2*(lines-i)-1; j > 0; j--) { System.out.print("*"); }
					System.out.println();
				}
				break;
			default: System.out.println("ERROR: INPUT DOES NOT EXIST");
			
			break;
		}
	}
	
	private int getType() { //prompts user for a valid number to determine the way in which the stars are printed
		Scanner scan = new Scanner(System.in);
		System.out.println("How would you like the stars printed? (Enter a number between 1-4.)");
		int input = scan.nextInt();
		while(input < 1 || input > 4) {
			System.out.println("ERROR: number is out of range. Please enter a number between 1-4!");
			input = scan.nextInt();
		}
		scan.close();
		return input;
	}
	
	private int getLines() {//prompts user for valid number to determine the number of lines printed.
		Scanner scan = new Scanner(System.in);
		System.out.println("How many lines would you like to print?");
		int input = scan.nextInt();
		while(input < 1 || input > 25) {
			System.out.println("ERROR: number is out of range. Please enter a number between 1-25!");
			input = scan.nextInt();
		}
		scan.close();
		return input;
	}
	
	public static void main(String[] args) {
		
		//StarPrinter sprint = new StarPrinter();
	}
}
