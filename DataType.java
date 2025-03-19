public class DataType{
	public static void main(String[] args){
		//Integer type(byte,short,int,long)
		
		byte age = 50;
		System.out.printf("Your age is %d%n",age);
		
		short quantity = 32000;
		System.out.printf("I bought %d quantity of bags for my business%n",quantity);
		
		int population = 100000000;
		System.out.printf("The total population in Nigeria is %d%n",population);
		
		long worldPopulation = 99900000000000000L;
		System.out.printf("The world's population is %d%n",worldPopulation);
		
		//float point type(float,double)
		
		float myBalance = 12345.858575F;
		System.out.printf("Your account balance is %f%n",myBalance);
		
		double cbnReserve = 56789.213212313242;
		System.out.printf("The CBN balance is %5f%n",cbnReserve);
		
		//Boolean TYpe (boolean)
		boolean isJavaFun = true;
		System.out.printf("Is Java a fun Language? %b%n",isJavaFun);
		
		//Character type (char)
		char alpha = '@';
		System.out.printf("My email is danielalabraba%cgmail.com",alpha);
	}
}