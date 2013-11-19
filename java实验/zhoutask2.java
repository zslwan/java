import java.util.Scanner;


public class zhoutask2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.println("enter a number:");
		int number;
		int c=0,d=0,y=0,x=0;double b;
		   while(d<=9)
		   {
			   d++;
			   number=scan.nextInt();
			   c=c+number;	
			   if
			       (number>x)
				   x=number;
			   else
				  y=number;
		   }
		   b=(double)c/10;
		   
		   System.out.println("average:"+b);
		   System.out.println("biggest:"+x);
		   System.out.println("smallest:"+y);

	}

}
