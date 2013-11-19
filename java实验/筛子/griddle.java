import java.util.Scanner;


public class griddle {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
	
		actor.actor();
		System.out.println("dou you want to try again");
		
		int m=scan.nextInt();//请输入0表示退出，输入1表示继续
		if(m==1)
		{
			actor.actor();
		}
		else if(m==0)
		{
			System.out.println("thanks");
		}
 
	}
	   		

	
		

}
	
