import java.util.Scanner;


public class AssigningValues{
	public static void main (String[] args){
	    Scanner input = new Scanner(System.in);
		System.out.print("Enter your first number: ");
		int x = input.nextInt();
		System.out.print("Enter second number: ");
		int y = input.nextInt();
	    System.out.print("Enter third number: ");
		int z = input.nextInt();
		
		int product = (x * y * z);
		System.out.printf("Product is %d",product);
		

		
		
	}
}