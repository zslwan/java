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
		
		int m=scan.nextInt();//������0��ʾ�˳�������1��ʾ����
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
	
