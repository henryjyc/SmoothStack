import java.util.*;
public class Adder {

	private static double sum(ArrayList<Double> nums) {
		double sum = 0;
		for(int i = 0; i < nums.size(); i++)
			sum += nums.get(i);
		return sum;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Double> nums = new ArrayList<Double>();
		boolean allnums = true;
		for(int i = 0; i < args.length && allnums; i++) {
			try {
				Double num = Double.parseDouble(args[i]);
				nums.add(num);
			} catch (NumberFormatException e) {
				allnums = false;
			}
		}
		//System.out.println("Done with for");
		if(!allnums)
			System.out.println("ERROR: One of the inputs is not a number!");
		else {
			
			System.out.println("The sum of the input(s) is " + sum(nums));
		}
	}

}
