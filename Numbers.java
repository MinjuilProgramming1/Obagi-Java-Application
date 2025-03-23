import java.util.Scanner;

public class Numbers{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.println("1 2 3 4 %n");
	 
        System.out.printf(" 1 2 3 4 %n");	 
		System.out.printf(" 1 2 3 4 %n");	 
		System.out.printf("1 2 3 4 %n");	 
		System.out.printf("1 2 3 4 %n");	 
		
		System.out.print("Enter first number: ");
		int num1 = input.nextInt();
		System.out.print("Enter second number: ");
		int num2 = input.nextInt();
	    int sum = num1 + num2;
		System.out.printf("The sum is %d%n",sum);
		
		System.out.print("Enter first number: ");
		int num3 = input.nextInt();
		System.out.print("Enter second number: ");
		int num4 = input.nextInt();
		int product = num3 * num4;
		System.out.printf("The product is %d%n",product);
		
		System.out.print("Enter first number: ");
		int num5 = input.nextInt();
		System.out.print("Enter second number: ");
		int num6 = input.nextInt();
		int difference = num5 - num6;
		System.out.printf("The difference is %d%n",difference);
		
		System.out.print("Enter first number: ");
		int num7 = input.nextInt();
		System.out.print("Enter second number: ");
		int num8 = input.nextInt();
		int quotient = num7 / num8;	
		System.out.printf("The quotient is %d%n",quotient);
		
		
		System.out.print("Enter a number: ");
		int num9 = input.nextInt();
		System.out.print("Enter a number: ");
		int num10 = input.nextInt();
		if (num9 > num10){
			System.out.printf("%d is larger",num9);
		}
		else if (num10 > num9){
			System.out.printf("%d is larger",num10);
		}
		else{
			System.out.print("These numbers are equal");
		}
        
        
		
		
	}
}