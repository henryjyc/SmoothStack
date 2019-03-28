import java.util.Random;

public class GetPosition {
	int[][] nums;
	int x,y;
	public GetPosition(int width, int length) {
		nums = new int[width][length];
	}
	
	public void findLargest() {
		int temp = nums[0][0];
		x = 0;
		y = 0;
		for(int i = 0; i < nums.length; i++) {
			for(int j = 0; j < nums[i].length; j++) {
				if(nums[i][j] > temp) {
					temp = nums[i][j];
					x = i;
					y = j;
					System.out.println("Found new max, " + temp);
				}
			}
		}
	}
	
	public void printResults() {
		System.out.println("The current array is ...");
		for(int i = 0; i < nums.length; i++) {
			for(int j = 0; j < nums[i].length; j++) {
				System.out.print(nums[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("The largest number is " + nums[x][y] + " at (" + (y+1) + ", " + (x+1) + ").");
	}
	
	public void fillArr() {
		Random rand = new Random();
		for(int i = 0; i < nums.length; i++) {
			for(int j = 0; j < nums[i].length; j++)
				nums[i][j] = rand.nextInt(100);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GetPosition gps = new GetPosition(10,10);
		gps.fillArr();
		gps.findLargest();
		gps.printResults();
	}

}
