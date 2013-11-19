import java.util.Scanner;


public class zhouchar {

	 

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		String information;
		System.out.println("enter you information:");
		information=scan.nextLine();
		int count=0;
		int n=information.length();
		
		for(int i=0,i<n;i++)
		{
	    char m=information.charAt(i);
		 		
		if(m=='.'||m=='!'||m=='?')
		  {count++;
		  }
		}
								
		
		
		System.out.println("the sentence has:"+count);
		
		System.out.println("the length is :"+n);

	}

}
