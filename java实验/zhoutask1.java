import java.util.*;


public class zhoutask1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int a,b,c;double d,x1 = 0,x2 = 0,x;
		System.out.println("enter a number:");
		   a=scan.nextInt();
		   b=scan.nextInt();
		   c=scan.nextInt();
		   d=Math.pow(b, 2)-4*a*c;
		 if (a==0)
		 {  x=-c/b;
		 System.out.println("answer:"+x);}
		 else
		     { if (d<0)
		 System.out.println("no answer");
			 else 
			     {  x1=(-b+Math.pow(d, 0.5))/(2*a);
		            x2=(-b-Math.pow(d,0.5))/(2*a);
			     
		           
		System.out.println("answer:x1="+x1);
		System.out.println("answer:x2="+x2);
		         }
		     }
	}

}
