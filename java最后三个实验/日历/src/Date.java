import java.util.*;
public class Date 
{
	 /**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main (String[] args){
		 Scanner scan = new Scanner(System.in);
		 System.out.println("Please enter the number of year");
		 int year = scan.nextInt();
		 Year y = new Year(year);
		 y.judge();
		 y.cal();
	 }
}
