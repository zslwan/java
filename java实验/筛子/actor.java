import java.util.Scanner;
public class actor {
	public static void actor()
	{
	Scanner scan=new Scanner(System.in);
	System.out.println("enter 6 number:");
	int goal=0;
	for(int m=0;m<6;m++)
	{
    	int a=(int)(Math.random()*6);
    	
	
    
         for(int i=0;i<6;)
       {
    	
    	   int n=scan.nextInt();
    	   if(n==a)
    	   {
    		goal++;
    	   }
    	   i++;
       }
 System.out.println("the end score is:"+goal);
 return;

	}
	}
}
